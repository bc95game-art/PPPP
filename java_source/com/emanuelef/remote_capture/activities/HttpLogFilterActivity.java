package com.emanuelef.remote_capture.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.collection.ArraySet;
import androidx.core.provider.FontProvider$$ExternalSyntheticLambda0;
import androidx.core.view.MenuProvider;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.HttpLog;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.model.HttpLogFilterDescriptor;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.slider.Slider;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p004j$.util.List;
/* loaded from: classes.dex */
public class HttpLogFilterActivity extends BaseActivity implements MenuProvider {
    public static final String FILTER_DESCRIPTOR = "http_log_filter";
    private static final String TAG = "HttpLogFilterActivity";
    private ChipGroup mContentTypeGroup;
    private Chip mDecryptionErrorChip;
    private Chip mDecryptionNoErrorChip;
    private HttpLogFilterDescriptor mFilter;
    private ChipGroup mHttpStatusGroup;
    private ChipGroup mMethodGroup;
    private Slider mPayloadSizeSlider;

    private void finishOk() {
        view2model();
        Intent intent = new Intent();
        intent.putExtra(FILTER_DESCRIPTOR, this.mFilter);
        setResult(-1, intent);
        finish();
    }

    public static /* synthetic */ String lambda$onCreate$0(float f) {
        return Utils.formatBytes(f * 1024);
    }

    private void model2view() {
        long j = this.mFilter.minPayloadSize / 1024;
        if (j > 0) {
            this.mPayloadSizeSlider.setValue((float) j);
        }
        Boolean bool = this.mFilter.decryptionError;
        if (bool != null) {
            if (bool.booleanValue()) {
                this.mDecryptionErrorChip.setChecked(true);
            } else {
                this.mDecryptionNoErrorChip.setChecked(true);
            }
        }
        if (this.mFilter.method != null) {
            int childCount = this.mMethodGroup.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                Chip chip = (Chip) this.mMethodGroup.getChildAt(i);
                if (chip.getText().toString().equalsIgnoreCase(this.mFilter.method)) {
                    chip.setChecked(true);
                    break;
                }
                i++;
            }
        }
        if (this.mFilter.contentType != null) {
            int childCount2 = this.mContentTypeGroup.getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount2) {
                    break;
                }
                Chip chip2 = (Chip) this.mContentTypeGroup.getChildAt(i2);
                if (chip2.getText().equals(this.mFilter.contentType)) {
                    chip2.setChecked(true);
                    break;
                }
                i2++;
            }
        }
        if (this.mFilter.httpStatus != null) {
            int childCount3 = this.mHttpStatusGroup.getChildCount();
            for (int i3 = 0; i3 < childCount3; i3++) {
                Chip chip3 = (Chip) this.mHttpStatusGroup.getChildAt(i3);
                if (chip3.getText().equals(String.valueOf(this.mFilter.httpStatus))) {
                    chip3.setChecked(true);
                    return;
                }
            }
        }
    }

    private void view2model() {
        this.mFilter.minPayloadSize = this.mPayloadSizeSlider.getValue() * 1024;
        if (this.mDecryptionErrorChip.isChecked()) {
            this.mFilter.decryptionError = Boolean.TRUE;
        } else if (this.mDecryptionNoErrorChip.isChecked()) {
            this.mFilter.decryptionError = Boolean.FALSE;
        } else {
            this.mFilter.decryptionError = null;
        }
        int childCount = this.mMethodGroup.getChildCount();
        this.mFilter.method = null;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            Chip chip = (Chip) this.mMethodGroup.getChildAt(i);
            if (chip.isChecked()) {
                this.mFilter.method = chip.getText().toString();
                break;
            }
            i++;
        }
        int childCount2 = this.mContentTypeGroup.getChildCount();
        this.mFilter.contentType = null;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount2) {
                break;
            }
            Chip chip2 = (Chip) this.mContentTypeGroup.getChildAt(i2);
            if (chip2.isChecked()) {
                this.mFilter.contentType = chip2.getText().toString();
                break;
            }
            i2++;
        }
        int childCount3 = this.mHttpStatusGroup.getChildCount();
        this.mFilter.httpStatus = null;
        for (int i3 = 0; i3 < childCount3; i3++) {
            Chip chip3 = (Chip) this.mHttpStatusGroup.getChildAt(i3);
            if (chip3.isChecked()) {
                try {
                    this.mFilter.httpStatus = Integer.valueOf(Integer.parseInt(chip3.getText().toString()));
                    return;
                } catch (NumberFormatException unused) {
                    return;
                }
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finishOk();
        super.onBackPressed();
    }

    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        long j;
        HttpLogFilterDescriptor httpLogFilterDescriptor;
        super.onCreate(bundle);
        setContentView(C0130R.layout.http_log_filter_activity);
        setTitle(C0130R.string.edit_filter);
        addMenuProvider(this);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setHomeAsUpIndicator();
        }
        Intent intent = getIntent();
        if (!(intent == null || (httpLogFilterDescriptor = (HttpLogFilterDescriptor) Utils.getSerializableExtra(intent, FILTER_DESCRIPTOR, HttpLogFilterDescriptor.class)) == null)) {
            this.mFilter = httpLogFilterDescriptor;
        }
        if (this.mFilter == null) {
            this.mFilter = new HttpLogFilterDescriptor();
        }
        this.mMethodGroup = (ChipGroup) findViewById(C0130R.C0132id.method_group);
        this.mContentTypeGroup = (ChipGroup) findViewById(C0130R.C0132id.content_type_group);
        this.mHttpStatusGroup = (ChipGroup) findViewById(C0130R.C0132id.http_status_group);
        this.mPayloadSizeSlider = (Slider) findViewById(C0130R.C0132id.payload_size_slider);
        this.mDecryptionErrorChip = (Chip) findViewById(C0130R.C0132id.decryption_error_chip);
        this.mDecryptionNoErrorChip = (Chip) findViewById(C0130R.C0132id.decryption_no_error_chip);
        HttpLog httpLog = CaptureService.getHttpLog();
        if (httpLog != null) {
            ArraySet arraySet = new ArraySet(0);
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            synchronized (httpLog) {
                j = 0;
                for (int i = 0; i < httpLog.getSize(); i++) {
                    try {
                        HttpLog.HttpRequest request = httpLog.getRequest(i);
                        if (request != null) {
                            String str = request.method;
                            if (str != null && !str.isEmpty()) {
                                arraySet.add(request.method.toUpperCase());
                            }
                            HttpLog.HttpReply httpReply = request.reply;
                            if (httpReply != null) {
                                String str2 = httpReply.contentType;
                                if (str2 != null && !str2.isEmpty()) {
                                    hashSet.add(request.reply.contentType);
                                }
                                int i2 = request.reply.responseCode;
                                if (i2 > 0) {
                                    hashSet2.add(Integer.valueOf(i2));
                                }
                                long j2 = request.bodyLength + request.reply.bodyLength;
                                if (j2 > j) {
                                    j = j2;
                                }
                            }
                            request.decryptionError.getClass();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (!arraySet.isEmpty()) {
                LayoutInflater layoutInflater = getLayoutInflater();
                ArrayList arrayList = new ArrayList(arraySet);
                List.EL.sort(arrayList, new FontProvider$$ExternalSyntheticLambda0(1));
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    Chip chip = (Chip) layoutInflater.inflate(C0130R.layout.choice_chip, (ViewGroup) this.mMethodGroup, false);
                    chip.setText((String) obj);
                    this.mMethodGroup.addView(chip);
                }
                this.mMethodGroup.setVisibility(0);
                findViewById(C0130R.C0132id.method_label).setVisibility(0);
            }
            if (!hashSet.isEmpty()) {
                LayoutInflater layoutInflater2 = getLayoutInflater();
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    Chip chip2 = (Chip) layoutInflater2.inflate(C0130R.layout.choice_chip, (ViewGroup) this.mContentTypeGroup, false);
                    chip2.setText((String) it.next());
                    this.mContentTypeGroup.addView(chip2);
                }
                this.mContentTypeGroup.setVisibility(0);
                findViewById(C0130R.C0132id.content_type_label).setVisibility(0);
            }
            if (!hashSet2.isEmpty()) {
                LayoutInflater layoutInflater3 = getLayoutInflater();
                ArrayList arrayList2 = new ArrayList(hashSet2);
                List.EL.sort(arrayList2, new FontProvider$$ExternalSyntheticLambda0(2));
                int size2 = arrayList2.size();
                int i4 = 0;
                while (i4 < size2) {
                    Object obj2 = arrayList2.get(i4);
                    i4++;
                    Chip chip3 = (Chip) layoutInflater3.inflate(C0130R.layout.choice_chip, (ViewGroup) this.mHttpStatusGroup, false);
                    chip3.setText(String.valueOf((Integer) obj2));
                    this.mHttpStatusGroup.addView(chip3);
                }
                this.mHttpStatusGroup.setVisibility(0);
                findViewById(C0130R.C0132id.http_status_label).setVisibility(0);
            }
            long max = Math.max(j / 1024, this.mFilter.minPayloadSize / 1024);
            if (max >= 2) {
                this.mPayloadSizeSlider.setValueTo((float) max);
                this.mPayloadSizeSlider.setLabelFormatter(new BaseActivity$$ExternalSyntheticLambda0(23));
                this.mPayloadSizeSlider.setVisibility(0);
                findViewById(C0130R.C0132id.payload_size_label).setVisibility(0);
            }
        }
        model2view();
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C0130R.C0134menu.edit_filter_menu, menu);
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != C0130R.C0132id.reset_changes) {
            return false;
        }
        this.mFilter.clear();
        model2view();
        return true;
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        finishOk();
        return true;
    }
}
