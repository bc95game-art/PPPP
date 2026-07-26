package androidx.emoji2.text;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public class EmojiCompatInitializer implements Initializer {

    /* renamed from: androidx.emoji2.text.EmojiCompatInitializer$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 implements LifecycleObserver {
        public final /* synthetic */ Lifecycle val$lifecycle;

        public AnonymousClass1(Lifecycle lifecycle) {
            this.val$lifecycle = lifecycle;
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.emoji2.text.EmojiCompat$MetadataRepoLoader, java.lang.Object, androidx.navigation.internal.NavContext] */
    @Override // androidx.startup.Initializer
    public final Object create(Context context) {
        ?? obj = new Object();
        obj.context = context.getApplicationContext();
        FontRequestEmojiCompatConfig fontRequestEmojiCompatConfig = new FontRequestEmojiCompatConfig(obj);
        fontRequestEmojiCompatConfig.mMetadataLoadStrategy = 1;
        if (EmojiCompat.sInstance == null) {
            synchronized (EmojiCompat.INSTANCE_LOCK) {
                try {
                    if (EmojiCompat.sInstance == null) {
                        EmojiCompat.sInstance = new EmojiCompat(fontRequestEmojiCompatConfig);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        delayUntilFirstResume(context);
        return Boolean.TRUE;
    }

    public final void delayUntilFirstResume(Context context) {
        Object obj;
        AppInitializer appInitializer = AppInitializer.getInstance(context);
        appInitializer.getClass();
        synchronized (AppInitializer.sLock) {
            try {
                obj = appInitializer.mInitialized.get(ProcessLifecycleInitializer.class);
                if (obj == null) {
                    obj = appInitializer.doInitialize(ProcessLifecycleInitializer.class, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Lifecycle lifecycle = ((LifecycleOwner) obj).getLifecycle();
        lifecycle.addObserver(new AnonymousClass1(lifecycle));
    }

    @Override // androidx.startup.Initializer
    public final List dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
