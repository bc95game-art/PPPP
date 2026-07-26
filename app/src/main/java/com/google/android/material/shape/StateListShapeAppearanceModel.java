package com.google.android.material.shape;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.emanuelef.remote_capture.R;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.ShapeAppearanceModel;
import j$.util.Objects;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class StateListShapeAppearanceModel {
    public final StateListCornerSize bottomLeftCornerSizeOverride;
    public final StateListCornerSize bottomRightCornerSizeOverride;
    public final ShapeAppearanceModel defaultShape;
    public final ShapeAppearanceModel[] shapeAppearanceModels;
    public final int stateCount;
    public final int[][] stateSpecs;
    public final StateListCornerSize topLeftCornerSizeOverride;
    public final StateListCornerSize topRightCornerSizeOverride;

    /* loaded from: classes.dex */
    public final class Builder {
        public StateListCornerSize bottomLeftCornerSizeOverride;
        public StateListCornerSize bottomRightCornerSizeOverride;
        public ShapeAppearanceModel defaultShape;
        public ShapeAppearanceModel[] shapeAppearanceModels;
        public int stateCount;
        public int[][] stateSpecs;
        public StateListCornerSize topLeftCornerSizeOverride;
        public StateListCornerSize topRightCornerSizeOverride;

        public Builder(ShapeAppearanceModel shapeAppearanceModel) {
            initialize();
            addStateShapeAppearanceModel(StateSet.WILD_CARD, shapeAppearanceModel);
        }

        public final void addStateShapeAppearanceModel(int[] iArr, ShapeAppearanceModel shapeAppearanceModel) {
            int i = this.stateCount;
            if (i == 0 || iArr.length == 0) {
                this.defaultShape = shapeAppearanceModel;
            }
            int[][] iArr2 = this.stateSpecs;
            if (i >= iArr2.length) {
                int i2 = i + 10;
                int[][] iArr3 = new int[i2];
                System.arraycopy(iArr2, 0, iArr3, 0, i);
                this.stateSpecs = iArr3;
                ShapeAppearanceModel[] shapeAppearanceModelArr = new ShapeAppearanceModel[i2];
                System.arraycopy(this.shapeAppearanceModels, 0, shapeAppearanceModelArr, 0, i);
                this.shapeAppearanceModels = shapeAppearanceModelArr;
            }
            int[][] iArr4 = this.stateSpecs;
            int i3 = this.stateCount;
            iArr4[i3] = iArr;
            this.shapeAppearanceModels[i3] = shapeAppearanceModel;
            this.stateCount = i3 + 1;
        }

        public final void initialize() {
            this.defaultShape = new ShapeAppearanceModel();
            this.stateSpecs = new int[10];
            this.shapeAppearanceModels = new ShapeAppearanceModel[10];
        }
    }

    public StateListShapeAppearanceModel(Builder builder) {
        this.stateCount = builder.stateCount;
        this.defaultShape = builder.defaultShape;
        this.stateSpecs = builder.stateSpecs;
        this.shapeAppearanceModels = builder.shapeAppearanceModels;
        this.topLeftCornerSizeOverride = builder.topLeftCornerSizeOverride;
        this.topRightCornerSizeOverride = builder.topRightCornerSizeOverride;
        this.bottomLeftCornerSizeOverride = builder.bottomLeftCornerSizeOverride;
        this.bottomRightCornerSizeOverride = builder.bottomRightCornerSizeOverride;
    }

    public static void access$000(Builder builder, Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray typedArray;
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
                    int[] iArr = R$styleable.MaterialShape;
                    if (theme == null) {
                        typedArray = resources.obtainAttributes(attributeSet, iArr);
                    } else {
                        typedArray = theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                    }
                    ShapeAppearanceModel build = ShapeAppearanceModel.builder(context, typedArray.getResourceId(0, 0), typedArray.getResourceId(1, 0)).build();
                    typedArray.recycle();
                    int attributeCount = attributeSet.getAttributeCount();
                    int[] iArr2 = new int[attributeCount];
                    int i = 0;
                    for (int i2 = 0; i2 < attributeCount; i2++) {
                        int attributeNameResource = attributeSet.getAttributeNameResource(i2);
                        if (!(attributeNameResource == R.attr.shapeAppearance || attributeNameResource == R.attr.shapeAppearanceOverlay)) {
                            int i3 = i + 1;
                            if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr2[i] = attributeNameResource;
                            i = i3;
                        }
                    }
                    builder.addStateShapeAppearanceModel(StateSet.trimStateSet(iArr2, i), build);
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, com.google.android.material.shape.StateListShapeAppearanceModel$Builder] */
    public static StateListShapeAppearanceModel create(Context context, TypedArray typedArray, int i) {
        XmlResourceParser xml;
        AttributeSet asAttributeSet;
        int next;
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0 || !Objects.equals(context.getResources().getResourceTypeName(resourceId), "xml")) {
            return null;
        }
        ?? obj = new Object();
        obj.initialize();
        try {
            xml = context.getResources().getXml(resourceId);
            asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
        } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
            obj.initialize();
        }
        if (next == 2) {
            if (xml.getName().equals("selector")) {
                access$000(obj, context, xml, asAttributeSet, context.getTheme());
            }
            xml.close();
            if (obj.stateCount == 0) {
                return null;
            }
            return new StateListShapeAppearanceModel(obj);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public final ShapeAppearanceModel getDefaultShape() {
        ShapeAppearanceModel shapeAppearanceModel = this.defaultShape;
        StateListCornerSize stateListCornerSize = this.bottomRightCornerSizeOverride;
        StateListCornerSize stateListCornerSize2 = this.bottomLeftCornerSizeOverride;
        StateListCornerSize stateListCornerSize3 = this.topRightCornerSizeOverride;
        StateListCornerSize stateListCornerSize4 = this.topLeftCornerSizeOverride;
        if (stateListCornerSize4 == null && stateListCornerSize3 == null && stateListCornerSize2 == null && stateListCornerSize == null) {
            return shapeAppearanceModel;
        }
        ShapeAppearanceModel.Builder builder = shapeAppearanceModel.toBuilder();
        if (stateListCornerSize4 != null) {
            builder.topLeftCornerSize = stateListCornerSize4.defaultCornerSize;
        }
        if (stateListCornerSize3 != null) {
            builder.topRightCornerSize = stateListCornerSize3.defaultCornerSize;
        }
        if (stateListCornerSize2 != null) {
            builder.bottomLeftCornerSize = stateListCornerSize2.defaultCornerSize;
        }
        if (stateListCornerSize != null) {
            builder.bottomRightCornerSize = stateListCornerSize.defaultCornerSize;
        }
        return builder.build();
    }

    public final boolean isStateful() {
        StateListCornerSize stateListCornerSize;
        StateListCornerSize stateListCornerSize2;
        StateListCornerSize stateListCornerSize3;
        StateListCornerSize stateListCornerSize4;
        if (this.stateCount > 1 || (((stateListCornerSize = this.topLeftCornerSizeOverride) != null && stateListCornerSize.stateCount > 1) || (((stateListCornerSize2 = this.topRightCornerSizeOverride) != null && stateListCornerSize2.stateCount > 1) || (((stateListCornerSize3 = this.bottomLeftCornerSizeOverride) != null && stateListCornerSize3.stateCount > 1) || ((stateListCornerSize4 = this.bottomRightCornerSizeOverride) != null && stateListCornerSize4.stateCount > 1))))) {
            return true;
        }
        return false;
    }
}
