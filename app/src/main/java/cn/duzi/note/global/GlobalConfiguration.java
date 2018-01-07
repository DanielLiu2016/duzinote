package cn.duzi.note.global;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.jess.arms.base.delegate.AppLifecycles;
import com.jess.arms.di.module.GlobalConfigModule;
import com.jess.arms.integration.ConfigModule;

import java.util.List;

/**
 * Simple to Introduction
 *
 * @ProjectName: duzinote
 * @Package: cn.duzi.note.global
 * @Description: 用来给框架配置各种自定义属性和功能
 * @Author: Majest
 * @CreateDate: 2018/1/6 22:12
 * @UpdateUser: Majest
 * @UpdateDate: 2018/1/6 22:12
 * @UpdateRemark: 首次创建
 * @Version: v1.0
 */

public class GlobalConfiguration implements ConfigModule {
    @Override
    public void applyOptions(Context context, GlobalConfigModule.Builder builder) {
        //使用builder可以为框架配置一些配置信息
    }

    @Override
    public void injectAppLifecycle(Context context, List<AppLifecycles> lifecycles) {
        //向Application的生命周期中注入一些自定义逻辑
    }

    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles) {
        //向Activity的生命周期中注入一些自定义逻辑
    }

    @Override
    public void injectFragmentLifecycle(Context context, List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {
        //向Fragment的生命周期中注入一些自定义逻辑
    }
}
