package com.google.gson.internal.bind;

import com.google.android.gms.tasks.zzr;
import com.google.gson.Gson;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.reflect.TypeToken;
import p004j$.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    public static final DummyTypeAdapterFactory TREE_TYPE_CLASS_DUMMY_FACTORY = new DummyTypeAdapterFactory(0);
    public static final DummyTypeAdapterFactory TREE_TYPE_FIELD_DUMMY_FACTORY = new DummyTypeAdapterFactory(0);
    public final ConcurrentHashMap adapterFactoryMap = new ConcurrentHashMap();
    public final zzr constructorConstructor;

    /* loaded from: classes.dex */
    public class DummyTypeAdapterFactory implements TypeAdapterFactory {
        private DummyTypeAdapterFactory() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter create(Gson gson, TypeToken typeToken) {
            throw new AssertionError("Factory should not be used");
        }

        public /* synthetic */ DummyTypeAdapterFactory(int i) {
            this();
        }
    }

    public JsonAdapterAnnotationTypeAdapterFactory(zzr zzrVar) {
        this.constructorConstructor = zzrVar;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(Gson gson, TypeToken typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter, true);
    }

    public final TypeAdapter getTypeAdapter(zzr zzrVar, Gson gson, TypeToken typeToken, JsonAdapter jsonAdapter, boolean z) {
        TypeAdapter typeAdapter;
        JsonSerializer jsonSerializer;
        DummyTypeAdapterFactory dummyTypeAdapterFactory;
        Object construct = zzrVar.get(TypeToken.get(jsonAdapter.value()), true).construct();
        boolean nullSafe = jsonAdapter.nullSafe();
        if (construct instanceof TypeAdapter) {
            typeAdapter = (TypeAdapter) construct;
        } else if (construct instanceof TypeAdapterFactory) {
            TypeAdapterFactory typeAdapterFactory = (TypeAdapterFactory) construct;
            if (z) {
                TypeAdapterFactory typeAdapterFactory2 = (TypeAdapterFactory) this.adapterFactoryMap.putIfAbsent(typeToken.getRawType(), typeAdapterFactory);
                if (typeAdapterFactory2 != null) {
                    typeAdapterFactory = typeAdapterFactory2;
                }
            }
            typeAdapter = typeAdapterFactory.create(gson, typeToken);
        } else {
            boolean z2 = construct instanceof JsonSerializer;
            if (z2) {
                if (z2) {
                    jsonSerializer = (JsonSerializer) construct;
                } else {
                    jsonSerializer = null;
                }
                JsonSerializer jsonSerializer2 = jsonSerializer;
                if (z) {
                    dummyTypeAdapterFactory = TREE_TYPE_CLASS_DUMMY_FACTORY;
                } else {
                    dummyTypeAdapterFactory = TREE_TYPE_FIELD_DUMMY_FACTORY;
                }
                TreeTypeAdapter treeTypeAdapter = new TreeTypeAdapter(jsonSerializer2, gson, typeToken, dummyTypeAdapterFactory, nullSafe);
                nullSafe = false;
                typeAdapter = treeTypeAdapter;
            } else {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + construct.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
        }
        if (typeAdapter == null || !nullSafe) {
            return typeAdapter;
        }
        return typeAdapter.nullSafe();
    }
}
