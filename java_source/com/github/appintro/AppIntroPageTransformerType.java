package com.github.appintro;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes.dex */
public abstract class AppIntroPageTransformerType {

    /* loaded from: classes.dex */
    public static final class Depth extends AppIntroPageTransformerType {
        public static final Depth INSTANCE = new Depth();

        private Depth() {
            super(null);
        }
    }

    /* loaded from: classes.dex */
    public static final class Fade extends AppIntroPageTransformerType {
        public static final Fade INSTANCE = new Fade();

        private Fade() {
            super(null);
        }
    }

    /* loaded from: classes.dex */
    public static final class Flow extends AppIntroPageTransformerType {
        public static final Flow INSTANCE = new Flow();

        private Flow() {
            super(null);
        }
    }

    /* loaded from: classes.dex */
    public static final class Parallax extends AppIntroPageTransformerType {
        private final double descriptionParallaxFactor;
        private final double imageParallaxFactor;
        private final double titleParallaxFactor;

        public Parallax() {
            this(0.0d, 0.0d, 0.0d, 7, null);
        }

        public final double getDescriptionParallaxFactor() {
            return this.descriptionParallaxFactor;
        }

        public final double getImageParallaxFactor() {
            return this.imageParallaxFactor;
        }

        public final double getTitleParallaxFactor() {
            return this.titleParallaxFactor;
        }

        public /* synthetic */ Parallax(double d, double d2, double d3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 1.0d : d, (i & 2) != 0 ? -1.0d : d2, (i & 4) != 0 ? 2.0d : d3);
        }

        public Parallax(double d, double d2, double d3) {
            super(null);
            this.titleParallaxFactor = d;
            this.imageParallaxFactor = d2;
            this.descriptionParallaxFactor = d3;
        }
    }

    /* loaded from: classes.dex */
    public static final class SlideOver extends AppIntroPageTransformerType {
        public static final SlideOver INSTANCE = new SlideOver();

        private SlideOver() {
            super(null);
        }
    }

    /* loaded from: classes.dex */
    public static final class Zoom extends AppIntroPageTransformerType {
        public static final Zoom INSTANCE = new Zoom();

        private Zoom() {
            super(null);
        }
    }

    public /* synthetic */ AppIntroPageTransformerType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AppIntroPageTransformerType() {
    }
}
