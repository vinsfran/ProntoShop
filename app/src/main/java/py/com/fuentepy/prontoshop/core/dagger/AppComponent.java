package py.com.fuentepy.prontoshop.core.dagger;

import javax.inject.Singleton;

import dagger.Component;
import py.com.fuentepy.prontoshop.common.MainActivity;

/**
 * Created by vinsfran on 07/08/17.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                ShoppingCartModule.class
        }
)
public interface AppComponent {
    void inject(MainActivity activity);
}
