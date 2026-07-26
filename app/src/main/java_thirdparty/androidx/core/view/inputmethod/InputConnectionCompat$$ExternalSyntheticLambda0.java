package androidx.core.view.inputmethod;

import android.content.ClipData;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.emoji2.text.MetadataRepo;
import androidx.navigation.Navigation;
import androidx.preference.Preference;
import androidx.transition.FragmentTransitionSupport$$ExternalSyntheticLambda0;
import androidx.viewpager2.widget.FakeDrag;
import com.emanuelef.remote_capture.HTTPReassembly;
import com.emanuelef.remote_capture.activities.CaptureCtrl;
import com.emanuelef.remote_capture.activities.ConnectionDetailsActivity;
import com.emanuelef.remote_capture.activities.FirewallActivity;
import com.emanuelef.remote_capture.activities.LogviewActivity;
import com.emanuelef.remote_capture.activities.PayloadExportActivity;
import com.emanuelef.remote_capture.activities.prefs.SettingsActivity;
import com.emanuelef.remote_capture.fragments.ConnectionPayload;
import com.emanuelef.remote_capture.fragments.prefs.GeoipSettings;
import com.emanuelef.remote_capture.fragments.prefs.Socks5Settings;
import com.emanuelef.remote_capture.interfaces.CaptureStartListener;
import com.emanuelef.remote_capture.model.PayloadChunk;
import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.cct.internal.AutoValue_BatchedLogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_LogResponse;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator$TabConfigurationStrategy;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.encoders.json.JsonValueObjectEncoderContext;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.UnsafeAllocator;
import com.google.gson.internal.reflect.ReflectionHelper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.text.MatcherMatchResult;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
/* loaded from: classes.dex */
public final /* synthetic */ class InputConnectionCompat$$ExternalSyntheticLambda0 implements CaptureStartListener, TabLayoutMediator$TabConfigurationStrategy, ActivityResultCallback, OnApplyWindowInsetsListener, Preference.OnPreferenceClickListener, Preference.OnPreferenceChangeListener, HTTPReassembly.ReassemblyListener, SynchronizationGuard.CriticalSection, ObjectConstructor {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ InputConnectionCompat$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    public CctTransportBackend.HttpResponse apply(MatcherMatchResult matcherMatchResult) {
        Exception e;
        InputStream inputStream;
        CctTransportBackend cctTransportBackend = (CctTransportBackend) this.f$0;
        URL url = (URL) matcherMatchResult.matcher;
        String tag = Navigation.getTag("CctTransportBackend");
        if (Log.isLoggable(tag, 4)) {
            Log.i(tag, String.format("Making request to: %s", url));
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(cctTransportBackend.readTimeout);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", "datatransport/3.1.8 android/");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = (String) matcherMatchResult.groups;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                ReadonlyStateFlow readonlyStateFlow = cctTransportBackend.dataEncoder;
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream));
                JsonDataEncoderBuilder jsonDataEncoderBuilder = (JsonDataEncoderBuilder) readonlyStateFlow.$$delegate_0;
                JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(bufferedWriter, jsonDataEncoderBuilder.objectEncoders, jsonDataEncoderBuilder.valueEncoders, jsonDataEncoderBuilder.fallbackEncoder, jsonDataEncoderBuilder.ignoreNullValues);
                jsonValueObjectEncoderContext.add((AutoValue_BatchedLogRequest) matcherMatchResult.input);
                jsonValueObjectEncoderContext.maybeUnNest();
                jsonValueObjectEncoderContext.jsonWriter.flush();
                gZIPOutputStream.close();
                if (outputStream != null) {
                    outputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                Integer valueOf = Integer.valueOf(responseCode);
                String tag2 = Navigation.getTag("CctTransportBackend");
                if (Log.isLoggable(tag2, 4)) {
                    Log.i(tag2, String.format("Status Code: %d", valueOf));
                }
                Navigation.d("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                Navigation.d("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                    return new CctTransportBackend.HttpResponse(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                }
                if (responseCode != 200) {
                    return new CctTransportBackend.HttpResponse(responseCode, null, 0L);
                }
                InputStream inputStream2 = httpURLConnection.getInputStream();
                try {
                    if ("gzip".equals(httpURLConnection.getHeaderField("Content-Encoding"))) {
                        inputStream = new GZIPInputStream(inputStream2);
                    } else {
                        inputStream = inputStream2;
                    }
                    CctTransportBackend.HttpResponse httpResponse = new CctTransportBackend.HttpResponse(responseCode, null, AutoValue_LogResponse.fromJson(new BufferedReader(new InputStreamReader(inputStream))).nextRequestWaitMillis);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    return httpResponse;
                } catch (Throwable th) {
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (EncodingException e2) {
            e = e2;
            Navigation.e("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new CctTransportBackend.HttpResponse(400, null, 0L);
        } catch (ConnectException e3) {
            e = e3;
            Navigation.e("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new CctTransportBackend.HttpResponse(500, null, 0L);
        } catch (UnknownHostException e4) {
            e = e4;
            Navigation.e("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new CctTransportBackend.HttpResponse(500, null, 0L);
        } catch (IOException e5) {
            e = e5;
            Navigation.e("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new CctTransportBackend.HttpResponse(400, null, 0L);
        }
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 18:
                Constructor constructor = (Constructor) obj;
                try {
                    return constructor.newInstance(null);
                } catch (IllegalAccessException e) {
                    LazyKt__LazyJVMKt lazyKt__LazyJVMKt = ReflectionHelper.RECORD_HELPER;
                    throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
                } catch (InstantiationException e2) {
                    throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with no args", e2);
                } catch (InvocationTargetException e3) {
                    throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.constructorToString(constructor) + "' with no args", e3.getCause());
                }
            default:
                Class cls = (Class) obj;
                try {
                    return UnsafeAllocator.INSTANCE.newInstance(cls);
                } catch (Exception e4) {
                    throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e4);
                }
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, androidx.emoji2.text.MetadataRepo] */
    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        SQLiteDatabase db;
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 12:
                SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) ((ClientHealthMetricsStore) obj);
                sQLiteEventStore.getClass();
                int i2 = ClientMetrics.$r8$clinit;
                ?? obj2 = new Object();
                obj2.mMetadataList = null;
                obj2.mEmojiCharArray = new ArrayList();
                obj2.mRootNode = null;
                obj2.mTypeface = "";
                HashMap hashMap = new HashMap();
                db = sQLiteEventStore.getDb();
                db.beginTransaction();
                try {
                    ClientMetrics clientMetrics = (ClientMetrics) SQLiteEventStore.tryWithCursor(db.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new FragmentTransitionSupport$$ExternalSyntheticLambda0(sQLiteEventStore, hashMap, obj2, 4));
                    db.setTransactionSuccessful();
                    return clientMetrics;
                } finally {
                }
            case 13:
                SQLiteEventStore sQLiteEventStore2 = (SQLiteEventStore) ((EventStore) obj);
                long time = sQLiteEventStore2.wallClock.getTime() - sQLiteEventStore2.config.eventCleanUpAge;
                db = sQLiteEventStore2.getDb();
                db.beginTransaction();
                try {
                    String[] strArr = {String.valueOf(time)};
                    Cursor rawQuery = db.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
                    while (rawQuery.moveToNext()) {
                        int i3 = rawQuery.getInt(0);
                        sQLiteEventStore2.recordLogEventDropped(i3, LogEventDropped.Reason.MESSAGE_TOO_OLD, rawQuery.getString(1));
                    }
                    rawQuery.close();
                    int delete = db.delete("events", "timestamp_ms < ?", strArr);
                    db.setTransactionSuccessful();
                    db.endTransaction();
                    return Integer.valueOf(delete);
                } finally {
                }
            case 14:
                SQLiteEventStore sQLiteEventStore3 = (SQLiteEventStore) ((Uploader) obj).clientHealthMetricsStore;
                db = sQLiteEventStore3.getDb();
                db.beginTransaction();
                try {
                    db.compileStatement("DELETE FROM log_event_dropped").execute();
                    db.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + sQLiteEventStore3.wallClock.getTime()).execute();
                    db.setTransactionSuccessful();
                    return null;
                } finally {
                }
            default:
                MetadataRepo metadataRepo = (MetadataRepo) obj;
                for (AutoValue_TransportContext autoValue_TransportContext : (Iterable) ((SQLiteEventStore) ((EventStore) metadataRepo.mEmojiCharArray)).inTransaction(new TransportImpl$$ExternalSyntheticLambda0(20))) {
                    ((MatcherMatchResult) metadataRepo.mRootNode).schedule(autoValue_TransportContext, 1, false);
                }
                return null;
        }
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        PayloadExportActivity.$r8$lambda$eQREs38pGGCwHFhYHY5F3RULCzg((PayloadExportActivity) this.f$0, (ActivityResult) obj);
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat lambda$onCreateView$0;
        WindowInsetsCompat lambda$onViewCreated$1;
        switch (this.$r8$classId) {
            case 6:
                lambda$onCreateView$0 = ((SettingsActivity) this.f$0).lambda$onCreateView$0(view, windowInsetsCompat);
                return lambda$onCreateView$0;
            default:
                lambda$onViewCreated$1 = ((ConnectionPayload) this.f$0).lambda$onViewCreated$1(view, windowInsetsCompat);
                return lambda$onViewCreated$1;
        }
    }

    @Override // com.emanuelef.remote_capture.interfaces.CaptureStartListener
    public void onCaptureStartResult(boolean z) {
        CaptureCtrl.$r8$lambda$I7quHj1vNT6stAHN5yULCqgf52Y((CaptureCtrl) this.f$0, z);
    }

    @Override // com.emanuelef.remote_capture.HTTPReassembly.ReassemblyListener
    public void onChunkReassembled(PayloadChunk payloadChunk) {
        ((AtomicReference) this.f$0).set(payloadChunk);
    }

    public boolean onCommitContent(FakeDrag fakeDrag, int i, Bundle bundle) {
        ContentInfoCompat.Compat31Impl compat31Impl;
        AppCompatEditText appCompatEditText = (AppCompatEditText) this.f$0;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 25 && (i & 1) != 0) {
            try {
                ((InputContentInfoCompat$InputContentInfoCompatImpl) fakeDrag.mScrollEventAdapter).requestPermission();
                Parcelable parcelable = (Parcelable) ((InputContentInfoCompat$InputContentInfoCompatImpl) fakeDrag.mScrollEventAdapter).getInputContentInfo();
                if (bundle == null) {
                    bundle = new Bundle();
                } else {
                    bundle = new Bundle(bundle);
                }
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
                return false;
            }
        }
        InputContentInfoCompat$InputContentInfoCompatImpl inputContentInfoCompat$InputContentInfoCompatImpl = (InputContentInfoCompat$InputContentInfoCompatImpl) fakeDrag.mScrollEventAdapter;
        ClipData clipData = new ClipData(inputContentInfoCompat$InputContentInfoCompatImpl.getDescription(), new ClipData.Item(inputContentInfoCompat$InputContentInfoCompatImpl.getContentUri()));
        if (i2 >= 31) {
            compat31Impl = new ContentInfoCompat.Compat31Impl(clipData, 2);
        } else {
            ContentInfoCompat.CompatImpl compatImpl = new ContentInfoCompat.CompatImpl();
            compatImpl.mClip = clipData;
            compatImpl.mSource = 2;
            compat31Impl = compatImpl;
        }
        compat31Impl.setLinkUri(inputContentInfoCompat$InputContentInfoCompatImpl.getLinkUri());
        compat31Impl.setExtras(bundle);
        if (ViewCompat.performReceiveContent(appCompatEditText, compat31Impl.build()) == null) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.tabs.TabLayoutMediator$TabConfigurationStrategy
    public void onConfigureTab(TabLayout.Tab tab, int i) {
        switch (this.$r8$classId) {
            case 2:
                ConnectionDetailsActivity.$r8$lambda$__cg253NfhNGG9K0QaCP15ZC3Oc((ConnectionDetailsActivity) this.f$0, tab, i);
                return;
            case 3:
                FirewallActivity.$r8$lambda$yF9JVEmtJ5t53Vc27fUjgVn9ciE((FirewallActivity) this.f$0, tab, i);
                return;
            default:
                LogviewActivity.$r8$lambda$Hj6AGbkZRBkiP9fIwLLTPyJU4zc((LogviewActivity) this.f$0, tab, i);
                return;
        }
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        return Socks5Settings.$r8$lambda$sJQFARlqn93lMKiE9Iffj0at35k((Socks5Settings) this.f$0, preference, obj);
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        boolean lambda$onCreatePreferences$1;
        lambda$onCreatePreferences$1 = ((GeoipSettings) this.f$0).lambda$onCreatePreferences$1(preference);
        return lambda$onCreatePreferences$1;
    }
}
