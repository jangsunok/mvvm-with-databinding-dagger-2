package jso.mvvm.models;

/**
 * Created by jang on 2017. 3. 2..
 */

public class MainModel {
    String name;
    String password;


    public MainModel(){

    }

    public MainModel(String name, String password) {
        this.name = name;
        this.password = password;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
