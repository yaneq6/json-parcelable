package com.yaneq6.jsonparcelable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by janek on 18.11.14.
 */
public class JsonHelper {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


    public static <T>T Deserialize(Class<T> clazz, String json) {
        T t;
        try {
            t = OBJECT_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            t = null;
            e.printStackTrace();
        }
        return t;
    }

    public static <T>T Deserialize(Class<T> clazz, InputStream inputStream) {
        T t;
        try {
            t = OBJECT_MAPPER.readValue(inputStream, clazz);
        } catch (IOException e) {
            t = null;
            e.printStackTrace();
        }
        return t;
    }

    public static boolean Deserialize(Object o, String json) {
        boolean b;
        try {
            OBJECT_MAPPER.readerForUpdating(o).readValue(json);
            b = true;
        } catch (IOException e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }

    public static String Serialize(Object o) {
        String json;
        try {
            json = OBJECT_MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            json = null;
            e.printStackTrace();
        }
        return json;
    }

}
