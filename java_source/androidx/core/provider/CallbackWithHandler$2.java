package androidx.core.provider;

import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.TimeUtils;
import androidx.emoji2.text.EmojiCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.FakeDrag;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.slider.BaseSlider;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class CallbackWithHandler$2 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final Object val$callback;
    public int val$reason;

    public /* synthetic */ CallbackWithHandler$2(int i, int i2, Object obj) {
        this.$r8$classId = i2;
        this.val$callback = obj;
        this.val$reason = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                int i = this.val$reason;
                ResourcesCompat.FontCallback fontCallback = (ResourcesCompat.FontCallback) ((FakeDrag) this.val$callback).mScrollEventAdapter;
                if (fontCallback != null) {
                    fontCallback.onFontRetrievalFailed(i);
                    return;
                }
                return;
            case 1:
                ArrayList arrayList = (ArrayList) this.val$callback;
                int size = arrayList.size();
                int i2 = 0;
                if (this.val$reason != 1) {
                    while (i2 < size) {
                        ((EmojiCompat.InitCallback) arrayList.get(i2)).onFailed();
                        i2++;
                    }
                    return;
                }
                while (i2 < size) {
                    ((EmojiCompat.InitCallback) arrayList.get(i2)).onInitialized();
                    i2++;
                }
                return;
            case 2:
                ((RecyclerView) this.val$callback).smoothScrollToPosition(this.val$reason);
                return;
            case 3:
                ((zabq) this.val$callback).zaI(this.val$reason);
                return;
            case 4:
                ((MaterialCalendar) this.val$callback).recyclerView.smoothScrollToPosition(this.val$reason);
                return;
            default:
                ((BaseSlider) this.val$callback).accessibilityHelper.sendEventForVirtualView(this.val$reason, 4);
                return;
        }
    }

    public CallbackWithHandler$2(int i, ViewPager2.RecyclerViewImpl recyclerViewImpl) {
        this.$r8$classId = 2;
        this.val$reason = i;
        this.val$callback = recyclerViewImpl;
    }

    public CallbackWithHandler$2(List list, int i, Throwable th) {
        this.$r8$classId = 1;
        TimeUtils.checkNotNull(list, "initCallbacks cannot be null");
        this.val$callback = new ArrayList(list);
        this.val$reason = i;
    }

    public CallbackWithHandler$2(BaseSlider baseSlider) {
        this.$r8$classId = 5;
        this.val$callback = baseSlider;
        this.val$reason = -1;
    }
}
