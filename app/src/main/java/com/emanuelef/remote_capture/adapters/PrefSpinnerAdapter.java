package com.emanuelef.remote_capture.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.emanuelef.remote_capture.R;
/* loaded from: classes.dex */
public class PrefSpinnerAdapter extends BaseAdapter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final LayoutInflater mInflater;
    private final ModeInfo[] mModes;

    /* loaded from: classes.dex */
    public static class ModeInfo {
        public final String description;
        public final String key;
        public final String label;

        public ModeInfo(String str, String str2, String str3) {
            this.key = str;
            this.label = str2;
            this.description = str3;
        }
    }

    public PrefSpinnerAdapter(Context context, int i, int i2, int i3) {
        this.mInflater = LayoutInflater.from(context);
        String[] stringArray = context.getResources().getStringArray(i);
        String[] stringArray2 = context.getResources().getStringArray(i2);
        String[] stringArray3 = context.getResources().getStringArray(i3);
        this.mModes = new ModeInfo[stringArray.length];
        for (int i4 = 0; i4 < stringArray.length; i4++) {
            this.mModes[i4] = new ModeInfo(stringArray[i4], stringArray2[i4], stringArray3[i4]);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mModes.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mModes[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public int getModePos(String str) {
        int i = 0;
        while (true) {
            ModeInfo[] modeInfoArr = this.mModes;
            if (i >= modeInfoArr.length) {
                return 0;
            }
            if (str.equals(modeInfoArr[i].key)) {
                return i;
            }
            i++;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(R.layout.quick_settings_item, viewGroup, false);
        }
        ModeInfo modeInfo = (ModeInfo) getItem(i);
        ((TextView) view.findViewById(R.id.title)).setText(modeInfo.label);
        ((TextView) view.findViewById(R.id.description)).setText(modeInfo.description);
        return view;
    }
}
