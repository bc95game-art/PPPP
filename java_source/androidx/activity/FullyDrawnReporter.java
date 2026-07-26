package androidx.activity;

import androidx.activity.ComponentActivity;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class FullyDrawnReporter {
    public final Object lock = new Object();
    public final ArrayList onReportCallbacks = new ArrayList();
    public boolean reportedFullyDrawn;

    public FullyDrawnReporter(ComponentActivity.ReportFullyDrawnExecutorApi16Impl reportFullyDrawnExecutorApi16Impl, ComponentActivity$$ExternalSyntheticLambda1 componentActivity$$ExternalSyntheticLambda1) {
    }
}
