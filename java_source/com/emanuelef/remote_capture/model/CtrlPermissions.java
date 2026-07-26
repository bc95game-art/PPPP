package com.emanuelef.remote_capture.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.ArrayMap;
import androidx.collection.ArrayMap;
import androidx.preference.PreferenceManager;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.LinkedTreeMap$KeySet$1;
import java.lang.reflect.Type;
import java.util.Iterator;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public class CtrlPermissions {
    private static final String PREF_NAME = "ctrl_perms";
    private final SharedPreferences mPrefs;
    private final ArrayMap<String, Rule> mRules = new ArrayMap<>();

    /* loaded from: classes.dex */
    public enum ConsentType {
        UNSPECIFIED,
        ALLOW,
        DENY
    }

    /* loaded from: classes.dex */
    public static class Rule {
        public final ConsentType consent;
        public final String package_name;

        public Rule(String str, ConsentType consentType) {
            this.package_name = str;
            this.consent = consentType;
        }
    }

    /* loaded from: classes.dex */
    public static class Serializer implements JsonSerializer {
        public /* synthetic */ Serializer(int i) {
            this();
        }

        private Serializer() {
        }

        public JsonElement serialize(CtrlPermissions ctrlPermissions, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            JsonObject jsonObject2 = new JsonObject();
            for (Rule rule : ctrlPermissions.mRules.values()) {
                jsonObject2.add(rule.package_name, new JsonPrimitive(rule.consent.toString()));
            }
            jsonObject.members.put("rules", jsonObject2);
            return jsonObject;
        }
    }

    public CtrlPermissions(Context context) {
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        reload();
    }

    private void deserialize(JsonObject jsonObject) {
        this.mRules.clear();
        JsonObject jsonObject2 = (JsonObject) jsonObject.members.get("rules");
        if (jsonObject2 != null) {
            Iterator it = ((ArrayMap.EntrySet) jsonObject2.members.entrySet()).iterator();
            while (((LinkedTreeMap$KeySet$1) it).hasNext()) {
                LinkedTreeMap.Node nextNode = ((LinkedTreeMap$KeySet$1) it).nextNode();
                JsonElement jsonElement = (JsonElement) nextNode.getValue();
                jsonElement.getClass();
                if ((jsonElement instanceof JsonPrimitive) && (((JsonElement) nextNode.getValue()).getAsJsonPrimitive().value instanceof String)) {
                    try {
                        this.mRules.put((String) nextNode.getKey(), new Rule((String) nextNode.getKey(), ConsentType.valueOf(((JsonElement) nextNode.getValue()).getAsJsonPrimitive().getAsString())));
                    } catch (IllegalArgumentException unused) {
                    }
                }
            }
        }
    }

    private void save() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(getClass(), new Serializer(0));
        this.mPrefs.edit().putString(PREF_NAME, gsonBuilder.create().toJson(this)).apply();
    }

    public void add(String str, ConsentType consentType) {
        this.mRules.put(str, new Rule(str, consentType));
        save();
    }

    public ConsentType getConsent(String str) {
        Rule rule = this.mRules.get(str);
        if (rule == null) {
            return ConsentType.UNSPECIFIED;
        }
        return rule.consent;
    }

    public boolean hasRules() {
        return !this.mRules.isEmpty();
    }

    public Iterator<Rule> iterRules() {
        return this.mRules.values().iterator();
    }

    public void reload() {
        String string = this.mPrefs.getString(PREF_NAME, "");
        if (!string.isEmpty()) {
            deserialize(LazyKt__LazyJVMKt.parseString(string).getAsJsonObject());
        } else {
            this.mRules.clear();
        }
    }

    public void remove(String str) {
        this.mRules.remove(str);
        save();
    }

    public void removeAll() {
        this.mRules.clear();
        save();
    }
}
