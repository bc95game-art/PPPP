package com.google.gson;

import androidx.lifecycle.ViewModelProvider;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* loaded from: classes.dex */
public abstract class ToNumberPolicy extends Enum {
    public static final /* synthetic */ ToNumberPolicy[] $VALUES;
    public static final C02301 DOUBLE;
    public static final C02312 LAZILY_PARSED_NUMBER;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.gson.ToNumberPolicy$1] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.gson.ToNumberPolicy$2] */
    static {
        ?? r0 = new ToNumberPolicy() { // from class: com.google.gson.ToNumberPolicy.1
            @Override // com.google.gson.ToNumberPolicy
            public final Number readNumber(JsonReader jsonReader) {
                return Double.valueOf(jsonReader.nextDouble());
            }
        };
        DOUBLE = r0;
        ?? r1 = new ToNumberPolicy() { // from class: com.google.gson.ToNumberPolicy.2
            @Override // com.google.gson.ToNumberPolicy
            public final Number readNumber(JsonReader jsonReader) {
                return new LazilyParsedNumber(jsonReader.nextString());
            }
        };
        LAZILY_PARSED_NUMBER = r1;
        $VALUES = new ToNumberPolicy[]{r0, r1, new ToNumberPolicy() { // from class: com.google.gson.ToNumberPolicy.3
            public static Double parseAsDouble(String str, JsonReader jsonReader) {
                try {
                    Double valueOf = Double.valueOf(str);
                    if (!valueOf.isInfinite()) {
                        if (valueOf.isNaN()) {
                        }
                        return valueOf;
                    }
                    if (jsonReader.strictness != 1) {
                        throw new IOException("JSON forbids NaN and infinities: " + valueOf + "; at path " + jsonReader.getPath(true));
                    }
                    return valueOf;
                } catch (NumberFormatException e) {
                    StringBuilder m = ViewModelProvider.Factory.CC.m594m("Cannot parse ", str, "; at path ");
                    m.append(jsonReader.getPath(true));
                    throw new RuntimeException(m.toString(), e);
                }
            }

            @Override // com.google.gson.ToNumberPolicy
            public final Number readNumber(JsonReader jsonReader) {
                String nextString = jsonReader.nextString();
                if (nextString.indexOf(46) >= 0) {
                    return parseAsDouble(nextString, jsonReader);
                }
                try {
                    return Long.valueOf(Long.parseLong(nextString));
                } catch (NumberFormatException unused) {
                    return parseAsDouble(nextString, jsonReader);
                }
            }
        }, new ToNumberPolicy() { // from class: com.google.gson.ToNumberPolicy.4
            @Override // com.google.gson.ToNumberPolicy
            public final Number readNumber(JsonReader jsonReader) {
                String nextString = jsonReader.nextString();
                try {
                    return Streams.parseBigDecimal(nextString);
                } catch (NumberFormatException e) {
                    StringBuilder m = ViewModelProvider.Factory.CC.m594m("Cannot parse ", nextString, "; at path ");
                    m.append(jsonReader.getPath(true));
                    throw new RuntimeException(m.toString(), e);
                }
            }
        }};
    }

    public static ToNumberPolicy valueOf(String str) {
        return (ToNumberPolicy) Enum.valueOf(ToNumberPolicy.class, str);
    }

    public static ToNumberPolicy[] values() {
        return (ToNumberPolicy[]) $VALUES.clone();
    }

    public abstract Number readNumber(JsonReader jsonReader);
}
