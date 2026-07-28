.class public final synthetic Landroidx/fragment/app/FragmentActivity$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/core/util/Consumer;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Landroidx/appcompat/app/AppCompatActivity;


# direct methods
.method public synthetic constructor <init>(Landroidx/appcompat/app/AppCompatActivity;I)V
    .locals 0

    .line 1
    iput p2, p0, Landroidx/fragment/app/FragmentActivity$$ExternalSyntheticLambda1;->$r8$classId:I

    iput-object p1, p0, Landroidx/fragment/app/FragmentActivity$$ExternalSyntheticLambda1;->f$0:Landroidx/appcompat/app/AppCompatActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final accept(Ljava/lang/Object;)V
    .locals 1

    .line 1
    iget v0, p0, Landroidx/fragment/app/FragmentActivity$$ExternalSyntheticLambda1;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    check-cast p1, Landroid/content/Intent;

    .line 7
    .line 8
    iget-object p1, p0, Landroidx/fragment/app/FragmentActivity$$ExternalSyntheticLambda1;->f$0:Landroidx/appcompat/app/AppCompatActivity;

    .line 9
    .line 10
    iget-object p1, p1, Landroidx/fragment/app/FragmentActivity;->mFragments:Landroidx/fragment/app/FragmentController;

    .line 11
    .line 12
    invoke-virtual {p1}, Landroidx/fragment/app/FragmentController;->noteStateNotSaved()V

    .line 13
    .line 14
    .line 15
    return-void

    .line 16
    :pswitch_0
    check-cast p1, Landroid/content/res/Configuration;

    .line 17
    .line 18
    iget-object p1, p0, Landroidx/fragment/app/FragmentActivity$$ExternalSyntheticLambda1;->f$0:Landroidx/appcompat/app/AppCompatActivity;

    .line 19
    .line 20
    iget-object p1, p1, Landroidx/fragment/app/FragmentActivity;->mFragments:Landroidx/fragment/app/FragmentController;

    .line 21
    .line 22
    invoke-virtual {p1}, Landroidx/fragment/app/FragmentController;->noteStateNotSaved()V

    .line 23
    .line 24
    .line 25
    return-void

    .line 26
    nop

    .line 27
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
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
