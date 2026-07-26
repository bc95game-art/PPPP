package androidx.arch.core.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class SafeIterableMap implements Iterable {
    public Entry mEnd;
    public final WeakHashMap mIterators = new WeakHashMap();
    public int mSize = 0;
    public Entry mStart;

    /* loaded from: classes.dex */
    public final class AscendingIterator extends SupportRemove implements Iterator {
        public final /* synthetic */ int $r8$classId;
        public Entry mExpectedEnd;
        public Entry mNext;

        public AscendingIterator(Entry entry, Entry entry2, int i) {
            this.$r8$classId = i;
            this.mExpectedEnd = entry2;
            this.mNext = entry;
        }

        public final Entry forward(Entry entry) {
            switch (this.$r8$classId) {
                case 0:
                    return entry.mNext;
                default:
                    return entry.mPrevious;
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.mNext != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            Entry entry;
            Entry entry2 = this.mNext;
            Entry entry3 = this.mExpectedEnd;
            if (entry2 == entry3 || entry3 == null) {
                entry = null;
            } else {
                entry = forward(entry2);
            }
            this.mNext = entry;
            return entry2;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public final void supportRemove(Entry entry) {
            Entry entry2;
            Entry entry3 = null;
            if (this.mExpectedEnd == entry && entry == this.mNext) {
                this.mNext = null;
                this.mExpectedEnd = null;
            }
            Entry entry4 = this.mExpectedEnd;
            if (entry4 == entry) {
                switch (this.$r8$classId) {
                    case 0:
                        entry2 = entry4.mPrevious;
                        break;
                    default:
                        entry2 = entry4.mNext;
                        break;
                }
                this.mExpectedEnd = entry2;
            }
            Entry entry5 = this.mNext;
            if (entry5 == entry) {
                Entry entry6 = this.mExpectedEnd;
                if (!(entry5 == entry6 || entry6 == null)) {
                    entry3 = forward(entry5);
                }
                this.mNext = entry3;
            }
        }
    }

    /* loaded from: classes.dex */
    public final class Entry implements Map.Entry {
        public final Object mKey;
        public Entry mNext;
        public Entry mPrevious;
        public final Object mValue;

        public Entry(Object obj, Object obj2) {
            this.mKey = obj;
            this.mValue = obj2;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (!this.mKey.equals(entry.mKey) || !this.mValue.equals(entry.mValue)) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.mKey;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.mValue;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.mKey.hashCode() ^ this.mValue.hashCode();
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public final String toString() {
            return this.mKey + "=" + this.mValue;
        }
    }

    /* loaded from: classes.dex */
    public final class IteratorWithAdditions extends SupportRemove implements Iterator {
        public boolean mBeforeStart = true;
        public Entry mCurrent;

        public IteratorWithAdditions() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (!this.mBeforeStart) {
                Entry entry = this.mCurrent;
                if (entry == null || entry.mNext == null) {
                    return false;
                }
                return true;
            } else if (SafeIterableMap.this.mStart != null) {
                return true;
            } else {
                return false;
            }
        }

        @Override // java.util.Iterator
        public final Object next() {
            Entry entry;
            if (this.mBeforeStart) {
                this.mBeforeStart = false;
                this.mCurrent = SafeIterableMap.this.mStart;
            } else {
                Entry entry2 = this.mCurrent;
                if (entry2 != null) {
                    entry = entry2.mNext;
                } else {
                    entry = null;
                }
                this.mCurrent = entry;
            }
            return this.mCurrent;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public final void supportRemove(Entry entry) {
            boolean z;
            Entry entry2 = this.mCurrent;
            if (entry == entry2) {
                Entry entry3 = entry2.mPrevious;
                this.mCurrent = entry3;
                if (entry3 == null) {
                    z = true;
                } else {
                    z = false;
                }
                this.mBeforeStart = z;
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class SupportRemove {
        public abstract void supportRemove(Entry entry);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r3.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
        if (((androidx.arch.core.internal.SafeIterableMap.AscendingIterator) r7).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (this.mSize != safeIterableMap.mSize) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = safeIterableMap.iterator();
        while (true) {
            AscendingIterator ascendingIterator = (AscendingIterator) it;
            if (!ascendingIterator.hasNext()) {
                break;
            }
            AscendingIterator ascendingIterator2 = (AscendingIterator) it2;
            if (!ascendingIterator2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) ascendingIterator.next();
            Object next = ascendingIterator2.next();
            if ((entry != null || next == null) && (entry == null || entry.equals(next))) {
            }
        }
        return false;
    }

    public Entry get(Object obj) {
        Entry entry = this.mStart;
        while (entry != null && !entry.mKey.equals(obj)) {
            entry = entry.mNext;
        }
        return entry;
    }

    public final int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (true) {
            AscendingIterator ascendingIterator = (AscendingIterator) it;
            if (!ascendingIterator.hasNext()) {
                return i;
            }
            i += ((Map.Entry) ascendingIterator.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        AscendingIterator ascendingIterator = new AscendingIterator(this.mStart, this.mEnd, 0);
        this.mIterators.put(ascendingIterator, Boolean.FALSE);
        return ascendingIterator;
    }

    public Object remove(Object obj) {
        Entry entry = get(obj);
        if (entry == null) {
            return null;
        }
        this.mSize--;
        WeakHashMap weakHashMap = this.mIterators;
        if (!weakHashMap.isEmpty()) {
            for (SupportRemove supportRemove : weakHashMap.keySet()) {
                supportRemove.supportRemove(entry);
            }
        }
        Entry entry2 = entry.mPrevious;
        if (entry2 != null) {
            entry2.mNext = entry.mNext;
        } else {
            this.mStart = entry.mNext;
        }
        Entry entry3 = entry.mNext;
        if (entry3 != null) {
            entry3.mPrevious = entry2;
        } else {
            this.mEnd = entry2;
        }
        entry.mNext = null;
        entry.mPrevious = null;
        return entry.mValue;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            AscendingIterator ascendingIterator = (AscendingIterator) it;
            if (ascendingIterator.hasNext()) {
                sb.append(((Map.Entry) ascendingIterator.next()).toString());
                if (ascendingIterator.hasNext()) {
                    sb.append(", ");
                }
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
