package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
/* loaded from: classes.dex */
public final class JsonObject extends JsonElement {
    public final LinkedTreeMap members = new LinkedTreeMap(false);

    public final void add(String str, JsonElement jsonElement) {
        this.members.put(str, jsonElement);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JsonObject) || !((JsonObject) obj).members.equals(this.members)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.members.hashCode();
    }
}
