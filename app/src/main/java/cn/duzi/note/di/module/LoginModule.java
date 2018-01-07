package cn.duzi.note.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import cn.duzi.note.mvp.contract.LoginContract;
import cn.duzi.note.mvp.model.LoginModel;


@Module
public class LoginModule {
    private LoginContract.LoginView view;

    /**
     * 构建LoginModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public LoginModule(LoginContract.LoginView view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    LoginContract.LoginView provideLoginView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    LoginContract.LoginModel provideLoginModel(LoginModel model) {
        return model;
    }
}