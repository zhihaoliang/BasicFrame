package com.zhihaoliang.basicframe.mode;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by haoliang on 2017/9/29.
 * email:zhihaoliang07@163.com
 * @author zhihaoliang
 */

public class BaseMode implements Parcelable {

    protected BaseMode(Parcel in) {
    }

    public static final Creator<BaseMode> CREATOR = new Creator<BaseMode>() {
        @Override
        public BaseMode createFromParcel(Parcel in) {
            return new BaseMode(in);
        }

        @Override
        public BaseMode[] newArray(int size) {
            return new BaseMode[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
