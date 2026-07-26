package com.google.android.datatransport.cct.internal;
/* loaded from: classes.dex */
public abstract class ClientInfo {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes.dex */
    public final class ClientType extends Enum {
        public static final /* synthetic */ ClientType[] $VALUES;
        public static final ClientType ANDROID_FIREBASE;
        /* JADX INFO: Fake field, exist only in values array */
        ClientType EF0;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, com.google.android.datatransport.cct.internal.ClientInfo$ClientType] */
        static {
            Enum r0 = new Enum("UNKNOWN", 0);
            ?? r1 = new Enum("ANDROID_FIREBASE", 1);
            ANDROID_FIREBASE = r1;
            $VALUES = new ClientType[]{r0, r1};
        }

        public static ClientType valueOf(String str) {
            return (ClientType) Enum.valueOf(ClientType.class, str);
        }

        public static ClientType[] values() {
            return (ClientType[]) $VALUES.clone();
        }
    }
}
