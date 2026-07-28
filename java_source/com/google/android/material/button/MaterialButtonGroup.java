package com.google.android.material.button;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager2.widget.FakeDrag;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.adapters.AppsStatsAdapter$$ExternalSyntheticLambda0;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.StateListCornerSize;
import com.google.android.material.shape.StateListShapeAppearanceModel;
import com.google.android.material.shape.StateListSizeChange;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public abstract class MaterialButtonGroup extends LinearLayout {
    public StateListSizeChange buttonSizeChange;
    public Integer[] childOrder;
    public final AppsStatsAdapter$$ExternalSyntheticLambda0 childOrderComparator;
    public StateListShapeAppearanceModel groupStateListShapeAppearance;
    public StateListCornerSize innerCornerSize;
    public final FakeDrag pressedStateTracker;
    public int spacing;
    public final ArrayList originalChildShapeAppearanceModels = new ArrayList();
    public final ArrayList originalChildStateListShapeAppearanceModels = new ArrayList();
    public boolean childShapesDirty = true;

    /* JADX WARN: Type inference failed for: r0v22, types: [java.lang.Object, com.google.android.material.shape.StateListSizeChange] */
    public MaterialButtonGroup(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, C0130R.attr.materialButtonToggleGroupStyle, C0130R.style.Widget_Material3_MaterialButtonGroup), attributeSet, C0130R.attr.materialButtonToggleGroupStyle);
        StateListCornerSize stateListCornerSize;
        int next;
        StateListSizeChange stateListSizeChange;
        XmlResourceParser xml;
        ?? obj;
        AttributeSet asAttributeSet;
        int next2;
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this;
        this.pressedStateTracker = new FakeDrag(28, materialButtonToggleGroup);
        this.childOrderComparator = new AppsStatsAdapter$$ExternalSyntheticLambda0(2, materialButtonToggleGroup);
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ViewUtils.obtainStyledAttributes(context2, attributeSet, R$styleable.MaterialButtonGroup, C0130R.attr.materialButtonToggleGroupStyle, C0130R.style.Widget_Material3_MaterialButtonGroup, new int[0]);
        StateListShapeAppearanceModel stateListShapeAppearanceModel = null;
        if (obtainStyledAttributes.hasValue(2)) {
            int resourceId = obtainStyledAttributes.getResourceId(2, 0);
            if (resourceId != 0 && context2.getResources().getResourceTypeName(resourceId).equals("xml")) {
                try {
                    xml = context2.getResources().getXml(resourceId);
                    obj = new Object();
                    obj.stateSpecs = new int[10];
                    obj.sizeChanges = new ReadonlyStateFlow[10];
                    asAttributeSet = Xml.asAttributeSet(xml);
                    while (true) {
                        next2 = xml.next();
                        if (next2 == 2 || next2 == 1) {
                            break;
                        }
                    }
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
                }
                if (next2 == 2) {
                    if (xml.getName().equals("selector")) {
                        obj.loadSizeChangeFromItems(context2, xml, asAttributeSet, context2.getTheme());
                    }
                    xml.close();
                    stateListSizeChange = obj;
                    this.buttonSizeChange = stateListSizeChange;
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            }
            stateListSizeChange = null;
            this.buttonSizeChange = stateListSizeChange;
        }
        if (obtainStyledAttributes.hasValue(4)) {
            StateListShapeAppearanceModel create = StateListShapeAppearanceModel.create(context2, obtainStyledAttributes, 4);
            this.groupStateListShapeAppearance = create;
            if (create == null) {
                StateListShapeAppearanceModel.Builder builder = new StateListShapeAppearanceModel.Builder(ShapeAppearanceModel.builder(context2, obtainStyledAttributes.getResourceId(4, 0), obtainStyledAttributes.getResourceId(5, 0)).build());
                this.groupStateListShapeAppearance = builder.stateCount != 0 ? new StateListShapeAppearanceModel(builder) : stateListShapeAppearanceModel;
            }
        }
        if (obtainStyledAttributes.hasValue(3)) {
            AbsoluteCornerSize absoluteCornerSize = new AbsoluteCornerSize(0.0f);
            int resourceId2 = obtainStyledAttributes.getResourceId(3, 0);
            if (resourceId2 == 0) {
                stateListCornerSize = StateListCornerSize.create(ShapeAppearanceModel.getCornerSize(obtainStyledAttributes, 3, absoluteCornerSize));
            } else if (!context2.getResources().getResourceTypeName(resourceId2).equals("xml")) {
                stateListCornerSize = StateListCornerSize.create(ShapeAppearanceModel.getCornerSize(obtainStyledAttributes, 3, absoluteCornerSize));
            } else {
                try {
                    XmlResourceParser xml2 = context2.getResources().getXml(resourceId2);
                    stateListCornerSize = new StateListCornerSize();
                    AttributeSet asAttributeSet2 = Xml.asAttributeSet(xml2);
                    while (true) {
                        next = xml2.next();
                        if (next == 2 || next == 1) {
                            break;
                        }
                    }
                    if (next == 2) {
                        if (xml2.getName().equals("selector")) {
                            stateListCornerSize.loadCornerSizesFromItems(context2, xml2, asAttributeSet2, context2.getTheme());
                        }
                        xml2.close();
                    } else {
                        throw new XmlPullParserException("No start tag found");
                    }
                } catch (Resources.NotFoundException | IOException | XmlPullParserException unused2) {
                    stateListCornerSize = StateListCornerSize.create(absoluteCornerSize);
                }
            }
            this.innerCornerSize = stateListCornerSize;
        }
        this.spacing = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (isChildVisible$1(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (isChildVisible$1(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(View.generateViewId());
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonGroup", "Child views must be of type MaterialButton.");
            return;
        }
        recoverAllChildrenLayoutParams();
        this.childShapesDirty = true;
        super.addView(view, i, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        materialButton.setOnPressedChangeListenerInternal(this.pressedStateTracker);
        this.originalChildShapeAppearanceModels.add(materialButton.getShapeAppearanceModel());
        this.originalChildStateListShapeAppearanceModels.add(materialButton.getStateListShapeAppearanceModel());
        materialButton.setEnabled(isEnabled());
    }

    public final void adjustChildMarginsAndUpdateLayout() {
        int i;
        LinearLayout.LayoutParams layoutParams;
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex != -1) {
            for (int i2 = firstVisibleChildIndex + 1; i2 < getChildCount(); i2++) {
                MaterialButton materialButton = (MaterialButton) getChildAt(i2);
                MaterialButton materialButton2 = (MaterialButton) getChildAt(i2 - 1);
                if (this.spacing <= 0) {
                    i = Math.min(materialButton.getStrokeWidth(), materialButton2.getStrokeWidth());
                    materialButton.setShouldDrawSurfaceColorStroke(true);
                    materialButton2.setShouldDrawSurfaceColorStroke(true);
                } else {
                    materialButton.setShouldDrawSurfaceColorStroke(false);
                    materialButton2.setShouldDrawSurfaceColorStroke(false);
                    i = 0;
                }
                ViewGroup.LayoutParams layoutParams2 = materialButton.getLayoutParams();
                if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                    layoutParams = (LinearLayout.LayoutParams) layoutParams2;
                } else {
                    layoutParams = new LinearLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
                }
                if (getOrientation() == 0) {
                    layoutParams.setMarginEnd(0);
                    layoutParams.setMarginStart(this.spacing - i);
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = this.spacing - i;
                    layoutParams.setMarginStart(0);
                }
                materialButton.setLayoutParams(layoutParams);
            }
            if (!(getChildCount() == 0 || firstVisibleChildIndex == -1)) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
                if (getOrientation() == 1) {
                    layoutParams3.topMargin = 0;
                    layoutParams3.bottomMargin = 0;
                    return;
                }
                layoutParams3.setMarginEnd(0);
                layoutParams3.setMarginStart(0);
                layoutParams3.leftMargin = 0;
                layoutParams3.rightMargin = 0;
            }
        }
    }

    public final void adjustChildSizeChange() {
        int i;
        MaterialButton materialButton;
        MaterialButton materialButton2;
        int i2;
        float max;
        if (!(this.buttonSizeChange == null || getChildCount() == 0)) {
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            int i3 = Integer.MAX_VALUE;
            for (int i4 = firstVisibleChildIndex; i4 <= lastVisibleChildIndex; i4++) {
                if (isChildVisible$1(i4)) {
                    int i5 = 0;
                    if (isChildVisible$1(i4) && this.buttonSizeChange != null) {
                        StateListSizeChange stateListSizeChange = this.buttonSizeChange;
                        int width = ((MaterialButton) getChildAt(i4)).getWidth();
                        int i6 = -width;
                        for (int i7 = 0; i7 < stateListSizeChange.stateCount; i7++) {
                            StateListSizeChange.SizeChangeAmount sizeChangeAmount = (StateListSizeChange.SizeChangeAmount) stateListSizeChange.sizeChanges[i7].$$delegate_0;
                            int i8 = sizeChangeAmount.type;
                            float f = sizeChangeAmount.amount;
                            if (i8 == 2) {
                                max = Math.max(i6, f);
                            } else if (i8 == 1) {
                                max = Math.max(i6, width * f);
                            }
                            i6 = (int) max;
                        }
                        int max2 = Math.max(0, i6);
                        int i9 = i4 - 1;
                        while (true) {
                            materialButton = null;
                            if (i9 < 0) {
                                materialButton2 = null;
                                break;
                            } else if (isChildVisible$1(i9)) {
                                materialButton2 = (MaterialButton) getChildAt(i9);
                                break;
                            } else {
                                i9--;
                            }
                        }
                        if (materialButton2 == null) {
                            i2 = 0;
                        } else {
                            i2 = materialButton2.getAllowedWidthDecrease();
                        }
                        int childCount = getChildCount();
                        int i10 = i4 + 1;
                        while (true) {
                            if (i10 >= childCount) {
                                break;
                            } else if (isChildVisible$1(i10)) {
                                materialButton = (MaterialButton) getChildAt(i10);
                                break;
                            } else {
                                i10++;
                            }
                        }
                        if (materialButton != null) {
                            i5 = materialButton.getAllowedWidthDecrease();
                        }
                        i5 = Math.min(max2, i2 + i5);
                    }
                    if (!(i4 == firstVisibleChildIndex || i4 == lastVisibleChildIndex)) {
                        i5 /= 2;
                    }
                    i3 = Math.min(i3, i5);
                }
            }
            for (int i11 = firstVisibleChildIndex; i11 <= lastVisibleChildIndex; i11++) {
                if (isChildVisible$1(i11)) {
                    ((MaterialButton) getChildAt(i11)).setSizeChange(this.buttonSizeChange);
                    MaterialButton materialButton3 = (MaterialButton) getChildAt(i11);
                    if (i11 == firstVisibleChildIndex || i11 == lastVisibleChildIndex) {
                        i = i3;
                    } else {
                        i = i3 * 2;
                    }
                    materialButton3.setWidthChangeMax(i);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.childOrderComparator);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put((MaterialButton) getChildAt(i), Integer.valueOf(i));
        }
        this.childOrder = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public StateListSizeChange getButtonSizeChange() {
        return this.buttonSizeChange;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i2) {
        Integer[] numArr = this.childOrder;
        if (numArr != null && i2 < numArr.length) {
            return numArr[i2].intValue();
        }
        Log.w("MButtonGroup", "Child order wasn't updated");
        return i2;
    }

    public CornerSize getInnerCornerSize() {
        return this.innerCornerSize.defaultCornerSize;
    }

    public StateListCornerSize getInnerCornerSizeStateList() {
        return this.innerCornerSize;
    }

    public ShapeAppearanceModel getShapeAppearance() {
        StateListShapeAppearanceModel stateListShapeAppearanceModel = this.groupStateListShapeAppearance;
        if (stateListShapeAppearanceModel == null) {
            return null;
        }
        return stateListShapeAppearanceModel.getDefaultShape();
    }

    public int getSpacing() {
        return this.spacing;
    }

    public StateListShapeAppearanceModel getStateListShapeAppearance() {
        return this.groupStateListShapeAppearance;
    }

    public final boolean isChildVisible$1(int i) {
        if (getChildAt(i).getVisibility() != 8) {
            return true;
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            recoverAllChildrenLayoutParams();
            adjustChildSizeChange();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.originalChildShapeAppearanceModels.remove(indexOfChild);
            this.originalChildStateListShapeAppearanceModels.remove(indexOfChild);
        }
        this.childShapesDirty = true;
        updateChildShapes();
        recoverAllChildrenLayoutParams();
        adjustChildMarginsAndUpdateLayout();
    }

    public final void recoverAllChildrenLayoutParams() {
        for (int i = 0; i < getChildCount(); i++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i);
            LinearLayout.LayoutParams layoutParams = materialButton.originalLayoutParams;
            if (layoutParams != null) {
                materialButton.setLayoutParams(layoutParams);
                materialButton.originalLayoutParams = null;
                materialButton.originalWidth = -1.0f;
            }
        }
    }

    public void setButtonSizeChange(StateListSizeChange stateListSizeChange) {
        if (this.buttonSizeChange != stateListSizeChange) {
            this.buttonSizeChange = stateListSizeChange;
            adjustChildSizeChange();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (int i = 0; i < getChildCount(); i++) {
            ((MaterialButton) getChildAt(i)).setEnabled(z);
        }
    }

    public void setInnerCornerSize(CornerSize cornerSize) {
        this.innerCornerSize = StateListCornerSize.create(cornerSize);
        this.childShapesDirty = true;
        updateChildShapes();
        invalidate();
    }

    public void setInnerCornerSizeStateList(StateListCornerSize stateListCornerSize) {
        this.innerCornerSize = stateListCornerSize;
        this.childShapesDirty = true;
        updateChildShapes();
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (getOrientation() != i) {
            this.childShapesDirty = true;
        }
        super.setOrientation(i);
    }

    public void setShapeAppearance(ShapeAppearanceModel shapeAppearanceModel) {
        StateListShapeAppearanceModel stateListShapeAppearanceModel;
        StateListShapeAppearanceModel.Builder builder = new StateListShapeAppearanceModel.Builder(shapeAppearanceModel);
        if (builder.stateCount == 0) {
            stateListShapeAppearanceModel = null;
        } else {
            stateListShapeAppearanceModel = new StateListShapeAppearanceModel(builder);
        }
        this.groupStateListShapeAppearance = stateListShapeAppearanceModel;
        this.childShapesDirty = true;
        updateChildShapes();
        invalidate();
    }

    public void setSpacing(int i) {
        this.spacing = i;
        invalidate();
        requestLayout();
    }

    public void setStateListShapeAppearance(StateListShapeAppearanceModel stateListShapeAppearanceModel) {
        this.groupStateListShapeAppearance = stateListShapeAppearanceModel;
        this.childShapesDirty = true;
        updateChildShapes();
        invalidate();
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object, com.google.android.material.shape.StateListShapeAppearanceModel$Builder] */
    public final void updateChildShapes() {
        boolean z;
        boolean z2;
        StateListShapeAppearanceModel.Builder builder;
        boolean z3;
        boolean z4;
        int i;
        StateListShapeAppearanceModel stateListShapeAppearanceModel;
        if (!(this.innerCornerSize == null && this.groupStateListShapeAppearance == null) && this.childShapesDirty) {
            this.childShapesDirty = false;
            int childCount = getChildCount();
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            for (int i2 = 0; i2 < childCount; i2++) {
                MaterialButton materialButton = (MaterialButton) getChildAt(i2);
                if (materialButton.getVisibility() != 8) {
                    if (i2 == firstVisibleChildIndex) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (i2 == lastVisibleChildIndex) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    StateListShapeAppearanceModel stateListShapeAppearanceModel2 = this.groupStateListShapeAppearance;
                    if (stateListShapeAppearanceModel2 == null || (!z && !z2)) {
                        stateListShapeAppearanceModel2 = (StateListShapeAppearanceModel) this.originalChildStateListShapeAppearanceModels.get(i2);
                    }
                    if (stateListShapeAppearanceModel2 == null) {
                        builder = new StateListShapeAppearanceModel.Builder((ShapeAppearanceModel) this.originalChildShapeAppearanceModels.get(i2));
                    } else {
                        ?? obj = new Object();
                        int i3 = stateListShapeAppearanceModel2.stateCount;
                        obj.stateCount = i3;
                        obj.defaultShape = stateListShapeAppearanceModel2.defaultShape;
                        int[][] iArr = stateListShapeAppearanceModel2.stateSpecs;
                        int[][] iArr2 = new int[iArr.length];
                        obj.stateSpecs = iArr2;
                        ShapeAppearanceModel[] shapeAppearanceModelArr = stateListShapeAppearanceModel2.shapeAppearanceModels;
                        obj.shapeAppearanceModels = new ShapeAppearanceModel[shapeAppearanceModelArr.length];
                        System.arraycopy(iArr, 0, iArr2, 0, i3);
                        System.arraycopy(shapeAppearanceModelArr, 0, obj.shapeAppearanceModels, 0, obj.stateCount);
                        obj.topLeftCornerSizeOverride = stateListShapeAppearanceModel2.topLeftCornerSizeOverride;
                        obj.topRightCornerSizeOverride = stateListShapeAppearanceModel2.topRightCornerSizeOverride;
                        obj.bottomLeftCornerSizeOverride = stateListShapeAppearanceModel2.bottomLeftCornerSizeOverride;
                        obj.bottomRightCornerSizeOverride = stateListShapeAppearanceModel2.bottomRightCornerSizeOverride;
                        builder = obj;
                    }
                    if (getOrientation() == 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (getLayoutDirection() == 1) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z3) {
                        if (z) {
                            i = 5;
                        } else {
                            i = 0;
                        }
                        if (z2) {
                            i |= 10;
                        }
                        if (z4) {
                            int i4 = i & 5;
                            i = ((i & 10) >> 1) | (i4 << 1);
                        }
                    } else {
                        if (z) {
                            i = 3;
                        } else {
                            i = 0;
                        }
                        if (z2) {
                            i |= 12;
                        }
                    }
                    int i5 = ~i;
                    StateListCornerSize stateListCornerSize = this.innerCornerSize;
                    if ((i5 | 1) == i5) {
                        builder.topLeftCornerSizeOverride = stateListCornerSize;
                    }
                    if ((i5 | 2) == i5) {
                        builder.topRightCornerSizeOverride = stateListCornerSize;
                    }
                    if ((i5 | 4) == i5) {
                        builder.bottomLeftCornerSizeOverride = stateListCornerSize;
                    }
                    if ((i5 | 8) == i5) {
                        builder.bottomRightCornerSizeOverride = stateListCornerSize;
                    }
                    if (builder.stateCount == 0) {
                        stateListShapeAppearanceModel = null;
                    } else {
                        stateListShapeAppearanceModel = new StateListShapeAppearanceModel(builder);
                    }
                    if (stateListShapeAppearanceModel.isStateful()) {
                        materialButton.setStateListShapeAppearanceModel(stateListShapeAppearanceModel);
                    } else {
                        materialButton.setShapeAppearanceModel(stateListShapeAppearanceModel.getDefaultShape());
                    }
                }
            }
        }
    }
}
