package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import j$.util.DesugarCollections;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder$LogEventDroppedEncoder implements ObjectEncoder {
    public static final FieldDescriptor EVENTSDROPPEDCOUNT_DESCRIPTOR;
    public static final AutoProtoEncoderDoNotUseEncoder$LogEventDroppedEncoder INSTANCE = new Object();
    public static final FieldDescriptor REASON_DESCRIPTOR;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.android.datatransport.runtime.AutoProtoEncoderDoNotUseEncoder$LogEventDroppedEncoder] */
    static {
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = new AtProtobuf$ProtobufImpl(1);
        HashMap hashMap = new HashMap();
        hashMap.put(Protobuf.class, atProtobuf$ProtobufImpl);
        EVENTSDROPPEDCOUNT_DESCRIPTOR = new FieldDescriptor("eventsDroppedCount", DesugarCollections.unmodifiableMap(new HashMap(hashMap)));
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl2 = new AtProtobuf$ProtobufImpl(3);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Protobuf.class, atProtobuf$ProtobufImpl2);
        REASON_DESCRIPTOR = new FieldDescriptor("reason", DesugarCollections.unmodifiableMap(new HashMap(hashMap2)));
    }

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        LogEventDropped logEventDropped = (LogEventDropped) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(EVENTSDROPPEDCOUNT_DESCRIPTOR, logEventDropped.events_dropped_count_);
        objectEncoderContext.add(REASON_DESCRIPTOR, logEventDropped.reason_);
    }
}
