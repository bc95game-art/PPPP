package com.maxmind.p003db;
/* renamed from: com.maxmind.db.Type */
/* loaded from: classes.dex */
enum Type {
    EXTENDED,
    POINTER,
    UTF8_STRING,
    DOUBLE,
    BYTES,
    UINT16,
    UINT32,
    MAP,
    INT32,
    UINT64,
    UINT128,
    ARRAY,
    CONTAINER,
    END_MARKER,
    BOOLEAN,
    FLOAT;
    
    static final Type[] values = values();

    public static Type fromControlByte(int i) {
        return get((byte) ((i & 255) >>> 5));
    }

    public static Type get(int i) {
        Type[] typeArr = values;
        if (i < typeArr.length) {
            return typeArr[i];
        }
        throw new InvalidDatabaseException("The MaxMind DB file's data section contains bad data");
    }

    private static Type get(byte b) {
        return get(b & 255);
    }
}
