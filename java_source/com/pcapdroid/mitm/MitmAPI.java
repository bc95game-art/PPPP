package com.pcapdroid.mitm;

import java.io.Serializable;
/* loaded from: classes.dex */
public class MitmAPI {
    public static final String CERTIFICATE_RESULT = "certificate";
    public static final String MITM_CONFIG = "mitm_config";
    public static final String MITM_SERVICE = "com.pcapdroid.mitm.MitmService";
    public static final int MSG_DISABLE_DOZE = 4;
    public static final int MSG_ERROR = -1;
    public static final int MSG_GET_CA_CERTIFICATE = 2;
    public static final int MSG_START_MITM = 1;
    public static final int MSG_STOP_MITM = 3;
    public static final String PACKAGE_NAME = "com.pcapdroid.mitm";
    public static final String SSLKEYLOG_RESULT = "sslkeylog";

    /* loaded from: classes.dex */
    public static final class MitmConfig implements Serializable {
        public String additionalOptions;
        public boolean dumpMasterSecrets;
        public String proxyAuth;
        public int proxyPort;
        public boolean shortPayload;
        public boolean sslInsecure;
        public boolean transparentMode;
    }
}
