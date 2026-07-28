package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.navigation.Navigation;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$ClientInfoEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$LogEventEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$LogRequestEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder;
import com.google.android.datatransport.cct.internal.AutoValue_AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_BatchedLogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_ClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_LogEvent;
import com.google.android.datatransport.cct.internal.AutoValue_LogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
/* loaded from: classes.dex */
public final class CctTransportBackend implements TransportBackend {
    public final Context applicationContext;
    public final ConnectivityManager connectivityManager;
    public final ReadonlyStateFlow dataEncoder;
    public final URL endPoint = parseUrlOrThrow(CCTDestination.DEFAULT_END_POINT);
    public final int readTimeout = 130000;
    public final Clock uptimeClock;
    public final Clock wallTimeClock;

    /* loaded from: classes.dex */
    public final class HttpResponse {
        public final int code;
        public final long nextRequestMillis;
        public final URL redirectUrl;

        public HttpResponse(int i, URL url, long j) {
            this.code = i;
            this.redirectUrl = url;
            this.nextRequestMillis = j;
        }
    }

    public CctTransportBackend(Context context, Clock clock, Clock clock2) {
        JsonDataEncoderBuilder jsonDataEncoderBuilder = new JsonDataEncoderBuilder();
        AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder autoBatchedLogRequestEncoder$BatchedLogRequestEncoder = AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(BatchedLogRequest.class, autoBatchedLogRequestEncoder$BatchedLogRequestEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_BatchedLogRequest.class, autoBatchedLogRequestEncoder$BatchedLogRequestEncoder);
        AutoBatchedLogRequestEncoder$LogRequestEncoder autoBatchedLogRequestEncoder$LogRequestEncoder = AutoBatchedLogRequestEncoder$LogRequestEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(LogRequest.class, autoBatchedLogRequestEncoder$LogRequestEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_LogRequest.class, autoBatchedLogRequestEncoder$LogRequestEncoder);
        AutoBatchedLogRequestEncoder$ClientInfoEncoder autoBatchedLogRequestEncoder$ClientInfoEncoder = AutoBatchedLogRequestEncoder$ClientInfoEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(ClientInfo.class, autoBatchedLogRequestEncoder$ClientInfoEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_ClientInfo.class, autoBatchedLogRequestEncoder$ClientInfoEncoder);
        AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder autoBatchedLogRequestEncoder$AndroidClientInfoEncoder = AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(AndroidClientInfo.class, autoBatchedLogRequestEncoder$AndroidClientInfoEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_AndroidClientInfo.class, autoBatchedLogRequestEncoder$AndroidClientInfoEncoder);
        AutoBatchedLogRequestEncoder$LogEventEncoder autoBatchedLogRequestEncoder$LogEventEncoder = AutoBatchedLogRequestEncoder$LogEventEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(LogEvent.class, autoBatchedLogRequestEncoder$LogEventEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_LogEvent.class, autoBatchedLogRequestEncoder$LogEventEncoder);
        AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder autoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder = AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(NetworkConnectionInfo.class, autoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_NetworkConnectionInfo.class, autoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder);
        jsonDataEncoderBuilder.ignoreNullValues = true;
        this.dataEncoder = new ReadonlyStateFlow(jsonDataEncoderBuilder);
        this.applicationContext = context;
        this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.uptimeClock = clock2;
        this.wallTimeClock = clock;
    }

    public static URL parseUrlOrThrow(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid url: " + str, e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a7, code lost:
        if (((com.google.android.datatransport.cct.internal.NetworkConnectionInfo.MobileSubtype) com.google.android.datatransport.cct.internal.NetworkConnectionInfo.MobileSubtype.valueMap.get(r0)) != null) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AutoValue_EventInternal decorate(AutoValue_EventInternal autoValue_EventInternal) {
        int i;
        int i2;
        HashMap hashMap;
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        AppCompatDrawableManager.C00231 builder = autoValue_EventInternal.toBuilder();
        int i3 = Build.VERSION.SDK_INT;
        HashMap hashMap2 = (HashMap) builder.TINT_CHECKABLE_BUTTON_LIST;
        if (hashMap2 != null) {
            hashMap2.put("sdk-version", String.valueOf(i3));
            builder.addMetadata("model", Build.MODEL);
            builder.addMetadata("hardware", Build.HARDWARE);
            builder.addMetadata("device", Build.DEVICE);
            builder.addMetadata("product", Build.PRODUCT);
            builder.addMetadata("os-uild", Build.ID);
            builder.addMetadata("manufacturer", Build.MANUFACTURER);
            builder.addMetadata("fingerprint", Build.FINGERPRINT);
            Calendar.getInstance();
            long offset = TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
            HashMap hashMap3 = (HashMap) builder.TINT_CHECKABLE_BUTTON_LIST;
            if (hashMap3 != null) {
                hashMap3.put("tz-offset", String.valueOf(offset));
                int i4 = -1;
                if (activeNetworkInfo == null) {
                    SparseArray sparseArray = NetworkConnectionInfo.NetworkType.valueMap;
                    i = -1;
                } else {
                    i = activeNetworkInfo.getType();
                }
                HashMap hashMap4 = (HashMap) builder.TINT_CHECKABLE_BUTTON_LIST;
                if (hashMap4 != null) {
                    hashMap4.put("net-type", String.valueOf(i));
                    if (activeNetworkInfo == null) {
                        SparseArray sparseArray2 = NetworkConnectionInfo.MobileSubtype.valueMap;
                    } else {
                        i2 = activeNetworkInfo.getSubtype();
                        if (i2 == -1) {
                            SparseArray sparseArray3 = NetworkConnectionInfo.MobileSubtype.valueMap;
                            i2 = 100;
                        }
                        hashMap = (HashMap) builder.TINT_CHECKABLE_BUTTON_LIST;
                        if (hashMap == null) {
                            hashMap.put("mobile-subtype", String.valueOf(i2));
                            builder.addMetadata("country", Locale.getDefault().getCountry());
                            builder.addMetadata("locale", Locale.getDefault().getLanguage());
                            Context context = this.applicationContext;
                            builder.addMetadata("mcc_mnc", ((TelephonyManager) context.getSystemService("phone")).getSimOperator());
                            try {
                                i4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                            } catch (PackageManager.NameNotFoundException e) {
                                Navigation.m589e("CctTransportBackend", "Unable to find version code for package", e);
                            }
                            builder.addMetadata("application_build", Integer.toString(i4));
                            return builder.build();
                        }
                        throw new IllegalStateException("Property \"autoMetadata\" has not been set");
                    }
                    i2 = 0;
                    hashMap = (HashMap) builder.TINT_CHECKABLE_BUTTON_LIST;
                    if (hashMap == null) {
                    }
                } else {
                    throw new IllegalStateException("Property \"autoMetadata\" has not been set");
                }
            } else {
                throw new IllegalStateException("Property \"autoMetadata\" has not been set");
            }
        } else {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
    }
}
