package com.emanuelef.remote_capture.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.model.PortMapping;
import java.util.Iterator;
/* loaded from: classes.dex */
public class PortMappingAdapter extends ArrayAdapter<PortMapping.PortMap> {
    private final LayoutInflater mLayoutInflater;
    private final PortMapping mMappings;

    public PortMappingAdapter(Context context, PortMapping portMapping) {
        super(context, C0130R.layout.port_mapping_item);
        this.mLayoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mMappings = portMapping;
        reload();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @SuppressLint({"SetTextI18n"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mLayoutInflater.inflate(C0130R.layout.port_mapping_item, viewGroup, false);
        }
        PortMapping.PortMap portMap = (PortMapping.PortMap) getItem(i);
        String string = getContext().getString(C0130R.string.ip_and_port, portMap.redirect_host, Integer.valueOf(portMap.redirect_port));
        ((TextView) view.findViewById(C0130R.C0132id.orig_port)).setText(Integer.toString(portMap.orig_port));
        ((TextView) view.findViewById(C0130R.C0132id.proto)).setText(Utils.proto2str(portMap.ipproto));
        ((TextView) view.findViewById(C0130R.C0132id.redirect_to)).setText(string);
        return view;
    }

    public void reload() {
        clear();
        Iterator<PortMapping.PortMap> iter = this.mMappings.iter();
        while (iter.hasNext()) {
            add(iter.next());
        }
    }
}
