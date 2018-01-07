package cn.duzi.note.mvp.contract;

import com.jess.arms.mvp.IView;
import com.jess.arms.mvp.IModel;

import cn.duzi.note.mvp.bean.UserBean;


public interface LoginContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface LoginView extends IView {
        //得到用户填写的信息
        String getUsername();
        String getPassword();

        //显示和隐藏登录ProgressBar
        void showLoading();
        void hideLoading();

        //登录成功或失败后，返回信息的方法
        void showSuccessMsg(UserBean user);
        void showFailedMsg(String s);

        //清楚数据
        void clearEditText();
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface LoginModel extends IModel {
        void login(String username,String password,OnLoginListener onLoginListener);
        interface OnLoginListener {
            void loginSuccess(UserBean user);
            void loginFailed(String s);
        }
    }
}
