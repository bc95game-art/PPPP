package com.github.appintro;

import com.github.appintro.model.SliderPage;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class AppIntroFragment extends AppIntroBaseFragment {
    public static final Companion Companion = new Companion(null);

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ AppIntroFragment createInstance$default(Companion companion, CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                charSequence = null;
            }
            if ((i8 & 2) != 0) {
                charSequence2 = null;
            }
            if ((i8 & 4) != 0) {
                i = 0;
            }
            if ((i8 & 8) != 0) {
                i2 = 0;
            }
            if ((i8 & 16) != 0) {
                i3 = 0;
            }
            if ((i8 & 32) != 0) {
                i4 = 0;
            }
            if ((i8 & 64) != 0) {
                i5 = 0;
            }
            if ((i8 & 128) != 0) {
                i6 = 0;
            }
            if ((i8 & 256) != 0) {
                i7 = 0;
            }
            return companion.createInstance(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7);
        }

        public static /* synthetic */ AppIntroFragment newInstance$default(Companion companion, CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                charSequence = null;
            }
            if ((i8 & 2) != 0) {
                charSequence2 = null;
            }
            if ((i8 & 4) != 0) {
                i = 0;
            }
            if ((i8 & 8) != 0) {
                i2 = 0;
            }
            if ((i8 & 16) != 0) {
                i3 = 0;
            }
            if ((i8 & 32) != 0) {
                i4 = 0;
            }
            if ((i8 & 64) != 0) {
                i5 = 0;
            }
            if ((i8 & 128) != 0) {
                i6 = 0;
            }
            if ((i8 & 256) != 0) {
                i7 = 0;
            }
            return companion.newInstance(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7);
        }

        public final AppIntroFragment createInstance() {
            return createInstance$default(this, null, null, 0, 0, 0, 0, 0, 0, 0, 511, null);
        }

        public final AppIntroFragment newInstance() {
            return newInstance$default(this, null, null, 0, 0, 0, 0, 0, 0, 0, 511, null);
        }

        private Companion() {
        }

        public final AppIntroFragment createInstance(CharSequence charSequence) {
            return createInstance$default(this, charSequence, null, 0, 0, 0, 0, 0, 0, 0, 510, null);
        }

        public final AppIntroFragment newInstance(CharSequence charSequence) {
            return newInstance$default(this, charSequence, null, 0, 0, 0, 0, 0, 0, 0, 510, null);
        }

        public final AppIntroFragment createInstance(CharSequence charSequence, CharSequence charSequence2) {
            return createInstance$default(this, charSequence, charSequence2, 0, 0, 0, 0, 0, 0, 0, 508, null);
        }

        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2) {
            return newInstance$default(this, charSequence, charSequence2, 0, 0, 0, 0, 0, 0, 0, 508, null);
        }

        public final AppIntroFragment createInstance(CharSequence charSequence, CharSequence charSequence2, int i) {
            return createInstance$default(this, charSequence, charSequence2, i, 0, 0, 0, 0, 0, 0, 504, null);
        }

        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i) {
            return newInstance$default(this, charSequence, charSequence2, i, 0, 0, 0, 0, 0, 0, 504, null);
        }

        public final AppIntroFragment createInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2) {
            return createInstance$default(this, charSequence, charSequence2, i, i2, 0, 0, 0, 0, 0, 496, null);
        }

        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2) {
            return newInstance$default(this, charSequence, charSequence2, i, i2, 0, 0, 0, 0, 0, 496, null);
        }

        public final AppIntroFragment createInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3) {
            return createInstance$default(this, charSequence, charSequence2, i, i2, i3, 0, 0, 0, 0, 480, null);
        }

        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3) {
            return newInstance$default(this, charSequence, charSequence2, i, i2, i3, 0, 0, 0, 0, 480, null);
        }

        public final AppIntroFragment createInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4) {
            return createInstance$default(this, charSequence, charSequence2, i, i2, i3, i4, 0, 0, 0, 448, null);
        }

        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4) {
            return newInstance$default(this, charSequence, charSequence2, i, i2, i3, i4, 0, 0, 0, 448, null);
        }

        public final AppIntroFragment createInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5) {
            return createInstance$default(this, charSequence, charSequence2, i, i2, i3, i4, i5, 0, 0, 384, null);
        }

        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5) {
            return newInstance$default(this, charSequence, charSequence2, i, i2, i3, i4, i5, 0, 0, 384, null);
        }

        public final AppIntroFragment createInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6) {
            return createInstance$default(this, charSequence, charSequence2, i, i2, i3, i4, i5, i6, 0, 256, null);
        }

        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6) {
            return newInstance$default(this, charSequence, charSequence2, i, i2, i3, i4, i5, i6, 0, 256, null);
        }

        public final AppIntroFragment createInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            return createInstance(new SliderPage(charSequence, charSequence2, i, 0, 0, 0, i2, i3, i4, i5, i6, null, null, i7, 6200, null));
        }

        public final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            return createInstance(new SliderPage(charSequence, charSequence2, i, i2, i3, i4, 0, 0, 0, i5, i6, null, null, i7, 6592, null));
        }

        public final AppIntroFragment createInstance(SliderPage sliderPage) {
            Intrinsics.checkNotNullParameter(sliderPage, "sliderPage");
            AppIntroFragment appIntroFragment = new AppIntroFragment();
            appIntroFragment.setArguments(sliderPage.toBundle());
            return appIntroFragment;
        }

        public final AppIntroFragment newInstance(SliderPage sliderPage) {
            Intrinsics.checkNotNullParameter(sliderPage, "sliderPage");
            return createInstance(sliderPage);
        }
    }

    public static final AppIntroFragment createInstance() {
        return Companion.createInstance();
    }

    public static final AppIntroFragment newInstance() {
        return Companion.newInstance();
    }

    @Override // com.github.appintro.AppIntroBaseFragment
    public int getLayoutId() {
        return C0161R.layout.appintro_fragment_intro;
    }

    public static final AppIntroFragment createInstance(SliderPage sliderPage) {
        return Companion.createInstance(sliderPage);
    }

    public static final AppIntroFragment newInstance(SliderPage sliderPage) {
        return Companion.newInstance(sliderPage);
    }

    public static final AppIntroFragment createInstance(CharSequence charSequence) {
        return Companion.createInstance(charSequence);
    }

    public static final AppIntroFragment newInstance(CharSequence charSequence) {
        return Companion.newInstance(charSequence);
    }

    public static final AppIntroFragment createInstance(CharSequence charSequence, CharSequence charSequence2) {
        return Companion.createInstance(charSequence, charSequence2);
    }

    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2) {
        return Companion.newInstance(charSequence, charSequence2);
    }

    public static final AppIntroFragment createInstance(CharSequence charSequence, CharSequence charSequence2, int i) {
        return Companion.createInstance(charSequence, charSequence2, i);
    }

    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i) {
        return Companion.newInstance(charSequence, charSequence2, i);
    }

    public static final AppIntroFragment createInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2) {
        return Companion.createInstance(charSequence, charSequence2, i, i2);
    }

    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2) {
        return Companion.newInstance(charSequence, charSequence2, i, i2);
    }

    public static final AppIntroFragment createInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3) {
        return Companion.createInstance(charSequence, charSequence2, i, i2, i3);
    }

    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3) {
        return Companion.newInstance(charSequence, charSequence2, i, i2, i3);
    }

    public static final AppIntroFragment createInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4) {
        return Companion.createInstance(charSequence, charSequence2, i, i2, i3, i4);
    }

    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4) {
        return Companion.newInstance(charSequence, charSequence2, i, i2, i3, i4);
    }

    public static final AppIntroFragment createInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5) {
        return Companion.createInstance(charSequence, charSequence2, i, i2, i3, i4, i5);
    }

    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5) {
        return Companion.newInstance(charSequence, charSequence2, i, i2, i3, i4, i5);
    }

    public static final AppIntroFragment createInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6) {
        return Companion.createInstance(charSequence, charSequence2, i, i2, i3, i4, i5, i6);
    }

    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6) {
        return Companion.newInstance(charSequence, charSequence2, i, i2, i3, i4, i5, i6);
    }

    public static final AppIntroFragment createInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return Companion.createInstance(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7);
    }

    public static final AppIntroFragment newInstance(CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return Companion.newInstance(charSequence, charSequence2, i, i2, i3, i4, i5, i6, i7);
    }
}
