package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class ConstraintSet {
    public static final int[] VISIBILITY_FLAGS = {0, 4, 8};
    public static final SparseIntArray sMapToConstant;
    public static final SparseIntArray sOverrideMapToConstant;
    public final HashMap mSavedAttributes = new HashMap();
    public final boolean mForceId = true;
    public final HashMap mConstraints = new HashMap();

    /* loaded from: classes.dex */
    public final class Layout {
        public static final SparseIntArray sMapToConstant;
        public int baselineMargin;
        public int baselineToBaseline;
        public int baselineToBottom;
        public int baselineToTop;
        public int bottomMargin;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String dimensionRatio;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endMargin;
        public int endToEnd;
        public int endToStart;
        public int goneBaselineMargin;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public boolean guidelineUseRtl;
        public int heightDefault;
        public int heightMax;
        public int heightMin;
        public float heightPercent;
        public float horizontalBias;
        public int horizontalChainStyle;
        public float horizontalWeight;
        public int leftMargin;
        public int leftToLeft;
        public int leftToRight;
        public boolean mBarrierAllowsGoneWidgets;
        public int mBarrierDirection;
        public int mBarrierMargin;
        public String mConstraintTag;
        public int mHeight;
        public int mHelperType;
        public boolean mIsGuideline;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public int mWrapBehavior;
        public int orientation;
        public int rightMargin;
        public int rightToLeft;
        public int rightToRight;
        public int startMargin;
        public int startToEnd;
        public int startToStart;
        public int topMargin;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        public float verticalWeight;
        public int widthDefault;
        public int widthMax;
        public int widthMin;
        public float widthPercent;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            sMapToConstant = sparseIntArray;
            sparseIntArray.append(43, 24);
            sparseIntArray.append(44, 25);
            sparseIntArray.append(46, 28);
            sparseIntArray.append(47, 29);
            sparseIntArray.append(52, 35);
            sparseIntArray.append(51, 34);
            sparseIntArray.append(24, 4);
            sparseIntArray.append(23, 3);
            sparseIntArray.append(19, 1);
            sparseIntArray.append(61, 6);
            sparseIntArray.append(62, 7);
            sparseIntArray.append(31, 17);
            sparseIntArray.append(32, 18);
            sparseIntArray.append(33, 19);
            sparseIntArray.append(15, 90);
            sparseIntArray.append(0, 26);
            sparseIntArray.append(48, 31);
            sparseIntArray.append(49, 32);
            sparseIntArray.append(30, 10);
            sparseIntArray.append(29, 9);
            sparseIntArray.append(66, 13);
            sparseIntArray.append(69, 16);
            sparseIntArray.append(67, 14);
            sparseIntArray.append(64, 11);
            sparseIntArray.append(68, 15);
            sparseIntArray.append(65, 12);
            sparseIntArray.append(55, 38);
            sparseIntArray.append(41, 37);
            sparseIntArray.append(40, 39);
            sparseIntArray.append(54, 40);
            sparseIntArray.append(39, 20);
            sparseIntArray.append(53, 36);
            sparseIntArray.append(28, 5);
            sparseIntArray.append(42, 91);
            sparseIntArray.append(50, 91);
            sparseIntArray.append(45, 91);
            sparseIntArray.append(22, 91);
            sparseIntArray.append(18, 91);
            sparseIntArray.append(3, 23);
            sparseIntArray.append(5, 27);
            sparseIntArray.append(7, 30);
            sparseIntArray.append(8, 8);
            sparseIntArray.append(4, 33);
            sparseIntArray.append(6, 2);
            sparseIntArray.append(1, 22);
            sparseIntArray.append(2, 21);
            sparseIntArray.append(56, 41);
            sparseIntArray.append(34, 42);
            sparseIntArray.append(17, 87);
            sparseIntArray.append(16, 88);
            sparseIntArray.append(71, 76);
            sparseIntArray.append(25, 61);
            sparseIntArray.append(27, 62);
            sparseIntArray.append(26, 63);
            sparseIntArray.append(60, 69);
            sparseIntArray.append(38, 70);
            sparseIntArray.append(12, 71);
            sparseIntArray.append(10, 72);
            sparseIntArray.append(11, 73);
            sparseIntArray.append(13, 74);
            sparseIntArray.append(9, 75);
            sparseIntArray.append(58, 84);
            sparseIntArray.append(59, 86);
            sparseIntArray.append(58, 83);
            sparseIntArray.append(37, 85);
            sparseIntArray.append(56, 87);
            sparseIntArray.append(34, 88);
            sparseIntArray.append(91, 89);
            sparseIntArray.append(15, 90);
        }

        public final void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                SparseIntArray sparseIntArray = sMapToConstant;
                int i2 = sparseIntArray.get(index);
                switch (i2) {
                    case 1:
                        this.baselineToBaseline = ConstraintSet.lookupID(obtainStyledAttributes, index, this.baselineToBaseline);
                        break;
                    case 2:
                        this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.bottomMargin);
                        break;
                    case 3:
                        this.bottomToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.bottomToBottom);
                        break;
                    case 4:
                        this.bottomToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.bottomToTop);
                        break;
                    case 5:
                        this.dimensionRatio = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                        break;
                    case 7:
                        this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                        break;
                    case 8:
                        this.endMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.endMargin);
                        break;
                    case 9:
                        this.endToEnd = ConstraintSet.lookupID(obtainStyledAttributes, index, this.endToEnd);
                        break;
                    case 10:
                        this.endToStart = ConstraintSet.lookupID(obtainStyledAttributes, index, this.endToStart);
                        break;
                    case 11:
                        this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 12:
                        this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 13:
                        this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 14:
                        this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 15:
                        this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 16:
                        this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 17:
                        this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 18:
                        this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 19:
                        this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 20:
                        this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 21:
                        this.mHeight = obtainStyledAttributes.getLayoutDimension(index, this.mHeight);
                        break;
                    case 22:
                        this.mWidth = obtainStyledAttributes.getLayoutDimension(index, this.mWidth);
                        break;
                    case 23:
                        this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.leftMargin);
                        break;
                    case 24:
                        this.leftToLeft = ConstraintSet.lookupID(obtainStyledAttributes, index, this.leftToLeft);
                        break;
                    case 25:
                        this.leftToRight = ConstraintSet.lookupID(obtainStyledAttributes, index, this.leftToRight);
                        break;
                    case 26:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 27:
                        this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.rightMargin);
                        break;
                    case 28:
                        this.rightToLeft = ConstraintSet.lookupID(obtainStyledAttributes, index, this.rightToLeft);
                        break;
                    case 29:
                        this.rightToRight = ConstraintSet.lookupID(obtainStyledAttributes, index, this.rightToRight);
                        break;
                    case 30:
                        this.startMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.startMargin);
                        break;
                    case 31:
                        this.startToEnd = ConstraintSet.lookupID(obtainStyledAttributes, index, this.startToEnd);
                        break;
                    case 32:
                        this.startToStart = ConstraintSet.lookupID(obtainStyledAttributes, index, this.startToStart);
                        break;
                    case 33:
                        this.topMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.topMargin);
                        break;
                    case 34:
                        this.topToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.topToBottom);
                        break;
                    case 35:
                        this.topToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.topToTop);
                        break;
                    case 36:
                        this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 37:
                        this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                        break;
                    case 38:
                        this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                        break;
                    case 39:
                        this.horizontalChainStyle = obtainStyledAttributes.getInt(index, this.horizontalChainStyle);
                        break;
                    case 40:
                        this.verticalChainStyle = obtainStyledAttributes.getInt(index, this.verticalChainStyle);
                        break;
                    case 41:
                        ConstraintSet.parseDimensionConstraints(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        ConstraintSet.parseDimensionConstraints(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i2) {
                            case 61:
                                this.circleConstraint = ConstraintSet.lookupID(obtainStyledAttributes, index, this.circleConstraint);
                                continue;
                            case 62:
                                this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                                continue;
                            case 63:
                                this.circleAngle = obtainStyledAttributes.getFloat(index, this.circleAngle);
                                continue;
                            default:
                                switch (i2) {
                                    case 69:
                                        this.widthPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                        continue;
                                    case 70:
                                        this.heightPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                        continue;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        continue;
                                    case 72:
                                        this.mBarrierDirection = obtainStyledAttributes.getInt(index, this.mBarrierDirection);
                                        continue;
                                    case 73:
                                        this.mBarrierMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.mBarrierMargin);
                                        continue;
                                    case 74:
                                        this.mReferenceIdString = obtainStyledAttributes.getString(index);
                                        continue;
                                    case 75:
                                        this.mBarrierAllowsGoneWidgets = obtainStyledAttributes.getBoolean(index, this.mBarrierAllowsGoneWidgets);
                                        continue;
                                    case 76:
                                        this.mWrapBehavior = obtainStyledAttributes.getInt(index, this.mWrapBehavior);
                                        continue;
                                    case 77:
                                        this.baselineToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.baselineToTop);
                                        continue;
                                    case 78:
                                        this.baselineToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.baselineToBottom);
                                        continue;
                                    case 79:
                                        this.goneBaselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBaselineMargin);
                                        continue;
                                    case 80:
                                        this.baselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.baselineMargin);
                                        continue;
                                    case 81:
                                        this.widthDefault = obtainStyledAttributes.getInt(index, this.widthDefault);
                                        continue;
                                    case 82:
                                        this.heightDefault = obtainStyledAttributes.getInt(index, this.heightDefault);
                                        continue;
                                    case 83:
                                        this.heightMax = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMax);
                                        continue;
                                    case 84:
                                        this.widthMax = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMax);
                                        continue;
                                    case 85:
                                        this.heightMin = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMin);
                                        continue;
                                    case 86:
                                        this.widthMin = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMin);
                                        continue;
                                    case 87:
                                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                                        continue;
                                    case 88:
                                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                                        continue;
                                    case 89:
                                        this.mConstraintTag = obtainStyledAttributes.getString(index);
                                        continue;
                                    case 90:
                                        this.guidelineUseRtl = obtainStyledAttributes.getBoolean(index, this.guidelineUseRtl);
                                        continue;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                        continue;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                        continue;
                                        continue;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public final class Motion {
        public static final SparseIntArray sMapToConstant;
        public int mAnimateCircleAngleTo;
        public int mAnimateRelativeTo;
        public float mMotionStagger;
        public int mPathMotionArc;
        public float mPathRotate;
        public int mQuantizeInterpolatorID;
        public String mQuantizeInterpolatorString;
        public float mQuantizeMotionPhase;
        public int mQuantizeMotionSteps;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            sMapToConstant = sparseIntArray;
            sparseIntArray.append(3, 1);
            sparseIntArray.append(5, 2);
            sparseIntArray.append(9, 3);
            sparseIntArray.append(2, 4);
            sparseIntArray.append(1, 5);
            sparseIntArray.append(0, 6);
            sparseIntArray.append(4, 7);
            sparseIntArray.append(8, 8);
            sparseIntArray.append(7, 9);
            sparseIntArray.append(6, 10);
        }

        public final void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Motion);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (sMapToConstant.get(index)) {
                    case 1:
                        this.mPathRotate = obtainStyledAttributes.getFloat(index, this.mPathRotate);
                        break;
                    case 2:
                        this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            String str = Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.mAnimateRelativeTo = ConstraintSet.lookupID(obtainStyledAttributes, index, this.mAnimateRelativeTo);
                        break;
                    case 6:
                        this.mAnimateCircleAngleTo = obtainStyledAttributes.getInteger(index, this.mAnimateCircleAngleTo);
                        break;
                    case 7:
                        this.mMotionStagger = obtainStyledAttributes.getFloat(index, this.mMotionStagger);
                        break;
                    case 8:
                        this.mQuantizeMotionSteps = obtainStyledAttributes.getInteger(index, this.mQuantizeMotionSteps);
                        break;
                    case 9:
                        this.mQuantizeMotionPhase = obtainStyledAttributes.getFloat(index, this.mQuantizeMotionPhase);
                        break;
                    case 10:
                        int i2 = obtainStyledAttributes.peekValue(index).type;
                        if (i2 != 1) {
                            if (i2 == 3) {
                                String string = obtainStyledAttributes.getString(index);
                                this.mQuantizeInterpolatorString = string;
                                if (string.indexOf("/") > 0) {
                                    this.mQuantizeInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                obtainStyledAttributes.getInteger(index, this.mQuantizeInterpolatorID);
                                break;
                            }
                        } else {
                            this.mQuantizeInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                            break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public final class PropertySet {
        public float alpha;
        public float mProgress;
        public int mVisibilityMode;
        public int visibility;

        public final void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PropertySet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 1) {
                    this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == 0) {
                    int i2 = obtainStyledAttributes.getInt(index, this.visibility);
                    this.visibility = i2;
                    this.visibility = ConstraintSet.VISIBILITY_FLAGS[i2];
                } else if (index == 4) {
                    this.mVisibilityMode = obtainStyledAttributes.getInt(index, this.mVisibilityMode);
                } else if (index == 3) {
                    this.mProgress = obtainStyledAttributes.getFloat(index, this.mProgress);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public final class Transform {
        public static final SparseIntArray sMapToConstant;
        public boolean applyElevation;
        public float elevation;
        public float rotation;
        public float rotationX;
        public float rotationY;
        public float scaleX;
        public float scaleY;
        public int transformPivotTarget;
        public float transformPivotX;
        public float transformPivotY;
        public float translationX;
        public float translationY;
        public float translationZ;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            sMapToConstant = sparseIntArray;
            sparseIntArray.append(6, 1);
            sparseIntArray.append(7, 2);
            sparseIntArray.append(8, 3);
            sparseIntArray.append(4, 4);
            sparseIntArray.append(5, 5);
            sparseIntArray.append(0, 6);
            sparseIntArray.append(1, 7);
            sparseIntArray.append(2, 8);
            sparseIntArray.append(3, 9);
            sparseIntArray.append(9, 10);
            sparseIntArray.append(10, 11);
            sparseIntArray.append(11, 12);
        }

        public final void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transform);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (sMapToConstant.get(index)) {
                    case 1:
                        this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                        break;
                    case 2:
                        this.rotationX = obtainStyledAttributes.getFloat(index, this.rotationX);
                        break;
                    case 3:
                        this.rotationY = obtainStyledAttributes.getFloat(index, this.rotationY);
                        break;
                    case 4:
                        this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                        break;
                    case 5:
                        this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                        break;
                    case 6:
                        this.transformPivotX = obtainStyledAttributes.getDimension(index, this.transformPivotX);
                        break;
                    case 7:
                        this.transformPivotY = obtainStyledAttributes.getDimension(index, this.transformPivotY);
                        break;
                    case 8:
                        this.translationX = obtainStyledAttributes.getDimension(index, this.translationX);
                        break;
                    case 9:
                        this.translationY = obtainStyledAttributes.getDimension(index, this.translationY);
                        break;
                    case 10:
                        this.translationZ = obtainStyledAttributes.getDimension(index, this.translationZ);
                        break;
                    case 11:
                        this.applyElevation = true;
                        this.elevation = obtainStyledAttributes.getDimension(index, this.elevation);
                        break;
                    case 12:
                        this.transformPivotTarget = ConstraintSet.lookupID(obtainStyledAttributes, index, this.transformPivotTarget);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sMapToConstant = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        sOverrideMapToConstant = sparseIntArray2;
        sparseIntArray.append(82, 25);
        sparseIntArray.append(83, 26);
        sparseIntArray.append(85, 29);
        sparseIntArray.append(86, 30);
        sparseIntArray.append(92, 36);
        sparseIntArray.append(91, 35);
        sparseIntArray.append(63, 4);
        sparseIntArray.append(62, 3);
        sparseIntArray.append(58, 1);
        sparseIntArray.append(60, 91);
        sparseIntArray.append(59, 92);
        sparseIntArray.append(101, 6);
        sparseIntArray.append(102, 7);
        sparseIntArray.append(70, 17);
        sparseIntArray.append(71, 18);
        sparseIntArray.append(72, 19);
        sparseIntArray.append(54, 99);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(87, 32);
        sparseIntArray.append(88, 33);
        sparseIntArray.append(69, 10);
        sparseIntArray.append(68, 9);
        sparseIntArray.append(106, 13);
        sparseIntArray.append(109, 16);
        sparseIntArray.append(107, 14);
        sparseIntArray.append(104, 11);
        sparseIntArray.append(108, 15);
        sparseIntArray.append(105, 12);
        sparseIntArray.append(95, 40);
        sparseIntArray.append(80, 39);
        sparseIntArray.append(79, 41);
        sparseIntArray.append(94, 42);
        sparseIntArray.append(78, 20);
        sparseIntArray.append(93, 37);
        sparseIntArray.append(67, 5);
        sparseIntArray.append(81, 87);
        sparseIntArray.append(90, 87);
        sparseIntArray.append(84, 87);
        sparseIntArray.append(61, 87);
        sparseIntArray.append(57, 87);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(96, 95);
        sparseIntArray.append(73, 96);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(97, 54);
        sparseIntArray.append(74, 55);
        sparseIntArray.append(98, 56);
        sparseIntArray.append(75, 57);
        sparseIntArray.append(99, 58);
        sparseIntArray.append(76, 59);
        sparseIntArray.append(64, 61);
        sparseIntArray.append(66, 62);
        sparseIntArray.append(65, 63);
        sparseIntArray.append(28, 64);
        sparseIntArray.append(121, 65);
        sparseIntArray.append(35, 66);
        sparseIntArray.append(122, 67);
        sparseIntArray.append(113, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(112, 68);
        sparseIntArray.append(100, 69);
        sparseIntArray.append(77, 70);
        sparseIntArray.append(111, 97);
        sparseIntArray.append(32, 71);
        sparseIntArray.append(30, 72);
        sparseIntArray.append(31, 73);
        sparseIntArray.append(33, 74);
        sparseIntArray.append(29, 75);
        sparseIntArray.append(114, 76);
        sparseIntArray.append(89, 77);
        sparseIntArray.append(123, 78);
        sparseIntArray.append(56, 80);
        sparseIntArray.append(55, 81);
        sparseIntArray.append(116, 82);
        sparseIntArray.append(120, 83);
        sparseIntArray.append(119, 84);
        sparseIntArray.append(118, 85);
        sparseIntArray.append(117, 86);
        sparseIntArray2.append(85, 6);
        sparseIntArray2.append(85, 7);
        sparseIntArray2.append(0, 27);
        sparseIntArray2.append(89, 13);
        sparseIntArray2.append(92, 16);
        sparseIntArray2.append(90, 14);
        sparseIntArray2.append(87, 11);
        sparseIntArray2.append(91, 15);
        sparseIntArray2.append(88, 12);
        sparseIntArray2.append(78, 40);
        sparseIntArray2.append(71, 39);
        sparseIntArray2.append(70, 41);
        sparseIntArray2.append(77, 42);
        sparseIntArray2.append(69, 20);
        sparseIntArray2.append(76, 37);
        sparseIntArray2.append(60, 5);
        sparseIntArray2.append(72, 87);
        sparseIntArray2.append(75, 87);
        sparseIntArray2.append(73, 87);
        sparseIntArray2.append(57, 87);
        sparseIntArray2.append(56, 87);
        sparseIntArray2.append(5, 24);
        sparseIntArray2.append(7, 28);
        sparseIntArray2.append(23, 31);
        sparseIntArray2.append(24, 8);
        sparseIntArray2.append(6, 34);
        sparseIntArray2.append(8, 2);
        sparseIntArray2.append(3, 23);
        sparseIntArray2.append(4, 21);
        sparseIntArray2.append(79, 95);
        sparseIntArray2.append(64, 96);
        sparseIntArray2.append(2, 22);
        sparseIntArray2.append(13, 43);
        sparseIntArray2.append(26, 44);
        sparseIntArray2.append(21, 45);
        sparseIntArray2.append(22, 46);
        sparseIntArray2.append(20, 60);
        sparseIntArray2.append(18, 47);
        sparseIntArray2.append(19, 48);
        sparseIntArray2.append(14, 49);
        sparseIntArray2.append(15, 50);
        sparseIntArray2.append(16, 51);
        sparseIntArray2.append(17, 52);
        sparseIntArray2.append(25, 53);
        sparseIntArray2.append(80, 54);
        sparseIntArray2.append(65, 55);
        sparseIntArray2.append(81, 56);
        sparseIntArray2.append(66, 57);
        sparseIntArray2.append(82, 58);
        sparseIntArray2.append(67, 59);
        sparseIntArray2.append(59, 62);
        sparseIntArray2.append(58, 63);
        sparseIntArray2.append(28, 64);
        sparseIntArray2.append(105, 65);
        sparseIntArray2.append(34, 66);
        sparseIntArray2.append(106, 67);
        sparseIntArray2.append(96, 79);
        sparseIntArray2.append(1, 38);
        sparseIntArray2.append(97, 98);
        sparseIntArray2.append(95, 68);
        sparseIntArray2.append(83, 69);
        sparseIntArray2.append(68, 70);
        sparseIntArray2.append(32, 71);
        sparseIntArray2.append(30, 72);
        sparseIntArray2.append(31, 73);
        sparseIntArray2.append(33, 74);
        sparseIntArray2.append(29, 75);
        sparseIntArray2.append(98, 76);
        sparseIntArray2.append(74, 77);
        sparseIntArray2.append(107, 78);
        sparseIntArray2.append(55, 80);
        sparseIntArray2.append(54, 81);
        sparseIntArray2.append(100, 82);
        sparseIntArray2.append(104, 83);
        sparseIntArray2.append(103, 84);
        sparseIntArray2.append(102, 85);
        sparseIntArray2.append(101, 86);
        sparseIntArray2.append(94, 97);
    }

    public static int[] convertReferenceString(Barrier barrier, String str) {
        int i;
        String[] split = str.split(",");
        Context context = barrier.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            Object obj = null;
            try {
                i = R$id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && barrier.isInEditMode() && (barrier.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) barrier.getParent();
                if (ViewModelProvider.Factory.CC.m599m((Object) trim)) {
                    HashMap hashMap = constraintLayout.mDesignIds;
                    if (hashMap != null && hashMap.containsKey(trim)) {
                        obj = constraintLayout.mDesignIds.get(trim);
                    }
                } else {
                    constraintLayout.getClass();
                }
                if (obj != null && (obj instanceof Integer)) {
                    i = ((Integer) obj).intValue();
                }
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        if (i3 != split.length) {
            return Arrays.copyOf(iArr, i3);
        }
        return iArr;
    }

    /* JADX WARN: Type inference failed for: r6v189, types: [androidx.constraintlayout.widget.ConstraintSet$Constraint$Delta, java.lang.Object] */
    public static Constraint fillFromAttributeList(Context context, AttributeSet attributeSet, boolean z) {
        int[] iArr;
        int i;
        int i2;
        Constraint constraint = new Constraint();
        if (z) {
            iArr = R$styleable.ConstraintOverride;
        } else {
            iArr = R$styleable.Constraint;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        PropertySet propertySet = constraint.propertySet;
        Transform transform = constraint.transform;
        Motion motion = constraint.motion;
        Layout layout = constraint.layout;
        int[] iArr2 = VISIBILITY_FLAGS;
        String[] strArr = Easing.NAMED_EASING;
        SparseIntArray sparseIntArray = sMapToConstant;
        if (z) {
            ?? obj = new Object();
            obj.mTypeInt = new int[10];
            obj.mValueInt = new int[10];
            obj.mCountInt = 0;
            obj.mTypeFloat = new int[10];
            obj.mValueFloat = new float[10];
            obj.mCountFloat = 0;
            obj.mTypeString = new int[5];
            obj.mValueString = new String[5];
            obj.mCountString = 0;
            obj.mTypeBoolean = new int[4];
            obj.mValueBoolean = new boolean[4];
            obj.mCountBoolean = 0;
            motion.getClass();
            layout.getClass();
            transform.getClass();
            int i3 = 0;
            for (int indexCount = obtainStyledAttributes.getIndexCount(); i3 < indexCount; indexCount = i2) {
                int index = obtainStyledAttributes.getIndex(i3);
                int i4 = i3;
                switch (sOverrideMapToConstant.get(index)) {
                    case 2:
                        i2 = indexCount;
                        obj.add(2, obtainStyledAttributes.getDimensionPixelSize(index, layout.bottomMargin));
                        continue;
                        i3 = i4 + 1;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case 25:
                    case 26:
                    case 29:
                    case 30:
                    case 32:
                    case 33:
                    case 35:
                    case 36:
                    case 61:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    default:
                        StringBuilder sb = new StringBuilder("Unknown attribute 0x");
                        i2 = indexCount;
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(sparseIntArray.get(index));
                        Log.w("ConstraintSet", sb.toString());
                        break;
                    case 5:
                        i2 = indexCount;
                        obj.add(5, obtainStyledAttributes.getString(index));
                        continue;
                        i3 = i4 + 1;
                    case 6:
                        i2 = indexCount;
                        obj.add(6, obtainStyledAttributes.getDimensionPixelOffset(index, layout.editorAbsoluteX));
                        break;
                    case 7:
                        i2 = indexCount;
                        obj.add(7, obtainStyledAttributes.getDimensionPixelOffset(index, layout.editorAbsoluteY));
                        break;
                    case 8:
                        i2 = indexCount;
                        obj.add(8, obtainStyledAttributes.getDimensionPixelSize(index, layout.endMargin));
                        break;
                    case 11:
                        i2 = indexCount;
                        obj.add(11, obtainStyledAttributes.getDimensionPixelSize(index, layout.goneBottomMargin));
                        break;
                    case 12:
                        i2 = indexCount;
                        obj.add(12, obtainStyledAttributes.getDimensionPixelSize(index, layout.goneEndMargin));
                        break;
                    case 13:
                        i2 = indexCount;
                        obj.add(13, obtainStyledAttributes.getDimensionPixelSize(index, layout.goneLeftMargin));
                        break;
                    case 14:
                        i2 = indexCount;
                        obj.add(14, obtainStyledAttributes.getDimensionPixelSize(index, layout.goneRightMargin));
                        break;
                    case 15:
                        i2 = indexCount;
                        obj.add(15, obtainStyledAttributes.getDimensionPixelSize(index, layout.goneStartMargin));
                        break;
                    case 16:
                        i2 = indexCount;
                        obj.add(16, obtainStyledAttributes.getDimensionPixelSize(index, layout.goneTopMargin));
                        break;
                    case 17:
                        i2 = indexCount;
                        obj.add(17, obtainStyledAttributes.getDimensionPixelOffset(index, layout.guideBegin));
                        break;
                    case 18:
                        i2 = indexCount;
                        obj.add(18, obtainStyledAttributes.getDimensionPixelOffset(index, layout.guideEnd));
                        break;
                    case 19:
                        i2 = indexCount;
                        obj.add(19, obtainStyledAttributes.getFloat(index, layout.guidePercent));
                        break;
                    case 20:
                        i2 = indexCount;
                        obj.add(20, obtainStyledAttributes.getFloat(index, layout.horizontalBias));
                        break;
                    case 21:
                        i2 = indexCount;
                        obj.add(21, obtainStyledAttributes.getLayoutDimension(index, layout.mHeight));
                        break;
                    case 22:
                        i2 = indexCount;
                        obj.add(22, iArr2[obtainStyledAttributes.getInt(index, propertySet.visibility)]);
                        break;
                    case 23:
                        i2 = indexCount;
                        obj.add(23, obtainStyledAttributes.getLayoutDimension(index, layout.mWidth));
                        break;
                    case 24:
                        i2 = indexCount;
                        obj.add(24, obtainStyledAttributes.getDimensionPixelSize(index, layout.leftMargin));
                        break;
                    case 27:
                        i2 = indexCount;
                        obj.add(27, obtainStyledAttributes.getInt(index, layout.orientation));
                        break;
                    case 28:
                        i2 = indexCount;
                        obj.add(28, obtainStyledAttributes.getDimensionPixelSize(index, layout.rightMargin));
                        break;
                    case 31:
                        i2 = indexCount;
                        obj.add(31, obtainStyledAttributes.getDimensionPixelSize(index, layout.startMargin));
                        break;
                    case 34:
                        i2 = indexCount;
                        obj.add(34, obtainStyledAttributes.getDimensionPixelSize(index, layout.topMargin));
                        break;
                    case 37:
                        i2 = indexCount;
                        obj.add(37, obtainStyledAttributes.getFloat(index, layout.verticalBias));
                        break;
                    case 38:
                        i2 = indexCount;
                        int resourceId = obtainStyledAttributes.getResourceId(index, constraint.mViewId);
                        constraint.mViewId = resourceId;
                        obj.add(38, resourceId);
                        break;
                    case 39:
                        i2 = indexCount;
                        obj.add(39, obtainStyledAttributes.getFloat(index, layout.horizontalWeight));
                        break;
                    case 40:
                        i2 = indexCount;
                        obj.add(40, obtainStyledAttributes.getFloat(index, layout.verticalWeight));
                        break;
                    case 41:
                        i2 = indexCount;
                        obj.add(41, obtainStyledAttributes.getInt(index, layout.horizontalChainStyle));
                        break;
                    case 42:
                        i2 = indexCount;
                        obj.add(42, obtainStyledAttributes.getInt(index, layout.verticalChainStyle));
                        break;
                    case 43:
                        i2 = indexCount;
                        obj.add(43, obtainStyledAttributes.getFloat(index, propertySet.alpha));
                        break;
                    case 44:
                        i2 = indexCount;
                        obj.add(44, true);
                        obj.add(44, obtainStyledAttributes.getDimension(index, transform.elevation));
                        break;
                    case 45:
                        i2 = indexCount;
                        obj.add(45, obtainStyledAttributes.getFloat(index, transform.rotationX));
                        break;
                    case 46:
                        i2 = indexCount;
                        obj.add(46, obtainStyledAttributes.getFloat(index, transform.rotationY));
                        break;
                    case 47:
                        i2 = indexCount;
                        obj.add(47, obtainStyledAttributes.getFloat(index, transform.scaleX));
                        break;
                    case 48:
                        i2 = indexCount;
                        obj.add(48, obtainStyledAttributes.getFloat(index, transform.scaleY));
                        break;
                    case 49:
                        i2 = indexCount;
                        obj.add(49, obtainStyledAttributes.getDimension(index, transform.transformPivotX));
                        break;
                    case 50:
                        i2 = indexCount;
                        obj.add(50, obtainStyledAttributes.getDimension(index, transform.transformPivotY));
                        break;
                    case 51:
                        i2 = indexCount;
                        obj.add(51, obtainStyledAttributes.getDimension(index, transform.translationX));
                        break;
                    case 52:
                        i2 = indexCount;
                        obj.add(52, obtainStyledAttributes.getDimension(index, transform.translationY));
                        break;
                    case 53:
                        i2 = indexCount;
                        obj.add(53, obtainStyledAttributes.getDimension(index, transform.translationZ));
                        break;
                    case 54:
                        i2 = indexCount;
                        obj.add(54, obtainStyledAttributes.getInt(index, layout.widthDefault));
                        break;
                    case 55:
                        i2 = indexCount;
                        obj.add(55, obtainStyledAttributes.getInt(index, layout.heightDefault));
                        break;
                    case 56:
                        i2 = indexCount;
                        obj.add(56, obtainStyledAttributes.getDimensionPixelSize(index, layout.widthMax));
                        break;
                    case 57:
                        i2 = indexCount;
                        obj.add(57, obtainStyledAttributes.getDimensionPixelSize(index, layout.heightMax));
                        break;
                    case 58:
                        i2 = indexCount;
                        obj.add(58, obtainStyledAttributes.getDimensionPixelSize(index, layout.widthMin));
                        break;
                    case 59:
                        i2 = indexCount;
                        obj.add(59, obtainStyledAttributes.getDimensionPixelSize(index, layout.heightMin));
                        break;
                    case 60:
                        i2 = indexCount;
                        obj.add(60, obtainStyledAttributes.getFloat(index, transform.rotation));
                        break;
                    case 62:
                        i2 = indexCount;
                        obj.add(62, obtainStyledAttributes.getDimensionPixelSize(index, layout.circleRadius));
                        break;
                    case 63:
                        i2 = indexCount;
                        obj.add(63, obtainStyledAttributes.getFloat(index, layout.circleAngle));
                        break;
                    case 64:
                        i2 = indexCount;
                        obj.add(64, lookupID(obtainStyledAttributes, index, motion.mAnimateRelativeTo));
                        break;
                    case 65:
                        i2 = indexCount;
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            obj.add(65, obtainStyledAttributes.getString(index));
                            break;
                        } else {
                            obj.add(65, strArr[obtainStyledAttributes.getInteger(index, 0)]);
                            break;
                        }
                    case 66:
                        i2 = indexCount;
                        obj.add(66, obtainStyledAttributes.getInt(index, 0));
                        break;
                    case 67:
                        i2 = indexCount;
                        obj.add(67, obtainStyledAttributes.getFloat(index, motion.mPathRotate));
                        break;
                    case 68:
                        i2 = indexCount;
                        obj.add(68, obtainStyledAttributes.getFloat(index, propertySet.mProgress));
                        break;
                    case 69:
                        i2 = indexCount;
                        obj.add(69, obtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 70:
                        i2 = indexCount;
                        obj.add(70, obtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 71:
                        i2 = indexCount;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i2 = indexCount;
                        obj.add(72, obtainStyledAttributes.getInt(index, layout.mBarrierDirection));
                        break;
                    case 73:
                        i2 = indexCount;
                        obj.add(73, obtainStyledAttributes.getDimensionPixelSize(index, layout.mBarrierMargin));
                        break;
                    case 74:
                        i2 = indexCount;
                        obj.add(74, obtainStyledAttributes.getString(index));
                        break;
                    case 75:
                        i2 = indexCount;
                        obj.add(75, obtainStyledAttributes.getBoolean(index, layout.mBarrierAllowsGoneWidgets));
                        break;
                    case 76:
                        i2 = indexCount;
                        obj.add(76, obtainStyledAttributes.getInt(index, motion.mPathMotionArc));
                        break;
                    case 77:
                        i2 = indexCount;
                        obj.add(77, obtainStyledAttributes.getString(index));
                        break;
                    case 78:
                        i2 = indexCount;
                        obj.add(78, obtainStyledAttributes.getInt(index, propertySet.mVisibilityMode));
                        break;
                    case 79:
                        i2 = indexCount;
                        obj.add(79, obtainStyledAttributes.getFloat(index, motion.mMotionStagger));
                        break;
                    case 80:
                        i2 = indexCount;
                        obj.add(80, obtainStyledAttributes.getBoolean(index, layout.constrainedWidth));
                        break;
                    case 81:
                        i2 = indexCount;
                        obj.add(81, obtainStyledAttributes.getBoolean(index, layout.constrainedHeight));
                        break;
                    case 82:
                        i2 = indexCount;
                        obj.add(82, obtainStyledAttributes.getInteger(index, motion.mAnimateCircleAngleTo));
                        break;
                    case 83:
                        i2 = indexCount;
                        obj.add(83, lookupID(obtainStyledAttributes, index, transform.transformPivotTarget));
                        break;
                    case 84:
                        i2 = indexCount;
                        obj.add(84, obtainStyledAttributes.getInteger(index, motion.mQuantizeMotionSteps));
                        break;
                    case 85:
                        i2 = indexCount;
                        obj.add(85, obtainStyledAttributes.getFloat(index, motion.mQuantizeMotionPhase));
                        break;
                    case 86:
                        i2 = indexCount;
                        int i5 = obtainStyledAttributes.peekValue(index).type;
                        if (i5 != 1) {
                            if (i5 == 3) {
                                String string = obtainStyledAttributes.getString(index);
                                motion.mQuantizeInterpolatorString = string;
                                obj.add(90, string);
                                if (motion.mQuantizeInterpolatorString.indexOf("/") > 0) {
                                    int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                                    motion.mQuantizeInterpolatorID = resourceId2;
                                    obj.add(89, resourceId2);
                                    obj.add(88, -2);
                                    break;
                                } else {
                                    obj.add(88, -1);
                                    break;
                                }
                            } else {
                                obj.add(88, obtainStyledAttributes.getInteger(index, motion.mQuantizeInterpolatorID));
                                break;
                            }
                        } else {
                            int resourceId3 = obtainStyledAttributes.getResourceId(index, -1);
                            motion.mQuantizeInterpolatorID = resourceId3;
                            obj.add(89, resourceId3);
                            if (motion.mQuantizeInterpolatorID != -1) {
                                obj.add(88, -2);
                                break;
                            }
                        }
                        break;
                    case 87:
                        i2 = indexCount;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                        break;
                    case 93:
                        i2 = indexCount;
                        obj.add(93, obtainStyledAttributes.getDimensionPixelSize(index, layout.baselineMargin));
                        break;
                    case 94:
                        i2 = indexCount;
                        obj.add(94, obtainStyledAttributes.getDimensionPixelSize(index, layout.goneBaselineMargin));
                        break;
                    case 95:
                        i2 = indexCount;
                        parseDimensionConstraints(obj, obtainStyledAttributes, index, 0);
                        break;
                    case 96:
                        i2 = indexCount;
                        parseDimensionConstraints(obj, obtainStyledAttributes, index, 1);
                        break;
                    case 97:
                        i2 = indexCount;
                        obj.add(97, obtainStyledAttributes.getInt(index, layout.mWrapBehavior));
                        break;
                    case 98:
                        i2 = indexCount;
                        int i6 = MotionLayout.$r8$clinit;
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            constraint.mViewId = obtainStyledAttributes.getResourceId(index, constraint.mViewId);
                            break;
                        }
                    case 99:
                        i2 = indexCount;
                        obj.add(99, obtainStyledAttributes.getBoolean(index, layout.guidelineUseRtl));
                        break;
                }
                i3 = i4 + 1;
            }
        } else {
            int i7 = 0;
            for (int indexCount2 = obtainStyledAttributes.getIndexCount(); i7 < indexCount2; indexCount2 = i) {
                int index2 = obtainStyledAttributes.getIndex(i7);
                if (index2 != 1 && 23 != index2) {
                    if (24 != index2) {
                        motion.getClass();
                        layout.getClass();
                        transform.getClass();
                    }
                }
                switch (sparseIntArray.get(index2)) {
                    case 1:
                        i = indexCount2;
                        layout.baselineToBaseline = lookupID(obtainStyledAttributes, index2, layout.baselineToBaseline);
                        continue;
                        i7++;
                    case 2:
                        i = indexCount2;
                        layout.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(index2, layout.bottomMargin);
                        continue;
                        i7++;
                    case 3:
                        i = indexCount2;
                        layout.bottomToBottom = lookupID(obtainStyledAttributes, index2, layout.bottomToBottom);
                        continue;
                        i7++;
                    case 4:
                        i = indexCount2;
                        layout.bottomToTop = lookupID(obtainStyledAttributes, index2, layout.bottomToTop);
                        continue;
                        i7++;
                    case 5:
                        i = indexCount2;
                        layout.dimensionRatio = obtainStyledAttributes.getString(index2);
                        continue;
                        i7++;
                    case 6:
                        i = indexCount2;
                        layout.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index2, layout.editorAbsoluteX);
                        continue;
                        i7++;
                    case 7:
                        i = indexCount2;
                        layout.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index2, layout.editorAbsoluteY);
                        continue;
                        i7++;
                    case 8:
                        i = indexCount2;
                        layout.endMargin = obtainStyledAttributes.getDimensionPixelSize(index2, layout.endMargin);
                        continue;
                        i7++;
                    case 9:
                        i = indexCount2;
                        layout.endToEnd = lookupID(obtainStyledAttributes, index2, layout.endToEnd);
                        continue;
                        i7++;
                    case 10:
                        i = indexCount2;
                        layout.endToStart = lookupID(obtainStyledAttributes, index2, layout.endToStart);
                        continue;
                        i7++;
                    case 11:
                        i = indexCount2;
                        layout.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index2, layout.goneBottomMargin);
                        continue;
                        i7++;
                    case 12:
                        i = indexCount2;
                        layout.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index2, layout.goneEndMargin);
                        continue;
                        i7++;
                    case 13:
                        i = indexCount2;
                        layout.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index2, layout.goneLeftMargin);
                        continue;
                        i7++;
                    case 14:
                        i = indexCount2;
                        layout.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index2, layout.goneRightMargin);
                        continue;
                        i7++;
                    case 15:
                        i = indexCount2;
                        layout.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index2, layout.goneStartMargin);
                        continue;
                        i7++;
                    case 16:
                        i = indexCount2;
                        layout.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index2, layout.goneTopMargin);
                        continue;
                        i7++;
                    case 17:
                        i = indexCount2;
                        layout.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index2, layout.guideBegin);
                        continue;
                        i7++;
                    case 18:
                        i = indexCount2;
                        layout.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index2, layout.guideEnd);
                        continue;
                        i7++;
                    case 19:
                        i = indexCount2;
                        layout.guidePercent = obtainStyledAttributes.getFloat(index2, layout.guidePercent);
                        continue;
                        i7++;
                    case 20:
                        i = indexCount2;
                        layout.horizontalBias = obtainStyledAttributes.getFloat(index2, layout.horizontalBias);
                        continue;
                        i7++;
                    case 21:
                        i = indexCount2;
                        layout.mHeight = obtainStyledAttributes.getLayoutDimension(index2, layout.mHeight);
                        continue;
                        i7++;
                    case 22:
                        i = indexCount2;
                        int i8 = obtainStyledAttributes.getInt(index2, propertySet.visibility);
                        propertySet.visibility = i8;
                        propertySet.visibility = iArr2[i8];
                        continue;
                        i7++;
                    case 23:
                        i = indexCount2;
                        layout.mWidth = obtainStyledAttributes.getLayoutDimension(index2, layout.mWidth);
                        continue;
                        i7++;
                    case 24:
                        i = indexCount2;
                        layout.leftMargin = obtainStyledAttributes.getDimensionPixelSize(index2, layout.leftMargin);
                        continue;
                        i7++;
                    case 25:
                        i = indexCount2;
                        layout.leftToLeft = lookupID(obtainStyledAttributes, index2, layout.leftToLeft);
                        continue;
                        i7++;
                    case 26:
                        i = indexCount2;
                        layout.leftToRight = lookupID(obtainStyledAttributes, index2, layout.leftToRight);
                        continue;
                        i7++;
                    case 27:
                        i = indexCount2;
                        layout.orientation = obtainStyledAttributes.getInt(index2, layout.orientation);
                        continue;
                        i7++;
                    case 28:
                        i = indexCount2;
                        layout.rightMargin = obtainStyledAttributes.getDimensionPixelSize(index2, layout.rightMargin);
                        continue;
                        i7++;
                    case 29:
                        i = indexCount2;
                        layout.rightToLeft = lookupID(obtainStyledAttributes, index2, layout.rightToLeft);
                        continue;
                        i7++;
                    case 30:
                        i = indexCount2;
                        layout.rightToRight = lookupID(obtainStyledAttributes, index2, layout.rightToRight);
                        continue;
                        i7++;
                    case 31:
                        i = indexCount2;
                        layout.startMargin = obtainStyledAttributes.getDimensionPixelSize(index2, layout.startMargin);
                        continue;
                        i7++;
                    case 32:
                        i = indexCount2;
                        layout.startToEnd = lookupID(obtainStyledAttributes, index2, layout.startToEnd);
                        continue;
                        i7++;
                    case 33:
                        i = indexCount2;
                        layout.startToStart = lookupID(obtainStyledAttributes, index2, layout.startToStart);
                        continue;
                        i7++;
                    case 34:
                        i = indexCount2;
                        layout.topMargin = obtainStyledAttributes.getDimensionPixelSize(index2, layout.topMargin);
                        continue;
                        i7++;
                    case 35:
                        i = indexCount2;
                        layout.topToBottom = lookupID(obtainStyledAttributes, index2, layout.topToBottom);
                        continue;
                        i7++;
                    case 36:
                        i = indexCount2;
                        layout.topToTop = lookupID(obtainStyledAttributes, index2, layout.topToTop);
                        continue;
                        i7++;
                    case 37:
                        i = indexCount2;
                        layout.verticalBias = obtainStyledAttributes.getFloat(index2, layout.verticalBias);
                        continue;
                        i7++;
                    case 38:
                        i = indexCount2;
                        constraint.mViewId = obtainStyledAttributes.getResourceId(index2, constraint.mViewId);
                        continue;
                        i7++;
                    case 39:
                        i = indexCount2;
                        layout.horizontalWeight = obtainStyledAttributes.getFloat(index2, layout.horizontalWeight);
                        continue;
                        i7++;
                    case 40:
                        i = indexCount2;
                        layout.verticalWeight = obtainStyledAttributes.getFloat(index2, layout.verticalWeight);
                        continue;
                        i7++;
                    case 41:
                        i = indexCount2;
                        layout.horizontalChainStyle = obtainStyledAttributes.getInt(index2, layout.horizontalChainStyle);
                        continue;
                        i7++;
                    case 42:
                        i = indexCount2;
                        layout.verticalChainStyle = obtainStyledAttributes.getInt(index2, layout.verticalChainStyle);
                        continue;
                        i7++;
                    case 43:
                        i = indexCount2;
                        propertySet.alpha = obtainStyledAttributes.getFloat(index2, propertySet.alpha);
                        continue;
                        i7++;
                    case 44:
                        i = indexCount2;
                        transform.applyElevation = true;
                        transform.elevation = obtainStyledAttributes.getDimension(index2, transform.elevation);
                        continue;
                        i7++;
                    case 45:
                        i = indexCount2;
                        transform.rotationX = obtainStyledAttributes.getFloat(index2, transform.rotationX);
                        continue;
                        i7++;
                    case 46:
                        i = indexCount2;
                        transform.rotationY = obtainStyledAttributes.getFloat(index2, transform.rotationY);
                        continue;
                        i7++;
                    case 47:
                        i = indexCount2;
                        transform.scaleX = obtainStyledAttributes.getFloat(index2, transform.scaleX);
                        continue;
                        i7++;
                    case 48:
                        i = indexCount2;
                        transform.scaleY = obtainStyledAttributes.getFloat(index2, transform.scaleY);
                        continue;
                        i7++;
                    case 49:
                        i = indexCount2;
                        transform.transformPivotX = obtainStyledAttributes.getDimension(index2, transform.transformPivotX);
                        continue;
                        i7++;
                    case 50:
                        i = indexCount2;
                        transform.transformPivotY = obtainStyledAttributes.getDimension(index2, transform.transformPivotY);
                        continue;
                        i7++;
                    case 51:
                        i = indexCount2;
                        transform.translationX = obtainStyledAttributes.getDimension(index2, transform.translationX);
                        continue;
                        i7++;
                    case 52:
                        i = indexCount2;
                        transform.translationY = obtainStyledAttributes.getDimension(index2, transform.translationY);
                        continue;
                        i7++;
                    case 53:
                        i = indexCount2;
                        transform.translationZ = obtainStyledAttributes.getDimension(index2, transform.translationZ);
                        continue;
                        i7++;
                    case 54:
                        i = indexCount2;
                        layout.widthDefault = obtainStyledAttributes.getInt(index2, layout.widthDefault);
                        continue;
                        i7++;
                    case 55:
                        i = indexCount2;
                        layout.heightDefault = obtainStyledAttributes.getInt(index2, layout.heightDefault);
                        continue;
                        i7++;
                    case 56:
                        i = indexCount2;
                        layout.widthMax = obtainStyledAttributes.getDimensionPixelSize(index2, layout.widthMax);
                        continue;
                        i7++;
                    case 57:
                        i = indexCount2;
                        layout.heightMax = obtainStyledAttributes.getDimensionPixelSize(index2, layout.heightMax);
                        continue;
                        i7++;
                    case 58:
                        i = indexCount2;
                        layout.widthMin = obtainStyledAttributes.getDimensionPixelSize(index2, layout.widthMin);
                        continue;
                        i7++;
                    case 59:
                        i = indexCount2;
                        layout.heightMin = obtainStyledAttributes.getDimensionPixelSize(index2, layout.heightMin);
                        continue;
                        i7++;
                    case 60:
                        i = indexCount2;
                        transform.rotation = obtainStyledAttributes.getFloat(index2, transform.rotation);
                        continue;
                        i7++;
                    case 61:
                        i = indexCount2;
                        layout.circleConstraint = lookupID(obtainStyledAttributes, index2, layout.circleConstraint);
                        continue;
                        i7++;
                    case 62:
                        i = indexCount2;
                        layout.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index2, layout.circleRadius);
                        continue;
                        i7++;
                    case 63:
                        i = indexCount2;
                        layout.circleAngle = obtainStyledAttributes.getFloat(index2, layout.circleAngle);
                        continue;
                        i7++;
                    case 64:
                        i = indexCount2;
                        motion.mAnimateRelativeTo = lookupID(obtainStyledAttributes, index2, motion.mAnimateRelativeTo);
                        continue;
                        i7++;
                    case 65:
                        i = indexCount2;
                        if (obtainStyledAttributes.peekValue(index2).type == 3) {
                            obtainStyledAttributes.getString(index2);
                            motion.getClass();
                            break;
                        } else {
                            String str = strArr[obtainStyledAttributes.getInteger(index2, 0)];
                            motion.getClass();
                            continue;
                            i7++;
                        }
                    case 66:
                        i = indexCount2;
                        obtainStyledAttributes.getInt(index2, 0);
                        motion.getClass();
                        continue;
                        i7++;
                    case 67:
                        i = indexCount2;
                        motion.mPathRotate = obtainStyledAttributes.getFloat(index2, motion.mPathRotate);
                        break;
                    case 68:
                        i = indexCount2;
                        propertySet.mProgress = obtainStyledAttributes.getFloat(index2, propertySet.mProgress);
                        break;
                    case 69:
                        i = indexCount2;
                        layout.widthPercent = obtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 70:
                        i = indexCount2;
                        layout.heightPercent = obtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 71:
                        i = indexCount2;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i = indexCount2;
                        layout.mBarrierDirection = obtainStyledAttributes.getInt(index2, layout.mBarrierDirection);
                        break;
                    case 73:
                        i = indexCount2;
                        layout.mBarrierMargin = obtainStyledAttributes.getDimensionPixelSize(index2, layout.mBarrierMargin);
                        break;
                    case 74:
                        i = indexCount2;
                        layout.mReferenceIdString = obtainStyledAttributes.getString(index2);
                        break;
                    case 75:
                        i = indexCount2;
                        layout.mBarrierAllowsGoneWidgets = obtainStyledAttributes.getBoolean(index2, layout.mBarrierAllowsGoneWidgets);
                        break;
                    case 76:
                        i = indexCount2;
                        motion.mPathMotionArc = obtainStyledAttributes.getInt(index2, motion.mPathMotionArc);
                        break;
                    case 77:
                        i = indexCount2;
                        layout.mConstraintTag = obtainStyledAttributes.getString(index2);
                        break;
                    case 78:
                        i = indexCount2;
                        propertySet.mVisibilityMode = obtainStyledAttributes.getInt(index2, propertySet.mVisibilityMode);
                        break;
                    case 79:
                        i = indexCount2;
                        motion.mMotionStagger = obtainStyledAttributes.getFloat(index2, motion.mMotionStagger);
                        break;
                    case 80:
                        i = indexCount2;
                        layout.constrainedWidth = obtainStyledAttributes.getBoolean(index2, layout.constrainedWidth);
                        break;
                    case 81:
                        i = indexCount2;
                        layout.constrainedHeight = obtainStyledAttributes.getBoolean(index2, layout.constrainedHeight);
                        break;
                    case 82:
                        i = indexCount2;
                        motion.mAnimateCircleAngleTo = obtainStyledAttributes.getInteger(index2, motion.mAnimateCircleAngleTo);
                        break;
                    case 83:
                        i = indexCount2;
                        transform.transformPivotTarget = lookupID(obtainStyledAttributes, index2, transform.transformPivotTarget);
                        break;
                    case 84:
                        i = indexCount2;
                        motion.mQuantizeMotionSteps = obtainStyledAttributes.getInteger(index2, motion.mQuantizeMotionSteps);
                        break;
                    case 85:
                        i = indexCount2;
                        motion.mQuantizeMotionPhase = obtainStyledAttributes.getFloat(index2, motion.mQuantizeMotionPhase);
                        break;
                    case 86:
                        i = indexCount2;
                        int i9 = obtainStyledAttributes.peekValue(index2).type;
                        if (i9 != 1) {
                            if (i9 == 3) {
                                String string2 = obtainStyledAttributes.getString(index2);
                                motion.mQuantizeInterpolatorString = string2;
                                if (string2.indexOf("/") > 0) {
                                    motion.mQuantizeInterpolatorID = obtainStyledAttributes.getResourceId(index2, -1);
                                    break;
                                }
                            } else {
                                obtainStyledAttributes.getInteger(index2, motion.mQuantizeInterpolatorID);
                                break;
                            }
                        } else {
                            motion.mQuantizeInterpolatorID = obtainStyledAttributes.getResourceId(index2, -1);
                            break;
                        }
                        break;
                    case 87:
                        i = indexCount2;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index2) + "   " + sparseIntArray.get(index2));
                        break;
                    case 88:
                    case 89:
                    case 90:
                    default:
                        StringBuilder sb2 = new StringBuilder("Unknown attribute 0x");
                        i = indexCount2;
                        sb2.append(Integer.toHexString(index2));
                        sb2.append("   ");
                        sb2.append(sparseIntArray.get(index2));
                        Log.w("ConstraintSet", sb2.toString());
                        break;
                    case 91:
                        i = indexCount2;
                        layout.baselineToTop = lookupID(obtainStyledAttributes, index2, layout.baselineToTop);
                        break;
                    case 92:
                        i = indexCount2;
                        layout.baselineToBottom = lookupID(obtainStyledAttributes, index2, layout.baselineToBottom);
                        break;
                    case 93:
                        i = indexCount2;
                        layout.baselineMargin = obtainStyledAttributes.getDimensionPixelSize(index2, layout.baselineMargin);
                        break;
                    case 94:
                        i = indexCount2;
                        layout.goneBaselineMargin = obtainStyledAttributes.getDimensionPixelSize(index2, layout.goneBaselineMargin);
                        break;
                    case 95:
                        i = indexCount2;
                        parseDimensionConstraints(layout, obtainStyledAttributes, index2, 0);
                        continue;
                        i7++;
                    case 96:
                        i = indexCount2;
                        parseDimensionConstraints(layout, obtainStyledAttributes, index2, 1);
                        break;
                    case 97:
                        i = indexCount2;
                        layout.mWrapBehavior = obtainStyledAttributes.getInt(index2, layout.mWrapBehavior);
                        break;
                }
                i7++;
            }
            if (layout.mReferenceIdString != null) {
                layout.mReferenceIds = null;
            }
        }
        obtainStyledAttributes.recycle();
        return constraint;
    }

    public static int lookupID(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        if (resourceId == -1) {
            return typedArray.getInt(i, -1);
        }
        return resourceId;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
        if (r8 == (-1)) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void parseDimensionConstraints(Object obj, TypedArray typedArray, int i, int i2) {
        int dimensionPixelSize;
        if (obj != null) {
            int i3 = typedArray.peekValue(i).type;
            boolean z = true;
            int i4 = 0;
            if (i3 != 3) {
                if (i3 != 5) {
                    dimensionPixelSize = typedArray.getInt(i, 0);
                    if (dimensionPixelSize != -4) {
                        if (dimensionPixelSize != -3) {
                            if (dimensionPixelSize != -2) {
                            }
                        }
                        z = false;
                        if (obj instanceof ConstraintLayout.LayoutParams) {
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
                            if (i2 == 0) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).width = i4;
                                layoutParams.constrainedWidth = z;
                                return;
                            }
                            ((ViewGroup.MarginLayoutParams) layoutParams).height = i4;
                            layoutParams.constrainedHeight = z;
                            return;
                        } else if (obj instanceof Layout) {
                            Layout layout = (Layout) obj;
                            if (i2 == 0) {
                                layout.mWidth = i4;
                                layout.constrainedWidth = z;
                                return;
                            }
                            layout.mHeight = i4;
                            layout.constrainedHeight = z;
                            return;
                        } else if (obj instanceof Constraint.Delta) {
                            Constraint.Delta delta = (Constraint.Delta) obj;
                            if (i2 == 0) {
                                delta.add(23, i4);
                                delta.add(80, z);
                                return;
                            }
                            delta.add(21, i4);
                            delta.add(81, z);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        i4 = -2;
                        if (obj instanceof ConstraintLayout.LayoutParams) {
                        }
                    }
                } else {
                    dimensionPixelSize = typedArray.getDimensionPixelSize(i, 0);
                }
                i4 = dimensionPixelSize;
                z = false;
                if (obj instanceof ConstraintLayout.LayoutParams) {
                }
            } else {
                String string = typedArray.getString(i);
                if (string != null) {
                    int indexOf = string.indexOf(61);
                    int length = string.length();
                    if (indexOf > 0 && indexOf < length - 1) {
                        String substring = string.substring(0, indexOf);
                        String substring2 = string.substring(indexOf + 1);
                        if (substring2.length() > 0) {
                            String trim = substring.trim();
                            String trim2 = substring2.trim();
                            if (!"ratio".equalsIgnoreCase(trim)) {
                                try {
                                    if ("weight".equalsIgnoreCase(trim)) {
                                        float parseFloat = Float.parseFloat(trim2);
                                        if (obj instanceof ConstraintLayout.LayoutParams) {
                                            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) obj;
                                            if (i2 == 0) {
                                                ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
                                                layoutParams2.horizontalWeight = parseFloat;
                                                return;
                                            }
                                            ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
                                            layoutParams2.verticalWeight = parseFloat;
                                        } else if (obj instanceof Layout) {
                                            Layout layout2 = (Layout) obj;
                                            if (i2 == 0) {
                                                layout2.mWidth = 0;
                                                layout2.horizontalWeight = parseFloat;
                                                return;
                                            }
                                            layout2.mHeight = 0;
                                            layout2.verticalWeight = parseFloat;
                                        } else if (obj instanceof Constraint.Delta) {
                                            Constraint.Delta delta2 = (Constraint.Delta) obj;
                                            if (i2 == 0) {
                                                delta2.add(23, 0);
                                                delta2.add(39, parseFloat);
                                                return;
                                            }
                                            delta2.add(21, 0);
                                            delta2.add(40, parseFloat);
                                        }
                                    } else if ("parent".equalsIgnoreCase(trim)) {
                                        float max = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(trim2)));
                                        if (obj instanceof ConstraintLayout.LayoutParams) {
                                            ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) obj;
                                            if (i2 == 0) {
                                                ((ViewGroup.MarginLayoutParams) layoutParams3).width = 0;
                                                layoutParams3.matchConstraintPercentWidth = max;
                                                layoutParams3.matchConstraintDefaultWidth = 2;
                                                return;
                                            }
                                            ((ViewGroup.MarginLayoutParams) layoutParams3).height = 0;
                                            layoutParams3.matchConstraintPercentHeight = max;
                                            layoutParams3.matchConstraintDefaultHeight = 2;
                                        } else if (obj instanceof Layout) {
                                            Layout layout3 = (Layout) obj;
                                            if (i2 == 0) {
                                                layout3.mWidth = 0;
                                                layout3.widthPercent = max;
                                                layout3.widthDefault = 2;
                                                return;
                                            }
                                            layout3.mHeight = 0;
                                            layout3.heightPercent = max;
                                            layout3.heightDefault = 2;
                                        } else if (obj instanceof Constraint.Delta) {
                                            Constraint.Delta delta3 = (Constraint.Delta) obj;
                                            if (i2 == 0) {
                                                delta3.add(23, 0);
                                                delta3.add(54, 2);
                                                return;
                                            }
                                            delta3.add(21, 0);
                                            delta3.add(55, 2);
                                        }
                                    }
                                } catch (NumberFormatException unused) {
                                }
                            } else if (obj instanceof ConstraintLayout.LayoutParams) {
                                ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) obj;
                                if (i2 == 0) {
                                    ((ViewGroup.MarginLayoutParams) layoutParams4).width = 0;
                                } else {
                                    ((ViewGroup.MarginLayoutParams) layoutParams4).height = 0;
                                }
                                parseDimensionRatioString(layoutParams4, trim2);
                            } else if (obj instanceof Layout) {
                                ((Layout) obj).dimensionRatio = trim2;
                            } else if (obj instanceof Constraint.Delta) {
                                ((Constraint.Delta) obj).add(5, trim2);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void parseDimensionRatioString(ConstraintLayout.LayoutParams layoutParams, String str) {
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i = 0;
            int i2 = -1;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (!substring.equalsIgnoreCase("W")) {
                    if (substring.equalsIgnoreCase("H")) {
                        i = 1;
                    } else {
                        i = -1;
                    }
                }
                i2 = i;
                i = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            try {
                if (indexOf2 < 0 || indexOf2 >= length - 1) {
                    String substring2 = str.substring(i);
                    if (substring2.length() > 0) {
                        Float.parseFloat(substring2);
                    }
                } else {
                    String substring3 = str.substring(i, indexOf2);
                    String substring4 = str.substring(indexOf2 + 1);
                    if (substring3.length() > 0 && substring4.length() > 0) {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            if (i2 == 1) {
                                Math.abs(parseFloat2 / parseFloat);
                            } else {
                                Math.abs(parseFloat / parseFloat2);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        layoutParams.dimensionRatio = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4, types: [androidx.constraintlayout.widget.Barrier, android.view.View, androidx.constraintlayout.widget.ConstraintHelper] */
    /* JADX WARN: Type inference failed for: r8v2, types: [androidx.constraintlayout.core.widgets.Barrier, androidx.constraintlayout.core.widgets.HelperWidget] */
    public final void applyToInternal(ConstraintLayout constraintLayout) {
        int i;
        HashSet hashSet;
        View findViewById;
        int i2;
        String str;
        HashMap hashMap;
        NoSuchMethodException e;
        IllegalAccessException e2;
        InvocationTargetException e3;
        String str2;
        ConstraintSet constraintSet = this;
        int childCount = constraintLayout.getChildCount();
        HashMap hashMap2 = constraintSet.mConstraints;
        HashSet hashSet2 = new HashSet(hashMap2.keySet());
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = constraintLayout.getChildAt(i3);
            int id = childAt.getId();
            if (!hashMap2.containsKey(Integer.valueOf(id))) {
                StringBuilder sb = new StringBuilder("id unknown ");
                try {
                    str2 = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    str2 = "UNKNOWN";
                }
                sb.append(str2);
                Log.w("ConstraintSet", sb.toString());
            } else if (constraintSet.mForceId && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1) {
                if (hashMap2.containsKey(Integer.valueOf(id))) {
                    hashSet2.remove(Integer.valueOf(id));
                    Constraint constraint = (Constraint) hashMap2.get(Integer.valueOf(id));
                    if (constraint != null) {
                        PropertySet propertySet = constraint.propertySet;
                        Layout layout = constraint.layout;
                        Transform transform = constraint.transform;
                        if (childAt instanceof Barrier) {
                            layout.mHelperType = 1;
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(layout.mBarrierDirection);
                            barrier.setMargin(layout.mBarrierMargin);
                            barrier.setAllowsGoneWidget(layout.mBarrierAllowsGoneWidgets);
                            int[] iArr = layout.mReferenceIds;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str3 = layout.mReferenceIdString;
                                if (str3 != null) {
                                    int[] convertReferenceString = convertReferenceString(barrier, str3);
                                    layout.mReferenceIds = convertReferenceString;
                                    barrier.setReferencedIds(convertReferenceString);
                                }
                            }
                        }
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.validate();
                        constraint.applyTo(layoutParams);
                        HashMap hashMap3 = constraint.mCustomConstraints;
                        Class<?> cls = childAt.getClass();
                        for (String str4 : hashMap3.keySet()) {
                            ConstraintAttribute constraintAttribute = (ConstraintAttribute) hashMap3.get(str4);
                            HashSet hashSet3 = hashSet2;
                            if (!constraintAttribute.mMethod) {
                                i2 = i3;
                                str = "set" + str4;
                            } else {
                                i2 = i3;
                                str = str4;
                            }
                            try {
                                int ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(constraintAttribute.mType);
                                Class<?> cls2 = Float.TYPE;
                                Class<?> cls3 = Integer.TYPE;
                                switch (ordinal) {
                                    case 0:
                                        hashMap = hashMap3;
                                        cls.getMethod(str, cls3).invoke(childAt, Integer.valueOf(constraintAttribute.mIntegerValue));
                                        break;
                                    case 1:
                                        hashMap = hashMap3;
                                        cls.getMethod(str, cls2).invoke(childAt, Float.valueOf(constraintAttribute.mFloatValue));
                                        break;
                                    case 2:
                                        hashMap = hashMap3;
                                        cls.getMethod(str, cls3).invoke(childAt, Integer.valueOf(constraintAttribute.mColorValue));
                                        break;
                                    case 3:
                                        hashMap = hashMap3;
                                        Method method = cls.getMethod(str, Drawable.class);
                                        ColorDrawable colorDrawable = new ColorDrawable();
                                        colorDrawable.setColor(constraintAttribute.mColorValue);
                                        method.invoke(childAt, colorDrawable);
                                        break;
                                    case 4:
                                        hashMap = hashMap3;
                                        cls.getMethod(str, CharSequence.class).invoke(childAt, constraintAttribute.mStringValue);
                                        break;
                                    case 5:
                                        hashMap = hashMap3;
                                        cls.getMethod(str, Boolean.TYPE).invoke(childAt, Boolean.valueOf(constraintAttribute.mBooleanValue));
                                        break;
                                    case 6:
                                        hashMap = hashMap3;
                                        cls.getMethod(str, cls2).invoke(childAt, Float.valueOf(constraintAttribute.mFloatValue));
                                        break;
                                    case 7:
                                        hashMap = hashMap3;
                                        try {
                                            cls.getMethod(str, cls3).invoke(childAt, Integer.valueOf(constraintAttribute.mIntegerValue));
                                        } catch (IllegalAccessException e4) {
                                            e2 = e4;
                                            StringBuilder m = ViewModelProvider.Factory.CC.m594m(" Custom Attribute \"", str4, "\" not found on ");
                                            m.append(cls.getName());
                                            Log.e("TransitionLayout", m.toString(), e2);
                                            hashSet2 = hashSet3;
                                            i3 = i2;
                                            hashMap3 = hashMap;
                                        } catch (NoSuchMethodException e5) {
                                            e = e5;
                                            Log.e("TransitionLayout", cls.getName() + " must have a method " + str, e);
                                            hashSet2 = hashSet3;
                                            i3 = i2;
                                            hashMap3 = hashMap;
                                        } catch (InvocationTargetException e6) {
                                            e3 = e6;
                                            StringBuilder m2 = ViewModelProvider.Factory.CC.m594m(" Custom Attribute \"", str4, "\" not found on ");
                                            m2.append(cls.getName());
                                            Log.e("TransitionLayout", m2.toString(), e3);
                                            hashSet2 = hashSet3;
                                            i3 = i2;
                                            hashMap3 = hashMap;
                                        }
                                    default:
                                        hashMap = hashMap3;
                                        break;
                                }
                            } catch (IllegalAccessException e7) {
                                e2 = e7;
                                hashMap = hashMap3;
                            } catch (NoSuchMethodException e8) {
                                e = e8;
                                hashMap = hashMap3;
                            } catch (InvocationTargetException e9) {
                                e3 = e9;
                                hashMap = hashMap3;
                            }
                            hashSet2 = hashSet3;
                            i3 = i2;
                            hashMap3 = hashMap;
                        }
                        hashSet = hashSet2;
                        i = i3;
                        childAt.setLayoutParams(layoutParams);
                        if (propertySet.mVisibilityMode == 0) {
                            childAt.setVisibility(propertySet.visibility);
                        }
                        childAt.setAlpha(propertySet.alpha);
                        childAt.setRotation(transform.rotation);
                        childAt.setRotationX(transform.rotationX);
                        childAt.setRotationY(transform.rotationY);
                        childAt.setScaleX(transform.scaleX);
                        childAt.setScaleY(transform.scaleY);
                        if (transform.transformPivotTarget != -1) {
                            if (((View) childAt.getParent()).findViewById(transform.transformPivotTarget) != null) {
                                float bottom = (findViewById.getBottom() + findViewById.getTop()) / 2.0f;
                                float right = (findViewById.getRight() + findViewById.getLeft()) / 2.0f;
                                if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                    childAt.setPivotX(right - childAt.getLeft());
                                    childAt.setPivotY(bottom - childAt.getTop());
                                }
                            }
                        } else {
                            if (!Float.isNaN(transform.transformPivotX)) {
                                childAt.setPivotX(transform.transformPivotX);
                            }
                            if (!Float.isNaN(transform.transformPivotY)) {
                                childAt.setPivotY(transform.transformPivotY);
                            }
                        }
                        childAt.setTranslationX(transform.translationX);
                        childAt.setTranslationY(transform.translationY);
                        childAt.setTranslationZ(transform.translationZ);
                        if (transform.applyElevation) {
                            childAt.setElevation(transform.elevation);
                        }
                    }
                } else {
                    hashSet = hashSet2;
                    i = i3;
                    Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                }
                i3 = i + 1;
                constraintSet = this;
                hashSet2 = hashSet;
            }
            hashSet = hashSet2;
            i = i3;
            i3 = i + 1;
            constraintSet = this;
            hashSet2 = hashSet;
        }
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Constraint constraint2 = (Constraint) hashMap2.get(num);
            if (constraint2 != null) {
                Layout layout2 = constraint2.layout;
                if (layout2.mHelperType == 1) {
                    Context context = constraintLayout.getContext();
                    ?? view = new View(context);
                    view.mIds = new int[32];
                    view.mMap = new HashMap();
                    view.myContext = context;
                    ?? helperWidget = new HelperWidget();
                    helperWidget.mBarrierType = 0;
                    helperWidget.mAllowsGoneWidget = true;
                    helperWidget.mMargin = 0;
                    helperWidget.mResolved = false;
                    view.mBarrier = helperWidget;
                    view.mHelperWidget = helperWidget;
                    view.validateParams();
                    view.setVisibility(8);
                    view.setId(num.intValue());
                    int[] iArr2 = layout2.mReferenceIds;
                    if (iArr2 != null) {
                        view.setReferencedIds(iArr2);
                    } else {
                        String str5 = layout2.mReferenceIdString;
                        if (str5 != null) {
                            int[] convertReferenceString2 = convertReferenceString(view, str5);
                            layout2.mReferenceIds = convertReferenceString2;
                            view.setReferencedIds(convertReferenceString2);
                        }
                    }
                    view.setType(layout2.mBarrierDirection);
                    view.setMargin(layout2.mBarrierMargin);
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams = ConstraintLayout.generateDefaultLayoutParams();
                    view.validateParams();
                    constraint2.applyTo(generateDefaultLayoutParams);
                    constraintLayout.addView((View) view, generateDefaultLayoutParams);
                }
                if (layout2.mIsGuideline) {
                    Guideline guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = ConstraintLayout.generateDefaultLayoutParams();
                    constraint2.applyTo(generateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, generateDefaultLayoutParams2);
                }
            }
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = constraintLayout.getChildAt(i4);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).applyLayoutFeaturesInConstraintSet(constraintLayout);
            }
        }
    }

    public final void clone(ConstraintLayout constraintLayout) {
        int i;
        HashMap hashMap;
        int i2;
        ConstraintSet constraintSet = this;
        int childCount = constraintLayout.getChildCount();
        HashMap hashMap2 = constraintSet.mConstraints;
        hashMap2.clear();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = constraintLayout.getChildAt(i3);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!constraintSet.mForceId || id != -1) {
                if (!hashMap2.containsKey(Integer.valueOf(id))) {
                    hashMap2.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = (Constraint) hashMap2.get(Integer.valueOf(id));
                if (constraint == null) {
                    i2 = childCount;
                    hashMap = hashMap2;
                    i = i3;
                } else {
                    PropertySet propertySet = constraint.propertySet;
                    Layout layout = constraint.layout;
                    Transform transform = constraint.transform;
                    i2 = childCount;
                    HashMap hashMap3 = new HashMap();
                    hashMap = hashMap2;
                    Class<?> cls = childAt.getClass();
                    i = i3;
                    HashMap hashMap4 = constraintSet.mSavedAttributes;
                    for (String str : hashMap4.keySet()) {
                        ConstraintAttribute constraintAttribute = (ConstraintAttribute) hashMap4.get(str);
                        HashMap hashMap5 = hashMap4;
                        try {
                            if (str.equals("BackgroundColor")) {
                                hashMap3.put(str, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                            } else {
                                hashMap3.put(str, new ConstraintAttribute(constraintAttribute, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                            }
                        } catch (IllegalAccessException e) {
                            StringBuilder m = ViewModelProvider.Factory.CC.m594m(" Custom Attribute \"", str, "\" not found on ");
                            m.append(cls.getName());
                            Log.e("TransitionLayout", m.toString(), e);
                        } catch (NoSuchMethodException e2) {
                            Log.e("TransitionLayout", cls.getName() + " must have a method " + str, e2);
                        } catch (InvocationTargetException e3) {
                            StringBuilder m2 = ViewModelProvider.Factory.CC.m594m(" Custom Attribute \"", str, "\" not found on ");
                            m2.append(cls.getName());
                            Log.e("TransitionLayout", m2.toString(), e3);
                        }
                        hashMap4 = hashMap5;
                    }
                    constraint.mCustomConstraints = hashMap3;
                    constraint.mViewId = id;
                    layout.leftToLeft = layoutParams.leftToLeft;
                    layout.leftToRight = layoutParams.leftToRight;
                    layout.rightToLeft = layoutParams.rightToLeft;
                    layout.rightToRight = layoutParams.rightToRight;
                    layout.topToTop = layoutParams.topToTop;
                    layout.topToBottom = layoutParams.topToBottom;
                    layout.bottomToTop = layoutParams.bottomToTop;
                    layout.bottomToBottom = layoutParams.bottomToBottom;
                    layout.baselineToBaseline = layoutParams.baselineToBaseline;
                    layout.baselineToTop = layoutParams.baselineToTop;
                    layout.baselineToBottom = layoutParams.baselineToBottom;
                    layout.startToEnd = layoutParams.startToEnd;
                    layout.startToStart = layoutParams.startToStart;
                    layout.endToStart = layoutParams.endToStart;
                    layout.endToEnd = layoutParams.endToEnd;
                    layout.horizontalBias = layoutParams.horizontalBias;
                    layout.verticalBias = layoutParams.verticalBias;
                    layout.dimensionRatio = layoutParams.dimensionRatio;
                    layout.circleConstraint = layoutParams.circleConstraint;
                    layout.circleRadius = layoutParams.circleRadius;
                    layout.circleAngle = layoutParams.circleAngle;
                    layout.editorAbsoluteX = layoutParams.editorAbsoluteX;
                    layout.editorAbsoluteY = layoutParams.editorAbsoluteY;
                    layout.orientation = layoutParams.orientation;
                    layout.guidePercent = layoutParams.guidePercent;
                    layout.guideBegin = layoutParams.guideBegin;
                    layout.guideEnd = layoutParams.guideEnd;
                    layout.mWidth = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                    layout.mHeight = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    layout.leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    layout.rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    layout.topMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    layout.bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    layout.baselineMargin = layoutParams.baselineMargin;
                    layout.verticalWeight = layoutParams.verticalWeight;
                    layout.horizontalWeight = layoutParams.horizontalWeight;
                    layout.verticalChainStyle = layoutParams.verticalChainStyle;
                    layout.horizontalChainStyle = layoutParams.horizontalChainStyle;
                    layout.constrainedWidth = layoutParams.constrainedWidth;
                    layout.constrainedHeight = layoutParams.constrainedHeight;
                    layout.widthDefault = layoutParams.matchConstraintDefaultWidth;
                    layout.heightDefault = layoutParams.matchConstraintDefaultHeight;
                    layout.widthMax = layoutParams.matchConstraintMaxWidth;
                    layout.heightMax = layoutParams.matchConstraintMaxHeight;
                    layout.widthMin = layoutParams.matchConstraintMinWidth;
                    layout.heightMin = layoutParams.matchConstraintMinHeight;
                    layout.widthPercent = layoutParams.matchConstraintPercentWidth;
                    layout.heightPercent = layoutParams.matchConstraintPercentHeight;
                    layout.mConstraintTag = layoutParams.constraintTag;
                    layout.goneTopMargin = layoutParams.goneTopMargin;
                    layout.goneBottomMargin = layoutParams.goneBottomMargin;
                    layout.goneLeftMargin = layoutParams.goneLeftMargin;
                    layout.goneRightMargin = layoutParams.goneRightMargin;
                    layout.goneStartMargin = layoutParams.goneStartMargin;
                    layout.goneEndMargin = layoutParams.goneEndMargin;
                    layout.goneBaselineMargin = layoutParams.goneBaselineMargin;
                    layout.mWrapBehavior = layoutParams.wrapBehaviorInParent;
                    layout.endMargin = layoutParams.getMarginEnd();
                    layout.startMargin = layoutParams.getMarginStart();
                    propertySet.visibility = childAt.getVisibility();
                    propertySet.alpha = childAt.getAlpha();
                    transform.rotation = childAt.getRotation();
                    transform.rotationX = childAt.getRotationX();
                    transform.rotationY = childAt.getRotationY();
                    transform.scaleX = childAt.getScaleX();
                    transform.scaleY = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(pivotX == 0.0d && pivotY == 0.0d)) {
                        transform.transformPivotX = pivotX;
                        transform.transformPivotY = pivotY;
                    }
                    transform.translationX = childAt.getTranslationX();
                    transform.translationY = childAt.getTranslationY();
                    transform.translationZ = childAt.getTranslationZ();
                    if (transform.applyElevation) {
                        transform.elevation = childAt.getElevation();
                    }
                    if (childAt instanceof Barrier) {
                        Barrier barrier = (Barrier) childAt;
                        layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                        layout.mReferenceIds = barrier.getReferencedIds();
                        layout.mBarrierDirection = barrier.getType();
                        layout.mBarrierMargin = barrier.getMargin();
                    }
                }
                i3 = i + 1;
                constraintSet = this;
                childCount = i2;
                hashMap2 = hashMap;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public final void load(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    Constraint fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        fillFromAttributeList.layout.mIsGuideline = true;
                    }
                    this.mConstraints.put(Integer.valueOf(fillFromAttributeList.mViewId), fillFromAttributeList);
                }
            }
        } catch (IOException e) {
            Log.e("ConstraintSet", "Error parsing resource: " + i, e);
        } catch (XmlPullParserException e2) {
            Log.e("ConstraintSet", "Error parsing resource: " + i, e2);
        }
    }

    /* loaded from: classes.dex */
    public final class Constraint {
        public final Layout layout;
        public HashMap mCustomConstraints = new HashMap();
        public int mViewId;
        public final Motion motion;
        public final PropertySet propertySet;
        public final Transform transform;

        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.constraintlayout.widget.ConstraintSet$PropertySet, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, androidx.constraintlayout.widget.ConstraintSet$Motion] */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, androidx.constraintlayout.widget.ConstraintSet$Layout] */
        /* JADX WARN: Type inference failed for: r0v3, types: [androidx.constraintlayout.widget.ConstraintSet$Transform, java.lang.Object] */
        public Constraint() {
            ?? obj = new Object();
            obj.visibility = 0;
            obj.mVisibilityMode = 0;
            obj.alpha = 1.0f;
            obj.mProgress = Float.NaN;
            this.propertySet = obj;
            ?? obj2 = new Object();
            obj2.mAnimateRelativeTo = -1;
            obj2.mAnimateCircleAngleTo = 0;
            obj2.mPathMotionArc = -1;
            obj2.mMotionStagger = Float.NaN;
            obj2.mPathRotate = Float.NaN;
            obj2.mQuantizeMotionPhase = Float.NaN;
            obj2.mQuantizeMotionSteps = -1;
            obj2.mQuantizeInterpolatorString = null;
            obj2.mQuantizeInterpolatorID = -1;
            this.motion = obj2;
            ?? obj3 = new Object();
            obj3.mIsGuideline = false;
            obj3.guideBegin = -1;
            obj3.guideEnd = -1;
            obj3.guidePercent = -1.0f;
            obj3.guidelineUseRtl = true;
            obj3.leftToLeft = -1;
            obj3.leftToRight = -1;
            obj3.rightToLeft = -1;
            obj3.rightToRight = -1;
            obj3.topToTop = -1;
            obj3.topToBottom = -1;
            obj3.bottomToTop = -1;
            obj3.bottomToBottom = -1;
            obj3.baselineToBaseline = -1;
            obj3.baselineToTop = -1;
            obj3.baselineToBottom = -1;
            obj3.startToEnd = -1;
            obj3.startToStart = -1;
            obj3.endToStart = -1;
            obj3.endToEnd = -1;
            obj3.horizontalBias = 0.5f;
            obj3.verticalBias = 0.5f;
            obj3.dimensionRatio = null;
            obj3.circleConstraint = -1;
            obj3.circleRadius = 0;
            obj3.circleAngle = 0.0f;
            obj3.editorAbsoluteX = -1;
            obj3.editorAbsoluteY = -1;
            obj3.orientation = -1;
            obj3.leftMargin = 0;
            obj3.rightMargin = 0;
            obj3.topMargin = 0;
            obj3.bottomMargin = 0;
            obj3.endMargin = 0;
            obj3.startMargin = 0;
            obj3.baselineMargin = 0;
            obj3.goneLeftMargin = Integer.MIN_VALUE;
            obj3.goneTopMargin = Integer.MIN_VALUE;
            obj3.goneRightMargin = Integer.MIN_VALUE;
            obj3.goneBottomMargin = Integer.MIN_VALUE;
            obj3.goneEndMargin = Integer.MIN_VALUE;
            obj3.goneStartMargin = Integer.MIN_VALUE;
            obj3.goneBaselineMargin = Integer.MIN_VALUE;
            obj3.verticalWeight = -1.0f;
            obj3.horizontalWeight = -1.0f;
            obj3.horizontalChainStyle = 0;
            obj3.verticalChainStyle = 0;
            obj3.widthDefault = 0;
            obj3.heightDefault = 0;
            obj3.widthMax = 0;
            obj3.heightMax = 0;
            obj3.widthMin = 0;
            obj3.heightMin = 0;
            obj3.widthPercent = 1.0f;
            obj3.heightPercent = 1.0f;
            obj3.mBarrierDirection = -1;
            obj3.mBarrierMargin = 0;
            obj3.mHelperType = -1;
            obj3.constrainedWidth = false;
            obj3.constrainedHeight = false;
            obj3.mBarrierAllowsGoneWidgets = true;
            obj3.mWrapBehavior = 0;
            this.layout = obj3;
            ?? obj4 = new Object();
            obj4.rotation = 0.0f;
            obj4.rotationX = 0.0f;
            obj4.rotationY = 0.0f;
            obj4.scaleX = 1.0f;
            obj4.scaleY = 1.0f;
            obj4.transformPivotX = Float.NaN;
            obj4.transformPivotY = Float.NaN;
            obj4.transformPivotTarget = -1;
            obj4.translationX = 0.0f;
            obj4.translationY = 0.0f;
            obj4.translationZ = 0.0f;
            obj4.applyElevation = false;
            obj4.elevation = 0.0f;
            this.transform = obj4;
        }

        public final void applyTo(ConstraintLayout.LayoutParams layoutParams) {
            Layout layout = this.layout;
            layoutParams.leftToLeft = layout.leftToLeft;
            layoutParams.leftToRight = layout.leftToRight;
            layoutParams.rightToLeft = layout.rightToLeft;
            layoutParams.rightToRight = layout.rightToRight;
            layoutParams.topToTop = layout.topToTop;
            layoutParams.topToBottom = layout.topToBottom;
            layoutParams.bottomToTop = layout.bottomToTop;
            layoutParams.bottomToBottom = layout.bottomToBottom;
            layoutParams.baselineToBaseline = layout.baselineToBaseline;
            layoutParams.baselineToTop = layout.baselineToTop;
            layoutParams.baselineToBottom = layout.baselineToBottom;
            layoutParams.startToEnd = layout.startToEnd;
            layoutParams.startToStart = layout.startToStart;
            layoutParams.endToStart = layout.endToStart;
            layoutParams.endToEnd = layout.endToEnd;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = layout.leftMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = layout.rightMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = layout.topMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = layout.bottomMargin;
            layoutParams.goneStartMargin = layout.goneStartMargin;
            layoutParams.goneEndMargin = layout.goneEndMargin;
            layoutParams.goneTopMargin = layout.goneTopMargin;
            layoutParams.goneBottomMargin = layout.goneBottomMargin;
            layoutParams.horizontalBias = layout.horizontalBias;
            layoutParams.verticalBias = layout.verticalBias;
            layoutParams.circleConstraint = layout.circleConstraint;
            layoutParams.circleRadius = layout.circleRadius;
            layoutParams.circleAngle = layout.circleAngle;
            layoutParams.dimensionRatio = layout.dimensionRatio;
            layoutParams.editorAbsoluteX = layout.editorAbsoluteX;
            layoutParams.editorAbsoluteY = layout.editorAbsoluteY;
            layoutParams.verticalWeight = layout.verticalWeight;
            layoutParams.horizontalWeight = layout.horizontalWeight;
            layoutParams.verticalChainStyle = layout.verticalChainStyle;
            layoutParams.horizontalChainStyle = layout.horizontalChainStyle;
            layoutParams.constrainedWidth = layout.constrainedWidth;
            layoutParams.constrainedHeight = layout.constrainedHeight;
            layoutParams.matchConstraintDefaultWidth = layout.widthDefault;
            layoutParams.matchConstraintDefaultHeight = layout.heightDefault;
            layoutParams.matchConstraintMaxWidth = layout.widthMax;
            layoutParams.matchConstraintMaxHeight = layout.heightMax;
            layoutParams.matchConstraintMinWidth = layout.widthMin;
            layoutParams.matchConstraintMinHeight = layout.heightMin;
            layoutParams.matchConstraintPercentWidth = layout.widthPercent;
            layoutParams.matchConstraintPercentHeight = layout.heightPercent;
            layoutParams.orientation = layout.orientation;
            layoutParams.guidePercent = layout.guidePercent;
            layoutParams.guideBegin = layout.guideBegin;
            layoutParams.guideEnd = layout.guideEnd;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = layout.mWidth;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = layout.mHeight;
            String str = layout.mConstraintTag;
            if (str != null) {
                layoutParams.constraintTag = str;
            }
            layoutParams.wrapBehaviorInParent = layout.mWrapBehavior;
            layoutParams.setMarginStart(layout.startMargin);
            layoutParams.setMarginEnd(layout.endMargin);
            layoutParams.validate();
        }

        public final Object clone() {
            Constraint constraint = new Constraint();
            Layout layout = constraint.layout;
            layout.getClass();
            Layout layout2 = this.layout;
            layout.mIsGuideline = layout2.mIsGuideline;
            layout.mWidth = layout2.mWidth;
            layout.mHeight = layout2.mHeight;
            layout.guideBegin = layout2.guideBegin;
            layout.guideEnd = layout2.guideEnd;
            layout.guidePercent = layout2.guidePercent;
            layout.guidelineUseRtl = layout2.guidelineUseRtl;
            layout.leftToLeft = layout2.leftToLeft;
            layout.leftToRight = layout2.leftToRight;
            layout.rightToLeft = layout2.rightToLeft;
            layout.rightToRight = layout2.rightToRight;
            layout.topToTop = layout2.topToTop;
            layout.topToBottom = layout2.topToBottom;
            layout.bottomToTop = layout2.bottomToTop;
            layout.bottomToBottom = layout2.bottomToBottom;
            layout.baselineToBaseline = layout2.baselineToBaseline;
            layout.baselineToTop = layout2.baselineToTop;
            layout.baselineToBottom = layout2.baselineToBottom;
            layout.startToEnd = layout2.startToEnd;
            layout.startToStart = layout2.startToStart;
            layout.endToStart = layout2.endToStart;
            layout.endToEnd = layout2.endToEnd;
            layout.horizontalBias = layout2.horizontalBias;
            layout.verticalBias = layout2.verticalBias;
            layout.dimensionRatio = layout2.dimensionRatio;
            layout.circleConstraint = layout2.circleConstraint;
            layout.circleRadius = layout2.circleRadius;
            layout.circleAngle = layout2.circleAngle;
            layout.editorAbsoluteX = layout2.editorAbsoluteX;
            layout.editorAbsoluteY = layout2.editorAbsoluteY;
            layout.orientation = layout2.orientation;
            layout.leftMargin = layout2.leftMargin;
            layout.rightMargin = layout2.rightMargin;
            layout.topMargin = layout2.topMargin;
            layout.bottomMargin = layout2.bottomMargin;
            layout.endMargin = layout2.endMargin;
            layout.startMargin = layout2.startMargin;
            layout.baselineMargin = layout2.baselineMargin;
            layout.goneLeftMargin = layout2.goneLeftMargin;
            layout.goneTopMargin = layout2.goneTopMargin;
            layout.goneRightMargin = layout2.goneRightMargin;
            layout.goneBottomMargin = layout2.goneBottomMargin;
            layout.goneEndMargin = layout2.goneEndMargin;
            layout.goneStartMargin = layout2.goneStartMargin;
            layout.goneBaselineMargin = layout2.goneBaselineMargin;
            layout.verticalWeight = layout2.verticalWeight;
            layout.horizontalWeight = layout2.horizontalWeight;
            layout.horizontalChainStyle = layout2.horizontalChainStyle;
            layout.verticalChainStyle = layout2.verticalChainStyle;
            layout.widthDefault = layout2.widthDefault;
            layout.heightDefault = layout2.heightDefault;
            layout.widthMax = layout2.widthMax;
            layout.heightMax = layout2.heightMax;
            layout.widthMin = layout2.widthMin;
            layout.heightMin = layout2.heightMin;
            layout.widthPercent = layout2.widthPercent;
            layout.heightPercent = layout2.heightPercent;
            layout.mBarrierDirection = layout2.mBarrierDirection;
            layout.mBarrierMargin = layout2.mBarrierMargin;
            layout.mHelperType = layout2.mHelperType;
            layout.mConstraintTag = layout2.mConstraintTag;
            int[] iArr = layout2.mReferenceIds;
            if (iArr == null || layout2.mReferenceIdString != null) {
                layout.mReferenceIds = null;
            } else {
                layout.mReferenceIds = Arrays.copyOf(iArr, iArr.length);
            }
            layout.mReferenceIdString = layout2.mReferenceIdString;
            layout.constrainedWidth = layout2.constrainedWidth;
            layout.constrainedHeight = layout2.constrainedHeight;
            layout.mBarrierAllowsGoneWidgets = layout2.mBarrierAllowsGoneWidgets;
            layout.mWrapBehavior = layout2.mWrapBehavior;
            Motion motion = constraint.motion;
            motion.getClass();
            Motion motion2 = this.motion;
            motion2.getClass();
            motion.mAnimateRelativeTo = motion2.mAnimateRelativeTo;
            motion.mPathMotionArc = motion2.mPathMotionArc;
            motion.mPathRotate = motion2.mPathRotate;
            motion.mMotionStagger = motion2.mMotionStagger;
            PropertySet propertySet = this.propertySet;
            int i = propertySet.visibility;
            PropertySet propertySet2 = constraint.propertySet;
            propertySet2.visibility = i;
            propertySet2.alpha = propertySet.alpha;
            propertySet2.mProgress = propertySet.mProgress;
            propertySet2.mVisibilityMode = propertySet.mVisibilityMode;
            Transform transform = constraint.transform;
            transform.getClass();
            Transform transform2 = this.transform;
            transform2.getClass();
            transform.rotation = transform2.rotation;
            transform.rotationX = transform2.rotationX;
            transform.rotationY = transform2.rotationY;
            transform.scaleX = transform2.scaleX;
            transform.scaleY = transform2.scaleY;
            transform.transformPivotX = transform2.transformPivotX;
            transform.transformPivotY = transform2.transformPivotY;
            transform.transformPivotTarget = transform2.transformPivotTarget;
            transform.translationX = transform2.translationX;
            transform.translationY = transform2.translationY;
            transform.translationZ = transform2.translationZ;
            transform.applyElevation = transform2.applyElevation;
            transform.elevation = transform2.elevation;
            constraint.mViewId = this.mViewId;
            return constraint;
        }

        /* loaded from: classes.dex */
        public final class Delta {
            public int mCountBoolean;
            public int mCountFloat;
            public int mCountInt;
            public int mCountString;
            public int[] mTypeBoolean;
            public int[] mTypeFloat;
            public int[] mTypeInt;
            public int[] mTypeString;
            public boolean[] mValueBoolean;
            public float[] mValueFloat;
            public int[] mValueInt;
            public String[] mValueString;

            public final void add(int i, int i2) {
                int i3 = this.mCountInt;
                int[] iArr = this.mTypeInt;
                if (i3 >= iArr.length) {
                    this.mTypeInt = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.mValueInt;
                    this.mValueInt = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.mTypeInt;
                int i4 = this.mCountInt;
                iArr3[i4] = i;
                int[] iArr4 = this.mValueInt;
                this.mCountInt = i4 + 1;
                iArr4[i4] = i2;
            }

            public final void add(int i, float f) {
                int i2 = this.mCountFloat;
                int[] iArr = this.mTypeFloat;
                if (i2 >= iArr.length) {
                    this.mTypeFloat = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.mValueFloat;
                    this.mValueFloat = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.mTypeFloat;
                int i3 = this.mCountFloat;
                iArr2[i3] = i;
                float[] fArr2 = this.mValueFloat;
                this.mCountFloat = i3 + 1;
                fArr2[i3] = f;
            }

            public final void add(int i, String str) {
                int i2 = this.mCountString;
                int[] iArr = this.mTypeString;
                if (i2 >= iArr.length) {
                    this.mTypeString = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.mValueString;
                    this.mValueString = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.mTypeString;
                int i3 = this.mCountString;
                iArr2[i3] = i;
                String[] strArr2 = this.mValueString;
                this.mCountString = i3 + 1;
                strArr2[i3] = str;
            }

            public final void add(int i, boolean z) {
                int i2 = this.mCountBoolean;
                int[] iArr = this.mTypeBoolean;
                if (i2 >= iArr.length) {
                    this.mTypeBoolean = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.mValueBoolean;
                    this.mValueBoolean = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.mTypeBoolean;
                int i3 = this.mCountBoolean;
                iArr2[i3] = i;
                boolean[] zArr2 = this.mValueBoolean;
                this.mCountBoolean = i3 + 1;
                zArr2[i3] = z;
            }
        }
    }
}
