package com.emanuelef.remote_capture.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.style.StyleSpan;
import android.util.ArrayMap;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.preference.PreferenceManager;
import com.emanuelef.remote_capture.AppsResolver;
import com.emanuelef.remote_capture.Cidr;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.google.gson.FormattingStyle;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;
import j$.util.Objects;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public class MatchList {
    private static final String TAG = "MatchList";
    private static final StyleSpan italic = new StyleSpan(2);
    private final Context mContext;
    private final String mPrefName;
    private final SharedPreferences mPrefs;
    private final AppsResolver mResolver;
    private final ArrayList<ListChangeListener> mListeners = new ArrayList<>();
    private final ArrayList<Rule> mRules = new ArrayList<>();
    private final ArrayMap<String, Rule> mMatches = new ArrayMap<>();
    private final ArraySet mUids = new ArraySet(0);
    private final ArrayList<Cidr> mCidrs = new ArrayList<>();
    private final ArrayMap<String, Integer> mPackageToUid = new ArrayMap<>();
    private boolean mMigration = false;

    /* loaded from: classes.dex */
    public interface ListChangeListener {
        void onListChanged();
    }

    /* loaded from: classes.dex */
    public static class ListDescriptor {
        public final List<String> apps = new ArrayList();
        public final List<String> hosts = new ArrayList();
        public final List<String> ips = new ArrayList();
        public final List<String> countries = new ArrayList();
    }

    /* loaded from: classes.dex */
    public class Rule {
        private final String mLabel;
        private final RuleType mType;
        private final Object mValue;

        public /* synthetic */ Rule(MatchList matchList, RuleType ruleType, String str) {
            this(ruleType, (Object) str);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Rule)) {
                return super.equals(obj);
            }
            Rule rule = (Rule) obj;
            if (this.mType != rule.mType || !this.mValue.equals(rule.mValue)) {
                return false;
            }
            return true;
        }

        public String getLabel() {
            return this.mLabel;
        }

        public RuleType getType() {
            return this.mType;
        }

        public Object getValue() {
            return this.mValue;
        }

        private Rule(RuleType ruleType, Object obj) {
            this.mLabel = MatchList.getRuleLabel(MatchList.this.mContext, ruleType, obj.toString());
            this.mType = ruleType;
            this.mValue = obj;
        }
    }

    /* loaded from: classes.dex */
    public enum RuleType {
        APP,
        IP,
        HOST,
        PROTOCOL,
        COUNTRY
    }

    /* loaded from: classes.dex */
    public static class Serializer implements JsonSerializer {
        public /* synthetic */ Serializer(int i) {
            this();
        }

        private Serializer() {
        }

        public JsonElement serialize(MatchList matchList, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            ArrayList arrayList = matchList.mRules;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                Rule rule = (Rule) obj;
                JsonObject jsonObject2 = new JsonObject();
                JsonPrimitive jsonPrimitive = new JsonPrimitive(rule.getType().name());
                LinkedTreeMap linkedTreeMap = jsonObject2.members;
                linkedTreeMap.put("type", jsonPrimitive);
                linkedTreeMap.put("value", new JsonPrimitive(rule.getValue().toString()));
                jsonArray.elements.add(jsonObject2);
            }
            jsonObject.members.put("rules", jsonArray);
            return jsonObject;
        }
    }

    public MatchList(Context context, String str) {
        this.mContext = context;
        this.mPrefName = str;
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        this.mResolver = new AppsResolver(context);
        reload();
    }

    private boolean addCidr(String str) {
        try {
            Cidr cidr = new Cidr(str);
            ArrayList<Cidr> arrayList = this.mCidrs;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Cidr cidr2 = arrayList.get(i);
                i++;
                if (cidr2.equals(cidr)) {
                    return false;
                }
            }
            this.mCidrs.add(cidr);
            return true;
        } catch (IllegalArgumentException | UnknownHostException unused) {
            return false;
        }
    }

    private boolean addRule(Rule rule, boolean z) {
        String obj = rule.getValue().toString();
        String matchKey = matchKey(rule.getType(), obj);
        if (this.mMatches.containsKey(matchKey)) {
            return false;
        }
        if (rule.getType() == RuleType.APP) {
            int uid = this.mResolver.getUid(obj);
            if (uid == -2) {
                return false;
            }
            this.mPackageToUid.put(obj, Integer.valueOf(uid));
            this.mUids.add(Integer.valueOf(uid));
        } else if (rule.getType() == RuleType.IP && obj.indexOf(47) >= 0 && !addCidr(obj)) {
            return false;
        }
        this.mRules.add(rule);
        this.mMatches.put(matchKey, rule);
        if (!z) {
            return true;
        }
        notifyListeners();
        return true;
    }

    private int deserialize(JsonObject jsonObject, int i) {
        Throwable e;
        RuleType ruleType;
        int parseInt;
        AppDescriptor appByUid;
        try {
            try {
                JsonArray jsonArray = (JsonArray) jsonObject.members.get("rules");
                if (jsonArray == null) {
                    return -1;
                }
                clear(false);
                ArrayList arrayList = jsonArray.elements;
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    JsonObject asJsonObject = ((JsonElement) obj).getAsJsonObject();
                    String asString = ((JsonElement) asJsonObject.members.get("type")).getAsString();
                    String asString2 = ((JsonElement) asJsonObject.members.get("value")).getAsString();
                    try {
                        ruleType = RuleType.valueOf(asString);
                    } catch (IllegalArgumentException e2) {
                        if (asString.equals("ROOT_DOMAIN")) {
                            Log.i(TAG, "ROOT_DOMAIN " + asString2 + " migrated");
                            ruleType = RuleType.HOST;
                            this.mMigration = true;
                        } else {
                            e2.printStackTrace();
                        }
                    }
                    if (ruleType == RuleType.APP) {
                        try {
                            parseInt = Integer.parseInt(asString2);
                            appByUid = this.mResolver.getAppByUid(parseInt, 0);
                        } catch (NumberFormatException unused) {
                        }
                        if (appByUid != null) {
                            asString2 = appByUid.getPackageName();
                            Log.i(TAG, String.format("UID %d resolved to package %s", Integer.valueOf(parseInt), asString2));
                            this.mMigration = true;
                            AppDescriptor appByPackage = this.mResolver.getAppByPackage(asString2, 0);
                            if (appByPackage != null && !appByPackage.getPackageName().equals(asString2)) {
                                Log.i(TAG, "The UID " + appByPackage.getUid() + " mapping has changed from " + asString2 + " to " + appByPackage.getPackageName());
                                asString2 = appByPackage.getPackageName();
                                this.mMigration = true;
                            }
                        } else {
                            Log.w(TAG, "Ignoring unknown UID " + parseInt);
                        }
                    }
                    if (addRule(new Rule(this, ruleType, asString2), false)) {
                        i2++;
                        if (i > 0 && i2 >= i) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
                notifyListeners();
                return i2;
            } catch (IllegalArgumentException e3) {
                e = e3;
                e.printStackTrace();
                return -1;
            }
        } catch (ClassCastException e4) {
            e = e4;
            e.printStackTrace();
            return -1;
        }
    }

    public static String getCidrLabel(Context context, Cidr cidr) {
        return Utils.formatTextValue(context, null, italic, R.string.cidr_val, cidr.toString()).toString();
    }

    public static String getRuleLabel(Context context, RuleType ruleType, String str) {
        int i;
        int ordinal = ruleType.ordinal();
        if (ordinal == 0) {
            i = R.string.app_val;
        } else if (ordinal == 1) {
            i = R.string.ip_address_val;
        } else if (ordinal == 2) {
            i = R.string.host_val;
        } else if (ordinal == 3) {
            i = R.string.protocol_val;
        } else if (ordinal != 4) {
            return "";
        } else {
            i = R.string.country_val;
        }
        if (ruleType == RuleType.APP) {
            AppDescriptor resolveInstalledApp = AppsResolver.resolveInstalledApp(context.getPackageManager(), str, 0, false);
            if (resolveInstalledApp != null) {
                str = resolveInstalledApp.getName();
            }
        } else if (ruleType == RuleType.HOST) {
            str = Utils.cleanDomain(str);
        } else if (ruleType == RuleType.COUNTRY) {
            str = Utils.getCountryName(context, str);
        }
        return Utils.formatTextValue(context, null, italic, i, str).toString();
    }

    private static String matchKey(RuleType ruleType, Object obj) {
        return ruleType + "@" + obj;
    }

    private void notifyListeners() {
        ArrayList<ListChangeListener> arrayList = this.mListeners;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            ListChangeListener listChangeListener = arrayList.get(i);
            i++;
            listChangeListener.onListChanged();
        }
    }

    private boolean removeCidr(String str) {
        try {
            return this.mCidrs.remove(new Cidr(str));
        } catch (IllegalArgumentException | UnknownHostException unused) {
            return false;
        }
    }

    public boolean addApp(String str) {
        return addRule(new Rule(this, RuleType.APP, str));
    }

    public boolean addCountry(String str) {
        return addRule(new Rule(this, RuleType.COUNTRY, str));
    }

    public boolean addHost(String str) {
        return addRule(new Rule(this, RuleType.HOST, Utils.cleanDomain(str)));
    }

    public boolean addIp(String str) {
        return addRule(new Rule(this, RuleType.IP, str));
    }

    public void addListChangeListener(ListChangeListener listChangeListener) {
        this.mListeners.add(listChangeListener);
    }

    public boolean addProto(String str) {
        return addRule(new Rule(this, RuleType.PROTOCOL, str));
    }

    public int addRules(MatchList matchList) {
        Iterator<Rule> iterRules = matchList.iterRules();
        int i = 0;
        while (iterRules.hasNext()) {
            if (addRule(iterRules.next(), false)) {
                i++;
            }
        }
        if (i > 0) {
            notifyListeners();
        }
        return i;
    }

    public void clear(boolean z) {
        boolean z2 = this.mRules.size() > 0;
        this.mRules.clear();
        this.mMatches.clear();
        this.mPackageToUid.clear();
        this.mUids.clear();
        this.mCidrs.clear();
        if (z && z2) {
            notifyListeners();
        }
    }

    public int fromJson(String str, int i) {
        try {
            JsonElement parseString = LazyKt__LazyJVMKt.parseString(str);
            if (!(parseString instanceof JsonObject)) {
                return -1;
            }
            return deserialize(parseString.getAsJsonObject(), i);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getSize() {
        return this.mRules.size();
    }

    public boolean isEmpty() {
        if (this.mRules.size() == 0) {
            return true;
        }
        return false;
    }

    public boolean isExemptedApp(int i) {
        return false;
    }

    public Iterator<Rule> iterRules() {
        return this.mRules.iterator();
    }

    public boolean matches(ConnectionDescriptor connectionDescriptor) {
        boolean z;
        if (this.mMatches.isEmpty()) {
            return false;
        }
        String str = connectionDescriptor.info;
        if (str == null || str.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (matchesApp(connectionDescriptor.uid) || matchesExactIP(connectionDescriptor.dst_ip) || matchesCidr(connectionDescriptor.dst_ip) != null || matchesProto(connectionDescriptor.l7proto) || matchesCountry(connectionDescriptor.country) || (z && matchesHost(connectionDescriptor.info))) {
            return true;
        }
        return false;
    }

    public boolean matchesApp(int i) {
        return this.mUids.contains(Integer.valueOf(i));
    }

    public Cidr matchesCidr(String str) {
        if (!this.mCidrs.isEmpty()) {
            try {
                InetAddress byName = InetAddress.getByName(str);
                ArrayList<Cidr> arrayList = this.mCidrs;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Cidr cidr = arrayList.get(i);
                    i++;
                    Cidr cidr2 = cidr;
                    if (cidr2.isInRange(byName)) {
                        return cidr2;
                    }
                }
            } catch (UnknownHostException unused) {
            }
        }
        return null;
    }

    public boolean matchesCountry(String str) {
        return this.mMatches.containsKey(matchKey(RuleType.COUNTRY, str));
    }

    public boolean matchesExactHost(String str) {
        return this.mMatches.containsKey(matchKey(RuleType.HOST, Utils.cleanDomain(str)));
    }

    public boolean matchesExactIP(String str) {
        return this.mMatches.containsKey(matchKey(RuleType.IP, str));
    }

    public boolean matchesHost(String str) {
        String cleanDomain = Utils.cleanDomain(str);
        if (matchesExactHost(cleanDomain)) {
            return true;
        }
        String secondLevelDomain = Utils.getSecondLevelDomain(cleanDomain);
        if (secondLevelDomain.equals(cleanDomain) || !this.mMatches.containsKey(matchKey(RuleType.HOST, secondLevelDomain))) {
            return false;
        }
        return true;
    }

    public boolean matchesProto(String str) {
        return this.mMatches.containsKey(matchKey(RuleType.PROTOCOL, str));
    }

    public void reload() {
        String string = this.mPrefs.getString(this.mPrefName, "");
        if (!string.isEmpty()) {
            fromJson(string);
            if (this.mMigration) {
                Log.i(TAG, "Migration completed");
                save();
                this.mMigration = false;
                return;
            }
            return;
        }
        clear();
    }

    public void removeApp(String str) {
        removeRule(new Rule(this, RuleType.APP, str));
    }

    public void removeCountry(String str) {
        removeRule(new Rule(this, RuleType.COUNTRY, str));
    }

    public void removeHost(String str) {
        removeRule(new Rule(this, RuleType.HOST, Utils.cleanDomain(str)));
    }

    public void removeIp(String str) {
        removeRule(new Rule(this, RuleType.IP, str));
    }

    public void removeListChangeListener(ListChangeListener listChangeListener) {
        this.mListeners.remove(listChangeListener);
    }

    public void removeProto(String str) {
        removeRule(new Rule(this, RuleType.PROTOCOL, str));
    }

    public void removeRule(Rule rule) {
        String obj = rule.getValue().toString();
        String matchKey = matchKey(rule.getType(), obj);
        boolean remove = this.mRules.remove(rule);
        this.mMatches.remove(matchKey);
        if (rule.getType() == RuleType.APP) {
            int uid = this.mResolver.getUid(obj);
            if (uid != -2) {
                this.mPackageToUid.remove(obj);
                this.mUids.remove(Integer.valueOf(uid));
            } else {
                Log.w(TAG, "removeRule: no uid found for package " + obj);
            }
        } else if (rule.getType() == RuleType.IP && obj.indexOf(47) >= 0 && !removeCidr(obj)) {
            Log.w(TAG, "removeRule: removing CIDR failed for ".concat(obj));
        }
        if (remove) {
            notifyListeners();
        }
    }

    public void save() {
        this.mPrefs.edit().putString(this.mPrefName, toJson(false)).apply();
    }

    public String toJson(boolean z) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(getClass(), new Serializer(0));
        if (z) {
            FormattingStyle formattingStyle = FormattingStyle.PRETTY;
            Objects.requireNonNull(formattingStyle);
            gsonBuilder.formattingStyle = formattingStyle;
        }
        return gsonBuilder.create().toJson(this);
    }

    public ListDescriptor toListDescriptor() {
        ListDescriptor listDescriptor = new ListDescriptor();
        Iterator<Rule> iterRules = iterRules();
        while (iterRules.hasNext()) {
            Rule next = iterRules.next();
            RuleType type = next.getType();
            String obj = next.getValue().toString();
            if (type.equals(RuleType.HOST)) {
                listDescriptor.hosts.add(obj);
            } else if (type.equals(RuleType.IP)) {
                listDescriptor.ips.add(obj);
            } else if (type.equals(RuleType.COUNTRY)) {
                listDescriptor.countries.add(obj);
            } else if (!type.equals(RuleType.APP)) {
                Log.w(TAG, "ListDescriptor does not support RuleType " + type.name());
            }
        }
        ArraySet arraySet = this.mUids;
        arraySet.getClass();
        ArrayMap.KeyIterator keyIterator = new ArrayMap.KeyIterator(arraySet);
        while (keyIterator.hasNext()) {
            int intValue = ((Integer) keyIterator.next()).intValue();
            if (!isExemptedApp(intValue)) {
                listDescriptor.apps.add(Integer.toString(intValue));
            }
        }
        return listDescriptor;
    }

    public boolean uidMappingChanged(String str) {
        boolean z = false;
        if (!this.mMatches.containsKey(matchKey(RuleType.APP, str))) {
            return false;
        }
        Integer num = this.mPackageToUid.get(str);
        AppDescriptor appByPackage = this.mResolver.getAppByPackage(str, 0);
        if (num != null && (appByPackage == null || appByPackage.getUid() != num.intValue())) {
            Log.i(TAG, "Remove old UID mapping of " + str + ": " + num);
            this.mPackageToUid.remove(str);
            this.mUids.remove(num);
            num = null;
            z = true;
        }
        if (num != null || appByPackage == null) {
            return z;
        }
        int uid = appByPackage.getUid();
        Log.i(TAG, "Add UID mapping of " + str + ": " + uid);
        this.mPackageToUid.put(str, Integer.valueOf(uid));
        this.mUids.add(Integer.valueOf(uid));
        return true;
    }

    public boolean addApp(int i) {
        AppDescriptor appByUid = this.mResolver.getAppByUid(i, 0);
        if (appByUid != null) {
            return addApp(appByUid.getPackageName());
        }
        Log.e(TAG, "could not resolve UID " + i);
        return false;
    }

    public void removeApp(int i) {
        AppDescriptor appByUid = this.mResolver.getAppByUid(i, 0);
        if (appByUid == null) {
            Log.e(TAG, "could not resolve UID " + i);
            return;
        }
        removeApp(appByUid.getPackageName());
    }

    public int fromJson(String str) {
        return fromJson(str, -1);
    }

    public void clear() {
        clear(true);
    }

    private boolean addRule(Rule rule) {
        return addRule(rule, true);
    }
}
