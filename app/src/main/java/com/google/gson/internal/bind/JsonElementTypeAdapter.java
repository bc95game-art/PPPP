package com.google.gson.internal.bind;

import androidx.collection.ArrayMap;
import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.LinkedTreeMap$KeySet$1;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class JsonElementTypeAdapter extends TypeAdapter {
    public static final JsonElementTypeAdapter ADAPTER = new JsonElementTypeAdapter();

    private JsonElementTypeAdapter() {
    }

    public static JsonElement readTerminal(JsonReader jsonReader, int i) {
        int ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(i);
        if (ordinal == 5) {
            return new JsonPrimitive(jsonReader.nextString());
        }
        if (ordinal == 6) {
            return new JsonPrimitive(new LazilyParsedNumber(jsonReader.nextString()));
        }
        if (ordinal == 7) {
            return new JsonPrimitive(Boolean.valueOf(jsonReader.nextBoolean()));
        }
        if (ordinal == 8) {
            jsonReader.nextNull();
            return JsonNull.INSTANCE;
        }
        throw new IllegalStateException("Unexpected token: ".concat(ViewModelProvider.Factory.CC.stringValueOf$4(i)));
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) {
        JsonElement jsonElement;
        String str;
        JsonElement jsonElement2;
        boolean z;
        int peek = jsonReader.peek();
        int ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(peek);
        if (ordinal == 0) {
            jsonReader.beginArray();
            jsonElement = new JsonArray();
        } else if (ordinal != 2) {
            jsonElement = null;
        } else {
            jsonReader.beginObject();
            jsonElement = new JsonObject();
        }
        if (jsonElement == null) {
            return readTerminal(jsonReader, peek);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (jsonReader.hasNext()) {
                if (jsonElement instanceof JsonObject) {
                    str = jsonReader.nextName();
                } else {
                    str = null;
                }
                int peek2 = jsonReader.peek();
                int ordinal2 = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(peek2);
                if (ordinal2 == 0) {
                    jsonReader.beginArray();
                    jsonElement2 = new JsonArray();
                } else if (ordinal2 != 2) {
                    jsonElement2 = null;
                } else {
                    jsonReader.beginObject();
                    jsonElement2 = new JsonObject();
                }
                if (jsonElement2 != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (jsonElement2 == null) {
                    jsonElement2 = readTerminal(jsonReader, peek2);
                }
                if (jsonElement instanceof JsonArray) {
                    ((JsonArray) jsonElement).elements.add(jsonElement2);
                } else {
                    ((JsonObject) jsonElement).add(str, jsonElement2);
                }
                if (z) {
                    arrayDeque.addLast(jsonElement);
                    jsonElement = jsonElement2;
                }
            } else {
                if (jsonElement instanceof JsonArray) {
                    jsonReader.endArray();
                } else {
                    jsonReader.endObject();
                }
                if (arrayDeque.isEmpty()) {
                    return jsonElement;
                }
                jsonElement = (JsonElement) arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final /* bridge */ /* synthetic */ void write(JsonWriter jsonWriter, Object obj) {
        write((JsonElement) obj, jsonWriter);
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) {
        boolean z;
        if (jsonElement == null || (jsonElement instanceof JsonNull)) {
            jsonWriter.nullValue();
        } else if (jsonElement instanceof JsonPrimitive) {
            JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
            Serializable serializable = asJsonPrimitive.value;
            if (serializable instanceof Number) {
                jsonWriter.value(asJsonPrimitive.getAsNumber());
            } else if (serializable instanceof Boolean) {
                if (serializable instanceof Boolean) {
                    z = ((Boolean) serializable).booleanValue();
                } else {
                    z = Boolean.parseBoolean(asJsonPrimitive.getAsString());
                }
                jsonWriter.value(z);
            } else {
                jsonWriter.value(asJsonPrimitive.getAsString());
            }
        } else {
            boolean z2 = jsonElement instanceof JsonArray;
            if (z2) {
                jsonWriter.beginArray();
                if (z2) {
                    ArrayList arrayList = ((JsonArray) jsonElement).elements;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        write((JsonElement) obj, jsonWriter);
                    }
                    jsonWriter.endArray();
                    return;
                }
                throw new IllegalStateException("Not a JSON Array: " + jsonElement);
            } else if (jsonElement instanceof JsonObject) {
                jsonWriter.beginObject();
                Iterator it = ((ArrayMap.EntrySet) jsonElement.getAsJsonObject().members.entrySet()).iterator();
                while (((LinkedTreeMap$KeySet$1) it).hasNext()) {
                    LinkedTreeMap.Node nextNode = ((LinkedTreeMap$KeySet$1) it).nextNode();
                    jsonWriter.name((String) nextNode.getKey());
                    write((JsonElement) nextNode.getValue(), jsonWriter);
                }
                jsonWriter.endObject();
            } else {
                throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
            }
        }
    }
}
