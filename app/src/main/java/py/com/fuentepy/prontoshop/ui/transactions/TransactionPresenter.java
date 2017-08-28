package py.com.fuentepy.prontoshop.ui.transactions;

import py.com.fuentepy.prontoshop.core.ProntoShopApplication;
import py.com.fuentepy.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import py.com.fuentepy.prontoshop.models.Customer;
import py.com.fuentepy.prontoshop.models.LineItem;
import py.com.fuentepy.prontoshop.models.SalesTransaction;
import py.com.fuentepy.prontoshop.ui.checkout.CheckoutContract;
import py.com.fuentepy.prontoshop.ui.customers.CustomerListContract;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by vinsfran on 22/08/2017.
 */
public class TransactionPresenter implements TransactionContract.Actions, OnDatabaseOperationCompleteListener {
    private final TransactionContract.View mView;
    @Inject TransactionContract.Repository mRepository;
    @Inject CustomerListContract.Repository mCustomerRepository;
    @Inject CheckoutContract.Repository mLineItemRepository;

    public TransactionPresenter(TransactionContract.View view) {
        mView = view;
        ProntoShopApplication.getInstance().getAppComponent().inject(this);
    }


    @Override
    public void loadSalesTransactions() {
        List<SalesTransaction> transactions = mRepository.getAllSalesTransactions();
        if (transactions != null && transactions.size() > 0){
            mView.hideEmptyText();
            mView.showSalesTransaction(transactions);
        }else {
            mView.showEmptyText();
        }

    }

    @Override
    public void onDeleteItemButtonClicked(SalesTransaction transaction) {
        mView.showConfirmDeletePrompt(transaction);
    }

    @Override
    public void editTransaction(SalesTransaction transaction) {
        mRepository.updateTransaction(transaction, this);
    }

    @Override
    public void deleteTransaction(SalesTransaction transaction) {
        mRepository.deleteTransaction(transaction.getId(), this);
    }

    @Override
    public Customer getCustomerById(long id) {
        return mCustomerRepository.getCustomerById(id);
    }

    @Override
    public List<LineItem> getLineItemsInTransactions(long transactionId) {
        return mLineItemRepository.getAllLineItemsInATransaction(transactionId);
    }

    @Override
    public void onSQLOperationFailed(String error) {
        mView.showMessage("Error: " + error);
    }

    @Override
    public void onSQLOperationSucceded(String message) {
        mView.showMessage(message);
    }
}
