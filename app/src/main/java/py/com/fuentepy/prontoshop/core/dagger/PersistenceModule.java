package py.com.fuentepy.prontoshop.core.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import py.com.fuentepy.prontoshop.ui.customerlist.CustomerInMemoryRepository;
import py.com.fuentepy.prontoshop.ui.customerlist.CustomerListContract;
import py.com.fuentepy.prontoshop.ui.productlist.ProductInMemoryRepository;
import py.com.fuentepy.prontoshop.ui.productlist.ProductListContract;
import py.com.fuentepy.prontoshop.ui.transaction.TempRepository;
import py.com.fuentepy.prontoshop.ui.transaction.TransactionContract;

/**
 * Created by vinsfran on 22/08/17.
 */
@Module
public class PersistenceModule {

    @Provides
    @Singleton
    public ProductListContract.Repository providesProductRepository(Context context){
        return new ProductInMemoryRepository();
    }

    @Provides
    @Singleton
    public CustomerListContract.Repository providesCustomerRepository(Context context){
        return new CustomerInMemoryRepository();
    }

    @Provides
    public TransactionContract.Repository providesTemTransactionRepository(Context context){
        return new TempRepository();
    }

}
