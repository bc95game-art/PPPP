package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class ArrayTypeAdapter extends TypeAdapter {
    public static final C02391 FACTORY = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter create(Gson gson, TypeToken typeToken) {
            Type type;
            Type type2 = typeToken.getType();
            boolean z = type2 instanceof GenericArrayType;
            if (!z && (!(type2 instanceof Class) || !((Class) type2).isArray())) {
                return null;
            }
            if (z) {
                type = ((GenericArrayType) type2).getGenericComponentType();
            } else {
                type = ((Class) type2).getComponentType();
            }
            return new ArrayTypeAdapter(gson, gson.getAdapter(TypeToken.get(type)), Streams.getRawType(type));
        }
    };
    public final Class componentType;
    public final MapTypeAdapterFactory.Adapter componentTypeAdapter;

    public ArrayTypeAdapter(Gson gson, TypeAdapter typeAdapter, Class cls) {
        this.componentTypeAdapter = new MapTypeAdapterFactory.Adapter(gson, typeAdapter, cls);
        this.componentType = cls;
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) {
        if (jsonReader.peek() == 9) {
            jsonReader.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.componentTypeAdapter.valueTypeAdapter.read(jsonReader));
        }
        jsonReader.endArray();
        int size = arrayList.size();
        Class cls = this.componentType;
        if (!cls.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance(cls, size));
        }
        Object newInstance = Array.newInstance(cls, size);
        for (int i = 0; i < size; i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.componentTypeAdapter.write(jsonWriter, Array.get(obj, i));
        }
        jsonWriter.endArray();
    }
}
