package com.emanuelef.remote_capture.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.preference.PreferenceManager;
import com.emanuelef.remote_capture.adapters.PrefSpinnerAdapter;
/* loaded from: classes.dex */
public class PrefSpinner implements AdapterView.OnItemSelectedListener {
    private final PrefSpinnerAdapter mAdapter;
    private final String mPrefKey;
    private final SharedPreferences mPrefs;

    private PrefSpinner(Spinner spinner, int i, int i2, int i3, String str, String str2) {
        Context context = spinner.getContext();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.mPrefs = defaultSharedPreferences;
        this.mPrefKey = str;
        PrefSpinnerAdapter prefSpinnerAdapter = new PrefSpinnerAdapter(context, i, i2, i3);
        this.mAdapter = prefSpinnerAdapter;
        int modePos = prefSpinnerAdapter.getModePos(defaultSharedPreferences.getString(str, str2));
        spinner.setAdapter((SpinnerAdapter) prefSpinnerAdapter);
        spinner.setSelection(modePos);
        spinner.setOnItemSelectedListener(this);
    }

    public static void init(Spinner spinner, int i, int i2, int i3, String str, String str2) {
        new PrefSpinner(spinner, i, i2, i3, str, str2);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        SharedPreferences.Editor edit = this.mPrefs.edit();
        edit.putString(this.mPrefKey, ((PrefSpinnerAdapter.ModeInfo) this.mAdapter.getItem(i)).key);
        edit.apply();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
