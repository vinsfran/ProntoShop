package py.com.fuentepy.prontoshop.ui.checkout;

import java.util.List;

import javax.inject.Inject;

import py.com.fuentepy.prontoshop.common.ShoppingCart;
import py.com.fuentepy.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import py.com.fuentepy.prontoshop.model.LineItem;
import py.com.fuentepy.prontoshop.model.SalesTransaction;

/**
 * Created by vinsfran on 22/08/17.
 */
public class CheckoutPresenter implements CheckoutContract.Actions, OnDatabaseOperationCompleteListener {
    private final CheckoutContract.View mView;
    @Inject
    CheckoutContract.Repository mRepository;
    @Inject
    ShoppingCart mCart;

    private double subTotal = 0.0;
    private double total;
    private double tax;
    private double taxRate = 0.08;
    private String selectedPaymentType = "";
    private boolean paid = false;

    public CheckoutPresenter(CheckoutContract.View mView) {
        this.mView = mView;
        //ProntoShopApplication.getInstance().getAppComponent().inject(this);
    }

    @Override
    public void loadLineItems() {
        List<LineItem> availableLineItems = mCart.getShoppingCart();
        calculateTotals(availableLineItems);
        if (availableLineItems != null && availableLineItems.size() > 0) {
            mView.hideText();
            mView.showLineItem(availableLineItems);
        } else {
            mView.showEmptyText();
        }
    }

    public void calculateTotals(List<LineItem> availableLineItems) {
        subTotal = 0.0;
        total = 0.0;
        tax = 0.0;
        for (LineItem item : availableLineItems) {
            subTotal += item.getSumPrice();
        }

        tax = subTotal * taxRate;
        total = tax + subTotal;
        mView.showCatTotals(tax, subTotal, total);
    }

    @Override
    public void onCheckoutButtonClicked() {
        mView.showConfirmCheckout();
    }

    @Override
    public void onDeleteItemButtonClicked(LineItem item) {
        mCart.removeItemFromCart(item);
        loadLineItems();
    }

    @Override
    public void checkout() {
        //Ensure a customer is selected
        if (mCart.getShoppingCart() != null || mCart.getShoppingCart().size() == 0) {
            mView.showMessage("Cart is empty");
            return;
        }
        if (mCart.getSelectedCustomer() == null || mCart.getSelectedCustomer().getId() == 0) {
            mView.showMessage("No Customer is selected");
        }
        SalesTransaction transaction = new SalesTransaction();
        transaction.setCustomerId(mCart.getSelectedCustomer().getId());
        transaction.setLineItems(mCart.getShoppingCart());
        transaction.setTaxAmount(tax);
        transaction.setSubTotalAmount(subTotal);
        transaction.setTotalAmount(total);
        transaction.setPaymentType(selectedPaymentType);
        transaction.setPaid(paid);
        mRepository.saveTransaction(transaction, this);
    }

    @Override
    public void onClearButtonClicked() {
        mView.showConfirmClearCart();
    }

    @Override
    public void clearShoppingCart() {
        mCart.clearAllItemFromCart();
        loadLineItems();
    }

    @Override
    public void setPaymentType(String paymentType) {
        selectedPaymentType = paymentType;
    }

    @Override
    public void markAsPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public void onItemQuantityChanged(LineItem item, int qty) {
        mCart.updateItemQty(item, qty);
    }

    @Override
    public void onDatabaseOperationFailed(String error) {
        mView.showMessage("Error Message:" + error);
    }

    @Override
    public void onDatabaseOperationSucceded(String message) {
        mView.showMessage(message);
    }
}
