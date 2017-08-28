package py.com.fuentepy.prontoshop.core.events;

import py.com.fuentepy.prontoshop.models.Customer;

/**
 * Created by vinsfran on 28/08/2017.
 */
public class CustomerSelectedEvent {
    private final Customer selectedCustomer;
    private final boolean clearCustomer;

    public CustomerSelectedEvent(Customer selectedCustomer, boolean clearCustomer) {
        this.selectedCustomer = selectedCustomer;
        this.clearCustomer = clearCustomer;
    }

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public boolean isClearCustomer() {
        return clearCustomer;
    }
}
