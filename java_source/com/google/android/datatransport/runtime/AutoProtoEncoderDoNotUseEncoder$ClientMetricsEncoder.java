package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import java.util.HashMap;
import p004j$.util.DesugarCollections;
/* loaded from: classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder implements ObjectEncoder {
    public static final FieldDescriptor APPNAMESPACE_DESCRIPTOR;
    public static final FieldDescriptor GLOBALMETRICS_DESCRIPTOR;
    public static final AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder INSTANCE = new Object();
    public static final FieldDescriptor LOGSOURCEMETRICS_DESCRIPTOR;
    public static final FieldDescriptor WINDOW_DESCRIPTOR;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.android.datatransport.runtime.AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder] */
    static {
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = new AtProtobuf$ProtobufImpl(1);
        HashMap hashMap = new HashMap();
        hashMap.put(Protobuf.class, atProtobuf$ProtobufImpl);
        WINDOW_DESCRIPTOR = new FieldDescriptor("window", DesugarCollections.unmodifiableMap(new HashMap(hashMap)));
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl2 = new AtProtobuf$ProtobufImpl(2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Protobuf.class, atProtobuf$ProtobufImpl2);
        LOGSOURCEMETRICS_DESCRIPTOR = new FieldDescriptor("logSourceMetrics", DesugarCollections.unmodifiableMap(new HashMap(hashMap2)));
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl3 = new AtProtobuf$ProtobufImpl(3);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(Protobuf.class, atProtobuf$ProtobufImpl3);
        GLOBALMETRICS_DESCRIPTOR = new FieldDescriptor("globalMetrics", DesugarCollections.unmodifiableMap(new HashMap(hashMap3)));
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl4 = new AtProtobuf$ProtobufImpl(4);
        HashMap hashMap4 = new HashMap();
        hashMap4.put(Protobuf.class, atProtobuf$ProtobufImpl4);
        APPNAMESPACE_DESCRIPTOR = new FieldDescriptor("appNamespace", DesugarCollections.unmodifiableMap(new HashMap(hashMap4)));
    }

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ClientMetrics clientMetrics = (ClientMetrics) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(WINDOW_DESCRIPTOR, clientMetrics.window_);
        objectEncoderContext.add(LOGSOURCEMETRICS_DESCRIPTOR, clientMetrics.log_source_metrics_);
        objectEncoderContext.add(GLOBALMETRICS_DESCRIPTOR, clientMetrics.global_metrics_);
        objectEncoderContext.add(APPNAMESPACE_DESCRIPTOR, clientMetrics.app_namespace_);
    }
}
