package com.maxmind.db;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public final class Reader implements Closeable {
    private static final int DATA_SECTION_SEPARATOR_SIZE = 16;
    private static final byte[] METADATA_START_MARKER = {-85, -51, -17, 77, 97, 120, 77, 105, 110, 100, 46, 99, 111, 109};
    private final AtomicReference<BufferHolder> bufferHolderReference;
    private final NodeCache cache;
    private final ConcurrentHashMap<Class, CachedConstructor> constructors;
    private final int ipV4Start;
    private final Metadata metadata;

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
        To view partially-correct add '--show-bad-code' argument
    */
    private int findMetadataStart(java.nio.ByteBuffer r8, java.lang.String r9) {
        /*
            r7 = this;
            int r0 = r8.capacity()
            r1 = 0
            r2 = 0
        L6:
            byte[] r3 = com.maxmind.db.Reader.METADATA_START_MARKER
            int r3 = r3.length
            int r3 = r0 - r3
            int r3 = r3 + 1
            if (r2 >= r3) goto L2e
            r3 = 0
        L10:
            byte[] r4 = com.maxmind.db.Reader.METADATA_START_MARKER
            int r5 = r4.length
            if (r3 >= r5) goto L2c
            int r5 = r0 - r2
            int r5 = r5 - r3
            int r5 = r5 + (-1)
            byte r5 = r8.get(r5)
            int r6 = r4.length
            int r6 = r6 - r3
            int r6 = r6 + (-1)
            r4 = r4[r6]
            if (r5 == r4) goto L29
            int r2 = r2 + 1
            goto L6
        L29:
            int r3 = r3 + 1
            goto L10
        L2c:
            int r0 = r0 - r2
            return r0
        L2e:
            com.maxmind.db.InvalidDatabaseException r8 = new com.maxmind.db.InvalidDatabaseException
            java.lang.String r0 = "Could not find a MaxMind DB metadata marker in this file ("
            java.lang.String r1 = "). Is this a valid MaxMind DB file?"
            java.lang.String r9 = androidx.lifecycle.ViewModelProvider.Factory.CC.m(r0, r9, r1)
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.maxmind.db.Reader.findMetadataStart(java.nio.ByteBuffer, java.lang.String):int");
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
