package com.zhihaoliang.basicframe.util;

import com.zhihaoliang.basicframe.acitivity.base.BaseActivity;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 * Created by haoliang on 2017/9/29.
 * email:zhihaoliang07@163.com
 * @author zhihaoliang
 */

public class AppManager {

    /**
     *用于存放所有的Activity
     */
    private static final ArrayList<SoftReference> ARRAY_LIST = new ArrayList<>();


    /**
     * 添加Activity 在Activity OnCreate
     */
    public static final void addActivity(BaseActivity baseActivity){
        SoftReference<BaseActivity> softReference = new SoftReference<BaseActivity>(baseActivity);
        ARRAY_LIST.add(softReference);
    }
    
    public static final void closeActivity(){
        for (int i = ARRAY_LIST.size() - 1; i >= 0; i--) {
            SoftReference softReference = ARRAY_LIST.get(i);
            Object object = softReference.get();
            if(object == null){
                ARRAY_LIST.remove(i);
                continue;
            }
            ARRAY_LIST.remove(i);
            BaseActivity baseActivity = (BaseActivity) object;
            baseActivity.finish();
        }
    }

    public static void removeActivity(BaseActivity baseActivity){
        for (int i = ARRAY_LIST.size() - 1; i >= 0; i--) {
            SoftReference softReference = ARRAY_LIST.get(i);
            Object object = softReference.get();
            if(object == null){
                ARRAY_LIST.remove(i);
                continue;
            }

            if(baseActivity == object){
                ARRAY_LIST.remove(i);
                break;
            }
        }
    }

}
