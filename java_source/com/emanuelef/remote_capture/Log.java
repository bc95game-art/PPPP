package com.emanuelef.remote_capture;

import androidx.lifecycle.ViewModelProvider;
/* loaded from: classes.dex */
public class Log {
    public static int DEFAULT_LOGGER = 0;
    public static final String DEFAULT_LOGGER_PATH = "pcapdroid.log";
    public static final int LOG_LEVEL_INFO = 4;
    public static int MITMADDON_LOGGER = 0;
    public static final String MITM_LOGGER_PATH = "mitmaddon.log";
    public static final String ROOT_LOGGER_PATH = "pcapd.log";

    /* renamed from: d */
    public static void m587d(String str, String str2) {
        android.util.Log.d(str, str2);
    }

    /* renamed from: e */
    public static void m585e(String str, String str2) {
        android.util.Log.e(str, str2);
        writeLog(DEFAULT_LOGGER, 6, str, str2);
    }

    /* renamed from: i */
    public static void m583i(String str, String str2) {
        android.util.Log.i(str, str2);
        writeLog(DEFAULT_LOGGER, 4, str, str2);
    }

    public static void init(String str) {
        DEFAULT_LOGGER = CaptureService.initLogger(str + "/pcapdroid.log", 4);
        MITMADDON_LOGGER = CaptureService.initLogger(str + "/mitmaddon.log", 4);
    }

    public static void level(int i, int i2, String str) {
        if (i2 == 4) {
            m584i(i, str);
        } else if (i2 == 5) {
            m582w(i, str);
        } else if (i2 == 6) {
            m586e(i, str);
        }
    }

    /* renamed from: w */
    public static void m581w(String str, String str2) {
        android.util.Log.w(str, str2);
        writeLog(DEFAULT_LOGGER, 5, str, str2);
    }

    public static void writeLog(int i, int i2, String str, String str2) {
        String str3;
        if (!PCAPdroid.isUnderTest()) {
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                str3 = ViewModelProvider.Factory.CC.m595m("[", str, "] ");
            } else {
                str3 = "";
            }
            sb.append(str3);
            sb.append(str2);
            CaptureService.writeLog(i, i2, sb.toString());
        }
    }

    public static void wtf(String str, String str2) {
        android.util.Log.wtf(str, str2);
        writeLog(DEFAULT_LOGGER, 7, str, str2);
    }

    /* renamed from: e */
    public static void m586e(int i, String str) {
        writeLog(i, 6, null, str);
    }

    /* renamed from: i */
    public static void m584i(int i, String str) {
        writeLog(i, 4, null, str);
    }

    /* renamed from: w */
    public static void m582w(int i, String str) {
        writeLog(i, 5, null, str);
    }
}
