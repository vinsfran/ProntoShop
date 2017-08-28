package py.com.fuentepy.prontoshop.core.listeners;

import py.com.fuentepy.prontoshop.models.Customer;
import py.com.fuentepy.prontoshop.models.SalesTransaction;

/**
 * Created by vinsfran on 28/08/2017.
 */
public interface OnTransactionSelectedListener {
    void onSelectTransaction(SalesTransaction transaction);

    Customer getCustomer(long id);
}
