package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.ProtobufDataEncoderContext;
import java.util.Map;
/* loaded from: classes.dex */
public final /* synthetic */ class JsonDataEncoderBuilder$$ExternalSyntheticLambda0 implements ObjectEncoder {
    public final /* synthetic */ int $r8$classId;

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                throw new RuntimeException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
                objectEncoderContext.add(ProtobufDataEncoderContext.MAP_KEY_DESC, entry.getKey());
                objectEncoderContext.add(ProtobufDataEncoderContext.MAP_VALUE_DESC, entry.getValue());
                return;
            default:
                throw new RuntimeException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }
    }
}
