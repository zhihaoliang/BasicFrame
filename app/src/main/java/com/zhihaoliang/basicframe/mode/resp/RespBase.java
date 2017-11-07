package com.zhihaoliang.basicframe.mode.resp;

/**
 * Created by haoliang on 2017/10/26.
 * email:zhihaoliang07@163.com
 *
 * @author zhihaoliang
 *
 * 请求返回值的基类
 */

public class RespBase {
    /**
     * 表示是否请求成功
     */
    private boolean success;
    /**
     * 请求失败或者成功的信息
     */
    private boolean msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isMsg() {
        return msg;
    }

    public void setMsg(boolean msg) {
        this.msg = msg;
    }
}
