package com.maxmind.p003db;

import com.maxmind.p003db.Reader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/* renamed from: com.maxmind.db.BufferHolder */
/* loaded from: classes.dex */
final class BufferHolder {
    private final ByteBuffer buffer;

    public BufferHolder(File file, Reader.FileMode fileMode) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            FileChannel channel = randomAccessFile.getChannel();
            if (fileMode == Reader.FileMode.MEMORY) {
                ByteBuffer wrap = ByteBuffer.wrap(new byte[(int) channel.size()]);
                if (channel.read(wrap) == wrap.capacity()) {
                    this.buffer = wrap.asReadOnlyBuffer();
                } else {
                    throw new IOException("Unable to read " + file.getName() + " into memory. Unexpected end of stream.");
                }
            } else {
                this.buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).asReadOnlyBuffer();
            }
            if (channel != null) {
                channel.close();
            }
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public ByteBuffer get() {
        return this.buffer.duplicate();
    }

    public BufferHolder(InputStream inputStream) {
        if (inputStream != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (-1 != read) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    this.buffer = ByteBuffer.wrap(byteArrayOutputStream.toByteArray()).asReadOnlyBuffer();
                    return;
                }
            }
        } else {
            throw new NullPointerException("Unable to use a NULL InputStream");
        }
    }
}
