package com.google.gson.internal.bind;

import androidx.transition.Transition;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
/* loaded from: classes.dex */
public final class TreeTypeAdapter extends SerializationDelegatingTypeAdapter {
    public final Transition.AnonymousClass1 context = new Transition.AnonymousClass1(19);
    public volatile TypeAdapter delegate;
    public final Gson gson;
    public final boolean nullSafe;
    public final JsonSerializer serializer;
    public final TypeAdapterFactory skipPastForGetDelegateAdapter;
    public final TypeToken typeToken;

    /* loaded from: classes.dex */
    public final class SingleTypeFactory implements TypeAdapterFactory {
        public final TypeToken exactType;
        public final boolean matchRawType;
        public final JsonSerializer serializer;

        public SingleTypeFactory(JsonSerializer jsonSerializer, TypeToken typeToken, boolean z) {
            this.serializer = jsonSerializer;
            this.exactType = typeToken;
            this.matchRawType = z;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter create(Gson gson, TypeToken typeToken) {
            TypeToken typeToken2 = this.exactType;
            if (typeToken2.equals(typeToken) || (this.matchRawType && typeToken2.getType() == typeToken.getRawType())) {
                return new TreeTypeAdapter(this.serializer, gson, typeToken, this, true);
            }
            return null;
        }
    }

    public TreeTypeAdapter(JsonSerializer jsonSerializer, Gson gson, TypeToken typeToken, TypeAdapterFactory typeAdapterFactory, boolean z) {
        this.serializer = jsonSerializer;
        this.gson = gson;
        this.typeToken = typeToken;
        this.skipPastForGetDelegateAdapter = typeAdapterFactory;
        this.nullSafe = z;
    }

    @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
    public final TypeAdapter getSerializationDelegate() {
        if (this.serializer != null) {
            return this;
        }
        TypeAdapter typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter delegateAdapter = this.gson.getDelegateAdapter(this.skipPastForGetDelegateAdapter, this.typeToken);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) {
        TypeAdapter typeAdapter = this.delegate;
        if (typeAdapter == null) {
            typeAdapter = this.gson.getDelegateAdapter(this.skipPastForGetDelegateAdapter, this.typeToken);
            this.delegate = typeAdapter;
        }
        return typeAdapter.read(jsonReader);
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        JsonSerializer jsonSerializer = this.serializer;
        if (jsonSerializer == null) {
            TypeAdapter typeAdapter = this.delegate;
            if (typeAdapter == null) {
                typeAdapter = this.gson.getDelegateAdapter(this.skipPastForGetDelegateAdapter, this.typeToken);
                this.delegate = typeAdapter;
            }
            typeAdapter.write(jsonWriter, obj);
        } else if (!this.nullSafe || obj != null) {
            JsonElement serialize = jsonSerializer.serialize(obj, this.typeToken.getType(), this.context);
            TypeAdapters.JSON_ELEMENT.getClass();
            JsonElementTypeAdapter.write(serialize, jsonWriter);
        } else {
            jsonWriter.nullValue();
        }
    }
}
