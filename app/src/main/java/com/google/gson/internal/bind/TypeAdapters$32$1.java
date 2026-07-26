package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.Collection;
/* loaded from: classes.dex */
public final class TypeAdapters$32$1 extends TypeAdapter {
    public final /* synthetic */ int $r8$classId = 1;
    public final Object this$0;
    public final Object val$requestedType;

    public TypeAdapters$32$1(MapTypeAdapterFactory.Adapter adapter, ObjectConstructor objectConstructor) {
        this.val$requestedType = adapter;
        this.this$0 = objectConstructor;
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) {
        switch (this.$r8$classId) {
            case 0:
                Class cls = (Class) this.val$requestedType;
                Object read = ((TypeAdapters.AnonymousClass29) this.this$0).val$typeAdapter.read(jsonReader);
                if (read == null || cls.isInstance(read)) {
                    return read;
                }
                throw new RuntimeException("Expected a " + cls.getName() + " but was " + read.getClass().getName() + "; at path " + jsonReader.getPath(true));
            default:
                if (jsonReader.peek() == 9) {
                    jsonReader.nextNull();
                    return null;
                }
                Collection collection = (Collection) ((ObjectConstructor) this.this$0).construct();
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    collection.add(((MapTypeAdapterFactory.Adapter) this.val$requestedType).valueTypeAdapter.read(jsonReader));
                }
                jsonReader.endArray();
                return collection;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((TypeAdapters.AnonymousClass29) this.this$0).val$typeAdapter.write(jsonWriter, obj);
                return;
            default:
                Collection<Object> collection = (Collection) obj;
                if (collection == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginArray();
                for (Object obj2 : collection) {
                    ((MapTypeAdapterFactory.Adapter) this.val$requestedType).write(jsonWriter, obj2);
                }
                jsonWriter.endArray();
                return;
        }
    }

    public TypeAdapters$32$1(TypeAdapters.AnonymousClass29 r2, Class cls) {
        this.this$0 = r2;
        this.val$requestedType = cls;
    }
}
