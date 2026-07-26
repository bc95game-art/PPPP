package com.google.gson;

import androidx.fragment.app.LogWriter;
import com.google.gson.internal.bind.JsonElementTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
/* loaded from: classes.dex */
public abstract class JsonElement {
    public final JsonObject getAsJsonObject() {
        if (this instanceof JsonObject) {
            return (JsonObject) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public final JsonPrimitive getAsJsonPrimitive() {
        if (this instanceof JsonPrimitive) {
            return (JsonPrimitive) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String getAsString() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            JsonWriter jsonWriter = new JsonWriter(new LogWriter(sb));
            jsonWriter.strictness = 1;
            TypeAdapters.JSON_ELEMENT.getClass();
            JsonElementTypeAdapter.write(this, jsonWriter);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
