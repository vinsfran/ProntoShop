package py.com.fuentepy.prontoshop.ui.checkout;

import java.util.List;

import py.com.fuentepy.prontoshop.model.Category;
import py.com.fuentepy.prontoshop.model.LineItem;
import py.com.fuentepy.prontoshop.model.Product;
import py.com.fuentepy.prontoshop.model.Transaction;


/**
 * Created by vinsfran on 21/08/17.
 */
public interface CheckoutContract {

    public interface View {
        void showLineItem(List<LineItem> items);

        void showEmptyText();

        void showCatTotals(double tax, double subTotal, double total);

        void showConfirmCheckout();

        void showConfirmClearCart();

        void hideText();

        void showDeleteProductPrompt(Product product);

        void showMessage(String message);
    }

    public interface Actions {
        void loadLineItems();

        void onCheckoutButtonClicked();

        void onDeleteItemButtonClicked(LineItem item);

        void checkout();

        void onClearButtonClicked();

        void clearShoppingCart();

        void setPaymentType(String paymentType);

        void markAsPaid(boolean paid);

        void onItemQuantityChanged(LineItem item, int qty);
    }

    public interface Repository {
        List<LineItem> getAllLineItems();

        void saveTransaction(Transaction transaction);

        void updateTransaction(Transaction transaction);
    }
}
