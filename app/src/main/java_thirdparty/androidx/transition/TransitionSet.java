package androidx.transition;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import androidx.emoji2.text.MetadataRepo;
import androidx.navigation.Navigation;
import androidx.transition.Transition;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class TransitionSet extends Transition {
    public int mCurrentListeners;
    public ArrayList mTransitions = new ArrayList();
    public boolean mPlayTogether = true;
    public boolean mStarted = false;
    public int mChangeFlags = 0;

    /* renamed from: androidx.transition.TransitionSet$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass2 extends TransitionListenerAdapter {
        public final /* synthetic */ int $r8$classId;
        public Transition this$0;

        public /* synthetic */ AnonymousClass2() {
            this.$r8$classId = 1;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
            switch (this.$r8$classId) {
                case 0:
                    TransitionSet transitionSet = (TransitionSet) this.this$0;
                    transitionSet.mTransitions.remove(transition);
                    if (!transitionSet.hasAnimators()) {
                        transitionSet.notifyFromTransition(transitionSet, Transition.TransitionNotification.ON_CANCEL, false);
                        transitionSet.mEnded = true;
                        transitionSet.notifyFromTransition(transitionSet, Transition.TransitionNotification.ON_END, false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            switch (this.$r8$classId) {
                case 1:
                    TransitionSet transitionSet = (TransitionSet) this.this$0;
                    int i = transitionSet.mCurrentListeners - 1;
                    transitionSet.mCurrentListeners = i;
                    if (i == 0) {
                        transitionSet.mStarted = false;
                        transitionSet.end();
                    }
                    transition.removeListener(this);
                    return;
                case 2:
                    this.this$0.runAnimators();
                    transition.removeListener(this);
                    return;
                default:
                    return;
            }
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            switch (this.$r8$classId) {
                case 1:
                    TransitionSet transitionSet = (TransitionSet) this.this$0;
                    if (!transitionSet.mStarted) {
                        transitionSet.start();
                        transitionSet.mStarted = true;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public /* synthetic */ AnonymousClass2(Transition transition, int i) {
            this.$r8$classId = i;
            this.this$0 = transition;
        }
    }

    @Override // androidx.transition.Transition
    public final void addTarget(View view) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            ((Transition) this.mTransitions.get(i)).addTarget(view);
        }
        this.mTargets.add(view);
    }

    public final void addTransition(Transition transition) {
        this.mTransitions.add(transition);
        transition.mParent = this;
        long j = this.mDuration;
        if (j >= 0) {
            transition.setDuration(j);
        }
        if ((this.mChangeFlags & 1) != 0) {
            transition.setInterpolator(this.mInterpolator);
        }
        if ((this.mChangeFlags & 2) != 0) {
            transition.setPropagation();
        }
        if ((this.mChangeFlags & 4) != 0) {
            transition.setPathMotion(this.mPathMotion);
        }
        if ((this.mChangeFlags & 8) != 0) {
            transition.setEpicenterCallback(this.mEpicenterCallback);
        }
    }

    @Override // androidx.transition.Transition
    public final void cancel() {
        super.cancel();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).cancel();
        }
    }

    @Override // androidx.transition.Transition
    public final void captureEndValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (isValidTarget(view)) {
            ArrayList arrayList = this.mTransitions;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                Transition transition = (Transition) obj;
                if (transition.isValidTarget(view)) {
                    transition.captureEndValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(transition);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public final void capturePropagationValues(TransitionValues transitionValues) {
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).capturePropagationValues(transitionValues);
        }
    }

    @Override // androidx.transition.Transition
    public final void captureStartValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (isValidTarget(view)) {
            ArrayList arrayList = this.mTransitions;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                Transition transition = (Transition) obj;
                if (transition.isValidTarget(view)) {
                    transition.captureStartValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(transition);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public final void createAnimators(ViewGroup viewGroup, MetadataRepo metadataRepo, MetadataRepo metadataRepo2, ArrayList arrayList, ArrayList arrayList2) {
        long j = this.mStartDelay;
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            Transition transition = (Transition) this.mTransitions.get(i);
            if (j > 0 && (this.mPlayTogether || i == 0)) {
                long j2 = transition.mStartDelay;
                if (j2 > 0) {
                    transition.setStartDelay(j2 + j);
                } else {
                    transition.setStartDelay(j);
                }
            }
            transition.createAnimators(viewGroup, metadataRepo, metadataRepo2, arrayList, arrayList2);
        }
    }

    public final Transition getTransitionAt(int i) {
        if (i < 0 || i >= this.mTransitions.size()) {
            return null;
        }
        return (Transition) this.mTransitions.get(i);
    }

    @Override // androidx.transition.Transition
    public final boolean hasAnimators() {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            if (((Transition) this.mTransitions.get(i)).hasAnimators()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.transition.Transition
    public final boolean isSeekingSupported() {
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            if (!((Transition) this.mTransitions.get(i)).isSeekingSupported()) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.transition.Transition
    public final void pause(View view) {
        super.pause(view);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).pause(view);
        }
    }

    @Override // androidx.transition.Transition
    public final void prepareAnimatorsForSeeking() {
        this.mTotalDuration = 0L;
        AnonymousClass2 r0 = new AnonymousClass2(this, 0);
        for (int i = 0; i < this.mTransitions.size(); i++) {
            Transition transition = (Transition) this.mTransitions.get(i);
            transition.addListener(r0);
            transition.prepareAnimatorsForSeeking();
            long j = transition.mTotalDuration;
            if (this.mPlayTogether) {
                this.mTotalDuration = Math.max(this.mTotalDuration, j);
            } else {
                long j2 = this.mTotalDuration;
                transition.mSeekOffsetInParent = j2;
                this.mTotalDuration = j2 + j;
            }
        }
    }

    @Override // androidx.transition.Transition
    public final Transition removeListener(Transition.TransitionListener transitionListener) {
        super.removeListener(transitionListener);
        return this;
    }

    @Override // androidx.transition.Transition
    public final void removeTarget(View view) {
        for (int i = 0; i < this.mTransitions.size(); i++) {
            ((Transition) this.mTransitions.get(i)).removeTarget(view);
        }
        this.mTargets.remove(view);
    }

    @Override // androidx.transition.Transition
    public final void resume(View view) {
        super.resume(view);
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).resume(view);
        }
    }

    @Override // androidx.transition.Transition
    public final void runAnimators() {
        if (this.mTransitions.isEmpty()) {
            start();
            end();
            return;
        }
        AnonymousClass2 r0 = new AnonymousClass2();
        r0.this$0 = this;
        ArrayList arrayList = this.mTransitions;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((Transition) obj).addListener(r0);
        }
        this.mCurrentListeners = this.mTransitions.size();
        if (!this.mPlayTogether) {
            for (int i3 = 1; i3 < this.mTransitions.size(); i3++) {
                ((Transition) this.mTransitions.get(i3 - 1)).addListener(new AnonymousClass2((Transition) this.mTransitions.get(i3), 2));
            }
            Transition transition = (Transition) this.mTransitions.get(0);
            if (transition != null) {
                transition.runAnimators();
                return;
            }
            return;
        }
        ArrayList arrayList2 = this.mTransitions;
        int size2 = arrayList2.size();
        while (i < size2) {
            Object obj2 = arrayList2.get(i);
            i++;
            ((Transition) obj2).runAnimators();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    @Override // androidx.transition.Transition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setCurrentPlayTimeMillis(long r20, long r22) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionSet.setCurrentPlayTimeMillis(long, long):void");
    }

    @Override // androidx.transition.Transition
    public final void setDuration(long j) {
        ArrayList arrayList;
        this.mDuration = j;
        if (j >= 0 && (arrayList = this.mTransitions) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Transition) this.mTransitions.get(i)).setDuration(j);
            }
        }
    }

    @Override // androidx.transition.Transition
    public final void setEpicenterCallback(Navigation navigation) {
        this.mEpicenterCallback = navigation;
        this.mChangeFlags |= 8;
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).setEpicenterCallback(navigation);
        }
    }

    @Override // androidx.transition.Transition
    public final void setInterpolator(TimeInterpolator timeInterpolator) {
        this.mChangeFlags |= 1;
        ArrayList arrayList = this.mTransitions;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Transition) this.mTransitions.get(i)).setInterpolator(timeInterpolator);
            }
        }
        this.mInterpolator = timeInterpolator;
    }

    @Override // androidx.transition.Transition
    public final void setPathMotion(Transition.AnonymousClass1 r3) {
        super.setPathMotion(r3);
        this.mChangeFlags |= 4;
        if (this.mTransitions != null) {
            for (int i = 0; i < this.mTransitions.size(); i++) {
                ((Transition) this.mTransitions.get(i)).setPathMotion(r3);
            }
        }
    }

    @Override // androidx.transition.Transition
    public final void setPropagation() {
        this.mChangeFlags |= 2;
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            ((Transition) this.mTransitions.get(i)).setPropagation();
        }
    }

    @Override // androidx.transition.Transition
    public final void setStartDelay(long j) {
        this.mStartDelay = j;
    }

    @Override // androidx.transition.Transition
    public final String toString(String str) {
        String transition = super.toString(str);
        for (int i = 0; i < this.mTransitions.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(transition);
            sb.append("\n");
            sb.append(((Transition) this.mTransitions.get(i)).toString(str + "  "));
            transition = sb.toString();
        }
        return transition;
    }

    @Override // androidx.transition.Transition
    public final Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.mTransitions = new ArrayList();
        int size = this.mTransitions.size();
        for (int i = 0; i < size; i++) {
            Transition clone = ((Transition) this.mTransitions.get(i)).clone();
            transitionSet.mTransitions.add(clone);
            clone.mParent = transitionSet;
        }
        return transitionSet;
    }
}
