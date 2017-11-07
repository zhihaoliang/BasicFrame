package com.zhihaoliang.basicframe;

/**
 * Created by haoliang on 2017/10/26.
 * email:zhihaoliang07@163.com
 *
 * @author zhihaoliang
 */

public interface Config {
    /***
     * 表示为测试版本
     */
    int ST_DEBUG = 1;
    /**
     * 表示为正式版本
     */
    int ST_PRODUCT = 2;
    /**
     * 表示当前的版本状态
     */
    int STATE = ST_DEBUG;
}
