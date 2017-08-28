package py.com.fuentepy.prontoshop.common;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import py.com.fuentepy.prontoshop.R;
import py.com.fuentepy.prontoshop.core.ProntoShopApplication;
import py.com.fuentepy.prontoshop.core.events.CustomerSelectedEvent;
import py.com.fuentepy.prontoshop.core.events.UpdateToolbarEvent;
import py.com.fuentepy.prontoshop.ui.transactions.TransactionActivity;
import py.com.fuentepy.prontoshop.util.Constants;
import py.com.fuentepy.prontoshop.util.Formatter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.math.BigDecimal;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.text_view_number_of_items)
    TextView mQtyTextView;
    @BindView(R.id.text_view_total_amount)
    TextView mTotalTextView;
    @BindView(R.id.text_view_customers_name)
    TextView mNameTextView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    private EventBus mBus;
    @Inject
    ShoppingCart mCart;

    private AccountHeader mHeader = null;
    private Activity mActivity;
    private Drawer mDrawer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mActivity = this;

        mBus = ProntoShopApplication.getInstance().getBus();
        ProntoShopApplication.getInstance().getAppComponent().inject(this);

        mHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .withSavedInstance(savedInstanceState)
                .build();

        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .withAccountHeader(mHeader)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Cart").withIcon(FontAwesome.Icon.faw_shopping_cart).withIdentifier(Constants.CART),
                        new PrimaryDrawerItem().withName("Report").withIcon(FontAwesome.Icon.faw_bar_chart).withIdentifier(Constants.REPORT),
                        new PrimaryDrawerItem().withName("Settings").withIcon(FontAwesome.Icon.faw_cog).withIdentifier(Constants.SETTINGS),
                        new PrimaryDrawerItem().withName("Transactions").withIcon(FontAwesome.Icon.faw_credit_card).withIdentifier(Constants.TRANSACTIONS)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null && drawerItem instanceof Nameable) {
                            String name = ((Nameable) drawerItem).getName().getText(MainActivity.this);
                            mNameTextView.setText(name);
                            onTouchDrawer(drawerItem.getIdentifier());
                        }
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();
        setupViewPager();


    }


    @Override
    protected void onResume() {
        super.onResume();
        try {
            mBus.register(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mBus != null) {
            try {
                mBus.unregister(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            mBus.unregister(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Subscribe
    public void onUpdateToolbar(UpdateToolbarEvent event) {
        populateToolbar(event.getTotalPrice(), event.getTotalQty());
    }

    @Subscribe
    public void onCustomerSelected(CustomerSelectedEvent event) {
        if (event.isClearCustomer()) {
            mNameTextView.setText(getString(R.string.hint_customer_name));
        } else {
            mNameTextView.setText(event.getSelectedCustomer().getCustomerName());
        }
    }


    private void populateToolbar(BigDecimal totalPrice, int totalQty) {
        mTotalTextView.setText(Formatter.formatCurrency(Double.valueOf(totalPrice.doubleValue())));
        mQtyTextView.setText(totalQty + " item");

    }


    private void onTouchDrawer(long identifier) {
        switch ((int) identifier) {
            case Constants.CART:
                //
                break;
            case Constants.REPORT:
                //Go to report
                Toast.makeText(this, "Report not implemented yet", Toast.LENGTH_SHORT).show();
                break;
            case Constants.SETTINGS:
                //Go to settings
                Toast.makeText(this, "Settings not implemented yet", Toast.LENGTH_SHORT).show();
                break;
            case Constants.TRANSACTIONS:
                startActivity(new Intent(MainActivity.this, TransactionActivity.class));
                break;
            case Constants.PURCHASE:
                //Go to checkout page
                Intent courseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.prontocast.com"));
                startActivity(courseIntent);
                break;

        }

    }

}
