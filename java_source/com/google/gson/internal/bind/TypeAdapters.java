package com.google.gson.internal.bind;

import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.ToNumberPolicy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.EnumTypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
/* loaded from: classes.dex */
public abstract class TypeAdapters {
    public static final JsonElementTypeAdapter JSON_ELEMENT;
    public static final C026429 JSON_ELEMENT_FACTORY;
    public static final C026429 CLASS_FACTORY = new C026429(Class.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.1
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("java-lang-class-unsupported"));
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + ((Class) obj).getName() + ". Forgot to register a type adapter?\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("java-lang-class-unsupported"));
        }
    }.nullSafe(), 0);
    public static final C026429 BIT_SET_FACTORY = new C026429(BitSet.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.2
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            boolean z;
            BitSet bitSet = new BitSet();
            jsonReader.beginArray();
            int peek = jsonReader.peek();
            int i = 0;
            while (peek != 2) {
                int ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(peek);
                if (ordinal == 5 || ordinal == 6) {
                    int nextInt = jsonReader.nextInt();
                    if (nextInt == 0) {
                        z = false;
                    } else if (nextInt == 1) {
                        z = true;
                    } else {
                        StringBuilder m = ViewModelProvider.Factory.CC.m598m("Invalid bitset value ", nextInt, ", expected 0 or 1; at path ");
                        m.append(jsonReader.getPath(true));
                        throw new RuntimeException(m.toString());
                    }
                } else if (ordinal == 7) {
                    z = jsonReader.nextBoolean();
                } else {
                    throw new RuntimeException("Invalid bitset value type: " + ViewModelProvider.Factory.CC.stringValueOf$4(peek) + "; at path " + jsonReader.getPath(false));
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                peek = jsonReader.peek();
            }
            jsonReader.endArray();
            return bitSet;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            BitSet bitSet = (BitSet) obj;
            jsonWriter.beginArray();
            int length = bitSet.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.value(bitSet.get(i) ? 1L : 0L);
            }
            jsonWriter.endArray();
        }
    }.nullSafe(), 0);
    public static final C02684 BOOLEAN_AS_STRING = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.4
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            if (jsonReader.peek() != 9) {
                return Boolean.valueOf(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            String str;
            Boolean bool = (Boolean) obj;
            if (bool == null) {
                str = "null";
            } else {
                str = bool.toString();
            }
            jsonWriter.value(str);
        }
    };
    public static final C026630 BYTE_FACTORY = new C026630(Byte.TYPE, Byte.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.5
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            if (jsonReader.peek() == 9) {
                jsonReader.nextNull();
                return null;
            }
            try {
                int nextInt = jsonReader.nextInt();
                if (nextInt <= 255 && nextInt >= -128) {
                    return Byte.valueOf((byte) nextInt);
                }
                StringBuilder m = ViewModelProvider.Factory.CC.m598m("Lossy conversion from ", nextInt, " to byte; at path ");
                m.append(jsonReader.getPath(true));
                throw new RuntimeException(m.toString());
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            Number number = (Number) obj;
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.byteValue());
            }
        }
    });
    public static final C026630 SHORT_FACTORY = new C026630(Short.TYPE, Short.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.6
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            if (jsonReader.peek() == 9) {
                jsonReader.nextNull();
                return null;
            }
            try {
                int nextInt = jsonReader.nextInt();
                if (nextInt <= 65535 && nextInt >= -32768) {
                    return Short.valueOf((short) nextInt);
                }
                StringBuilder m = ViewModelProvider.Factory.CC.m598m("Lossy conversion from ", nextInt, " to short; at path ");
                m.append(jsonReader.getPath(true));
                throw new RuntimeException(m.toString());
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            Number number = (Number) obj;
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.shortValue());
            }
        }
    });
    public static final C026630 INTEGER_FACTORY = new C026630(Integer.TYPE, Integer.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.7
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            if (jsonReader.peek() == 9) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            Number number = (Number) obj;
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.intValue());
            }
        }
    });
    public static final C026429 ATOMIC_INTEGER_FACTORY = new C026429(AtomicInteger.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.8
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            try {
                return new AtomicInteger(jsonReader.nextInt());
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            jsonWriter.value(((AtomicInteger) obj).get());
        }
    }.nullSafe(), 0);
    public static final C026429 ATOMIC_BOOLEAN_FACTORY = new C026429(AtomicBoolean.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.9
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            return new AtomicBoolean(jsonReader.nextBoolean());
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            jsonWriter.value(((AtomicBoolean) obj).get());
        }
    }.nullSafe(), 0);
    public static final C026429 ATOMIC_INTEGER_ARRAY_FACTORY = new C026429(AtomicIntegerArray.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.10
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(jsonReader.nextInt()));
                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                }
            }
            jsonReader.endArray();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i = 0; i < size; i++) {
                atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
            jsonWriter.beginArray();
            int length = atomicIntegerArray.length();
            for (int i = 0; i < length; i++) {
                jsonWriter.value(atomicIntegerArray.get(i));
            }
            jsonWriter.endArray();
        }
    }.nullSafe(), 0);
    public static final C024611 LONG = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.11
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            if (jsonReader.peek() == 9) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.nextLong());
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            Number number = (Number) obj;
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.longValue());
            }
        }
    };
    public static final C026630 CHARACTER_FACTORY = new C026630(Character.TYPE, Character.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.14
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            if (jsonReader.peek() == 9) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if (nextString.length() == 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            StringBuilder m = ViewModelProvider.Factory.CC.m594m("Expecting character, got: ", nextString, "; at ");
            m.append(jsonReader.getPath(true));
            throw new RuntimeException(m.toString());
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            String str;
            Character ch = (Character) obj;
            if (ch == null) {
                str = null;
            } else {
                str = String.valueOf(ch);
            }
            jsonWriter.value(str);
        }
    });
    public static final C025116 BIG_DECIMAL = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.16
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            if (jsonReader.peek() == 9) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            try {
                return Streams.parseBigDecimal(nextString);
            } catch (NumberFormatException e) {
                StringBuilder m = ViewModelProvider.Factory.CC.m594m("Failed parsing '", nextString, "' as BigDecimal; at path ");
                m.append(jsonReader.getPath(true));
                throw new RuntimeException(m.toString(), e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            jsonWriter.value((BigDecimal) obj);
        }
    };
    public static final C025217 BIG_INTEGER = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.17
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            if (jsonReader.peek() == 9) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            try {
                Streams.checkNumberStringLength(nextString);
                return new BigInteger(nextString);
            } catch (NumberFormatException e) {
                StringBuilder m = ViewModelProvider.Factory.CC.m594m("Failed parsing '", nextString, "' as BigInteger; at path ");
                m.append(jsonReader.getPath(true));
                throw new RuntimeException(m.toString(), e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            jsonWriter.value((BigInteger) obj);
        }
    };
    public static final C025318 LAZILY_PARSED_NUMBER = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.18
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            if (jsonReader.peek() != 9) {
                return new LazilyParsedNumber(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            jsonWriter.value((LazilyParsedNumber) obj);
        }
    };
    public static final C026429 STRING_BUILDER_FACTORY = new C026429(StringBuilder.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.19
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            if (jsonReader.peek() != 9) {
                return new StringBuilder(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            String str;
            StringBuilder sb = (StringBuilder) obj;
            if (sb == null) {
                str = null;
            } else {
                str = sb.toString();
            }
            jsonWriter.value(str);
        }
    }, 0);
    public static final C026429 STRING_BUFFER_FACTORY = new C026429(StringBuffer.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.20
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            if (jsonReader.peek() != 9) {
                return new StringBuffer(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            String str;
            StringBuffer stringBuffer = (StringBuffer) obj;
            if (stringBuffer == null) {
                str = null;
            } else {
                str = stringBuffer.toString();
            }
            jsonWriter.value(str);
        }
    }, 0);
    public static final C026429 URL_FACTORY = new C026429(URL.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.21
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            if (jsonReader.peek() == 9) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            if (nextString.equals("null")) {
                return null;
            }
            return new URL(nextString);
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            String str;
            URL url = (URL) obj;
            if (url == null) {
                str = null;
            } else {
                str = url.toExternalForm();
            }
            jsonWriter.value(str);
        }
    }, 0);
    public static final C026429 URI_FACTORY = new C026429(URI.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.22
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            if (jsonReader.peek() == 9) {
                jsonReader.nextNull();
                return null;
            }
            try {
                String nextString = jsonReader.nextString();
                if (nextString.equals("null")) {
                    return null;
                }
                return new URI(nextString);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            String str;
            URI uri = (URI) obj;
            if (uri == null) {
                str = null;
            } else {
                str = uri.toASCIIString();
            }
            jsonWriter.value(str);
        }
    }, 0);
    public static final C026429 INET_ADDRESS_FACTORY = new C026429(InetAddress.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.23
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            if (jsonReader.peek() != 9) {
                return InetAddress.getByName(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            String str;
            InetAddress inetAddress = (InetAddress) obj;
            if (inetAddress == null) {
                str = null;
            } else {
                str = inetAddress.getHostAddress();
            }
            jsonWriter.value(str);
        }
    }, 1);
    public static final C026429 UUID_FACTORY = new C026429(UUID.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.24
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            if (jsonReader.peek() == 9) {
                jsonReader.nextNull();
                return null;
            }
            String nextString = jsonReader.nextString();
            try {
                return UUID.fromString(nextString);
            } catch (IllegalArgumentException e) {
                StringBuilder m = ViewModelProvider.Factory.CC.m594m("Failed parsing '", nextString, "' as UUID; at path ");
                m.append(jsonReader.getPath(true));
                throw new RuntimeException(m.toString(), e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            String str;
            UUID uuid = (UUID) obj;
            if (uuid == null) {
                str = null;
            } else {
                str = uuid.toString();
            }
            jsonWriter.value(str);
        }
    }, 0);
    public static final C026429 CURRENCY_FACTORY = new C026429(Currency.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.25
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            String nextString = jsonReader.nextString();
            try {
                return Currency.getInstance(nextString);
            } catch (IllegalArgumentException e) {
                StringBuilder m = ViewModelProvider.Factory.CC.m594m("Failed parsing '", nextString, "' as Currency; at path ");
                m.append(jsonReader.getPath(true));
                throw new RuntimeException(m.toString(), e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            jsonWriter.value(((Currency) obj).getCurrencyCode());
        }
    }.nullSafe(), 0);
    public static final C026731 CALENDAR_FACTORY = new C026731(0, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.26
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
            if (r1.equals("month") == false) goto L11;
         */
        @Override // com.google.gson.TypeAdapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object read(JsonReader jsonReader) {
            if (jsonReader.peek() == 9) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                char c = 4;
                if (jsonReader.peek() != 4) {
                    String nextName = jsonReader.nextName();
                    int nextInt = jsonReader.nextInt();
                    nextName.getClass();
                    switch (nextName.hashCode()) {
                        case -1181204563:
                            if (nextName.equals("dayOfMonth")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1074026988:
                            if (nextName.equals("minute")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case -906279820:
                            if (nextName.equals("second")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3704893:
                            if (nextName.equals("year")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 104080000:
                            break;
                        case 985252545:
                            if (nextName.equals("hourOfDay")) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            i3 = nextInt;
                            break;
                        case 1:
                            i5 = nextInt;
                            break;
                        case 2:
                            i6 = nextInt;
                            break;
                        case 3:
                            i = nextInt;
                            break;
                        case 4:
                            i2 = nextInt;
                            break;
                        case 5:
                            i4 = nextInt;
                            break;
                    }
                } else {
                    jsonReader.endObject();
                    return new GregorianCalendar(i, i2, i3, i4, i5, i6);
                }
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            Calendar calendar = (Calendar) obj;
            if (calendar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("year");
            jsonWriter.value(calendar.get(1));
            jsonWriter.name("month");
            jsonWriter.value(calendar.get(2));
            jsonWriter.name("dayOfMonth");
            jsonWriter.value(calendar.get(5));
            jsonWriter.name("hourOfDay");
            jsonWriter.value(calendar.get(11));
            jsonWriter.name("minute");
            jsonWriter.value(calendar.get(12));
            jsonWriter.name("second");
            jsonWriter.value(calendar.get(13));
            jsonWriter.endObject();
        }
    });
    public static final C026429 LOCALE_FACTORY = new C026429(Locale.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.27
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            String str;
            String str2;
            String str3 = null;
            if (jsonReader.peek() == 9) {
                jsonReader.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), "_");
            if (stringTokenizer.hasMoreElements()) {
                str = stringTokenizer.nextToken();
            } else {
                str = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                str2 = stringTokenizer.nextToken();
            } else {
                str2 = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                str3 = stringTokenizer.nextToken();
            }
            if (str2 == null && str3 == null) {
                return new Locale(str);
            }
            if (str3 == null) {
                return new Locale(str, str2);
            }
            return new Locale(str, str2, str3);
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            String str;
            Locale locale = (Locale) obj;
            if (locale == null) {
                str = null;
            } else {
                str = locale.toString();
            }
            jsonWriter.value(str);
        }
    }, 0);
    public static final EnumTypeAdapter.C02421 ENUM_FACTORY = EnumTypeAdapter.FACTORY;
    public static final C026630 BOOLEAN_FACTORY = new C026630(Boolean.TYPE, Boolean.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.3
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            int peek = jsonReader.peek();
            if (peek == 9) {
                jsonReader.nextNull();
                return null;
            } else if (peek == 6) {
                return Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString()));
            } else {
                return Boolean.valueOf(jsonReader.nextBoolean());
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            String str;
            Boolean bool = (Boolean) obj;
            if (bool == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.writeDeferredName();
            jsonWriter.beforeValue();
            Writer writer = jsonWriter.out;
            if (bool.booleanValue()) {
                str = "true";
            } else {
                str = "false";
            }
            writer.write(str);
        }
    });
    public static final C026429 STRING_FACTORY = new C026429(String.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.15
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            int peek = jsonReader.peek();
            if (peek == 9) {
                jsonReader.nextNull();
                return null;
            } else if (peek == 8) {
                return Boolean.toString(jsonReader.nextBoolean());
            } else {
                return jsonReader.nextString();
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            jsonWriter.value((String) obj);
        }
    }, 0);

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$29 */
    /* loaded from: classes.dex */
    public final class C026429 implements TypeAdapterFactory {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object val$type;
        public final /* synthetic */ TypeAdapter val$typeAdapter;

        public /* synthetic */ C026429(Object obj, TypeAdapter typeAdapter, int i) {
            this.$r8$classId = i;
            this.val$type = obj;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter create(Gson gson, TypeToken typeToken) {
            switch (this.$r8$classId) {
                case 0:
                    if (typeToken.getRawType() == ((Class) this.val$type)) {
                        return this.val$typeAdapter;
                    }
                    return null;
                case 1:
                    Class<?> rawType = typeToken.getRawType();
                    if (!((Class) this.val$type).isAssignableFrom(rawType)) {
                        return null;
                    }
                    return new TypeAdapters$32$1(this, rawType);
                default:
                    if (typeToken.equals((TypeToken) this.val$type)) {
                        return this.val$typeAdapter;
                    }
                    return null;
            }
        }

        public String toString() {
            switch (this.$r8$classId) {
                case 0:
                    return "Factory[type=" + ((Class) this.val$type).getName() + ",adapter=" + this.val$typeAdapter + "]";
                case 1:
                    return "Factory[typeHierarchy=" + ((Class) this.val$type).getName() + ",adapter=" + this.val$typeAdapter + "]";
                default:
                    return super.toString();
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$30 */
    /* loaded from: classes.dex */
    public final class C026630 implements TypeAdapterFactory {
        public final /* synthetic */ Class val$boxed;
        public final /* synthetic */ TypeAdapter val$typeAdapter;
        public final /* synthetic */ Class val$unboxed;

        public C026630(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.val$unboxed = cls;
            this.val$boxed = cls2;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter create(Gson gson, TypeToken typeToken) {
            Class rawType = typeToken.getRawType();
            if (rawType == this.val$unboxed || rawType == this.val$boxed) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public final String toString() {
            return "Factory[type=" + this.val$boxed.getName() + "+" + this.val$unboxed.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$31 */
    /* loaded from: classes.dex */
    public final class C026731 implements TypeAdapterFactory {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object val$typeAdapter;

        public /* synthetic */ C026731(int i, Object obj) {
            this.$r8$classId = i;
            this.val$typeAdapter = obj;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter create(Gson gson, TypeToken typeToken) {
            switch (this.$r8$classId) {
                case 0:
                    Class rawType = typeToken.getRawType();
                    if (rawType == Calendar.class || rawType == GregorianCalendar.class) {
                        return (C026226) this.val$typeAdapter;
                    }
                    return null;
                case 1:
                    if (typeToken.getRawType() == Number.class) {
                        return (NumberTypeAdapter) this.val$typeAdapter;
                    }
                    return null;
                default:
                    if (typeToken.getRawType() == Object.class) {
                        return new ObjectTypeAdapter(gson, (ToNumberPolicy) this.val$typeAdapter);
                    }
                    return null;
            }
        }

        public String toString() {
            switch (this.$r8$classId) {
                case 0:
                    return "Factory[type=" + Calendar.class.getName() + "+" + GregorianCalendar.class.getName() + ",adapter=" + ((C026226) this.val$typeAdapter) + "]";
                default:
                    return super.toString();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [com.google.gson.internal.bind.TypeAdapters$11] */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.google.gson.internal.bind.TypeAdapters$16] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.google.gson.internal.bind.TypeAdapters$17] */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.google.gson.internal.bind.TypeAdapters$18] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.gson.internal.bind.TypeAdapters$4] */
    static {
        new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.12
            @Override // com.google.gson.TypeAdapter
            public final Object read(JsonReader jsonReader) {
                if (jsonReader.peek() != 9) {
                    return Float.valueOf((float) jsonReader.nextDouble());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(JsonWriter jsonWriter, Object obj) {
                Number number = (Number) obj;
                if (number == null) {
                    jsonWriter.nullValue();
                    return;
                }
                if (!(number instanceof Float)) {
                    number = Float.valueOf(number.floatValue());
                }
                jsonWriter.value(number);
            }
        };
        new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.13
            @Override // com.google.gson.TypeAdapter
            public final Object read(JsonReader jsonReader) {
                if (jsonReader.peek() != 9) {
                    return Double.valueOf(jsonReader.nextDouble());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void write(JsonWriter jsonWriter, Object obj) {
                Number number = (Number) obj;
                if (number == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value(number.doubleValue());
                }
            }
        };
        JsonElementTypeAdapter jsonElementTypeAdapter = JsonElementTypeAdapter.ADAPTER;
        JSON_ELEMENT = jsonElementTypeAdapter;
        JSON_ELEMENT_FACTORY = new C026429(JsonElement.class, jsonElementTypeAdapter, 1);
    }
}
