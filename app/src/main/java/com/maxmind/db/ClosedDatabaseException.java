package com.maxmind.db;

import java.io.IOException;
/* loaded from: classes.dex */
public class ClosedDatabaseException extends IOException {
    private static final long serialVersionUID = 1;

    public ClosedDatabaseException() {
        super("The MaxMind DB has been closed.");
    }
}
