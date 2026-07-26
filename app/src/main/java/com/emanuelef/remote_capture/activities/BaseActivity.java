package com.emanuelef.remote_capture.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.Utils;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class BaseActivity extends AppCompatActivity {
    private boolean mBackAction = false;

    public static /* synthetic */ WindowInsetsCompat $r8$lambda$pdUnoclZ50V6eRuLbvymfX9cekI(View view, WindowInsetsCompat windowInsetsCompat) {
        return lambda$setContentView$0(view, windowInsetsCompat);
    }

    public static WindowInsetsCompat lambda$setContentView$0(View view, WindowInsetsCompat windowInsetsCompat) {
        int i = windowInsetsCompat.mImpl.getInsets(135).top;
        if (i > 0) {
            view.setPadding(0, i, 0, 0);
        }
        return windowInsetsCompat;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        applyOverrideConfiguration(Utils.getLocalizedConfig(context));
        super.attachBaseContext(context);
    }

    public void displayBackAction() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            this.mBackAction = true;
        }
    }

    public Fragment getFragment(Class cls) {
        for (Fragment fragment : getSupportFragmentManager().mFragmentStore.getFragments()) {
            if (cls.isInstance(fragment)) {
                return fragment;
            }
        }
        return null;
    }

    public Fragment getFragmentAtPos(int i) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        return supportFragmentManager.findFragmentByTag("f" + i);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Utils.enableEdgeToEdge(this);
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (!this.mBackAction || menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        super.setContentView(i);
        View findViewById = findViewById(C0130R.C0132id.toolbar);
        if (findViewById != null) {
            BaseActivity$$ExternalSyntheticLambda0 baseActivity$$ExternalSyntheticLambda0 = new BaseActivity$$ExternalSyntheticLambda0(0);
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(findViewById, baseActivity$$ExternalSyntheticLambda0);
        }
    }
}
