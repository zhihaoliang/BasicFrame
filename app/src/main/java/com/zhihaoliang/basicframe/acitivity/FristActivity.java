package com.zhihaoliang.basicframe.acitivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhihaoliang.basicframe.R;

/**
 * Created by haoliang on 2017/10/16.
 * email:zhihaoliang07@163.com
 * @author zhihaoliang
 *
 * 当应用第一次启动时展示用户协议的界面
 */
public class FristActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist);
    }
}
