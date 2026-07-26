package com.emanuelef.remote_capture.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.model.BlacklistDescriptor;
import java.util.Iterator;
/* loaded from: classes.dex */
public class BlacklistsAdapter extends ArrayAdapter<BlacklistDescriptor> {
    private final LayoutInflater mLayoutInflater;

    public BlacklistsAdapter(Context context, Iterator<BlacklistDescriptor> it) {
        super(context, R.layout.blacklist_item);
        this.mLayoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        if (view == null) {
            view = this.mLayoutInflater.inflate(R.layout.blacklist_item, viewGroup, false);
        }
        Context context = viewGroup.getContext();
        BlacklistDescriptor blacklistDescriptor = (BlacklistDescriptor) getItem(i);
        ((TextView) view.findViewById(R.id.label)).setText(blacklistDescriptor.label);
        TextView textView = (TextView) view.findViewById(R.id.status);
        textView.setText(blacklistDescriptor.getStatusLabel(context));
        textView.setTextColor(blacklistDescriptor.getStatusColor(context));
        if (CaptureService.isServiceActive()) {
            i2 = 0;
        } else {
            i2 = 4;
        }
        textView.setVisibility(i2);
        ((TextView) view.findViewById(R.id.type)).setText(String.format(context.getString(R.string.blacklist_type), blacklistDescriptor.getTypeLabel(context)));
        ((TextView) view.findViewById(R.id.rules)).setText(String.format(context.getString(R.string.n_rules), Utils.formatIntShort(blacklistDescriptor.num_rules)));
        ((TextView) view.findViewById(R.id.last_update)).setText(String.format(context.getString(R.string.last_update_val), Utils.formatEpochMin(context, blacklistDescriptor.getLastUpdate() / 1000)));
        return view;
    }
}
