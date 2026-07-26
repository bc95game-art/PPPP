package com.google.gson.internal.bind;

import androidx.transition.ViewUtilsApi21;
import com.google.android.gms.tasks.zzr;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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
            To view partially-correct add '--show-bad-code' argument
        */
        public final void write(com.google.gson.stream.JsonWriter r5, java.lang.Object r6) {
            /*
                r4 = this;
                int r0 = r4.$r8$classId
                switch(r0) {
                    case 0: goto L49;
                    default: goto L5;
                }
            L5:
                java.lang.Object r0 = r4.constructor
                java.lang.reflect.Type r0 = (java.lang.reflect.Type) r0
                if (r6 == 0) goto L18
                boolean r1 = r0 instanceof java.lang.Class
                if (r1 != 0) goto L13
                boolean r1 = r0 instanceof java.lang.reflect.TypeVariable
                if (r1 == 0) goto L18
            L13:
                java.lang.Class r1 = r6.getClass()
                goto L19
            L18:
                r1 = r0
            L19:
                com.google.gson.TypeAdapter r2 = r4.valueTypeAdapter
                if (r1 == r0) goto L45
                java.lang.Object r0 = r4.keyTypeAdapter
                com.google.gson.Gson r0 = (com.google.gson.Gson) r0
                com.google.gson.reflect.TypeToken r1 = com.google.gson.reflect.TypeToken.get(r1)
                com.google.gson.TypeAdapter r0 = r0.getAdapter(r1)
                boolean r1 = r0 instanceof com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
                if (r1 != 0) goto L2e
                goto L44
            L2e:
                r1 = r2
            L2f:
                boolean r3 = r1 instanceof com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
                if (r3 == 0) goto L3f
                r3 = r1
                com.google.gson.internal.bind.SerializationDelegatingTypeAdapter r3 = (com.google.gson.internal.bind.SerializationDelegatingTypeAdapter) r3
                com.google.gson.TypeAdapter r3 = r3.getSerializationDelegate()
                if (r3 != r1) goto L3d
                goto L3f
            L3d:
                r1 = r3
                goto L2f
            L3f:
                boolean r1 = r1 instanceof com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
                if (r1 != 0) goto L44
                goto L45
            L44:
                r2 = r0
            L45:
                r2.write(r5, r6)
                return
            L49:
                java.util.Map r6 = (java.util.Map) r6
                com.google.gson.TypeAdapter r0 = r4.valueTypeAdapter
                com.google.gson.internal.bind.MapTypeAdapterFactory$Adapter r0 = (com.google.gson.internal.bind.MapTypeAdapterFactory.Adapter) r0
                if (r6 != 0) goto L55
                r5.nullValue()
                goto L82
            L55:
                r5.beginObject()
                java.util.Set r6 = r6.entrySet()
                java.util.Iterator r6 = r6.iterator()
            L60:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L7f
                java.lang.Object r1 = r6.next()
                java.util.Map$Entry r1 = (java.util.Map.Entry) r1
                java.lang.Object r2 = r1.getKey()
                java.lang.String r2 = java.lang.String.valueOf(r2)
                r5.name(r2)
                java.lang.Object r1 = r1.getValue()
                r0.write(r5, r1)
                goto L60
            L7f:
                r5.endObject()
            L82:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.MapTypeAdapterFactory.Adapter.write(com.google.gson.stream.JsonWriter, java.lang.Object):void");
        }

        public Adapter(MapTypeAdapterFactory mapTypeAdapterFactory, Adapter adapter, Adapter adapter2, ObjectConstructor objectConstructor) {
            this.keyTypeAdapter = adapter;
            this.valueTypeAdapter = adapter2;
            this.constructor = objectConstructor;
        }
    }
}
