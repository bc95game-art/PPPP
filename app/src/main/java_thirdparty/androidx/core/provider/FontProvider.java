package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public abstract class FontProvider {
    public static final FontProvider$$ExternalSyntheticLambda0 sByteArrayComparator = new FontProvider$$ExternalSyntheticLambda0(0);

    /* loaded from: classes.dex */
    public final class ContentQueryWrapperApi16Impl {
        public final /* synthetic */ int $r8$classId;
        public final ContentProviderClient mClient;

        public ContentQueryWrapperApi16Impl(Context context, Uri uri, int i) {
            this.$r8$classId = i;
            switch (i) {
                case 1:
                    this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                    return;
                default:
                    this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                    return;
            }
        }

        public final void close() {
            switch (this.$r8$classId) {
                case 0:
                    ContentProviderClient contentProviderClient = this.mClient;
                    if (contentProviderClient != null) {
                        contentProviderClient.release();
                        return;
                    }
                    return;
                default:
                    ContentProviderClient contentProviderClient2 = this.mClient;
                    if (contentProviderClient2 == null) {
                        return;
                    }
                    if (contentProviderClient2 instanceof AutoCloseable) {
                        contentProviderClient2.close();
                        return;
                    } else if (contentProviderClient2 instanceof ExecutorService) {
                        FontProvider$ContentQueryWrapperApi24Impl$$ExternalSyntheticAutoCloseableForwarder0.m((ExecutorService) contentProviderClient2);
                        return;
                    } else {
                        contentProviderClient2.release();
                        return;
                    }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.android.billingclient.api.zzbv getFontFamilyResult(android.content.Context r19, androidx.core.provider.FontRequest r20) {
        /*
            Method dump skipped, instructions count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontProvider.getFontFamilyResult(android.content.Context, androidx.core.provider.FontRequest):com.android.billingclient.api.zzbv");
    }
}
