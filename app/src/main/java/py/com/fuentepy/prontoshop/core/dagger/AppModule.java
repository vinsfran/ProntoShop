package py.com.fuentepy.prontoshop.core.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import py.com.fuentepy.prontoshop.core.ProntoShopApplication;

/**
 * Created by vinsfran on 07/08/2017.
 */
@Module
public class AppModule {
    private final ProntoShopApplication app;

    public AppModule(ProntoShopApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public ProntoShopApplication getApp() {
        return app;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return app;
    }
}
