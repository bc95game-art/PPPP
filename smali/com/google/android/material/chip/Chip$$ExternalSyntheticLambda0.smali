.class public final synthetic Lcom/google/android/material/chip/Chip$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/google/android/material/chip/Chip$$ExternalSyntheticLambda0;->$r8$classId:I

    iput-object p2, p0, Lcom/google/android/material/chip/Chip$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 3

    .line 1
    iget v0, p0, Lcom/google/android/material/chip/Chip$$ExternalSyntheticLambda0;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lcom/google/android/material/chip/Chip$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 7
    .line 8
    check-cast v0, Lcom/emanuelef/remote_capture/views/AppsListView;

    .line 9
    .line 10
    invoke-static {v0, p1, p2}, Lcom/emanuelef/remote_capture/views/AppSelectDialog;->$r8$lambda$jwSGhg1cf43-q7cgUP0CJ8FrGFY(Lcom/emanuelef/remote_capture/views/AppsListView;Landroid/widget/CompoundButton;Z)V

    .line 11
    .line 12
    .line 13
    return-void

    .line 14
    :pswitch_0
    iget-object v0, p0, Lcom/google/android/material/chip/Chip$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 15
    .line 16
    check-cast v0, Lcom/emanuelef/remote_capture/fragments/prefs/PortMapFragment;

    .line 17
    .line 18
    invoke-static {v0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/prefs/PortMapFragment;->$r8$lambda$5lzyg0lluvL2KnZFm5Wvin6o-lM(Lcom/emanuelef/remote_capture/fragments/prefs/PortMapFragment;Landroid/widget/CompoundButton;Z)V

    .line 19
    .line 20
    .line 21
    return-void

    .line 22
    :pswitch_1
    iget-object v0, p0, Lcom/google/android/material/chip/Chip$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 23
    .line 24
    check-cast v0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus;

    .line 25
    .line 26
    invoke-static {v0, p1, p2}, Lcom/emanuelef/remote_capture/fragments/FirewallStatus;->$r8$lambda$xTny7K7j5qDKCmeY-hTUfUrzPno(Lcom/emanuelef/remote_capture/fragments/FirewallStatus;Landroid/widget/CompoundButton;Z)V

    .line 27
    .line 28
    .line 29
    return-void

    .line 30
    :pswitch_2
    iget-object v0, p0, Lcom/google/android/material/chip/Chip$$ExternalSyntheticLambda0;->f$0:Ljava/lang/Object;

    .line 31
    .line 32
    check-cast v0, Lcom/google/android/material/chip/Chip;

    .line 33
    .line 34
    iget-object v1, v0, Lcom/google/android/material/chip/Chip;->onCheckedChangeListenerInternal:Lcom/google/android/material/internal/MaterialCheckable$OnCheckedChangeListener;

    .line 35
    .line 36
    if-eqz v1, :cond_1

    .line 37
    .line 38
    check-cast v1, Lkotlinx/coroutines/flow/ReadonlyStateFlow;

    .line 39
    .line 40
    iget-object v1, v1, Lkotlinx/coroutines/flow/ReadonlyStateFlow;->$$delegate_0:Ljava/lang/Object;

    .line 41
    .line 42
    check-cast v1, Lcom/google/android/material/internal/CheckableGroup;

    .line 43
    .line 44
    if-eqz p2, :cond_0

    .line 45
    .line 46
    invoke-virtual {v1, v0}, Lcom/google/android/material/internal/CheckableGroup;->checkInternal(Lcom/google/android/material/internal/MaterialCheckable;)Z

    .line 47
    .line 48
    .line 49
    move-result v2

    .line 50
    if-eqz v2, :cond_1

    .line 51
    .line 52
    goto :goto_0

    .line 53
    :cond_0
    iget-boolean v2, v1, Lcom/google/android/material/internal/CheckableGroup;->selectionRequired:Z

    .line 54
    .line 55
    invoke-virtual {v1, v0, v2}, Lcom/google/android/material/internal/CheckableGroup;->uncheckInternal(Lcom/google/android/material/internal/MaterialCheckable;Z)Z

    .line 56
    .line 57
    .line 58
    move-result v2

    .line 59
    if-eqz v2, :cond_1

    .line 60
    .line 61
    :goto_0
    invoke-virtual {v1}, Lcom/google/android/material/internal/CheckableGroup;->onCheckedStateChanged()V

    .line 62
    .line 63
    .line 64
    :cond_1
    iget-object v0, v0, Lcom/google/android/material/chip/Chip;->onCheckedChangeListener:Landroid/widget/CompoundButton$OnCheckedChangeListener;

    .line 65
    .line 66
    if-eqz v0, :cond_2

    .line 67
    .line 68
    invoke-interface {v0, p1, p2}, Landroid/widget/CompoundButton$OnCheckedChangeListener;->onCheckedChanged(Landroid/widget/CompoundButton;Z)V

    .line 69
    .line 70
    .line 71
    :cond_2
    return-void

    .line 72
    nop

    .line 73
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
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
