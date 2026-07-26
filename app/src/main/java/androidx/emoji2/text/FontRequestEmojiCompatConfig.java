package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import androidx.collection.internal.Lock;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.provider.FontProvider;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat$FontInfo;
import androidx.core.util.TimeUtils;
import androidx.emoji2.text.EmojiCompat;
import androidx.navigation.Navigation;
import com.android.billingclient.api.zzbv;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class FontRequestEmojiCompatConfig {
    public static final Lock DEFAULT_FONTS_CONTRACT = new Object();
    public final EmojiCompat.MetadataRepoLoader mMetadataLoader;
    public int mMetadataLoadStrategy = 0;
    public final DefaultGlyphChecker mGlyphChecker = new DefaultGlyphChecker();

    /* loaded from: classes.dex */
    public final class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {
        public Navigation mCallback;
        public final Context mContext;
        public ThreadPoolExecutor mExecutor;
        public Handler mMainHandler;
        public ThreadPoolExecutor mMyThreadPoolExecutor;
        public final FontRequest mRequest;
        public final Object mLock = new Object();
        public final Lock mFontProviderHelper = FontRequestEmojiCompatConfig.DEFAULT_FONTS_CONTRACT;

        public FontRequestMetadataLoader(Context context, FontRequest fontRequest) {
            TimeUtils.checkNotNull(context, "Context cannot be null");
            this.mContext = context.getApplicationContext();
            this.mRequest = fontRequest;
        }

        public final void cleanUp() {
            synchronized (this.mLock) {
                try {
                    this.mCallback = null;
                    Handler handler = this.mMainHandler;
                    if (handler != null) {
                        handler.removeCallbacks(null);
                    }
                    this.mMainHandler = null;
                    ThreadPoolExecutor threadPoolExecutor = this.mMyThreadPoolExecutor;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.mExecutor = null;
                    this.mMyThreadPoolExecutor = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public final void load(Navigation navigation) {
            synchronized (this.mLock) {
                this.mCallback = navigation;
            }
            loadInternal();
        }

        public final void loadInternal() {
            synchronized (this.mLock) {
                try {
                    if (this.mCallback != null) {
                        if (this.mExecutor == null) {
                            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ConcurrencyHelpers$$ExternalSyntheticLambda0("emojiCompat"));
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                            this.mMyThreadPoolExecutor = threadPoolExecutor;
                            this.mExecutor = threadPoolExecutor;
                        }
                        this.mExecutor.execute(new ActivityCompat$$ExternalSyntheticLambda0(5, this));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final FontsContractCompat$FontInfo retrieveFontInfo() {
            try {
                Lock lock = this.mFontProviderHelper;
                Context context = this.mContext;
                FontRequest fontRequest = this.mRequest;
                lock.getClass();
                zzbv fontFamilyResult = FontProvider.getFontFamilyResult(context, fontRequest);
                int i = fontFamilyResult.zzb;
                if (i == 0) {
                    FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr = (FontsContractCompat$FontInfo[]) fontFamilyResult.zza;
                    if (fontsContractCompat$FontInfoArr != null && fontsContractCompat$FontInfoArr.length != 0) {
                        return fontsContractCompat$FontInfoArr[0];
                    }
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                throw new RuntimeException("fetchFonts failed (" + i + ")");
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }
    }

    public FontRequestEmojiCompatConfig(EmojiCompat.MetadataRepoLoader metadataRepoLoader) {
        this.mMetadataLoader = metadataRepoLoader;
    }
}
