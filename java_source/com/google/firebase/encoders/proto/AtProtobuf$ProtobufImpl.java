package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.proto.Protobuf;
/* loaded from: classes.dex */
public final class AtProtobuf$ProtobufImpl implements Protobuf {
    public final int tag;

    public AtProtobuf$ProtobufImpl(int i) {
        this.tag = i;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return Protobuf.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Protobuf)) {
            return false;
        }
        if (this.tag != ((AtProtobuf$ProtobufImpl) ((Protobuf) obj)).tag) {
            return false;
        }
        Object obj2 = Protobuf.IntEncoding.DEFAULT;
        if (obj2.equals(obj2)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (14552422 ^ this.tag) + (Protobuf.IntEncoding.DEFAULT.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.tag + "intEncoding=" + Protobuf.IntEncoding.DEFAULT + ')';
    }
}
