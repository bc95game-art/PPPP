package com.google.gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.ToNumberPolicy;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class GsonBuilder {
    public final Excluder excluder = Excluder.DEFAULT;
    public final int longSerializationPolicy = 1;
    public final FieldNamingPolicy.C02201 fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
    public final HashMap instanceCreators = new HashMap();
    public final ArrayList factories = new ArrayList();
    public final ArrayList hierarchyFactories = new ArrayList();
    public final int dateStyle = 2;
    public final int timeStyle = 2;
    public final boolean escapeHtmlChars = true;
    public FormattingStyle formattingStyle = Gson.DEFAULT_FORMATTING_STYLE;
    public final boolean useJdkUnsafe = true;
    public final ToNumberPolicy.C02301 objectToNumberStrategy = Gson.DEFAULT_OBJECT_TO_NUMBER_STRATEGY;
    public final ToNumberPolicy.C02312 numberToNumberStrategy = Gson.DEFAULT_NUMBER_TO_NUMBER_STRATEGY;
    public final ArrayDeque reflectionFilters = new ArrayDeque();

    public GsonBuilder() {
        FormattingStyle formattingStyle = Gson.DEFAULT_FORMATTING_STYLE;
    }

    public final Gson create() {
        TypeAdapters.C026429 r10;
        TypeAdapters.C026429 r4;
        ArrayList arrayList = this.factories;
        int size = arrayList.size();
        ArrayList arrayList2 = this.hierarchyFactories;
        ArrayList arrayList3 = new ArrayList(arrayList2.size() + size + 3);
        arrayList3.addAll(arrayList);
        Collections.reverse(arrayList3);
        ArrayList arrayList4 = new ArrayList(arrayList2);
        Collections.reverse(arrayList4);
        arrayList3.addAll(arrayList4);
        boolean z = SqlTypesSupport.SUPPORTS_SQL_TYPES;
        int i = this.dateStyle;
        int i2 = this.timeStyle;
        if (!(i == 2 && i2 == 2)) {
            DefaultDateTypeAdapter defaultDateTypeAdapter = new DefaultDateTypeAdapter(DefaultDateTypeAdapter.DateType.DATE, i, i2);
            TypeAdapters.C026429 r6 = TypeAdapters.CLASS_FACTORY;
            TypeAdapters.C026429 r62 = new TypeAdapters.C026429(Date.class, defaultDateTypeAdapter, 0);
            if (z) {
                SqlTypesSupport.C02771 r5 = SqlTypesSupport.TIMESTAMP_DATE_TYPE;
                r5.getClass();
                r10 = new TypeAdapters.C026429(r5.dateClass, new DefaultDateTypeAdapter(r5, i, i2), 0);
                SqlTypesSupport.C02771 r52 = SqlTypesSupport.DATE_DATE_TYPE;
                r52.getClass();
                r4 = new TypeAdapters.C026429(r52.dateClass, new DefaultDateTypeAdapter(r52, i, i2), 0);
            } else {
                r10 = null;
                r4 = null;
            }
            arrayList3.add(r62);
            if (z) {
                arrayList3.add(r10);
                arrayList3.add(r4);
            }
        }
        HashMap hashMap = new HashMap(this.instanceCreators);
        FormattingStyle formattingStyle = this.formattingStyle;
        new ArrayList(arrayList);
        new ArrayList(arrayList2);
        return new Gson(this.excluder, this.fieldNamingPolicy, hashMap, this.escapeHtmlChars, formattingStyle, this.useJdkUnsafe, this.longSerializationPolicy, arrayList3, this.objectToNumberStrategy, this.numberToNumberStrategy, new ArrayList(this.reflectionFilters));
    }

    public final void registerTypeAdapter(Class cls, JsonSerializer jsonSerializer) {
        boolean z;
        if (cls != Object.class) {
            TypeToken<?> typeToken = TypeToken.get((Type) cls);
            if (typeToken.getType() == typeToken.getRawType()) {
                z = true;
            } else {
                z = false;
            }
            TreeTypeAdapter.SingleTypeFactory singleTypeFactory = new TreeTypeAdapter.SingleTypeFactory(jsonSerializer, typeToken, z);
            ArrayList arrayList = this.factories;
            arrayList.add(singleTypeFactory);
            if (jsonSerializer instanceof TypeAdapter) {
                TypeAdapters.C026429 r1 = TypeAdapters.CLASS_FACTORY;
                arrayList.add(new TypeAdapters.C026429(TypeToken.get((Type) cls), (TypeAdapter) jsonSerializer, 2));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Cannot override built-in adapter for " + cls);
    }
}
