package com.zhihaoliang.basicframe.event;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by haoliang on 2017/10/16.
 * email:zhihaoliang07@163.com
 * @author zhihaoliang
 */

public interface EventHandler<T extends EventBase> {

    /**
     * eventbus消息响应方法的再封装
     * 集成的方法一定要写@Subscribe注解
     * @param event 传递的类型
     */
    @Subscribe
    void onEvent(T event);
}
