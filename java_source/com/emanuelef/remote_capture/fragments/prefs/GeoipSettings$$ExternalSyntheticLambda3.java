package com.emanuelef.remote_capture.fragments.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.preference.Preference;
import androidx.preference.SwitchPreference;
import com.emanuelef.remote_capture.activities.prefs.SettingsActivity;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_PersistedEvent;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final /* synthetic */ class GeoipSettings$$ExternalSyntheticLambda3 implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener, SynchronizationGuard.CriticalSection, SQLiteEventStore.Function {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ GeoipSettings$$ExternalSyntheticLambda3(Object obj, int i, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    /* JADX WARN: Finally extract failed */
    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        Priority[] values;
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) this.f$0;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.f$1;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        AutoValue_EventStoreConfig autoValue_EventStoreConfig = sQLiteEventStore.config;
        ArrayList loadEvents = sQLiteEventStore.loadEvents(sQLiteDatabase, autoValue_TransportContext, autoValue_EventStoreConfig.loadBatchSize);
        for (Priority priority : Priority.values()) {
            if (priority != autoValue_TransportContext.priority) {
                int size = autoValue_EventStoreConfig.loadBatchSize - loadEvents.size();
                if (size <= 0) {
                    break;
                }
                MatcherMatchResult builder = AutoValue_TransportContext.builder();
                builder.setBackendName(autoValue_TransportContext.backendName);
                if (priority != null) {
                    builder.groups = priority;
                    builder.input = autoValue_TransportContext.extras;
                    loadEvents.addAll(sQLiteEventStore.loadEvents(sQLiteDatabase, builder.build(), size));
                } else {
                    throw new NullPointerException("Null priority");
                }
            }
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < loadEvents.size(); i++) {
            sb.append(((AutoValue_PersistedEvent) loadEvents.get(i)).f34id);
            if (i < loadEvents.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        Cursor query = sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null);
        while (query.moveToNext()) {
            try {
                long j = query.getLong(0);
                Set set = (Set) hashMap.get(Long.valueOf(j));
                if (set == null) {
                    set = new HashSet();
                    hashMap.put(Long.valueOf(j), set);
                }
                set.add(new SQLiteEventStore.Metadata(query.getString(1), query.getString(2)));
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        query.close();
        ListIterator listIterator = loadEvents.listIterator();
        while (listIterator.hasNext()) {
            AutoValue_PersistedEvent autoValue_PersistedEvent = (AutoValue_PersistedEvent) listIterator.next();
            long j2 = autoValue_PersistedEvent.f34id;
            if (hashMap.containsKey(Long.valueOf(j2))) {
                AppCompatDrawableManager.C00231 builder2 = autoValue_PersistedEvent.event.toBuilder();
                for (SQLiteEventStore.Metadata metadata : (Set) hashMap.get(Long.valueOf(j2))) {
                    builder2.addMetadata(metadata.key, metadata.value);
                }
                listIterator.set(new AutoValue_PersistedEvent(j2, autoValue_PersistedEvent.transportContext, builder2.build()));
            }
        }
        return loadEvents;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        switch (this.$r8$classId) {
            case 3:
                Iterable iterable = (Iterable) this.f$1;
                SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) ((Uploader) this.f$0).eventStore;
                sQLiteEventStore.getClass();
                if (!iterable.iterator().hasNext()) {
                    return null;
                }
                sQLiteEventStore.getDb().compileStatement("DELETE FROM events WHERE _id in " + SQLiteEventStore.toIdList(iterable)).execute();
                return null;
            default:
                Uploader uploader = (Uploader) this.f$0;
                for (Map.Entry entry : ((HashMap) this.f$1).entrySet()) {
                    ((SQLiteEventStore) uploader.clientHealthMetricsStore).recordLogEventDropped(((Integer) entry.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) entry.getKey());
                }
                return null;
        }
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        boolean lambda$setupAppLanguagePref$12;
        boolean lambda$onCreatePreferences$5;
        switch (this.$r8$classId) {
            case 1:
                lambda$setupAppLanguagePref$12 = ((SettingsActivity.SettingsFragment) this.f$0).lambda$setupAppLanguagePref$12((SharedPreferences) this.f$1, preference, obj);
                return lambda$setupAppLanguagePref$12;
            default:
                lambda$onCreatePreferences$5 = ((Socks5Settings) this.f$0).lambda$onCreatePreferences$5((SwitchPreference) this.f$1, preference, obj);
                return lambda$onCreatePreferences$5;
        }
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        boolean lambda$onCreatePreferences$0;
        lambda$onCreatePreferences$0 = ((GeoipSettings) this.f$0).lambda$onCreatePreferences$0((Context) this.f$1, preference);
        return lambda$onCreatePreferences$0;
    }
}
