package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.appcompat.widget.TooltipPopup;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import com.emanuelef.remote_capture.fragments.prefs.GeoipSettings$$ExternalSyntheticLambda3;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.cct.internal.AutoValue_AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_BatchedLogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_ClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_LogEvent;
import com.google.android.datatransport.cct.internal.AutoValue_LogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.ProtoEncoderDoNotUse;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendResponse;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_PersistedEvent;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$ExternalSyntheticLambda3;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.text.MatcherMatchResult;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public final class Uploader {
    public final MetadataBackendRegistry backendRegistry;
    public final ClientHealthMetricsStore clientHealthMetricsStore;
    public final Clock clock;
    public final Context context;
    public final EventStore eventStore;
    public final Executor executor;
    public final SynchronizationGuard guard;
    public final Clock uptimeClock;
    public final MatcherMatchResult workScheduler;

    public Uploader(Context context, MetadataBackendRegistry metadataBackendRegistry, EventStore eventStore, MatcherMatchResult matcherMatchResult, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        this.context = context;
        this.backendRegistry = metadataBackendRegistry;
        this.eventStore = eventStore;
        this.workScheduler = matcherMatchResult;
        this.executor = executor;
        this.guard = synchronizationGuard;
        this.clock = clock;
        this.uptimeClock = clock2;
        this.clientHealthMetricsStore = clientHealthMetricsStore;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03df A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v45, types: [androidx.appcompat.widget.TooltipPopup, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v22, types: [androidx.appcompat.widget.TooltipPopup, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object, androidx.appcompat.widget.AppCompatDrawableManager$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void logAndUpdateState(final AutoValue_TransportContext autoValue_TransportContext, int i) {
        long j;
        byte[] bArr;
        int i2;
        AutoValue_BackendResponse autoValue_BackendResponse;
        int i3;
        String str;
        IOException e;
        CctTransportBackend.HttpResponse apply;
        String str2;
        Integer num;
        TooltipPopup tooltipPopup;
        long j2;
        String str3;
        ArrayList arrayList;
        final Uploader uploader = this;
        final AutoValue_TransportContext autoValue_TransportContext2 = autoValue_TransportContext;
        byte[] bArr2 = autoValue_TransportContext2.extras;
        TransportBackend transportBackend = uploader.backendRegistry.get(autoValue_TransportContext2.backendName);
        long j3 = 0;
        while (true) {
            SynchronizationGuard.CriticalSection uploader$$ExternalSyntheticLambda3 = new SynchronizationGuard.CriticalSection(uploader) { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda3
                public final /* synthetic */ Uploader f$0;

                {
                    this.f$0 = uploader;
                }

                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object execute() {
                    Boolean bool;
                    switch (r3) {
                        case 0:
                            AutoValue_TransportContext autoValue_TransportContext3 = autoValue_TransportContext2;
                            SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) this.f$0.eventStore;
                            SQLiteDatabase db = sQLiteEventStore.getDb();
                            db.beginTransaction();
                            try {
                                Long transportContextId = SQLiteEventStore.getTransportContextId(db, autoValue_TransportContext3);
                                if (transportContextId == null) {
                                    bool = Boolean.FALSE;
                                } else {
                                    Cursor rawQuery = sQLiteEventStore.getDb().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{transportContextId.toString()});
                                    Boolean valueOf = Boolean.valueOf(rawQuery.moveToNext());
                                    rawQuery.close();
                                    bool = valueOf;
                                }
                                db.setTransactionSuccessful();
                                return bool;
                            } finally {
                                db.endTransaction();
                            }
                        default:
                            SQLiteEventStore sQLiteEventStore2 = (SQLiteEventStore) this.f$0.eventStore;
                            sQLiteEventStore2.getClass();
                            return (Iterable) sQLiteEventStore2.inTransaction(new GeoipSettings$$ExternalSyntheticLambda3(sQLiteEventStore2, 5, autoValue_TransportContext2));
                    }
                }
            };
            SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) uploader.guard;
            if (((Boolean) sQLiteEventStore.runCriticalSection(uploader$$ExternalSyntheticLambda3)).booleanValue()) {
                final Iterable<AutoValue_PersistedEvent> iterable = (Iterable) sQLiteEventStore.runCriticalSection(new SynchronizationGuard.CriticalSection(uploader) { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda3
                    public final /* synthetic */ Uploader f$0;

                    {
                        this.f$0 = uploader;
                    }

                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        Boolean bool;
                        switch (r3) {
                            case 0:
                                AutoValue_TransportContext autoValue_TransportContext3 = autoValue_TransportContext2;
                                SQLiteEventStore sQLiteEventStore2 = (SQLiteEventStore) this.f$0.eventStore;
                                SQLiteDatabase db = sQLiteEventStore2.getDb();
                                db.beginTransaction();
                                try {
                                    Long transportContextId = SQLiteEventStore.getTransportContextId(db, autoValue_TransportContext3);
                                    if (transportContextId == null) {
                                        bool = Boolean.FALSE;
                                    } else {
                                        Cursor rawQuery = sQLiteEventStore2.getDb().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{transportContextId.toString()});
                                        Boolean valueOf = Boolean.valueOf(rawQuery.moveToNext());
                                        rawQuery.close();
                                        bool = valueOf;
                                    }
                                    db.setTransactionSuccessful();
                                    return bool;
                                } finally {
                                    db.endTransaction();
                                }
                            default:
                                SQLiteEventStore sQLiteEventStore22 = (SQLiteEventStore) this.f$0.eventStore;
                                sQLiteEventStore22.getClass();
                                return (Iterable) sQLiteEventStore22.inTransaction(new GeoipSettings$$ExternalSyntheticLambda3(sQLiteEventStore22, 5, autoValue_TransportContext2));
                        }
                    }
                });
                if (iterable.iterator().hasNext()) {
                    if (transportBackend == null) {
                        Navigation.m590d("Uploader", "Unknown backend for %s, deleting event batch for it...", autoValue_TransportContext2);
                        autoValue_BackendResponse = new AutoValue_BackendResponse(3, -1L);
                        bArr = bArr2;
                        j = j3;
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        for (AutoValue_PersistedEvent autoValue_PersistedEvent : iterable) {
                            arrayList2.add(autoValue_PersistedEvent.event);
                        }
                        if (bArr2 != null) {
                            ClientHealthMetricsStore clientHealthMetricsStore = uploader.clientHealthMetricsStore;
                            Objects.requireNonNull(clientHealthMetricsStore);
                            ClientMetrics clientMetrics = (ClientMetrics) sQLiteEventStore.runCriticalSection(new InputConnectionCompat$$ExternalSyntheticLambda0(12, clientHealthMetricsStore));
                            ?? obj = new Object();
                            obj.TINT_CHECKABLE_BUTTON_LIST = new HashMap();
                            obj.COLORFILTER_COLOR_BACKGROUND_MULTIPLY = Long.valueOf(uploader.clock.getTime());
                            obj.TINT_COLOR_CONTROL_STATE_LIST = Long.valueOf(uploader.uptimeClock.getTime());
                            obj.COLORFILTER_TINT_COLOR_CONTROL_NORMAL = "GDT_CLIENT_METRICS";
                            Encoding encoding = new Encoding("proto");
                            clientMetrics.getClass();
                            MatcherMatchResult matcherMatchResult = ProtoEncoderDoNotUse.ENCODER;
                            matcherMatchResult.getClass();
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                matcherMatchResult.encode(clientMetrics, byteArrayOutputStream);
                            } catch (IOException unused) {
                            }
                            obj.COLORFILTER_COLOR_CONTROL_ACTIVATED = new EncodedPayload(encoding, byteArrayOutputStream.toByteArray());
                            arrayList2.add(((CctTransportBackend) transportBackend).decorate(obj.build()));
                        }
                        CctTransportBackend cctTransportBackend = (CctTransportBackend) transportBackend;
                        HashMap hashMap = new HashMap();
                        int size = arrayList2.size();
                        int i4 = 0;
                        while (i4 < size) {
                            Object obj2 = arrayList2.get(i4);
                            i4++;
                            AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) obj2;
                            String str4 = autoValue_EventInternal.transportName;
                            if (!hashMap.containsKey(str4)) {
                                arrayList = arrayList2;
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(autoValue_EventInternal);
                                hashMap.put(str4, arrayList3);
                            } else {
                                arrayList = arrayList2;
                                ((List) hashMap.get(str4)).add(autoValue_EventInternal);
                            }
                            arrayList2 = arrayList;
                        }
                        ArrayList arrayList4 = new ArrayList();
                        for (Map.Entry entry : hashMap.entrySet()) {
                            AutoValue_EventInternal autoValue_EventInternal2 = (AutoValue_EventInternal) ((List) entry.getValue()).get(0);
                            QosTier qosTier = QosTier.DEFAULT;
                            long time = cctTransportBackend.wallTimeClock.getTime();
                            long time2 = cctTransportBackend.uptimeClock.getTime();
                            AutoValue_ClientInfo autoValue_ClientInfo = new AutoValue_ClientInfo(new AutoValue_AndroidClientInfo(Integer.valueOf(autoValue_EventInternal2.getInteger("sdk-version")), autoValue_EventInternal2.get("model"), autoValue_EventInternal2.get("hardware"), autoValue_EventInternal2.get("device"), autoValue_EventInternal2.get("product"), autoValue_EventInternal2.get("os-uild"), autoValue_EventInternal2.get("manufacturer"), autoValue_EventInternal2.get("fingerprint"), autoValue_EventInternal2.get("locale"), autoValue_EventInternal2.get("country"), autoValue_EventInternal2.get("mcc_mnc"), autoValue_EventInternal2.get("application_build")));
                            try {
                                num = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                                str2 = null;
                            } catch (NumberFormatException unused2) {
                                str2 = (String) entry.getKey();
                                num = null;
                            }
                            ArrayList arrayList5 = new ArrayList();
                            for (AutoValue_EventInternal autoValue_EventInternal3 : (List) entry.getValue()) {
                                byte[] bArr3 = bArr2;
                                EncodedPayload encodedPayload = autoValue_EventInternal3.encodedPayload;
                                Encoding encoding2 = encodedPayload.encoding;
                                byte[] bArr4 = encodedPayload.bytes;
                                long j4 = j3;
                                if (encoding2.equals(new Encoding("proto"))) {
                                    ?? obj3 = new Object();
                                    obj3.mLayoutParams = bArr4;
                                    tooltipPopup = obj3;
                                } else if (encoding2.equals(new Encoding("json"))) {
                                    String str5 = new String(bArr4, Charset.forName("UTF-8"));
                                    ?? obj4 = new Object();
                                    obj4.mTmpDisplayFrame = str5;
                                    tooltipPopup = obj4;
                                } else {
                                    String tag = Navigation.getTag("CctTransportBackend");
                                    if (Log.isLoggable(tag, 5)) {
                                        Log.w(tag, "Received event of unsupported encoding " + encoding2 + ". Skipping...");
                                    }
                                    bArr2 = bArr3;
                                    j3 = j4;
                                }
                                tooltipPopup.mContext = Long.valueOf(autoValue_EventInternal3.eventMillis);
                                tooltipPopup.mMessageView = Long.valueOf(autoValue_EventInternal3.uptimeMillis);
                                String str6 = (String) autoValue_EventInternal3.autoMetadata.get("tz-offset");
                                if (str6 == null) {
                                    j2 = 0;
                                } else {
                                    j2 = Long.valueOf(str6).longValue();
                                }
                                tooltipPopup.mTmpAnchorPos = Long.valueOf(j2);
                                tooltipPopup.mTmpAppPos = new AutoValue_NetworkConnectionInfo((NetworkConnectionInfo.NetworkType) NetworkConnectionInfo.NetworkType.valueMap.get(autoValue_EventInternal3.getInteger("net-type")), (NetworkConnectionInfo.MobileSubtype) NetworkConnectionInfo.MobileSubtype.valueMap.get(autoValue_EventInternal3.getInteger("mobile-subtype")));
                                Integer num2 = autoValue_EventInternal3.code;
                                if (num2 != null) {
                                    tooltipPopup.mContentView = num2;
                                }
                                if (((Long) tooltipPopup.mContext) == null) {
                                    str3 = " eventTimeMs";
                                } else {
                                    str3 = "";
                                }
                                if (((Long) tooltipPopup.mMessageView) == null) {
                                    str3 = str3.concat(" eventUptimeMs");
                                }
                                if (((Long) tooltipPopup.mTmpAnchorPos) == null) {
                                    str3 = ViewModelProvider.Factory.CC.m596m(str3, " timezoneOffsetSeconds");
                                }
                                if (str3.isEmpty()) {
                                    arrayList5.add(new AutoValue_LogEvent(((Long) tooltipPopup.mContext).longValue(), (Integer) tooltipPopup.mContentView, ((Long) tooltipPopup.mMessageView).longValue(), (byte[]) tooltipPopup.mLayoutParams, (String) tooltipPopup.mTmpDisplayFrame, ((Long) tooltipPopup.mTmpAnchorPos).longValue(), (AutoValue_NetworkConnectionInfo) tooltipPopup.mTmpAppPos));
                                    bArr2 = bArr3;
                                    j3 = j4;
                                } else {
                                    throw new IllegalStateException("Missing required properties:".concat(str3));
                                }
                            }
                            arrayList4.add(new AutoValue_LogRequest(time, time2, autoValue_ClientInfo, num, str2, arrayList5));
                        }
                        bArr = bArr2;
                        j = j3;
                        AutoValue_BatchedLogRequest autoValue_BatchedLogRequest = new AutoValue_BatchedLogRequest(arrayList4);
                        URL url = cctTransportBackend.endPoint;
                        if (bArr != null) {
                            try {
                                CCTDestination fromByteArray = CCTDestination.fromByteArray(bArr);
                                str = fromByteArray.apiKey;
                                if (str == null) {
                                    str = null;
                                }
                                String str7 = fromByteArray.endPoint;
                                if (str7 != null) {
                                    url = CctTransportBackend.parseUrlOrThrow(str7);
                                }
                            } catch (IllegalArgumentException unused3) {
                                autoValue_BackendResponse = new AutoValue_BackendResponse(3, -1L);
                            }
                        } else {
                            str = null;
                        }
                        try {
                            MatcherMatchResult matcherMatchResult2 = new MatcherMatchResult(url, autoValue_BatchedLogRequest, str, 10);
                            InputConnectionCompat$$ExternalSyntheticLambda0 inputConnectionCompat$$ExternalSyntheticLambda0 = new InputConnectionCompat$$ExternalSyntheticLambda0(11, cctTransportBackend);
                            int i5 = 5;
                            do {
                                apply = inputConnectionCompat$$ExternalSyntheticLambda0.apply(matcherMatchResult2);
                                URL url2 = apply.redirectUrl;
                                if (url2 != null) {
                                    Navigation.m590d("CctTransportBackend", "Following redirect to: %s", url2);
                                    matcherMatchResult2 = new MatcherMatchResult(url2, (AutoValue_BatchedLogRequest) matcherMatchResult2.input, (String) matcherMatchResult2.groups, 10);
                                } else {
                                    matcherMatchResult2 = null;
                                }
                                if (matcherMatchResult2 == null) {
                                    break;
                                }
                                i5--;
                            } while (i5 >= 1);
                            int i6 = apply.code;
                            if (i6 == 200) {
                                autoValue_BackendResponse = new AutoValue_BackendResponse(1, apply.nextRequestMillis);
                            } else if (i6 >= 500 || i6 == 404) {
                                autoValue_BackendResponse = new AutoValue_BackendResponse(2, -1L);
                            } else if (i6 == 400) {
                                try {
                                    autoValue_BackendResponse = new AutoValue_BackendResponse(4, -1L);
                                } catch (IOException e2) {
                                    e = e2;
                                    Navigation.m589e("CctTransportBackend", "Could not make request to the backend", e);
                                    i2 = 2;
                                    autoValue_BackendResponse = new AutoValue_BackendResponse(2, -1L);
                                    i3 = autoValue_BackendResponse.status;
                                    if (i3 != i2) {
                                    }
                                }
                            } else {
                                autoValue_BackendResponse = new AutoValue_BackendResponse(3, -1L);
                            }
                        } catch (IOException e3) {
                            e = e3;
                        }
                    }
                    i2 = 2;
                    i3 = autoValue_BackendResponse.status;
                    if (i3 != i2) {
                        final long j5 = j;
                        sQLiteEventStore.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda5
                            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                            public final Object execute() {
                                Iterable iterable2;
                                Uploader uploader2 = Uploader.this;
                                SQLiteEventStore sQLiteEventStore2 = (SQLiteEventStore) uploader2.eventStore;
                                sQLiteEventStore2.getClass();
                                if (iterable.iterator().hasNext()) {
                                    String str8 = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + SQLiteEventStore.toIdList(iterable2);
                                    SQLiteDatabase db = sQLiteEventStore2.getDb();
                                    db.beginTransaction();
                                    try {
                                        db.compileStatement(str8).execute();
                                        Cursor rawQuery = db.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", null);
                                        while (rawQuery.moveToNext()) {
                                            sQLiteEventStore2.recordLogEventDropped(rawQuery.getInt(0), LogEventDropped.Reason.MAX_RETRIES_REACHED, rawQuery.getString(1));
                                        }
                                        rawQuery.close();
                                        db.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                                        db.setTransactionSuccessful();
                                    } finally {
                                        db.endTransaction();
                                    }
                                }
                                sQLiteEventStore2.inTransaction(new SQLiteEventStore$$ExternalSyntheticLambda3(uploader2.clock.getTime() + j5, autoValue_TransportContext));
                                return null;
                            }
                        });
                        this.workScheduler.schedule(autoValue_TransportContext, i + 1, true);
                        return;
                    }
                    uploader = this;
                    autoValue_TransportContext2 = autoValue_TransportContext;
                    long j6 = j;
                    sQLiteEventStore.runCriticalSection(new GeoipSettings$$ExternalSyntheticLambda3(uploader, 3, iterable));
                    if (i3 == 1) {
                        j3 = Math.max(j6, autoValue_BackendResponse.nextRequestWaitMillis);
                        if (bArr != null) {
                            sQLiteEventStore.runCriticalSection(new InputConnectionCompat$$ExternalSyntheticLambda0(14, uploader));
                        }
                    } else {
                        if (i3 == 4) {
                            HashMap hashMap2 = new HashMap();
                            for (AutoValue_PersistedEvent autoValue_PersistedEvent2 : iterable) {
                                String str8 = autoValue_PersistedEvent2.event.transportName;
                                if (!hashMap2.containsKey(str8)) {
                                    hashMap2.put(str8, 1);
                                } else {
                                    hashMap2.put(str8, Integer.valueOf(((Integer) hashMap2.get(str8)).intValue() + 1));
                                }
                            }
                            sQLiteEventStore.runCriticalSection(new GeoipSettings$$ExternalSyntheticLambda3(uploader, 4, hashMap2));
                        }
                        j3 = j6;
                    }
                    bArr2 = bArr;
                } else {
                    return;
                }
            } else {
                sQLiteEventStore.runCriticalSection(new Uploader$$ExternalSyntheticLambda9(j3, uploader, autoValue_TransportContext2));
                return;
            }
        }
    }
}
