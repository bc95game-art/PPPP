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

    public static void d(String str, String str2) {
        android.util.Log.d(str, str2);
    }

    public static void e(String str, String str2) {
        android.util.Log.e(str, str2);
        writeLog(DEFAULT_LOGGER, 6, str, str2);
    }

    public static void i(String str, String str2) {
        android.util.Log.i(str, str2);
        writeLog(DEFAULT_LOGGER, 4, str, str2);
    }

    public static void init(String str) {
        DEFAULT_LOGGER = CaptureService.initLogger(str + "/pcapdroid.log", 4);
        MITMADDON_LOGGER = CaptureService.initLogger(str + "/mitmaddon.log", 4);
    }

    public static void level(int i, int i2, String str) {
        if (i2 == 4) {
            i(i, str);
        } else if (i2 == 5) {
            w(i, str);
        } else if (i2 == 6) {
            e(i, str);
        }
    }

    public static void w(String str, String str2) {
        android.util.Log.w(str, str2);
        writeLog(DEFAULT_LOGGER, 5, str, str2);
    }

    public static void writeLog(int i, int i2, String str, String str2) {
        String str3;
        if (!PCAPdroid.isUnderTest()) {
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                str3 = ViewModelProvider.Factory.CC.m("[", str, "] ");
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

    public static void e(int i, String str) {
        writeLog(i, 6, null, str);
    }

    public static void i(int i, String str) {
        writeLog(i, 4, null, str);
    }

    public static void w(int i, String str) {
        writeLog(i, 5, null, str);
    }
}
