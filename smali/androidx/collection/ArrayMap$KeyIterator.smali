.class public final Landroidx/collection/ArrayMap$KeyIterator;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/Iterator;
.implements Lkotlin/jvm/internal/markers/KMappedMarker;


# instance fields
.field public final synthetic $r8$classId:I

.field public canRemove:Z

.field public index:I

.field public size:I

.field public final synthetic this$0:Ljava/lang/Object;


# direct methods
.method public constructor <init>(I)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    iput p1, p0, Landroidx/collection/ArrayMap$KeyIterator;->size:I

    return-void
.end method

.method public constructor <init>(Landroidx/collection/ArrayMap;I)V
    .locals 0

    iput p2, p0, Landroidx/collection/ArrayMap$KeyIterator;->$r8$classId:I

    packed-switch p2, :pswitch_data_0

    .line 6
    iput-object p1, p0, Landroidx/collection/ArrayMap$KeyIterator;->this$0:Ljava/lang/Object;

    .line 7
    iget p1, p1, Landroidx/collection/SimpleArrayMap;->size:I

    .line 8
    invoke-direct {p0, p1}, Landroidx/collection/ArrayMap$KeyIterator;-><init>(I)V

    return-void

    .line 9
    :pswitch_0
    iput-object p1, p0, Landroidx/collection/ArrayMap$KeyIterator;->this$0:Ljava/lang/Object;

    .line 10
    iget p1, p1, Landroidx/collection/SimpleArrayMap;->size:I

    .line 11
    invoke-direct {p0, p1}, Landroidx/collection/ArrayMap$KeyIterator;-><init>(I)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public constructor <init>(Landroidx/collection/ArraySet;)V
    .locals 1

    const/4 v0, 0x2

    iput v0, p0, Landroidx/collection/ArrayMap$KeyIterator;->$r8$classId:I

    .line 3
    iput-object p1, p0, Landroidx/collection/ArrayMap$KeyIterator;->this$0:Ljava/lang/Object;

    .line 4
    iget p1, p1, Landroidx/collection/ArraySet;->_size:I

    .line 5
    invoke-direct {p0, p1}, Landroidx/collection/ArrayMap$KeyIterator;-><init>(I)V

    return-void
.end method


# virtual methods
.method public final hasNext()Z
    .locals 2

    .line 1
    iget v0, p0, Landroidx/collection/ArrayMap$KeyIterator;->index:I

    .line 2
    .line 3
    iget v1, p0, Landroidx/collection/ArrayMap$KeyIterator;->size:I

    .line 4
    .line 5
    if-ge v0, v1, :cond_0

    .line 6
    .line 7
    const/4 v0, 0x1

    .line 8
    return v0

    .line 9
    :cond_0
    const/4 v0, 0x0

    .line 10
    return v0
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

.method public final next()Ljava/lang/Object;
    .locals 3

    .line 1
    invoke-virtual {p0}, Landroidx/collection/ArrayMap$KeyIterator;->hasNext()Z

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    if-eqz v0, :cond_0

    .line 6
    .line 7
    iget v0, p0, Landroidx/collection/ArrayMap$KeyIterator;->index:I

    .line 8
    .line 9
    iget v1, p0, Landroidx/collection/ArrayMap$KeyIterator;->$r8$classId:I

    .line 10
    .line 11
    packed-switch v1, :pswitch_data_0

    .line 12
    .line 13
    .line 14
    iget-object v1, p0, Landroidx/collection/ArrayMap$KeyIterator;->this$0:Ljava/lang/Object;

    .line 15
    .line 16
    check-cast v1, Landroidx/collection/ArraySet;

    .line 17
    .line 18
    iget-object v1, v1, Landroidx/collection/ArraySet;->array:[Ljava/lang/Object;

    .line 19
    .line 20
    aget-object v0, v1, v0

    .line 21
    .line 22
    goto :goto_0

    .line 23
    :pswitch_0
    iget-object v1, p0, Landroidx/collection/ArrayMap$KeyIterator;->this$0:Ljava/lang/Object;

    .line 24
    .line 25
    check-cast v1, Landroidx/collection/ArrayMap;

    .line 26
    .line 27
    invoke-virtual {v1, v0}, Landroidx/collection/SimpleArrayMap;->valueAt(I)Ljava/lang/Object;

    .line 28
    .line 29
    .line 30
    move-result-object v0

    .line 31
    goto :goto_0

    .line 32
    :pswitch_1
    iget-object v1, p0, Landroidx/collection/ArrayMap$KeyIterator;->this$0:Ljava/lang/Object;

    .line 33
    .line 34
    check-cast v1, Landroidx/collection/ArrayMap;

    .line 35
    .line 36
    invoke-virtual {v1, v0}, Landroidx/collection/SimpleArrayMap;->keyAt(I)Ljava/lang/Object;

    .line 37
    .line 38
    .line 39
    move-result-object v0

    .line 40
    :goto_0
    iget v1, p0, Landroidx/collection/ArrayMap$KeyIterator;->index:I

    .line 41
    .line 42
    const/4 v2, 0x1

    .line 43
    add-int/2addr v1, v2

    .line 44
    iput v1, p0, Landroidx/collection/ArrayMap$KeyIterator;->index:I

    .line 45
    .line 46
    iput-boolean v2, p0, Landroidx/collection/ArrayMap$KeyIterator;->canRemove:Z

    .line 47
    .line 48
    return-object v0

    .line 49
    :cond_0
    new-instance v0, Ljava/util/NoSuchElementException;

    .line 50
    .line 51
    invoke-direct {v0}, Ljava/util/NoSuchElementException;-><init>()V

    .line 52
    .line 53
    .line 54
    throw v0

    .line 55
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
    .line 56
    .line 57
    .line 58
.end method

.method public final remove()V
    .locals 2

    .line 1
    iget-boolean v0, p0, Landroidx/collection/ArrayMap$KeyIterator;->canRemove:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    iget v0, p0, Landroidx/collection/ArrayMap$KeyIterator;->index:I

    .line 6
    .line 7
    add-int/lit8 v0, v0, -0x1

    .line 8
    .line 9
    iput v0, p0, Landroidx/collection/ArrayMap$KeyIterator;->index:I

    .line 10
    .line 11
    iget v1, p0, Landroidx/collection/ArrayMap$KeyIterator;->$r8$classId:I

    .line 12
    .line 13
    packed-switch v1, :pswitch_data_0

    .line 14
    .line 15
    .line 16
    iget-object v1, p0, Landroidx/collection/ArrayMap$KeyIterator;->this$0:Ljava/lang/Object;

    .line 17
    .line 18
    check-cast v1, Landroidx/collection/ArraySet;

    .line 19
    .line 20
    invoke-virtual {v1, v0}, Landroidx/collection/ArraySet;->removeAt(I)Ljava/lang/Object;

    .line 21
    .line 22
    .line 23
    goto :goto_0

    .line 24
    :pswitch_0
    iget-object v1, p0, Landroidx/collection/ArrayMap$KeyIterator;->this$0:Ljava/lang/Object;

    .line 25
    .line 26
    check-cast v1, Landroidx/collection/ArrayMap;

    .line 27
    .line 28
    invoke-virtual {v1, v0}, Landroidx/collection/SimpleArrayMap;->removeAt(I)Ljava/lang/Object;

    .line 29
    .line 30
    .line 31
    goto :goto_0

    .line 32
    :pswitch_1
    iget-object v1, p0, Landroidx/collection/ArrayMap$KeyIterator;->this$0:Ljava/lang/Object;

    .line 33
    .line 34
    check-cast v1, Landroidx/collection/ArrayMap;

    .line 35
    .line 36
    invoke-virtual {v1, v0}, Landroidx/collection/SimpleArrayMap;->removeAt(I)Ljava/lang/Object;

    .line 37
    .line 38
    .line 39
    :goto_0
    iget v0, p0, Landroidx/collection/ArrayMap$KeyIterator;->size:I

    .line 40
    .line 41
    add-int/lit8 v0, v0, -0x1

    .line 42
    .line 43
    iput v0, p0, Landroidx/collection/ArrayMap$KeyIterator;->size:I

    .line 44
    .line 45
    const/4 v0, 0x0

    .line 46
    iput-boolean v0, p0, Landroidx/collection/ArrayMap$KeyIterator;->canRemove:Z

    .line 47
    .line 48
    return-void

    .line 49
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 50
    .line 51
    const-string v1, "Call next() before removing an element."

    .line 52
    .line 53
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 54
    .line 55
    .line 56
    throw v0

    .line 57
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
    .line 58
.end method
