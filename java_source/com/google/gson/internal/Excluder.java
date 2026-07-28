package com.google.gson.internal;

import androidx.lifecycle.ViewModelProvider;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    public final List deserializationStrategies;
    public final List serializationStrategies;

    public Excluder() {
        List list = Collections.EMPTY_LIST;
        this.serializationStrategies = list;
        this.deserializationStrategies = list;
    }

    public final Object clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        Class rawType = typeToken.getRawType();
        final boolean excludeClass = excludeClass(rawType, true);
        final boolean excludeClass2 = excludeClass(rawType, false);
        if (excludeClass || excludeClass2) {
            return new TypeAdapter() { // from class: com.google.gson.internal.Excluder.1
                public volatile TypeAdapter delegate;

                @Override // com.google.gson.TypeAdapter
                public final Object read(JsonReader jsonReader) {
                    if (excludeClass2) {
                        jsonReader.skipValue();
                        return null;
                    }
                    TypeAdapter typeAdapter = this.delegate;
                    if (typeAdapter == null) {
                        typeAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                        this.delegate = typeAdapter;
                    }
                    return typeAdapter.read(jsonReader);
                }

                @Override // com.google.gson.TypeAdapter
                public final void write(JsonWriter jsonWriter, Object obj) {
                    if (excludeClass) {
                        jsonWriter.nullValue();
                        return;
                    }
                    TypeAdapter typeAdapter = this.delegate;
                    if (typeAdapter == null) {
                        typeAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                        this.delegate = typeAdapter;
                    }
                    typeAdapter.write(jsonWriter, obj);
                }
            };
        }
        return null;
    }

    public final boolean excludeClass(Class cls, boolean z) {
        List list;
        if (!z && !Enum.class.isAssignableFrom(cls)) {
            LazyKt__LazyJVMKt lazyKt__LazyJVMKt = ReflectionHelper.RECORD_HELPER;
            if (!Modifier.isStatic(cls.getModifiers()) && (cls.isAnonymousClass() || cls.isLocalClass())) {
                return true;
            }
        }
        if (z) {
            list = this.serializationStrategies;
        } else {
            list = this.deserializationStrategies;
        }
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return false;
        }
        throw ViewModelProvider.Factory.CC.m592m(it);
    }
}
