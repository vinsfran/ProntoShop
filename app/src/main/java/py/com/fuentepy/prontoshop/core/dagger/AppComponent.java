package py.com.fuentepy.prontoshop.core.dagger;

import javax.inject.Singleton;

import dagger.Component;
import py.com.fuentepy.prontoshop.common.MainActivity;
import py.com.fuentepy.prontoshop.common.ShoppingCart;

/**
 * Created by vinsfran on 07/08/17.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                ShoppingCartModule.class,
                BusModule.class
        }
)
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(ShoppingCart cart);
}
