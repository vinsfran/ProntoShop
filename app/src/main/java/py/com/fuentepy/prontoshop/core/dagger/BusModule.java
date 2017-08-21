package py.com.fuentepy.prontoshop.core.dagger;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vinsfran on 21/08/17.
 */
@Module
public class BusModule {

    @Provides
    @Singleton
    public Bus provideBus(){
        return new Bus();
    }
}
