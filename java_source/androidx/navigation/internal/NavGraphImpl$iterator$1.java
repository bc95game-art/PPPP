package androidx.navigation.internal;

import androidx.collection.ArraySetKt;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.NavDestination;
import com.android.billingclient.api.zzca;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
/* loaded from: classes.dex */
public final class NavGraphImpl$iterator$1 implements Iterator, KMappedMarker {
    public int index = -1;
    public final /* synthetic */ zzca this$0;
    public boolean wentToNext;

    public NavGraphImpl$iterator$1(zzca zzcaVar) {
        this.this$0 = zzcaVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.index + 1 < ((SparseArrayCompat) this.this$0.zzb).size()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.wentToNext = true;
            int i = this.index + 1;
            this.index = i;
            return (NavDestination) ((SparseArrayCompat) this.this$0.zzb).valueAt(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.wentToNext) {
            SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) this.this$0.zzb;
            ((NavDestination) sparseArrayCompat.valueAt(this.index)).parent = null;
            int i = this.index;
            Object[] objArr = sparseArrayCompat.values;
            Object obj = objArr[i];
            Object obj2 = ArraySetKt.DELETED$1;
            if (obj != obj2) {
                objArr[i] = obj2;
                sparseArrayCompat.garbage = true;
            }
            this.index = i - 1;
            this.wentToNext = false;
            return;
        }
        throw new IllegalStateException("You must call next() before you can remove an element");
    }
}
