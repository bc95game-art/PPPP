package p004j$.util.concurrent;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
/* renamed from: j$.util.concurrent.b */
/* loaded from: classes2.dex */
public abstract class AbstractC0410b implements Collection, Serializable {
    private static final long serialVersionUID = 7249069246763182397L;

    /* renamed from: a */
    public final ConcurrentHashMap f336a;

    @Override // java.util.Collection
    public abstract boolean contains(Object obj);

    @Override // java.util.Collection, java.lang.Iterable
    public abstract Iterator iterator();

    @Override // java.util.Collection
    public abstract boolean remove(Object obj);

    public AbstractC0410b(ConcurrentHashMap concurrentHashMap) {
        this.f336a = concurrentHashMap;
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f336a.clear();
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f336a.size();
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f336a.isEmpty();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        long j = this.f336a.m263j();
        if (j < 0) {
            j = 0;
        }
        if (j <= 2147483639) {
            int i = (int) j;
            Object[] objArr = new Object[i];
            Iterator it = iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                if (i2 == i) {
                    int i3 = 2147483639;
                    if (i < 2147483639) {
                        if (i < 1073741819) {
                            i3 = (i >>> 1) + 1 + i;
                        }
                        objArr = Arrays.copyOf(objArr, i3);
                        i = i3;
                    } else {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                }
                i2++;
                objArr[i2] = next;
            }
            return i2 == i ? objArr : Arrays.copyOf(objArr, i2);
        }
        throw new OutOfMemoryError("Required array size too large");
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        long j = this.f336a.m263j();
        if (j < 0) {
            j = 0;
        }
        if (j <= 2147483639) {
            int i = (int) j;
            Object[] objArr2 = objArr.length >= i ? objArr : (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
            int length = objArr2.length;
            Iterator it = iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                if (i2 == length) {
                    int i3 = 2147483639;
                    if (length < 2147483639) {
                        if (length < 1073741819) {
                            i3 = (length >>> 1) + 1 + length;
                        }
                        objArr2 = Arrays.copyOf(objArr2, i3);
                        length = i3;
                    } else {
                        throw new OutOfMemoryError("Required array size too large");
                    }
                }
                i2++;
                objArr2[i2] = next;
            }
            if (objArr != objArr2 || i2 >= length) {
                return i2 == length ? objArr2 : Arrays.copyOf(objArr2, i2);
            }
            objArr2[i2] = null;
            return objArr2;
        }
        throw new OutOfMemoryError("Required array size too large");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        if (it.hasNext()) {
            while (true) {
                Object next = it.next();
                if (next == this) {
                    next = "(this Collection)";
                }
                sb.append(next);
                if (!it.hasNext()) {
                    break;
                }
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000c  */
    @Override // java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean containsAll(Collection collection) {
        if (collection == this) {
            return true;
        }
        for (Object obj : collection) {
            if (obj == null || !contains(obj)) {
                return false;
            }
            while (r2.hasNext()) {
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        collection.getClass();
        C0420l[] lVarArr = this.f336a.f321a;
        boolean z = false;
        if (lVarArr == null) {
            return false;
        }
        if (!(collection instanceof Set) || collection.size() <= lVarArr.length) {
            for (Object obj : collection) {
                z |= remove(obj);
            }
            return z;
        }
        Iterator it = iterator();
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        Iterator it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }
}
