package com.yaneq6.jsonparcelable.internal;

import android.os.Parcel;

import com.yaneq6.jsonparcelable.JsonParcelable;

/**
 * Created by janek on 24.11.15.
 */
public class JsonParcelableObject extends JsonParcelable {

    private int integer;
    private boolean bool;
    private String string;
    private int[] arr;

    public JsonParcelableObject() {
    }

    public JsonParcelableObject(int integer, boolean bool, String string, int[] arr) {
        this.integer = integer;
        this.bool = bool;
        this.string = string;
        this.arr = arr;
    }

    public int getInteger() {
        return integer;
    }

    public boolean isBool() {
        return bool;
    }

    public String getString() {
        return string;
    }

    public int[] getArr() {
        return arr;
    }
}
