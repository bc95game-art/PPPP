package com.google.firebase.encoders.proto;

import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder$$ExternalSyntheticLambda0;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import p004j$.util.DesugarCollections;
/* loaded from: classes.dex */
public final class ProtobufDataEncoderContext implements ObjectEncoderContext {
    public static final FieldDescriptor MAP_KEY_DESC;
    public static final FieldDescriptor MAP_VALUE_DESC;
    public final ObjectEncoder fallbackEncoder;
    public final HashMap objectEncoders;
    public OutputStream output;
    public final ProtobufValueEncoderContext valueEncoderContext = new ProtobufValueEncoderContext(this);
    public final HashMap valueEncoders;
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final JsonDataEncoderBuilder$$ExternalSyntheticLambda0 DEFAULT_MAP_ENCODER = new JsonDataEncoderBuilder$$ExternalSyntheticLambda0(1);

    static {
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = new AtProtobuf$ProtobufImpl(1);
        HashMap hashMap = new HashMap();
        hashMap.put(Protobuf.class, atProtobuf$ProtobufImpl);
        MAP_KEY_DESC = new FieldDescriptor("key", DesugarCollections.unmodifiableMap(new HashMap(hashMap)));
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl2 = new AtProtobuf$ProtobufImpl(2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(Protobuf.class, atProtobuf$ProtobufImpl2);
        MAP_VALUE_DESC = new FieldDescriptor("value", DesugarCollections.unmodifiableMap(new HashMap(hashMap2)));
    }

    public ProtobufDataEncoderContext(ByteArrayOutputStream byteArrayOutputStream, HashMap hashMap, HashMap hashMap2, ObjectEncoder objectEncoder) {
        this.output = byteArrayOutputStream;
        this.objectEncoders = hashMap;
        this.valueEncoders = hashMap2;
        this.fallbackEncoder = objectEncoder;
    }

    public static int getTag(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) ((Annotation) fieldDescriptor.properties.get(Protobuf.class));
        if (protobuf != null) {
            return ((AtProtobuf$ProtobufImpl) protobuf).tag;
        }
        throw new RuntimeException("Field has no @Protobuf config");
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) {
        add(fieldDescriptor, obj, true);
        return this;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.OutputStream, com.google.firebase.encoders.proto.LengthCountingOutputStream] */
    public final void doEncode(ObjectEncoder objectEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z) {
        ?? outputStream = new OutputStream();
        outputStream.length = 0L;
        try {
            OutputStream outputStream2 = this.output;
            this.output = outputStream;
            objectEncoder.encode(obj, this);
            this.output = outputStream2;
            long j = outputStream.length;
            outputStream.close();
            if (!z || j != 0) {
                writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
                writeVarInt64(j);
                objectEncoder.encode(obj, this);
            }
        } catch (Throwable th) {
            try {
                outputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void writeVarInt32(int i) {
        while ((i & (-128)) != 0) {
            this.output.write((i & 127) | 128);
            i >>>= 7;
        }
        this.output.write(i & 127);
    }

    public final void writeVarInt64(long j) {
        while (((-128) & j) != 0) {
            this.output.write((((int) j) & 127) | 128);
            j >>>= 7;
        }
        this.output.write(((int) j) & 127);
    }

    public final void add(FieldDescriptor fieldDescriptor, Object obj, boolean z) {
        if (obj != null) {
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                if (!z || charSequence.length() != 0) {
                    writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
                    byte[] bytes = charSequence.toString().getBytes(UTF_8);
                    writeVarInt32(bytes.length);
                    this.output.write(bytes);
                }
            } else if (obj instanceof Collection) {
                for (Object obj2 : (Collection) obj) {
                    add(fieldDescriptor, obj2, false);
                }
            } else if (obj instanceof Map) {
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    doEncode(DEFAULT_MAP_ENCODER, fieldDescriptor, entry, false);
                }
            } else if (obj instanceof Double) {
                double doubleValue = ((Double) obj).doubleValue();
                if (!z || doubleValue != 0.0d) {
                    writeVarInt32((getTag(fieldDescriptor) << 3) | 1);
                    this.output.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(doubleValue).array());
                }
            } else if (obj instanceof Float) {
                float floatValue = ((Float) obj).floatValue();
                if (!z || floatValue != 0.0f) {
                    writeVarInt32((getTag(fieldDescriptor) << 3) | 5);
                    this.output.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(floatValue).array());
                }
            } else if (obj instanceof Number) {
                long longValue = ((Number) obj).longValue();
                if (!z || longValue != 0) {
                    Protobuf protobuf = (Protobuf) ((Annotation) fieldDescriptor.properties.get(Protobuf.class));
                    if (protobuf != null) {
                        writeVarInt32(((AtProtobuf$ProtobufImpl) protobuf).tag << 3);
                        writeVarInt64(longValue);
                        return;
                    }
                    throw new RuntimeException("Field has no @Protobuf config");
                }
            } else if (obj instanceof Boolean) {
                add(fieldDescriptor, ((Boolean) obj).booleanValue() ? 1 : 0, z);
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                if (!z || bArr.length != 0) {
                    writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
                    writeVarInt32(bArr.length);
                    this.output.write(bArr);
                }
            } else {
                ObjectEncoder objectEncoder = (ObjectEncoder) this.objectEncoders.get(obj.getClass());
                if (objectEncoder != null) {
                    doEncode(objectEncoder, fieldDescriptor, obj, z);
                    return;
                }
                ValueEncoder valueEncoder = (ValueEncoder) this.valueEncoders.get(obj.getClass());
                if (valueEncoder != null) {
                    ProtobufValueEncoderContext protobufValueEncoderContext = this.valueEncoderContext;
                    protobufValueEncoderContext.encoded = false;
                    protobufValueEncoderContext.field = fieldDescriptor;
                    protobufValueEncoderContext.skipDefault = z;
                    valueEncoder.encode(obj, protobufValueEncoderContext);
                } else if (obj instanceof LogEventDropped.Reason) {
                    add(fieldDescriptor, ((LogEventDropped.Reason) obj).number_, true);
                } else if (obj instanceof Enum) {
                    add(fieldDescriptor, ((Enum) obj).ordinal(), true);
                } else {
                    doEncode(this.fallbackEncoder, fieldDescriptor, obj, z);
                }
            }
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) {
        if (j == 0) {
            return this;
        }
        Protobuf protobuf = (Protobuf) ((Annotation) fieldDescriptor.properties.get(Protobuf.class));
        if (protobuf != null) {
            writeVarInt32(((AtProtobuf$ProtobufImpl) protobuf).tag << 3);
            writeVarInt64(j);
            return this;
        }
        throw new RuntimeException("Field has no @Protobuf config");
    }

    public final void add(FieldDescriptor fieldDescriptor, int i, boolean z) {
        if (!z || i != 0) {
            Protobuf protobuf = (Protobuf) ((Annotation) fieldDescriptor.properties.get(Protobuf.class));
            if (protobuf != null) {
                writeVarInt32(((AtProtobuf$ProtobufImpl) protobuf).tag << 3);
                writeVarInt32(i);
                return;
            }
            throw new RuntimeException("Field has no @Protobuf config");
        }
    }
}
