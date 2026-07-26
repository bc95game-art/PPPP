package com.emanuelef.remote_capture.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import androidx.core.content.ContextCompat$Api21Impl;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.os.BundleKt;
import com.emanuelef.remote_capture.AppsResolver;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.interfaces.TextAdapter;
import com.emanuelef.remote_capture.model.MatchList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ListEditAdapter extends ArrayAdapter<MatchList.Rule> implements TextAdapter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AppsResolver mApps;
    private final Drawable mDefaultIcon;
    private final LayoutInflater mLayoutInflater;
    private final Drawable mUnknownIcon;

    public ListEditAdapter(Context context) {
        super(context, R.layout.rule_item);
        this.mLayoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mApps = new AppsResolver(context);
        this.mUnknownIcon = ContextCompat$Api21Impl.getDrawable(context, R.drawable.ic_image);
        Drawable drawable = ContextCompat$Api21Impl.getDrawable(context, R.drawable.ic_short_text);
        this.mDefaultIcon = drawable;
        DrawableCompat$Api21Impl.setTint(drawable, BundleKt.getColor(context, R.color.colorTabText));
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
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            r0 = 0
            if (r7 != 0) goto Lc
            android.view.LayoutInflater r7 = r5.mLayoutInflater
            r1 = 2131558564(0x7f0d00a4, float:1.8742447E38)
            android.view.View r7 = r7.inflate(r1, r8, r0)
        Lc:
            java.lang.Object r6 = r5.getItem(r6)
            com.emanuelef.remote_capture.model.MatchList$Rule r6 = (com.emanuelef.remote_capture.model.MatchList.Rule) r6
            r8 = 2131362236(0x7f0a01bc, float:1.8344247E38)
            android.view.View r8 = r7.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            java.lang.String r1 = r6.getLabel()
            r8.setText(r1)
            r8 = 2131362201(0x7f0a0199, float:1.8344176E38)
            android.view.View r8 = r7.findViewById(r8)
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r1 = 2131362024(0x7f0a00e8, float:1.8343817E38)
            android.view.View r1 = r7.findViewById(r1)
            com.haipq.android.flagkit.FlagImageView r1 = (com.haipq.android.flagkit.FlagImageView) r1
            com.emanuelef.remote_capture.model.MatchList$RuleType r2 = r6.getType()
            com.emanuelef.remote_capture.model.MatchList$RuleType r3 = com.emanuelef.remote_capture.model.MatchList.RuleType.COUNTRY
            if (r2 != r3) goto L4d
            java.lang.Object r2 = r6.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r1.setCountryCode(r2)
            android.graphics.drawable.Drawable r2 = r1.getDrawable()
            if (r2 == 0) goto L4d
            r2 = 1
            goto L4e
        L4d:
            r2 = 0
        L4e:
            r3 = 8
            if (r2 == 0) goto L55
            r4 = 8
            goto L56
        L55:
            r4 = 0
        L56:
            r8.setVisibility(r4)
            if (r2 != 0) goto L5c
            goto L5d
        L5c:
            r3 = 0
        L5d:
            r1.setVisibility(r3)
            if (r2 != 0) goto L8e
            com.emanuelef.remote_capture.model.MatchList$RuleType r1 = r6.getType()
            com.emanuelef.remote_capture.model.MatchList$RuleType r2 = com.emanuelef.remote_capture.model.MatchList.RuleType.APP
            if (r1 != r2) goto L89
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            com.emanuelef.remote_capture.AppsResolver r1 = r5.mApps
            com.emanuelef.remote_capture.model.AppDescriptor r6 = r1.getAppByPackage(r6, r0)
            if (r6 == 0) goto L83
            android.graphics.drawable.Drawable r0 = r6.getIcon()
            if (r0 == 0) goto L83
            android.graphics.drawable.Drawable r6 = r6.getIcon()
            goto L85
        L83:
            android.graphics.drawable.Drawable r6 = r5.mUnknownIcon
        L85:
            r8.setImageDrawable(r6)
            return r7
        L89:
            android.graphics.drawable.Drawable r6 = r5.mDefaultIcon
            r8.setImageDrawable(r6)
        L8e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.emanuelef.remote_capture.adapters.ListEditAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public void reload(Iterator<MatchList.Rule> it) {
        clear();
        while (it.hasNext()) {
            add(it.next());
        }
    }
}
