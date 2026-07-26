package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.EncoderConfig;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
/* loaded from: classes.dex */
public final class JsonDataEncoderBuilder implements EncoderConfig {
    public final JsonDataEncoderBuilder$$ExternalSyntheticLambda0 fallbackEncoder = DEFAULT_FALLBACK_ENCODER;
    public boolean ignoreNullValues = false;
    public final HashMap objectEncoders;
    public final HashMap valueEncoders;
    public static final JsonDataEncoderBuilder$$ExternalSyntheticLambda0 DEFAULT_FALLBACK_ENCODER = new JsonDataEncoderBuilder$$ExternalSyntheticLambda0(0);
    public static final JsonDataEncoderBuilder$$ExternalSyntheticLambda1 STRING_ENCODER = new ValueEncoder() { // from class: com.google.firebase.encoders.json.JsonDataEncoderBuilder$$ExternalSyntheticLambda1
        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, Object obj2) {
            switch (r1) {
                case 0:
                    ((ValueEncoderContext) obj2).add((String) obj);
                    return;
                default:
                    ((ValueEncoderContext) obj2).add(((Boolean) obj).booleanValue());
                    return;
            }
        }
    };
    public static final JsonDataEncoderBuilder$$ExternalSyntheticLambda1 BOOLEAN_ENCODER = new ValueEncoder() { // from class: com.google.firebase.encoders.json.JsonDataEncoderBuilder$$ExternalSyntheticLambda1
        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, Object obj2) {
            switch (r1) {
                case 0:
                    ((ValueEncoderContext) obj2).add((String) obj);
                    return;
                default:
                    ((ValueEncoderContext) obj2).add(((Boolean) obj).booleanValue());
                    return;
            }
        }
    };
    public static final TimestampEncoder TIMESTAMP_ENCODER = new Object();

    /* loaded from: classes.dex */
    public final class TimestampEncoder implements ValueEncoder {
        public static final SimpleDateFormat rfc339;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            rfc339 = simpleDateFormat;
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        }

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, Object obj2) {
            ((ValueEncoderContext) obj2).add(rfc339.format((Date) obj));
        }
    }

    public JsonDataEncoderBuilder() {
        HashMap hashMap = new HashMap();
        this.objectEncoders = hashMap;
        HashMap hashMap2 = new HashMap();
        this.valueEncoders = hashMap2;
        hashMap2.put(String.class, STRING_ENCODER);
        hashMap.remove(String.class);
        hashMap2.put(Boolean.class, BOOLEAN_ENCODER);
        hashMap.remove(Boolean.class);
        hashMap2.put(Date.class, TIMESTAMP_ENCODER);
        hashMap.remove(Date.class);
    }

    public final EncoderConfig registerEncoder(Class cls, ObjectEncoder objectEncoder) {
        this.objectEncoders.put(cls, objectEncoder);
        this.valueEncoders.remove(cls);
        return this;
    }
}
