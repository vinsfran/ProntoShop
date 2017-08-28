package py.com.fuentepy.prontoshop.core.listeners;

import py.com.fuentepy.prontoshop.models.Customer;

/**
 * Created by vinsfran on 09/08/2017.
 */
public interface OnCustomerSelectedListener {
    void onSelectCustomer(Customer customer);

    void onLongClickProduct(Customer clickedCustomer);
}
