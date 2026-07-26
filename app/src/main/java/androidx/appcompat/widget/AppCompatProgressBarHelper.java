package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.drawable.WrappedDrawable;
import androidx.core.graphics.drawable.WrappedDrawableApi21;
import androidx.core.util.TimeUtils;
import androidx.core.widget.TextViewCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.viewsintegration.EmojiInputConnection;
import androidx.emoji2.viewsintegration.EmojiKeyListener;
import androidx.emoji2.viewsintegration.EmojiTextWatcher;
import androidx.viewpager2.widget.FakeDrag;
import com.android.billingclient.api.zzcl;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public class AppCompatProgressBarHelper {
    public static final int[] TINT_ATTRS = {16843067, 16843068};
    public final /* synthetic */ int $r8$classId = 2;
    public Object mSampleTile;
    public View mView;

    public /* synthetic */ AppCompatProgressBarHelper() {
    }

    public KeyListener getKeyListener(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        ((zzcl) ((FakeDrag) this.mSampleTile).mScrollEventAdapter).getClass();
        if (keyListener instanceof EmojiKeyListener) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        return new EmojiKeyListener(keyListener);
    }

    /* JADX WARN: Finally extract failed */
    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        switch (this.$r8$classId) {
            case 0:
                AbsSeekBar absSeekBar = (AbsSeekBar) this.mView;
                MatcherMatchResult obtainStyledAttributes = MatcherMatchResult.obtainStyledAttributes(absSeekBar.getContext(), attributeSet, TINT_ATTRS, i);
                Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
                if (drawableIfKnown != null) {
                    if (drawableIfKnown instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) drawableIfKnown;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i2 = 0; i2 < numberOfFrames; i2++) {
                            Drawable tileify = tileify(animationDrawable.getFrame(i2), true);
                            tileify.setLevel(10000);
                            animationDrawable2.addFrame(tileify, animationDrawable.getDuration(i2));
                        }
                        animationDrawable2.setLevel(10000);
                        drawableIfKnown = animationDrawable2;
                    }
                    absSeekBar.setIndeterminateDrawable(drawableIfKnown);
                }
                Drawable drawableIfKnown2 = obtainStyledAttributes.getDrawableIfKnown(1);
                if (drawableIfKnown2 != null) {
                    absSeekBar.setProgressDrawable(tileify(drawableIfKnown2, false));
                }
                obtainStyledAttributes.recycle();
                return;
            default:
                TypedArray obtainStyledAttributes2 = ((EditText) this.mView).getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i, 0);
                try {
                    boolean z = true;
                    if (obtainStyledAttributes2.hasValue(14)) {
                        z = obtainStyledAttributes2.getBoolean(14, true);
                    }
                    obtainStyledAttributes2.recycle();
                    setEnabled(z);
                    return;
                } catch (Throwable th) {
                    obtainStyledAttributes2.recycle();
                    throw th;
                }
        }
    }

    public EmojiInputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo) {
        FakeDrag fakeDrag = (FakeDrag) this.mSampleTile;
        if (inputConnection == null) {
            fakeDrag.getClass();
            inputConnection = null;
        } else {
            zzcl zzclVar = (zzcl) fakeDrag.mScrollEventAdapter;
            zzclVar.getClass();
            if (!(inputConnection instanceof EmojiInputConnection)) {
                inputConnection = new EmojiInputConnection((EditText) zzclVar.zzb, inputConnection, editorInfo);
            }
        }
        return (EmojiInputConnection) inputConnection;
    }

    public void setEnabled(boolean z) {
        EmojiTextWatcher emojiTextWatcher = (EmojiTextWatcher) ((zzcl) ((FakeDrag) this.mSampleTile).mScrollEventAdapter).zzc;
        if (emojiTextWatcher.mEnabled != z) {
            if (emojiTextWatcher.mInitCallback != null) {
                EmojiCompat emojiCompat = EmojiCompat.get();
                SwitchCompat.EmojiCompatInitCallback emojiCompatInitCallback = emojiTextWatcher.mInitCallback;
                emojiCompat.getClass();
                TimeUtils.checkNotNull(emojiCompatInitCallback, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = emojiCompat.mInitLock;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    emojiCompat.mInitCallbacks.remove(emojiCompatInitCallback);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            emojiTextWatcher.mEnabled = z;
            if (z) {
                EmojiTextWatcher.processTextOnEnablingEvent(emojiTextWatcher.mEditText, EmojiCompat.get().getLoadState());
            }
        }
    }

    public Drawable tileify(Drawable drawable, boolean z) {
        boolean z2;
        if (drawable instanceof WrappedDrawable) {
            WrappedDrawableApi21 wrappedDrawableApi21 = (WrappedDrawableApi21) ((WrappedDrawable) drawable);
            Drawable drawable2 = wrappedDrawableApi21.mDrawable;
            if (drawable2 != null) {
                wrappedDrawableApi21.setWrappedDrawable(tileify(drawable2, z));
                return drawable;
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i = 0; i < numberOfLayers; i++) {
                int id = layerDrawable.getId(i);
                Drawable drawable3 = layerDrawable.getDrawable(i);
                if (id == 16908301 || id == 16908303) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                drawableArr[i] = tileify(drawable3, z2);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable2.setId(i2, layerDrawable.getId(i2));
                if (Build.VERSION.SDK_INT >= 23) {
                    TextViewCompat.transferLayerProperties(layerDrawable, layerDrawable2, i2);
                }
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (((Bitmap) this.mSampleTile) == null) {
                this.mSampleTile = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            if (z) {
                return new ClipDrawable(shapeDrawable, 3, 1);
            }
            return shapeDrawable;
        }
        return drawable;
    }

    public AppCompatProgressBarHelper(AbsSeekBar absSeekBar) {
        this.mView = absSeekBar;
    }

    public AppCompatProgressBarHelper(EditText editText) {
        this.mView = editText;
        this.mSampleTile = new FakeDrag(editText);
    }
}
