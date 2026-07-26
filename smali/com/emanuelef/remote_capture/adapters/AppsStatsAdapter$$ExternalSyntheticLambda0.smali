.class public final synthetic Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/util/Comparator;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda0;->$r8$classId:I

    iput-object p2, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 3

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda0;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 7
    .line 8
    check-cast v0, Lcom/google/android/material/button/MaterialButtonToggleGroup;

    .line 9
    .line 10
    check-cast p1, Lcom/google/android/material/button/MaterialButton;

    .line 11
    .line 12
    check-cast p2, Lcom/google/android/material/button/MaterialButton;

    .line 13
    .line 14
    iget-boolean v1, p1, Lcom/google/android/material/button/MaterialButton;->checked:Z

    .line 15
    .line 16
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 17
    .line 18
    .line 19
    move-result-object v1

    .line 20
    iget-boolean v2, p2, Lcom/google/android/material/button/MaterialButton;->checked:Z

    .line 21
    .line 22
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 23
    .line 24
    .line 25
    move-result-object v2

    .line 26
    invoke-virtual {v1, v2}, Ljava/lang/Boolean;->compareTo(Ljava/lang/Boolean;)I

    .line 27
    .line 28
    .line 29
    move-result v1

    .line 30
    if-eqz v1, :cond_0

    .line 31
    .line 32
    goto :goto_0

    .line 33
    :cond_0
    invoke-virtual {p1}, Landroid/view/View;->isPressed()Z

    .line 34
    .line 35
    .line 36
    move-result v1

    .line 37
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 38
    .line 39
    .line 40
    move-result-object v1

    .line 41
    invoke-virtual {p2}, Landroid/view/View;->isPressed()Z

    .line 42
    .line 43
    .line 44
    move-result v2

    .line 45
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 46
    .line 47
    .line 48
    move-result-object v2

    .line 49
    invoke-virtual {v1, v2}, Ljava/lang/Boolean;->compareTo(Ljava/lang/Boolean;)I

    .line 50
    .line 51
    .line 52
    move-result v1

    .line 53
    if-eqz v1, :cond_1

    .line 54
    .line 55
    goto :goto_0

    .line 56
    :cond_1
    invoke-virtual {v0, p1}, Landroid/view/ViewGroup;->indexOfChild(Landroid/view/View;)I

    .line 57
    .line 58
    .line 59
    move-result p1

    .line 60
    invoke-virtual {v0, p2}, Landroid/view/ViewGroup;->indexOfChild(Landroid/view/View;)I

    .line 61
    .line 62
    .line 63
    move-result p2

    .line 64
    invoke-static {p1, p2}, Ljava/lang/Integer;->compare(II)I

    .line 65
    .line 66
    .line 67
    move-result v1

    .line 68
    :goto_0
    return v1

    .line 69
    :pswitch_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 70
    .line 71
    check-cast v0, Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter;

    .line 72
    .line 73
    check-cast p1, Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 74
    .line 75
    check-cast p2, Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 76
    .line 77
    invoke-static {v0, p1, p2}, Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter;->$r8$lambda$HhOcOiE6NsYzRf1HJQJOJpCwoZU(Lcom/emanuelef/remote_capture/adapters/AppsTogglesAdapter;Lcom/emanuelef/remote_capture/model/AppDescriptor;Lcom/emanuelef/remote_capture/model/AppDescriptor;)I

    .line 78
    .line 79
    .line 80
    move-result p1

    .line 81
    return p1

    .line 82
    :pswitch_1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 83
    .line 84
    check-cast v0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;

    .line 85
    .line 86
    check-cast p1, Lcom/emanuelef/remote_capture/model/AppStats;

    .line 87
    .line 88
    check-cast p2, Lcom/emanuelef/remote_capture/model/AppStats;

    .line 89
    .line 90
    invoke-static {v0, p1, p2}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->$r8$lambda$OM70x6gm8s6_s5Qt11M6fxBge_U(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;Lcom/emanuelef/remote_capture/model/AppStats;Lcom/emanuelef/remote_capture/model/AppStats;)I

    .line 91
    .line 92
    .line 93
    move-result p1

    .line 94
    return p1

    .line 95
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
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
