package py.com.fuentepy.prontoshop.ui.addCustomer;

import py.com.fuentepy.prontoshop.core.ProntoShopApplication;
import py.com.fuentepy.prontoshop.core.events.CustomerListChangedEvent;
import py.com.fuentepy.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import py.com.fuentepy.prontoshop.models.Customer;
import py.com.fuentepy.prontoshop.ui.customers.CustomerListContract;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * Created by vinsfran on 28/08/2017.
 */
public class AddCustomerPresenter implements AddCustomerContract.Action, OnDatabaseOperationCompleteListener {
    private final AddCustomerContract.View mView;
    private long customerId = 0;
    @Inject
    CustomerListContract.Repository mRepository;
    @Inject
    EventBus mBus;

    public AddCustomerPresenter(AddCustomerContract.View view) {
        mView = view;
        ProntoShopApplication.getInstance().getAppComponent().inject(this);
    }

    @Override
    public void onAddCustomerButtonClick(Customer customer) {
        if (customerId > 0) {
            updatedCustomer(customer);
        } else {
            saveCustomer(customer);
        }
    }

    @Override
    public void checkStatus(long id) {
        if (id > 0) {
            if (mRepository.getCustomerById(id) != null) {
                customerId = id;
                mView.setEditMode(true);
                mView.populateForm(mRepository.getCustomerById(id));
            }
        }
    }

    @Override
    public void saveCustomer(Customer customer) {
        if (customerId > 0) {
            customer.setId(customerId);
            updatedCustomer(customer);
        } else {
            mRepository.addCustomer(customer, this);
        }

    }

    @Override
    public void updatedCustomer(Customer customer) {
        customer.setId(customerId);
        mRepository.updateCustomer(customer, this);
    }

    @Override
    public void onSQLOperationFailed(String error) {
        mView.displayMessage("Error: " + error);
    }

    @Override
    public void onSQLOperationSucceded(String message) {
        mView.displayMessage(message);
        mBus.post(new CustomerListChangedEvent());
    }
}
