.class public final synthetic Lcom/google/android/material/slider/BaseSlider$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnScrollChangedListener;


# instance fields
.field public final synthetic f$0:Lcom/google/android/material/slider/Slider;


# direct methods
.method public synthetic constructor <init>(Lcom/google/android/material/slider/Slider;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/material/slider/BaseSlider$$ExternalSyntheticLambda1;->f$0:Lcom/google/android/material/slider/Slider;

    return-void
.end method


# virtual methods
.method public final onScrollChanged()V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/android/material/slider/BaseSlider$$ExternalSyntheticLambda1;->f$0:Lcom/google/android/material/slider/Slider;

    invoke-virtual {v0}, Lcom/google/android/material/slider/BaseSlider;->updateLabels()V

    return-void
.end method
