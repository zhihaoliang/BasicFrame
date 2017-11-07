package com.zhihaoliang.basicframe.acitivity.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.zhihaoliang.basicframe.R;
import com.zhihaoliang.basicframe.event.EventHandler;
import com.zhihaoliang.basicframe.util.AppManager;


/**
 * Created by haoliang on 2017/9/29.
 * email:zhihaoliang07@163.com
 * @author zhihaoliang
 */

public class BaseActivity extends AppCompatActivity {

    private EventHandler[] mEventHandlers;

    private Toolbar mToolbar;

    /**
     * 加载数据时的loading
     */
    private Dialog mLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppManager.addActivity(this);
    }

    /**
     * 设置状态栏
     *
     * @param title 状态栏的标题
     */
    public void initTitle(String title) {
        initTitle(title, R.mipmap.ic_title_back_white);
    }

    /**
     * 设置状态栏
     *
     * @param title   状态栏的标题
     * @param navIcon 导航按钮 Navigation icon
     */
    public void initTitle(String title, final int navIcon) {
        if (mToolbar == null) {
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(mToolbar);
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayShowTitleEnabled(false);
                actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
                actionBar.setDisplayShowCustomEnabled(true);
            }
        }

        if (mToolbar == null) {
            return;
        }

        if (navIcon != -1) {
            mToolbar.setNavigationIcon(navIcon);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hideIMM(v);
                    onNavClick();
                }
            });
        } else {
            mToolbar.setNavigationIcon(null);
        }

        if (!TextUtils.isEmpty(title)) {
            ((TextView) findViewById(R.id.tv_title)).setText(title);
        }
    }

    /**
     * 点击导航按钮 Navigation icon 进行操作，默认的是返回操作
     */
    public void onNavClick() {
        onBackPressed();
    }

    /**
     * 关闭键盘
     */
    protected void hideIMM(View v) {
        if (v != null) {
            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        }
    }

    /***
     * Activity 跳转Activity方法
     * @param cls 目的界面
     */
    public void startActivity(Class<? extends Activity> cls) {
        startActivity(cls,null);
    }

    /**
     * Activity 跳转Activity方法
     * @param cls 目的界面
     * @param bundle 所有传递的数值
     */
    public void startActivity(Class<? extends Activity> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        overridePendingTransition(R.anim.activity_in_right, R.anim.activity_out_left);
    }

    /**
     * 如果acitiviy需要响应eventbus消息，需要重写此方法。
     * 返回参数是EventHandler数组，每一类Event需要一个EventHandler
     */
    public EventHandler[] genEventHandlers() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mEventHandlers != null) {
            for (EventHandler eventHandler : mEventHandlers) {
                org.greenrobot.eventbus.EventBus.getDefault().unregister(eventHandler);
            }
        }
    }

    @Override
    public void finish() {
        AppManager.removeActivity(this);
        super.finish();
    }

}
