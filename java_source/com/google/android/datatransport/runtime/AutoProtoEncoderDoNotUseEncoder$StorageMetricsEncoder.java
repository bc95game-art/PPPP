package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import java.util.HashMap;
import p004j$.util.DesugarCollections;
/* loaded from: classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder$StorageMetricsEncoder implements ObjectEncoder {
    public static final FieldDescriptor CURRENTCACHESIZEBYTES_DESCRIPTOR;
    public static final AutoProtoEncoderDoNotUseEncoder$StorageMetricsEncoder INSTANCE = new Object();
    public static final FieldDescriptor MAXCACHESIZEBYTES_DESCRIPTOR;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.android.datatransport.runtime.AutoProtoEncoderDoNotUseEncoder$StorageMetricsEncoder] */
    static {
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = new AtProtobuf$ProtobufImpl(1);
        HashMap hashMap = new HashMap();
        hashMap.put(Protobuf.class, atProtobuf$ProtobufImpl);
        CURRENTCACHESIZEBYTES_DESCRIPTOR = new FieldDescriptor("currentCacheSizeBytes", DesugarCollections.unmodifiableMap(new HashMap(hashMap)));
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl2 = new AtProtobuf$ProtobufImpl(2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Protobuf.class, atProtobuf$ProtobufImpl2);
        MAXCACHESIZEBYTES_DESCRIPTOR = new FieldDescriptor("maxCacheSizeBytes", DesugarCollections.unmodifiableMap(new HashMap(hashMap2)));
    }

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        StorageMetrics storageMetrics = (StorageMetrics) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(CURRENTCACHESIZEBYTES_DESCRIPTOR, storageMetrics.current_cache_size_bytes_);
        objectEncoderContext.add(MAXCACHESIZEBYTES_DESCRIPTOR, storageMetrics.max_cache_size_bytes_);
    }
}
