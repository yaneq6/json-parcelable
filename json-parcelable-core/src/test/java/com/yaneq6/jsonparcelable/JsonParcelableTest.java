package com.yaneq6.jsonparcelable;

import android.os.Bundle;

import com.yaneq6.jsonparcelable.internal.JsonParcelableObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
public class JsonParcelableTest {

    @Test
    public void shouldWriteToBundleAndRead() throws Exception {
        JsonParcelableObject jsonParcelable = new JsonParcelableObject(1, true, "string", new int[]{1, 2, 3});
        Bundle bundle = JsonParcelable.ToBundle(jsonParcelable);
        JsonParcelableObject fromParcel = JsonParcelable.GetJsonParcelable(JsonParcelableObject.class, bundle);
        assertEquals(jsonParcelable.isBool(), fromParcel.isBool());
        assertEquals(jsonParcelable.getInteger(), fromParcel.getInteger());
        assertEquals(jsonParcelable.getString(), fromParcel.getString());
        assertArrayEquals(jsonParcelable.getArr(), fromParcel.getArr());
    }
}