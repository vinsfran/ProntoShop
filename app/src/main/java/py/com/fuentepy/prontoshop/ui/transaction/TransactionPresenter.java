package py.com.fuentepy.prontoshop.ui.transaction;

import java.util.List;

import javax.inject.Inject;

import py.com.fuentepy.prontoshop.core.ProntoShopApplication;
import py.com.fuentepy.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import py.com.fuentepy.prontoshop.model.Customer;
import py.com.fuentepy.prontoshop.model.Transaction;
import py.com.fuentepy.prontoshop.ui.customerlist.CustomerListContract;

/**
 * Created by vinsfran on 22/08/17.
 */
public class TransactionPresenter implements TransactionContract.Actions, OnDatabaseOperationCompleteListener {
    private final TransactionContract.View mView;
    @Inject
    TransactionContract.Repository mRepository;
    @Inject
    CustomerListContract.Repository mCustomerRepository;

    public TransactionPresenter(TransactionContract.View mView) {
        this.mView = mView;
        ProntoShopApplication.getInstance().getAppComponent().inject(this);
    }

    @Override
    public void loadTransactions() {
        List<Transaction> transactions = mRepository.getAllTransactions();
        if (transactions != null && transactions.size() > 0) {
            mView.hideEmptyText();
            mView.showTransaction(transactions);
        } else {
            mView.showEmptyText();
        }

    }

    @Override
    public void onDeleteItemButtonClicked(Transaction transaction) {
        mView.showConfirmDeletePrompty(transaction);
    }

    @Override
    public void editTransaction(Transaction transaction) {
        mRepository.updateTransaction(transaction, this);
    }

    @Override
    public void deleteTransaction(Transaction transaction) {
        mRepository.deleteTransaction(transaction.getId(), this);
    }

    @Override
    public Customer getCustomerById(long id) {
        return mCustomerRepository.getCustomerById(id);
    }

    @Override
    public void onDatabaseOperationFailed(String error) {
        mView.showMessage("Error:" + error);
    }

    @Override
    public void onDatabaseOperationSucceded(String message) {
        mView.showMessage(message);
    }
}
