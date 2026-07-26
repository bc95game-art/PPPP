package com.emanuelef.remote_capture.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.model.BlacklistDescriptor;
import java.util.Iterator;
/* loaded from: classes.dex */
public class BlacklistsAdapter extends ArrayAdapter<BlacklistDescriptor> {
    private final LayoutInflater mLayoutInflater;

    public BlacklistsAdapter(Context context, Iterator<BlacklistDescriptor> it) {
        super(context, C0130R.layout.blacklist_item);
        this.mLayoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        if (view == null) {
            view = this.mLayoutInflater.inflate(C0130R.layout.blacklist_item, viewGroup, false);
        }
        Context context = viewGroup.getContext();
        BlacklistDescriptor blacklistDescriptor = (BlacklistDescriptor) getItem(i);
        ((TextView) view.findViewById(C0130R.C0132id.label)).setText(blacklistDescriptor.label);
        TextView textView = (TextView) view.findViewById(C0130R.C0132id.status);
        textView.setText(blacklistDescriptor.getStatusLabel(context));
        textView.setTextColor(blacklistDescriptor.getStatusColor(context));
        if (CaptureService.isServiceActive()) {
            i2 = 0;
        } else {
            i2 = 4;
        }
        textView.setVisibility(i2);
        ((TextView) view.findViewById(C0130R.C0132id.type)).setText(String.format(context.getString(C0130R.string.blacklist_type), blacklistDescriptor.getTypeLabel(context)));
        ((TextView) view.findViewById(C0130R.C0132id.rules)).setText(String.format(context.getString(C0130R.string.n_rules), Utils.formatIntShort(blacklistDescriptor.num_rules)));
        ((TextView) view.findViewById(C0130R.C0132id.last_update)).setText(String.format(context.getString(C0130R.string.last_update_val), Utils.formatEpochMin(context, blacklistDescriptor.getLastUpdate() / 1000)));
        return view;
    }
}
