package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import j$.util.DesugarCollections;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder$LogSourceMetricsEncoder implements ObjectEncoder {
    public static final AutoProtoEncoderDoNotUseEncoder$LogSourceMetricsEncoder INSTANCE = new Object();
    public static final FieldDescriptor LOGEVENTDROPPED_DESCRIPTOR;
    public static final FieldDescriptor LOGSOURCE_DESCRIPTOR;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.android.datatransport.runtime.AutoProtoEncoderDoNotUseEncoder$LogSourceMetricsEncoder] */
    static {
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = new AtProtobuf$ProtobufImpl(1);
        HashMap hashMap = new HashMap();
        hashMap.put(Protobuf.class, atProtobuf$ProtobufImpl);
        LOGSOURCE_DESCRIPTOR = new FieldDescriptor("logSource", DesugarCollections.unmodifiableMap(new HashMap(hashMap)));
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl2 = new AtProtobuf$ProtobufImpl(2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Protobuf.class, atProtobuf$ProtobufImpl2);
        LOGEVENTDROPPED_DESCRIPTOR = new FieldDescriptor("logEventDropped", DesugarCollections.unmodifiableMap(new HashMap(hashMap2)));
    }

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        LogSourceMetrics logSourceMetrics = (LogSourceMetrics) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(LOGSOURCE_DESCRIPTOR, logSourceMetrics.log_source_);
        objectEncoderContext.add(LOGEVENTDROPPED_DESCRIPTOR, logSourceMetrics.log_event_dropped_);
    }
}
