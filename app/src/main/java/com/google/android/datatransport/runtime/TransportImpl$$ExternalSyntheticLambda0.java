package com.google.android.datatransport.runtime;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.preference.Preference;
import com.emanuelef.remote_capture.activities.prefs.SettingsActivity;
import com.emanuelef.remote_capture.fragments.AppOverview;
import com.emanuelef.remote_capture.fragments.ConnectionPayload;
import com.emanuelef.remote_capture.fragments.ConnectionsFragment;
import com.emanuelef.remote_capture.fragments.HttpLogFragment;
import com.emanuelef.remote_capture.fragments.HttpPayloadFragment;
import com.emanuelef.remote_capture.fragments.LogviewFragment;
import com.emanuelef.remote_capture.fragments.prefs.DnsSettings;
import com.emanuelef.remote_capture.fragments.prefs.Socks5Settings;
import com.emanuelef.remote_capture.views.EmptyRecyclerView;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.ObjectConstructor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final /* synthetic */ class TransportImpl$$ExternalSyntheticLambda0 implements Preference.OnPreferenceChangeListener, OnApplyWindowInsetsListener, LabelFormatter, SQLiteEventStore.Function, TextInputLayout.LengthCounter, ObjectConstructor {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ TransportImpl$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        byte[] bArr;
        Cursor rawQuery = ((SQLiteDatabase) obj).rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]);
        try {
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                MatcherMatchResult builder = AutoValue_TransportContext.builder();
                builder.setBackendName(rawQuery.getString(1));
                builder.groups = PriorityMapping.valueOf(rawQuery.getInt(2));
                String string = rawQuery.getString(3);
                if (string == null) {
                    bArr = null;
                } else {
                    bArr = Base64.decode(string, 0);
                }
                builder.input = bArr;
                arrayList.add(builder.build());
            }
            return arrayList;
        } finally {
            rawQuery.close();
        }
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.$r8$classId) {
            case 28:
                return new LinkedTreeMap(true);
            default:
                return new LinkedHashMap();
        }
    }

    @Override // com.google.android.material.slider.LabelFormatter
    public String getFormattedValue(float f) {
        String lambda$onViewCreated$0;
        String lambda$onViewCreated$02;
        switch (this.$r8$classId) {
            case 6:
                lambda$onViewCreated$0 = ConnectionsFragment.lambda$onViewCreated$0(f);
                return lambda$onViewCreated$0;
            default:
                lambda$onViewCreated$02 = HttpLogFragment.lambda$onViewCreated$0(f);
                return lambda$onViewCreated$02;
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat lambda$onViewCreated$1;
        WindowInsetsCompat lambda$onViewCreated$0;
        WindowInsetsCompat lambda$onViewCreated$5;
        WindowInsetsCompat lambda$onViewCreated$52;
        WindowInsetsCompat lambda$onViewCreated$02;
        WindowInsetsCompat lambda$init$0;
        WindowInsetsCompat lambda$setEmptyView$1;
        switch (this.$r8$classId) {
            case 4:
                lambda$onViewCreated$1 = AppOverview.lambda$onViewCreated$1(view, windowInsetsCompat);
                return lambda$onViewCreated$1;
            case 5:
                lambda$onViewCreated$0 = ConnectionPayload.lambda$onViewCreated$0(view, windowInsetsCompat);
                return lambda$onViewCreated$0;
            case 7:
                lambda$onViewCreated$5 = ConnectionsFragment.lambda$onViewCreated$5(view, windowInsetsCompat);
                return lambda$onViewCreated$5;
            case 9:
                lambda$onViewCreated$52 = HttpLogFragment.lambda$onViewCreated$5(view, windowInsetsCompat);
                return lambda$onViewCreated$52;
            case 10:
                lambda$onViewCreated$02 = HttpPayloadFragment.lambda$onViewCreated$0(view, windowInsetsCompat);
                return lambda$onViewCreated$02;
            case 11:
                return LogviewFragment.$r8$lambda$G3Ife5gsm7t32EW1pwirttfTG4A(view, windowInsetsCompat);
            case 18:
                lambda$init$0 = EmptyRecyclerView.lambda$init$0(view, windowInsetsCompat);
                return lambda$init$0;
            default:
                lambda$setEmptyView$1 = EmptyRecyclerView.lambda$setEmptyView$1(view, windowInsetsCompat);
                return lambda$setEmptyView$1;
        }
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        boolean lambda$setupHttpServerPrefs$4;
        boolean lambda$setupExporterPrefs$1;
        switch (this.$r8$classId) {
            case 1:
                lambda$setupHttpServerPrefs$4 = SettingsActivity.SettingsFragment.lambda$setupHttpServerPrefs$4(preference, obj);
                return lambda$setupHttpServerPrefs$4;
            case 2:
                lambda$setupExporterPrefs$1 = SettingsActivity.SettingsFragment.lambda$setupExporterPrefs$1(preference, obj);
                return lambda$setupExporterPrefs$1;
            case 12:
                return DnsSettings.$r8$lambda$ItTbOMEq3mUJk6wq9AHGxHKAYm8(preference, obj);
            case 13:
                return DnsSettings.$r8$lambda$MHpgqMC8TyMJmqjdm4rnmzwhQsY(preference, obj);
            case 14:
                return Socks5Settings.$r8$lambda$TKhh3V9pYhHxFZyMOcdvR2EilLs(preference, obj);
            default:
                return Socks5Settings.m233$r8$lambda$m3C7kkMujGH7YXTu2cYpTAtZXo(preference, obj);
        }
    }
}
