package com.google.gson.internal.bind;

import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.ToNumberPolicy;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
/* loaded from: classes.dex */
public final class NumberTypeAdapter extends TypeAdapter {
    public static final TypeAdapters.C026731 LAZILY_PARSED_NUMBER_FACTORY = new TypeAdapters.C026731(1, new NumberTypeAdapter(ToNumberPolicy.LAZILY_PARSED_NUMBER));
    public final ToNumberPolicy toNumberStrategy;

    public NumberTypeAdapter(ToNumberPolicy toNumberPolicy) {
        this.toNumberStrategy = toNumberPolicy;
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) {
        int peek = jsonReader.peek();
        int ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(peek);
        if (ordinal == 5 || ordinal == 6) {
            return this.toNumberStrategy.readNumber(jsonReader);
        }
        if (ordinal == 8) {
            jsonReader.nextNull();
            return null;
        }
        throw new RuntimeException("Expecting number, got: " + ViewModelProvider.Factory.CC.stringValueOf$4(peek) + "; at path " + jsonReader.getPath(false));
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        jsonWriter.value((Number) obj);
    }
}
