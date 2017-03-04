package jso.mvvm;

import android.app.Application;

/**
 * Created by jang on 2017. 3. 2..
 */

public class MyApplication extends Application {
    AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }


    public AppComponent getAppComponent(){ return appComponent; }
}
