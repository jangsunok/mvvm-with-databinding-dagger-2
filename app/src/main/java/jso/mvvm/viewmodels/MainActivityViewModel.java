package jso.mvvm.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;

import jso.mvvm.BR;
import jso.mvvm.models.MainModel;
import jso.mvvm.ui.MainActivity;

/**
 * Created by jang on 2017. 3. 2..
 */

public class MainActivityViewModel extends BaseObservable{

    MainActivity activity;

    MainModel model;
    String result;



    public MainActivityViewModel(@NonNull MainActivity activity) {
        this.activity = activity;
        model = new MainModel("", "");
    }


    //INPUT
    public void setUserName(String name){
        model.setName(name);
        notifyPropertyChanged(BR.userName);
        notifyPropertyChanged(BR.result);
    }

    public void setUserPassword(String password){
        model.setPassword(password);
        notifyPropertyChanged(BR.result);
    }


    //OUTPUT
    @Bindable
    public CharSequence getUserName() {
        return model.getName();
    }

    @Bindable
    public CharSequence getResult() {
        if(model==null){
            result = "put your name and PassWord!";
        }else if(model.getName().equals("jang") && model.getPassword().equals("password")){
            result = "Welcome jang!";
        }else if(model.getName().equals("jang")) {
            result = "password is password";
        }else {
            result = "put your name and password!";
        }
        return result;
    }


    @Bindable
    public TextWatcher getOnUsernameChanged() {

        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(String newValue) {
                setUserName(newValue);
            }
        };
    }

    @Bindable
    public TextWatcher getOnUserPasswordChanged() {

        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(String newValue) {
                setUserPassword(newValue);
            }
        };
    }



    public abstract class SimpleTextWatcher implements TextWatcher {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            onTextChanged(s.toString());
        }

        public abstract void onTextChanged(String newValue);
    }



}
