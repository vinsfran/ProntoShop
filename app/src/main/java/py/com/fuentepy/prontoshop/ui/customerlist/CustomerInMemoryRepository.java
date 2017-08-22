package py.com.fuentepy.prontoshop.ui.customerlist;

import java.util.List;

import py.com.fuentepy.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import py.com.fuentepy.prontoshop.data.SampleCustomerData;
import py.com.fuentepy.prontoshop.model.Customer;

/**
 * Created by vinsfran on 22/08/17.
 */
public class CustomerInMemoryRepository implements CustomerListContract.Repository {

    public CustomerInMemoryRepository() {
    }

    @Override
    public List<Customer> getAllCustomers() {
        return SampleCustomerData.getCustomers();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return null;
    }

    @Override
    public void onDeleteCustomer(Customer customer, OnDatabaseOperationCompleteListener listener) {

    }

    @Override
    public void addCustomer(Customer customer, OnDatabaseOperationCompleteListener listener) {

    }

    @Override
    public void updatedCustomer(Customer customer, OnDatabaseOperationCompleteListener listener) {

    }
}
