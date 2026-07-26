package androidx.emoji2.text;

import androidx.emoji2.text.MetadataRepo;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class EmojiProcessor$ProcessorSm {
    public int mCurrentDepth;
    public MetadataRepo.Node mCurrentNode;
    public MetadataRepo.Node mFlushNode;
    public int mLastCodepoint;
    public final MetadataRepo.Node mRootNode;
    public int mState = 1;

    public EmojiProcessor$ProcessorSm(MetadataRepo.Node node) {
        this.mRootNode = node;
        this.mCurrentNode = node;
    }

    public final void reset() {
        this.mState = 1;
        this.mCurrentNode = this.mRootNode;
        this.mCurrentDepth = 0;
    }

    public final boolean shouldUseEmojiPresentationStyleForSingleCodepoint() {
        MetadataItem metadataItem = this.mCurrentNode.mData.getMetadataItem();
        int __offset = metadataItem.__offset(6);
        if ((__offset == 0 || ((ByteBuffer) metadataItem.f9bb).get(__offset + metadataItem.bb_pos) == 0) && this.mLastCodepoint != 65039) {
            return false;
        }
        return true;
    }
}
