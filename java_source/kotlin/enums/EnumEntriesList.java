package kotlin.enums;

import androidx.lifecycle.ViewModelProvider;
import java.io.Serializable;
import kotlin.collections.AbstractList;
/* loaded from: classes.dex */
public final class EnumEntriesList extends AbstractList implements EnumEntries, Serializable {
    public final Enum[] entries;

    public EnumEntriesList(Enum[] enumArr) {
        this.entries = enumArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001a A[ORIG_RETURN, RETURN] */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean contains(Object obj) {
        Enum r0;
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r4 = (Enum) obj;
        int ordinal = r4.ordinal();
        if (ordinal >= 0) {
            Enum[] enumArr = this.entries;
            if (ordinal < enumArr.length) {
                r0 = enumArr[ordinal];
                if (r0 != r4) {
                    return true;
                }
                return false;
            }
        }
        r0 = null;
        if (r0 != r4) {
        }
    }

    @Override // java.util.List
    public final Object get(int i) {
        Enum[] enumArr = this.entries;
        int length = enumArr.length;
        if (i >= 0 && i < length) {
            return enumArr[i];
        }
        throw new IndexOutOfBoundsException(ViewModelProvider.Factory.CC.m605m(i, length, "index: ", ", size: "));
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.entries.length;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0019 A[ORIG_RETURN, RETURN] */
    @Override // kotlin.collections.AbstractList, java.util.List
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int indexOf(Object obj) {
        Enum r1;
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r4 = (Enum) obj;
        int ordinal = r4.ordinal();
        if (ordinal >= 0) {
            Enum[] enumArr = this.entries;
            if (ordinal < enumArr.length) {
                r1 = enumArr[ordinal];
                if (r1 != r4) {
                    return ordinal;
                }
                return -1;
            }
        }
        r1 = null;
        if (r1 != r4) {
        }
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        return indexOf((Enum) obj);
    }
}
