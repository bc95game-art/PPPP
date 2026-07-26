package kotlin.collections;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatcherMatchResult$groups$1;
/* loaded from: classes.dex */
public final class AbstractCollection$toString$1 extends Lambda implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AbstractCollection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AbstractCollection$toString$1(AbstractCollection abstractCollection, int i) {
        super(1);
        this.$r8$classId = i;
        this.this$0 = abstractCollection;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                if (obj == this.this$0) {
                    return "(this Collection)";
                }
                return String.valueOf(obj);
            default:
                return ((MatcherMatchResult$groups$1) this.this$0).get(((Number) obj).intValue());
        }
    }
}
