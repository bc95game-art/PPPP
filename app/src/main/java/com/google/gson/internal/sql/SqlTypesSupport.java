package com.google.gson.internal.sql;

import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.sql.SqlDateTypeAdapter;
import com.google.gson.internal.sql.SqlTimeTypeAdapter;
import com.google.gson.internal.sql.SqlTimestampTypeAdapter;
import java.sql.Date;
import java.sql.Timestamp;
/* loaded from: classes.dex */
public abstract class SqlTypesSupport {
    public static final C02771 DATE_DATE_TYPE;
    public static final SqlDateTypeAdapter.C02741 DATE_FACTORY;
    public static final boolean SUPPORTS_SQL_TYPES;
    public static final C02771 TIMESTAMP_DATE_TYPE;
    public static final SqlTimestampTypeAdapter.C02761 TIMESTAMP_FACTORY;
    public static final SqlTimeTypeAdapter.C02751 TIME_FACTORY;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.gson.internal.sql.SqlTypesSupport$1] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.google.gson.internal.sql.SqlTypesSupport$1] */
    static {
        boolean z;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        SUPPORTS_SQL_TYPES = z;
        if (z) {
            DATE_DATE_TYPE = new DefaultDateTypeAdapter.DateType(Date.class) { // from class: com.google.gson.internal.sql.SqlTypesSupport.1
                @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType
                public final java.util.Date deserialize(java.util.Date date) {
                    switch (r1) {
                        case 0:
                            return new Date(date.getTime());
                        default:
                            return new Timestamp(date.getTime());
                    }
                }
            };
            TIMESTAMP_DATE_TYPE = new DefaultDateTypeAdapter.DateType(Timestamp.class) { // from class: com.google.gson.internal.sql.SqlTypesSupport.1
                @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType
                public final java.util.Date deserialize(java.util.Date date) {
                    switch (r1) {
                        case 0:
                            return new Date(date.getTime());
                        default:
                            return new Timestamp(date.getTime());
                    }
                }
            };
            DATE_FACTORY = SqlDateTypeAdapter.FACTORY;
            TIME_FACTORY = SqlTimeTypeAdapter.FACTORY;
            TIMESTAMP_FACTORY = SqlTimestampTypeAdapter.FACTORY;
            return;
        }
        DATE_DATE_TYPE = null;
        TIMESTAMP_DATE_TYPE = null;
        DATE_FACTORY = null;
        TIME_FACTORY = null;
        TIMESTAMP_FACTORY = null;
    }
}
