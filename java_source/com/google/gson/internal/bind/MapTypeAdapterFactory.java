package com.google.gson.internal.bind;

import androidx.transition.ViewUtilsApi21;
import com.google.android.gms.tasks.zzr;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;
/* loaded from: classes.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {
    public final /* synthetic */ int $r8$classId;
    public final zzr constructorConstructor;

    public /* synthetic */ MapTypeAdapterFactory(zzr zzrVar, int i) {
        this.$r8$classId = i;
        this.constructorConstructor = zzrVar;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(Gson gson, TypeToken typeToken) {
        Type[] typeArr;
        TypeAdapter typeAdapter;
        int i = this.$r8$classId;
        zzr zzrVar = this.constructorConstructor;
        Type type = Object.class;
        switch (i) {
            case 0:
                Type type2 = typeToken.getType();
                Class rawType = typeToken.getRawType();
                if (!Map.class.isAssignableFrom(rawType)) {
                    return null;
                }
                if (Properties.class.isAssignableFrom(rawType)) {
                    typeArr = new Type[]{String.class, String.class};
                } else {
                    Type supertype = Streams.getSupertype(type2, rawType, Map.class);
                    typeArr = supertype instanceof ParameterizedType ? ((ParameterizedType) supertype).getActualTypeArguments() : new Type[]{type, type};
                }
                Type type3 = typeArr[0];
                Type type4 = typeArr[1];
                if (type3 == Boolean.TYPE || type3 == Boolean.class) {
                    typeAdapter = TypeAdapters.BOOLEAN_AS_STRING;
                } else {
                    typeAdapter = gson.getAdapter(TypeToken.get(type3));
                }
                return new Adapter(this, new Adapter(gson, typeAdapter, type3), new Adapter(gson, gson.getAdapter(TypeToken.get(type4)), type4), zzrVar.get(typeToken, false));
            default:
                Type type5 = typeToken.getType();
                Class rawType2 = typeToken.getRawType();
                if (!Collection.class.isAssignableFrom(rawType2)) {
                    return null;
                }
                Type supertype2 = Streams.getSupertype(type5, rawType2, Collection.class);
                if (supertype2 instanceof ParameterizedType) {
                    type = ((ParameterizedType) supertype2).getActualTypeArguments()[0];
                }
                return new TypeAdapters$32$1(new Adapter(gson, gson.getAdapter(TypeToken.get(type)), type), zzrVar.get(typeToken, false));
        }
    }

    /* loaded from: classes.dex */
    public final class Adapter extends TypeAdapter {
        public final /* synthetic */ int $r8$classId = 1;
        public final Object constructor;
        public final Object keyTypeAdapter;
        public final TypeAdapter valueTypeAdapter;

        public Adapter(Gson gson, TypeAdapter typeAdapter, Type type) {
            this.keyTypeAdapter = gson;
            this.valueTypeAdapter = typeAdapter;
            this.constructor = type;
        }

        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            switch (this.$r8$classId) {
                case 0:
                    int peek = jsonReader.peek();
                    if (peek == 9) {
                        jsonReader.nextNull();
                        return null;
                    }
                    Map map = (Map) ((ObjectConstructor) this.constructor).construct();
                    if (peek == 1) {
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            jsonReader.beginArray();
                            Object read = ((Adapter) this.keyTypeAdapter).valueTypeAdapter.read(jsonReader);
                            if (map.put(read, ((Adapter) this.valueTypeAdapter).valueTypeAdapter.read(jsonReader)) == null) {
                                jsonReader.endArray();
                            } else {
                                throw new RuntimeException("duplicate key: " + read);
                            }
                        }
                        jsonReader.endArray();
                    } else {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            ViewUtilsApi21.INSTANCE.getClass();
                            int i = jsonReader.peeked;
                            if (i == 0) {
                                i = jsonReader.doPeek();
                            }
                            if (i == 13) {
                                jsonReader.peeked = 9;
                            } else if (i == 12) {
                                jsonReader.peeked = 8;
                            } else if (i == 14) {
                                jsonReader.peeked = 10;
                            } else {
                                throw jsonReader.unexpectedTokenError("a name");
                            }
                            Object read2 = ((Adapter) this.keyTypeAdapter).valueTypeAdapter.read(jsonReader);
                            if (map.put(read2, ((Adapter) this.valueTypeAdapter).valueTypeAdapter.read(jsonReader)) != null) {
                                throw new RuntimeException("duplicate key: " + read2);
                            }
                        }
                        jsonReader.endObject();
                    }
                    return map;
                default:
                    return this.valueTypeAdapter.read(jsonReader);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
            if ((r1 instanceof com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter) == false) goto L25;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.reflect.Type] */
        @Override // com.google.gson.TypeAdapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void write(JsonWriter jsonWriter, Object obj) {
            Class<?> cls;
            TypeAdapter serializationDelegate;
            switch (this.$r8$classId) {
                case 0:
                    Map map = (Map) obj;
                    Adapter adapter = (Adapter) this.valueTypeAdapter;
                    if (map == null) {
                        jsonWriter.nullValue();
                        return;
                    }
                    jsonWriter.beginObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jsonWriter.name(String.valueOf(entry.getKey()));
                        adapter.write(jsonWriter, entry.getValue());
                    }
                    jsonWriter.endObject();
                    return;
                default:
                    ?? r0 = (Type) this.constructor;
                    if (obj == null || (!(r0 instanceof Class) && !(r0 instanceof TypeVariable))) {
                        cls = r0;
                    } else {
                        cls = obj.getClass();
                    }
                    TypeAdapter typeAdapter = this.valueTypeAdapter;
                    if (cls != r0) {
                        TypeAdapter adapter2 = ((Gson) this.keyTypeAdapter).getAdapter(TypeToken.get((Type) cls));
                        if (adapter2 instanceof ReflectiveTypeAdapterFactory.Adapter) {
                            TypeAdapter typeAdapter2 = typeAdapter;
                            while ((typeAdapter2 instanceof SerializationDelegatingTypeAdapter) && (serializationDelegate = ((SerializationDelegatingTypeAdapter) typeAdapter2).getSerializationDelegate()) != typeAdapter2) {
                                typeAdapter2 = serializationDelegate;
                            }
                            break;
                        }
                        typeAdapter = adapter2;
                    }
                    typeAdapter.write(jsonWriter, obj);
                    return;
            }
        }

        public Adapter(MapTypeAdapterFactory mapTypeAdapterFactory, Adapter adapter, Adapter adapter2, ObjectConstructor objectConstructor) {
            this.keyTypeAdapter = adapter;
            this.valueTypeAdapter = adapter2;
            this.constructor = objectConstructor;
        }
    }
}
