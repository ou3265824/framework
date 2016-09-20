package com.example.framework.event;

import android.text.TextUtils;

/**
 * Created by Administrator on 2016/5/6.
 */
public class EventBusBean {

    private int type;
    private String targetClassName;// 目标类
    private String sendClassName;// 发送类

    public boolean equalsTargetName(String className) {
        return TextUtils.equals(className, targetClassName);
    }

    public boolean equalsSendName(String className) {
        return TextUtils.equals(className, sendClassName);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTargetClassName() {
        return targetClassName;
    }

    public void setTargetClassName(String targetClassName) {
        this.targetClassName = targetClassName;
    }

    public String getSendClassName() {
        return sendClassName;
    }

    public void setSendClassName(String sendClassName) {
        this.sendClassName = sendClassName;
    }
}
