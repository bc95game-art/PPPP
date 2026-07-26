package com.google.gson.internal;

import androidx.collection.ArrayMap;
import androidx.viewpager.widget.ViewPager;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class LinkedTreeMap extends AbstractMap implements Serializable {
    public static final ViewPager.AnonymousClass1 NATURAL_ORDER = new ViewPager.AnonymousClass1(6);
    public final boolean allowNullValues;
    public ArrayMap.EntrySet entrySet;
    public final Node header;
    public ArrayMap.EntrySet keySet;
    public Node root;
    public int size = 0;
    public int modCount = 0;
    public final Comparator comparator = NATURAL_ORDER;

    public LinkedTreeMap(boolean z) {
        this.allowNullValues = z;
        this.header = new Node(z);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        Node node = this.header;
        node.prev = node;
        node.next = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Node node = null;
        if (obj != null) {
            try {
                node = find(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        if (node != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        ArrayMap.EntrySet entrySet = this.entrySet;
        if (entrySet != null) {
            return entrySet;
        }
        ArrayMap.EntrySet entrySet2 = new ArrayMap.EntrySet(this, 1);
        this.entrySet = entrySet2;
        return entrySet2;
    }

    public final Node find(Object obj, boolean z) {
        int i;
        Node node;
        Comparable comparable;
        Node node2;
        Node node3 = this.root;
        ViewPager.AnonymousClass1 r2 = NATURAL_ORDER;
        Comparator comparator = this.comparator;
        if (node3 != null) {
            if (comparator == r2) {
                comparable = (Comparable) obj;
            } else {
                comparable = null;
            }
            while (true) {
                Object obj2 = node3.key;
                if (comparable != null) {
                    i = comparable.compareTo(obj2);
                } else {
                    i = comparator.compare(obj, obj2);
                }
                if (i == 0) {
                    return node3;
                }
                if (i < 0) {
                    node2 = node3.left;
                } else {
                    node2 = node3.right;
                }
                if (node2 == null) {
                    break;
                }
                node3 = node2;
            }
        } else {
            i = 0;
        }
        Node node4 = node3;
        if (!z) {
            return null;
        }
        Node node5 = this.header;
        if (node4 != null) {
            node = new Node(this.allowNullValues, node4, obj, node5, node5.prev);
            if (i < 0) {
                node4.left = node;
            } else {
                node4.right = node;
            }
            rebalance(node4, true);
        } else if (comparator != r2 || (obj instanceof Comparable)) {
            node = new Node(this.allowNullValues, node4, obj, node5, node5.prev);
            this.root = node;
        } else {
            throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
        }
        this.size++;
        this.modCount++;
        return node;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0010 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x000d  */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto La
            r1 = 0
            com.google.gson.internal.LinkedTreeMap$Node r3 = r2.find(r3, r1)     // Catch: java.lang.ClassCastException -> L9
            goto Lb
        L9:
        La:
            r3 = r0
        Lb:
            if (r3 == 0) goto L10
            java.lang.Object r3 = r3.value
            return r3
        L10:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        ArrayMap.EntrySet entrySet = this.keySet;
        if (entrySet != null) {
            return entrySet;
        }
        ArrayMap.EntrySet entrySet2 = new ArrayMap.EntrySet(this, 2);
        this.keySet = entrySet2;
        return entrySet2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        } else if (obj2 != null || this.allowNullValues) {
            Node find = find(obj, true);
            Object obj3 = find.value;
            find.value = obj2;
            return obj3;
        } else {
            throw new NullPointerException("value == null");
        }
    }

    public final void rebalance(Node node, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        while (node != null) {
            Node node2 = node.left;
            Node node3 = node.right;
            int i5 = 0;
            if (node2 != null) {
                i = node2.height;
            } else {
                i = 0;
            }
            if (node3 != null) {
                i2 = node3.height;
            } else {
                i2 = 0;
            }
            int i6 = i - i2;
            if (i6 == -2) {
                Node node4 = node3.left;
                Node node5 = node3.right;
                if (node5 != null) {
                    i4 = node5.height;
                } else {
                    i4 = 0;
                }
                if (node4 != null) {
                    i5 = node4.height;
                }
                int i7 = i5 - i4;
                if (i7 == -1 || (i7 == 0 && !z)) {
                    rotateLeft(node);
                } else {
                    rotateRight(node3);
                    rotateLeft(node);
                }
                if (z) {
                    return;
                }
            } else if (i6 == 2) {
                Node node6 = node2.left;
                Node node7 = node2.right;
                if (node7 != null) {
                    i3 = node7.height;
                } else {
                    i3 = 0;
                }
                if (node6 != null) {
                    i5 = node6.height;
                }
                int i8 = i5 - i3;
                if (i8 == 1 || (i8 == 0 && !z)) {
                    rotateRight(node);
                } else {
                    rotateLeft(node2);
                    rotateRight(node);
                }
                if (z) {
                    return;
                }
            } else if (i6 == 0) {
                node.height = i + 1;
                if (z) {
                    return;
                }
            } else {
                node.height = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            node = node.parent;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0016 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x000d  */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object remove(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto La
            r1 = 0
            com.google.gson.internal.LinkedTreeMap$Node r3 = r2.find(r3, r1)     // Catch: java.lang.ClassCastException -> L9
            goto Lb
        L9:
        La:
            r3 = r0
        Lb:
            if (r3 == 0) goto L11
            r1 = 1
            r2.removeInternal(r3, r1)
        L11:
            if (r3 == 0) goto L16
            java.lang.Object r3 = r3.value
            return r3
        L16:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.remove(java.lang.Object):java.lang.Object");
    }

    public final void removeInternal(Node node, boolean z) {
        Node node2;
        int i;
        Node node3;
        if (z) {
            Node node4 = node.prev;
            node4.next = node.next;
            node.next.prev = node4;
        }
        Node node5 = node.left;
        Node node6 = node.right;
        Node node7 = node.parent;
        int i2 = 0;
        if (node5 == null || node6 == null) {
            if (node5 != null) {
                replaceInParent(node, node5);
                node.left = null;
            } else if (node6 != null) {
                replaceInParent(node, node6);
                node.right = null;
            } else {
                replaceInParent(node, null);
            }
            rebalance(node7, false);
            this.size--;
            this.modCount++;
            return;
        }
        if (node5.height > node6.height) {
            Node node8 = node5.right;
            while (true) {
                Node node9 = node8;
                node2 = node5;
                node5 = node9;
                if (node5 == null) {
                    break;
                }
                node8 = node5.right;
            }
        } else {
            Node node10 = node6.left;
            while (true) {
                node3 = node6;
                node6 = node10;
                if (node6 == null) {
                    break;
                }
                node10 = node6.left;
            }
            node2 = node3;
        }
        removeInternal(node2, false);
        Node node11 = node.left;
        if (node11 != null) {
            i = node11.height;
            node2.left = node11;
            node11.parent = node2;
            node.left = null;
        } else {
            i = 0;
        }
        Node node12 = node.right;
        if (node12 != null) {
            i2 = node12.height;
            node2.right = node12;
            node12.parent = node2;
            node.right = null;
        }
        node2.height = Math.max(i, i2) + 1;
        replaceInParent(node, node2);
    }

    public final void replaceInParent(Node node, Node node2) {
        Node node3 = node.parent;
        node.parent = null;
        if (node2 != null) {
            node2.parent = node3;
        }
        if (node3 == null) {
            this.root = node2;
        } else if (node3.left == node) {
            node3.left = node2;
        } else {
            node3.right = node2;
        }
    }

    public final void rotateLeft(Node node) {
        int i;
        int i2;
        Node node2 = node.left;
        Node node3 = node.right;
        Node node4 = node3.left;
        Node node5 = node3.right;
        node.right = node4;
        if (node4 != null) {
            node4.parent = node;
        }
        replaceInParent(node, node3);
        node3.left = node;
        node.parent = node3;
        int i3 = 0;
        if (node2 != null) {
            i = node2.height;
        } else {
            i = 0;
        }
        if (node4 != null) {
            i2 = node4.height;
        } else {
            i2 = 0;
        }
        int max = Math.max(i, i2) + 1;
        node.height = max;
        if (node5 != null) {
            i3 = node5.height;
        }
        node3.height = Math.max(max, i3) + 1;
    }

    public final void rotateRight(Node node) {
        int i;
        int i2;
        Node node2 = node.left;
        Node node3 = node.right;
        Node node4 = node2.left;
        Node node5 = node2.right;
        node.left = node5;
        if (node5 != null) {
            node5.parent = node;
        }
        replaceInParent(node, node2);
        node2.right = node;
        node.parent = node2;
        int i3 = 0;
        if (node3 != null) {
            i = node3.height;
        } else {
            i = 0;
        }
        if (node5 != null) {
            i2 = node5.height;
        } else {
            i2 = 0;
        }
        int max = Math.max(i, i2) + 1;
        node.height = max;
        if (node4 != null) {
            i3 = node4.height;
        }
        node2.height = Math.max(max, i3) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.size;
    }

    /* loaded from: classes.dex */
    public final class Node implements Map.Entry {
        public final boolean allowNullValue;
        public int height;
        public final Object key;
        public Node left;
        public Node next;
        public Node parent;
        public Node prev;
        public Node right;
        public Object value;

        public Node(boolean z) {
            this.key = null;
            this.allowNullValue = z;
            this.prev = this;
            this.next = this;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = this.key;
                if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                    Object obj3 = this.value;
                    if (obj3 == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (obj3.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            int i;
            int i2 = 0;
            Object obj = this.key;
            if (obj == null) {
                i = 0;
            } else {
                i = obj.hashCode();
            }
            Object obj2 = this.value;
            if (obj2 != null) {
                i2 = obj2.hashCode();
            }
            return i2 ^ i;
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            if (obj != null || this.allowNullValue) {
                Object obj2 = this.value;
                this.value = obj;
                return obj2;
            }
            throw new NullPointerException("value == null");
        }

        public final String toString() {
            return this.key + "=" + this.value;
        }

        public Node(boolean z, Node node, Object obj, Node node2, Node node3) {
            this.parent = node;
            this.key = obj;
            this.allowNullValue = z;
            this.height = 1;
            this.next = node2;
            this.prev = node3;
            node3.next = this;
            node2.prev = this;
        }
    }
}
