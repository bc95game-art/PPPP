package com.maxmind.p003db;

import androidx.lifecycle.ViewModelProvider;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
import p004j$.util.concurrent.ConcurrentHashMap;
/* renamed from: com.maxmind.db.Reader */
/* loaded from: classes.dex */
public final class Reader implements Closeable {
    private static final int DATA_SECTION_SEPARATOR_SIZE = 16;
    private static final byte[] METADATA_START_MARKER = {-85, -51, -17, 77, 97, 120, 77, 105, 110, 100, 46, 99, 111, 109};
    private final AtomicReference<BufferHolder> bufferHolderReference;
    private final NodeCache cache;
    private final ConcurrentHashMap<Class, CachedConstructor> constructors;
    private final int ipV4Start;
    private final Metadata metadata;

    /* renamed from: com.maxmind.db.Reader$FileMode */
    /* loaded from: classes.dex */
    public enum FileMode {
        MEMORY_MAPPED,
        MEMORY
    }

    public Reader(File file) {
        this(file, NoCache.getInstance());
    }

    private int findIpV4StartNode(ByteBuffer byteBuffer) {
        if (this.metadata.getIpVersion() == 4) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < 96 && i < this.metadata.getNodeCount(); i2++) {
            i = readNode(byteBuffer, i, 0);
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int findMetadataStart(ByteBuffer byteBuffer, String str) {
        int capacity = byteBuffer.capacity();
        int i = 0;
        while (i < (capacity - METADATA_START_MARKER.length) + 1) {
            int i2 = 0;
            while (true) {
                byte[] bArr = METADATA_START_MARKER;
                if (i2 >= bArr.length) {
                    return capacity - i;
                }
                if (byteBuffer.get(((capacity - i) - i2) - 1) != bArr[(bArr.length - i2) - 1]) {
                    break;
                }
                i2++;
            }
        }
        throw new InvalidDatabaseException(ViewModelProvider.Factory.CC.m595m("Could not find a MaxMind DB metadata marker in this file (", str, "). Is this a valid MaxMind DB file?"));
    }

    private BufferHolder getBufferHolder() {
        BufferHolder bufferHolder = this.bufferHolderReference.get();
        if (bufferHolder != null) {
            return bufferHolder;
        }
        throw new ClosedDatabaseException();
    }

    private int readNode(ByteBuffer byteBuffer, int i, int i2) {
        int i3;
        int nodeByteSize = this.metadata.getNodeByteSize() * i;
        int recordSize = this.metadata.getRecordSize();
        if (recordSize == 24) {
            byteBuffer.position((i2 * 3) + nodeByteSize);
            return Decoder.decodeInteger(byteBuffer, 0, 3);
        } else if (recordSize == 28) {
            byte b = byteBuffer.get(nodeByteSize + 3);
            if (i2 == 0) {
                i3 = (b & 240) >>> 4;
            } else {
                i3 = b & 15;
            }
            byteBuffer.position((i2 * 4) + nodeByteSize);
            return Decoder.decodeInteger(byteBuffer, i3, 3);
        } else if (recordSize == 32) {
            byteBuffer.position((i2 * 4) + nodeByteSize);
            return Decoder.decodeInteger(byteBuffer, 0, 4);
        } else {
            throw new InvalidDatabaseException("Unknown record size: " + this.metadata.getRecordSize());
        }
    }

    private <T> T resolveDataPointer(ByteBuffer byteBuffer, int i, Class<T> cls) {
        int searchTreeSize = this.metadata.getSearchTreeSize() + (i - this.metadata.getNodeCount());
        if (searchTreeSize < byteBuffer.capacity()) {
            return (T) new Decoder(this.cache, byteBuffer, this.metadata.getSearchTreeSize() + 16, this.constructors).decode(searchTreeSize, cls);
        }
        throw new InvalidDatabaseException("The MaxMind DB file's search tree is corrupt: contains pointer larger than the database.");
    }

    private int startNode(int i) {
        if (this.metadata.getIpVersion() == 6 && i == 32) {
            return this.ipV4Start;
        }
        return 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.bufferHolderReference.set(null);
    }

    public <T> T get(InetAddress inetAddress, Class<T> cls) {
        return getRecord(inetAddress, cls).getData();
    }

    public Metadata getMetadata() {
        return this.metadata;
    }

    public <T> DatabaseRecord<T> getRecord(InetAddress inetAddress, Class<T> cls) {
        Object obj;
        ByteBuffer byteBuffer = getBufferHolder().get();
        byte[] address = inetAddress.getAddress();
        int length = address.length * 8;
        int startNode = startNode(length);
        int nodeCount = this.metadata.getNodeCount();
        int i = 0;
        while (i < length && startNode < nodeCount) {
            startNode = readNode(byteBuffer, startNode, ((address[i / 8] & 255) >> (7 - (i % 8))) & 1);
            i++;
        }
        if (startNode > nodeCount) {
            obj = resolveDataPointer(byteBuffer, startNode, cls);
        } else {
            obj = null;
        }
        return new DatabaseRecord<>(obj, inetAddress, i);
    }

    public Reader(File file, NodeCache nodeCache) {
        this(file, FileMode.MEMORY_MAPPED, nodeCache);
    }

    public Reader(InputStream inputStream) {
        this(inputStream, NoCache.getInstance());
    }

    public Reader(InputStream inputStream, NodeCache nodeCache) {
        this(new BufferHolder(inputStream), "<InputStream>", nodeCache);
    }

    public Reader(File file, FileMode fileMode) {
        this(file, fileMode, NoCache.getInstance());
    }

    public Reader(File file, FileMode fileMode, NodeCache nodeCache) {
        this(new BufferHolder(file, fileMode), file.getName(), nodeCache);
    }

    private Reader(BufferHolder bufferHolder, String str, NodeCache nodeCache) {
        this.bufferHolderReference = new AtomicReference<>(bufferHolder);
        if (nodeCache != null) {
            this.cache = nodeCache;
            ByteBuffer byteBuffer = bufferHolder.get();
            int findMetadataStart = findMetadataStart(byteBuffer, str);
            this.metadata = (Metadata) new Decoder(nodeCache, byteBuffer, findMetadataStart).decode(findMetadataStart, Metadata.class);
            this.ipV4Start = findIpV4StartNode(byteBuffer);
            this.constructors = new ConcurrentHashMap<>();
            return;
        }
        throw new NullPointerException("Cache cannot be null");
    }
}
