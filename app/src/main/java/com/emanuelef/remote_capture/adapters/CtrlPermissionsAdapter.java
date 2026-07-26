package com.emanuelef.remote_capture.adapters;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.core.provider.FontProvider$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.AppsResolver;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.interfaces.TextAdapter;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.CtrlPermissions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public class CtrlPermissionsAdapter extends ArrayAdapter<CtrlPermissions.Rule> implements TextAdapter {
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private final CtrlPermissions mPermissions;
    private final ArrayMap<String, AppDescriptor> mPkgToApp = new ArrayMap<>();

    public CtrlPermissionsAdapter(Context context, CtrlPermissions ctrlPermissions) {
        super(context, R.layout.rule_item);
        this.mLayoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mPermissions = ctrlPermissions;
        this.mContext = context;
        load();
    }

    public static /* synthetic */ int lambda$load$0(CtrlPermissions.Rule rule, CtrlPermissions.Rule rule2) {
        return rule.package_name.compareTo(rule2.package_name);
    }

    private void load() {
        PackageManager packageManager = this.mContext.getPackageManager();
        Iterator<CtrlPermissions.Rule> iterRules = this.mPermissions.iterRules();
        ArrayList arrayList = new ArrayList();
        while (iterRules.hasNext()) {
            CtrlPermissions.Rule next = iterRules.next();
            AppDescriptor resolveInstalledApp = AppsResolver.resolveInstalledApp(packageManager, next.package_name, 0);
            if (resolveInstalledApp != null) {
                this.mPkgToApp.put(next.package_name, resolveInstalledApp);
            }
            arrayList.add(next);
        }
        Collections.sort(arrayList, new FontProvider$$ExternalSyntheticLambda0(3));
        addAll(arrayList);
    }

    @Override // com.emanuelef.remote_capture.interfaces.TextAdapter
    public String getItemText(int i) {
        return ((CtrlPermissions.Rule) getItem(i)).package_name;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        String str;
        int i2;
        if (view == null) {
            view = this.mLayoutInflater.inflate(R.layout.rule_item, viewGroup, false);
        }
        CtrlPermissions.Rule rule = (CtrlPermissions.Rule) getItem(i);
        AppDescriptor appDescriptor = this.mPkgToApp.get(rule.package_name);
        String string = this.mContext.getString(R.string.control_permissions_item);
        if (appDescriptor == null) {
            str = rule.package_name;
        } else {
            str = appDescriptor.getName() + " (" + appDescriptor.getPackageName() + ")";
        }
        Context context = this.mContext;
        if (rule.consent == CtrlPermissions.ConsentType.ALLOW) {
            i2 = R.string.allow;
        } else {
            i2 = R.string.deny;
        }
        ((TextView) view.findViewById(R.id.item_label)).setText(String.format(string, str, context.getString(i2)));
        return view;
    }
}
