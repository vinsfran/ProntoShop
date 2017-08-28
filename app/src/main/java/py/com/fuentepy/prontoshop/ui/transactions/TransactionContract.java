package py.com.fuentepy.prontoshop.ui.transactions;

import py.com.fuentepy.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import py.com.fuentepy.prontoshop.models.Customer;
import py.com.fuentepy.prontoshop.models.LineItem;
import py.com.fuentepy.prontoshop.models.SalesTransaction;

import java.util.List;

/**
 * Created by vinsfran on 22/08/2017.
 */
public interface TransactionContract {

    public interface View{
        void showSalesTransaction(List<SalesTransaction> transactions);
        void showEmptyText();
        void hideEmptyText();
        void showConfirmDeletePrompt(SalesTransaction transaction);
        void showMessage(String message);

    }

    public interface Actions{
        void loadSalesTransactions();
        void onDeleteItemButtonClicked(SalesTransaction transaction);
        void editTransaction(SalesTransaction transaction);
        void deleteTransaction(SalesTransaction transaction);
        Customer getCustomerById(long id);
        List<LineItem> getLineItemsInTransactions(long transactionId);
    }

    public interface Repository{
        List<LineItem> getAllLineItems();
        long saveTransaction(SalesTransaction transaction, OnDatabaseOperationCompleteListener listener);
        List<SalesTransaction> getAllSalesTransactions();
        void updateTransaction(SalesTransaction transaction, OnDatabaseOperationCompleteListener listener);
        SalesTransaction getTransactionById(long id);
        void deleteTransaction(long id, OnDatabaseOperationCompleteListener listener);


    }

}
