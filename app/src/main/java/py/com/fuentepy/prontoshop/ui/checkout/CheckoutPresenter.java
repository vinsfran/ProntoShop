package py.com.fuentepy.prontoshop.ui.checkout;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import py.com.fuentepy.prontoshop.common.ShoppingCart;
import py.com.fuentepy.prontoshop.core.ProntoShopApplication;
import py.com.fuentepy.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import py.com.fuentepy.prontoshop.models.LineItem;
import py.com.fuentepy.prontoshop.models.SalesTransaction;
import py.com.fuentepy.prontoshop.ui.transactions.TransactionContract;

import java.util.List;

import javax.inject.Inject;

import static android.R.attr.id;

/**
 * Created by vinsfran on 28/08/2017.
 */
public class CheckoutPresenter implements CheckoutContract.Actions, OnDatabaseOperationCompleteListener {
    private final CheckoutContract.View mView;
    @Inject
    TransactionContract.Repository mTransactionRepository;
    @Inject
    CheckoutContract.Repository mLineItemRepository;
    @Inject
    Context mContext;
    private long transactionId = -1;
    private final static String LOG_TAG = CheckoutPresenter.class.getSimpleName();
    private final static boolean DEBUG = true;

    private String selectedPaymentType = "";
    private boolean paid = false;


    @Inject
    ShoppingCart mCart;

    public CheckoutPresenter(CheckoutContract.View cartView) {
        this.mView = cartView;
        ProntoShopApplication.getInstance().getAppComponent().inject(this);

    }


    @Override
    public void loadLineItems() {
        List<LineItem> availableProducts = mCart.getShoppingCart();

        if (availableProducts != null && availableProducts.size() > 0) {
            mView.hideEmptyText();
            mView.showLineItem(availableProducts);
        } else {
            mView.showEmptyText();
        }
        double subTotal = mCart.getSubTotalAmount();
        double tax = mCart.getTaxAmount();
        double totalAmount = mCart.getTotalAmount();

        mView.showCartTotals(tax, subTotal, totalAmount);

    }


    @Override
    public void onCheckoutButtonClicked() {
        mView.showConfirmCheckout();
    }

    @Override
    public void onDeleteItemButtonClicked(LineItem item) {
        //Ensure there is an existing Shopping Cart
        mCart.removeItemFromCart(item);
        loadLineItems();
    }

    @Override
    public void checkout() {
        //Ensure a customer is selected
        if (mCart.getShoppingCart() == null || mCart.getShoppingCart().size() == 0) {
            mView.showMessage("Cart is empty");
            return;
        }
        if (mCart.getSelectedCustomer() == null || mCart.getSelectedCustomer().getId() == 0) {
            mView.showMessage("No Customer selected");
            return;
        }

        final SalesTransaction transaction = new SalesTransaction();
        transaction.setCustomerId(mCart.getSelectedCustomer().getId());
        transaction.setLineItems(mCart.getShoppingCart());
        transaction.setTaxAmount(mCart.getTaxAmount());
        transaction.setSubTotalAmount(mCart.getSubTotalAmount());
        transaction.setTotalAmount(mCart.getTotalAmount());
        transaction.setPaymentType(selectedPaymentType);
        transaction.setLineItems(mCart.getShoppingCart());
        transaction.setPaid(paid);
        new SaveTransactionAsync().execute(transaction);
        //  transactionId =  mTransactionRepository.saveTransaction(transaction, this);

    }

    @Override
    public void onClearButtonClicked() {
        mView.showConfirmClearCart();
    }

    @Override
    public void clearShoppingCart() {
        mCart.clearShoppingCart();
        loadLineItems();
    }

    @Override
    public void setPaymentType(String paymentType) {
        if (DEBUG) {
            Log.d(LOG_TAG, "Set Payment Type: " + paymentType);
        }
        selectedPaymentType = paymentType;
    }

    @Override
    public void markAsPaid(boolean isPaid) {
        paid = isPaid;
    }


    @Override
    public void onItemQuantityChanged(LineItem item, int qty) {
        mCart.updateItemQty(item, qty);
        loadLineItems();
    }

    public CheckoutContract.View getView() {
        return mView;
    }


    @Override
    public void onSQLOperationFailed(String error) {
        mView.showMessage("Error: " + error);
    }

    @Override
    public void onSQLOperationSucceded(String message) {
        mView.showMessage(message);
    }

    public class SaveTransactionAsync extends AsyncTask<SalesTransaction, Void, String> {

        @Override
        protected String doInBackground(SalesTransaction... params) {
            SalesTransaction transaction = params[0];
            final String[] result = {""};
            transactionId = mTransactionRepository.saveTransaction(transaction, new OnDatabaseOperationCompleteListener() {
                @Override
                public void onSQLOperationFailed(String error) {
                    result[0] = error;
                }

                @Override
                public void onSQLOperationSucceded(String message) {
                    result[0] = message;
                }
            });
            if (id > -1) {
                for (LineItem lineItem : transaction.getLineItems()) {
                    lineItem.setTransactionId(transactionId);
                    mLineItemRepository.saveLineItem(lineItem, CheckoutPresenter.this);
                }
            }
            return result[0];
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            mView.showMessage(result);
            mCart.clearShoppingCart();
            loadLineItems();
        }
    }
}
