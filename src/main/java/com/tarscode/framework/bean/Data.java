package com.tarscode.framework.bean;

/**
 * 返回数据对象
 * Created by liuyang on 17/3/14.
 */
public class Data {
    private Object model;

    //模型数据
    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
