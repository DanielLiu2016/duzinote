package cn.duzi.note.mvp.presenter;

import android.app.Application;

import com.jess.arms.integration.AppManager;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.http.imageloader.ImageLoader;

import java.util.logging.Handler;

import cn.duzi.note.mvp.bean.UserBean;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

import javax.inject.Inject;

import cn.duzi.note.mvp.contract.LoginContract;


@ActivityScope
public class LoginPresenter extends BasePresenter<LoginContract.LoginModel, LoginContract.LoginView> {
    private RxErrorHandler mErrorHandler;
    private Application mApplication;
    private ImageLoader mImageLoader;
    private AppManager mAppManager;
    private Handler mHandler;

    @Inject
    public LoginPresenter(LoginContract.LoginModel model, LoginContract.LoginView rootView
            , RxErrorHandler handler, Application application
            , ImageLoader imageLoader, AppManager appManager) {
        super(model, rootView);
        this.mErrorHandler = handler;
        this.mApplication = application;
        this.mImageLoader = imageLoader;
        this.mAppManager = appManager;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }

    public void login(){
        mRootView.showLoading();
        mModel.login(mRootView.getUsername(), mRootView.getPassword(), new LoginContract.LoginModel.OnLoginListener() {
            @Override
            public void loginSuccess(UserBean user) {
                mRootView.showSuccessMsg(user);
                mRootView.hideLoading();
            }

            @Override
            public void loginFailed(String s) {
                mRootView.showFailedMsg(s);
                mRootView.hideLoading();
            }
        });
    }
}
