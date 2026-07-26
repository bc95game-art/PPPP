package androidx.emoji2.text.flatbuffer;

import android.os.Build;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.transition.ViewUtilsApi21;
import java.nio.ByteBuffer;
import java.util.ConcurrentModificationException;
import kotlin.collections.builders.MapBuilder;
/* loaded from: classes.dex */
public abstract class Table {

    /* renamed from: bb */
    public Object f9bb;
    public int bb_pos;
    public int vtable_size;
    public int vtable_start;

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    public Table() {
        if (ViewUtilsApi21.DEFAULT == null) {
            ViewUtilsApi21.DEFAULT = new Object();
        }
    }

    public int __offset(int i) {
        if (i < this.vtable_size) {
            return ((ByteBuffer) this.f9bb).getShort(this.vtable_start + i);
        }
        return 0;
    }

    public void checkForComodification$kotlin_stdlib() {
        if (((MapBuilder) this.f9bb).modCount != this.vtable_size) {
            throw new ConcurrentModificationException();
        }
    }

    public abstract Object frameworkGet(View view);

    public abstract void frameworkSet(View view, Object obj);

    public boolean hasNext() {
        if (this.bb_pos < ((MapBuilder) this.f9bb).length) {
            return true;
        }
        return false;
    }

    public void initNext$kotlin_stdlib() {
        while (true) {
            int i = this.bb_pos;
            MapBuilder mapBuilder = (MapBuilder) this.f9bb;
            if (i < mapBuilder.length && mapBuilder.presenceArray[i] < 0) {
                this.bb_pos = i + 1;
            } else {
                return;
            }
        }
    }

    public void remove() {
        MapBuilder mapBuilder = (MapBuilder) this.f9bb;
        checkForComodification$kotlin_stdlib();
        if (this.vtable_start != -1) {
            mapBuilder.checkIsMutable$kotlin_stdlib();
            mapBuilder.removeEntryAt(this.vtable_start);
            this.vtable_start = -1;
            this.vtable_size = mapBuilder.modCount;
            return;
        }
        throw new IllegalStateException("Call next() before removing element from the iterator.");
    }

    public void set(View view, Object obj) {
        Object obj2;
        AccessibilityDelegateCompat accessibilityDelegateCompat;
        if (Build.VERSION.SDK_INT >= this.vtable_start) {
            frameworkSet(view, obj);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.vtable_start) {
            obj2 = frameworkGet(view);
        } else {
            obj2 = view.getTag(this.bb_pos);
            if (!((Class) this.f9bb).isInstance(obj2)) {
                obj2 = null;
            }
        }
        if (shouldUpdate(obj2, obj)) {
            View.AccessibilityDelegate accessibilityDelegateInternal = ViewCompat.getAccessibilityDelegateInternal(view);
            if (accessibilityDelegateInternal == null) {
                accessibilityDelegateCompat = null;
            } else if (accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) {
                accessibilityDelegateCompat = ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegateInternal).mCompat;
            } else {
                accessibilityDelegateCompat = new AccessibilityDelegateCompat(accessibilityDelegateInternal);
            }
            if (accessibilityDelegateCompat == null) {
                accessibilityDelegateCompat = new AccessibilityDelegateCompat();
            }
            ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompat);
            view.setTag(this.bb_pos, obj);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(this.vtable_size, view);
        }
    }

    public abstract boolean shouldUpdate(Object obj, Object obj2);
}
