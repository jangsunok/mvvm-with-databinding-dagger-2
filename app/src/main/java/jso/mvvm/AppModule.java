package jso.mvvm;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jang on 2017. 3. 2..
 */


@Module
public class AppModule {

    MyApplication application;


    AppModule(MyApplication application){
        this.application = application;
    }

    @Provides
    @Singleton
    MyApplication provideMyApplication(){ return application; }


    @Provides
    @Singleton
    Context provideAppContext(){ return application.getBaseContext(); }


}
