package com.google.gson.internal.bind;

import androidx.lifecycle.ViewModelProvider;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import j$.util.Objects;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes.dex */
public final class DefaultDateTypeAdapter extends TypeAdapter {
    public static final AnonymousClass1 DEFAULT_STYLE_FACTORY = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.DefaultDateTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter create(Gson gson, TypeToken typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new DefaultDateTypeAdapter(DateType.DATE, 2, 2);
            }
            return null;
        }

        public final String toString() {
            return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
        }
    };
    public final ArrayList dateFormats;
    public final DateType dateType;

    /* loaded from: classes.dex */
    public abstract class DateType {
        public static final AnonymousClass1 DATE = new DateType(Date.class);
        public final Class dateClass;

        /* renamed from: com.google.gson.internal.bind.DefaultDateTypeAdapter$DateType$1  reason: invalid class name */
        /* loaded from: classes.dex */
        public final class AnonymousClass1 extends DateType {
            @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType
            public final Date deserialize(Date date) {
                return date;
            }
        }

        public DateType(Class cls) {
            this.dateClass = cls;
        }

        public abstract Date deserialize(Date date);
    }

    public DefaultDateTypeAdapter(DateType dateType, int i, int i2) {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        Objects.requireNonNull(dateType);
        this.dateType = dateType;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i, i2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (JavaVersion.majorJavaVersion >= 9) {
            StringBuilder sb = new StringBuilder();
            if (i == 0) {
                str = "EEEE, MMMM d, yyyy";
            } else if (i == 1) {
                str = "MMMM d, yyyy";
            } else if (i == 2) {
                str = "MMM d, yyyy";
            } else if (i == 3) {
                str = "M/d/yy";
            } else {
                throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(i, "Unknown DateFormat style: "));
            }
            sb.append(str);
            sb.append(" ");
            if (i2 == 0 || i2 == 1) {
                str2 = "h:mm:ss a z";
            } else if (i2 == 2) {
                str2 = "h:mm:ss a";
            } else if (i2 == 3) {
                str2 = "h:mm a";
            } else {
                throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(i2, "Unknown DateFormat style: "));
            }
            sb.append(str2);
            arrayList.add(new SimpleDateFormat(sb.toString(), locale));
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader jsonReader) {
        Date parse;
        if (jsonReader.peek() == 9) {
            jsonReader.nextNull();
            return null;
        }
        String nextString = jsonReader.nextString();
        synchronized (this.dateFormats) {
            try {
                ArrayList arrayList = this.dateFormats;
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        DateFormat dateFormat = (DateFormat) obj;
                        TimeZone timeZone = dateFormat.getTimeZone();
                        try {
                            parse = dateFormat.parse(nextString);
                            dateFormat.setTimeZone(timeZone);
                            break;
                        } catch (ParseException unused) {
                            dateFormat.setTimeZone(timeZone);
                        }
                    } else {
                        try {
                            parse = ISO8601Utils.parse(nextString, new ParsePosition(0));
                            break;
                        } catch (ParseException e) {
                            StringBuilder m = ViewModelProvider.Factory.CC.m15m("Failed parsing '", nextString, "' as Date; at path ");
                            m.append(jsonReader.getPath(true));
                            throw new RuntimeException(m.toString(), e);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.dateType.deserialize(parse);
    }

    public final String toString() {
        DateFormat dateFormat = (DateFormat) this.dateFormats.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        String format;
        Date date = (Date) obj;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.dateFormats.get(0);
        synchronized (this.dateFormats) {
            format = dateFormat.format(date);
        }
        jsonWriter.value(format);
    }
}
