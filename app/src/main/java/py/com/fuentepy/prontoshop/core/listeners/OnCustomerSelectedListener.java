package py.com.fuentepy.prontoshop.core.listeners;

import py.com.fuentepy.prontoshop.model.Customer;

/**
 * Created by vinsfran on 09/08/17.
 */
public interface OnCustomerSelectedListener {
    void onSelectCustomer(Customer customer);

    void onLongClickCustomer(Customer customer);
}
