package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
/* loaded from: classes.dex */
public final class AutoBatchedLogRequestEncoder$LogEventEncoder implements ObjectEncoder {
    public static final AutoBatchedLogRequestEncoder$LogEventEncoder INSTANCE = new Object();
    public static final FieldDescriptor EVENTTIMEMS_DESCRIPTOR = FieldDescriptor.m566of("eventTimeMs");
    public static final FieldDescriptor EVENTCODE_DESCRIPTOR = FieldDescriptor.m566of("eventCode");
    public static final FieldDescriptor EVENTUPTIMEMS_DESCRIPTOR = FieldDescriptor.m566of("eventUptimeMs");
    public static final FieldDescriptor SOURCEEXTENSION_DESCRIPTOR = FieldDescriptor.m566of("sourceExtension");
    public static final FieldDescriptor SOURCEEXTENSIONJSONPROTO3_DESCRIPTOR = FieldDescriptor.m566of("sourceExtensionJsonProto3");
    public static final FieldDescriptor TIMEZONEOFFSETSECONDS_DESCRIPTOR = FieldDescriptor.m566of("timezoneOffsetSeconds");
    public static final FieldDescriptor NETWORKCONNECTIONINFO_DESCRIPTOR = FieldDescriptor.m566of("networkConnectionInfo");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        AutoValue_LogEvent autoValue_LogEvent = (AutoValue_LogEvent) ((LogEvent) obj);
        objectEncoderContext.add(EVENTTIMEMS_DESCRIPTOR, autoValue_LogEvent.eventTimeMs);
        objectEncoderContext.add(EVENTCODE_DESCRIPTOR, autoValue_LogEvent.eventCode);
        objectEncoderContext.add(EVENTUPTIMEMS_DESCRIPTOR, autoValue_LogEvent.eventUptimeMs);
        objectEncoderContext.add(SOURCEEXTENSION_DESCRIPTOR, autoValue_LogEvent.sourceExtension);
        objectEncoderContext.add(SOURCEEXTENSIONJSONPROTO3_DESCRIPTOR, autoValue_LogEvent.sourceExtensionJsonProto3);
        objectEncoderContext.add(TIMEZONEOFFSETSECONDS_DESCRIPTOR, autoValue_LogEvent.timezoneOffsetSeconds);
        objectEncoderContext.add(NETWORKCONNECTIONINFO_DESCRIPTOR, autoValue_LogEvent.networkConnectionInfo);
    }
}
