package py.com.fuentepy.prontoshop.core;

import android.app.Application;

import py.com.fuentepy.prontoshop.core.dagger.AppComponent;
import py.com.fuentepy.prontoshop.core.dagger.AppModule;
import py.com.fuentepy.prontoshop.core.dagger.DaggerAppComponent;

/**
 * Created by vinsfran on 16/08/17.
 */
public class ProntoShopApplication extends Application{

    private static AppComponent appComponent;
    private static ProntoShopApplication instance = new ProntoShopApplication();

    @Override
    public void onCreate() {
        super.onCreate();
        getAppComponent();
    }

    private void getAppComponent() {
        if(appComponent == null){
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
    }
}
