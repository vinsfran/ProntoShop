package py.com.fuentepy.prontoshop.ui.transaction;

import java.util.List;

import py.com.fuentepy.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import py.com.fuentepy.prontoshop.model.Customer;
import py.com.fuentepy.prontoshop.model.SalesTransaction;

/**
 * Created by vinsfran on 22/08/17.
 */
public class TransactionContract {
    public interface View {
        void showTransaction(List<SalesTransaction> transactions);

        void showEmptyText();

        void hideEmptyText();

        void showConfirmDeletePrompty(SalesTransaction transaction);

        void showMessage(String message);
    }

    public interface Actions {
        void loadTransactions();

        void onDeleteItemButtonClicked(SalesTransaction transaction);

        void editTransaction(SalesTransaction transaction);

        void deleteTransaction(SalesTransaction transaction);

        Customer getCustomerById(long id);
    }

    public interface Repository {
        List<SalesTransaction> getAllTransactions();

        void updateTransaction(SalesTransaction transaction, OnDatabaseOperationCompleteListener listener);

        SalesTransaction getTransactionById(long id);

        void deleteTransaction(long id, OnDatabaseOperationCompleteListener listener);
    }

}
