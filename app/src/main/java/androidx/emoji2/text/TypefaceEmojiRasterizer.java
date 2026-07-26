package androidx.emoji2.text;

import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.emoji2.text.flatbuffer.MetadataList;
import androidx.emoji2.text.flatbuffer.Table;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class TypefaceEmojiRasterizer {
    public static final ThreadLocal sMetadataItem = new ThreadLocal();
    public volatile int mCache = 0;
    public final int mIndex;
    public final MetadataRepo mMetadataRepo;

    public TypefaceEmojiRasterizer(MetadataRepo metadataRepo, int i) {
        this.mMetadataRepo = metadataRepo;
        this.mIndex = i;
    }

    public final int getCodepointAt(int i) {
        MetadataItem metadataItem = getMetadataItem();
        int __offset = metadataItem.__offset(16);
        if (__offset == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) metadataItem.f9bb;
        int i2 = __offset + metadataItem.bb_pos;
        return byteBuffer.getInt((i * 4) + byteBuffer.getInt(i2) + i2 + 4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.emoji2.text.flatbuffer.Table, java.lang.Object] */
    public final MetadataItem getMetadataItem() {
        ThreadLocal threadLocal = sMetadataItem;
        MetadataItem metadataItem = (MetadataItem) threadLocal.get();
        MetadataItem metadataItem2 = metadataItem;
        if (metadataItem == null) {
            ?? table = new Table();
            threadLocal.set(table);
            metadataItem2 = table;
        }
        MetadataList metadataList = (MetadataList) this.mMetadataRepo.mMetadataList;
        int __offset = metadataList.__offset(6);
        if (__offset != 0) {
            int i = __offset + metadataList.bb_pos;
            int i2 = (this.mIndex * 4) + ((ByteBuffer) metadataList.f9bb).getInt(i) + i + 4;
            int i3 = ((ByteBuffer) metadataList.f9bb).getInt(i2) + i2;
            ByteBuffer byteBuffer = (ByteBuffer) metadataList.f9bb;
            metadataItem2.f9bb = byteBuffer;
            if (byteBuffer != null) {
                metadataItem2.bb_pos = i3;
                int i4 = i3 - byteBuffer.getInt(i3);
                metadataItem2.vtable_start = i4;
                metadataItem2.vtable_size = ((ByteBuffer) metadataItem2.f9bb).getShort(i4);
                return metadataItem2;
            }
            metadataItem2.bb_pos = 0;
            metadataItem2.vtable_start = 0;
            metadataItem2.vtable_size = 0;
        }
        return metadataItem2;
    }

    public final String toString() {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        MetadataItem metadataItem = getMetadataItem();
        int __offset = metadataItem.__offset(4);
        if (__offset != 0) {
            i = ((ByteBuffer) metadataItem.f9bb).getInt(__offset + metadataItem.bb_pos);
        } else {
            i = 0;
        }
        sb.append(Integer.toHexString(i));
        sb.append(", codepoints:");
        MetadataItem metadataItem2 = getMetadataItem();
        int __offset2 = metadataItem2.__offset(16);
        if (__offset2 != 0) {
            int i3 = __offset2 + metadataItem2.bb_pos;
            i2 = ((ByteBuffer) metadataItem2.f9bb).getInt(((ByteBuffer) metadataItem2.f9bb).getInt(i3) + i3);
        } else {
            i2 = 0;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            sb.append(Integer.toHexString(getCodepointAt(i4)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
