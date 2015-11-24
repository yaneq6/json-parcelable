package com.yaneq6.jsonparcelable;

/**
 * Created by janek on 18.11.14.
 */
interface JsonBody {

    String serialize();
    void inflate(String json);

}
