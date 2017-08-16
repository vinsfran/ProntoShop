package py.com.fuentepy.prontoshop.core.dagger;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import py.com.fuentepy.prontoshop.common.ShoppingCart;

/**
 * Created by vinsfran on 16/08/17.
 */
@Module
public class ShoppingCartModule {

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    ShoppingCart provideShoppingCart(SharedPreferences preferences){
        return new ShoppingCart(preferences);
    }
}
