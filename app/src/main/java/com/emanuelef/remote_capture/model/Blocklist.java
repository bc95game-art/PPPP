package com.emanuelef.remote_capture.model;

import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.util.ArrayMap;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.Geolocation;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.model.MatchList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class Blocklist extends MatchList {
    private static final String TAG = "Blocklist";
    private boolean mGeoWarningShown = false;
    private final ArrayMap<Integer, Long> mUidToGrace = new ArrayMap<>();

    public Blocklist(Context context) {
        super(context, Prefs.PREF_BLOCKLIST);
    }

    public static /* synthetic */ void lambda$showNoticeIfGeoMissing$0(DialogInterface dialogInterface, int i) {
    }

    @Override // com.emanuelef.remote_capture.model.MatchList
    public synchronized boolean addApp(int i) {
        this.mUidToGrace.remove(Integer.valueOf(i));
        return super.addApp(i);
    }

    public synchronized boolean checkGracePeriods() {
        boolean z;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<Integer, Long>> it = this.mUidToGrace.entrySet().iterator();
        z = false;
        while (it.hasNext()) {
            Map.Entry<Integer, Long> next = it.next();
            if (elapsedRealtime >= next.getValue().longValue()) {
                Log.i(TAG, "Grace period ended for app: " + next.getKey());
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public synchronized boolean hasCountryRules() {
        Iterator<MatchList.Rule> iterRules = iterRules();
        while (iterRules.hasNext()) {
            if (iterRules.next().getType() == MatchList.RuleType.COUNTRY) {
                return true;
            }
        }
        return false;
    }

    @Override // com.emanuelef.remote_capture.model.MatchList
    public synchronized boolean isExemptedApp(int i) {
        return this.mUidToGrace.containsKey(Integer.valueOf(i));
    }

    @Override // com.emanuelef.remote_capture.model.MatchList
    public boolean matchesApp(int i) {
        boolean z;
        if (!super.matchesApp(i)) {
            return false;
        }
        synchronized (this) {
            z = !isExemptedApp(i);
        }
        return z;
    }

    @Override // com.emanuelef.remote_capture.model.MatchList
    public synchronized void removeApp(int i) {
        this.mUidToGrace.remove(Integer.valueOf(i));
        super.removeApp(i);
    }

    public void saveAndReload() {
        save();
        if (CaptureService.isServiceActive()) {
            CaptureService.requireInstance().reloadBlocklist();
        }
    }

    public void showNoticeIfGeoMissing(Context context) {
        if (!this.mGeoWarningShown && !Geolocation.isAvailable(context)) {
            zzbv zzbvVar = new zzbv(context);
            zzbvVar.setTitle(R.string.geo_db_missing);
            zzbvVar.setMessage(R.string.country_rules_warning);
            zzbvVar.setNeutralButton(R.string.ok, new Blocklist$$ExternalSyntheticLambda0(0));
            zzbvVar.show();
            this.mGeoWarningShown = true;
        }
    }

    public synchronized boolean unblockAppForMinutes(int i, int i2) {
        boolean z;
        Long put = this.mUidToGrace.put(Integer.valueOf(i), Long.valueOf((i2 * 60000) + SystemClock.elapsedRealtime()));
        Log.i(TAG, "Grace app: " + i + " for " + i2 + " minutes (old: " + put + ")");
        if (put == null) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
