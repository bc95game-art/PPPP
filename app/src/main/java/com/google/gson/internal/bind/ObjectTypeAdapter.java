package com.google.gson.internal.bind;

import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.Gson;
import com.google.gson.ToNumberPolicy;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class ObjectTypeAdapter extends TypeAdapter {
    public static final TypeAdapters.AnonymousClass31 DOUBLE_FACTORY = new TypeAdapters.AnonymousClass31(2, ToNumberPolicy.DOUBLE);
    public final Gson gson;
    public final ToNumberPolicy toNumberStrategy;

    public ObjectTypeAdapter(Gson gson, ToNumberPolicy toNumberPolicy) {
        this.gson = gson;
        this.toNumberStrategy = toNumberPolicy;
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) {
        Object obj;
        String str;
        Serializable serializable;
        boolean z;
        int peek = jsonReader.peek();
        int ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(peek);
        if (ordinal == 0) {
            jsonReader.beginArray();
            obj = new ArrayList();
        } else if (ordinal != 2) {
            obj = null;
        } else {
            jsonReader.beginObject();
            obj = new LinkedTreeMap(true);
        }
        if (obj == null) {
            return readTerminal(jsonReader, peek);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (jsonReader.hasNext()) {
                if (obj instanceof Map) {
                    str = jsonReader.nextName();
                } else {
                    str = null;
                }
                int peek2 = jsonReader.peek();
                int ordinal2 = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(peek2);
                if (ordinal2 == 0) {
                    jsonReader.beginArray();
                    serializable = new ArrayList();
                } else if (ordinal2 != 2) {
                    serializable = null;
                } else {
                    jsonReader.beginObject();
                    serializable = new LinkedTreeMap(true);
                }
                if (serializable != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (serializable == null) {
                    serializable = readTerminal(jsonReader, peek2);
                }
                if (obj instanceof List) {
                    ((List) obj).add(serializable);
                } else {
                    ((Map) obj).put(str, serializable);
                }
                if (z) {
                    arrayDeque.addLast(obj);
                    obj = serializable;
                }
            } else {
                if (obj instanceof List) {
                    jsonReader.endArray();
                } else {
                    jsonReader.endObject();
                }
                if (arrayDeque.isEmpty()) {
                    return obj;
                }
                obj = arrayDeque.removeLast();
            }
        }
    }

    public final Serializable readTerminal(JsonReader jsonReader, int i) {
        int ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(i);
        if (ordinal == 5) {
            return jsonReader.nextString();
        }
        if (ordinal == 6) {
            return this.toNumberStrategy.readNumber(jsonReader);
        }
        if (ordinal == 7) {
            return Boolean.valueOf(jsonReader.nextBoolean());
        }
        if (ordinal == 8) {
            jsonReader.nextNull();
            return null;
        }
        throw new IllegalStateException("Unexpected token: ".concat(ViewModelProvider.Factory.CC.stringValueOf$4(i)));
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        Class<?> cls = obj.getClass();
        Gson gson = this.gson;
        gson.getClass();
        TypeAdapter adapter = gson.getAdapter(TypeToken.get((Class) cls));
        if (adapter instanceof ObjectTypeAdapter) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
            return;
        }
        adapter.write(jsonWriter, obj);
    }
}
