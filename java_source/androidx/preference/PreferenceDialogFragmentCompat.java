package androidx.preference;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.android.billingclient.api.zzbv;
/* loaded from: classes.dex */
public abstract class PreferenceDialogFragmentCompat extends DialogFragment implements DialogInterface.OnClickListener {
    public BitmapDrawable mDialogIcon;
    public int mDialogLayoutRes;
    public CharSequence mDialogMessage;
    public CharSequence mDialogTitle;
    public CharSequence mNegativeButtonText;
    public CharSequence mPositiveButtonText;
    public DialogPreference mPreference;
    public int mWhichButtonClicked;

    /* loaded from: classes.dex */
    public abstract class Api30Impl {
        public static void showIme(Window window) {
            window.getDecorView().getWindowInsetsController().show(WindowInsets.Type.ime());
        }
    }

    public final DialogPreference getPreference() {
        if (this.mPreference == null) {
            this.mPreference = (DialogPreference) ((PreferenceFragmentCompat) getTargetFragment()).findPreference(requireArguments().getString("key"));
        }
        return this.mPreference;
    }

    public void onBindDialogView(View view) {
        int i;
        View findViewById = view.findViewById(16908299);
        if (findViewById != null) {
            CharSequence charSequence = this.mDialogMessage;
            if (!TextUtils.isEmpty(charSequence)) {
                if (findViewById instanceof TextView) {
                    ((TextView) findViewById).setText(charSequence);
                }
                i = 0;
            } else {
                i = 8;
            }
            if (findViewById.getVisibility() != i) {
                findViewById.setVisibility(i);
            }
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mWhichButtonClicked = i;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment targetFragment = getTargetFragment();
        if (targetFragment instanceof PreferenceFragmentCompat) {
            PreferenceFragmentCompat preferenceFragmentCompat = (PreferenceFragmentCompat) targetFragment;
            String string = requireArguments().getString("key");
            if (bundle == null) {
                DialogPreference dialogPreference = (DialogPreference) preferenceFragmentCompat.findPreference(string);
                this.mPreference = dialogPreference;
                this.mDialogTitle = dialogPreference.mDialogTitle;
                this.mPositiveButtonText = dialogPreference.mPositiveButtonText;
                this.mNegativeButtonText = dialogPreference.mNegativeButtonText;
                this.mDialogMessage = dialogPreference.mDialogMessage;
                this.mDialogLayoutRes = dialogPreference.mDialogLayoutResId;
                Drawable drawable = dialogPreference.mDialogIcon;
                if (drawable == null || (drawable instanceof BitmapDrawable)) {
                    this.mDialogIcon = (BitmapDrawable) drawable;
                    return;
                }
                Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                this.mDialogIcon = new BitmapDrawable(getResources(), createBitmap);
                return;
            }
            this.mDialogTitle = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.mPositiveButtonText = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.mNegativeButtonText = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.mDialogMessage = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.mDialogLayoutRes = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.mDialogIcon = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            return;
        }
        throw new IllegalStateException("Target fragment must implement TargetFragment interface");
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog() {
        this.mWhichButtonClicked = -2;
        zzbv zzbvVar = new zzbv(requireContext());
        CharSequence charSequence = this.mDialogTitle;
        AlertController.AlertParams alertParams = (AlertController.AlertParams) zzbvVar.zza;
        alertParams.mTitle = charSequence;
        alertParams.mIcon = this.mDialogIcon;
        alertParams.mPositiveButtonText = this.mPositiveButtonText;
        alertParams.mPositiveButtonListener = this;
        alertParams.mNegativeButtonText = this.mNegativeButtonText;
        alertParams.mNegativeButtonListener = this;
        requireContext();
        int i = this.mDialogLayoutRes;
        View view = null;
        if (i != 0) {
            view = getLayoutInflater().inflate(i, (ViewGroup) null);
        }
        if (view != null) {
            onBindDialogView(view);
            alertParams.mView = view;
        } else {
            alertParams.mMessage = this.mDialogMessage;
        }
        onPrepareDialogBuilder(zzbvVar);
        AlertDialog create = zzbvVar.create();
        if (this instanceof EditTextPreferenceDialogFragmentCompat) {
            Window window = create.getWindow();
            if (Build.VERSION.SDK_INT >= 30) {
                Api30Impl.showIme(window);
                return create;
            }
            EditTextPreferenceDialogFragmentCompat editTextPreferenceDialogFragmentCompat = (EditTextPreferenceDialogFragmentCompat) this;
            editTextPreferenceDialogFragmentCompat.mShowRequestTime = SystemClock.currentThreadTimeMillis();
            editTextPreferenceDialogFragmentCompat.scheduleShowSoftInputInner();
        }
        return create;
    }

    public abstract void onDialogClosed(boolean z);

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        boolean z;
        super.onDismiss(dialogInterface);
        if (this.mWhichButtonClicked == -1) {
            z = true;
        } else {
            z = false;
        }
        onDialogClosed(z);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.mDialogTitle);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.mPositiveButtonText);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.mNegativeButtonText);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.mDialogMessage);
        bundle.putInt("PreferenceDialogFragment.layout", this.mDialogLayoutRes);
        BitmapDrawable bitmapDrawable = this.mDialogIcon;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    public void onPrepareDialogBuilder(zzbv zzbvVar) {
    }
}
