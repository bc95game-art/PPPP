package androidx.transition;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import android.util.Log;
import androidx.emoji2.text.MetadataRepo;
import androidx.navigation.Navigation;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_PersistedEvent;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p004j$.util.DesugarCollections;
/* loaded from: classes.dex */
public final /* synthetic */ class FragmentTransitionSupport$$ExternalSyntheticLambda0 implements SynchronizationGuard.CriticalSection, SQLiteEventStore.Function {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ FragmentTransitionSupport$$ExternalSyntheticLambda0(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$2 = obj2;
        this.f$1 = obj3;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x007f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object, androidx.appcompat.widget.AppCompatDrawableManager$1] */
    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object apply(Object obj) {
        long j;
        boolean z;
        byte[] bArr;
        boolean z2;
        Encoding encoding;
        Cursor cursor;
        Throwable th;
        Encoding encoding2;
        LogEventDropped.Reason reason;
        int i = this.$r8$classId;
        int i2 = 5;
        int i3 = 4;
        int i4 = 3;
        LogEventDropped.Reason reason2 = LogEventDropped.Reason.CACHE_FULL;
        int i5 = 2;
        int i6 = 1;
        Object obj2 = this.f$1;
        Object obj3 = this.f$2;
        int i7 = 0;
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) this.f$0;
        switch (i) {
            case 2:
                AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) obj3;
                EncodedPayload encodedPayload = autoValue_EventInternal.encodedPayload;
                String str = autoValue_EventInternal.transportName;
                AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) obj2;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                long simpleQueryForLong = sQLiteEventStore.getDb().compileStatement("PRAGMA page_size").simpleQueryForLong() * sQLiteEventStore.getDb().compileStatement("PRAGMA page_count").simpleQueryForLong();
                AutoValue_EventStoreConfig autoValue_EventStoreConfig = sQLiteEventStore.config;
                if (simpleQueryForLong >= autoValue_EventStoreConfig.maxStorageSizeInBytes) {
                    sQLiteEventStore.recordLogEventDropped(1L, reason2, str);
                    return -1L;
                }
                Long transportContextId = SQLiteEventStore.getTransportContextId(sQLiteDatabase, autoValue_TransportContext);
                if (transportContextId != null) {
                    j = transportContextId.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", autoValue_TransportContext.backendName);
                    contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(autoValue_TransportContext.priority)));
                    contentValues.put("next_request_ms", (Integer) 0);
                    byte[] bArr2 = autoValue_TransportContext.extras;
                    if (bArr2 != null) {
                        contentValues.put("extras", Base64.encodeToString(bArr2, 0));
                    }
                    j = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                int i8 = autoValue_EventStoreConfig.maxBlobByteSizePerRow;
                byte[] bArr3 = encodedPayload.bytes;
                if (bArr3.length <= i8) {
                    z = true;
                } else {
                    z = false;
                }
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(j));
                contentValues2.put("transport_name", str);
                contentValues2.put("timestamp_ms", Long.valueOf(autoValue_EventInternal.eventMillis));
                contentValues2.put("uptime_ms", Long.valueOf(autoValue_EventInternal.uptimeMillis));
                contentValues2.put("payload_encoding", encodedPayload.encoding.name);
                contentValues2.put("code", autoValue_EventInternal.code);
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put("inline", Boolean.valueOf(z));
                if (z) {
                    bArr = bArr3;
                } else {
                    bArr = new byte[0];
                }
                contentValues2.put("payload", bArr);
                long insert = sQLiteDatabase.insert("events", null, contentValues2);
                if (!z) {
                    int ceil = (int) Math.ceil(bArr3.length / i8);
                    for (int i9 = 1; i9 <= ceil; i9++) {
                        byte[] copyOfRange = Arrays.copyOfRange(bArr3, (i9 - 1) * i8, Math.min(i9 * i8, bArr3.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("event_id", Long.valueOf(insert));
                        contentValues3.put("sequence_num", Integer.valueOf(i9));
                        contentValues3.put("bytes", copyOfRange);
                        sQLiteDatabase.insert("event_payloads", null, contentValues3);
                    }
                }
                for (Map.Entry entry : DesugarCollections.unmodifiableMap(autoValue_EventInternal.autoMetadata).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(insert));
                    contentValues4.put("name", (String) entry.getKey());
                    contentValues4.put("value", (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(insert);
            case 3:
                ArrayList arrayList = (ArrayList) obj3;
                AutoValue_TransportContext autoValue_TransportContext2 = (AutoValue_TransportContext) obj2;
                Cursor cursor2 = (Cursor) obj;
                while (cursor2.moveToNext()) {
                    long j2 = cursor2.getLong(0);
                    if (cursor2.getInt(7) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    ?? obj4 = new Object();
                    obj4.TINT_CHECKABLE_BUTTON_LIST = new HashMap();
                    String string = cursor2.getString(i6);
                    if (string != null) {
                        obj4.COLORFILTER_TINT_COLOR_CONTROL_NORMAL = string;
                        obj4.COLORFILTER_COLOR_BACKGROUND_MULTIPLY = Long.valueOf(cursor2.getLong(i5));
                        obj4.TINT_COLOR_CONTROL_STATE_LIST = Long.valueOf(cursor2.getLong(3));
                        if (z2) {
                            String string2 = cursor2.getString(4);
                            if (string2 == null) {
                                encoding2 = SQLiteEventStore.PROTOBUF_ENCODING;
                            } else {
                                encoding2 = new Encoding(string2);
                            }
                            obj4.COLORFILTER_COLOR_CONTROL_ACTIVATED = new EncodedPayload(encoding2, cursor2.getBlob(5));
                        } else {
                            String string3 = cursor2.getString(4);
                            if (string3 == null) {
                                encoding = SQLiteEventStore.PROTOBUF_ENCODING;
                            } else {
                                encoding = new Encoding(string3);
                            }
                            Cursor query = sQLiteEventStore.getDb().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j2)}, null, null, "sequence_num");
                            try {
                                ArrayList arrayList2 = new ArrayList();
                                int i10 = 0;
                                while (query.moveToNext()) {
                                    byte[] blob = query.getBlob(0);
                                    arrayList2.add(blob);
                                    i10 += blob.length;
                                }
                                byte[] bArr4 = new byte[i10];
                                int i11 = 0;
                                int i12 = 0;
                                while (i11 < arrayList2.size()) {
                                    byte[] bArr5 = (byte[]) arrayList2.get(i11);
                                    cursor = query;
                                    try {
                                        ArrayList arrayList3 = arrayList2;
                                        System.arraycopy(bArr5, 0, bArr4, i12, bArr5.length);
                                        i12 += bArr5.length;
                                        i11++;
                                        query = cursor;
                                        arrayList2 = arrayList3;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        cursor.close();
                                        throw th;
                                    }
                                }
                                query.close();
                                obj4.COLORFILTER_COLOR_CONTROL_ACTIVATED = new EncodedPayload(encoding, bArr4);
                            } catch (Throwable th3) {
                                th = th3;
                                cursor = query;
                            }
                        }
                        if (!cursor2.isNull(6)) {
                            obj4.TINT_COLOR_CONTROL_NORMAL = Integer.valueOf(cursor2.getInt(6));
                        }
                        arrayList.add(new AutoValue_PersistedEvent(j2, autoValue_TransportContext2, obj4.build()));
                        i5 = 2;
                        i6 = 1;
                    } else {
                        throw new NullPointerException("Null transportName");
                    }
                }
                return null;
            default:
                HashMap hashMap = (HashMap) obj3;
                MetadataRepo metadataRepo = (MetadataRepo) obj2;
                ArrayList arrayList4 = (ArrayList) metadataRepo.mEmojiCharArray;
                Cursor cursor3 = (Cursor) obj;
                sQLiteEventStore.getClass();
                while (cursor3.moveToNext()) {
                    String string4 = cursor3.getString(i7);
                    int i13 = cursor3.getInt(1);
                    LogEventDropped.Reason reason3 = LogEventDropped.Reason.REASON_UNKNOWN;
                    if (i13 != 0) {
                        if (i13 == 1) {
                            reason3 = LogEventDropped.Reason.MESSAGE_TOO_OLD;
                        } else if (i13 == 2) {
                            reason = reason2;
                            long j3 = cursor3.getLong(2);
                            if (hashMap.containsKey(string4)) {
                                hashMap.put(string4, new ArrayList());
                            }
                            ((List) hashMap.get(string4)).add(new LogEventDropped(j3, reason));
                            i7 = 0;
                            i2 = 5;
                            i3 = 4;
                            i4 = 3;
                        } else if (i13 == i4) {
                            reason3 = LogEventDropped.Reason.PAYLOAD_TOO_BIG;
                        } else if (i13 == i3) {
                            reason3 = LogEventDropped.Reason.MAX_RETRIES_REACHED;
                        } else if (i13 == i2) {
                            reason3 = LogEventDropped.Reason.INVALID_PAYLOD;
                        } else if (i13 == 6) {
                            reason3 = LogEventDropped.Reason.SERVER_ERROR;
                        } else {
                            Navigation.m590d("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i13));
                        }
                    }
                    reason = reason3;
                    long j32 = cursor3.getLong(2);
                    if (hashMap.containsKey(string4)) {
                    }
                    ((List) hashMap.get(string4)).add(new LogEventDropped(j32, reason));
                    i7 = 0;
                    i2 = 5;
                    i3 = 4;
                    i4 = 3;
                }
                for (Map.Entry entry2 : hashMap.entrySet()) {
                    int i14 = LogSourceMetrics.$r8$clinit;
                    new ArrayList();
                    arrayList4.add(new LogSourceMetrics(DesugarCollections.unmodifiableList((List) entry2.getValue()), (String) entry2.getKey()));
                }
                long time = sQLiteEventStore.wallClock.getTime();
                SQLiteDatabase db = sQLiteEventStore.getDb();
                db.beginTransaction();
                try {
                    Cursor rawQuery = db.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]);
                    rawQuery.moveToNext();
                    TimeWindow timeWindow = new TimeWindow(rawQuery.getLong(0), time);
                    rawQuery.close();
                    db.setTransactionSuccessful();
                    db.endTransaction();
                    metadataRepo.mMetadataList = timeWindow;
                    metadataRepo.mRootNode = new GlobalMetrics(new StorageMetrics(sQLiteEventStore.getDb().compileStatement("PRAGMA page_size").simpleQueryForLong() * sQLiteEventStore.getDb().compileStatement("PRAGMA page_count").simpleQueryForLong(), AutoValue_EventStoreConfig.DEFAULT.maxStorageSizeInBytes));
                    metadataRepo.mTypeface = (String) sQLiteEventStore.packageName.get();
                    return new ClientMetrics((TimeWindow) metadataRepo.mMetadataList, DesugarCollections.unmodifiableList(arrayList4), (GlobalMetrics) metadataRepo.mRootNode, (String) metadataRepo.mTypeface);
                } catch (Throwable th4) {
                    db.endTransaction();
                    throw th4;
                }
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        DefaultScheduler defaultScheduler = (DefaultScheduler) this.f$0;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.f$2;
        AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) this.f$1;
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) defaultScheduler.eventStore;
        sQLiteEventStore.getClass();
        Priority priority = autoValue_TransportContext.priority;
        String str = autoValue_EventInternal.transportName;
        String str2 = autoValue_TransportContext.backendName;
        String tag = Navigation.getTag("SQLiteEventStore");
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, "Storing event with priority=" + priority + ", name=" + str + " for destination " + str2);
        }
        ((Long) sQLiteEventStore.inTransaction(new FragmentTransitionSupport$$ExternalSyntheticLambda0(sQLiteEventStore, autoValue_EventInternal, autoValue_TransportContext, 2))).getClass();
        defaultScheduler.workScheduler.schedule(autoValue_TransportContext, 1, false);
        return null;
    }

    public /* synthetic */ FragmentTransitionSupport$$ExternalSyntheticLambda0(Runnable runnable, Transition transition, Runnable runnable2) {
        this.$r8$classId = 0;
        this.f$0 = runnable;
        this.f$1 = transition;
        this.f$2 = runnable2;
    }
}
