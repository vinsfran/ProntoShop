package py.com.fuentepy.prontoshop.ui.customers;

import py.com.fuentepy.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import py.com.fuentepy.prontoshop.models.Customer;

import java.util.List;

/**
 * Created by vinsfran on 28/08/2017.
 */
public interface CustomerListContract {
    public interface View{
        void showCustomers(List<Customer> customers);
        void showAddCustomerForm();
        void showDeleteCustomerPrompt(Customer customer);
        void showEditCustomerForm(Customer customer);
        void showEmptyText();
        void hideEmptyText();
        void showMessage(String message);

    }

    public interface Actions{
        void loadCustomers();
        Customer getCustomer(long id);
        void onCustomerSelected(Customer customer);
        void onAddCustomerButtonClicked();
        void addCustomer(Customer customer);
        void onDeleteCustomerButtonClicked(Customer customer);
        void deleteCustomer(Customer customer);
        void onEditCustomerButtonClicked(Customer customer);
        void updateCustomer(Customer customer);

    }

    public interface Repository{
        List<Customer> getAllCustomers();
        Customer getCustomerById(long id);
        void deleteCustomer(Customer customer, OnDatabaseOperationCompleteListener listener);
        void addCustomer(Customer customer, OnDatabaseOperationCompleteListener listener);
        void updateCustomer(Customer customer, OnDatabaseOperationCompleteListener listener);

    }
}
