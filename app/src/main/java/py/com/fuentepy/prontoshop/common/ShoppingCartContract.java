package py.com.fuentepy.prontoshop.common;

import java.util.List;

import py.com.fuentepy.prontoshop.model.Customer;
import py.com.fuentepy.prontoshop.model.LineItem;

/**
 * Created by vinsfran on 16/08/17.
 */
public interface ShoppingCartContract {
    void addItemToCart(LineItem item);
    void removeItemFromCart(LineItem item);
    void clearAllItemFromCart();
    List<LineItem> getShoppingCart();
    void setCustomer(Customer customer);
    void updateItemQty(LineItem item, int qty);
    Customer getSelectedCustomer();
    void completeCheckout();
}
