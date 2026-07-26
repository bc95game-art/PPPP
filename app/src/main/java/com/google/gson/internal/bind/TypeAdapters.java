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
    public static final AnonymousClass29 JSON_ELEMENT_FACTORY;
    public static final AnonymousClass29 CLASS_FACTORY = new AnonymousClass29(Class.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.1
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("java-lang-class-unsupported"));
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + ((Class) obj).getName() + ". Forgot to register a type adapter?\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("java-lang-class-unsupported"));
        }
    }.nullSafe(), 0);
    public static final AnonymousClass29 BIT_SET_FACTORY = new AnonymousClass29(BitSet.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.2
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
                        StringBuilder m = ViewModelProvider.Factory.CC.m("Invalid bitset value ", nextInt, ", expected 0 or 1; at path ");
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
    public static final AnonymousClass4 BOOLEAN_AS_STRING = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.4
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
    public static final AnonymousClass30 BYTE_FACTORY = new AnonymousClass30(Byte.TYPE, Byte.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.5
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
                StringBuilder m = ViewModelProvider.Factory.CC.m("Lossy conversion from ", nextInt, " to byte; at path ");
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
    public static final AnonymousClass30 SHORT_FACTORY = new AnonymousClass30(Short.TYPE, Short.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.6
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
                StringBuilder m = ViewModelProvider.Factory.CC.m("Lossy conversion from ", nextInt, " to short; at path ");
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
    public static final AnonymousClass30 INTEGER_FACTORY = new AnonymousClass30(Integer.TYPE, Integer.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.7
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
    public static final AnonymousClass29 ATOMIC_INTEGER_FACTORY = new AnonymousClass29(AtomicInteger.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.8
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
    public static final AnonymousClass29 ATOMIC_BOOLEAN_FACTORY = new AnonymousClass29(AtomicBoolean.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.9
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            return new AtomicBoolean(jsonReader.nextBoolean());
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            jsonWriter.value(((AtomicBoolean) obj).get());
        }
    }.nullSafe(), 0);
    public static final AnonymousClass29 ATOMIC_INTEGER_ARRAY_FACTORY = new AnonymousClass29(AtomicIntegerArray.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.10
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
    public static final AnonymousClass11 LONG = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.11
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
    public static final AnonymousClass30 CHARACTER_FACTORY = new AnonymousClass30(Character.TYPE, Character.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.14
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
            StringBuilder m = ViewModelProvider.Factory.CC.m15m("Expecting character, got: ", nextString, "; at ");
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
    public static final AnonymousClass16 BIG_DECIMAL = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.16
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
                StringBuilder m = ViewModelProvider.Factory.CC.m15m("Failed parsing '", nextString, "' as BigDecimal; at path ");
                m.append(jsonReader.getPath(true));
                throw new RuntimeException(m.toString(), e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            jsonWriter.value((BigDecimal) obj);
        }
    };
    public static final AnonymousClass17 BIG_INTEGER = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.17
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
                StringBuilder m = ViewModelProvider.Factory.CC.m15m("Failed parsing '", nextString, "' as BigInteger; at path ");
                m.append(jsonReader.getPath(true));
                throw new RuntimeException(m.toString(), e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            jsonWriter.value((BigInteger) obj);
        }
    };
    public static final AnonymousClass18 LAZILY_PARSED_NUMBER = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.18
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
    public static final AnonymousClass29 STRING_BUILDER_FACTORY = new AnonymousClass29(StringBuilder.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.19
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
    public static final AnonymousClass29 STRING_BUFFER_FACTORY = new AnonymousClass29(StringBuffer.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.20
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
    public static final AnonymousClass29 URL_FACTORY = new AnonymousClass29(URL.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.21
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
    public static final AnonymousClass29 URI_FACTORY = new AnonymousClass29(URI.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.22
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
    public static final AnonymousClass29 INET_ADDRESS_FACTORY = new AnonymousClass29(InetAddress.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.23
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
    public static final AnonymousClass29 UUID_FACTORY = new AnonymousClass29(UUID.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.24
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
                StringBuilder m = ViewModelProvider.Factory.CC.m15m("Failed parsing '", nextString, "' as UUID; at path ");
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
    public static final AnonymousClass29 CURRENCY_FACTORY = new AnonymousClass29(Currency.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.25
        @Override // com.google.gson.TypeAdapter
        public final Object read(JsonReader jsonReader) {
            String nextString = jsonReader.nextString();
            try {
                return Currency.getInstance(nextString);
            } catch (IllegalArgumentException e) {
                StringBuilder m = ViewModelProvider.Factory.CC.m15m("Failed parsing '", nextString, "' as Currency; at path ");
                m.append(jsonReader.getPath(true));
                throw new RuntimeException(m.toString(), e);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter jsonWriter, Object obj) {
            jsonWriter.value(((Currency) obj).getCurrencyCode());
        }
    }.nullSafe(), 0);
    public static final AnonymousClass31 CALENDAR_FACTORY = new AnonymousClass31(0, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.26
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
            if (r1.equals("month") == false) goto L11;
         */
        @Override // com.google.gson.TypeAdapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object read(com.google.gson.stream.JsonReader r13) {
            /*
                r12 = this;
                int r0 = r13.peek()
                r1 = 9
                if (r0 != r1) goto Ld
                r13.nextNull()
                r13 = 0
                return r13
            Ld:
                r13.beginObject()
                r0 = 0
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
            L17:
                int r1 = r13.peek()
                r8 = 4
                if (r1 == r8) goto L82
                java.lang.String r1 = r13.nextName()
                int r9 = r13.nextInt()
                r1.getClass()
                int r10 = r1.hashCode()
                r11 = -1
                switch(r10) {
                    case -1181204563: goto L68;
                    case -1074026988: goto L5d;
                    case -906279820: goto L52;
                    case 3704893: goto L47;
                    case 104080000: goto L3e;
                    case 985252545: goto L33;
                    default: goto L31;
                }
            L31:
                r8 = -1
                goto L72
            L33:
                java.lang.String r8 = "hourOfDay"
                boolean r1 = r1.equals(r8)
                if (r1 != 0) goto L3c
                goto L31
            L3c:
                r8 = 5
                goto L72
            L3e:
                java.lang.String r10 = "month"
                boolean r1 = r1.equals(r10)
                if (r1 != 0) goto L72
                goto L31
            L47:
                java.lang.String r8 = "year"
                boolean r1 = r1.equals(r8)
                if (r1 != 0) goto L50
                goto L31
            L50:
                r8 = 3
                goto L72
            L52:
                java.lang.String r8 = "second"
                boolean r1 = r1.equals(r8)
                if (r1 != 0) goto L5b
                goto L31
            L5b:
                r8 = 2
                goto L72
            L5d:
                java.lang.String r8 = "minute"
                boolean r1 = r1.equals(r8)
                if (r1 != 0) goto L66
                goto L31
            L66:
                r8 = 1
                goto L72
            L68:
                java.lang.String r8 = "dayOfMonth"
                boolean r1 = r1.equals(r8)
                if (r1 != 0) goto L71
                goto L31
            L71:
                r8 = 0
            L72:
                switch(r8) {
                    case 0: goto L80;
                    case 1: goto L7e;
                    case 2: goto L7c;
                    case 3: goto L7a;
                    case 4: goto L78;
                    case 5: goto L76;
                    default: goto L75;
                }
            L75:
                goto L17
            L76:
                r5 = r9
                goto L17
            L78:
                r3 = r9
                goto L17
            L7a:
                r2 = r9
                goto L17
            L7c:
                r7 = r9
                goto L17
            L7e:
                r6 = r9
                goto L17
            L80:
                r4 = r9
                goto L17
            L82:
                r13.endObject()
                java.util.GregorianCalendar r1 = new java.util.GregorianCalendar
                r1.<init>(r2, r3, r4, r5, r6, r7)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.TypeAdapters.AnonymousClass26.read(com.google.gson.stream.JsonReader):java.lang.Object");
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
    public static final AnonymousClass29 LOCALE_FACTORY = new AnonymousClass29(Locale.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.27
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
    public static final EnumTypeAdapter.AnonymousClass1 ENUM_FACTORY = EnumTypeAdapter.FACTORY;
    public static final AnonymousClass30 BOOLEAN_FACTORY = new AnonymousClass30(Boolean.TYPE, Boolean.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.3
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
    public static final AnonymousClass29 STRING_FACTORY = new AnonymousClass29(String.class, new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.15
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

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$29  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass29 implements TypeAdapterFactory {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object val$type;
        public final /* synthetic */ TypeAdapter val$typeAdapter;

        public /* synthetic */ AnonymousClass29(Object obj, TypeAdapter typeAdapter, int i) {
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

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$30  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass30 implements TypeAdapterFactory {
        public final /* synthetic */ Class val$boxed;
        public final /* synthetic */ TypeAdapter val$typeAdapter;
        public final /* synthetic */ Class val$unboxed;

        public AnonymousClass30(Class cls, Class cls2, TypeAdapter typeAdapter) {
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

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$31  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass31 implements TypeAdapterFactory {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object val$typeAdapter;

        public /* synthetic */ AnonymousClass31(int i, Object obj) {
            this.$r8$classId = i;
            this.val$typeAdapter = obj;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter create(Gson gson, TypeToken typeToken) {
            switch (this.$r8$classId) {
                case 0:
                    Class rawType = typeToken.getRawType();
                    if (rawType == Calendar.class || rawType == GregorianCalendar.class) {
                        return (AnonymousClass26) this.val$typeAdapter;
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
                    return "Factory[type=" + Calendar.class.getName() + "+" + GregorianCalendar.class.getName() + ",adapter=" + ((AnonymousClass26) this.val$typeAdapter) + "]";
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
        JSON_ELEMENT_FACTORY = new AnonymousClass29(JsonElement.class, jsonElementTypeAdapter, 1);
    }
}
