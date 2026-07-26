package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.collection.ArraySet;
import androidx.core.provider.CallbackWithHandler$2;
import androidx.core.util.TimeUtils;
import androidx.navigation.Navigation;
import androidx.transition.ViewUtilsApi21;
import com.android.billingclient.api.zzcl;
import com.google.android.gms.internal.play_billing.zzc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class EmojiCompat {
    public static final Object INSTANCE_LOCK = new Object();
    public static volatile EmojiCompat sInstance;
    public final DefaultGlyphChecker mGlyphChecker;
    public final CompatInternal19 mHelper;
    public final ReentrantReadWriteLock mInitLock;
    public volatile int mLoadState;
    public final int mMetadataLoadStrategy;
    public final MetadataRepoLoader mMetadataLoader;
    public final Handler mMainHandler = new Handler(Looper.getMainLooper());
    public final ArraySet mInitCallbacks = new ArraySet(0);
    public final ViewUtilsApi21 mSpanFactory = new Object();

    /* loaded from: classes.dex */
    public final class CompatInternal19 {
        public final Object mEmojiCompat;
        public volatile Object mMetadataRepo;
        public volatile Object mProcessor;

        /* renamed from: androidx.emoji2.text.EmojiCompat$CompatInternal19$1 */
        /* loaded from: classes.dex */
        public final class C00551 extends Navigation {
            public C00551() {
            }

            @Override // androidx.navigation.Navigation
            public final void onFailed(Throwable th) {
                ((EmojiCompat) CompatInternal19.this.mEmojiCompat).onMetadataLoadFailed(th);
            }

            /* JADX WARN: Finally extract failed */
            @Override // androidx.navigation.Navigation
            public final void onLoaded(MetadataRepo metadataRepo) {
                Set<int[]> set;
                CompatInternal19 compatInternal19 = CompatInternal19.this;
                compatInternal19.mMetadataRepo = metadataRepo;
                MetadataRepo metadataRepo2 = (MetadataRepo) compatInternal19.mMetadataRepo;
                EmojiCompat emojiCompat = (EmojiCompat) compatInternal19.mEmojiCompat;
                ViewUtilsApi21 viewUtilsApi21 = emojiCompat.mSpanFactory;
                DefaultGlyphChecker defaultGlyphChecker = emojiCompat.mGlyphChecker;
                if (Build.VERSION.SDK_INT >= 34) {
                    set = EmojiExclusions$EmojiExclusions_Api34.getExclusions();
                } else {
                    set = Navigation.getExclusions();
                }
                compatInternal19.mProcessor = new MatcherMatchResult(metadataRepo2, viewUtilsApi21, defaultGlyphChecker, set);
                EmojiCompat emojiCompat2 = (EmojiCompat) compatInternal19.mEmojiCompat;
                emojiCompat2.getClass();
                ArrayList arrayList = new ArrayList();
                emojiCompat2.mInitLock.writeLock().lock();
                try {
                    emojiCompat2.mLoadState = 1;
                    arrayList.addAll(emojiCompat2.mInitCallbacks);
                    emojiCompat2.mInitCallbacks.clear();
                    emojiCompat2.mInitLock.writeLock().unlock();
                    emojiCompat2.mMainHandler.post(new CallbackWithHandler$2(arrayList, emojiCompat2.mLoadState, (Throwable) null));
                } catch (Throwable th) {
                    emojiCompat2.mInitLock.writeLock().unlock();
                    throw th;
                }
            }
        }

        public /* synthetic */ CompatInternal19(Object obj) {
            this.mEmojiCompat = obj;
        }

        public boolean zza() {
            try {
                Context context = (Context) this.mEmojiCompat;
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("com.google.android.play.billingclient.enableBillingOverridesTesting", false);
            } catch (Exception e) {
                zzc.zzo("BillingClient", "Unable to retrieve metadata value for enableBillingOverridesTesting.", e);
                return false;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface GlyphChecker {
    }

    /* loaded from: classes.dex */
    public interface MetadataRepoLoader {
        void load(Navigation navigation);
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    public EmojiCompat(FontRequestEmojiCompatConfig fontRequestEmojiCompatConfig) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mInitLock = reentrantReadWriteLock;
        this.mLoadState = 3;
        MetadataRepoLoader metadataRepoLoader = fontRequestEmojiCompatConfig.mMetadataLoader;
        this.mMetadataLoader = metadataRepoLoader;
        int i = fontRequestEmojiCompatConfig.mMetadataLoadStrategy;
        this.mMetadataLoadStrategy = i;
        this.mGlyphChecker = fontRequestEmojiCompatConfig.mGlyphChecker;
        CompatInternal19 compatInternal19 = new CompatInternal19(this);
        this.mHelper = compatInternal19;
        reentrantReadWriteLock.writeLock().lock();
        if (i == 0) {
            try {
                this.mLoadState = 0;
            } catch (Throwable th) {
                this.mInitLock.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (getLoadState() == 0) {
            try {
                metadataRepoLoader.load(new CompatInternal19.C00551());
            } catch (Throwable th2) {
                onMetadataLoadFailed(th2);
            }
        }
    }

    public static EmojiCompat get() {
        EmojiCompat emojiCompat;
        boolean z;
        synchronized (INSTANCE_LOCK) {
            try {
                emojiCompat = sInstance;
                if (emojiCompat != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return emojiCompat;
    }

    public final int getLoadState() {
        this.mInitLock.readLock().lock();
        try {
            return this.mLoadState;
        } finally {
            this.mInitLock.readLock().unlock();
        }
    }

    public final void load() {
        boolean z;
        if (this.mMetadataLoadStrategy == 1) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        } else if (getLoadState() != 1) {
            this.mInitLock.writeLock().lock();
            try {
                if (this.mLoadState != 0) {
                    this.mLoadState = 0;
                    this.mInitLock.writeLock().unlock();
                    CompatInternal19 compatInternal19 = this.mHelper;
                    EmojiCompat emojiCompat = (EmojiCompat) compatInternal19.mEmojiCompat;
                    try {
                        emojiCompat.mMetadataLoader.load(new CompatInternal19.C00551());
                    } catch (Throwable th) {
                        emojiCompat.onMetadataLoadFailed(th);
                    }
                }
            } finally {
                this.mInitLock.writeLock().unlock();
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void onMetadataLoadFailed(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.mInitLock.writeLock().lock();
        try {
            this.mLoadState = 2;
            arrayList.addAll(this.mInitCallbacks);
            this.mInitCallbacks.clear();
            this.mInitLock.writeLock().unlock();
            this.mMainHandler.post(new CallbackWithHandler$2(arrayList, this.mLoadState, th));
        } catch (Throwable th2) {
            this.mInitLock.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a2 A[Catch: all -> 0x0085, TryCatch #0 {all -> 0x0085, blocks: (B:31:0x005d, B:34:0x0062, B:36:0x0066, B:38:0x0073, B:44:0x0092, B:46:0x009c, B:48:0x009f, B:50:0x00a2, B:52:0x00b2, B:53:0x00b5), top: B:91:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0108  */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, androidx.emoji2.text.UnprecomputeTextOnModificationSpannable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CharSequence process(CharSequence charSequence, int i, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        Throwable th;
        CharSequence charSequence2;
        int i3;
        int i4;
        TypefaceEmojiSpan[] typefaceEmojiSpanArr;
        boolean z4 = true;
        if (getLoadState() == 1) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            throw new IllegalStateException("Not initialized yet");
        } else if (i < 0) {
            throw new IllegalArgumentException("start cannot be negative");
        } else if (i2 >= 0) {
            if (i <= i2) {
                z2 = true;
            } else {
                z2 = false;
            }
            TimeUtils.checkArgument("start should be <= than end", z2);
            UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable = null;
            unprecomputeTextOnModificationSpannable = null;
            if (charSequence == null) {
                return null;
            }
            if (i <= charSequence.length()) {
                z3 = true;
            } else {
                z3 = false;
            }
            TimeUtils.checkArgument("start should be < than charSequence length", z3);
            if (i2 > charSequence.length()) {
                z4 = false;
            }
            TimeUtils.checkArgument("end should be < than charSequence length", z4);
            if (charSequence.length() == 0 || i == i2) {
                return charSequence;
            }
            MatcherMatchResult matcherMatchResult = (MatcherMatchResult) this.mHelper.mProcessor;
            matcherMatchResult.getClass();
            boolean z5 = charSequence instanceof SpannableBuilder;
            if (z5) {
                ((SpannableBuilder) charSequence).blockWatchers();
            }
            try {
                if (!z5) {
                    try {
                        if (!(charSequence instanceof Spannable)) {
                            if ((charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(i - 1, i2 + 1, TypefaceEmojiSpan.class) <= i2) {
                                ?? obj = new Object();
                                obj.mSafeToWrite = false;
                                obj.mDelegate = new SpannableString(charSequence);
                                unprecomputeTextOnModificationSpannable = obj;
                            }
                            if (!(unprecomputeTextOnModificationSpannable == null || (typefaceEmojiSpanArr = (TypefaceEmojiSpan[]) unprecomputeTextOnModificationSpannable.mDelegate.getSpans(i, i2, TypefaceEmojiSpan.class)) == null || typefaceEmojiSpanArr.length <= 0)) {
                                for (TypefaceEmojiSpan typefaceEmojiSpan : typefaceEmojiSpanArr) {
                                    int spanStart = unprecomputeTextOnModificationSpannable.mDelegate.getSpanStart(typefaceEmojiSpan);
                                    int spanEnd = unprecomputeTextOnModificationSpannable.mDelegate.getSpanEnd(typefaceEmojiSpan);
                                    if (spanStart != i2) {
                                        unprecomputeTextOnModificationSpannable.removeSpan(typefaceEmojiSpan);
                                    }
                                    i = Math.min(spanStart, i);
                                    i2 = Math.max(spanEnd, i2);
                                }
                            }
                            i3 = i;
                            i4 = i2;
                            if (i3 != i4 || i3 >= charSequence.length()) {
                                charSequence2 = charSequence;
                                if (!z5) {
                                    return charSequence2;
                                }
                            } else {
                                try {
                                    charSequence2 = charSequence;
                                } catch (Throwable th2) {
                                    charSequence2 = charSequence;
                                    th = th2;
                                    if (z5) {
                                    }
                                    throw th;
                                }
                                try {
                                    UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable2 = (UnprecomputeTextOnModificationSpannable) matcherMatchResult.process(charSequence2, i3, i4, Integer.MAX_VALUE, false, new zzcl(unprecomputeTextOnModificationSpannable, 11, (ViewUtilsApi21) matcherMatchResult.matcher));
                                    if (unprecomputeTextOnModificationSpannable2 != null) {
                                        Spannable spannable = unprecomputeTextOnModificationSpannable2.mDelegate;
                                        if (z5) {
                                            ((SpannableBuilder) charSequence2).endBatchEdit();
                                        }
                                        return spannable;
                                    } else if (!z5) {
                                        return charSequence2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    th = th;
                                    if (z5) {
                                    }
                                    throw th;
                                }
                            }
                            ((SpannableBuilder) charSequence2).endBatchEdit();
                            return charSequence2;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        charSequence2 = charSequence;
                        if (z5) {
                            ((SpannableBuilder) charSequence2).endBatchEdit();
                        }
                        throw th;
                    }
                }
                unprecomputeTextOnModificationSpannable = new UnprecomputeTextOnModificationSpannable((Spannable) charSequence);
                if (unprecomputeTextOnModificationSpannable == null) {
                    while (r1 < r5) {
                    }
                }
                i3 = i;
                i4 = i2;
                if (i3 != i4) {
                }
                charSequence2 = charSequence;
                if (!z5) {
                }
                ((SpannableBuilder) charSequence2).endBatchEdit();
                return charSequence2;
            } catch (Throwable th5) {
                th = th5;
                charSequence2 = charSequence;
                th = th;
                if (z5) {
                }
                throw th;
            }
        } else {
            throw new IllegalArgumentException("end cannot be negative");
        }
    }

    public final void registerInitCallback(InitCallback initCallback) {
        TimeUtils.checkNotNull(initCallback, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        try {
            if (!(this.mLoadState == 1 || this.mLoadState == 2)) {
                this.mInitCallbacks.add(initCallback);
                this.mInitLock.writeLock().unlock();
            }
            this.mMainHandler.post(new CallbackWithHandler$2(Arrays.asList(initCallback), this.mLoadState, (Throwable) null));
            this.mInitLock.writeLock().unlock();
        } catch (Throwable th) {
            this.mInitLock.writeLock().unlock();
            throw th;
        }
    }

    /* loaded from: classes.dex */
    public abstract class InitCallback {
        public abstract void onInitialized();

        public void onFailed() {
        }
    }
}
