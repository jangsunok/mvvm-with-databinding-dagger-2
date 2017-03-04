package jso.mvvm.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import jso.mvvm.AppComponent;
import jso.mvvm.MyApplication;
import jso.mvvm.R;
import jso.mvvm.databinding.ActivityMainBinding;
import jso.mvvm.viewmodels.MainActivityViewModel;

/**
 * Created by jang on 2017. 3. 2..
 */

public class MainActivity extends AppCompatActivity {


    @Inject
    Context appContext;

    MainActivityComponent activityComponent;
    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppComponent appComponent = ((MyApplication)getApplication()).getAppComponent();
        appComponent.inject(this);

        activityComponent = DaggerMainActivityComponent.builder()
                .mainModule(new MainModule(this)).build();


        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new MainActivityViewModel(this);
        binding.setViewmodel(viewModel);


    }
}
