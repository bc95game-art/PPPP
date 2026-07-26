package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.ReplacementSpan;
import androidx.core.util.TimeUtils;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class TypefaceEmojiSpan extends ReplacementSpan {
    public final TypefaceEmojiRasterizer mRasterizer;
    public TextPaint mWorkingPaint;
    public final Paint.FontMetricsInt mTmpFontMetrics = new Paint.FontMetricsInt();
    public short mWidth = -1;
    public float mRatio = 1.0f;

    public TypefaceEmojiSpan(TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        TimeUtils.checkNotNull(typefaceEmojiRasterizer, "rasterizer cannot be null");
        this.mRasterizer = typefaceEmojiRasterizer;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        TextPaint textPaint = null;
        if (charSequence instanceof Spanned) {
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i, i2, CharacterStyle.class);
            if (characterStyleArr.length != 0) {
                if (!(characterStyleArr.length == 1 && characterStyleArr[0] == this)) {
                    TextPaint textPaint2 = this.mWorkingPaint;
                    if (textPaint2 == null) {
                        textPaint2 = new TextPaint();
                        this.mWorkingPaint = textPaint2;
                    }
                    textPaint = textPaint2;
                    textPaint.set(paint);
                    for (CharacterStyle characterStyle : characterStyleArr) {
                        characterStyle.updateDrawState(textPaint);
                    }
                }
            }
            if (paint instanceof TextPaint) {
                textPaint = (TextPaint) paint;
            }
        } else if (paint instanceof TextPaint) {
            textPaint = (TextPaint) paint;
        }
        TextPaint textPaint3 = textPaint;
        if (!(textPaint3 == null || textPaint3.bgColor == 0)) {
            int color = textPaint3.getColor();
            Paint.Style style = textPaint3.getStyle();
            textPaint3.setColor(textPaint3.bgColor);
            textPaint3.setStyle(Paint.Style.FILL);
            canvas.drawRect(f, i3, f + this.mWidth, i5, textPaint3);
            textPaint3.setStyle(style);
            textPaint3.setColor(color);
        }
        EmojiCompat.get().getClass();
        float f2 = i4;
        Paint paint2 = textPaint3;
        if (textPaint3 == null) {
            paint2 = paint;
        }
        TypefaceEmojiRasterizer typefaceEmojiRasterizer = this.mRasterizer;
        MetadataRepo metadataRepo = typefaceEmojiRasterizer.mMetadataRepo;
        Typeface typeface = paint2.getTypeface();
        paint2.setTypeface((Typeface) metadataRepo.mTypeface);
        canvas.drawText((char[]) metadataRepo.mEmojiCharArray, typefaceEmojiRasterizer.mIndex * 2, 2, f, f2, paint2);
        paint2.setTypeface(typeface);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        short s;
        Paint.FontMetricsInt fontMetricsInt2 = this.mTmpFontMetrics;
        paint.getFontMetricsInt(fontMetricsInt2);
        float abs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        TypefaceEmojiRasterizer typefaceEmojiRasterizer = this.mRasterizer;
        MetadataItem metadataItem = typefaceEmojiRasterizer.getMetadataItem();
        int __offset = metadataItem.__offset(14);
        short s2 = 0;
        if (__offset != 0) {
            s = ((ByteBuffer) metadataItem.bb).getShort(__offset + metadataItem.bb_pos);
        } else {
            s = 0;
        }
        this.mRatio = abs / s;
        MetadataItem metadataItem2 = typefaceEmojiRasterizer.getMetadataItem();
        int __offset2 = metadataItem2.__offset(14);
        if (__offset2 != 0) {
            ((ByteBuffer) metadataItem2.bb).getShort(__offset2 + metadataItem2.bb_pos);
        }
        MetadataItem metadataItem3 = typefaceEmojiRasterizer.getMetadataItem();
        int __offset3 = metadataItem3.__offset(12);
        if (__offset3 != 0) {
            s2 = ((ByteBuffer) metadataItem3.bb).getShort(__offset3 + metadataItem3.bb_pos);
        }
        short s3 = (short) (s2 * this.mRatio);
        this.mWidth = s3;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s3;
    }
}
