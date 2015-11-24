package com.yaneq6.jsonparcelable;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by janek on 18.11.14.
 */

public abstract class JsonParcelable implements JsonBody, Parcelable {

    public static final Creator<JsonParcelable> CREATOR = new JsonParcelHelper.Creator<JsonParcelable>();

    public JsonParcelable() {
    }

    public JsonParcelable(Parcel in) {
        JsonParcelHelper.ReadFromParcel(this, in);
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        JsonParcelHelper.WriteToParcel(this, out);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public String serialize() {
        return JsonHelper.Serialize(this);
    }

    @Override
    public void inflate(String json) {
        JsonHelper.Deserialize(this, json);
    }

    public static <T>T Deserialize(Class<T> type, String json) {
        return JsonHelper.Deserialize(type, json);
    }

    public static void Inflate(Object o, String json) {
        JsonHelper.Deserialize(o, json);
    }

    public void putJsonParcelable(Bundle extras) {
        extras.putParcelable(GetClassName(this), this);
    }

    public void putJsonParcelable(Intent data) {
        data.putExtra(GetClassName(this), this);
    }

    public static <T extends JsonParcelable>void PutJsonParcelable(Bundle extras, T... jsonParcelables) {
        for (T jsonParcelable : jsonParcelables) {
            extras.putParcelable(GetClassName(jsonParcelable), jsonParcelable);
        }
    }

    public static <T extends JsonParcelable>void PutJsonParcelable(Intent data, T... jsonParcelables) {
        for (T apiObject : jsonParcelables) {
            data.putExtra(GetClassName(apiObject), apiObject);
        }
    }

    public static <T extends JsonParcelable>Bundle ToBundle(T... jsonParcelables) {
        Bundle bundle = new Bundle();
        PutJsonParcelable(bundle, jsonParcelables);
        return bundle;
    }

    public static <T extends JsonParcelable> T GetJsonParcelable(Class<T> type, Bundle extras) {
        return extras.getParcelable(GetClassName(type));
    }

    public static <T extends JsonParcelable> T GetJsonParcelable(Class<T> type, Intent data) {
        return data.getParcelableExtra(GetClassName(type));
    }

    private static <T extends JsonParcelable>String GetClassName(Class<T> type) {
        return type.getName();
    }

    private static String GetClassName(Object o) {
        return o.getClass().getName();
    }

    @Override
    public String toString() {
        return serialize().toString();
    }
}
