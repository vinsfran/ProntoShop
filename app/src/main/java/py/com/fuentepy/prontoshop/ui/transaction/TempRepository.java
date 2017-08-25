package py.com.fuentepy.prontoshop.ui.transaction;

import java.util.List;

import py.com.fuentepy.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import py.com.fuentepy.prontoshop.model.SalesTransaction;

/**
 * Created by vinsfran on 22/08/17.
 */
public class TempRepository implements TransactionContract.Repository{
    @Override
    public List<SalesTransaction> getAllTransactions() {
        return null;
    }

    @Override
    public void updateTransaction(SalesTransaction transaction, OnDatabaseOperationCompleteListener listener) {

    }

    @Override
    public SalesTransaction getTransactionById(long id) {
        return null;
    }

    @Override
    public void deleteTransaction(long id, OnDatabaseOperationCompleteListener listener) {

    }
}
