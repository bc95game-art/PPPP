package com.emanuelef.remote_capture;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.ArrayMap;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.preference.PreferenceManager;
import com.emanuelef.remote_capture.interfaces.BlacklistsStateListener;
import com.emanuelef.remote_capture.model.BlacklistDescriptor;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.LinkedTreeMap$KeySet$1;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public class Blacklists {
    public static final long BLACKLISTS_UPDATE_MILLIS = 86400000;
    public static final String PREF_BLACKLISTS_STATUS = "blacklists_status";
    private static final String TAG = "Blacklists";
    private final Context mContext;
    private final SharedPreferences mPrefs;
    private boolean mStopRequest;
    private final ArrayList<BlacklistDescriptor> mLists = new ArrayList<>();
    private final ArrayMap<String, BlacklistDescriptor> mListByFname = new ArrayMap<>();
    private final ArrayList<BlacklistsStateListener> mListeners = new ArrayList<>();
    private long mLastUpdate = 0;
    private long mLastUpdateMonotonic = -86400000;
    private int mNumDomainRules = 0;
    private int mNumIPRules = 0;
    private boolean mUpdateInProgress = false;

    /* loaded from: classes.dex */
    public static class NativeBlacklistStatus {
        public final String fname;
        public final int num_rules;

        public NativeBlacklistStatus(String str, int i) {
            this.fname = str;
            this.num_rules = i;
        }
    }

    /* loaded from: classes.dex */
    public static class Serializer implements JsonSerializer {
        public /* synthetic */ Serializer(int i) {
            this();
        }

        private Serializer() {
        }

        public JsonElement serialize(Blacklists blacklists, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            ArrayList arrayList = blacklists.mLists;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                BlacklistDescriptor blacklistDescriptor = (BlacklistDescriptor) obj;
                JsonObject jsonObject2 = new JsonObject();
                JsonPrimitive jsonPrimitive = new JsonPrimitive(Integer.valueOf(blacklistDescriptor.num_rules));
                LinkedTreeMap linkedTreeMap = jsonObject2.members;
                linkedTreeMap.put("num_rules", jsonPrimitive);
                linkedTreeMap.put("last_update", new JsonPrimitive(Long.valueOf(blacklistDescriptor.getLastUpdate())));
                jsonObject.add(blacklistDescriptor.fname, jsonObject2);
            }
            JsonObject jsonObject3 = new JsonObject();
            JsonPrimitive jsonPrimitive2 = new JsonPrimitive(Long.valueOf(blacklists.mLastUpdate));
            LinkedTreeMap linkedTreeMap2 = jsonObject3.members;
            linkedTreeMap2.put("last_update", jsonPrimitive2);
            linkedTreeMap2.put("num_domain_rules", new JsonPrimitive(Integer.valueOf(blacklists.mNumDomainRules)));
            linkedTreeMap2.put("num_ip_rules", new JsonPrimitive(Integer.valueOf(blacklists.mNumIPRules)));
            linkedTreeMap2.put("blacklists", jsonObject);
            return jsonObject3;
        }
    }

    public Blacklists(Context context) {
        this.mContext = context;
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        addList("Maltrail", BlacklistDescriptor.Type.DOMAIN_BLACKLIST, "maltrail-malware-domains.txt", "https://raw.githubusercontent.com/stamparm/aux/master/maltrail-malware-domains.txt");
        BlacklistDescriptor.Type type = BlacklistDescriptor.Type.IP_BLACKLIST;
        addList("Emerging Threats", type, "emerging-Block-IPs.txt", "https://rules.emergingthreats.net/fwrules/emerging-Block-IPs.txt");
        addList("DigitalSide Threat-Intel", type, "digitalsideit_ips.txt", "https://raw.githubusercontent.com/davidonzo/Threat-Intel/master/lists/latestips.txt");
        deserialize();
        checkFiles();
    }

    private void addList(String str, BlacklistDescriptor.Type type, String str2, String str3) {
        BlacklistDescriptor blacklistDescriptor = new BlacklistDescriptor(str, type, str2, str3);
        this.mLists.add(blacklistDescriptor);
        this.mListByFname.put(str2, blacklistDescriptor);
    }

    private void checkFiles() {
        ArraySet arraySet = new ArraySet(0);
        ArrayList<BlacklistDescriptor> arrayList = this.mLists;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            BlacklistDescriptor blacklistDescriptor = arrayList.get(i);
            i++;
            File file = new File(getListPath(blacklistDescriptor));
            arraySet.add(file);
            if (!file.exists()) {
                this.mLastUpdateMonotonic = -86400000L;
            }
        }
        File file2 = new File(this.mContext.getFilesDir().getPath() + "/malware_bl");
        file2.mkdir();
        File[] listFiles = file2.listFiles();
        if (listFiles != null) {
            for (File file3 : listFiles) {
                if (!arraySet.contains(file3)) {
                    Log.i(TAG, "Removing unknown list: " + file3.getPath());
                    file3.delete();
                }
            }
        }
    }

    private String getListPath(BlacklistDescriptor blacklistDescriptor) {
        return this.mContext.getFilesDir().getPath() + "/malware_bl/" + blacklistDescriptor.fname;
    }

    private void notifyListeners() {
        ArrayList<BlacklistsStateListener> arrayList = this.mListeners;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            BlacklistsStateListener blacklistsStateListener = arrayList.get(i);
            i++;
            blacklistsStateListener.onBlacklistsStateChanged();
        }
    }

    public void abortUpdate() {
        this.mStopRequest = true;
    }

    public void addOnChangeListener(BlacklistsStateListener blacklistsStateListener) {
        this.mListeners.add(blacklistsStateListener);
    }

    public void deserialize() {
        long j;
        long j2;
        String string = this.mPrefs.getString(PREF_BLACKLISTS_STATUS, "");
        if (!string.isEmpty()) {
            LinkedTreeMap linkedTreeMap = LazyKt__LazyJVMKt.parseString(string).getAsJsonObject().members;
            JsonPrimitive jsonPrimitive = (JsonPrimitive) linkedTreeMap.get("last_update");
            if (jsonPrimitive.value instanceof Number) {
                j = jsonPrimitive.getAsNumber().longValue();
            } else {
                j = Long.parseLong(jsonPrimitive.getAsString());
            }
            this.mLastUpdate = j;
            this.mNumDomainRules = ((JsonPrimitive) linkedTreeMap.get("num_domain_rules")).getAsInt();
            this.mNumIPRules = ((JsonPrimitive) linkedTreeMap.get("num_ip_rules")).getAsInt();
            long currentTimeMillis = System.currentTimeMillis() - this.mLastUpdate;
            if (currentTimeMillis > 0) {
                this.mLastUpdateMonotonic = SystemClock.elapsedRealtime() - currentTimeMillis;
            }
            JsonObject jsonObject = (JsonObject) linkedTreeMap.get("blacklists");
            if (jsonObject != null) {
                Iterator it = ((ArrayMap.EntrySet) jsonObject.members.entrySet()).iterator();
                while (((LinkedTreeMap$KeySet$1) it).hasNext()) {
                    LinkedTreeMap.Node nextNode = ((LinkedTreeMap$KeySet$1) it).nextNode();
                    BlacklistDescriptor blacklistDescriptor = this.mListByFname.get(nextNode.getKey());
                    if (blacklistDescriptor != null) {
                        LinkedTreeMap linkedTreeMap2 = ((JsonElement) nextNode.getValue()).getAsJsonObject().members;
                        blacklistDescriptor.num_rules = ((JsonPrimitive) linkedTreeMap2.get("num_rules")).getAsInt();
                        JsonPrimitive jsonPrimitive2 = (JsonPrimitive) linkedTreeMap2.get("last_update");
                        if (jsonPrimitive2.value instanceof Number) {
                            j2 = jsonPrimitive2.getAsNumber().longValue();
                        } else {
                            j2 = Long.parseLong(jsonPrimitive2.getAsString());
                        }
                        blacklistDescriptor.setUpdated(j2);
                    }
                }
            }
        }
    }

    public long getLastUpdate() {
        return this.mLastUpdate;
    }

    public int getNumBlacklists() {
        return this.mLists.size();
    }

    public int getNumLoadedDomainRules() {
        return this.mNumDomainRules;
    }

    public int getNumLoadedIPRules() {
        return this.mNumIPRules;
    }

    public int getNumUpdatedBlacklists() {
        ArrayList<BlacklistDescriptor> arrayList = this.mLists;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            BlacklistDescriptor blacklistDescriptor = arrayList.get(i2);
            i2++;
            if (blacklistDescriptor.isUpToDate()) {
                i++;
            }
        }
        return i;
    }

    public boolean isUpdateInProgress() {
        return this.mUpdateInProgress;
    }

    public Iterator<BlacklistDescriptor> iter() {
        return this.mLists.iterator();
    }

    public boolean needsUpdate(boolean z) {
        if (SystemClock.elapsedRealtime() - this.mLastUpdateMonotonic >= BLACKLISTS_UPDATE_MILLIS) {
            return true;
        }
        if (!z || getNumUpdatedBlacklists() >= getNumBlacklists()) {
            return false;
        }
        return true;
    }

    public void onNativeLoaded(NativeBlacklistStatus[] nativeBlacklistStatusArr) {
        NativeBlacklistStatus nativeBlacklistStatus;
        ArraySet arraySet = new ArraySet(0);
        int length = nativeBlacklistStatusArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length && (nativeBlacklistStatus = nativeBlacklistStatusArr[i4]) != null; i4++) {
            BlacklistDescriptor blacklistDescriptor = this.mListByFname.get(nativeBlacklistStatus.fname);
            if (blacklistDescriptor != null) {
                blacklistDescriptor.num_rules = nativeBlacklistStatus.num_rules;
                blacklistDescriptor.loaded = true;
                arraySet.add(blacklistDescriptor.fname);
                if (blacklistDescriptor.type == BlacklistDescriptor.Type.DOMAIN_BLACKLIST) {
                    i2 += nativeBlacklistStatus.num_rules;
                } else {
                    i3 += nativeBlacklistStatus.num_rules;
                }
                i++;
            } else {
                Log.w(TAG, "Loaded unknown blacklist " + nativeBlacklistStatus.fname);
            }
        }
        ArrayList<BlacklistDescriptor> arrayList = this.mLists;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            BlacklistDescriptor blacklistDescriptor2 = arrayList.get(i5);
            i5++;
            BlacklistDescriptor blacklistDescriptor3 = blacklistDescriptor2;
            if (!arraySet.contains(blacklistDescriptor3.fname)) {
                Log.w(TAG, "Blacklist not loaded: " + blacklistDescriptor3.fname);
                blacklistDescriptor3.loaded = false;
            }
        }
        Log.i(TAG, "Blacklists loaded: " + i + " lists, " + i2 + " domains, " + i3 + " IPs");
        this.mNumDomainRules = i2;
        this.mNumIPRules = i3;
        this.mUpdateInProgress = false;
        notifyListeners();
    }

    public void removeOnChangeListener(BlacklistsStateListener blacklistsStateListener) {
        this.mListeners.remove(blacklistsStateListener);
    }

    public void save() {
        this.mPrefs.edit().putString(PREF_BLACKLISTS_STATUS, toJson()).apply();
    }

    public String toJson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(getClass(), new Serializer(0));
        return gsonBuilder.create().toJson(this);
    }

    public void update() {
        this.mUpdateInProgress = true;
        int i = 0;
        this.mStopRequest = false;
        ArrayList<BlacklistDescriptor> arrayList = this.mLists;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            BlacklistDescriptor blacklistDescriptor = arrayList.get(i2);
            i2++;
            blacklistDescriptor.setUpdating();
        }
        notifyListeners();
        Log.i(TAG, "Updating " + this.mLists.size() + " blacklists...");
        ArrayList<BlacklistDescriptor> arrayList2 = this.mLists;
        int size2 = arrayList2.size();
        while (true) {
            if (i >= size2) {
                break;
            }
            BlacklistDescriptor blacklistDescriptor2 = arrayList2.get(i);
            i++;
            BlacklistDescriptor blacklistDescriptor3 = blacklistDescriptor2;
            if (this.mStopRequest) {
                Log.i(TAG, "Stop request received, abort");
                break;
            }
            Log.i(TAG, "\tupdating " + blacklistDescriptor3.fname + "...");
            if (Utils.downloadFile(blacklistDescriptor3.url, getListPath(blacklistDescriptor3))) {
                blacklistDescriptor3.setUpdated(System.currentTimeMillis());
            } else {
                blacklistDescriptor3.setOutdated();
            }
            notifyListeners();
        }
        this.mLastUpdate = System.currentTimeMillis();
        this.mLastUpdateMonotonic = SystemClock.elapsedRealtime();
        notifyListeners();
    }
}
