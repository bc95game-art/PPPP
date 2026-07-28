.class public final Lcom/google/android/material/carousel/CarouselOrientationHelper$1;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final synthetic $r8$classId:I

.field public final orientation:I

.field public final synthetic val$carouselLayoutManager:Lcom/google/android/material/carousel/CarouselLayoutManager;


# direct methods
.method public constructor <init>(I)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    iput p1, p0, Lcom/google/android/material/carousel/CarouselOrientationHelper$1;->orientation:I

    return-void
.end method

.method public constructor <init>(Lcom/google/android/material/carousel/CarouselLayoutManager;I)V
    .locals 0

    iput p2, p0, Lcom/google/android/material/carousel/CarouselOrientationHelper$1;->$r8$classId:I

    packed-switch p2, :pswitch_data_0

    .line 3
    iput-object p1, p0, Lcom/google/android/material/carousel/CarouselOrientationHelper$1;->val$carouselLayoutManager:Lcom/google/android/material/carousel/CarouselLayoutManager;

    const/4 p1, 0x1

    invoke-direct {p0, p1}, Lcom/google/android/material/carousel/CarouselOrientationHelper$1;-><init>(I)V

    return-void

    .line 4
    :pswitch_0
    iput-object p1, p0, Lcom/google/android/material/carousel/CarouselOrientationHelper$1;->val$carouselLayoutManager:Lcom/google/android/material/carousel/CarouselLayoutManager;

    const/4 p1, 0x0

    invoke-direct {p0, p1}, Lcom/google/android/material/carousel/CarouselOrientationHelper$1;-><init>(I)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method


# virtual methods
.method public final getParentStart()I
    .locals 2

    .line 1
    iget v0, p0, Lcom/google/android/material/carousel/CarouselOrientationHelper$1;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lcom/google/android/material/carousel/CarouselOrientationHelper$1;->val$carouselLayoutManager:Lcom/google/android/material/carousel/CarouselLayoutManager;

    .line 7
    .line 8
    invoke-virtual {v0}, Lcom/google/android/material/carousel/CarouselLayoutManager;->isLayoutRtl()Z

    .line 9
    .line 10
    .line 11
    move-result v1

    .line 12
    if-eqz v1, :cond_0

    .line 13
    .line 14
    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;->getWidth()I

    .line 15
    .line 16
    .line 17
    move-result v0

    .line 18
    goto :goto_0

    .line 19
    :cond_0
    const/4 v0, 0x0

    .line 20
    :goto_0
    return v0

    .line 21
    :pswitch_0
    const/4 v0, 0x0

    .line 22
    return v0

    .line 23
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
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
    .line 58
.end method
