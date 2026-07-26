package com.emanuelef.remote_capture.model;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.google.gson.FormattingStyle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public class PortMapping {
    private static final String TAG = "PortMappings";
    private ArrayList<PortMap> mMapping = new ArrayList<>();
    private final SharedPreferences mPrefs;

    /* loaded from: classes.dex */
    public static class PortMap {
        public final int ipproto;
        public final int orig_port;
        @SerializedName("redirect_ip")
        public final String redirect_host;
        public final int redirect_port;

        public PortMap(int i, int i2, int i3, String str) {
            this.ipproto = i;
            this.orig_port = i2;
            this.redirect_port = i3;
            this.redirect_host = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                PortMap portMap = (PortMap) obj;
                if (this.ipproto == portMap.ipproto && this.orig_port == portMap.orig_port && this.redirect_port == portMap.redirect_port && this.redirect_host.equals(portMap.redirect_host)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.ipproto), Integer.valueOf(this.orig_port), Integer.valueOf(this.redirect_port), this.redirect_host);
        }
    }

    public PortMapping(Context context) {
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        reload();
    }

    public boolean add(PortMap portMap) {
        if (this.mMapping.contains(portMap)) {
            return false;
        }
        this.mMapping.add(portMap);
        return true;
    }

    public void clear() {
        this.mMapping.clear();
    }

    public boolean fromJson(String str) {
        try {
            this.mMapping = (ArrayList) new Gson().fromJson(str, TypeToken.get(new TypeToken<ArrayList<PortMap>>() { // from class: com.emanuelef.remote_capture.model.PortMapping.1
            }.getType()));
            return true;
        } catch (JsonParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Iterator<PortMap> iter() {
        return this.mMapping.iterator();
    }

    public void reload() {
        String string = this.mPrefs.getString(Prefs.PREF_PORT_MAPPING, "");
        if (!string.isEmpty()) {
            fromJson(string);
        } else {
            clear();
        }
    }

    public boolean remove(PortMap portMap) {
        return this.mMapping.remove(portMap);
    }

    public void save() {
        this.mPrefs.edit().putString(Prefs.PREF_PORT_MAPPING, toJson(false)).apply();
    }

    public String toJson(boolean z) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        if (z) {
            FormattingStyle formattingStyle = FormattingStyle.PRETTY;
            Objects.requireNonNull(formattingStyle);
            gsonBuilder.formattingStyle = formattingStyle;
        }
        return gsonBuilder.create().toJson(this.mMapping);
    }
}
