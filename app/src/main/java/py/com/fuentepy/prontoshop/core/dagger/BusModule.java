package py.com.fuentepy.prontoshop.core.dagger;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vinsfran on 21/08/2017.
 */
@Module
public class BusModule {

    @Provides
    @Singleton
    public EventBus provideBus() {
        return new EventBus();
    }
}

