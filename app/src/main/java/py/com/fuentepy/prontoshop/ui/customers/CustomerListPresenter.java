package py.com.fuentepy.prontoshop.ui.customers;

import py.com.fuentepy.prontoshop.common.ShoppingCart;
import py.com.fuentepy.prontoshop.core.ProntoShopApplication;
import py.com.fuentepy.prontoshop.core.events.CustomerListChangedEvent;
import py.com.fuentepy.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import py.com.fuentepy.prontoshop.models.Customer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by vinsfran on 28/08/2017.
 */
public class CustomerListPresenter implements CustomerListContract.Actions, OnDatabaseOperationCompleteListener {
    private final CustomerListContract.View mView;
    @Inject
    CustomerListContract.Repository mRepository;
    @Inject
    ShoppingCart mCart;
    @Inject
    EventBus mBus;

    public CustomerListPresenter(CustomerListContract.View customerListView) {
        this.mView = customerListView;
        ProntoShopApplication.getInstance().getAppComponent().inject(this);
        mBus.register(this);
    }

    @Override
    public void loadCustomers() {
        List<Customer> availableCustomers = mRepository.getAllCustomers();
        if (availableCustomers != null && availableCustomers.size() > 0) {
            mView.hideEmptyText();
            mView.showCustomers(availableCustomers);
        } else {
            mView.showEmptyText();
        }
    }

    @Override
    public void onCustomerSelected(Customer customer) {
        mCart.setCustomer(customer);
    }


    @Override
    public void onAddCustomerButtonClicked() {
        mView.showAddCustomerForm();
    }

    @Override
    public void addCustomer(Customer customer) {
        mRepository.addCustomer(customer, this);
    }

    @Override
    public void onDeleteCustomerButtonClicked(Customer customer) {
        mView.showDeleteCustomerPrompt(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        mRepository.deleteCustomer(customer, this);
        loadCustomers();
    }

    @Override
    public void onEditCustomerButtonClicked(Customer customer) {
        mView.showEditCustomerForm(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        mRepository.updateCustomer(customer, this);
    }

    @Subscribe
    public void onCustomerListChanged(CustomerListChangedEvent event) {
        loadCustomers();
    }


    @Override
    public Customer getCustomer(long id) {
        return mRepository.getCustomerById(id);
    }

    @Override
    public void onSQLOperationFailed(String error) {
        mView.showMessage("Error: " + error);
    }

    @Override
    public void onSQLOperationSucceded(String message) {
        mView.showMessage(message);
    }


}
