package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.animation.AnimationUtils;
import j$.util.Objects;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public final class ContentInfoCompat {
    public final Compat mCompat;

    /* loaded from: classes.dex */
    public interface BuilderCompat {
        ContentInfoCompat build();

        void setExtras(Bundle bundle);

        void setFlags(int i);

        void setLinkUri(Uri uri);
    }

    /* loaded from: classes.dex */
    public interface Compat {
        ClipData getClip();

        int getFlags();

        int getSource();

        ContentInfo getWrapped();
    }

    /* loaded from: classes.dex */
    public final class CompatImpl implements BuilderCompat, Compat {
        public final /* synthetic */ int $r8$classId;
        public Object mClip;
        public Cloneable mExtras;
        public int mFlags;
        public Object mLinkUri;
        public int mSource;

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData getClip() {
            return (ClipData) this.mClip;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return this.mFlags;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.mSource;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo getWrapped() {
            return null;
        }

        public void onProgress(WindowInsetsCompat windowInsetsCompat, List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) it.next();
                if ((windowInsetsAnimationCompat.mImpl.getTypeMask() & 8) != 0) {
                    ((View) this.mLinkUri).setTranslationY(AnimationUtils.lerp(this.mFlags, windowInsetsAnimationCompat.mImpl.getInterpolatedFraction(), 0));
                    return;
                }
            }
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle bundle) {
            this.mExtras = bundle;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int i) {
            this.mFlags = i;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(Uri uri) {
            this.mLinkUri = uri;
        }

        public String toString() {
            String str;
            String str2;
            String str3;
            switch (this.$r8$classId) {
                case 0:
                    Uri uri = (Uri) this.mLinkUri;
                    StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                    sb.append(((ClipData) this.mClip).getDescription());
                    sb.append(", source=");
                    int i = this.mSource;
                    if (i == 0) {
                        str = "SOURCE_APP";
                    } else if (i == 1) {
                        str = "SOURCE_CLIPBOARD";
                    } else if (i == 2) {
                        str = "SOURCE_INPUT_METHOD";
                    } else if (i == 3) {
                        str = "SOURCE_DRAG_AND_DROP";
                    } else if (i == 4) {
                        str = "SOURCE_AUTOFILL";
                    } else if (i != 5) {
                        str = String.valueOf(i);
                    } else {
                        str = "SOURCE_PROCESS_TEXT";
                    }
                    sb.append(str);
                    sb.append(", flags=");
                    int i2 = this.mFlags;
                    if ((i2 & 1) != 0) {
                        str2 = "FLAG_CONVERT_TO_PLAIN_TEXT";
                    } else {
                        str2 = String.valueOf(i2);
                    }
                    sb.append(str2);
                    String str4 = "";
                    if (uri == null) {
                        str3 = str4;
                    } else {
                        str3 = ", hasLinkUri(" + uri.toString().length() + ")";
                    }
                    sb.append(str3);
                    if (((Bundle) this.mExtras) != null) {
                        str4 = ", hasExtras";
                    }
                    return ViewModelProvider.Factory.CC.m(sb, str4, "}");
                default:
                    return super.toString();
            }
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [int[], java.lang.Cloneable] */
        public CompatImpl(View view) {
            this.$r8$classId = 2;
            this.mExtras = new int[2];
            this.mLinkUri = view;
        }

        public CompatImpl(CompatImpl compatImpl) {
            this.$r8$classId = 0;
            ClipData clipData = (ClipData) compatImpl.mClip;
            clipData.getClass();
            this.mClip = clipData;
            int i = compatImpl.mSource;
            if (i < 0) {
                Locale locale = Locale.US;
                throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
            } else if (i <= 5) {
                this.mSource = i;
                int i2 = compatImpl.mFlags;
                if ((i2 & 1) == i2) {
                    this.mFlags = i2;
                    this.mLinkUri = (Uri) compatImpl.mLinkUri;
                    this.mExtras = (Bundle) compatImpl.mExtras;
                    return;
                }
                throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i2) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
            } else {
                Locale locale2 = Locale.US;
                throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
            }
        }
    }

    public ContentInfoCompat(Compat compat) {
        this.mCompat = compat;
    }

    public final ContentInfo toContentInfo() {
        ContentInfo wrapped = this.mCompat.getWrapped();
        Objects.requireNonNull(wrapped);
        return wrapped;
    }

    public final String toString() {
        return this.mCompat.toString();
    }

    /* loaded from: classes.dex */
    public final class Compat31Impl implements BuilderCompat, Compat {
        public final /* synthetic */ int $r8$classId = 1;
        public final Object mWrapped;

        public Compat31Impl(ContentInfo contentInfo) {
            contentInfo.getClass();
            this.mWrapped = contentInfo;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new Compat31Impl(((ContentInfo.Builder) this.mWrapped).build()));
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData getClip() {
            return ((ContentInfo) this.mWrapped).getClip();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return ((ContentInfo) this.mWrapped).getFlags();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return ((ContentInfo) this.mWrapped).getSource();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo getWrapped() {
            return (ContentInfo) this.mWrapped;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle bundle) {
            ((ContentInfo.Builder) this.mWrapped).setExtras(bundle);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int i) {
            ((ContentInfo.Builder) this.mWrapped).setFlags(i);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(Uri uri) {
            ((ContentInfo.Builder) this.mWrapped).setLinkUri(uri);
        }

        public String toString() {
            switch (this.$r8$classId) {
                case 0:
                    return "ContentInfoCompat{" + ((ContentInfo) this.mWrapped) + "}";
                default:
                    return super.toString();
            }
        }

        public Compat31Impl(ClipData clipData, int i) {
            this.mWrapped = ContentInfoCompat$BuilderCompat31Impl$$ExternalSyntheticApiModelOutline0.m(clipData, i);
        }
    }
}
