package com.google.android.material.shape;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.material.R$styleable;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
/* loaded from: classes.dex */
public final class StateListSizeChange {
    public ReadonlyStateFlow defaultSizeChange;
    public ReadonlyStateFlow[] sizeChanges;
    public int stateCount;
    public int[][] stateSpecs;

    /* loaded from: classes.dex */
    public final class SizeChangeAmount {
        public final float amount;
        public final int type;

        public SizeChangeAmount(int i, float f) {
            this.type = i;
            this.amount = f;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9  */
    /* JADX WARN: Type inference failed for: r3v5, types: [kotlinx.coroutines.flow.ReadonlyStateFlow, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void loadSizeChangeFromItems(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray typedArray;
        SizeChangeAmount sizeChangeAmount;
        int attributeCount;
        int i;
        int i2;
        int[][] iArr;
        int depth = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next != 1) {
                int depth2 = xmlResourceParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth && xmlResourceParser.getName().equals("item")) {
                    Resources resources = context.getResources();
                    int[] iArr2 = R$styleable.StateListSizeChange;
                    if (theme == null) {
                        typedArray = resources.obtainAttributes(attributeSet, iArr2);
                    } else {
                        typedArray = theme.obtainStyledAttributes(attributeSet, iArr2, 0, 0);
                    }
                    TypedValue peekValue = typedArray.peekValue(0);
                    if (peekValue != null) {
                        int i3 = peekValue.type;
                        if (i3 == 5) {
                            sizeChangeAmount = new SizeChangeAmount(2, TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
                        } else if (i3 == 6) {
                            sizeChangeAmount = new SizeChangeAmount(1, peekValue.getFraction(1.0f, 1.0f));
                        }
                        typedArray.recycle();
                        attributeCount = attributeSet.getAttributeCount();
                        int[] iArr3 = new int[attributeCount];
                        int i4 = 0;
                        for (i = 0; i < attributeCount; i++) {
                            int attributeNameResource = attributeSet.getAttributeNameResource(i);
                            if (attributeNameResource != C0130R.attr.widthChange) {
                                int i5 = i4 + 1;
                                if (!attributeSet.getAttributeBooleanValue(i, false)) {
                                    attributeNameResource = -attributeNameResource;
                                }
                                iArr3[i4] = attributeNameResource;
                                i4 = i5;
                            }
                        }
                        int[] trimStateSet = StateSet.trimStateSet(iArr3, i4);
                        ?? obj = new Object();
                        obj.$$delegate_0 = sizeChangeAmount;
                        i2 = this.stateCount;
                        if (i2 != 0 || trimStateSet.length == 0) {
                            this.defaultSizeChange = obj;
                        }
                        iArr = this.stateSpecs;
                        if (i2 >= iArr.length) {
                            int i6 = i2 + 10;
                            int[][] iArr4 = new int[i6];
                            System.arraycopy(iArr, 0, iArr4, 0, i2);
                            this.stateSpecs = iArr4;
                            ReadonlyStateFlow[] readonlyStateFlowArr = new ReadonlyStateFlow[i6];
                            System.arraycopy(this.sizeChanges, 0, readonlyStateFlowArr, 0, i2);
                            this.sizeChanges = readonlyStateFlowArr;
                        }
                        int[][] iArr5 = this.stateSpecs;
                        int i7 = this.stateCount;
                        iArr5[i7] = trimStateSet;
                        this.sizeChanges[i7] = obj;
                        this.stateCount = i7 + 1;
                    }
                    sizeChangeAmount = null;
                    typedArray.recycle();
                    attributeCount = attributeSet.getAttributeCount();
                    int[] iArr32 = new int[attributeCount];
                    int i42 = 0;
                    while (i < attributeCount) {
                    }
                    int[] trimStateSet2 = StateSet.trimStateSet(iArr32, i42);
                    ?? obj2 = new Object();
                    obj2.$$delegate_0 = sizeChangeAmount;
                    i2 = this.stateCount;
                    if (i2 != 0) {
                    }
                    this.defaultSizeChange = obj2;
                    iArr = this.stateSpecs;
                    if (i2 >= iArr.length) {
                    }
                    int[][] iArr52 = this.stateSpecs;
                    int i72 = this.stateCount;
                    iArr52[i72] = trimStateSet2;
                    this.sizeChanges[i72] = obj2;
                    this.stateCount = i72 + 1;
                }
            } else {
                return;
            }
        }
    }
}
