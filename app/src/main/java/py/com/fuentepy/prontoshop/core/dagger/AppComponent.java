package py.com.fuentepy.prontoshop.core.dagger;

import javax.inject.Singleton;

import dagger.Component;
import py.com.fuentepy.prontoshop.common.MainActivity;
import py.com.fuentepy.prontoshop.common.ShoppingCart;
import py.com.fuentepy.prontoshop.ui.checkout.CheckoutPresenter;
import py.com.fuentepy.prontoshop.ui.customerlist.CustomerPresenter;
import py.com.fuentepy.prontoshop.ui.productlist.ProductPresenter;
import py.com.fuentepy.prontoshop.ui.transaction.TransactionPresenter;

/**
 * Created by vinsfran on 07/08/17.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                ShoppingCartModule.class,
                BusModule.class,
                PersistenceModule.class
        }
)
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(ShoppingCart cart);
    void inject(ProductPresenter presenter);
    void inject(CustomerPresenter presenter);
    void inject(TransactionPresenter presenter);

}
