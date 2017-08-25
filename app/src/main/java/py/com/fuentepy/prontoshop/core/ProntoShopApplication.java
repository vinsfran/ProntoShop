package py.com.fuentepy.prontoshop.core;

import android.app.Application;

import com.squareup.otto.Bus;

import py.com.fuentepy.prontoshop.core.dagger.AppComponent;
import py.com.fuentepy.prontoshop.core.dagger.AppModule;
import py.com.fuentepy.prontoshop.core.dagger.DaggerAppComponent;

/**
 * Created by vinsfran on 16/08/17.
 */
public class ProntoShopApplication extends Application {

    private static AppComponent appComponent;
    private static ProntoShopApplication instance = new ProntoShopApplication();

    private Bus bus;

    public Bus getBus() {
        return bus;
    }

    public static ProntoShopApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getAppComponent();
        instance.bus = new Bus();
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return appComponent;
    }
}
