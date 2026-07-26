package com.google.gson;

import androidx.lifecycle.ViewModelProvider;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class JsonArray extends JsonElement implements Iterable {
    public final ArrayList elements = new ArrayList();

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JsonArray) || !((JsonArray) obj).elements.equals(this.elements)) {
            return false;
        }
        return true;
    }

    @Override // com.google.gson.JsonElement
    public final String getAsString() {
        ArrayList arrayList = this.elements;
        int size = arrayList.size();
        if (size == 1) {
            return ((JsonElement) arrayList.get(0)).getAsString();
        }
        throw new IllegalStateException(ViewModelProvider.Factory.CC.m604m(size, "Array must have size 1, but has size "));
    }

    public final int hashCode() {
        return this.elements.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.elements.iterator();
    }
}
