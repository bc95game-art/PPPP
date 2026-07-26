.class public Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$AppViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AppViewHolder"
.end annotation


# instance fields
.field appName:Landroid/widget/TextView;

.field icon:Landroid/widget/ImageView;

.field packageName:Landroid/widget/TextView;

.field toggle:Landroidx/appcompat/widget/SwitchCompat;


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 1

    .line 1
    invoke-direct {p0, p1}, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 2
    .line 3
    .line 4
    const v0, 0x7f0a0076

    .line 5
    .line 6
    .line 7
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    check-cast v0, Landroid/widget/TextView;

    .line 12
    .line 13
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$AppViewHolder;->appName:Landroid/widget/TextView;

    .line 14
    .line 15
    const v0, 0x7f0a0199

    .line 16
    .line 17
    .line 18
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 19
    .line 20
    .line 21
    move-result-object v0

    .line 22
    check-cast v0, Landroid/widget/ImageView;

    .line 23
    .line 24
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$AppViewHolder;->icon:Landroid/widget/ImageView;

    .line 25
    .line 26
    const v0, 0x7f0a0079

    .line 27
    .line 28
    .line 29
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 30
    .line 31
    .line 32
    move-result-object v0

    .line 33
    check-cast v0, Landroid/widget/TextView;

    .line 34
    .line 35
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$AppViewHolder;->packageName:Landroid/widget/TextView;

    .line 36
    .line 37
    const v0, 0x7f0a035d

    .line 38
    .line 39
    .line 40
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 41
    .line 42
    .line 43
    move-result-object p1

    .line 44
    check-cast p1, Landroidx/appcompat/widget/SwitchCompat;

    .line 45
    .line 46
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter$AppViewHolder;->toggle:Landroidx/appcompat/widget/SwitchCompat;

    .line 47
    .line 48
    return-void
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
