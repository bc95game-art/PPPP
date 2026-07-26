package kotlin.text;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ClipDescription;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.TooltipPopup;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.PaintCompat;
import androidx.core.p002os.BundleKt;
import androidx.core.provider.FontRequest;
import androidx.core.util.Pair;
import androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl;
import androidx.emoji2.text.DefaultGlyphChecker;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback;
import androidx.emoji2.text.EmojiProcessor$ProcessorSm;
import androidx.emoji2.text.MetadataRepo;
import androidx.emoji2.text.TypefaceEmojiRasterizer;
import androidx.emoji2.text.TypefaceEmojiSpan;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.transition.Transition;
import androidx.transition.ViewUtilsApi21;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.emanuelef.remote_capture.PlayBilling$$ExternalSyntheticLambda23;
import com.google.android.datatransport.AutoValue_Event;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.gms.internal.play_billing.zzbb;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.proto.ProtobufDataEncoderContext;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.zip.Adler32;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import p004j$.util.DesugarCollections;
/* loaded from: classes.dex */
public final class MatcherMatchResult implements ActionBarDrawerToggle.Delegate, InputContentInfoCompat$InputContentInfoCompatImpl, Factory {
    public static MatcherMatchResult sInstance;
    public final /* synthetic */ int $r8$classId;
    public Object groups;
    public Object input;
    public Object matcher;

    public /* synthetic */ MatcherMatchResult(int i) {
        this.$r8$classId = i;
    }

    public static boolean delete(Editable editable, KeyEvent keyEvent, boolean z) {
        TypefaceEmojiSpan[] typefaceEmojiSpanArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (!(selectionStart == -1 || selectionEnd == -1 || selectionStart != selectionEnd || (typefaceEmojiSpanArr = (TypefaceEmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, TypefaceEmojiSpan.class)) == null || typefaceEmojiSpanArr.length <= 0)) {
                for (TypefaceEmojiSpan typefaceEmojiSpan : typefaceEmojiSpanArr) {
                    int spanStart = editable.getSpanStart(typefaceEmojiSpan);
                    int spanEnd = editable.getSpanEnd(typefaceEmojiSpan);
                    if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static MatcherMatchResult obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new MatcherMatchResult(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public AutoValue_TransportContext build() {
        String str;
        if (((String) this.matcher) == null) {
            str = " backendName";
        } else {
            str = "";
        }
        if (((Priority) this.groups) == null) {
            str = str.concat(" priority");
        }
        if (str.isEmpty()) {
            return new AutoValue_TransportContext((String) this.matcher, (byte[]) this.input, (Priority) this.groups);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public void encode(ClientMetrics clientMetrics, ByteArrayOutputStream byteArrayOutputStream) {
        HashMap hashMap = (HashMap) this.matcher;
        ProtobufDataEncoderContext protobufDataEncoderContext = new ProtobufDataEncoderContext(byteArrayOutputStream, hashMap, (HashMap) this.input, (ObjectEncoder) this.groups);
        ObjectEncoder objectEncoder = (ObjectEncoder) hashMap.get(ClientMetrics.class);
        if (objectEncoder != null) {
            objectEncoder.encode(clientMetrics, protobufDataEncoderContext);
            return;
        }
        throw new RuntimeException("No encoder for " + ClientMetrics.class);
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.android.datatransport.runtime.time.Clock, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.google.android.datatransport.runtime.time.Clock, java.lang.Object] */
    @Override // javax.inject.Provider
    public Object get() {
        switch (this.$r8$classId) {
            case 14:
                return new TransportRuntime(new Object(), new Object(), (Scheduler) ((FontRequest) this.matcher).get(), (Uploader) ((TooltipPopup) this.input).get(), (MetadataRepo) ((MetadataRepo) this.groups).get());
            default:
                return new MatcherMatchResult((Context) ((Provider) this.matcher).get(), (EventStore) ((Provider) this.input).get(), (AutoValue_SchedulerConfig) ((Transition.C01101) this.groups).get(), 17);
        }
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public Context getActionBarThemedContext() {
        return ((Toolbar) this.matcher).getContext();
    }

    public ColorStateList getColorStateList(int i) {
        int resourceId;
        ColorStateList colorStateList;
        TypedArray typedArray = (TypedArray) this.input;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateList = BundleKt.getColorStateList((Context) this.matcher, resourceId)) == null) {
            return typedArray.getColorStateList(i);
        }
        return colorStateList;
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public Uri getContentUri() {
        return (Uri) this.matcher;
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public ClipDescription getDescription() {
        return (ClipDescription) this.input;
    }

    public Drawable getDrawable(int i) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.input;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return typedArray.getDrawable(i);
        }
        return BundleKt.getDrawable((Context) this.matcher, resourceId);
    }

    public Drawable getDrawableIfKnown(int i) {
        int resourceId;
        Drawable drawable;
        if (!((TypedArray) this.input).hasValue(i) || (resourceId = ((TypedArray) this.input).getResourceId(i, 0)) == 0) {
            return null;
        }
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        Context context = (Context) this.matcher;
        synchronized (appCompatDrawableManager) {
            drawable = appCompatDrawableManager.mResourceManager.getDrawable(context, resourceId, true);
        }
        return drawable;
    }

    public Typeface getFont(int i, int i2, AppCompatTextHelper.C00271 r12) {
        int resourceId = ((TypedArray) this.input).getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.groups) == null) {
            this.groups = new TypedValue();
        }
        Context context = (Context) this.matcher;
        TypedValue typedValue = (TypedValue) this.groups;
        ThreadLocal threadLocal = ResourcesCompat.sTempTypedValue;
        if (context.isRestricted()) {
            return null;
        }
        return ResourcesCompat.loadFont(context, resourceId, typedValue, i2, r12, true, false);
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public Object getInputContentInfo() {
        return null;
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public Uri getLinkUri() {
        return (Uri) this.groups;
    }

    public IntRange getRange() {
        Matcher matcher = (Matcher) this.matcher;
        return RangesKt.until(matcher.start(), matcher.end());
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public Drawable getThemeUpIndicator() {
        return (Drawable) this.groups;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bc, code lost:
        if (r6 >= r7) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean hasGlyph(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        short s;
        boolean z;
        int i3;
        if ((typefaceEmojiRasterizer.mCache & 3) == 0) {
            EmojiCompat.GlyphChecker glyphChecker = (EmojiCompat.GlyphChecker) this.groups;
            MetadataItem metadataItem = typefaceEmojiRasterizer.getMetadataItem();
            int __offset = metadataItem.__offset(8);
            if (__offset != 0) {
                s = ((ByteBuffer) metadataItem.f9bb).getShort(__offset + metadataItem.bb_pos);
            } else {
                s = 0;
            }
            DefaultGlyphChecker defaultGlyphChecker = (DefaultGlyphChecker) glyphChecker;
            defaultGlyphChecker.getClass();
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 23 || s <= i4) {
                ThreadLocal threadLocal = DefaultGlyphChecker.sStringBuilder;
                if (threadLocal.get() == null) {
                    threadLocal.set(new StringBuilder());
                }
                StringBuilder sb = (StringBuilder) threadLocal.get();
                sb.setLength(0);
                while (i < i2) {
                    sb.append(charSequence.charAt(i));
                    i++;
                }
                TextPaint textPaint = defaultGlyphChecker.mTextPaint;
                String sb2 = sb.toString();
                ThreadLocal threadLocal2 = PaintCompat.sRectThreadLocal;
                if (Build.VERSION.SDK_INT >= 23) {
                    z = PaintCompat.Api23Impl.hasGlyph(textPaint, sb2);
                } else {
                    int length = sb2.length();
                    if (length != 1 || !Character.isWhitespace(sb2.charAt(0))) {
                        float measureText = textPaint.measureText("\udfffd");
                        float measureText2 = textPaint.measureText("m");
                        float measureText3 = textPaint.measureText(sb2);
                        float f = 0.0f;
                        if (measureText3 != 0.0f) {
                            if (sb2.codePointCount(0, sb2.length()) > 1) {
                                if (measureText3 <= measureText2 * 2.0f) {
                                    int i5 = 0;
                                    while (i5 < length) {
                                        int charCount = Character.charCount(sb2.codePointAt(i5)) + i5;
                                        f += textPaint.measureText(sb2, i5, charCount);
                                        i5 = charCount;
                                    }
                                }
                            }
                            if (measureText3 == measureText) {
                                ThreadLocal threadLocal3 = PaintCompat.sRectThreadLocal;
                                Pair pair = (Pair) threadLocal3.get();
                                if (pair == null) {
                                    pair = new Pair(new Rect(), new Rect());
                                    threadLocal3.set(pair);
                                } else {
                                    pair.first.setEmpty();
                                    pair.second.setEmpty();
                                }
                                Rect rect = pair.second;
                                Rect rect2 = pair.first;
                                textPaint.getTextBounds("\udfffd", 0, 2, rect2);
                                textPaint.getTextBounds(sb2, 0, length, rect);
                                z = !rect2.equals(rect);
                            }
                        }
                    }
                    z = true;
                }
                int i6 = typefaceEmojiRasterizer.mCache & 4;
                if (!z) {
                    i3 = i6 | 2;
                } else {
                    i3 = i6 | 1;
                }
                typefaceEmojiRasterizer.mCache = i3;
            }
            z = false;
            int i62 = typefaceEmojiRasterizer.mCache & 4;
            if (!z) {
            }
            typefaceEmojiRasterizer.mCache = i3;
        }
        if ((typefaceEmojiRasterizer.mCache & 3) == 2) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public boolean isNavigationVisible() {
        return true;
    }

    public boolean measure(int i, ConstraintWidget constraintWidget, ConstraintLayout.Measurer measurer) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        BasicMeasure$Measure basicMeasure$Measure = (BasicMeasure$Measure) this.input;
        int[] iArr = constraintWidget.mListDimensionBehaviors;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        basicMeasure$Measure.horizontalBehavior = iArr[0];
        basicMeasure$Measure.verticalBehavior = iArr[1];
        basicMeasure$Measure.horizontalDimension = constraintWidget.getWidth();
        basicMeasure$Measure.verticalDimension = constraintWidget.getHeight();
        basicMeasure$Measure.measuredNeedsSolverPass = false;
        basicMeasure$Measure.measureStrategy = i;
        if (basicMeasure$Measure.horizontalBehavior == 3) {
            z = true;
        } else {
            z = false;
        }
        if (basicMeasure$Measure.verticalBehavior == 3) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z || constraintWidget.mDimensionRatio <= 0.0f) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z2 || constraintWidget.mDimensionRatio <= 0.0f) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z3 && iArr2[0] == 4) {
            basicMeasure$Measure.horizontalBehavior = 1;
        }
        if (z4 && iArr2[1] == 4) {
            basicMeasure$Measure.verticalBehavior = 1;
        }
        measurer.measure(constraintWidget, basicMeasure$Measure);
        constraintWidget.setWidth(basicMeasure$Measure.measuredWidth);
        constraintWidget.setHeight(basicMeasure$Measure.measuredHeight);
        constraintWidget.mHasBaseline = basicMeasure$Measure.measuredHasBaseline;
        constraintWidget.setBaselineDistance(basicMeasure$Measure.measuredBaseline);
        basicMeasure$Measure.measureStrategy = 0;
        return basicMeasure$Measure.measuredNeedsSolverPass;
    }

    public MatcherMatchResult next() {
        int i;
        CharSequence charSequence = (CharSequence) this.input;
        Matcher matcher = (Matcher) this.matcher;
        int end = matcher.end();
        if (matcher.end() == matcher.start()) {
            i = 1;
        } else {
            i = 0;
        }
        int i2 = end + i;
        if (i2 > charSequence.length()) {
            return null;
        }
        Matcher matcher2 = matcher.pattern().matcher(charSequence);
        Intrinsics.checkNotNullExpressionValue(matcher2, "matcher(...)");
        if (!matcher2.find(i2)) {
            return null;
        }
        return new MatcherMatchResult(matcher2, charSequence);
    }

    public Object process(CharSequence charSequence, int i, int i2, int i3, boolean z, EmojiProcessor$EmojiProcessCallback emojiProcessor$EmojiProcessCallback) {
        MetadataRepo.Node node;
        char c;
        EmojiProcessor$ProcessorSm emojiProcessor$ProcessorSm = new EmojiProcessor$ProcessorSm((MetadataRepo.Node) ((MetadataRepo) this.input).mRootNode);
        int i4 = i;
        int codePointAt = Character.codePointAt(charSequence, i);
        int i5 = 0;
        boolean z2 = true;
        int i6 = i4;
        while (i6 < i2 && i5 < i3 && z2) {
            SparseArray sparseArray = emojiProcessor$ProcessorSm.mCurrentNode.mChildren;
            if (sparseArray == null) {
                node = null;
            } else {
                node = (MetadataRepo.Node) sparseArray.get(codePointAt);
            }
            if (emojiProcessor$ProcessorSm.mState == 2) {
                if (node != null) {
                    emojiProcessor$ProcessorSm.mCurrentNode = node;
                    emojiProcessor$ProcessorSm.mCurrentDepth++;
                } else {
                    if (codePointAt == 65038) {
                        emojiProcessor$ProcessorSm.reset();
                    } else if (codePointAt != 65039) {
                        MetadataRepo.Node node2 = emojiProcessor$ProcessorSm.mCurrentNode;
                        if (node2.mData != null) {
                            if (emojiProcessor$ProcessorSm.mCurrentDepth != 1) {
                                emojiProcessor$ProcessorSm.mFlushNode = node2;
                                emojiProcessor$ProcessorSm.reset();
                            } else if (emojiProcessor$ProcessorSm.shouldUseEmojiPresentationStyleForSingleCodepoint()) {
                                emojiProcessor$ProcessorSm.mFlushNode = emojiProcessor$ProcessorSm.mCurrentNode;
                                emojiProcessor$ProcessorSm.reset();
                            } else {
                                emojiProcessor$ProcessorSm.reset();
                            }
                            c = 3;
                        } else {
                            emojiProcessor$ProcessorSm.reset();
                        }
                    }
                    c = 1;
                }
                c = 2;
            } else if (node == null) {
                emojiProcessor$ProcessorSm.reset();
                c = 1;
            } else {
                emojiProcessor$ProcessorSm.mState = 2;
                emojiProcessor$ProcessorSm.mCurrentNode = node;
                emojiProcessor$ProcessorSm.mCurrentDepth = 1;
                c = 2;
            }
            emojiProcessor$ProcessorSm.mLastCodepoint = codePointAt;
            if (c == 1) {
                i6 = Character.charCount(Character.codePointAt(charSequence, i4)) + i4;
                if (i6 < i2) {
                    codePointAt = Character.codePointAt(charSequence, i6);
                }
            } else if (c == 2) {
                int charCount = Character.charCount(codePointAt) + i6;
                if (charCount < i2) {
                    codePointAt = Character.codePointAt(charSequence, charCount);
                }
                i6 = charCount;
            } else if (c == 3) {
                if (z || !hasGlyph(charSequence, i4, i6, emojiProcessor$ProcessorSm.mFlushNode.mData)) {
                    z2 = emojiProcessor$EmojiProcessCallback.handleEmoji(charSequence, i4, i6, emojiProcessor$ProcessorSm.mFlushNode.mData);
                    i5++;
                }
            }
            i4 = i6;
        }
        if (emojiProcessor$ProcessorSm.mState == 2 && emojiProcessor$ProcessorSm.mCurrentNode.mData != null && ((emojiProcessor$ProcessorSm.mCurrentDepth > 1 || emojiProcessor$ProcessorSm.shouldUseEmojiPresentationStyleForSingleCodepoint()) && i5 < i3 && z2 && (z || !hasGlyph(charSequence, i4, i6, emojiProcessor$ProcessorSm.mCurrentNode.mData)))) {
            emojiProcessor$EmojiProcessCallback.handleEmoji(charSequence, i4, i6, emojiProcessor$ProcessorSm.mCurrentNode.mData);
        }
        return emojiProcessor$EmojiProcessCallback.getResult();
    }

    public void recycle() {
        ((TypedArray) this.input).recycle();
    }

    /* JADX WARN: Finally extract failed */
    public void schedule(AutoValue_TransportContext autoValue_TransportContext, int i, boolean z) {
        Long l;
        char c;
        AutoValue_SchedulerConfig autoValue_SchedulerConfig = (AutoValue_SchedulerConfig) this.groups;
        Context context = (Context) this.matcher;
        ComponentName componentName = new ComponentName(context, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        String str = autoValue_TransportContext.backendName;
        String str2 = autoValue_TransportContext.backendName;
        adler32.update(str.getBytes(Charset.forName("UTF-8")));
        ByteBuffer allocate = ByteBuffer.allocate(4);
        Priority priority = autoValue_TransportContext.priority;
        adler32.update(allocate.putInt(PriorityMapping.toInt(priority)).array());
        byte[] bArr = autoValue_TransportContext.extras;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int i2 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i2 >= i) {
                        Navigation.m590d("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", autoValue_TransportContext);
                        return;
                    }
                }
            }
        }
        Cursor rawQuery = ((SQLiteEventStore) ((EventStore) this.input)).getDb().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str2, String.valueOf(PriorityMapping.toInt(priority))});
        try {
            if (rawQuery.moveToNext()) {
                l = Long.valueOf(rawQuery.getLong(0));
            } else {
                l = 0L;
            }
            rawQuery.close();
            long longValue = l.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            builder.setMinimumLatency(autoValue_SchedulerConfig.getScheduleDelay(priority, longValue, i));
            Set set = ((AutoValue_SchedulerConfig_ConfigValue) autoValue_SchedulerConfig.values.get(priority)).flags;
            if (set.contains(SchedulerConfig$Flag.NETWORK_UNMETERED)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(SchedulerConfig$Flag.DEVICE_CHARGING)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(SchedulerConfig$Flag.DEVICE_IDLE)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i);
            persistableBundle.putString("backendName", str2);
            persistableBundle.putInt("priority", PriorityMapping.toInt(priority));
            if (bArr != null) {
                c = 0;
                persistableBundle.putString("extras", Base64.encodeToString(bArr, 0));
            } else {
                c = 0;
            }
            builder.setExtras(persistableBundle);
            Integer valueOf = Integer.valueOf(value);
            Long valueOf2 = Long.valueOf(autoValue_SchedulerConfig.getScheduleDelay(priority, longValue, i));
            Integer valueOf3 = Integer.valueOf(i);
            Object[] objArr = new Object[5];
            objArr[c] = autoValue_TransportContext;
            objArr[1] = valueOf;
            objArr[2] = valueOf2;
            objArr[3] = l;
            objArr[4] = valueOf3;
            String tag = Navigation.getTag("JobInfoScheduler");
            if (Log.isLoggable(tag, 3)) {
                Log.d(tag, String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr));
            }
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, androidx.appcompat.widget.AppCompatDrawableManager$1] */
    public void send(AutoValue_Event autoValue_Event) {
        TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0 = new TransportImpl$$ExternalSyntheticLambda0(0);
        TransportRuntime transportRuntime = (TransportRuntime) this.groups;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.matcher;
        Scheduler scheduler = transportRuntime.scheduler;
        MatcherMatchResult builder = AutoValue_TransportContext.builder();
        builder.setBackendName(autoValue_TransportContext.backendName);
        builder.groups = Priority.DEFAULT;
        builder.input = autoValue_TransportContext.extras;
        AutoValue_TransportContext build = builder.build();
        ?? obj = new Object();
        obj.TINT_CHECKABLE_BUTTON_LIST = new HashMap();
        obj.COLORFILTER_COLOR_BACKGROUND_MULTIPLY = Long.valueOf(transportRuntime.eventClock.getTime());
        obj.TINT_COLOR_CONTROL_STATE_LIST = Long.valueOf(transportRuntime.uptimeClock.getTime());
        obj.COLORFILTER_TINT_COLOR_CONTROL_NORMAL = "PLAY_BILLING_LIBRARY";
        obj.COLORFILTER_COLOR_CONTROL_ACTIVATED = new EncodedPayload((Encoding) this.input, autoValue_Event.payload.zzM());
        obj.TINT_COLOR_CONTROL_NORMAL = null;
        DefaultScheduler defaultScheduler = (DefaultScheduler) scheduler;
        defaultScheduler.executor.execute(new PlayBilling$$ExternalSyntheticLambda23(defaultScheduler, build, transportImpl$$ExternalSyntheticLambda0, obj.build()));
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public void setActionBarDescription(int i) {
        Toolbar toolbar = (Toolbar) this.matcher;
        if (i == 0) {
            toolbar.setNavigationContentDescription((CharSequence) this.input);
        } else {
            toolbar.setNavigationContentDescription(i);
        }
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public void setActionBarUpIndicator(DrawerArrowDrawable drawerArrowDrawable, int i) {
        ((Toolbar) this.matcher).setNavigationIcon(drawerArrowDrawable);
        setActionBarDescription(i);
    }

    public void setBackendName(String str) {
        if (str != null) {
            this.matcher = str;
            return;
        }
        throw new NullPointerException("Null backendName");
    }

    public void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3) {
        constraintWidgetContainer.getClass();
        int i4 = constraintWidgetContainer.mMinWidth;
        int i5 = constraintWidgetContainer.mMinHeight;
        constraintWidgetContainer.mMinWidth = 0;
        constraintWidgetContainer.mMinHeight = 0;
        constraintWidgetContainer.setWidth(i2);
        constraintWidgetContainer.setHeight(i3);
        if (i4 < 0) {
            constraintWidgetContainer.mMinWidth = 0;
        } else {
            constraintWidgetContainer.mMinWidth = i4;
        }
        if (i5 < 0) {
            constraintWidgetContainer.mMinHeight = 0;
        } else {
            constraintWidgetContainer.mMinHeight = i5;
        }
        ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) this.groups;
        constraintWidgetContainer2.mPass = i;
        constraintWidgetContainer2.layout();
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 8:
                String str = (String) this.groups;
                String str2 = (String) this.input;
                StringBuilder sb = new StringBuilder("NavDeepLinkRequest{");
                Uri uri = (Uri) this.matcher;
                if (uri != null) {
                    sb.append(" uri=");
                    sb.append(String.valueOf(uri));
                }
                if (str2 != null) {
                    sb.append(" action=");
                    sb.append(str2);
                }
                if (str != null) {
                    sb.append(" mimetype=");
                    sb.append(str);
                }
                sb.append(" }");
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                return sb2;
            case 20:
                StringBuilder sb3 = new StringBuilder(32);
                sb3.append((String) this.matcher);
                sb3.append('{');
                zzbb zzbbVar = ((zzbb) this.input).zzb;
                String str3 = "";
                while (zzbbVar != null) {
                    Object obj = zzbbVar.zza;
                    sb3.append(str3);
                    if (obj == null || !obj.getClass().isArray()) {
                        sb3.append(obj);
                    } else {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb3.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                    }
                    zzbbVar = zzbbVar.zzb;
                    str3 = ", ";
                }
                sb3.append('}');
                return sb3.toString();
            default:
                return super.toString();
        }
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer) {
        ArrayList arrayList = (ArrayList) this.matcher;
        arrayList.clear();
        int size = constraintWidgetContainer.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) constraintWidgetContainer.mChildren.get(i);
            int[] iArr = constraintWidget.mListDimensionBehaviors;
            if (iArr[0] == 3 || iArr[1] == 3) {
                arrayList.add(constraintWidget);
            }
        }
        constraintWidgetContainer.mDependencyGraph.mNeedBuildGraph = true;
    }

    public /* synthetic */ MatcherMatchResult(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.matcher = obj;
        this.input = obj2;
        this.groups = obj3;
    }

    public static MatcherMatchResult obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new MatcherMatchResult(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    public MatcherMatchResult(String str) {
        this.$r8$classId = 20;
        Object obj = new Object();
        this.input = obj;
        this.groups = obj;
        this.matcher = str;
    }

    public MatcherMatchResult(Set set, String str, String str2) {
        this.$r8$classId = 19;
        Set unmodifiableSet = set == null ? Collections.EMPTY_SET : DesugarCollections.unmodifiableSet(set);
        Map map = Collections.EMPTY_MAP;
        this.input = str2;
        this.groups = SignInOptions.zaa;
        HashSet hashSet = new HashSet(unmodifiableSet);
        Iterator it = map.values().iterator();
        if (!it.hasNext()) {
            this.matcher = DesugarCollections.unmodifiableSet(hashSet);
            return;
        }
        throw ViewModelProvider.Factory.CC.m592m(it);
    }

    public MatcherMatchResult(AutoValue_TransportContext autoValue_TransportContext, Encoding encoding, Transition.C01101 r3, TransportRuntime transportRuntime) {
        this.$r8$classId = 13;
        this.matcher = autoValue_TransportContext;
        this.input = encoding;
        this.groups = transportRuntime;
    }

    public MatcherMatchResult(NavigationView navigationView) {
        Object obj;
        this.$r8$classId = 21;
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            obj = new Object();
        } else {
            obj = i >= 33 ? new Object() : null;
        }
        this.matcher = obj;
        this.input = navigationView;
        this.groups = navigationView;
    }

    public MatcherMatchResult(Context context, TypedArray typedArray) {
        this.$r8$classId = 3;
        this.matcher = context;
        this.input = typedArray;
    }

    public MatcherMatchResult(Context context, LocationManager locationManager) {
        this.$r8$classId = 2;
        this.groups = new Object();
        this.matcher = context;
        this.input = locationManager;
    }

    public MatcherMatchResult(ConstraintWidgetContainer constraintWidgetContainer) {
        this.$r8$classId = 5;
        this.matcher = new ArrayList();
        this.input = new Object();
        this.groups = constraintWidgetContainer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback, com.android.billingclient.api.ConsumeParams, java.lang.Object] */
    public MatcherMatchResult(MetadataRepo metadataRepo, ViewUtilsApi21 viewUtilsApi21, DefaultGlyphChecker defaultGlyphChecker, Set set) {
        this.$r8$classId = 7;
        this.matcher = viewUtilsApi21;
        this.input = metadataRepo;
        this.groups = defaultGlyphChecker;
        if (!set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                int[] iArr = (int[]) it.next();
                String str = new String(iArr, 0, iArr.length);
                ?? obj = new Object();
                obj.zza = str;
                process(str, 0, str.length(), 1, true, obj);
            }
        }
    }

    public MatcherMatchResult(Matcher matcher, CharSequence input) {
        this.$r8$classId = 0;
        Intrinsics.checkNotNullParameter(input, "input");
        this.matcher = matcher;
        this.input = input;
        this.groups = new MatcherMatchResult$groups$1(this);
    }

    public MatcherMatchResult(FragmentStateAdapter fragmentStateAdapter, Fragment fragment, FrameLayout frameLayout) {
        this.$r8$classId = 9;
        this.groups = fragmentStateAdapter;
        this.matcher = fragment;
        this.input = frameLayout;
    }

    public MatcherMatchResult(Toolbar toolbar) {
        this.$r8$classId = 1;
        this.matcher = toolbar;
        this.groups = toolbar.getNavigationIcon();
        this.input = toolbar.getNavigationContentDescription();
    }

    @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
    public void requestPermission() {
    }
}
