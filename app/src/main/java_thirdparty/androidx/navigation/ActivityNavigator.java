package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.navigation.Navigator;
import androidx.navigation.internal.NavDestinationImpl;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt__StringsKt;
@Navigator.Name("activity")
/* loaded from: classes.dex */
public class ActivityNavigator extends Navigator {
    public final Context context;
    public final Activity hostActivity;

    /* loaded from: classes.dex */
    public final class Destination extends NavDestination {
        public String dataPattern;
        public Intent intent;

        public static String parseApplicationId(Context context, String str) {
            if (str == null) {
                return null;
            }
            String packageName = context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            return StringsKt__StringsKt.replace$default(str, "${applicationId}", packageName);
        }

        @Override // androidx.navigation.NavDestination
        public final boolean equals(Object obj) {
            boolean z;
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof Destination) && super.equals(obj)) {
                Intent intent = this.intent;
                if (intent != null) {
                    z = intent.filterEquals(((Destination) obj).intent);
                } else if (((Destination) obj).intent == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && Intrinsics.areEqual(this.dataPattern, ((Destination) obj).dataPattern)) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.navigation.NavDestination
        public final int hashCode() {
            int i;
            int hashCode = super.hashCode() * 31;
            Intent intent = this.intent;
            int i2 = 0;
            if (intent != null) {
                i = intent.filterHashCode();
            } else {
                i = 0;
            }
            int i3 = (hashCode + i) * 31;
            String str = this.dataPattern;
            if (str != null) {
                i2 = str.hashCode();
            }
            return i3 + i2;
        }

        @Override // androidx.navigation.NavDestination
        public final void onInflate(Context context, AttributeSet attributeSet) {
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.ActivityNavigator);
            Intrinsics.checkNotNullExpressionValue(obtainAttributes, "obtainAttributes(...)");
            String parseApplicationId = parseApplicationId(context, obtainAttributes.getString(4));
            if (this.intent == null) {
                this.intent = new Intent();
            }
            Intent intent = this.intent;
            Intrinsics.checkNotNull(intent);
            intent.setPackage(parseApplicationId);
            String string = obtainAttributes.getString(0);
            if (string != null) {
                if (string.charAt(0) == '.') {
                    string = context.getPackageName() + string;
                }
                ComponentName componentName = new ComponentName(context, string);
                if (this.intent == null) {
                    this.intent = new Intent();
                }
                Intent intent2 = this.intent;
                Intrinsics.checkNotNull(intent2);
                intent2.setComponent(componentName);
            }
            String string2 = obtainAttributes.getString(1);
            if (this.intent == null) {
                this.intent = new Intent();
            }
            Intent intent3 = this.intent;
            Intrinsics.checkNotNull(intent3);
            intent3.setAction(string2);
            String parseApplicationId2 = parseApplicationId(context, obtainAttributes.getString(2));
            if (parseApplicationId2 != null) {
                Uri parse = Uri.parse(parseApplicationId2);
                if (this.intent == null) {
                    this.intent = new Intent();
                }
                Intent intent4 = this.intent;
                Intrinsics.checkNotNull(intent4);
                intent4.setData(parse);
            }
            this.dataPattern = parseApplicationId(context, obtainAttributes.getString(3));
            obtainAttributes.recycle();
        }

        @Override // androidx.navigation.NavDestination
        public final String toString() {
            ComponentName componentName;
            Intent intent = this.intent;
            String str = null;
            if (intent != null) {
                componentName = intent.getComponent();
            } else {
                componentName = null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (componentName != null) {
                sb.append(" class=");
                sb.append(componentName.getClassName());
            } else {
                Intent intent2 = this.intent;
                if (intent2 != null) {
                    str = intent2.getAction();
                }
                if (str != null) {
                    sb.append(" action=");
                    sb.append(str);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
    }

    public ActivityNavigator(Context context) {
        Object obj;
        this.context = context;
        Iterator it = SequencesKt.generateSequence(context, new Navigation$$ExternalSyntheticLambda0(1)).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Context) obj) instanceof Activity) {
                break;
            }
        }
        this.hostActivity = (Activity) obj;
    }

    @Override // androidx.navigation.Navigator
    public final NavDestination createDestination() {
        return new NavDestination(this);
    }

    @Override // androidx.navigation.Navigator
    public final NavDestination navigate(NavDestination navDestination, Bundle bundle, NavOptions navOptions) {
        Intent intent;
        int intExtra;
        NavType navType;
        String str;
        Destination destination = (Destination) navDestination;
        NavDestinationImpl navDestinationImpl = destination.impl;
        if (destination.intent != null) {
            Intent intent2 = new Intent(destination.intent);
            if (bundle != null) {
                intent2.putExtras(bundle);
                String str2 = destination.dataPattern;
                if (!(str2 == null || str2.length() == 0)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(str2);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        Intrinsics.checkNotNull(group);
                        if (bundle.containsKey(group)) {
                            matcher.appendReplacement(stringBuffer, "");
                            NavArgument navArgument = (NavArgument) destination.getArguments().get(group);
                            if (navArgument != null) {
                                navType = navArgument.type;
                            } else {
                                navType = null;
                            }
                            if (navType != null) {
                                str = navType.serializeAsValue(navType.get(bundle, group));
                            } else {
                                str = Uri.encode(String.valueOf(bundle.get(group)));
                            }
                            stringBuffer.append(str);
                        } else {
                            throw new IllegalArgumentException(("Could not find " + group + " in " + bundle + " to fill data pattern " + str2).toString());
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    intent2.setData(Uri.parse(stringBuffer.toString()));
                }
            }
            Activity activity = this.hostActivity;
            if (activity == null) {
                intent2.addFlags(268435456);
            }
            if (navOptions != null && navOptions.singleTop) {
                intent2.addFlags(536870912);
            }
            int i = 0;
            if (!(activity == null || (intent = activity.getIntent()) == null || (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) == 0)) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
            }
            intent2.putExtra("android-support-navigation:ActivityNavigator:current", navDestinationImpl.id);
            Context context = this.context;
            Resources resources = context.getResources();
            if (navOptions != null) {
                int i2 = navOptions.popEnterAnim;
                int i3 = navOptions.popExitAnim;
                if ((i2 <= 0 || !Intrinsics.areEqual(resources.getResourceTypeName(i2), "animator")) && (i3 <= 0 || !Intrinsics.areEqual(resources.getResourceTypeName(i3), "animator"))) {
                    intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", i2);
                    Intrinsics.checkNotNull(intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", i3));
                } else {
                    Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring popEnter resource " + resources.getResourceName(i2) + " and popExit resource " + resources.getResourceName(i3) + " when launching " + destination);
                }
            }
            context.startActivity(intent2);
            if (!(navOptions == null || activity == null)) {
                int i4 = navOptions.enterAnim;
                int i5 = navOptions.exitAnim;
                if ((i4 > 0 && Intrinsics.areEqual(resources.getResourceTypeName(i4), "animator")) || (i5 > 0 && Intrinsics.areEqual(resources.getResourceTypeName(i5), "animator"))) {
                    Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring enter resource " + resources.getResourceName(i4) + " and exit resource " + resources.getResourceName(i5) + "when launching " + destination);
                    return null;
                } else if (i4 >= 0 || i5 >= 0) {
                    if (i4 < 0) {
                        i4 = 0;
                    }
                    if (i5 >= 0) {
                        i = i5;
                    }
                    activity.overridePendingTransition(i4, i);
                }
            }
            return null;
        }
        throw new IllegalStateException(("Destination " + navDestinationImpl.id + " does not have an Intent set.").toString());
    }

    @Override // androidx.navigation.Navigator
    public final boolean popBackStack() {
        Activity activity = this.hostActivity;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }
}
