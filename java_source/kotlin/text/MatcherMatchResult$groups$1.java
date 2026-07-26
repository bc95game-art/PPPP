package kotlin.text;

import androidx.core.view.TreeIterator;
import java.util.Iterator;
import java.util.regex.Matcher;
import kotlin.collections.AbstractCollection;
import kotlin.collections.AbstractCollection$toString$1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.TakeWhileSequence;
/* loaded from: classes.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection {
    public final /* synthetic */ MatcherMatchResult this$0;

    public MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.this$0 = matcherMatchResult;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        boolean z;
        if (obj == null) {
            z = true;
        } else {
            z = obj instanceof MatchGroup;
        }
        if (!z) {
            return false;
        }
        return super.contains((MatchGroup) obj);
    }

    public final MatchGroup get(int i) {
        Matcher matcher = (Matcher) this.this$0.matcher;
        IntRange until = RangesKt.until(matcher.start(i), matcher.end(i));
        if (until.first < 0) {
            return null;
        }
        String group = matcher.group(i);
        Intrinsics.checkNotNullExpressionValue(group, "group(...)");
        return new MatchGroup(group, until);
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return ((Matcher) this.this$0.matcher).groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new TreeIterator(new TakeWhileSequence(new FilteringSequence(1, new IntProgression(0, getSize() - 1, 1)), new AbstractCollection$toString$1(this, 1), 1));
    }
}
