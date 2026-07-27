package com.emanuelef.remote_capture.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class EmptyRecyclerView extends RecyclerView {
    private View mEmptyView;
    final RecyclerView.AdapterDataObserver observer = new RecyclerView.AdapterDataObserver() { // from class: com.emanuelef.remote_capture.views.EmptyRecyclerView.1
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            EmptyRecyclerView.this.initEmptyView();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            EmptyRecyclerView.this.initEmptyView();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            EmptyRecyclerView.this.initEmptyView();
        }
    };

    /* loaded from: classes.dex */
    public static class MyLinearLayoutManager extends LinearLayoutManager {
        public MyLinearLayoutManager(Context context) {
            super(1);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean supportsPredictiveItemAnimations() {
            return false;
        }
    }

    public EmptyRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        RecyclerView.ItemAnimator itemAnimator = getItemAnimator();
        if (itemAnimator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) itemAnimator).mSupportsChangeAnimations = false;
        }
        TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0 = new TransportImpl$$ExternalSyntheticLambda0(18);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(this, transportImpl$$ExternalSyntheticLambda0);
        setClipToPadding(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initEmptyView() {
        int i;
        View view = this.mEmptyView;
        if (view != null) {
            int i2 = 0;
            if (getAdapter() == null || getAdapter().getItemCount() == 0) {
                i = 0;
            } else {
                i = 8;
            }
            view.setVisibility(i);
            if (getAdapter() == null || getAdapter().getItemCount() == 0) {
                i2 = 8;
            }
            setVisibility(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static WindowInsetsCompat lambda$init$0(View view, WindowInsetsCompat windowInsetsCompat) {
        boolean z;
        int i;
        Insets insets = windowInsetsCompat.mImpl.getInsets(143);
        if (windowInsetsCompat.mImpl.getInsets(8).bottom > 0) {
            z = true;
        } else {
            z = false;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i2 = insets.top;
        int i3 = insets.bottom;
        marginLayoutParams.topMargin = i2;
        if (z) {
            i = i3;
        } else {
            i = 0;
        }
        marginLayoutParams.bottomMargin = i;
        marginLayoutParams.leftMargin = insets.left;
        marginLayoutParams.rightMargin = insets.right;
        view.setLayoutParams(marginLayoutParams);
        if (z) {
            i3 = 0;
        }
        view.setPadding(0, 0, 0, i3);
        return windowInsetsCompat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static WindowInsetsCompat lambda$setEmptyView$1(View view, WindowInsetsCompat windowInsetsCompat) {
        view.setPadding(0, windowInsetsCompat.mImpl.getInsets(135).top, 0, 0);
        return windowInsetsCompat;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = getAdapter();
        super.setAdapter(adapter);
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.observer);
        }
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.observer);
        }
        initEmptyView();
    }

    public void setEmptyView(View view) {
        View view2 = this.mEmptyView;
        if (view2 != null) {
            view2.setOnApplyWindowInsetsListener(null);
        }
        this.mEmptyView = view;
        initEmptyView();
        if (view != null) {
            TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0 = new TransportImpl$$ExternalSyntheticLambda0(19);
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(view, transportImpl$$ExternalSyntheticLambda0);
        }
    }

    public EmptyRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public EmptyRecyclerView(Context context) {
        super(context, null);
        init();
    }
}
