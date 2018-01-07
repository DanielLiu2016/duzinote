package cn.duzi.note.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import com.jess.arms.di.scope.ActivityScope;

import javax.inject.Inject;

import cn.duzi.note.mvp.bean.UserBean;
import cn.duzi.note.mvp.contract.LoginContract;


@ActivityScope
public class LoginModel extends BaseModel implements LoginContract.LoginModel {
    private Gson mGson;
    private Application mApplication;

    @Inject
    public LoginModel(IRepositoryManager repositoryManager, Gson gson, Application application) {
        super(repositoryManager);
        this.mGson = gson;
        this.mApplication = application;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public void login(final String username,final String password,final OnLoginListener onLoginListener) {

        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                    if (username.equals("DanielLiu2016@outlook.com") && password.equals("12345")) {
                        onLoginListener.loginSuccess(new UserBean(username, password));
                    } else {
                        onLoginListener.loginFailed("Incorrect username or password.");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}