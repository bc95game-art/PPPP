package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
/* loaded from: classes.dex */
public final class AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder implements ObjectEncoder {
    public static final AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder INSTANCE = new Object();
    public static final FieldDescriptor LOGREQUEST_DESCRIPTOR = FieldDescriptor.of("logRequest");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ((ObjectEncoderContext) obj2).add(LOGREQUEST_DESCRIPTOR, ((AutoValue_BatchedLogRequest) ((BatchedLogRequest) obj)).logRequests);
    }
}
