.class public final Landroidx/cursoradapter/widget/CursorAdapter$MyDataSetObserver;
.super Landroid/database/DataSetObserver;
.source "SourceFile"


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic this$0:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p1, p0, Landroidx/cursoradapter/widget/CursorAdapter$MyDataSetObserver;->$r8$classId:I

    iput-object p2, p0, Landroidx/cursoradapter/widget/CursorAdapter$MyDataSetObserver;->this$0:Ljava/lang/Object;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public final onChanged()V
    .locals 2

    .line 1
    iget v0, p0, Landroidx/cursoradapter/widget/CursorAdapter$MyDataSetObserver;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Landroidx/cursoradapter/widget/CursorAdapter$MyDataSetObserver;->this$0:Ljava/lang/Object;

    .line 7
    .line 8
    check-cast v0, Lcom/google/android/material/tabs/TabLayout;

    .line 9
    .line 10
    invoke-virtual {v0}, Lcom/google/android/material/tabs/TabLayout;->populateFromPagerAdapter()V

    .line 11
    .line 12
    .line 13
    return-void

    .line 14
    :pswitch_0
    iget-object v0, p0, Landroidx/cursoradapter/widget/CursorAdapter$MyDataSetObserver;->this$0:Ljava/lang/Object;

    .line 15
    .line 16
    check-cast v0, Landroidx/appcompat/widget/ListPopupWindow;

    .line 17
    .line 18
    iget-object v1, v0, Landroidx/appcompat/widget/ListPopupWindow;->mPopup:Landroidx/appcompat/widget/AppCompatPopupWindow;

    .line 19
    .line 20
    invoke-virtual {v1}, Landroid/widget/PopupWindow;->isShowing()Z

    .line 21
    .line 22
    .line 23
    move-result v1

    .line 24
    if-eqz v1, :cond_0

    .line 25
    .line 26
    invoke-virtual {v0}, Landroidx/appcompat/widget/ListPopupWindow;->show()V

    .line 27
    .line 28
    .line 29
    :cond_0
    return-void

    .line 30
    :pswitch_1
    iget-object v0, p0, Landroidx/cursoradapter/widget/CursorAdapter$MyDataSetObserver;->this$0:Ljava/lang/Object;

    .line 31
    .line 32
    check-cast v0, Landroidx/appcompat/widget/SuggestionsAdapter;

    .line 33
    .line 34
    const/4 v1, 0x1

    .line 35
    iput-boolean v1, v0, Landroidx/cursoradapter/widget/CursorAdapter;->mDataValid:Z

    .line 36
    .line 37
    invoke-virtual {v0}, Landroidx/appcompat/widget/SuggestionsAdapter;->notifyDataSetChanged()V

    .line 38
    .line 39
    .line 40
    return-void

    .line 41
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
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

.method public final onInvalidated()V
    .locals 2

    .line 1
    iget v0, p0, Landroidx/cursoradapter/widget/CursorAdapter$MyDataSetObserver;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Landroidx/cursoradapter/widget/CursorAdapter$MyDataSetObserver;->this$0:Ljava/lang/Object;

    .line 7
    .line 8
    check-cast v0, Lcom/google/android/material/tabs/TabLayout;

    .line 9
    .line 10
    invoke-virtual {v0}, Lcom/google/android/material/tabs/TabLayout;->populateFromPagerAdapter()V

    .line 11
    .line 12
    .line 13
    return-void

    .line 14
    :pswitch_0
    iget-object v0, p0, Landroidx/cursoradapter/widget/CursorAdapter$MyDataSetObserver;->this$0:Ljava/lang/Object;

    .line 15
    .line 16
    check-cast v0, Landroidx/appcompat/widget/ListPopupWindow;

    .line 17
    .line 18
    invoke-virtual {v0}, Landroidx/appcompat/widget/ListPopupWindow;->dismiss()V

    .line 19
    .line 20
    .line 21
    return-void

    .line 22
    :pswitch_1
    iget-object v0, p0, Landroidx/cursoradapter/widget/CursorAdapter$MyDataSetObserver;->this$0:Ljava/lang/Object;

    .line 23
    .line 24
    check-cast v0, Landroidx/appcompat/widget/SuggestionsAdapter;

    .line 25
    .line 26
    const/4 v1, 0x0

    .line 27
    iput-boolean v1, v0, Landroidx/cursoradapter/widget/CursorAdapter;->mDataValid:Z

    .line 28
    .line 29
    invoke-virtual {v0}, Landroidx/appcompat/widget/SuggestionsAdapter;->notifyDataSetInvalidated()V

    .line 30
    .line 31
    .line 32
    return-void

    .line 33
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
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
