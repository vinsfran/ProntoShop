package py.com.fuentepy.prontoshop.core;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.greenrobot.eventbus.EventBus;

import py.com.fuentepy.prontoshop.core.dagger.AppComponent;
import py.com.fuentepy.prontoshop.core.dagger.AppModule;
import py.com.fuentepy.prontoshop.core.dagger.DaggerAppComponent;
import py.com.fuentepy.prontoshop.util.Constants;

/**
 * Created by vinsfran on 16/08/2017.
 */
public class ProntoShopApplication extends Application {
    private EventBus bus;

    public org.greenrobot.eventbus.EventBus getBus() {
        return bus;
    }


    private SharedPreferences sharedPreferences;

    private static ProntoShopApplication instance = new ProntoShopApplication();
    private static AppComponent appComponent;

    public static ProntoShopApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance.bus = new EventBus();
        getAppComponent();
        initDefaultProducts();
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return appComponent;
    }

    private void initDefaultProducts() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean(Constants.FIRST_RUN, true)) {
            startService(new Intent(this, AddInitialDataService.class));
            editor.putBoolean(Constants.FIRST_RUN, false).commit();
        }
    }
}
