package com.feagle.learn.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Feagle on 2017/7/16.
 */
public class MyGenericList<T> extends ArrayList {
    private T data;

    public MyGenericList() {
    }

    public MyGenericList(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
