package com.google.android.datatransport.runtime;

import androidx.appcompat.widget.AppCompatDrawableManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class AutoValue_EventInternal {
    public final Map autoMetadata;
    public final Integer code;
    public final EncodedPayload encodedPayload;
    public final long eventMillis;
    public final String transportName;
    public final long uptimeMillis;

    public AutoValue_EventInternal(String str, Integer num, EncodedPayload encodedPayload, long j, long j2, HashMap hashMap) {
        this.transportName = str;
        this.code = num;
        this.encodedPayload = encodedPayload;
        this.eventMillis = j;
        this.uptimeMillis = j2;
        this.autoMetadata = hashMap;
    }

    public final boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_EventInternal) {
            AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) obj;
            Integer num2 = autoValue_EventInternal.code;
            if (this.transportName.equals(autoValue_EventInternal.transportName) && ((num = this.code) != null ? num.equals(num2) : num2 == null) && this.encodedPayload.equals(autoValue_EventInternal.encodedPayload) && this.eventMillis == autoValue_EventInternal.eventMillis && this.uptimeMillis == autoValue_EventInternal.uptimeMillis && this.autoMetadata.equals(autoValue_EventInternal.autoMetadata)) {
                return true;
            }
        }
        return false;
    }

    public final String get(String str) {
        String str2 = (String) this.autoMetadata.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    public final int getInteger(String str) {
        String str2 = (String) this.autoMetadata.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final int hashCode() {
        int i;
        int hashCode = (this.transportName.hashCode() ^ 1000003) * 1000003;
        Integer num = this.code;
        if (num == null) {
            i = 0;
        } else {
            i = num.hashCode();
        }
        long j = this.eventMillis;
        long j2 = this.uptimeMillis;
        return ((((((((hashCode ^ i) * 1000003) ^ this.encodedPayload.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.autoMetadata.hashCode();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, androidx.appcompat.widget.AppCompatDrawableManager$1] */
    public final AppCompatDrawableManager.AnonymousClass1 toBuilder() {
        ?? obj = new Object();
        String str = this.transportName;
        if (str != null) {
            obj.COLORFILTER_TINT_COLOR_CONTROL_NORMAL = str;
            obj.TINT_COLOR_CONTROL_NORMAL = this.code;
            EncodedPayload encodedPayload = this.encodedPayload;
            if (encodedPayload != null) {
                obj.COLORFILTER_COLOR_CONTROL_ACTIVATED = encodedPayload;
                obj.COLORFILTER_COLOR_BACKGROUND_MULTIPLY = Long.valueOf(this.eventMillis);
                obj.TINT_COLOR_CONTROL_STATE_LIST = Long.valueOf(this.uptimeMillis);
                obj.TINT_CHECKABLE_BUTTON_LIST = new HashMap(this.autoMetadata);
                return obj;
            }
            throw new NullPointerException("Null encodedPayload");
        }
        throw new NullPointerException("Null transportName");
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.transportName + ", code=" + this.code + ", encodedPayload=" + this.encodedPayload + ", eventMillis=" + this.eventMillis + ", uptimeMillis=" + this.uptimeMillis + ", autoMetadata=" + this.autoMetadata + "}";
    }
}
