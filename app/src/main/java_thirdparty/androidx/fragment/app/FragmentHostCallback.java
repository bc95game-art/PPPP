package androidx.fragment.app;

import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
/* loaded from: classes.dex */
public abstract class FragmentHostCallback extends FragmentContainer {
    public final AppCompatActivity activity;
    public final AppCompatActivity context;
    public final FragmentManagerImpl fragmentManager = new FragmentManager();
    public final Handler handler;

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.fragment.app.FragmentManagerImpl, androidx.fragment.app.FragmentManager] */
    public FragmentHostCallback(AppCompatActivity appCompatActivity) {
        Handler handler = new Handler();
        this.activity = appCompatActivity;
        this.context = appCompatActivity;
        this.handler = handler;
    }
}
