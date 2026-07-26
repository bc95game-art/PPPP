package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import java.util.HashMap;
import p004j$.util.DesugarCollections;
/* loaded from: classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder$GlobalMetricsEncoder implements ObjectEncoder {
    public static final AutoProtoEncoderDoNotUseEncoder$GlobalMetricsEncoder INSTANCE = new Object();
    public static final FieldDescriptor STORAGEMETRICS_DESCRIPTOR;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.datatransport.runtime.AutoProtoEncoderDoNotUseEncoder$GlobalMetricsEncoder, java.lang.Object] */
    static {
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = new AtProtobuf$ProtobufImpl(1);
        HashMap hashMap = new HashMap();
        hashMap.put(Protobuf.class, atProtobuf$ProtobufImpl);
        STORAGEMETRICS_DESCRIPTOR = new FieldDescriptor("storageMetrics", DesugarCollections.unmodifiableMap(new HashMap(hashMap)));
    }

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ((ObjectEncoderContext) obj2).add(STORAGEMETRICS_DESCRIPTOR, ((GlobalMetrics) obj).storage_metrics_);
    }
}
