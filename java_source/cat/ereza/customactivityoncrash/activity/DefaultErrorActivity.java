package cat.ereza.customactivityoncrash.activity;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cat.ereza.customactivityoncrash.R$styleable;
import cat.ereza.customactivityoncrash.config.CaocConfig;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.fragments.AppOverview$$ExternalSyntheticLambda0;
/* loaded from: classes.dex */
public final class DefaultErrorActivity extends AppCompatActivity {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedArray obtainStyledAttributes = obtainStyledAttributes(R$styleable.AppCompatTheme);
        if (!obtainStyledAttributes.hasValue(117)) {
            setTheme(2132083345);
        }
        obtainStyledAttributes.recycle();
        setContentView(C0130R.layout.customactivityoncrash_default_error_activity);
        Button button = (Button) findViewById(C0130R.C0132id.customactivityoncrash_error_activity_restart_button);
        CaocConfig configFromIntent = CustomActivityOnCrash.getConfigFromIntent(getIntent());
        if (configFromIntent == null) {
            finish();
            return;
        }
        if (configFromIntent.restartActivityClass != null) {
            button.setText(C0130R.string.customactivityoncrash_error_activity_restart_app);
            button.setOnClickListener(new AppOverview$$ExternalSyntheticLambda0(this, 1, configFromIntent));
        } else {
            button.setOnClickListener(new DefaultErrorActivity$$ExternalSyntheticLambda1(this, configFromIntent));
        }
        ((Button) findViewById(C0130R.C0132id.customactivityoncrash_error_activity_more_info_button)).setOnClickListener(new DefaultErrorActivity$$ExternalSyntheticLambda1(this));
        Integer num = configFromIntent.errorDrawable;
        ImageView imageView = (ImageView) findViewById(C0130R.C0132id.customactivityoncrash_error_activity_image);
        if (num != null) {
            Resources resources = getResources();
            int intValue = num.intValue();
            Resources.Theme theme = getTheme();
            ThreadLocal threadLocal = ResourcesCompat.sTempTypedValue;
            imageView.setImageDrawable(ResourcesCompat.Api21Impl.getDrawable(resources, intValue, theme));
        }
    }
}
