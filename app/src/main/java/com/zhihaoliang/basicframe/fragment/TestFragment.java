package com.zhihaoliang.basicframe.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhihaoliang.basicframe.R;

/**
 * Created by haoliang on 2017/10/17.
 * email:zhihaoliang07@163.com
 * @author zhihaoliang
 */

public class TestFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView  = inflater.inflate(R.layout.fragment_test,null);

        View view = rootView.findViewById(R.id.basefragment);

        return rootView;
    }
}
