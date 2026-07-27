package com.emanuelef.remote_capture.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat$Api21Impl;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.p002os.BundleKt;
import com.emanuelef.remote_capture.AppsResolver;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.interfaces.TextAdapter;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.MatchList;
import com.haipq.android.flagkit.FlagImageView;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ListEditAdapter extends ArrayAdapter<MatchList.Rule> implements TextAdapter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AppsResolver mApps;
    private final Drawable mDefaultIcon;
    private final LayoutInflater mLayoutInflater;
    private final Drawable mUnknownIcon;

    public ListEditAdapter(Context context) {
        super(context, C0130R.layout.rule_item);
        this.mLayoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mApps = new AppsResolver(context);
        this.mUnknownIcon = ContextCompat$Api21Impl.getDrawable(context, C0130R.C0131drawable.ic_image);
        Drawable drawable = ContextCompat$Api21Impl.getDrawable(context, C0130R.C0131drawable.ic_short_text);
        this.mDefaultIcon = drawable;
        DrawableCompat$Api21Impl.setTint(drawable, BundleKt.getColor(context, C0130R.color.colorTabText));
    }

    @Override // com.emanuelef.remote_capture.interfaces.TextAdapter
    public String getItemText(int i) {
        return ((MatchList.Rule) getItem(i)).getLabel();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i, View view, ViewGroup viewGroup) {
        boolean z;
        int i2;
        Drawable drawable;
        if (view == null) {
            view = this.mLayoutInflater.inflate(C0130R.layout.rule_item, viewGroup, false);
        }
        MatchList.Rule rule = (MatchList.Rule) getItem(i);
        ((TextView) view.findViewById(C0130R.C0132id.item_label)).setText(rule.getLabel());
        ImageView imageView = (ImageView) view.findViewById(C0130R.C0132id.icon);
        FlagImageView flagImageView = (FlagImageView) view.findViewById(C0130R.C0132id.country_flag);
        if (rule.getType() == MatchList.RuleType.COUNTRY) {
            flagImageView.setCountryCode((String) rule.getValue());
            if (flagImageView.getDrawable() != null) {
                z = true;
                int i3 = 8;
                if (!z) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                imageView.setVisibility(i2);
                if (z) {
                    i3 = 0;
                }
                flagImageView.setVisibility(i3);
                if (!z) {
                    if (rule.getType() == MatchList.RuleType.APP) {
                        AppDescriptor appByPackage = this.mApps.getAppByPackage((String) rule.getValue(), 0);
                        if (appByPackage == null || appByPackage.getIcon() == null) {
                            drawable = this.mUnknownIcon;
                        } else {
                            drawable = appByPackage.getIcon();
                        }
                        imageView.setImageDrawable(drawable);
                        return view;
                    }
                    imageView.setImageDrawable(this.mDefaultIcon);
                }
                return view;
            }
        }
        z = false;
        int i32 = 8;
        if (!z) {
        }
        imageView.setVisibility(i2);
        if (z) {
        }
        flagImageView.setVisibility(i32);
        if (!z) {
        }
        return view;
    }

    public void reload(Iterator<MatchList.Rule> it) {
        clear();
        while (it.hasNext()) {
            add(it.next());
        }
    }
}
