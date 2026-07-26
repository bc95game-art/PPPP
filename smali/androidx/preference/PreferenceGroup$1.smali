.class public final Landroidx/preference/PreferenceGroup$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic this$0:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p1, p0, Landroidx/preference/PreferenceGroup$1;->$r8$classId:I

    iput-object p2, p0, Landroidx/preference/PreferenceGroup$1;->this$0:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    .line 1
    iget v0, p0, Landroidx/preference/PreferenceGroup$1;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Landroidx/preference/PreferenceGroup$1;->this$0:Ljava/lang/Object;

    .line 7
    .line 8
    check-cast v0, Landroidx/preference/PreferenceGroupAdapter;

    .line 9
    .line 10
    invoke-virtual {v0}, Landroidx/preference/PreferenceGroupAdapter;->updatePreferences()V

    .line 11
    .line 12
    .line 13
    return-void

    .line 14
    :pswitch_0
    iget-object v0, p0, Landroidx/preference/PreferenceGroup$1;->this$0:Ljava/lang/Object;

    .line 15
    .line 16
    check-cast v0, Landroidx/preference/EditTextPreferenceDialogFragmentCompat;

    .line 17
    .line 18
    invoke-virtual {v0}, Landroidx/preference/EditTextPreferenceDialogFragmentCompat;->scheduleShowSoftInputInner()V

    .line 19
    .line 20
    .line 21
    return-void

    .line 22
    :pswitch_1
    iget-object v0, p0, Landroidx/preference/PreferenceGroup$1;->this$0:Ljava/lang/Object;

    .line 23
    .line 24
    check-cast v0, Landroidx/preference/PreferenceFragmentCompat;

    .line 25
    .line 26
    iget-object v0, v0, Landroidx/preference/PreferenceFragmentCompat;->mList:Landroidx/recyclerview/widget/RecyclerView;

    .line 27
    .line 28
    invoke-virtual {v0, v0}, Landroid/view/ViewGroup;->focusableViewAvailable(Landroid/view/View;)V

    .line 29
    .line 30
    .line 31
    return-void

    .line 32
    :pswitch_2
    monitor-enter p0

    .line 33
    :try_start_0
    iget-object v0, p0, Landroidx/preference/PreferenceGroup$1;->this$0:Ljava/lang/Object;

    .line 34
    .line 35
    check-cast v0, Landroidx/preference/PreferenceGroup;

    .line 36
    .line 37
    iget-object v0, v0, Landroidx/preference/PreferenceGroup;->mIdRecycleCache:Landroidx/collection/SimpleArrayMap;

    .line 38
    .line 39
    invoke-virtual {v0}, Landroidx/collection/SimpleArrayMap;->clear()V

    .line 40
    .line 41
    .line 42
    monitor-exit p0

    .line 43
    return-void

    .line 44
    :catchall_0
    move-exception v0

    .line 45
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 46
    throw v0

    .line 47
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
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
