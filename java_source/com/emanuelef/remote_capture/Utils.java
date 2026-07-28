package com.emanuelef.remote_capture;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.UiModeManager;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.InetAddresses;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.util.Base64;
import android.util.Patterns;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.EdgeToEdgeApi21;
import androidx.activity.SystemBarStyle;
import androidx.activity.SystemBarStyle$Companion$auto$1;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat$Api21Impl;
import androidx.core.graphics.Insets;
import androidx.core.p002os.BundleKt;
import androidx.core.text.HtmlCompat$Api24Impl;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat$Impl20;
import androidx.core.view.WindowInsetsControllerCompat$Impl30;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.PreferenceManager;
import androidx.transition.Transition;
import androidx.viewpager2.widget.ViewPager2;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.interfaces.TextAdapter;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.ConnectionDescriptor;
import com.emanuelef.remote_capture.model.Prefs;
import com.google.android.material.tabs.TabLayout;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.Intrinsics;
import p004j$.util.DesugarTimeZone;
/* loaded from: classes.dex */
public class Utils {
    public static final String INTERACT_ACROSS_USERS = "android.permission.INTERACT_ACROSS_USERS";
    public static final int LOW_HEAP_THRESHOLD = 10485760;
    public static final String PCAPDROID_WEBSITE = "https://pcapdroid.org";
    public static final int PER_USER_RANGE = 100000;
    static final String TAG = "Utils";
    public static final int UID_NO_FILTER = -2;
    public static final int UID_UNKNOWN = -1;
    private static String[] l7Protocols;
    private static Locale primaryLocale;
    private static Boolean rootAvailable;
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    private static final Pattern IPV4_PATTERN = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$");

    /* renamed from: com.emanuelef.remote_capture.Utils$3 */
    /* loaded from: classes.dex */
    public class C01383 extends ViewPager2.OnPageChangeCallback {
        final /* synthetic */ AtomicReference val$lastInsets;
        final /* synthetic */ ViewPager2 val$pager;

        public C01383(ViewPager2 viewPager2, AtomicReference atomicReference) {
            this.val$pager = viewPager2;
            this.val$lastInsets = atomicReference;
        }

        public static void lambda$onPageSelected$0(ViewPager2 viewPager2, AtomicReference atomicReference) {
            View childAt = viewPager2.getChildAt(0);
            WindowInsetsCompat windowInsetsCompat = (WindowInsetsCompat) atomicReference.get();
            if (childAt != null && windowInsetsCompat != null && !windowInsetsCompat.mImpl.isConsumed()) {
                ViewCompat.dispatchApplyWindowInsets(childAt, windowInsetsCompat);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            new Handler(Looper.getMainLooper()).postDelayed(new Utils$$ExternalSyntheticLambda3(this.val$pager, 1, this.val$lastInsets), 5L);
        }
    }

    /* renamed from: com.emanuelef.remote_capture.Utils$4 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C01394 {

        /* renamed from: $SwitchMap$com$emanuelef$remote_capture$model$ConnectionDescriptor$DecryptionStatus */
        static final /* synthetic */ int[] f28x1b328d71;

        static {
            int[] iArr = new int[ConnectionDescriptor.DecryptionStatus.values().length];
            f28x1b328d71 = iArr;
            try {
                iArr[ConnectionDescriptor.DecryptionStatus.DECRYPTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28x1b328d71[ConnectionDescriptor.DecryptionStatus.NOT_DECRYPTABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28x1b328d71[ConnectionDescriptor.DecryptionStatus.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum BuildType {
        UNKNOWN,
        DEBUG,
        GITHUB,
        FDROID,
        PLAYSTORE
    }

    /* loaded from: classes.dex */
    public enum PrivateDnsMode {
        DISABLED,
        OPPORTUNISTIC,
        STRICT;

        @Override // java.lang.Enum
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    /* loaded from: classes.dex */
    public static class UriStat {
        public String name;
        public long size;
    }

    public static String adapter2Text(TextAdapter textAdapter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < textAdapter.getCount(); i++) {
            sb.append(textAdapter.getItemText(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static boolean backHandleSearchview(SearchView searchView) {
        if (searchView == null || searchView.mIconified) {
            return false;
        }
        searchView.setIconified(true);
        return true;
    }

    public static byte[] base32Decode(String str) {
        int i;
        String replace = str.toUpperCase().replace("\n", "");
        int i2 = 8;
        int length = (replace.length() * 5) / 8;
        byte[] bArr = new byte[length];
        int i3 = 0;
        byte b = 0;
        for (int i4 = 0; i4 < replace.length(); i4++) {
            char charAt = replace.charAt(i4);
            if (charAt >= '2' && charAt <= '7') {
                i = charAt - 24;
            } else if (charAt < 'A' || charAt > 'Z') {
                throw new IllegalArgumentException("invalid BASE32 string or unsupported padding");
            } else {
                i = charAt - 'A';
            }
            if (i2 > 5) {
                b = (byte) (b | (i << (i2 - 5)));
                i2 -= 5;
            } else {
                bArr[i3] = (byte) (b | (i >> (5 - i2)));
                i2 += 3;
                b = (byte) (i << i2);
                i3++;
            }
        }
        if (i3 < length) {
            bArr[i3] = b;
        }
        return bArr;
    }

    public static String byteArrayToHex(byte[] bArr, int i) {
        char[] cArr = new char[i * 2];
        for (int i2 = 0; i2 < i; i2++) {
            byte b = bArr[i2];
            int i3 = i2 * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i3] = cArr2[(b & 255) >>> 4];
            cArr[i3 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static String cleanDomain(String str) {
        if (str.startsWith("www.")) {
            return str.substring(4);
        }
        return str;
    }

    public static void copy(File file, OutputStream outputStream) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void copyToClipboard(Context context, String str) {
        try {
            ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(context.getString(C0130R.string.stats), str));
            if (Build.VERSION.SDK_INT <= 32) {
                showToast(context, C0130R.string.copied, new Object[0]);
            }
        } catch (Exception e) {
            Log.m585e(TAG, "copyToClipboard failed: " + e.getMessage());
            showToastLong(context, C0130R.string.error, new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean downloadFile(String str, String str2) {
        boolean z;
        IOException e;
        FileOutputStream fileOutputStream;
        Throwable th;
        Throwable th2;
        Throwable th3;
        BufferedInputStream bufferedInputStream;
        Throwable th4;
        boolean z2;
        try {
            try {
                fileOutputStream = new FileOutputStream(str2 + ".tmp");
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                if (!z) {
                }
            }
        } catch (IOException e3) {
            e = e3;
            z = false;
            e.printStackTrace();
            if (!z) {
            }
        }
        try {
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    try {
                        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                        try {
                            try {
                                httpsURLConnection.setRequestProperty("Connection", "Close");
                                httpsURLConnection.setConnectTimeout(5000);
                                httpsURLConnection.setReadTimeout(5000);
                                try {
                                    bufferedInputStream = new BufferedInputStream(httpsURLConnection.getInputStream());
                                } catch (SocketTimeoutException unused) {
                                    z = false;
                                }
                                try {
                                    try {
                                        byte[] bArr = new byte[4096];
                                        z = false;
                                        while (true) {
                                            try {
                                                int read = bufferedInputStream.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                bufferedOutputStream.write(bArr, 0, read);
                                                if (read > 0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                z |= z2;
                                            } catch (Throwable th5) {
                                                th4 = th5;
                                                try {
                                                    bufferedInputStream.close();
                                                } catch (Throwable th6) {
                                                    th4.addSuppressed(th6);
                                                }
                                                throw th4;
                                            }
                                        }
                                        bufferedInputStream.close();
                                    } catch (SocketTimeoutException unused2) {
                                        Log.m581w(TAG, "Timeout while fetching " + str);
                                        httpsURLConnection.disconnect();
                                        bufferedOutputStream.close();
                                        fileOutputStream.close();
                                        if (!z) {
                                        }
                                    }
                                    httpsURLConnection.disconnect();
                                    bufferedOutputStream.close();
                                    fileOutputStream.close();
                                    if (!z) {
                                        return new File(ViewModelProvider.Factory.CC.m596m(str2, ".tmp")).renameTo(new File(str2));
                                    }
                                    try {
                                        new File(str2 + ".tmp").delete();
                                    } catch (Exception unused3) {
                                    }
                                    return false;
                                } catch (Throwable th7) {
                                    th4 = th7;
                                }
                            } catch (Throwable th8) {
                                th3 = th8;
                                httpsURLConnection.disconnect();
                                throw th3;
                            }
                        } catch (Throwable th9) {
                            th3 = th9;
                            httpsURLConnection.disconnect();
                            throw th3;
                        }
                    } catch (Throwable th10) {
                        th2 = th10;
                        bufferedOutputStream.close();
                        throw th2;
                    }
                } catch (Throwable th11) {
                    th2 = th11;
                    bufferedOutputStream.close();
                    throw th2;
                }
            } catch (Throwable th12) {
                th = th12;
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th13) {
            th = th13;
            fileOutputStream.close();
            throw th;
        }
    }

    private static String downloadsUriToPath(Context context, Uri uri) {
        String documentId = DocumentsContract.getDocumentId(uri);
        if (documentId == null) {
            return null;
        }
        if (documentId.startsWith("raw:/")) {
            return Uri.parse(documentId).getPath();
        }
        try {
            long parseLong = Long.parseLong(documentId);
            String[] strArr = {"content://downloads/public_downloads", "content://downloads/my_downloads"};
            for (int i = 0; i < 2; i++) {
                String mediastoreUriToPath = mediastoreUriToPath(context, ContentUris.withAppendedId(Uri.parse(strArr[i]), parseLong));
                if (mediastoreUriToPath != null) {
                    return mediastoreUriToPath;
                }
            }
        } catch (NumberFormatException unused) {
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object, androidx.activity.EdgeToEdgeApi21] */
    public static void enableEdgeToEdge(ComponentActivity componentActivity) {
        BundleKt bundleKt;
        int i = EdgeToEdge.DefaultLightScrim;
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        SystemBarStyle$Companion$auto$1 systemBarStyle$Companion$auto$1 = SystemBarStyle$Companion$auto$1.INSTANCE;
        SystemBarStyle systemBarStyle = new SystemBarStyle(0, 0, systemBarStyle$Companion$auto$1);
        SystemBarStyle systemBarStyle2 = new SystemBarStyle(EdgeToEdge.DefaultLightScrim, EdgeToEdge.DefaultDarkScrim, systemBarStyle$Companion$auto$1);
        View decorView = componentActivity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        Resources resources = decorView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        boolean booleanValue = ((Boolean) systemBarStyle$Companion$auto$1.invoke(resources)).booleanValue();
        Resources resources2 = decorView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "view.resources");
        boolean booleanValue2 = ((Boolean) systemBarStyle$Companion$auto$1.invoke(resources2)).booleanValue();
        EdgeToEdgeApi21 edgeToEdgeApi21 = EdgeToEdge.Impl;
        EdgeToEdgeApi21 edgeToEdgeApi212 = edgeToEdgeApi21;
        if (edgeToEdgeApi21 == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                edgeToEdgeApi212 = new Object();
            } else if (i2 >= 26) {
                edgeToEdgeApi212 = new Object();
            } else if (i2 >= 23) {
                edgeToEdgeApi212 = new Object();
            } else {
                ?? obj = new Object();
                EdgeToEdge.Impl = obj;
                edgeToEdgeApi212 = obj;
            }
        }
        Window window = componentActivity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        edgeToEdgeApi212.setUp(systemBarStyle, systemBarStyle2, window, decorView, booleanValue, booleanValue2);
        Window window2 = componentActivity.getWindow();
        Transition.C01101 r2 = new Transition.C01101(window2.getDecorView());
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            bundleKt = new WindowInsetsControllerCompat$Impl30(window2, r2);
        } else if (i3 >= 26) {
            bundleKt = new WindowInsetsControllerCompat$Impl20(window2, r2);
        } else if (i3 >= 23) {
            bundleKt = new WindowInsetsControllerCompat$Impl20(window2, r2);
        } else {
            bundleKt = new WindowInsetsControllerCompat$Impl20(window2, r2);
        }
        bundleKt.setAppearanceLightStatusBars(false);
    }

    public static void fixListviewInsetsBottom(ListView listView) {
        PlayBilling$$ExternalSyntheticLambda15 playBilling$$ExternalSyntheticLambda15 = new PlayBilling$$ExternalSyntheticLambda15(4);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(listView, playBilling$$ExternalSyntheticLambda15);
        listView.setClipToPadding(false);
    }

    public static void fixScrollableTabLayoutInsets(TabLayout tabLayout) {
        PlayBilling$$ExternalSyntheticLambda15 playBilling$$ExternalSyntheticLambda15 = new PlayBilling$$ExternalSyntheticLambda15(5);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(tabLayout, playBilling$$ExternalSyntheticLambda15);
    }

    public static void fixViewPager2Insets(ViewPager2 viewPager2) {
        AtomicReference atomicReference = new AtomicReference();
        PlayBilling$$ExternalSyntheticLambda4 playBilling$$ExternalSyntheticLambda4 = new PlayBilling$$ExternalSyntheticLambda4(5, atomicReference);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(viewPager2, playBilling$$ExternalSyntheticLambda4);
        ((ArrayList) viewPager2.mExternalPageChangeCallbacks.mCallbacks).add(new C01383(viewPager2, atomicReference));
    }

    public static String formatBytes(long j) {
        String str;
        long j2 = 1024;
        if (j < 1024) {
            return j + " B";
        }
        if (j < 1048576) {
            str = "KB";
        } else {
            j2 = 1073741824;
            if (j < 1073741824) {
                str = "MB";
                j2 = 1048576;
            } else {
                str = "GB";
            }
        }
        return String.format("%.1f %s", Float.valueOf(((float) j) / ((float) j2)), str);
    }

    public static String formatDuration(long j) {
        if (j == 0) {
            return "< 1 s";
        }
        if (j < 60) {
            return String.format("%d s", Long.valueOf(j));
        }
        if (j < 3600) {
            return String.format("> %d m", Long.valueOf(j / 60));
        }
        return String.format("> %d h", Long.valueOf(j / 3600));
    }

    public static String formatEpochFull(Context context, long j) {
        return new SimpleDateFormat("MM/dd/yy HH:mm:ss", getPrimaryLocale(context)).format(new Date(j * 1000));
    }

    public static String formatEpochMillis(Context context, long j) {
        return new SimpleDateFormat("MM/dd/yy HH:mm:ss.SSS", getPrimaryLocale(context)).format(new Date(j));
    }

    public static String formatEpochMin(Context context, long j) {
        if (j == 0) {
            return "-";
        }
        long now = now();
        Locale primaryLocale2 = getPrimaryLocale(context);
        if (now - j < 86400) {
            return new SimpleDateFormat("HH:mm", primaryLocale2).format(new Date(j * 1000));
        }
        return new SimpleDateFormat("dd MMM", primaryLocale2).format(new Date(j * 1000));
    }

    public static String formatEpochShort(Context context, long j) {
        if (j == 0) {
            return "-";
        }
        long now = now();
        Locale primaryLocale2 = getPrimaryLocale(context);
        if (now - j < 86400) {
            return new SimpleDateFormat("HH:mm:ss", primaryLocale2).format(new Date(j * 1000));
        }
        return new SimpleDateFormat("dd MMM, HH:mm:ss", primaryLocale2).format(new Date(j * 1000));
    }

    public static String formatIntShort(long j) {
        String str;
        long j2 = 1000;
        if (j < 1000) {
            return Long.toString(j);
        }
        if (j < 1000000) {
            str = "K";
        } else {
            j2 = 1000000000;
            if (j < 1000000000) {
                str = "M";
                j2 = 1000000;
            } else {
                str = "G";
            }
        }
        return String.format("%.1f %s", Float.valueOf(((float) j) / ((float) j2)), str);
    }

    public static String formatInteger(Context context, int i) {
        return String.format(getPrimaryLocale(context), "%d", Integer.valueOf(i));
    }

    public static String formatMillisIso8601(Context context, long j) {
        String str;
        int length;
        Locale primaryLocale2 = getPrimaryLocale(context);
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            str = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
        } else {
            str = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
        }
        String format = new SimpleDateFormat(str, primaryLocale2).format(new Date(j));
        if (i >= 24 || (length = format.length()) <= 5) {
            return format;
        }
        int i2 = length - 5;
        if (format.charAt(i2) != '+' && format.charAt(i2) != '-') {
            return format;
        }
        StringBuilder sb = new StringBuilder();
        int i3 = length - 2;
        sb.append(format.substring(0, i3));
        sb.append(":");
        sb.append(format.substring(i3));
        return sb.toString();
    }

    public static String formatNumber(Context context, long j) {
        return String.format(getPrimaryLocale(context), "%,d", Long.valueOf(j));
    }

    public static SpannableString formatTextValue(Context context, StyleSpan styleSpan, StyleSpan styleSpan2, int i, String str) {
        String string = context.getResources().getString(i);
        String format = String.format(string, str);
        SpannableString spannableString = new SpannableString(format);
        int length = string.length() - 4;
        if (!isRTL(context)) {
            if (styleSpan != null) {
                spannableString.setSpan(styleSpan, 0, length, 0);
            }
            if (styleSpan2 != null) {
                spannableString.setSpan(styleSpan2, length, format.length(), 0);
                return spannableString;
            }
        } else {
            if (styleSpan != null) {
                spannableString.setSpan(styleSpan, format.length() - length, format.length(), 0);
            }
            if (styleSpan2 != null) {
                spannableString.setSpan(styleSpan2, 0, format.length() - length, 0);
            }
        }
        return spannableString;
    }

    public static String genRandomString(int i) {
        StringBuilder sb = new StringBuilder(i);
        Random random = new Random();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(62)));
        }
        return sb.toString();
    }

    public static String getAppVersion(Context context) {
        try {
            String str = getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
            if (str.contains(".")) {
                return "v".concat(str);
            }
            return str;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.m585e(TAG, "Could not retrieve package version");
            return "";
        }
    }

    public static String getAppVersionString() {
        return "PCAPdroid v1.9.1";
    }

    public static long getAvailableHeap() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.freeMemory() + (runtime.maxMemory() - runtime.totalMemory());
    }

    public static String getBuildInfo(Context context) {
        String str;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        boolean isRootAvailable = isRootAvailable();
        StringBuilder sb = new StringBuilder("Build type: ");
        sb.append(getVerifiedBuild(context).toString().toLowerCase());
        String str2 = "";
        if (!PCAPdroid.getInstance().isUsharkAvailable()) {
            str = " (withoutUshark)";
        } else {
            str = str2;
        }
        sb.append(str);
        sb.append("\nBuild version: 1.9.1\nCurrent date: ");
        sb.append(simpleDateFormat.format(new Date()));
        sb.append("\nDevice: ");
        sb.append(getDeviceModel());
        if (isRootAvailable) {
            str2 = " (rooted)";
        }
        sb.append(str2);
        sb.append("\nOS version: ");
        sb.append(getOsVersion());
        sb.append("\n");
        return sb.toString();
    }

    public static String getCountryName(Context context, String str) {
        return new Locale(getPrimaryLocale(context).getCountry(), str).getDisplayCountry();
    }

    public static String getDeviceModel() {
        String str = Build.MODEL;
        String str2 = Build.MANUFACTURER;
        if (str.startsWith(str2)) {
            return str2;
        }
        return str2 + " " + str;
    }

    public static String getDeviceName(Context context) {
        try {
            if (Build.VERSION.SDK_INT <= 31) {
                return Settings.Secure.getString(context.getContentResolver(), "bluetooth_name");
            }
            return Settings.Global.getString(context.getContentResolver(), "device_name");
        } catch (Exception e) {
            Log.m587d(TAG, "getDeviceName failed: " + e);
            return null;
        }
    }

    public static String getDnsServer(ConnectivityManager connectivityManager, Network network) {
        LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
        if (linkProperties == null) {
            return null;
        }
        for (InetAddress inetAddress : linkProperties.getDnsServers()) {
            if (inetAddress instanceof Inet4Address) {
                return inetAddress.getHostAddress();
            }
        }
        return null;
    }

    public static Uri getDownloadsUri(Context context, String str) {
        String str2;
        Cursor query;
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            String m = ViewModelProvider.Factory.CC.m593m(new StringBuilder(), Environment.DIRECTORY_DOWNLOADS, "/PCAPdroid/");
            contentValues.put("relative_path", m);
            str2 = "relative_path='" + m + "' AND _display_name='" + str + "'";
        } else if (i < 23 || context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(externalStoragePublicDirectory + "/PCAPdroid");
            try {
                file.mkdirs();
            } catch (Exception unused) {
            }
            if (file.exists()) {
                externalStoragePublicDirectory = file;
            }
            String str3 = externalStoragePublicDirectory + "/" + str;
            Log.m587d(TAG, "getDownloadsUri: path=" + str3);
            contentValues.put("_data", str3);
            str2 = "_data='" + str3 + "'";
        } else {
            showToastLong(context, C0130R.string.external_storage_perm_required, new Object[0]);
            return null;
        }
        Uri contentUri = MediaStore.Files.getContentUri("external");
        try {
            query = context.getContentResolver().query(contentUri, new String[]{"_id"}, str2, null, null);
        } catch (Exception unused2) {
        }
        if (query == null || !query.moveToFirst()) {
            if (query != null) {
                query.close();
            }
            try {
                Uri insert = context.getContentResolver().insert(contentUri, contentValues);
                Log.m587d(TAG, "getDownloadsUri: new file " + insert);
                return insert;
            } catch (Exception e) {
                Log.m585e(TAG, "getDownloadsUri failed:" + e.getMessage());
                showToastLong(context, C0130R.string.write_ext_storage_failed, new Object[0]);
                return null;
            }
        } else {
            Uri withAppendedId = ContentUris.withAppendedId(contentUri, query.getLong(query.getColumnIndexOrThrow("_id")));
            Log.m587d(TAG, "getDownloadsUri: overwriting file " + withAppendedId);
            query.close();
            return withAppendedId;
        }
    }

    public static int getEndOfHTTPHeaders(byte[] bArr) {
        for (int i = 0; i <= bArr.length - 4; i++) {
            if (bArr[i] == 13 && bArr[i + 1] == 10 && bArr[i + 2] == 13 && bArr[i + 3] == 10) {
                return i + 4;
            }
        }
        return 0;
    }

    public static String getExportFileName(Context context, String str) {
        String loadedPcapBasename = PCAPdroid.getInstance().getLoadedPcapBasename();
        if (loadedPcapBasename == null) {
            return getUniqueFileName(context, str);
        }
        return loadedPcapBasename + "." + str;
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    public static List<PackageInfo> getInstalledPackages(PackageManager packageManager, int i) {
        if (Build.VERSION.SDK_INT >= 33) {
            return packageManager.getInstalledPackages(PackageManager.PackageInfoFlags.of(i));
        }
        return packageManager.getInstalledPackages(i);
    }

    public static int getIntentFlags(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return i | 67108864;
        }
        return i;
    }

    public static String[] getL7Protocols() {
        List<String> l7Protocols2;
        if (l7Protocols == null && (l7Protocols2 = CaptureService.getL7Protocols()) != null) {
            Collections.sort(l7Protocols2, String.CASE_INSENSITIVE_ORDER);
            l7Protocols = (String[]) l7Protocols2.toArray(new String[0]);
        }
        return l7Protocols;
    }

    public static String getLocalIPAddress(Context context) {
        String hostAddress;
        try {
            InetAddress byName = InetAddress.getByName(CaptureService.VPN_IP_ADDRESS);
            String localWifiIpAddress = getLocalWifiIpAddress(context);
            if (localWifiIpAddress == null || localWifiIpAddress.equals("0.0.0.0")) {
                try {
                    ArrayList list = Collections.list(NetworkInterface.getNetworkInterfaces());
                    int size = list.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = list.get(i);
                        i++;
                        NetworkInterface networkInterface = (NetworkInterface) obj;
                        if (!networkInterface.isVirtual()) {
                            ArrayList list2 = Collections.list(networkInterface.getInetAddresses());
                            int size2 = list2.size();
                            int i2 = 0;
                            while (i2 < size2) {
                                Object obj2 = list2.get(i2);
                                i2++;
                                InetAddress inetAddress = (InetAddress) obj2;
                                if (!inetAddress.isLoopbackAddress() && inetAddress.isSiteLocalAddress() && !inetAddress.equals(byName) && (hostAddress = inetAddress.getHostAddress()) != null && (inetAddress instanceof Inet4Address) && !hostAddress.equals("0.0.0.0")) {
                                    Log.m587d("getLocalIPAddress", "Using interface '" + networkInterface.getName() + "' IP: " + hostAddress);
                                    return hostAddress;
                                }
                            }
                            continue;
                        }
                    }
                } catch (Exception unused) {
                }
                Log.m587d("getLocalIPAddress", "Using fallback IP");
                return "127.0.0.1";
            }
            Log.m587d("getLocalIPAddress", "Using WiFi IP: ".concat(localWifiIpAddress));
            return localWifiIpAddress;
        } catch (UnknownHostException unused2) {
            return "";
        }
    }

    public static String getLocalWifiIpAddress(Context context) {
        WifiInfo connectionInfo;
        int ipAddress;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null || (ipAddress = connectionInfo.getIpAddress()) == 0) {
            return null;
        }
        if (ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN)) {
            ipAddress = Integer.reverseBytes(ipAddress);
        }
        try {
            return InetAddress.getByAddress(BigInteger.valueOf(ipAddress).toByteArray()).getHostAddress();
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    public static Configuration getLocalizedConfig(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Configuration configuration = context.getResources().getConfiguration();
        String appLocale = Prefs.getAppLocale(defaultSharedPreferences);
        if (Build.VERSION.SDK_INT >= 33 || appLocale == null) {
            return configuration;
        }
        Locale forLanguageTag = Locale.forLanguageTag(appLocale);
        Locale.setDefault(forLanguageTag);
        configuration.setLocale(forLanguageTag);
        return configuration;
    }

    public static int getMajorVersion(String str) {
        boolean startsWith = str.startsWith("v");
        int indexOf = str.indexOf(46);
        if (indexOf < 0) {
            return -1;
        }
        try {
            return Integer.parseInt(str.substring(startsWith ? 1 : 0, indexOf));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static String getMemoryStats(Context context) {
        boolean z;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        Runtime runtime = Runtime.getRuntime();
        long availableHeap = getAvailableHeap();
        if (availableHeap <= 10485760) {
            z = true;
        } else {
            z = false;
        }
        return "[Runtime] free: " + formatBytes(runtime.freeMemory()) + ", max: " + formatBytes(runtime.maxMemory()) + ", allocated: " + formatBytes(runtime.totalMemory()) + ", available: " + formatBytes(availableHeap) + ", low=" + z + "\n[MemoryState] pid: " + runningAppProcessInfo.pid + ", trimlevel: " + trimlvl2str(runningAppProcessInfo.lastTrimLevel) + "\n[MemoryInfo] available: " + formatBytes(memoryInfo.availMem) + ", total: " + formatBytes(memoryInfo.totalMem) + ", lowthresh: " + formatBytes(memoryInfo.threshold) + ", low=" + memoryInfo.lowMemory + "\n[MemoryClass] standard: " + activityManager.getMemoryClass() + " MB, large: " + activityManager.getLargeMemoryClass() + " MB";
    }

    public static Enumeration<NetworkInterface> getNetworkInterfaces() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                return networkInterfaces;
            }
        } catch (NullPointerException | SocketException e) {
            e.printStackTrace();
        }
        return Collections.enumeration(new ArrayList());
    }

    public static String getOsVersion() {
        return "Android " + Build.VERSION.RELEASE + " (SDK " + Build.VERSION.SDK_INT + ")";
    }

    public static int getPCAPdroidUid(Context context) {
        AppDescriptor resolveInstalledApp = AppsResolver.resolveInstalledApp(context.getPackageManager(), BuildConfig.APPLICATION_ID, 0);
        if (resolveInstalledApp != null) {
            return resolveInstalledApp.getUid();
        }
        return -1;
    }

    public static PackageInfo getPackageInfo(PackageManager packageManager, String str, int i) {
        if (Build.VERSION.SDK_INT >= 33) {
            return packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(i));
        }
        return packageManager.getPackageInfo(str, i);
    }

    public static int getPackageUid(PackageManager packageManager, String str, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            return packageManager.getPackageUid(str, PackageManager.PackageInfoFlags.of(i));
        }
        if (i2 >= 24) {
            return packageManager.getPackageUid(str, 0);
        }
        return packageManager.getApplicationInfo(str, 0).uid;
    }

    public static Locale getPrimaryLocale(Context context) {
        if (primaryLocale == null) {
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 24) {
                primaryLocale = configuration.getLocales().get(0);
            } else {
                primaryLocale = configuration.locale;
            }
        }
        return primaryLocale;
    }

    public static PrivateDnsMode getPrivateDnsMode(LinkProperties linkProperties) {
        if (linkProperties.getPrivateDnsServerName() != null) {
            return PrivateDnsMode.STRICT;
        }
        if (linkProperties.isPrivateDnsActive()) {
            return PrivateDnsMode.OPPORTUNISTIC;
        }
        return PrivateDnsMode.DISABLED;
    }

    public static Network getRunningVpn(Context context) {
        Network[] allNetworks;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        try {
            for (Network network : connectivityManager.getAllNetworks()) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                if (networkCapabilities != null && networkCapabilities.hasTransport(4)) {
                    Log.m587d("hasVPNRunning", "detected VPN connection: " + network.toString());
                    return network;
                }
            }
            return null;
        } catch (SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getSecondLevelDomain(String str) {
        int lastIndexOf;
        int lastIndexOf2 = str.lastIndexOf(".");
        if (lastIndexOf2 > 0 && (lastIndexOf = str.substring(0, lastIndexOf2).lastIndexOf(".")) > 0) {
            return str.substring(lastIndexOf + 1);
        }
        return str;
    }

    public static <T extends Serializable> T getSerializable(Bundle bundle, String str, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 33) {
            return (T) bundle.getSerializable(str, cls);
        }
        try {
            return (T) bundle.getSerializable(str);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public static <T extends Serializable> T getSerializableExtra(Intent intent, String str, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 33) {
            return (T) intent.getSerializableExtra(str, cls);
        }
        try {
            return (T) intent.getSerializableExtra(str);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public static int getSmallerDisplayDimension(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            return Math.min(currentWindowMetrics.getBounds().width(), currentWindowMetrics.getBounds().width());
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return Math.min(point.x, point.y);
    }

    public static String[] getSupportedLocales(Context context) {
        String attributeValue;
        ArrayList arrayList = new ArrayList();
        try {
            XmlResourceParser xml = context.getResources().getXml(C0130R.xml.locales_config);
            while (true) {
                int next = xml.next();
                if (next == 1) {
                    break;
                } else if (next == 2 && "locale".equals(xml.getName()) && (attributeValue = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "name")) != null) {
                    arrayList.add(attributeValue);
                }
            }
            xml.close();
        } catch (Exception e) {
            Log.m585e(TAG, "getSupportedLocales: " + e.getMessage());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static CharSequence getText(Context context, int i, String... strArr) {
        String str;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr[i2] = TextUtils.htmlEncode(strArr[i2]);
        }
        SpannedString spannedString = new SpannedString(context.getText(i));
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24) {
            str = HtmlCompat$Api24Impl.toHtml(spannedString, 0);
        } else {
            str = Html.toHtml(spannedString);
        }
        String format = String.format(str, strArr);
        if (i3 >= 24) {
            return HtmlCompat$Api24Impl.fromHtml(format, 0);
        }
        return Html.fromHtml(format);
    }

    public static String getUniqueFileName(Context context, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MMM_HH_mm_ss", getPrimaryLocale(context));
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return Prefs.getFilenamePrefix(defaultSharedPreferences) + simpleDateFormat.format(new Date()) + "." + str;
    }

    public static String getUniquePcapFileName(Context context, boolean z) {
        String str;
        if (z) {
            str = Billing.PCAPNG_SKU;
        } else {
            str = "pcap";
        }
        return getUniqueFileName(context, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x009f, code lost:
        r9.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static UriStat getUriStat(Context context, Uri uri) {
        File file;
        String str;
        long j;
        String uri2 = uri.toString();
        String uriToFilePath = uriToFilePath(context, uri);
        if (uriToFilePath != null) {
            Log.m587d(TAG, "getUriStat: resolved to file ".concat(uriToFilePath));
            file = new File(uriToFilePath);
        } else if (uri2.startsWith("file://")) {
            file = new File(uri2.substring(7));
        } else {
            file = null;
        }
        if (file == null || !file.exists()) {
            try {
                Cursor query = context.getContentResolver().query(uri, null, null, null, null);
                if (query != null && query.moveToFirst()) {
                    UriStat uriStat = new UriStat();
                    int columnIndexOrThrow = query.getColumnIndexOrThrow("_size");
                    int columnIndexOrThrow2 = query.getColumnIndexOrThrow("_display_name");
                    if (columnIndexOrThrow2 >= 0) {
                        str = query.getString(columnIndexOrThrow2);
                    } else {
                        str = "*unknown*";
                    }
                    uriStat.name = str;
                    if (!query.isNull(columnIndexOrThrow)) {
                        j = query.getLong(columnIndexOrThrow);
                    } else {
                        j = -1;
                    }
                    uriStat.size = j;
                    query.close();
                    return uriStat;
                }
            } catch (Exception unused) {
            }
            return null;
        }
        UriStat uriStat2 = new UriStat();
        uriStat2.name = file.getName();
        uriStat2.size = file.length();
        return uriStat2;
    }

    public static int getUserId(int i) {
        return i / PER_USER_RANGE;
    }

    public static BuildType getVerifiedBuild(Context context, String str) {
        Signature[] signatureArr;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                SigningInfo signingInfo = getPackageInfo(context.getPackageManager(), str, 134217728).signingInfo;
                signatureArr = signingInfo == null ? null : signingInfo.getSigningCertificateHistory();
            } else {
                signatureArr = getPackageInfo(context.getPackageManager(), str, 64).signatures;
            }
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            Log.m585e(TAG, "Could not determine the build type");
        }
        if (signatureArr != null && signatureArr.length >= 1) {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(signatureArr[0].toByteArray());
            String byteArrayToHex = byteArrayToHex(messageDigest.digest(), messageDigest.getDigestLength());
            int hashCode = byteArrayToHex.hashCode();
            if (hashCode != -1687511015) {
                if (hashCode != -1063465838) {
                    if (hashCode == -495019788 && byteArrayToHex.equals("72777D6939EF150099219BBB68C17220DB28EA8E")) {
                        return BuildType.FDROID;
                    }
                } else if (byteArrayToHex.equals("511140392BFF2CFB4BD825895DD6510CE1807F6D")) {
                    return BuildType.DEBUG;
                }
            } else if (byteArrayToHex.equals("EE953D4F988C8AC17575DFFAA1E3BBCE2E29E81D")) {
                return isPlaystore() ? BuildType.PLAYSTORE : BuildType.GITHUB;
            }
            return BuildType.UNKNOWN;
        }
        return BuildType.UNKNOWN;
    }

    public static boolean hasEncryptedPayload(AppDescriptor appDescriptor, ConnectionDescriptor connectionDescriptor) {
        int i;
        if (appDescriptor.getPackageName().equals("org.telegram.messenger")) {
            return true;
        }
        String str = connectionDescriptor.info;
        if (str != null && str.equals("g.whatsapp.net") && !connectionDescriptor.l7proto.equals("DNS")) {
            return true;
        }
        if (appDescriptor.getUid() == 1000 && (i = connectionDescriptor.dst_port) >= 5228 && i <= 5230) {
            return true;
        }
        if (appDescriptor.getUid() != 1000) {
            return false;
        }
        int i2 = connectionDescriptor.dst_port;
        if (i2 == 2195 || i2 == 2196 || i2 == 5223) {
            return true;
        }
        return false;
    }

    public static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) (Character.digit(str.charAt(i + 1), 16) + (Character.digit(str.charAt(i), 16) << 4));
        }
        return bArr;
    }

    public static String hexdump(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = i; i3 < i + i2; i3 += 16) {
            for (int i4 = 0; i4 < 16; i4++) {
                if (i4 == 8) {
                    sb.append(" ");
                }
                int i5 = i3 + i4;
                if (i5 < i2) {
                    sb.append(String.format("%02x ", Byte.valueOf(bArr[i5])));
                } else {
                    sb.append("   ");
                }
            }
            if (i3 < i2) {
                int min = Math.min(16, i2 - i3);
                sb.append(" ");
                sb.append(new String(bArr, i3, min, StandardCharsets.US_ASCII).replaceAll("[^ -~]", "."));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String httpDateToIso8601(String str) {
        Date date;
        if (str == null) {
            return null;
        }
        String[] strArr = {"EEE, dd-MMM-yyyy HH:mm:ss zzz", "EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy"};
        int i = 0;
        while (true) {
            if (i >= 4) {
                date = null;
                break;
            }
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strArr[i], Locale.US);
                simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
                date = simpleDateFormat.parse(str);
                break;
            } catch (ParseException unused) {
                i++;
            }
        }
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat2.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        return simpleDateFormat2.format(date);
    }

    public static boolean isCAInstalled(X509Certificate x509Certificate) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
            keyStore.load(null, null);
            return keyStore.getCertificateAlias(x509Certificate) != null;
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isLocalNetworkAddress(InetAddress inetAddress) {
        try {
            ArrayList list = Collections.list(NetworkInterface.getNetworkInterfaces());
            int size = list.size();
            int i = 0;
            while (i < size) {
                Object obj = list.get(i);
                i++;
                NetworkInterface networkInterface = (NetworkInterface) obj;
                if (!networkInterface.isVirtual()) {
                    for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                        if (subnetContains(interfaceAddress.getAddress(), interfaceAddress.getNetworkPrefixLength(), inetAddress)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isParseable(String str, int i, int i2, int i3, int i4, boolean z, int i5, int i6) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i7 = i2 - i;
        boolean z6 = false;
        if (i7 < 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (i7 > i4) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 || z2) {
            return false;
        }
        if (i7 > 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        if ((z4 && (!z)) && Character.digit(str.charAt(i), i3) <= 0) {
            return false;
        }
        int i8 = 0;
        while (i < i2) {
            int i9 = i + 1;
            int digit = Character.digit(str.charAt(i), i3);
            if (digit < 0) {
                return false;
            }
            i8 = (i8 * i3) + digit;
            i = i9;
        }
        if (i8 >= i5) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (i8 <= i6) {
            z6 = true;
        }
        return z5 & z6;
    }

    private static boolean isParseableIPv6Segment(String str, int i, int i2) {
        return isParseable(str, i, i2, 16, 4, true, 0, 65535);
    }

    public static boolean isPcapng(Context context, Uri uri) {
        boolean z;
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            DataInputStream dataInputStream = new DataInputStream(openInputStream);
            int readInt = dataInputStream.readInt();
            dataInputStream.skipBytes(4);
            int readInt2 = dataInputStream.readInt();
            if (readInt == 168627466 && (readInt2 == 439041101 || readInt2 == 1295788826)) {
                z = true;
            } else {
                z = false;
            }
            dataInputStream.close();
            if (openInputStream == null) {
                return z;
            }
            openInputStream.close();
            return z;
        } catch (IOException | RuntimeException e) {
            Log.m581w(TAG, "Reading " + uri + " failed: " + e);
            return false;
        }
    }

    public static boolean isPlaystore() {
        return true;
    }

    public static boolean isPrintable(byte b) {
        return (b >= 32 && b <= 126) || b == 13 || b == 10 || b == 9;
    }

    public static boolean isRTL(Context context) {
        String displayName = getPrimaryLocale(context).getDisplayName();
        if (displayName.isEmpty()) {
            return false;
        }
        byte directionality = Character.getDirectionality(displayName.charAt(0));
        if (directionality == 1 || directionality == 2) {
            return true;
        }
        return false;
    }

    public static boolean isReadable(String str) {
        try {
            new FileInputStream(str).close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isRootAvailable() {
        if (rootAvailable == null) {
            String str = System.getenv("PATH");
            rootAvailable = Boolean.FALSE;
            if (str != null) {
                Log.m587d("isRootAvailable", "PATH = ".concat(str));
                String[] split = str.split(":");
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    File file = new File(ViewModelProvider.Factory.CC.m596m(split[i], "/su"));
                    if (file.exists()) {
                        Log.m587d("isRootAvailable", "'su' binary found at " + file.getAbsolutePath());
                        rootAvailable = Boolean.TRUE;
                        break;
                    }
                    i++;
                }
            }
        }
        return rootAvailable.booleanValue();
    }

    public static boolean isSemanticVersionCompatible(String str, String str2) {
        int majorVersion = getMajorVersion(str);
        if (majorVersion < 0 || majorVersion != getMajorVersion(str2)) {
            return false;
        }
        return true;
    }

    public static boolean isTv(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        if (uiModeManager != null && uiModeManager.getCurrentModeType() == 4) {
            return true;
        }
        return false;
    }

    private static boolean isValidIPv6(String str) {
        int indexOf;
        if (str.length() == 0) {
            return false;
        }
        char charAt = str.charAt(0);
        if (charAt != ':' && Character.digit(charAt, 16) < 0) {
            return false;
        }
        String concat = str.concat(":");
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < concat.length() && (indexOf = concat.indexOf(58, i)) >= i) {
            if (i2 == 8) {
                return false;
            }
            if (i != indexOf) {
                String substring = concat.substring(i, indexOf);
                if (indexOf == concat.length() - 1 && substring.indexOf(46) > 0) {
                    i2++;
                    if (i2 == 8 || !validateIpv4Address(substring)) {
                        return false;
                    }
                } else if (!isParseableIPv6Segment(concat, i, indexOf)) {
                    return false;
                }
            } else if (indexOf != 1 && indexOf != concat.length() - 1 && z) {
                return false;
            } else {
                z = true;
            }
            i = indexOf + 1;
            i2++;
        }
        if (i2 == 8 || z) {
            return true;
        }
        return false;
    }

    public static Iterator<Integer> iterPcapRecords(byte[] bArr, boolean z) {
        final ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        if (z) {
            return new Iterator<Integer>() { // from class: com.emanuelef.remote_capture.Utils.1
                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (wrap.remaining() >= 12) {
                        return true;
                    }
                    return false;
                }

                @Override // java.util.Iterator
                public Integer next() {
                    ByteBuffer byteBuffer = wrap;
                    int i = byteBuffer.getInt(byteBuffer.position() + 4);
                    ByteBuffer byteBuffer2 = wrap;
                    byteBuffer2.position(byteBuffer2.position() + i);
                    return Integer.valueOf(i);
                }
            };
        }
        return new Iterator<Integer>() { // from class: com.emanuelef.remote_capture.Utils.2
            @Override // java.util.Iterator
            public boolean hasNext() {
                if (wrap.remaining() > 16) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Iterator
            public Integer next() {
                ByteBuffer byteBuffer = wrap;
                int i = byteBuffer.getInt(byteBuffer.position() + 8) + 16;
                ByteBuffer byteBuffer2 = wrap;
                byteBuffer2.position(byteBuffer2.position() + i);
                return Integer.valueOf(i);
            }
        };
    }

    public static WindowInsetsCompat lambda$fixListviewInsetsBottom$3(View view, WindowInsetsCompat windowInsetsCompat) {
        view.setPadding(0, 0, 0, windowInsetsCompat.mImpl.getInsets(135).bottom);
        return WindowInsetsCompat.CONSUMED;
    }

    public static WindowInsetsCompat lambda$fixScrollableTabLayoutInsets$4(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.mImpl.getInsets(135);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = insets.left;
        marginLayoutParams.rightMargin = insets.right;
        view.setLayoutParams(marginLayoutParams);
        return windowInsetsCompat;
    }

    public static WindowInsetsCompat lambda$fixViewPager2Insets$2(AtomicReference atomicReference, View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.mImpl.getInsets(135);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.leftMargin = insets.left;
        int i = insets.right;
        marginLayoutParams.rightMargin = i;
        view.setLayoutParams(marginLayoutParams);
        WindowInsetsCompat inset = windowInsetsCompat.mImpl.inset(insets.left, insets.top, i, 0);
        atomicReference.set(inset);
        return inset;
    }

    public static void lambda$setSearchQuery$1(SearchView searchView, String str) {
        SearchView.SearchAutoComplete searchAutoComplete = searchView.mSearchSrcTextView;
        searchAutoComplete.setText(str);
        if (str != null) {
            searchAutoComplete.setSelection(searchAutoComplete.length());
            searchView.mUserQuery = str;
        }
        if (!TextUtils.isEmpty(str)) {
            searchView.onSubmitQuery();
        }
    }

    public static boolean launchFileDialog(Context context, Intent intent, ActivityResultLauncher activityResultLauncher) {
        if (supportsFileDialog(context, intent)) {
            try {
                activityResultLauncher.launch(intent);
                return true;
            } catch (ActivityNotFoundException | IllegalStateException unused) {
            }
        }
        showToastLong(context, C0130R.string.no_activity_file_selection, new Object[0]);
        return false;
    }

    public static String[] list2array(List<String> list) {
        return (String[]) list.toArray(new String[0]);
    }

    private static String mediastoreUriToPath(Context context, Uri uri) {
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
            if (query.moveToFirst()) {
                String string = query.getString(columnIndexOrThrow);
                query.close();
                return string;
            }
            query.close();
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static long now() {
        return Calendar.getInstance().getTimeInMillis() / 1000;
    }

    public static String proto2str(int i) {
        if (i == 1) {
            return "ICMP";
        }
        if (i == 6) {
            return "TCP";
        }
        if (i != 17) {
            return Integer.toString(i);
        }
        return "UDP";
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean rootGrantPermission(Context context, String str) {
        if (CaptureService.rootCmd("pm", String.format("grant --user %d %s %s", Integer.valueOf(getUserId(getPCAPdroidUid(context))), BuildConfig.APPLICATION_ID, str)) == 0) {
            return true;
        }
        return false;
    }

    public static void runOnUi(Runnable runnable, Handler handler) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.m581w(TAG, e.getLocalizedMessage());
            }
        }
    }

    public static BitmapDrawable scaleDrawable(Resources resources, Drawable drawable, int i, int i2) {
        if (i > 0 && i2 > 0) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return new BitmapDrawable(resources, createBitmap);
            } catch (Exception e) {
                Log.m581w(TAG, "scaleDrawable(" + i + ", " + i2 + ") failed: " + e.getMessage());
            }
        }
        return null;
    }

    public static void sendImportantNotification(Context context, int i, Notification notification) {
        NotificationManagerCompat notificationManagerCompat = new NotificationManagerCompat(context);
        if (!notificationManagerCompat.areNotificationsEnabled()) {
            String str = notification.extras.getString("android.title") + " - " + notification.extras.getString("android.text");
            Log.m581w(TAG, "Important notification not sent because notifications are disabled: " + str);
            Toast.makeText(context, str, 0).show();
            return;
        }
        notificationManagerCompat.notify(i, notification);
    }

    public static void setDecryptionIcon(ImageView imageView, ConnectionDescriptor connectionDescriptor) {
        int i;
        int i2;
        int i3 = C01394.f28x1b328d71[connectionDescriptor.getDecryptionStatus().ordinal()];
        if (i3 == 1) {
            i = C0130R.color.ok;
        } else if (i3 == 2) {
            i = C0130R.color.warning;
        } else if (i3 != 3) {
            i = C0130R.color.lightGray;
        } else {
            i = C0130R.color.danger;
        }
        Context context = imageView.getContext();
        if (connectionDescriptor.isCleartext() || connectionDescriptor.isDecrypted()) {
            i2 = C0130R.C0131drawable.ic_lock_open;
        } else {
            i2 = C0130R.C0131drawable.ic_lock;
        }
        imageView.setColorFilter(BundleKt.getColor(context, i));
        imageView.setImageDrawable(ContextCompat$Api21Impl.getDrawable(context, i2));
    }

    public static void setSearchQuery(SearchView searchView, MenuItem menuItem, String str) {
        searchView.setIconified(false);
        menuItem.expandActionView();
        searchView.setIconified(false);
        menuItem.expandActionView();
        searchView.post(new Utils$$ExternalSyntheticLambda3(searchView, 0, str));
    }

    public static void setTextUrls(TextView textView, int i, String... strArr) {
        textView.setText(getText(textView.getContext(), i, strArr));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static void shareText(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", str);
        intent.putExtra("android.intent.extra.TEXT", str2);
        startActivity(context, Intent.createChooser(intent, context.getResources().getString(C0130R.string.share)));
    }

    public static String shorten(String str, int i) {
        if (str.length() <= i) {
            return str;
        }
        return str.substring(0, i - 1) + "…";
    }

    public static void showHelpDialog(Context context, int i) {
        showHelpDialog(context, context.getResources().getString(i));
    }

    public static void showToast(Context context, int i, Object... objArr) {
        Toast.makeText(context, context.getResources().getString(i, objArr), 0).show();
    }

    public static void showToastLong(Context context, int i, Object... objArr) {
        Toast.makeText(context, context.getResources().getString(i, objArr), 1).show();
    }

    public static void startActivity(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException | SecurityException unused) {
            showToastLong(context, C0130R.string.no_intent_handler_found, new Object[0]);
        }
    }

    public static boolean subnetContains(InetAddress inetAddress, int i, InetAddress inetAddress2) {
        int length = inetAddress.getAddress().length;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        for (int i2 = 0; i2 < length / 4; i2++) {
            allocate.putInt(-1);
        }
        BigInteger not = new BigInteger(1, allocate.array()).shiftRight(i).not();
        BigInteger and = new BigInteger(1, inetAddress.getAddress()).and(not);
        BigInteger add = and.add(not.not());
        BigInteger bigInteger = new BigInteger(1, inetAddress2.getAddress());
        return bigInteger.compareTo(and) >= 0 && bigInteger.compareTo(add) <= 0;
    }

    public static boolean supportsFileDialog(Context context, Intent intent) {
        ComponentName resolveActivity = intent.resolveActivity(context.getPackageManager());
        return resolveActivity != null && !"com.google.android.tv.frameworkpackagestubs".equals(resolveActivity.getPackageName());
    }

    public static String table2Text(TableLayout tableLayout) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            View childAt = tableLayout.getChildAt(i);
            if ((childAt instanceof TableRow) && childAt.getVisibility() == 0) {
                TableRow tableRow = (TableRow) childAt;
                if (tableRow.getChildCount() == 2) {
                    View childAt2 = tableRow.getChildAt(0);
                    View childAt3 = tableRow.getChildAt(1);
                    if (childAt3 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) childAt3;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= viewGroup.getChildCount()) {
                                break;
                            }
                            View childAt4 = viewGroup.getChildAt(i2);
                            if (childAt4 instanceof TextView) {
                                childAt3 = childAt4;
                                break;
                            }
                            i2++;
                        }
                    }
                    if ((childAt2 instanceof TextView) && (childAt3 instanceof TextView)) {
                        sb.append(((TextView) childAt2).getText());
                        sb.append(": ");
                        sb.append(((TextView) childAt3).getText());
                        sb.append("\n");
                    }
                }
            }
        }
        return sb.toString();
    }

    public static String tcpFlagsToStr(int i) {
        String[] strArr = {"FIN", "SYN", "RST", "PSH", "ACK", "URG", "ECN", "CWR"};
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (int i2 = 0; i2 < 8; i2++) {
            if (((1 << i2) & i) != 0) {
                if (!z) {
                    sb.append(" ");
                }
                sb.append(strArr[i2]);
                z = false;
            }
        }
        return sb.toString();
    }

    public static String trimlvl2str(int i) {
        if (i == 5) {
            return "TRIM_MEMORY_RUNNING_MODERATE";
        }
        if (i == 10) {
            return "TRIM_MEMORY_RUNNING_LOW";
        }
        if (i == 15) {
            return "TRIM_MEMORY_RUNNING_CRITICAL";
        }
        if (i == 20) {
            return "TRIM_MEMORY_UI_HIDDEN";
        }
        if (i == 40) {
            return "TRIM_MEMORY_BACKGROUND";
        }
        if (i == 60) {
            return "TRIM_MEMORY_MODERATE";
        }
        if (i != 80) {
            return "TRIM_UNKNOWN";
        }
        return "TRIM_MEMORY_COMPLETE";
    }

    public static boolean ungzip(InputStream inputStream, String str) {
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = gZIPInputStream.read(bArr);
                    if (read != -1) {
                        bufferedOutputStream.write(bArr, 0, read);
                    } else {
                        bufferedOutputStream.close();
                        gZIPInputStream.close();
                        return true;
                    }
                }
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String uriToFilePath(Context context, Uri uri) {
        if (uri == null) {
            return null;
        }
        if (isExternalStorageDocument(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if ("primary".equalsIgnoreCase(split[0])) {
                return Environment.getExternalStorageDirectory() + "/" + split[1];
            }
        } else if (isDownloadsDocument(uri)) {
            return downloadsUriToPath(context, uri);
        } else {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return mediastoreUriToPath(context, uri);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public static boolean validateCidr(String str) {
        int parseInt;
        String substring;
        boolean z;
        int indexOf = str.indexOf(47);
        if (indexOf < 0) {
            return validateIpAddress(str);
        }
        try {
            parseInt = Integer.parseInt(str.substring(indexOf + 1));
            substring = str.substring(0, indexOf);
        } catch (NumberFormatException unused) {
        }
        if (!validateIpAddress(substring)) {
            return false;
        }
        if (substring.indexOf(58) >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (parseInt < 0 || ((!z || parseInt > 128) && (z || parseInt > 32))) {
            return false;
        }
        return true;
    }

    public static boolean validateHost(String str) {
        int length = str.length();
        if (length < 2 || length > 67 || str.charAt(0) == '-' || str.charAt(length - 1) == '-' || str.matches(".*[A-Z\\s?!=`@].*")) {
            return false;
        }
        return true;
    }

    public static boolean validateIpAddress(String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return InetAddresses.isNumericAddress(str);
        }
        return Patterns.IP_ADDRESS.matcher(str).matches();
    }

    public static boolean validateIpv4Address(String str) {
        return IPV4_PATTERN.matcher(str).matches();
    }

    public static boolean validateIpv6Address(String str) {
        if (!isValidIPv6(str) || validateIpv4Address(str)) {
            return false;
        }
        return true;
    }

    public static boolean validatePort(String str) {
        int parseInt;
        try {
            parseInt = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        if (parseInt <= 0 || parseInt >= 65535) {
            return false;
        }
        return true;
    }

    public static X509Certificate x509FromPem(String str) {
        int indexOf = str.indexOf(10) + 1;
        int indexOf2 = str.indexOf(45, indexOf);
        if (indexOf <= 0 || indexOf2 <= indexOf) {
            return null;
        }
        try {
            return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(Base64.decode(str.substring(indexOf, indexOf2), 0)));
        } catch (CertificateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void showHelpDialog(Context context, CharSequence charSequence) {
        zzbv zzbvVar = new zzbv(context);
        zzbvVar.setTitle(C0130R.string.hint);
        AlertController.AlertParams alertParams = (AlertController.AlertParams) zzbvVar.zza;
        alertParams.mMessage = charSequence;
        alertParams.mCancelable = true;
        zzbvVar.setNeutralButton(C0130R.string.ok, new Utils$$ExternalSyntheticLambda1(0));
        AlertDialog create = zzbvVar.create();
        create.show();
        TextView textView = (TextView) create.findViewById(16908299);
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static boolean supportsFileDialog(Context context) {
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        return supportsFileDialog(context, intent);
    }

    public static boolean isCAInstalled(String str) {
        X509Certificate x509FromPem;
        if (str == null || (x509FromPem = x509FromPem(str)) == null) {
            return false;
        }
        return isCAInstalled(x509FromPem);
    }

    public static void copy(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static boolean isLocalNetworkAddress(String str) {
        if (!validateIpAddress(str)) {
            return false;
        }
        try {
            return isLocalNetworkAddress(InetAddress.getByName(str));
        } catch (UnknownHostException unused) {
            return false;
        }
    }

    public static boolean subnetContains(String str, int i, String str2) {
        try {
            return subnetContains(InetAddress.getByName(str), i, InetAddress.getByName(str2));
        } catch (UnknownHostException unused) {
            return false;
        }
    }

    public static String hexdump(byte[] bArr) {
        return hexdump(bArr, 0, bArr.length);
    }

    public static BuildType getVerifiedBuild(Context context) {
        return getVerifiedBuild(context, context.getPackageName());
    }
}
