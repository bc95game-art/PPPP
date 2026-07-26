package kotlin.jvm.internal;

import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.markers.KMappedMarker;
/* loaded from: classes.dex */
public class ArrayIterator implements Iterator, KMappedMarker {
    public final /* synthetic */ int $r8$classId;
    public final Object array;
    public int index;

    public /* synthetic */ ArrayIterator(int i, Object obj) {
        this.$r8$classId = i;
        this.array = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.$r8$classId) {
            case 0:
                if (this.index < ((Object[]) this.array).length) {
                    return true;
                }
                return false;
            case 1:
                if (this.index < ((SparseArrayCompat) this.array).size()) {
                    return true;
                }
                return false;
            case 2:
                if (this.index < ((ViewGroup) this.array).getChildCount()) {
                    return true;
                }
                return false;
            default:
                if (this.index < ((AbstractList) this.array).getSize()) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.$r8$classId) {
            case 0:
                try {
                    int i = this.index;
                    this.index = i + 1;
                    return ((Object[]) this.array)[i];
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.index--;
                    throw new NoSuchElementException(e.getMessage());
                }
            case 1:
                int i2 = this.index;
                this.index = i2 + 1;
                return ((SparseArrayCompat) this.array).valueAt(i2);
            case 2:
                int i3 = this.index;
                this.index = i3 + 1;
                View childAt = ((ViewGroup) this.array).getChildAt(i3);
                if (childAt != null) {
                    return childAt;
                }
                throw new IndexOutOfBoundsException();
            default:
                if (hasNext()) {
                    int i4 = this.index;
                    this.index = i4 + 1;
                    return ((AbstractList) this.array).get(i4);
                }
                throw new NoSuchElementException();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 2:
                int i = this.index - 1;
                this.index = i;
                ((ViewGroup) this.array).removeViewAt(i);
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public ArrayIterator(Object[] array) {
        this.$r8$classId = 0;
        Intrinsics.checkNotNullParameter(array, "array");
        this.array = array;
    }
}
