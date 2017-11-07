package com.zhihaoliang.basicframe.acitivity;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhihaoliang.basicframe.R;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by haoliang on 2017/10/16.
 * email:zhihaoliang07@163.com
 * @author zhihaoliang
 */
@RuntimePermissions
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @NeedsPermission(Manifest.permission.CAMERA)
    void showCamera() {
    }

    @OnShowRationale(Manifest.permission.CAMERA)
    void showRationaleForCamera(final PermissionRequest request) {

    }

    @OnPermissionDenied(Manifest.permission.CAMERA)
    void showDeniedForCamera() {

    }

    @OnNeverAskAgain(Manifest.permission.CAMERA)
    void showNeverAskForCamera(){
    }
}
