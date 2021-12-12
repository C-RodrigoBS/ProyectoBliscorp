package com.example.myapplication;

public class Data {
    String key;
    String[] value;

    public Data(String key, String[] value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(String[] value) {
        this.value = value;
    }


}
