package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
/* loaded from: classes.dex */
public abstract class TypeAdapter {

    /* loaded from: classes.dex */
    public final class NullSafeTypeAdapter extends TypeAdapter {
        public NullSafeTypeAdapter() {
        }

        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            if (jsonReader.peek() != 9) {
                return TypeAdapter.this.read(jsonReader);
            }
            jsonReader.nextNull();
            return null;
        }

        public final String toString() {
            return "NullSafeTypeAdapter[" + TypeAdapter.this + "]";
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            if (obj == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter.this.write(jsonWriter, obj);
            }
        }
    }

    public final NullSafeTypeAdapter nullSafe() {
        if (!(this instanceof NullSafeTypeAdapter)) {
            return new NullSafeTypeAdapter();
        }
        return (NullSafeTypeAdapter) this;
    }

    public abstract Object read(JsonReader jsonReader);

    public abstract void write(JsonWriter jsonWriter, Object obj);
}
