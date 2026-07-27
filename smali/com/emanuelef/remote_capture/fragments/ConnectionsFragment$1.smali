.class Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/material/slider/BaseOnSliderTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;


# direct methods
.method public constructor <init>(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$1;->this$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    .line 2
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    .line 5
    .line 6
    return-void
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
.end method


# virtual methods
.method public onStartTrackingTouch(Lcom/google/android/material/slider/Slider;)V
    .locals 1

    .line 2
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$1;->this$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    const/4 v0, 0x1

    invoke-static {p1, v0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->-$$Nest$fputmSizeSliderActive(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Z)V

    return-void
.end method

.method public bridge synthetic onStartTrackingTouch(Ljava/lang/Object;)V
    .locals 0

    .line 1
    check-cast p1, Lcom/google/android/material/slider/Slider;

    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$1;->onStartTrackingTouch(Lcom/google/android/material/slider/Slider;)V

    return-void
.end method

.method public onStopTrackingTouch(Lcom/google/android/material/slider/Slider;)V
    .locals 2

    .line 2
    invoke-virtual {p1}, Lcom/google/android/material/slider/Slider;->getValue()F

    move-result v0

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    const/16 v0, 0x8

    .line 3
    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    const/4 v0, 0x2

    .line 4
    invoke-virtual {p1, v0}, Lcom/google/android/material/slider/Slider;->setLabelBehavior(I)V

    .line 5
    :cond_0
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$1;->this$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    const/4 v0, 0x0

    invoke-static {p1, v0}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->-$$Nest$fputmSizeSliderActive(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;Z)V

    .line 6
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$1;->this$0:Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;

    invoke-static {p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->-$$Nest$mrecheckMaxConnectionSize(Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;)V

    return-void
.end method

.method public bridge synthetic onStopTrackingTouch(Ljava/lang/Object;)V
    .locals 0

    .line 1
    check-cast p1, Lcom/google/android/material/slider/Slider;

    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment$1;->onStopTrackingTouch(Lcom/google/android/material/slider/Slider;)V

    return-void
.end method
