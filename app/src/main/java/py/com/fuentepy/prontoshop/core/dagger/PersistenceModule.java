package py.com.fuentepy.prontoshop.core.dagger;

import android.content.Context;

import py.com.fuentepy.prontoshop.data.sqlite.CustomerSQLiteRepository;
import py.com.fuentepy.prontoshop.data.sqlite.LineItemSQLiteRepository;
import py.com.fuentepy.prontoshop.data.sqlite.ProductSQLiteRepository;
import py.com.fuentepy.prontoshop.data.sqlite.TransactionSQLiteRepository;
import py.com.fuentepy.prontoshop.ui.checkout.CheckoutContract;
import py.com.fuentepy.prontoshop.ui.customers.CustomerListContract;
import py.com.fuentepy.prontoshop.ui.products.ProductListContract;
import py.com.fuentepy.prontoshop.ui.transactions.TransactionContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vinsfran on 22/08/2017.
 */
@Module
public class PersistenceModule {

    @Provides
    public ProductListContract.Repository providesProductRepository(Context context) {
//        return new ProductInMemoryRepository();
        return new ProductSQLiteRepository(context);
    }

    @Provides
    public CustomerListContract.Repository providesCustomerRepository(Context context) {
//        return new CustomerInMemoryRepository();
        return new CustomerSQLiteRepository(context);
    }

    @Provides
    public TransactionContract.Repository providesTransactionRepository(Context context) {
//        return new TempRepository();
        return new TransactionSQLiteRepository(context);
    }

    @Provides
    public CheckoutContract.Repository providesLineItemRepository(Context context) {
        return new LineItemSQLiteRepository(context);
    }

}
