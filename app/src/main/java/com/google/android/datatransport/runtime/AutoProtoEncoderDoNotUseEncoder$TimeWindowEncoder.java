package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import j$.util.DesugarCollections;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder$TimeWindowEncoder implements ObjectEncoder {
    public static final FieldDescriptor ENDMS_DESCRIPTOR;
    public static final AutoProtoEncoderDoNotUseEncoder$TimeWindowEncoder INSTANCE = new Object();
    public static final FieldDescriptor STARTMS_DESCRIPTOR;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.android.datatransport.runtime.AutoProtoEncoderDoNotUseEncoder$TimeWindowEncoder] */
    static {
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = new AtProtobuf$ProtobufImpl(1);
        HashMap hashMap = new HashMap();
        hashMap.put(Protobuf.class, atProtobuf$ProtobufImpl);
        STARTMS_DESCRIPTOR = new FieldDescriptor("startMs", DesugarCollections.unmodifiableMap(new HashMap(hashMap)));
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl2 = new AtProtobuf$ProtobufImpl(2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Protobuf.class, atProtobuf$ProtobufImpl2);
        ENDMS_DESCRIPTOR = new FieldDescriptor("endMs", DesugarCollections.unmodifiableMap(new HashMap(hashMap2)));
    }

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        TimeWindow timeWindow = (TimeWindow) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(STARTMS_DESCRIPTOR, timeWindow.start_ms_);
        objectEncoderContext.add(ENDMS_DESCRIPTOR, timeWindow.end_ms_);
    }
}
