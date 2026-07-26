package com.maxmind.p003db;
/* renamed from: com.maxmind.db.DeserializationException */
/* loaded from: classes.dex */
public class DeserializationException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public DeserializationException() {
        super("Database value cannot be deserialized into the type.");
    }

    public DeserializationException(String str) {
        super(str);
    }
}
