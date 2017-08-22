package py.com.fuentepy.prontoshop.ui.transaction;

import java.util.List;

import py.com.fuentepy.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import py.com.fuentepy.prontoshop.model.Customer;
import py.com.fuentepy.prontoshop.model.Transaction;

/**
 * Created by vinsfran on 22/08/17.
 */
public class TransactionContract {
    public interface View {
        void showTransaction(List<Transaction> transactions);

        void showEmptyText();

        void hideEmptyText();

        void showConfirmDeletePrompty(Transaction transaction);

        void showMessage(String message);
    }

    public interface Actions {
        void loadTransactions();

        void onDeleteItemButtonClicked(Transaction transaction);

        void editTransaction(Transaction transaction);

        void deleteTransaction(Transaction transaction);

        Customer getCustomerById(long id);
    }

    public interface Repository {
        List<Transaction> getAllTransactions();

        void updateTransaction(Transaction transaction, OnDatabaseOperationCompleteListener listener);

        Transaction getTransactionById(long id);

        void deleteTransaction(long id, OnDatabaseOperationCompleteListener listener);
    }

}
