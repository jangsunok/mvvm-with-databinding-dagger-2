package jso.mvvm.ui;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jang on 2017. 3. 2..
 */


@Module
public class MainModule {

    MainActivity activity;


    public MainModule(MainActivity activity){
        this.activity = activity;
    }

    @Provides
    @PerActivity
    MainActivity provideMainActivity(){ return activity; }



}
