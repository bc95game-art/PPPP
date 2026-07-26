package com.emanuelef.remote_capture.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.p002os.BundleKt;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import com.emanuelef.remote_capture.Billing;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.model.Prefs;
import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroBaseFragment;
import com.github.appintro.model.SliderPagerBuilder;
/* loaded from: classes.dex */
public class OnBoardingActivity extends AppIntro {
    public static final String ENABLE_BACK_BUTTON = "back_enabled";
    private static final String TAG = "OnBoardingActivity";

    /* loaded from: classes.dex */
    public static class OnBoardingFragment extends AppIntroBaseFragment {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public static OnBoardingFragment createInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z) {
            OnBoardingFragment onBoardingFragment = new OnBoardingFragment();
            Bundle bundle = new SliderPagerBuilder().title(charSequence).imageDrawable(i).backgroundColorRes(C0130R.color.backgroundColor).titleColorRes(C0130R.color.colorAccent).descriptionColorRes(C0130R.color.colorTabText).build().toBundle();
            bundle.putCharSequence("pd_descr", charSequence2);
            bundle.putInt("pd_image_tint", i2);
            bundle.putBoolean("pd_image_autosz", z);
            onBoardingFragment.setArguments(bundle);
            return onBoardingFragment;
        }

        @Override // com.github.appintro.AppIntroBaseFragment
        public int getLayoutId() {
            return C0130R.layout.appintro_fragment_intro;
        }

        @Override // com.github.appintro.AppIntroBaseFragment, androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            if (onCreateView == null) {
                return null;
            }
            Bundle arguments = getArguments();
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            TextView textView = (TextView) onCreateView.findViewById(C0130R.C0132id.description);
            textView.setAutoLinkMask(0);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(arguments.getCharSequence("pd_descr"));
            textView.setGravity(8388627);
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                if (i >= 27) {
                    TextViewCompat.Api26Impl.setAutoSizeTextTypeWithDefaults(textView, 0);
                } else if (textView instanceof AutoSizeableTextView) {
                    ((AutoSizeableTextView) textView).setAutoSizeTextTypeWithDefaults(0);
                }
            }
            textView.setTextSize(2, 14.0f);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, (int) TypedValue.applyDimension(1, 10.0f, displayMetrics), 0, 0);
                textView.setPadding(textView.getPaddingLeft(), 0, textView.getPaddingRight(), 0);
                textView.setLayoutParams(layoutParams2);
            }
            ImageView imageView = (ImageView) onCreateView.findViewById(C0130R.C0132id.image);
            int i2 = arguments.getInt("pd_image_tint");
            if (i2 > 0) {
                imageView.setColorFilter(BundleKt.getColor(onCreateView.getContext(), i2));
            }
            if (arguments.getBoolean("pd_image_autosz")) {
                imageView.setAdjustViewBounds(true);
                imageView.getLayoutParams().height = (int) TypedValue.applyDimension(1, 120.0f, displayMetrics);
            }
            return onCreateView;
        }
    }

    private void runMainActivity() {
        Prefs.refreshAppVersion(getSharedPreferences(PreferenceManager.getDefaultSharedPreferencesName(this), 0));
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
        finish();
    }

    @Override // com.github.appintro.AppIntroBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        PlayBilling newInstance = Billing.newInstance(this);
        setImmersiveMode();
        Intent intent = getIntent();
        if (intent != null) {
            z = intent.getBooleanExtra(ENABLE_BACK_BUTTON, false);
        } else {
            z = false;
        }
        addSlide(OnBoardingFragment.createInstance(getString(C0130R.string.welcome_to_pcapdroid), getText(C0130R.string.app_intro_welcome_msg), C0130R.C0131drawable.ic_logo, C0130R.color.colorAccent, true));
        addSlide(OnBoardingFragment.createInstance(getString(C0130R.string.privacy_first), Utils.getText(this, C0130R.string.app_intro_privacy_msg, MainActivity.PRIVACY_POLICY_URL, MainActivity.GITHUB_PROJECT_URL), C0130R.C0131drawable.ic_shield, C0130R.color.colorAccent, true));
        addSlide(OnBoardingFragment.createInstance(getString(C0130R.string.traffic_inspection), Utils.getText(this, C0130R.string.app_intro_traffic_inspection, MainActivity.TLS_DECRYPTION_DOCS_URL), C0130R.C0131drawable.http_inspection, 0, false));
        if (newInstance.isPlayStore()) {
            addSlide(OnBoardingFragment.createInstance(getString(C0130R.string.firewall), Utils.getText(this, C0130R.string.app_intro_firewall_msg, MainActivity.FIREWALL_DOCS_URL), C0130R.C0131drawable.firewall_block, 0, false));
            addSlide(OnBoardingFragment.createInstance(getString(C0130R.string.malware_detection), Utils.getText(this, C0130R.string.app_intro_malware_detection, MainActivity.MALWARE_DETECTION_DOCS_URL), C0130R.C0131drawable.malware_notification, 0, false));
        }
        addSlide(OnBoardingFragment.createInstance(getString(C0130R.string.traffic_dump), Utils.getText(this, C0130R.string.app_intro_traffic_dump, "https://emanuele-f.github.io/PCAPdroid/dump_modes", "https://emanuele-f.github.io/PCAPdroid/advanced_features#45-pcapdroid-extensions"), C0130R.C0131drawable.dump_modes, 0, false));
        addSlide(OnBoardingFragment.createInstance(getString(C0130R.string.country_and_asn), getText(C0130R.string.app_intro_geolocation_msg), C0130R.C0131drawable.ic_location_dot, C0130R.color.colorAccent, true));
        showStatusBar(true);
        setSkipButtonEnabled(true);
        setIndicatorEnabled(true);
        setSystemBackButtonLocked(!z);
        int color = BundleKt.getColor(this, C0130R.color.colorAccent);
        setIndicatorColor(color, BundleKt.getColor(this, C0130R.color.colorAccentLight));
        setBackArrowColor(color);
        setColorSkipButton(color);
        setNextArrowColor(color);
        setBackArrowColor(color);
        setColorDoneText(color);
    }

    @Override // com.github.appintro.AppIntroBase
    public void onDonePressed(Fragment fragment) {
        Log.m587d(TAG, "onDonePressed");
        super.onDonePressed(fragment);
        runMainActivity();
    }

    @Override // com.github.appintro.AppIntroBase
    public void onSkipPressed(Fragment fragment) {
        Log.m587d(TAG, "onSkipPressed");
        super.onSkipPressed(fragment);
        runMainActivity();
    }
}
