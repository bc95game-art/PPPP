package com.google.firebase.encoders.proto;
/* JADX WARN: Method from annotation default annotation not found: intEncoding */
/* loaded from: classes.dex */
public @interface Protobuf {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes.dex */
    public final class IntEncoding extends Enum {
        public static final /* synthetic */ IntEncoding[] $VALUES;
        public static final IntEncoding DEFAULT;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, com.google.firebase.encoders.proto.Protobuf$IntEncoding] */
        static {
            ?? r0 = new Enum("DEFAULT", 0);
            DEFAULT = r0;
            $VALUES = new IntEncoding[]{r0, new Enum("SIGNED", 1), new Enum("FIXED", 2)};
        }

        public static IntEncoding valueOf(String str) {
            return (IntEncoding) Enum.valueOf(IntEncoding.class, str);
        }

        public static IntEncoding[] values() {
            return (IntEncoding[]) $VALUES.clone();
        }
    }
}
