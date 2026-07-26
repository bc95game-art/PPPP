package com.android.billingclient.api;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuDialogHelper;
import androidx.core.provider.FontsContractCompat$FontInfo;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.play_billing.zzar;
import com.google.android.gms.internal.play_billing.zzas;
import com.google.android.gms.internal.play_billing.zzau;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzp;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
/* loaded from: classes.dex */
public final /* synthetic */ class zzbv implements AccessibilityViewCommand {
    public final Object zza;
    public final int zzb;

    public /* synthetic */ zzbv(int i, Object obj) {
        this.zza = obj;
        this.zzb = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AlertDialog create() {
        ArrayAdapter arrayAdapter;
        int i;
        final AlertController.AlertParams alertParams = (AlertController.AlertParams) this.zza;
        ContextThemeWrapper contextThemeWrapper = alertParams.mContext;
        ContextThemeWrapper contextThemeWrapper2 = alertParams.mContext;
        AlertDialog alertDialog = new AlertDialog(contextThemeWrapper, this.zzb);
        View view = alertParams.mCustomTitleView;
        final AlertController alertController = alertDialog.mAlert;
        if (view != null) {
            alertController.mCustomTitleView = view;
        } else {
            CharSequence charSequence = alertParams.mTitle;
            if (charSequence != null) {
                alertController.mTitle = charSequence;
                TextView textView = alertController.mTitleView;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = alertParams.mIcon;
            if (drawable != null) {
                alertController.mIcon = drawable;
                ImageView imageView = alertController.mIconView;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    alertController.mIconView.setImageDrawable(drawable);
                }
            }
        }
        CharSequence charSequence2 = alertParams.mMessage;
        if (charSequence2 != null) {
            alertController.mMessage = charSequence2;
            TextView textView2 = alertController.mMessageView;
            if (textView2 != null) {
                textView2.setText(charSequence2);
            }
        }
        CharSequence charSequence3 = alertParams.mPositiveButtonText;
        if (charSequence3 != null) {
            alertController.setButton(-1, charSequence3, alertParams.mPositiveButtonListener);
        }
        CharSequence charSequence4 = alertParams.mNegativeButtonText;
        if (charSequence4 != null) {
            alertController.setButton(-2, charSequence4, alertParams.mNegativeButtonListener);
        }
        CharSequence charSequence5 = alertParams.mNeutralButtonText;
        if (charSequence5 != null) {
            alertController.setButton(-3, charSequence5, alertParams.mNeutralButtonListener);
        }
        if (!(alertParams.mItems == null && alertParams.mAdapter == null)) {
            final AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) alertParams.mInflater.inflate(alertController.mListLayout, (ViewGroup) null);
            if (alertParams.mIsMultiChoice) {
                arrayAdapter = new ArrayAdapter(contextThemeWrapper2, alertController.mMultiChoiceItemLayout, alertParams.mItems) { // from class: androidx.appcompat.app.AlertController.AlertParams.1
                    @Override // android.widget.ArrayAdapter, android.widget.Adapter
                    public final View getView(int i2, View view2, ViewGroup viewGroup) {
                        View view3 = super.getView(i2, view2, viewGroup);
                        boolean[] zArr = AlertParams.this.mCheckedItems;
                        if (zArr != null && zArr[i2]) {
                            recycleListView.setItemChecked(i2, true);
                        }
                        return view3;
                    }
                };
            } else {
                if (alertParams.mIsSingleChoice) {
                    i = alertController.mSingleChoiceItemLayout;
                } else {
                    i = alertController.mListItemLayout;
                }
                Object obj = alertParams.mAdapter;
                arrayAdapter = obj;
                if (obj == 0) {
                    arrayAdapter = new ArrayAdapter(contextThemeWrapper2, i, 16908308, alertParams.mItems);
                }
            }
            alertController.mAdapter = arrayAdapter;
            alertController.mCheckedItem = alertParams.mCheckedItem;
            if (alertParams.mOnClickListener != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i2, long j) {
                        AlertParams alertParams2 = AlertParams.this;
                        DialogInterface.OnClickListener onClickListener = alertParams2.mOnClickListener;
                        AlertController alertController2 = alertController;
                        onClickListener.onClick(alertController2.mDialog, i2);
                        if (!alertParams2.mIsSingleChoice) {
                            alertController2.mDialog.dismiss();
                        }
                    }
                });
            } else if (alertParams.mOnCheckboxClickListener != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.4
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i2, long j) {
                        AlertParams alertParams2 = AlertParams.this;
                        boolean[] zArr = alertParams2.mCheckedItems;
                        RecycleListView recycleListView2 = recycleListView;
                        if (zArr != null) {
                            zArr[i2] = recycleListView2.isItemChecked(i2);
                        }
                        alertParams2.mOnCheckboxClickListener.onClick(alertController.mDialog, i2, recycleListView2.isItemChecked(i2));
                    }
                });
            }
            if (alertParams.mIsSingleChoice) {
                recycleListView.setChoiceMode(1);
            } else if (alertParams.mIsMultiChoice) {
                recycleListView.setChoiceMode(2);
            }
            alertController.mListView = recycleListView;
        }
        View view2 = alertParams.mView;
        if (view2 != null) {
            alertController.mView = view2;
            alertController.mViewSpacingSpecified = false;
        }
        alertDialog.setCancelable(alertParams.mCancelable);
        if (alertParams.mCancelable) {
            alertDialog.setCanceledOnTouchOutside(true);
        }
        alertDialog.setOnCancelListener(alertParams.mOnCancelListener);
        alertDialog.setOnDismissListener(alertParams.mOnDismissListener);
        MenuDialogHelper menuDialogHelper = alertParams.mOnKeyListener;
        if (menuDialogHelper != null) {
            alertDialog.setOnKeyListener(menuDialogHelper);
        }
        return alertDialog;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(View view) {
        ((BottomSheetBehavior) this.zza).setState(this.zzb);
        return true;
    }

    public void setMessage(int i) {
        AlertController.AlertParams alertParams = (AlertController.AlertParams) this.zza;
        alertParams.mMessage = alertParams.mContext.getText(i);
    }

    public void setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
        AlertController.AlertParams alertParams = (AlertController.AlertParams) this.zza;
        alertParams.mNegativeButtonText = alertParams.mContext.getText(i);
        alertParams.mNegativeButtonListener = onClickListener;
    }

    public void setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
        AlertController.AlertParams alertParams = (AlertController.AlertParams) this.zza;
        alertParams.mNeutralButtonText = alertParams.mContext.getText(i);
        alertParams.mNeutralButtonListener = onClickListener;
    }

    public void setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
        AlertController.AlertParams alertParams = (AlertController.AlertParams) this.zza;
        alertParams.mPositiveButtonText = alertParams.mContext.getText(i);
        alertParams.mPositiveButtonListener = onClickListener;
    }

    public void setTitle(int i) {
        AlertController.AlertParams alertParams = (AlertController.AlertParams) this.zza;
        alertParams.mTitle = alertParams.mContext.getText(i);
    }

    public AlertDialog show() {
        AlertDialog create = create();
        create.show();
        return create;
    }

    public String zza(zzp zzpVar) {
        String str;
        zzce zzceVar = (zzce) this.zza;
        int i = this.zzb;
        try {
            if (zzceVar.zzc != null) {
                zzau zzauVar = zzceVar.zzc;
                String packageName = zzceVar.zza.getPackageName();
                if (i == 2) {
                    str = "LAUNCH_BILLING_FLOW";
                } else if (i == 3) {
                    str = "ACKNOWLEDGE_PURCHASE";
                } else if (i == 4) {
                    str = "CONSUME_ASYNC";
                } else if (i == 5) {
                    str = "IS_FEATURE_SUPPORTED";
                } else if (i != 6) {
                    str = "QUERY_PRODUCT_DETAILS_ASYNC";
                } else {
                    str = "START_CONNECTION";
                }
                zzcb zzcbVar = new zzcb(zzpVar);
                zzas zzasVar = (zzas) zzauVar;
                Parcel zzs = zzasVar.zzs();
                zzs.writeString(packageName);
                zzs.writeString(str);
                int i2 = zzar.$r8$clinit;
                zzs.writeStrongBinder(zzcbVar);
                zzasVar.zza.transact(1, zzs, null, 1);
                zzs.recycle();
                return "billingOverrideService.getBillingOverride";
            }
            throw null;
        } catch (Exception e) {
            zzceVar.zzaF(95, 28, zzcj.zzF);
            zzc.zzo("BillingClientTesting", "An error occurred while retrieving billing override.", e);
            zzpVar.zzb(0);
            return "billingOverrideService.getBillingOverride";
        }
    }

    public zzbv(ConnectionResult connectionResult, int i) {
        zzah.checkNotNull(connectionResult);
        this.zza = connectionResult;
        this.zzb = i;
    }

    public zzbv(Context context) {
        int resolveDialogTheme = AlertDialog.resolveDialogTheme(context, 0);
        this.zza = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, resolveDialogTheme)));
        this.zzb = resolveDialogTheme;
    }

    public zzbv(int i, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr) {
        this.zzb = i;
        this.zza = fontsContractCompat$FontInfoArr;
    }
}
