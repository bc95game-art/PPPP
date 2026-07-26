package androidx.lifecycle;

import android.app.Application;
import android.content.ContentProviderClient;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
import androidx.core.provider.FontProvider$ContentQueryWrapperApi24Impl$$ExternalSyntheticAutoCloseableForwarder0;
import androidx.emoji2.text.MetadataRepo;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Transition;
import androidx.transition.ViewUtilsApi21;
import com.google.android.gms.internal.play_billing.zzem;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class ViewModelProvider {
    public static final ViewUtilsApi21 VIEW_MODEL_KEY = new Object();
    public final Object impl;

    /* loaded from: classes.dex */
    public interface Factory {

        /* renamed from: androidx.lifecycle.ViewModelProvider$Factory$-CC  reason: invalid class name */
        /* loaded from: classes.dex */
        public abstract /* synthetic */ class CC {
            public static final void _applyState(int i, View view, ViewGroup container) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(container, "container");
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Calling apply state");
                }
                int ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(i);
                ViewGroup viewGroup = null;
                if (ordinal == 0) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof ViewGroup) {
                        viewGroup = (ViewGroup) parent;
                    }
                    if (viewGroup != null) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                        }
                        viewGroup.removeView(view);
                    }
                } else if (ordinal == 1) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    ViewParent parent2 = view.getParent();
                    if (parent2 instanceof ViewGroup) {
                        viewGroup = (ViewGroup) parent2;
                    }
                    if (viewGroup == null) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Adding view " + view + " to Container " + container);
                        }
                        container.addView(view);
                    }
                    view.setVisibility(0);
                } else if (ordinal == 2) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                } else if (ordinal == 3) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                    }
                    view.setVisibility(4);
                }
            }

            public static int _zzb(int i) {
                if (i == 90) {
                    return 81;
                }
                if (i == 91) {
                    return 82;
                }
                if (i == 93) {
                    return 84;
                }
                if (i == 94) {
                    return 85;
                }
                switch (i) {
                    case 0:
                        return 1;
                    case 1:
                        return 2;
                    case 2:
                        return 3;
                    case 3:
                        return 4;
                    case 4:
                        return 5;
                    case 5:
                        return 6;
                    case 6:
                        return 7;
                    case 7:
                        return 8;
                    case 8:
                        return 9;
                    case 9:
                        return 10;
                    case 10:
                        return 11;
                    case 11:
                        return 12;
                    case 12:
                        return 13;
                    case 13:
                        return 14;
                    case 14:
                        return 15;
                    case 15:
                        return 16;
                    case 16:
                        return 17;
                    case 17:
                        return 18;
                    case 18:
                        return 19;
                    case 19:
                        return 20;
                    case 20:
                        return 21;
                    case 21:
                        return 22;
                    case 22:
                        return 23;
                    case 23:
                        return 24;
                    case 24:
                        return 25;
                    case 25:
                        return 26;
                    case 26:
                        return 27;
                    case 27:
                        return 28;
                    case 28:
                        return 29;
                    case 29:
                        return 30;
                    case 30:
                        return 31;
                    case 31:
                        return 32;
                    case 32:
                        return 33;
                    case 33:
                        return 34;
                    case 34:
                        return 35;
                    case 35:
                        return 36;
                    case 36:
                        return 37;
                    case 37:
                        return 38;
                    case 38:
                        return 39;
                    case 39:
                        return 40;
                    case 40:
                        return 41;
                    case 41:
                        return 42;
                    case 42:
                        return 43;
                    case 43:
                        return 44;
                    case 44:
                        return 45;
                    case 45:
                        return 46;
                    case 46:
                        return 47;
                    case 47:
                        return 48;
                    case 48:
                        return 49;
                    case 49:
                        return 50;
                    case 50:
                        return 51;
                    case 51:
                        return 52;
                    case 52:
                        return 53;
                    case 53:
                        return 54;
                    case 54:
                        return 55;
                    case 55:
                        return 56;
                    case 56:
                        return 57;
                    case 57:
                        return 58;
                    case 58:
                        return 59;
                    case 59:
                        return 60;
                    case 60:
                        return 61;
                    case 61:
                        return 62;
                    case 62:
                        return 63;
                    case 63:
                        return 64;
                    case 64:
                        return 65;
                    case 65:
                        return 66;
                    case 66:
                        return 67;
                    case 67:
                        return 68;
                    case 68:
                        return 69;
                    case 69:
                        return 70;
                    case 70:
                        return 71;
                    case 71:
                        return 72;
                    case 72:
                        return 73;
                    case 73:
                        return 74;
                    case 74:
                        return 75;
                    case 75:
                        return 76;
                    case 76:
                        return 77;
                    case 77:
                        return 78;
                    case 78:
                        return 79;
                    case 79:
                        return 80;
                    default:
                        switch (i) {
                            case 96:
                                return 87;
                            case 97:
                                return 88;
                            case 98:
                                return 89;
                            case 99:
                                return 90;
                            case 100:
                                return 91;
                            case 101:
                                return 92;
                            case 102:
                                return 83;
                            case 103:
                                return 86;
                            case 104:
                                return 93;
                            case 105:
                                return 94;
                            case 106:
                                return 95;
                            case 107:
                                return 96;
                            case 108:
                                return 97;
                            case 109:
                                return 98;
                            case 110:
                                return 99;
                            case 111:
                                return 100;
                            case 112:
                                return 101;
                            case 113:
                                return 102;
                            case 114:
                                return 103;
                            case 115:
                                return 104;
                            case 116:
                                return 105;
                            case 117:
                                return 106;
                            case 118:
                                return 107;
                            case 119:
                                return 108;
                            case 120:
                                return 109;
                            case 121:
                                return 110;
                            case 122:
                                return 111;
                            case 123:
                                return 112;
                            case 124:
                                return 113;
                            case 125:
                                return 114;
                            case 126:
                                return 117;
                            case 127:
                                return 119;
                            case 128:
                                return 120;
                            case 129:
                                return 121;
                            case 130:
                                return 122;
                            case 131:
                                return 123;
                            case 132:
                                return 124;
                            case 133:
                                return 125;
                            case 134:
                                return 126;
                            case 135:
                                return 127;
                            case 136:
                                return 128;
                            case 137:
                                return 129;
                            case 138:
                                return 130;
                            case 139:
                                return 131;
                            case 140:
                                return 132;
                            case 141:
                                return 133;
                            case 142:
                                return 134;
                            case 143:
                                return 135;
                            case 144:
                                return 136;
                            case 145:
                                return 115;
                            case 146:
                                return 116;
                            case 147:
                                return 118;
                            case 148:
                                return 137;
                            case 149:
                                return 138;
                            default:
                                return 0;
                        }
                }
            }

            public static /* synthetic */ int getZzbJ(int i) {
                switch (i) {
                    case 1:
                        return 0;
                    case 2:
                        return 1;
                    case 3:
                        return 2;
                    case 4:
                        return 3;
                    case 5:
                        return 4;
                    case 6:
                        return 5;
                    case 7:
                        return 6;
                    case 8:
                        return 7;
                    case 9:
                        return 8;
                    case 10:
                        return 9;
                    case 11:
                        return 10;
                    case 12:
                        return 11;
                    case 13:
                        return 12;
                    case 14:
                        return 13;
                    case 15:
                        return 14;
                    case 16:
                        return 15;
                    case 17:
                        return 16;
                    case 18:
                        return 17;
                    case 19:
                        return 18;
                    case 20:
                        return 19;
                    case 21:
                        return 20;
                    case 22:
                        return 21;
                    case 23:
                        return 22;
                    case 24:
                        return 23;
                    case 25:
                        return 24;
                    case 26:
                        return 25;
                    case 27:
                        return 26;
                    case 28:
                        return 27;
                    case 29:
                        return 28;
                    case 30:
                        return 29;
                    case 31:
                        return 30;
                    case 32:
                        return 31;
                    case 33:
                        return 32;
                    case 34:
                        return 33;
                    case 35:
                        return 34;
                    case 36:
                        return 35;
                    case 37:
                        return 36;
                    case 38:
                        return 37;
                    case 39:
                        return 38;
                    case 40:
                        return 39;
                    case 41:
                        return 40;
                    case 42:
                        return 41;
                    case 43:
                        return 42;
                    case 44:
                        return 43;
                    case 45:
                        return 44;
                    case 46:
                        return 45;
                    case 47:
                        return 46;
                    case 48:
                        return 47;
                    case 49:
                        return 48;
                    case 50:
                        return 49;
                    case 51:
                        return 50;
                    case 52:
                        return 51;
                    case 53:
                        return 52;
                    case 54:
                        return 53;
                    case 55:
                        return 54;
                    case 56:
                        return 55;
                    case 57:
                        return 56;
                    case 58:
                        return 57;
                    case 59:
                        return 58;
                    case 60:
                        return 59;
                    case 61:
                        return 60;
                    case 62:
                        return 61;
                    case 63:
                        return 62;
                    case 64:
                        return 63;
                    case 65:
                        return 64;
                    case 66:
                        return 65;
                    case 67:
                        return 66;
                    case 68:
                        return 67;
                    case 69:
                        return 68;
                    case 70:
                        return 69;
                    case 71:
                        return 70;
                    case 72:
                        return 71;
                    case 73:
                        return 72;
                    case 74:
                        return 73;
                    case 75:
                        return 74;
                    case 76:
                        return 75;
                    case 77:
                        return 76;
                    case 78:
                        return 77;
                    case 79:
                        return 78;
                    case 80:
                        return 79;
                    case 81:
                        return 90;
                    case 82:
                        return 91;
                    case 83:
                        return 102;
                    case 84:
                        return 93;
                    case 85:
                        return 94;
                    case 86:
                        return 103;
                    case 87:
                        return 96;
                    case 88:
                        return 97;
                    case 89:
                        return 98;
                    case 90:
                        return 99;
                    case 91:
                        return 100;
                    case 92:
                        return 101;
                    case 93:
                        return 104;
                    case 94:
                        return 105;
                    case 95:
                        return 106;
                    case 96:
                        return 107;
                    case 97:
                        return 108;
                    case 98:
                        return 109;
                    case 99:
                        return 110;
                    case 100:
                        return 111;
                    case 101:
                        return 112;
                    case 102:
                        return 113;
                    case 103:
                        return 114;
                    case 104:
                        return 115;
                    case 105:
                        return 116;
                    case 106:
                        return 117;
                    case 107:
                        return 118;
                    case 108:
                        return 119;
                    case 109:
                        return 120;
                    case 110:
                        return 121;
                    case 111:
                        return 122;
                    case 112:
                        return 123;
                    case 113:
                        return 124;
                    case 114:
                        return 125;
                    case 115:
                        return 145;
                    case 116:
                        return 146;
                    case 117:
                        return 126;
                    case 118:
                        return 147;
                    case 119:
                        return 127;
                    case 120:
                        return 128;
                    case 121:
                        return 129;
                    case 122:
                        return 130;
                    case 123:
                        return 131;
                    case 124:
                        return 132;
                    case 125:
                        return 133;
                    case 126:
                        return 134;
                    case 127:
                        return 135;
                    case 128:
                        return 136;
                    case 129:
                        return 137;
                    case 130:
                        return 138;
                    case 131:
                        return 139;
                    case 132:
                        return 140;
                    case 133:
                        return 141;
                    case 134:
                        return 142;
                    case 135:
                        return 143;
                    case 136:
                        return 144;
                    case 137:
                        return 148;
                    case 138:
                        return 149;
                    default:
                        throw null;
                }
            }

            public static int m(int i, int i2, int i3) {
                return zzem.zzC(i) + i2 + i3;
            }

            public static /* synthetic */ String name(int i) {
                switch (i) {
                    case 1:
                        return "NONE";
                    case 2:
                        return "LEFT";
                    case 3:
                        return "TOP";
                    case 4:
                        return "RIGHT";
                    case 5:
                        return "BOTTOM";
                    case 6:
                        return "BASELINE";
                    case 7:
                        return "CENTER";
                    case 8:
                        return "CENTER_X";
                    case 9:
                        return "CENTER_Y";
                    default:
                        throw null;
                }
            }

            public static /* synthetic */ String stringValueOf$1(int i) {
                return i != 1 ? i != 2 ? i != 3 ? "null" : "REMOVING" : "ADDING" : "NONE";
            }

            public static /* synthetic */ String stringValueOf$2(int i) {
                return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "INVISIBLE" : "GONE" : "VISIBLE" : "REMOVED";
            }

            public static /* synthetic */ String stringValueOf$4(int i) {
                switch (i) {
                    case 1:
                        return "BEGIN_ARRAY";
                    case 2:
                        return "END_ARRAY";
                    case 3:
                        return "BEGIN_OBJECT";
                    case 4:
                        return "END_OBJECT";
                    case 5:
                        return "NAME";
                    case 6:
                        return "STRING";
                    case 7:
                        return "NUMBER";
                    case 8:
                        return "BOOLEAN";
                    case 9:
                        return "NULL";
                    case 10:
                        return "END_DOCUMENT";
                    default:
                        return "null";
                }
            }

            public static int m(int i, int i2, int i3, int i4) {
                return zzem.zzC(i) + i2 + i3 + i4;
            }

            public static ClassCastException m(Iterator it) {
                it.next().getClass();
                return new ClassCastException();
            }

            public static String m(int i, int i2, String str, String str2) {
                return str + i + str2 + i2;
            }

            public static String m(int i, String str) {
                return str + i;
            }

            public static String m(RecyclerView recyclerView, StringBuilder sb) {
                sb.append(recyclerView.exceptionLabel());
                return sb.toString();
            }

            public static String m(String str, Fragment fragment, String str2) {
                return str + fragment + str2;
            }

            public static String m(String str, String str2) {
                return str + str2;
            }

            public static String m(String str, String str2, String str3) {
                return str + str2 + str3;
            }

            public static String m(StringBuilder sb, String str, String str2) {
                sb.append(str);
                sb.append(str2);
                return sb.toString();
            }

            public static StringBuilder m(String str, int i, String str2) {
                StringBuilder sb = new StringBuilder(str);
                sb.append(i);
                sb.append(str2);
                return sb;
            }

            /* renamed from: m  reason: collision with other method in class */
            public static StringBuilder m15m(String str, String str2, String str3) {
                StringBuilder sb = new StringBuilder(str);
                sb.append(str2);
                sb.append(str3);
                return sb;
            }

            public static /* synthetic */ void m(AutoCloseable autoCloseable) {
                if (autoCloseable instanceof AutoCloseable) {
                    autoCloseable.close();
                } else if (autoCloseable instanceof ExecutorService) {
                    FontProvider$ContentQueryWrapperApi24Impl$$ExternalSyntheticAutoCloseableForwarder0.m((ExecutorService) autoCloseable);
                } else if (autoCloseable instanceof TypedArray) {
                    ((TypedArray) autoCloseable).recycle();
                } else if (autoCloseable instanceof MediaMetadataRetriever) {
                    ((MediaMetadataRetriever) autoCloseable).release();
                } else if (autoCloseable instanceof MediaDrm) {
                    ((MediaDrm) autoCloseable).release();
                } else if (autoCloseable instanceof DrmManagerClient) {
                    ((DrmManagerClient) autoCloseable).release();
                } else if (autoCloseable instanceof ContentProviderClient) {
                    ((ContentProviderClient) autoCloseable).release();
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }

        ViewModel create(Class cls);

        ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras);

        ViewModel create(ClassReference classReference, MutableCreationExtras mutableCreationExtras);
    }

    public ViewModelProvider(ViewModelStore store, Factory factory, CreationExtras defaultCreationExtras) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(defaultCreationExtras, "defaultCreationExtras");
        this.impl = new MetadataRepo(store, factory, defaultCreationExtras);
    }

    public ViewModelProvider(ProcessLifecycleOwner processLifecycleOwner) {
        this.impl = processLifecycleOwner;
    }

    /* loaded from: classes.dex */
    public final class AndroidViewModelFactory extends Transition.AnonymousClass1 {
        public static final ViewUtilsApi21 APPLICATION_KEY = new Object();
        public static AndroidViewModelFactory _instance;
        public final Application application;

        public AndroidViewModelFactory(Application application) {
            super(10);
            this.application = application;
        }

        @Override // androidx.transition.Transition.AnonymousClass1, androidx.lifecycle.ViewModelProvider.Factory
        public final ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
            if (this.application != null) {
                return create(cls);
            }
            Application application = (Application) mutableCreationExtras.extras.get(APPLICATION_KEY);
            if (application != null) {
                return create(cls, application);
            }
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return Navigation.createViewModel(cls);
            }
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }

        @Override // androidx.transition.Transition.AnonymousClass1, androidx.lifecycle.ViewModelProvider.Factory
        public final ViewModel create(Class cls) {
            Application application = this.application;
            if (application != null) {
                return create(cls, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        public final ViewModel create(Class cls, Application application) {
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return Navigation.createViewModel(cls);
            }
            try {
                ViewModel viewModel = (ViewModel) cls.getConstructor(Application.class).newInstance(application);
                Intrinsics.checkNotNull(viewModel);
                return viewModel;
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }
    }
}
