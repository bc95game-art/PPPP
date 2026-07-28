.class public final Landroidx/viewpager2/widget/ViewPager2$PageAwareAccessibilityProvider$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/core/view/accessibility/AccessibilityViewCommand;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic this$1:Landroidx/emoji2/text/MetadataRepo;


# direct methods
.method public synthetic constructor <init>(Landroidx/emoji2/text/MetadataRepo;I)V
    .locals 0

    .line 1
    iput p2, p0, Landroidx/viewpager2/widget/ViewPager2$PageAwareAccessibilityProvider$1;->$r8$classId:I

    iput-object p1, p0, Landroidx/viewpager2/widget/ViewPager2$PageAwareAccessibilityProvider$1;->this$1:Landroidx/emoji2/text/MetadataRepo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final perform(Landroid/view/View;)Z
    .locals 3

    .line 1
    iget v0, p0, Landroidx/viewpager2/widget/ViewPager2$PageAwareAccessibilityProvider$1;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    check-cast p1, Landroidx/viewpager2/widget/ViewPager2;

    .line 7
    .line 8
    invoke-virtual {p1}, Landroidx/viewpager2/widget/ViewPager2;->getCurrentItem()I

    .line 9
    .line 10
    .line 11
    move-result p1

    .line 12
    const/4 v0, 0x1

    .line 13
    sub-int/2addr p1, v0

    .line 14
    iget-object v1, p0, Landroidx/viewpager2/widget/ViewPager2$PageAwareAccessibilityProvider$1;->this$1:Landroidx/emoji2/text/MetadataRepo;

    .line 15
    .line 16
    iget-object v1, v1, Landroidx/emoji2/text/MetadataRepo;->mTypeface:Ljava/lang/Object;

    .line 17
    .line 18
    check-cast v1, Landroidx/viewpager2/widget/ViewPager2;

    .line 19
    .line 20
    iget-boolean v2, v1, Landroidx/viewpager2/widget/ViewPager2;->mUserInputEnabled:Z

    .line 21
    .line 22
    if-eqz v2, :cond_0

    .line 23
    .line 24
    invoke-virtual {v1, p1, v0}, Landroidx/viewpager2/widget/ViewPager2;->setCurrentItemInternal(IZ)V

    .line 25
    .line 26
    .line 27
    :cond_0
    return v0

    .line 28
    :pswitch_0
    check-cast p1, Landroidx/viewpager2/widget/ViewPager2;

    .line 29
    .line 30
    invoke-virtual {p1}, Landroidx/viewpager2/widget/ViewPager2;->getCurrentItem()I

    .line 31
    .line 32
    .line 33
    move-result p1

    .line 34
    const/4 v0, 0x1

    .line 35
    add-int/2addr p1, v0

    .line 36
    iget-object v1, p0, Landroidx/viewpager2/widget/ViewPager2$PageAwareAccessibilityProvider$1;->this$1:Landroidx/emoji2/text/MetadataRepo;

    .line 37
    .line 38
    iget-object v1, v1, Landroidx/emoji2/text/MetadataRepo;->mTypeface:Ljava/lang/Object;

    .line 39
    .line 40
    check-cast v1, Landroidx/viewpager2/widget/ViewPager2;

    .line 41
    .line 42
    iget-boolean v2, v1, Landroidx/viewpager2/widget/ViewPager2;->mUserInputEnabled:Z

    .line 43
    .line 44
    if-eqz v2, :cond_1

    .line 45
    .line 46
    invoke-virtual {v1, p1, v0}, Landroidx/viewpager2/widget/ViewPager2;->setCurrentItemInternal(IZ)V

    .line 47
    .line 48
    .line 49
    :cond_1
    return v0

    .line 50
    nop

    .line 51
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
.end method
