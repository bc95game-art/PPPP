package com.maxmind.p003db;

import java.io.IOException;
/* renamed from: com.maxmind.db.InvalidDatabaseException */
/* loaded from: classes.dex */
public class InvalidDatabaseException extends IOException {
    private static final long serialVersionUID = 6161763462364823003L;

    public InvalidDatabaseException(String str) {
        super(str);
    }

    public InvalidDatabaseException(String str, Throwable th) {
        super(str, th);
    }
}
