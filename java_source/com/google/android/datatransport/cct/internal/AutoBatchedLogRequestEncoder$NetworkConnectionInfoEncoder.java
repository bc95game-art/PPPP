package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
/* loaded from: classes.dex */
public final class AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder implements ObjectEncoder {
    public static final AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder INSTANCE = new Object();
    public static final FieldDescriptor NETWORKTYPE_DESCRIPTOR = FieldDescriptor.m566of("networkType");
    public static final FieldDescriptor MOBILESUBTYPE_DESCRIPTOR = FieldDescriptor.m566of("mobileSubtype");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        AutoValue_NetworkConnectionInfo autoValue_NetworkConnectionInfo = (AutoValue_NetworkConnectionInfo) ((NetworkConnectionInfo) obj);
        objectEncoderContext.add(NETWORKTYPE_DESCRIPTOR, autoValue_NetworkConnectionInfo.networkType);
        objectEncoderContext.add(MOBILESUBTYPE_DESCRIPTOR, autoValue_NetworkConnectionInfo.mobileSubtype);
    }
}
