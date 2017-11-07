package com.zhihaoliang.basicframe.event;

import android.os.Parcel;
import android.os.Parcelable;

import com.zhihaoliang.basicframe.mode.BaseMode;

/**
 * Created by haoliang on 2017/9/29.
 * email:zhihaoliang07@163.com
 * @author zhihaoliang
 */

public  class EventBase <T extends BaseMode> implements Parcelable{
    private T mBaseMode;

    private String mName;

    public EventBase(T baseMode,String name){
        mBaseMode = baseMode;
        mName = name;
    }

    public EventBase(Parcel in) {
        mBaseMode = getT(in);
        mName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mBaseMode, flags);
        dest.writeString(mName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<EventBase> CREATOR = new Creator<EventBase>() {
        @Override
        public EventBase createFromParcel(Parcel in) {
            return new EventBase(in);
        }

        @Override
        public EventBase[] newArray(int size) {
            return new EventBase[size];
        }
    };

    public T getBaseMode() {
        return mBaseMode;
    }

    public void setBaseMode(T baseMode) {
        this.mBaseMode = baseMode;
    }

    public String getName() {
        return mName;
    }

    public void setmName(String name) {
        this.mName = name;
    }


    public T getT(Parcel in){
        return null;
    }




}
