package py.com.fuentepy.prontoshop.core.dagger;

import py.com.fuentepy.prontoshop.common.MainActivity;
import py.com.fuentepy.prontoshop.data.sqlite.LineItemSQLiteRepository;
import py.com.fuentepy.prontoshop.data.sqlite.SQLiteReport;
import py.com.fuentepy.prontoshop.data.sqlite.TransactionSQLiteRepository;
import py.com.fuentepy.prontoshop.ui.addCustomer.AddCustomerPresenter;
import py.com.fuentepy.prontoshop.ui.addProduct.AddProductPresenter;
import py.com.fuentepy.prontoshop.ui.checkout.CheckoutPresenter;
import py.com.fuentepy.prontoshop.ui.customers.CustomerListPresenter;
import py.com.fuentepy.prontoshop.ui.products.ProductListPresenter;
import py.com.fuentepy.prontoshop.ui.transactions.TransactionListFragment;
import py.com.fuentepy.prontoshop.ui.transactions.TransactionPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by vinsfran on 07/08/2017.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                ShoppingCartModule.class,
                BusModule.class,
                PersistenceModule.class
        }
)
public interface AppComponent {
    void inject(ProductListPresenter presenter);

    void inject(CustomerListPresenter presenter);

    void inject(AddCustomerPresenter presenter);

    void inject(CheckoutPresenter presenter);

    void inject(AddProductPresenter presenter);

    void inject(TransactionPresenter presenter);

    void inject(TransactionListFragment fragment);

    void inject(MainActivity activity);

    void inject(TransactionSQLiteRepository repository);

    void inject(SQLiteReport report);

    void inject(LineItemSQLiteRepository repository);
}
