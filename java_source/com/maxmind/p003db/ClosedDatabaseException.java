package com.maxmind.p003db;

import java.io.IOException;
/* renamed from: com.maxmind.db.ClosedDatabaseException */
/* loaded from: classes.dex */
public class ClosedDatabaseException extends IOException {
    private static final long serialVersionUID = 1;

    public ClosedDatabaseException() {
        super("The MaxMind DB has been closed.");
    }
}
