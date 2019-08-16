package com.example.fruitdelivery.modules.account.register;

import com.example.fruitdelivery.base.BasePresenter;

public class RegisterPresenter extends BasePresenter <RegisterView,RegisterModel>{

    public void get(){

    }
    @Override
    protected RegisterModel createModel() {
        return new RegisterModel();
    }
}
