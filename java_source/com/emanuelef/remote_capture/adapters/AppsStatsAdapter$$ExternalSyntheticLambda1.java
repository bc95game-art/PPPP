package com.emanuelef.remote_capture.adapters;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.emanuelef.remote_capture.adapters.AppsStatsAdapter;
import com.emanuelef.remote_capture.adapters.ConnectionsAdapter;
/* loaded from: classes.dex */
public final /* synthetic */ class AppsStatsAdapter$$ExternalSyntheticLambda1 implements View.OnLongClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ RecyclerView.Adapter f$0;
    public final /* synthetic */ RecyclerView.ViewHolder f$1;

    public /* synthetic */ AppsStatsAdapter$$ExternalSyntheticLambda1(RecyclerView.Adapter adapter, RecyclerView.ViewHolder viewHolder, int i) {
        this.$r8$classId = i;
        this.f$0 = adapter;
        this.f$1 = viewHolder;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        boolean lambda$onCreateViewHolder$0;
        switch (this.$r8$classId) {
            case 0:
                lambda$onCreateViewHolder$0 = ((AppsStatsAdapter) this.f$0).lambda$onCreateViewHolder$0((AppsStatsAdapter.ViewHolder) this.f$1, view);
                return lambda$onCreateViewHolder$0;
            default:
                return ConnectionsAdapter.$r8$lambda$VoKIAct4Di7fxOUwuaV3IN8bZs0((ConnectionsAdapter) this.f$0, (ConnectionsAdapter.ViewHolder) this.f$1, view);
        }
    }
}
