.class public Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "SourceFile"

# interfaces
.implements Lcom/emanuelef/remote_capture/interfaces/ConnectionsListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/recyclerview/widget/RecyclerView$Adapter;",
        "Lcom/emanuelef/remote_capture/interfaces/ConnectionsListener;"
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "ConnectionsAdapter"


# instance fields
.field private final mAppsResolver:Lcom/emanuelef/remote_capture/AppsResolver;

.field private final mContext:Landroid/content/Context;

.field public mFilter:Lcom/emanuelef/remote_capture/model/FilterDescriptor;

.field private mFilteredConn:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;",
            ">;"
        }
    .end annotation
.end field

.field private final mIdToFilteredPos:Landroid/util/SparseIntArray;

.field private final mLayoutInflater:Landroid/view/LayoutInflater;

.field private mListener:Landroid/view/View$OnClickListener;

.field public final mMask:Lcom/emanuelef/remote_capture/model/MatchList;

.field private mNumRemovedItems:I

.field private mSearch:Ljava/lang/String;

.field private final mSelectableBackground:I

.field private final mSelectedColor:I

.field private mSelectedItem:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

.field private final mSelectedItems:Landroidx/collection/ArraySet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/collection/ArraySet;"
        }
    .end annotation
.end field

.field private mSelectionLongClickListener:Landroid/view/View$OnLongClickListener;

.field private mUnfilteredItemsCount:I

.field private final mUnknownIcon:Landroid/graphics/drawable/Drawable;


# direct methods
.method public static synthetic $r8$lambda$VoKIAct4Di7fxOUwuaV3IN8bZs0(Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;Landroid/view/View;)Z
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->lambda$onCreateViewHolder$0(Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;Landroid/view/View;)Z

    move-result p0

    return p0
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/emanuelef/remote_capture/AppsResolver;)V
    .locals 2

    .line 1
    invoke-direct {p0}, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Landroidx/collection/ArraySet;

    .line 5
    .line 6
    const/4 v1, 0x0

    .line 7
    invoke-direct {v0, v1}, Landroidx/collection/ArraySet;-><init>(I)V

    .line 8
    .line 9
    .line 10
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSelectedItems:Landroidx/collection/ArraySet;

    .line 11
    .line 12
    new-instance v0, Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 13
    .line 14
    invoke-direct {v0}, Lcom/emanuelef/remote_capture/model/FilterDescriptor;-><init>()V

    .line 15
    .line 16
    .line 17
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 18
    .line 19
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mContext:Landroid/content/Context;

    .line 20
    .line 21
    iput-object p2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mAppsResolver:Lcom/emanuelef/remote_capture/AppsResolver;

    .line 22
    .line 23
    const-string p2, "layout_inflater"

    .line 24
    .line 25
    invoke-virtual {p1, p2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    .line 26
    .line 27
    .line 28
    move-result-object p2

    .line 29
    check-cast p2, Landroid/view/LayoutInflater;

    .line 30
    .line 31
    iput-object p2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    .line 32
    .line 33
    const p2, 0x7f0801a5

    .line 34
    .line 35
    .line 36
    invoke-static {p1, p2}, Landroidx/core/content/ContextCompat$Api21Impl;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    .line 37
    .line 38
    .line 39
    move-result-object p2

    .line 40
    iput-object p2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mUnknownIcon:Landroid/graphics/drawable/Drawable;

    .line 41
    .line 42
    const/4 p2, 0x0

    .line 43
    iput-object p2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mListener:Landroid/view/View$OnClickListener;

    .line 44
    .line 45
    iput-object p2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 46
    .line 47
    iput v1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mUnfilteredItemsCount:I

    .line 48
    .line 49
    iput v1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mNumRemovedItems:I

    .line 50
    .line 51
    new-instance v0, Landroid/util/SparseIntArray;

    .line 52
    .line 53
    invoke-direct {v0}, Landroid/util/SparseIntArray;-><init>()V

    .line 54
    .line 55
    .line 56
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mIdToFilteredPos:Landroid/util/SparseIntArray;

    .line 57
    .line 58
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 59
    .line 60
    .line 61
    move-result-object v0

    .line 62
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/PCAPdroid;->getVisualizationMask()Lcom/emanuelef/remote_capture/model/MatchList;

    .line 63
    .line 64
    .line 65
    move-result-object v0

    .line 66
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mMask:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 67
    .line 68
    iput-object p2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSearch:Ljava/lang/String;

    .line 69
    .line 70
    const p2, 0x101042c

    .line 71
    .line 72
    .line 73
    filled-new-array {p2}, [I

    .line 74
    .line 75
    .line 76
    move-result-object p2

    .line 77
    invoke-virtual {p1, p2}, Landroid/content/Context;->obtainStyledAttributes([I)Landroid/content/res/TypedArray;

    .line 78
    .line 79
    .line 80
    move-result-object p2

    .line 81
    const v0, 0x40808080

    .line 82
    .line 83
    .line 84
    invoke-virtual {p2, v1, v0}, Landroid/content/res/TypedArray;->getColor(II)I

    .line 85
    .line 86
    .line 87
    move-result v0

    .line 88
    iput v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSelectedColor:I

    .line 89
    .line 90
    invoke-virtual {p2}, Landroid/content/res/TypedArray;->recycle()V

    .line 91
    .line 92
    .line 93
    new-instance p2, Landroid/util/TypedValue;

    .line 94
    .line 95
    invoke-direct {p2}, Landroid/util/TypedValue;-><init>()V

    .line 96
    .line 97
    .line 98
    invoke-virtual {p1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    .line 99
    .line 100
    .line 101
    move-result-object p1

    .line 102
    const v0, 0x101030e

    .line 103
    .line 104
    .line 105
    const/4 v1, 0x1

    .line 106
    invoke-virtual {p1, v0, p2, v1}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 107
    .line 108
    .line 109
    iget p1, p2, Landroid/util/TypedValue;->resourceId:I

    .line 110
    .line 111
    iput p1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSelectableBackground:I

    .line 112
    .line 113
    invoke-virtual {p0, v1}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->setHasStableIds(Z)V

    .line 114
    .line 115
    .line 116
    return-void
    .line 117
    .line 118
    .line 119
.end method

.method private fixFilteredPositions(I)V
    .locals 3

    .line 1
    :goto_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-ge p1, v0, :cond_0

    .line 8
    .line 9
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mIdToFilteredPos:Landroid/util/SparseIntArray;

    .line 10
    .line 11
    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 12
    .line 13
    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 14
    .line 15
    .line 16
    move-result-object v1

    .line 17
    check-cast v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 18
    .line 19
    iget v1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 20
    .line 21
    iget v2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mNumRemovedItems:I

    .line 22
    .line 23
    add-int/2addr v2, p1

    .line 24
    invoke-virtual {v0, v1, v2}, Landroid/util/SparseIntArray;->put(II)V

    .line 25
    .line 26
    .line 27
    add-int/lit8 p1, p1, 0x1

    .line 28
    .line 29
    goto :goto_0

    .line 30
    :cond_0
    return-void
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

.method private getFilteredItemPos(I)I
    .locals 2

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mIdToFilteredPos:Landroid/util/SparseIntArray;

    .line 2
    .line 3
    const/4 v1, -0x1

    .line 4
    invoke-virtual {v0, p1, v1}, Landroid/util/SparseIntArray;->get(II)I

    .line 5
    .line 6
    .line 7
    move-result p1

    .line 8
    if-ne p1, v1, :cond_0

    .line 9
    .line 10
    return v1

    .line 11
    :cond_0
    iget v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mNumRemovedItems:I

    .line 12
    .line 13
    sub-int/2addr p1, v0

    .line 14
    return p1
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

.method private synthetic lambda$onCreateViewHolder$0(Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;Landroid/view/View;)Z
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSelectionLongClickListener:Landroid/view/View$OnLongClickListener;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-interface {v0, p2}, Landroid/view/View$OnLongClickListener;->onLongClick(Landroid/view/View;)Z

    .line 6
    .line 7
    .line 8
    move-result p2

    .line 9
    if-eqz p2, :cond_0

    .line 10
    .line 11
    const/4 p1, 0x1

    .line 12
    return p1

    .line 13
    :cond_0
    invoke-virtual {p1}, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;->getAbsoluteAdapterPosition()I

    .line 14
    .line 15
    .line 16
    move-result p1

    .line 17
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getItem(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 18
    .line 19
    .line 20
    move-result-object p1

    .line 21
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSelectedItem:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 22
    .line 23
    const/4 p1, 0x0

    .line 24
    return p1
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
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
.end method

.method private matches(Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)Z
    .locals 2

    .line 1
    if-eqz p1, :cond_1

    .line 2
    .line 3
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 4
    .line 5
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/model/FilterDescriptor;->matches(Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)Z

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    if-eqz v0, :cond_1

    .line 10
    .line 11
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSearch:Ljava/lang/String;

    .line 12
    .line 13
    if-eqz v0, :cond_0

    .line 14
    .line 15
    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mAppsResolver:Lcom/emanuelef/remote_capture/AppsResolver;

    .line 16
    .line 17
    invoke-virtual {p1, v1, v0}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->matches(Lcom/emanuelef/remote_capture/AppsResolver;Ljava/lang/String;)Z

    .line 18
    .line 19
    .line 20
    move-result p1

    .line 21
    if-eqz p1, :cond_1

    .line 22
    .line 23
    :cond_0
    const/4 p1, 0x1

    .line 24
    return p1

    .line 25
    :cond_1
    const/4 p1, 0x0

    .line 26
    return p1
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

.method private removeFilteredItemAt(I)V
    .locals 2

    .line 1
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getItem(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    return-void

    .line 8
    :cond_0
    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 9
    .line 10
    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 11
    .line 12
    .line 13
    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mIdToFilteredPos:Landroid/util/SparseIntArray;

    .line 14
    .line 15
    iget v0, v0, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 16
    .line 17
    invoke-virtual {v1, v0}, Landroid/util/SparseIntArray;->delete(I)V

    .line 18
    .line 19
    .line 20
    invoke-virtual {p0, p1}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyItemRemoved(I)V

    .line 21
    .line 22
    .line 23
    return-void
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
.method public clearSelection()V
    .locals 1
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NotifyDataSetChanged"
        }
    .end annotation

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSelectedItems:Landroidx/collection/ArraySet;

    .line 2
    .line 3
    invoke-virtual {v0}, Landroidx/collection/ArraySet;->clear()V

    .line 4
    .line 5
    .line 6
    invoke-virtual {p0}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyDataSetChanged()V

    .line 7
    .line 8
    .line 9
    return-void
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
    .line 58
.end method

.method public connectionsAdded(I[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)V
    .locals 7

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mUnfilteredItemsCount:I

    .line 2
    .line 3
    array-length v1, p2

    .line 4
    add-int/2addr v0, v1

    .line 5
    iput v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mUnfilteredItemsCount:I

    .line 6
    .line 7
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 8
    .line 9
    if-nez v0, :cond_0

    .line 10
    .line 11
    array-length p2, p2

    .line 12
    invoke-virtual {p0, p1, p2}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyItemRangeInserted(II)V

    .line 13
    .line 14
    .line 15
    return-void

    .line 16
    :cond_0
    iget p1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mNumRemovedItems:I

    .line 17
    .line 18
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 19
    .line 20
    .line 21
    move-result v0

    .line 22
    add-int/2addr v0, p1

    .line 23
    array-length p1, p2

    .line 24
    const/4 v1, 0x0

    .line 25
    const/4 v2, 0x0

    .line 26
    :goto_0
    if-ge v1, p1, :cond_2

    .line 27
    .line 28
    aget-object v3, p2, v1

    .line 29
    .line 30
    invoke-direct {p0, v3}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->matches(Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)Z

    .line 31
    .line 32
    .line 33
    move-result v4

    .line 34
    if-eqz v4, :cond_1

    .line 35
    .line 36
    iget-object v4, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mIdToFilteredPos:Landroid/util/SparseIntArray;

    .line 37
    .line 38
    iget v5, v3, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 39
    .line 40
    add-int/lit8 v6, v0, 0x1

    .line 41
    .line 42
    invoke-virtual {v4, v5, v0}, Landroid/util/SparseIntArray;->put(II)V

    .line 43
    .line 44
    .line 45
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 46
    .line 47
    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 48
    .line 49
    .line 50
    add-int/lit8 v2, v2, 0x1

    .line 51
    .line 52
    move v0, v6

    .line 53
    :cond_1
    add-int/lit8 v1, v1, 0x1

    .line 54
    .line 55
    goto :goto_0

    .line 56
    :cond_2
    if-lez v2, :cond_3

    .line 57
    .line 58
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 59
    .line 60
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    .line 61
    .line 62
    .line 63
    move-result p1

    .line 64
    sub-int/2addr p1, v2

    .line 65
    invoke-virtual {p0, p1, v2}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyItemRangeInserted(II)V

    .line 66
    .line 67
    .line 68
    :cond_3
    return-void
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
.end method

.method public connectionsChanges(I)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mUnfilteredItemsCount:I

    .line 2
    .line 3
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->refreshFilteredConnections()V

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

.method public connectionsRemoved(I[Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)V
    .locals 5

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mUnfilteredItemsCount:I

    .line 2
    .line 3
    array-length v1, p2

    .line 4
    sub-int/2addr v0, v1

    .line 5
    iput v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mUnfilteredItemsCount:I

    .line 6
    .line 7
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 8
    .line 9
    if-nez v0, :cond_0

    .line 10
    .line 11
    array-length p2, p2

    .line 12
    invoke-virtual {p0, p1, p2}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyItemRangeRemoved(II)V

    .line 13
    .line 14
    .line 15
    return-void

    .line 16
    :cond_0
    array-length p1, p2

    .line 17
    const/4 v0, 0x0

    .line 18
    const/4 v1, 0x0

    .line 19
    :goto_0
    if-ge v1, p1, :cond_3

    .line 20
    .line 21
    aget-object v2, p2, v1

    .line 22
    .line 23
    if-nez v2, :cond_1

    .line 24
    .line 25
    goto :goto_1

    .line 26
    :cond_1
    iget-object v3, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSelectedItems:Landroidx/collection/ArraySet;

    .line 27
    .line 28
    iget v4, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 29
    .line 30
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 31
    .line 32
    .line 33
    move-result-object v4

    .line 34
    invoke-virtual {v3, v4}, Landroidx/collection/ArraySet;->remove(Ljava/lang/Object;)Z

    .line 35
    .line 36
    .line 37
    iget v2, v2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 38
    .line 39
    invoke-direct {p0, v2}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getFilteredItemPos(I)I

    .line 40
    .line 41
    .line 42
    move-result v2

    .line 43
    const/4 v3, -0x1

    .line 44
    if-eq v2, v3, :cond_2

    .line 45
    .line 46
    invoke-direct {p0, v2}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->removeFilteredItemAt(I)V

    .line 47
    .line 48
    .line 49
    iget v2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mNumRemovedItems:I

    .line 50
    .line 51
    add-int/lit8 v2, v2, 0x1

    .line 52
    .line 53
    iput v2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mNumRemovedItems:I

    .line 54
    .line 55
    :cond_2
    :goto_1
    add-int/lit8 v1, v1, 0x1

    .line 56
    .line 57
    goto :goto_0

    .line 58
    :cond_3
    return-void
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
.end method

.method public connectionsUpdated([I)V
    .locals 11

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    if-nez v0, :cond_0

    .line 5
    .line 6
    array-length v0, p1

    .line 7
    :goto_0
    if-ge v1, v0, :cond_4

    .line 8
    .line 9
    aget v2, p1, v1

    .line 10
    .line 11
    invoke-virtual {p0, v2}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyItemChanged(I)V

    .line 12
    .line 13
    .line 14
    add-int/lit8 v1, v1, 0x1

    .line 15
    .line 16
    goto :goto_0

    .line 17
    :cond_0
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->requireConnsRegister()Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 18
    .line 19
    .line 20
    move-result-object v0

    .line 21
    invoke-static {p1}, Ljava/util/Arrays;->sort([I)V

    .line 22
    .line 23
    .line 24
    array-length v2, p1

    .line 25
    const/4 v3, -0x1

    .line 26
    const/4 v4, 0x0

    .line 27
    const/4 v5, -0x1

    .line 28
    :goto_1
    if-ge v1, v2, :cond_3

    .line 29
    .line 30
    aget v6, p1, v1

    .line 31
    .line 32
    invoke-virtual {v0, v6}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->getConn(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 33
    .line 34
    .line 35
    move-result-object v6

    .line 36
    if-eqz v6, :cond_2

    .line 37
    .line 38
    iget v7, v6, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 39
    .line 40
    invoke-direct {p0, v7}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getFilteredItemPos(I)I

    .line 41
    .line 42
    .line 43
    move-result v7

    .line 44
    if-eq v7, v3, :cond_2

    .line 45
    .line 46
    sub-int/2addr v7, v4

    .line 47
    invoke-direct {p0, v6}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->matches(Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)Z

    .line 48
    .line 49
    .line 50
    move-result v8

    .line 51
    const-string v9, "ConnectionsAdapter"

    .line 52
    .line 53
    if-eqz v8, :cond_1

    .line 54
    .line 55
    const-string v6, "Changed item "

    .line 56
    .line 57
    const-string v8, ", dataset size: "

    .line 58
    .line 59
    invoke-static {v6, v7, v8}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->m(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/StringBuilder;

    .line 60
    .line 61
    .line 62
    move-result-object v6

    .line 63
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getItemCount()I

    .line 64
    .line 65
    .line 66
    move-result v8

    .line 67
    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 68
    .line 69
    .line 70
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 71
    .line 72
    .line 73
    move-result-object v6

    .line 74
    invoke-static {v9, v6}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    .line 76
    .line 77
    invoke-virtual {p0, v7}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyItemChanged(I)V

    .line 78
    .line 79
    .line 80
    goto :goto_2

    .line 81
    :cond_1
    const-string v8, "Unmatch item "

    .line 82
    .line 83
    const-string v10, ": "

    .line 84
    .line 85
    invoke-static {v8, v7, v10}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->m(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/StringBuilder;

    .line 86
    .line 87
    .line 88
    move-result-object v8

    .line 89
    invoke-virtual {v6}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->toString()Ljava/lang/String;

    .line 90
    .line 91
    .line 92
    move-result-object v6

    .line 93
    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 94
    .line 95
    .line 96
    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 97
    .line 98
    .line 99
    move-result-object v6

    .line 100
    invoke-static {v9, v6}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    .line 102
    .line 103
    invoke-direct {p0, v7}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->removeFilteredItemAt(I)V

    .line 104
    .line 105
    .line 106
    add-int/lit8 v4, v4, 0x1

    .line 107
    .line 108
    if-ne v5, v3, :cond_2

    .line 109
    .line 110
    move v5, v7

    .line 111
    :cond_2
    :goto_2
    add-int/lit8 v1, v1, 0x1

    .line 112
    .line 113
    goto :goto_1

    .line 114
    :cond_3
    if-eq v5, v3, :cond_4

    .line 115
    .line 116
    invoke-direct {p0, v5}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->fixFilteredPositions(I)V

    .line 117
    .line 118
    .line 119
    :cond_4
    return-void
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
.end method

.method public dumpConnectionsCsv(Z)Ljava/lang/String;
    .locals 11

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 2
    .line 3
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 4
    .line 5
    .line 6
    new-instance v1, Lcom/emanuelef/remote_capture/AppsResolver;

    .line 7
    .line 8
    iget-object v2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mContext:Landroid/content/Context;

    .line 9
    .line 10
    invoke-direct {v1, v2}, Lcom/emanuelef/remote_capture/AppsResolver;-><init>(Landroid/content/Context;)V

    .line 11
    .line 12
    .line 13
    iget-object v2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mContext:Landroid/content/Context;

    .line 14
    .line 15
    invoke-static {v2}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    .line 16
    .line 17
    .line 18
    move-result-object v3

    .line 19
    invoke-static {v2, v3}, Lcom/emanuelef/remote_capture/model/Prefs;->isMalwareDetectionEnabled(Landroid/content/Context;Landroid/content/SharedPreferences;)Z

    .line 20
    .line 21
    .line 22
    move-result v2

    .line 23
    iget-object v3, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mContext:Landroid/content/Context;

    .line 24
    .line 25
    const v4, 0x7f1400a1

    .line 26
    .line 27
    .line 28
    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 29
    .line 30
    .line 31
    move-result-object v3

    .line 32
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 33
    .line 34
    .line 35
    if-eqz v2, :cond_0

    .line 36
    .line 37
    const-string v3, ",Malicious"

    .line 38
    .line 39
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 40
    .line 41
    .line 42
    :cond_0
    const-string v3, "\n"

    .line 43
    .line 44
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 45
    .line 46
    .line 47
    const/4 v4, 0x0

    .line 48
    const/4 v5, 0x0

    .line 49
    :goto_0
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getItemCount()I

    .line 50
    .line 51
    .line 52
    move-result v6

    .line 53
    if-ge v5, v6, :cond_7

    .line 54
    .line 55
    invoke-virtual {p0, v5}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getItem(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 56
    .line 57
    .line 58
    move-result-object v6

    .line 59
    if-eqz v6, :cond_6

    .line 60
    .line 61
    if-eqz p1, :cond_1

    .line 62
    .line 63
    iget-object v7, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSelectedItems:Landroidx/collection/ArraySet;

    .line 64
    .line 65
    iget v8, v6, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 66
    .line 67
    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 68
    .line 69
    .line 70
    move-result-object v8

    .line 71
    invoke-virtual {v7, v8}, Landroidx/collection/ArraySet;->contains(Ljava/lang/Object;)Z

    .line 72
    .line 73
    .line 74
    move-result v7

    .line 75
    if-eqz v7, :cond_6

    .line 76
    .line 77
    :cond_1
    iget v7, v6, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 78
    .line 79
    invoke-virtual {v1, v7, v4}, Lcom/emanuelef/remote_capture/AppsResolver;->getAppByUid(II)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 80
    .line 81
    .line 82
    move-result-object v7

    .line 83
    iget v8, v6, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->ipproto:I

    .line 84
    .line 85
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 86
    .line 87
    .line 88
    const-string v8, ","

    .line 89
    .line 90
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 91
    .line 92
    .line 93
    iget-object v9, v6, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->src_ip:Ljava/lang/String;

    .line 94
    .line 95
    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 96
    .line 97
    .line 98
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 99
    .line 100
    .line 101
    iget v9, v6, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->src_port:I

    .line 102
    .line 103
    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 104
    .line 105
    .line 106
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 107
    .line 108
    .line 109
    iget-object v9, v6, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->dst_ip:Ljava/lang/String;

    .line 110
    .line 111
    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 112
    .line 113
    .line 114
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 115
    .line 116
    .line 117
    iget v9, v6, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->dst_port:I

    .line 118
    .line 119
    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 120
    .line 121
    .line 122
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 123
    .line 124
    .line 125
    iget v9, v6, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 126
    .line 127
    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 128
    .line 129
    .line 130
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 131
    .line 132
    .line 133
    const-string v9, ""

    .line 134
    .line 135
    if-eqz v7, :cond_2

    .line 136
    .line 137
    invoke-virtual {v7}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getName()Ljava/lang/String;

    .line 138
    .line 139
    .line 140
    move-result-object v10

    .line 141
    goto :goto_1

    .line 142
    :cond_2
    move-object v10, v9

    .line 143
    :goto_1
    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 144
    .line 145
    .line 146
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 147
    .line 148
    .line 149
    if-eqz v7, :cond_3

    .line 150
    .line 151
    invoke-virtual {v7}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getPackageName()Ljava/lang/String;

    .line 152
    .line 153
    .line 154
    move-result-object v7

    .line 155
    goto :goto_2

    .line 156
    :cond_3
    move-object v7, v9

    .line 157
    :goto_2
    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 158
    .line 159
    .line 160
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 161
    .line 162
    .line 163
    iget-object v7, v6, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->l7proto:Ljava/lang/String;

    .line 164
    .line 165
    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 166
    .line 167
    .line 168
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 169
    .line 170
    .line 171
    iget-object v7, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mContext:Landroid/content/Context;

    .line 172
    .line 173
    invoke-virtual {v6, v7}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->getStatusLabel(Landroid/content/Context;)Ljava/lang/String;

    .line 174
    .line 175
    .line 176
    move-result-object v7

    .line 177
    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 178
    .line 179
    .line 180
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 181
    .line 182
    .line 183
    iget-object v7, v6, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 184
    .line 185
    if-eqz v7, :cond_4

    .line 186
    .line 187
    move-object v9, v7

    .line 188
    :cond_4
    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 189
    .line 190
    .line 191
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 192
    .line 193
    .line 194
    iget-wide v9, v6, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->sent_bytes:J

    .line 195
    .line 196
    invoke-virtual {v0, v9, v10}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 197
    .line 198
    .line 199
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 200
    .line 201
    .line 202
    iget-wide v9, v6, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->rcvd_bytes:J

    .line 203
    .line 204
    invoke-virtual {v0, v9, v10}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    .line 205
    .line 206
    .line 207
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 208
    .line 209
    .line 210
    iget v7, v6, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->sent_pkts:I

    .line 211
    .line 212
    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 213
    .line 214
    .line 215
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 216
    .line 217
    .line 218
    iget v7, v6, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->rcvd_pkts:I

    .line 219
    .line 220
    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 221
    .line 222
    .line 223
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 224
    .line 225
    .line 226
    iget-object v7, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mContext:Landroid/content/Context;

    .line 227
    .line 228
    iget-wide v9, v6, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->first_seen:J

    .line 229
    .line 230
    invoke-static {v7, v9, v10}, Lcom/emanuelef/remote_capture/Utils;->formatMillisIso8601(Landroid/content/Context;J)Ljava/lang/String;

    .line 231
    .line 232
    .line 233
    move-result-object v7

    .line 234
    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 235
    .line 236
    .line 237
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 238
    .line 239
    .line 240
    iget-object v7, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mContext:Landroid/content/Context;

    .line 241
    .line 242
    iget-wide v9, v6, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->last_seen:J

    .line 243
    .line 244
    invoke-static {v7, v9, v10}, Lcom/emanuelef/remote_capture/Utils;->formatMillisIso8601(Landroid/content/Context;J)Ljava/lang/String;

    .line 245
    .line 246
    .line 247
    move-result-object v7

    .line 248
    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 249
    .line 250
    .line 251
    if-eqz v2, :cond_5

    .line 252
    .line 253
    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 254
    .line 255
    .line 256
    invoke-virtual {v6}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->isBlacklisted()Z

    .line 257
    .line 258
    .line 259
    move-result v6

    .line 260
    if-eqz v6, :cond_5

    .line 261
    .line 262
    const-string v6, "yes"

    .line 263
    .line 264
    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 265
    .line 266
    .line 267
    :cond_5
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 268
    .line 269
    .line 270
    :cond_6
    add-int/lit8 v5, v5, 0x1

    .line 271
    .line 272
    goto/16 :goto_0

    .line 273
    .line 274
    :cond_7
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 275
    .line 276
    .line 277
    move-result-object p1

    .line 278
    return-object p1
    .line 279
    .line 280
    .line 281
.end method

.method public getFilteredConnectionIds()Ljava/util/ArrayList;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    const/4 v0, 0x0

    .line 6
    return-object v0

    .line 7
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    .line 8
    .line 9
    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 10
    .line 11
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    .line 12
    .line 13
    .line 14
    move-result v1

    .line 15
    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 16
    .line 17
    .line 18
    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 19
    .line 20
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    .line 21
    .line 22
    .line 23
    move-result v2

    .line 24
    const/4 v3, 0x0

    .line 25
    :goto_0
    if-ge v3, v2, :cond_1

    .line 26
    .line 27
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 28
    .line 29
    .line 30
    move-result-object v4

    .line 31
    add-int/lit8 v3, v3, 0x1

    .line 32
    .line 33
    check-cast v4, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 34
    .line 35
    iget v4, v4, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 36
    .line 37
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 38
    .line 39
    .line 40
    move-result-object v4

    .line 41
    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 42
    .line 43
    .line 44
    goto :goto_0

    .line 45
    :cond_1
    return-object v0
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

.method public getItem(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    const-string v2, "ConnectionsAdapter"

    .line 5
    .line 6
    if-eqz v0, :cond_2

    .line 7
    .line 8
    if-ltz p1, :cond_1

    .line 9
    .line 10
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 11
    .line 12
    .line 13
    move-result v0

    .line 14
    if-lt p1, v0, :cond_0

    .line 15
    .line 16
    goto :goto_0

    .line 17
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 18
    .line 19
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 20
    .line 21
    .line 22
    move-result-object p1

    .line 23
    check-cast p1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 24
    .line 25
    return-object p1

    .line 26
    :cond_1
    :goto_0
    new-instance v0, Ljava/lang/StringBuilder;

    .line 27
    .line 28
    const-string v3, "getItem(filtered): bad position: "

    .line 29
    .line 30
    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 31
    .line 32
    .line 33
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 34
    .line 35
    .line 36
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 37
    .line 38
    .line 39
    move-result-object p1

    .line 40
    invoke-static {v2, p1}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    .line 42
    .line 43
    return-object v1

    .line 44
    :cond_2
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getConnsRegister()Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 45
    .line 46
    .line 47
    move-result-object v0

    .line 48
    if-ltz p1, :cond_4

    .line 49
    .line 50
    iget v3, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mUnfilteredItemsCount:I

    .line 51
    .line 52
    if-ge p1, v3, :cond_4

    .line 53
    .line 54
    if-nez v0, :cond_3

    .line 55
    .line 56
    goto :goto_1

    .line 57
    :cond_3
    invoke-virtual {v0, p1}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->getConn(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 58
    .line 59
    .line 60
    move-result-object p1

    .line 61
    return-object p1

    .line 62
    :cond_4
    :goto_1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 63
    .line 64
    const-string v3, "getItem: bad position: "

    .line 65
    .line 66
    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 67
    .line 68
    .line 69
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 70
    .line 71
    .line 72
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 73
    .line 74
    .line 75
    move-result-object p1

    .line 76
    invoke-static {v2, p1}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 77
    .line 78
    .line 79
    return-object v1
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
.end method

.method public getItemCount()I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    return v0

    .line 10
    :cond_0
    iget v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mUnfilteredItemsCount:I

    .line 11
    .line 12
    return v0
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
    .line 58
.end method

.method public getItemId(I)J
    .locals 2

    .line 1
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getItem(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    if-eqz p1, :cond_0

    .line 6
    .line 7
    iget p1, p1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 8
    .line 9
    goto :goto_0

    .line 10
    :cond_0
    const/4 p1, -0x1

    .line 11
    :goto_0
    int-to-long v0, p1

    .line 12
    return-wide v0
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

.method public getSelectedCount()I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSelectedItems:Landroidx/collection/ArraySet;

    .line 2
    .line 3
    iget v0, v0, Landroidx/collection/ArraySet;->_size:I

    .line 4
    .line 5
    return v0
    .line 6
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
    .line 58
.end method

.method public getSelectedItem()Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSelectedItem:Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 2
    .line 3
    return-object v0
    .line 4
    .line 5
    .line 6
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
    .line 58
.end method

.method public hasFilter()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSearch:Ljava/lang/String;

    .line 2
    .line 3
    if-nez v0, :cond_1

    .line 4
    .line 5
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilter:Lcom/emanuelef/remote_capture/model/FilterDescriptor;

    .line 6
    .line 7
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/FilterDescriptor;->isSet()Z

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    if-eqz v0, :cond_0

    .line 12
    .line 13
    goto :goto_0

    .line 14
    :cond_0
    const/4 v0, 0x0

    .line 15
    return v0

    .line 16
    :cond_1
    :goto_0
    const/4 v0, 0x1

    .line 17
    return v0
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
    .line 58
.end method

.method public bridge synthetic onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V
    .locals 0

    .line 1
    check-cast p1, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;

    invoke-virtual {p0, p1, p2}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->onBindViewHolder(Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;I)V

    return-void
.end method

.method public onBindViewHolder(Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;I)V
    .locals 3

    .line 2
    invoke-virtual {p0, p2}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getItem(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    move-result-object v0

    if-nez v0, :cond_0

    .line 3
    new-instance p1, Ljava/lang/StringBuilder;

    const-string v0, "bad position: "

    invoke-direct {p1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string p2, "ConnectionsAdapter"

    invoke-static {p2, p1}, Lcom/emanuelef/remote_capture/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    return-void

    .line 4
    :cond_0
    iget-object p2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mAppsResolver:Lcom/emanuelef/remote_capture/AppsResolver;

    iget-object v2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mUnknownIcon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p1, p2, v0, v1, v2}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->bindConn(Landroid/content/Context;Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;Lcom/emanuelef/remote_capture/AppsResolver;Landroid/graphics/drawable/Drawable;)V

    .line 5
    iget-object p2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSelectedItems:Landroidx/collection/ArraySet;

    iget v0, v0, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p2, v0}, Landroidx/collection/ArraySet;->contains(Ljava/lang/Object;)Z

    move-result p2

    if-eqz p2, :cond_1

    .line 6
    iget-object p1, p1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;->itemView:Landroid/view/View;

    iget p2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSelectedColor:I

    invoke-virtual {p1, p2}, Landroid/view/View;->setBackgroundColor(I)V

    return-void

    .line 7
    :cond_1
    iget-object p1, p1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;->itemView:Landroid/view/View;

    iget p2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSelectableBackground:I

    invoke-virtual {p1, p2}, Landroid/view/View;->setBackgroundResource(I)V

    return-void
.end method

.method public bridge synthetic onCreateViewHolder(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    .locals 0

    .line 1
    invoke-virtual {p0, p1, p2}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->onCreateViewHolder(Landroid/view/ViewGroup;I)Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;

    move-result-object p1

    return-object p1
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;
    .locals 2

    .line 2
    iget-object p2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    const v0, 0x7f0d002c

    const/4 v1, 0x0

    invoke-virtual {p2, v0, p1, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p1

    const/4 p2, 0x1

    .line 3
    invoke-virtual {p1, p2}, Landroid/view/View;->setLongClickable(Z)V

    .line 4
    iget-object p2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mListener:Landroid/view/View$OnClickListener;

    if-eqz p2, :cond_0

    .line 5
    invoke-virtual {p1, p2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 6
    :cond_0
    new-instance p2, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;

    invoke-direct {p2, p1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;-><init>(Landroid/view/View;)V

    .line 7
    new-instance v0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda1;

    const/4 v1, 0x1

    invoke-direct {v0, p0, p2, v1}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda1;-><init>(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V

    invoke-virtual {p1, v0}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    return-object p2
.end method

.method public refreshFilteredConnections()V
    .locals 6
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NotifyDataSetChanged"
        }
    .end annotation

    .line 1
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->getConnsRegister()Lcom/emanuelef/remote_capture/ConnectionsRegister;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    return-void

    .line 8
    :cond_0
    const-string v1, "ConnectionsAdapter"

    .line 9
    .line 10
    new-instance v2, Ljava/lang/StringBuilder;

    .line 11
    .line 12
    const-string v3, "refreshFilteredConn ("

    .line 13
    .line 14
    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 15
    .line 16
    .line 17
    iget v3, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mUnfilteredItemsCount:I

    .line 18
    .line 19
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 20
    .line 21
    .line 22
    const-string v3, ") unfiltered"

    .line 23
    .line 24
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 25
    .line 26
    .line 27
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 28
    .line 29
    .line 30
    move-result-object v2

    .line 31
    invoke-static {v1, v2}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 32
    .line 33
    .line 34
    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mIdToFilteredPos:Landroid/util/SparseIntArray;

    .line 35
    .line 36
    invoke-virtual {v1}, Landroid/util/SparseIntArray;->clear()V

    .line 37
    .line 38
    .line 39
    const/4 v1, 0x0

    .line 40
    iput v1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mNumRemovedItems:I

    .line 41
    .line 42
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->hasFilter()Z

    .line 43
    .line 44
    .line 45
    move-result v2

    .line 46
    if-eqz v2, :cond_3

    .line 47
    .line 48
    new-instance v2, Ljava/util/ArrayList;

    .line 49
    .line 50
    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 51
    .line 52
    .line 53
    iput-object v2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 54
    .line 55
    monitor-enter v0

    .line 56
    const/4 v2, 0x0

    .line 57
    :goto_0
    :try_start_0
    iget v3, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mUnfilteredItemsCount:I

    .line 58
    .line 59
    if-ge v1, v3, :cond_2

    .line 60
    .line 61
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/ConnectionsRegister;->getConn(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 62
    .line 63
    .line 64
    move-result-object v3

    .line 65
    invoke-direct {p0, v3}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->matches(Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)Z

    .line 66
    .line 67
    .line 68
    move-result v4

    .line 69
    if-eqz v4, :cond_1

    .line 70
    .line 71
    iget-object v4, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 72
    .line 73
    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 74
    .line 75
    .line 76
    iget-object v4, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mIdToFilteredPos:Landroid/util/SparseIntArray;

    .line 77
    .line 78
    iget v3, v3, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 79
    .line 80
    add-int/lit8 v5, v2, 0x1

    .line 81
    .line 82
    invoke-virtual {v4, v3, v2}, Landroid/util/SparseIntArray;->put(II)V

    .line 83
    .line 84
    .line 85
    move v2, v5

    .line 86
    goto :goto_1

    .line 87
    :catchall_0
    move-exception v1

    .line 88
    goto :goto_2

    .line 89
    :cond_1
    :goto_1
    add-int/lit8 v1, v1, 0x1

    .line 90
    .line 91
    goto :goto_0

    .line 92
    :cond_2
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 93
    const-string v0, "ConnectionsAdapter"

    .line 94
    .line 95
    new-instance v1, Ljava/lang/StringBuilder;

    .line 96
    .line 97
    const-string v2, "refreshFilteredConn: "

    .line 98
    .line 99
    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 100
    .line 101
    .line 102
    iget-object v2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 103
    .line 104
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    .line 105
    .line 106
    .line 107
    move-result v2

    .line 108
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 109
    .line 110
    .line 111
    const-string v2, " connections matched"

    .line 112
    .line 113
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 114
    .line 115
    .line 116
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 117
    .line 118
    .line 119
    move-result-object v1

    .line 120
    invoke-static {v0, v1}, Lcom/emanuelef/remote_capture/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 121
    .line 122
    .line 123
    goto :goto_3

    .line 124
    :goto_2
    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 125
    throw v1

    .line 126
    :cond_3
    const/4 v0, 0x0

    .line 127
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mFilteredConn:Ljava/util/ArrayList;

    .line 128
    .line 129
    :goto_3
    invoke-virtual {p0}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyDataSetChanged()V

    .line 130
    .line 131
    .line 132
    return-void
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
    .line 282
    .line 283
    .line 284
    .line 285
    .line 286
    .line 287
    .line 288
    .line 289
    .line 290
    .line 291
    .line 292
    .line 293
    .line 294
    .line 295
    .line 296
    .line 297
    .line 298
    .line 299
    .line 300
    .line 301
    .line 302
    .line 303
    .line 304
    .line 305
    .line 306
    .line 307
    .line 308
    .line 309
    .line 310
    .line 311
    .line 312
    .line 313
    .line 314
    .line 315
    .line 316
    .line 317
    .line 318
    .line 319
    .line 320
    .line 321
    .line 322
    .line 323
    .line 324
    .line 325
    .line 326
    .line 327
    .line 328
    .line 329
    .line 330
    .line 331
    .line 332
    .line 333
    .line 334
    .line 335
    .line 336
    .line 337
    .line 338
    .line 339
    .line 340
    .line 341
    .line 342
    .line 343
    .line 344
    .line 345
    .line 346
    .line 347
    .line 348
    .line 349
    .line 350
    .line 351
    .line 352
    .line 353
    .line 354
    .line 355
    .line 356
    .line 357
.end method

.method public selectAll()V
    .locals 3
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NotifyDataSetChanged"
        }
    .end annotation

    .line 1
    const/4 v0, 0x0

    .line 2
    :goto_0
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getItemCount()I

    .line 3
    .line 4
    .line 5
    move-result v1

    .line 6
    if-ge v0, v1, :cond_1

    .line 7
    .line 8
    invoke-virtual {p0, v0}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getItem(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 9
    .line 10
    .line 11
    move-result-object v1

    .line 12
    if-eqz v1, :cond_0

    .line 13
    .line 14
    iget-object v2, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSelectedItems:Landroidx/collection/ArraySet;

    .line 15
    .line 16
    iget v1, v1, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 17
    .line 18
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 19
    .line 20
    .line 21
    move-result-object v1

    .line 22
    invoke-virtual {v2, v1}, Landroidx/collection/ArraySet;->add(Ljava/lang/Object;)Z

    .line 23
    .line 24
    .line 25
    :cond_0
    add-int/lit8 v0, v0, 0x1

    .line 26
    .line 27
    goto :goto_0

    .line 28
    :cond_1
    invoke-virtual {p0}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyDataSetChanged()V

    .line 29
    .line 30
    .line 31
    return-void
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

.method public selectItem(I)V
    .locals 2

    .line 1
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getItem(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    return-void

    .line 8
    :cond_0
    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSelectedItems:Landroidx/collection/ArraySet;

    .line 9
    .line 10
    iget v0, v0, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 11
    .line 12
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 13
    .line 14
    .line 15
    move-result-object v0

    .line 16
    invoke-virtual {v1, v0}, Landroidx/collection/ArraySet;->add(Ljava/lang/Object;)Z

    .line 17
    .line 18
    .line 19
    invoke-virtual {p0, p1}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyItemChanged(I)V

    .line 20
    .line 21
    .line 22
    return-void
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

.method public setClickListener(Landroid/view/View$OnClickListener;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mListener:Landroid/view/View$OnClickListener;

    .line 2
    .line 3
    return-void
    .line 4
    .line 5
    .line 6
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

.method public setSearch(Ljava/lang/String;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSearch:Ljava/lang/String;

    .line 2
    .line 3
    invoke-virtual {p0}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->refreshFilteredConnections()V

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

.method public setSelectionLongClickListener(Landroid/view/View$OnLongClickListener;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSelectionLongClickListener:Landroid/view/View$OnLongClickListener;

    .line 2
    .line 3
    return-void
    .line 4
    .line 5
    .line 6
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

.method public toggleSelection(I)V
    .locals 3

    .line 1
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->getItem(I)Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    if-nez v0, :cond_0

    .line 6
    .line 7
    return-void

    .line 8
    :cond_0
    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSelectedItems:Landroidx/collection/ArraySet;

    .line 9
    .line 10
    iget v2, v0, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 11
    .line 12
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 13
    .line 14
    .line 15
    move-result-object v2

    .line 16
    invoke-virtual {v1, v2}, Landroidx/collection/ArraySet;->remove(Ljava/lang/Object;)Z

    .line 17
    .line 18
    .line 19
    move-result v1

    .line 20
    if-nez v1, :cond_1

    .line 21
    .line 22
    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;->mSelectedItems:Landroidx/collection/ArraySet;

    .line 23
    .line 24
    iget v0, v0, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->incr_id:I

    .line 25
    .line 26
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 27
    .line 28
    .line 29
    move-result-object v0

    .line 30
    invoke-virtual {v1, v0}, Landroidx/collection/ArraySet;->add(Ljava/lang/Object;)Z

    .line 31
    .line 32
    .line 33
    :cond_1
    invoke-virtual {p0, p1}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyItemChanged(I)V

    .line 34
    .line 35
    .line 36
    return-void
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
