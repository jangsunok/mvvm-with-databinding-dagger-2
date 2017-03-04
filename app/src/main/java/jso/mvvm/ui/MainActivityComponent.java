package jso.mvvm.ui;

import dagger.Component;
import jso.mvvm.viewmodels.MainActivityViewModel;

/**
 * Created by jang on 2017. 3. 2..
 */

@PerActivity
@Component(modules = MainModule.class)
public interface MainActivityComponent {
    void inject(MainActivityViewModel __);
}
