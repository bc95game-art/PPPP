package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.viewpager2.widget.FakeDrag;
/* loaded from: classes.dex */
public abstract class ActivityResultContract {
    public abstract Intent createIntent(Context context, Object obj);

    public FakeDrag getSynchronousResult(Context context, Object obj) {
        return null;
    }

    public abstract Object parseResult(Intent intent, int i);
}
