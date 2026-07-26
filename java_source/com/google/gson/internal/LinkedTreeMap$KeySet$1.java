package com.google.gson.internal;

import com.google.gson.internal.LinkedTreeMap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class LinkedTreeMap$KeySet$1 implements Iterator {
    public final /* synthetic */ int $r8$classId;
    public int expectedModCount;
    public LinkedTreeMap.Node lastReturned = null;
    public LinkedTreeMap.Node next;
    public final /* synthetic */ LinkedTreeMap this$0;

    public LinkedTreeMap$KeySet$1(LinkedTreeMap linkedTreeMap, int i) {
        this.$r8$classId = i;
        this.this$0 = linkedTreeMap;
        this.next = linkedTreeMap.header.next;
        this.expectedModCount = linkedTreeMap.modCount;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.next != this.this$0.header) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch (this.$r8$classId) {
            case 0:
                return nextNode().key;
            default:
                return m565x1f94beef();
        }
    }

    /* renamed from: next$com$google$gson$internal$LinkedTreeMap$LinkedTreeMapIterator */
    public final Object m565x1f94beef() {
        return nextNode();
    }

    public final LinkedTreeMap.Node nextNode() {
        LinkedTreeMap.Node node = this.next;
        LinkedTreeMap linkedTreeMap = this.this$0;
        if (node == linkedTreeMap.header) {
            throw new NoSuchElementException();
        } else if (linkedTreeMap.modCount == this.expectedModCount) {
            this.next = node.next;
            this.lastReturned = node;
            return node;
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        LinkedTreeMap.Node node = this.lastReturned;
        if (node != null) {
            LinkedTreeMap linkedTreeMap = this.this$0;
            linkedTreeMap.removeInternal(node, true);
            this.lastReturned = null;
            this.expectedModCount = linkedTreeMap.modCount;
            return;
        }
        throw new IllegalStateException();
    }
}
