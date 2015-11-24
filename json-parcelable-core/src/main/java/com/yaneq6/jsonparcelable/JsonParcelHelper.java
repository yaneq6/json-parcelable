package com.yaneq6.jsonparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class JsonParcelHelper {

    public static class Creator<T extends Parcelable> implements Parcelable.Creator {

        @Override
        public Object createFromParcel(Parcel source) {
            try {
                Class<T> parceledClass = (Class<T>)Class.forName(source.readString());
                T model = parceledClass.newInstance();
                ReadFromParcel(model, source);
                return model;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public Object[] newArray(int size) {
            return new Object[size];
        }
    }

    public static <T extends Parcelable>void WriteToParcel(T model, Parcel out) {
        out.writeString(model.getClass().getName());
        out.writeString(JsonHelper.Serialize(model));

    }

    public static <T extends Parcelable>void ReadFromParcel(T model, Parcel in) {
        String json = in.readString();
        JsonHelper.Deserialize(model, json);
    }
}