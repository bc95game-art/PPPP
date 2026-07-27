.class public final synthetic Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda2;->$r8$classId:I

    iput-object p2, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 3

    .line 1
    iget v0, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda2;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    .line 7
    .line 8
    check-cast p1, Lcom/google/android/material/textfield/PasswordToggleEndIconDelegate;

    .line 9
    .line 10
    iget-object v0, p1, Lcom/google/android/material/textfield/PasswordToggleEndIconDelegate;->editText:Landroid/widget/EditText;

    .line 11
    .line 12
    if-nez v0, :cond_0

    .line 13
    .line 14
    goto :goto_1

    .line 15
    :cond_0
    invoke-virtual {v0}, Landroid/widget/TextView;->getSelectionEnd()I

    .line 16
    .line 17
    .line 18
    move-result v0

    .line 19
    iget-object v1, p1, Lcom/google/android/material/textfield/PasswordToggleEndIconDelegate;->editText:Landroid/widget/EditText;

    .line 20
    .line 21
    if-eqz v1, :cond_1

    .line 22
    .line 23
    invoke-virtual {v1}, Landroid/widget/TextView;->getTransformationMethod()Landroid/text/method/TransformationMethod;

    .line 24
    .line 25
    .line 26
    move-result-object v1

    .line 27
    instance-of v1, v1, Landroid/text/method/PasswordTransformationMethod;

    .line 28
    .line 29
    if-eqz v1, :cond_1

    .line 30
    .line 31
    iget-object v1, p1, Lcom/google/android/material/textfield/PasswordToggleEndIconDelegate;->editText:Landroid/widget/EditText;

    .line 32
    .line 33
    const/4 v2, 0x0

    .line 34
    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTransformationMethod(Landroid/text/method/TransformationMethod;)V

    .line 35
    .line 36
    .line 37
    goto :goto_0

    .line 38
    :cond_1
    iget-object v1, p1, Lcom/google/android/material/textfield/PasswordToggleEndIconDelegate;->editText:Landroid/widget/EditText;

    .line 39
    .line 40
    invoke-static {}, Landroid/text/method/PasswordTransformationMethod;->getInstance()Landroid/text/method/PasswordTransformationMethod;

    .line 41
    .line 42
    .line 43
    move-result-object v2

    .line 44
    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTransformationMethod(Landroid/text/method/TransformationMethod;)V

    .line 45
    .line 46
    .line 47
    :goto_0
    if-ltz v0, :cond_2

    .line 48
    .line 49
    iget-object v1, p1, Lcom/google/android/material/textfield/PasswordToggleEndIconDelegate;->editText:Landroid/widget/EditText;

    .line 50
    .line 51
    invoke-virtual {v1, v0}, Landroid/widget/EditText;->setSelection(I)V

    .line 52
    .line 53
    .line 54
    :cond_2
    invoke-virtual {p1}, Lcom/google/android/material/textfield/EndIconDelegate;->refreshIconState()V

    .line 55
    .line 56
    .line 57
    :goto_1
    return-void

    .line 58
    :pswitch_0
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    .line 59
    .line 60
    check-cast p1, Lcom/google/android/material/textfield/DropdownMenuEndIconDelegate;

    .line 61
    .line 62
    invoke-virtual {p1}, Lcom/google/android/material/textfield/DropdownMenuEndIconDelegate;->showHideDropdown()V

    .line 63
    .line 64
    .line 65
    return-void

    .line 66
    :pswitch_1
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    .line 67
    .line 68
    check-cast p1, Lcom/google/android/material/textfield/ClearTextEndIconDelegate;

    .line 69
    .line 70
    iget-object v0, p1, Lcom/google/android/material/textfield/ClearTextEndIconDelegate;->editText:Landroid/widget/EditText;

    .line 71
    .line 72
    if-nez v0, :cond_3

    .line 73
    .line 74
    goto :goto_2

    .line 75
    :cond_3
    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    .line 76
    .line 77
    .line 78
    move-result-object v0

    .line 79
    if-eqz v0, :cond_4

    .line 80
    .line 81
    invoke-interface {v0}, Landroid/text/Editable;->clear()V

    .line 82
    .line 83
    .line 84
    :cond_4
    invoke-virtual {p1}, Lcom/google/android/material/textfield/EndIconDelegate;->refreshIconState()V

    .line 85
    .line 86
    .line 87
    :goto_2
    return-void

    .line 88
    :pswitch_2
    iget-object p1, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    .line 89
    .line 90
    check-cast p1, Lcom/google/android/material/datepicker/MaterialDatePicker;

    .line 91
    .line 92
    invoke-virtual {p1}, Lcom/google/android/material/datepicker/MaterialDatePicker;->getDateSelector()V

    .line 93
    .line 94
    .line 95
    const/4 p1, 0x0

    .line 96
    throw p1

    .line 97
    :pswitch_3
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    .line 98
    .line 99
    check-cast v0, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallAddon;

    .line 100
    .line 101
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallAddon;->$r8$lambda$Sb4HtmZ7POhPI8maqhN3C8yOPcg(Lcom/emanuelef/remote_capture/fragments/mitmwizard/InstallAddon;Landroid/view/View;)V

    .line 102
    .line 103
    .line 104
    return-void

    .line 105
    :pswitch_4
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    .line 106
    .line 107
    check-cast v0, Lcom/emanuelef/remote_capture/fragments/MalwareStatusFragment;

    .line 108
    .line 109
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/MalwareStatusFragment;->$r8$lambda$Vhn2sIEMBquwtT7igeU4IgEpOc4(Lcom/emanuelef/remote_capture/fragments/MalwareStatusFragment;Landroid/view/View;)V

    .line 110
    .line 111
    .line 112
    return-void

    .line 113
    :pswitch_5
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    .line 114
    .line 115
    check-cast v0, Lcom/emanuelef/remote_capture/fragments/HttpPayloadFragment;

    .line 116
    .line 117
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/HttpPayloadFragment;->$r8$lambda$QIox5AhEHn7I00CNYmW_JUKiK7s(Lcom/emanuelef/remote_capture/fragments/HttpPayloadFragment;Landroid/view/View;)V

    .line 118
    .line 119
    .line 120
    return-void

    .line 121
    :pswitch_6
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    .line 122
    .line 123
    check-cast v0, Lcom/emanuelef/remote_capture/fragments/FirewallStatus;

    .line 124
    .line 125
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/FirewallStatus;->$r8$lambda$b12on10kEllknLH6H_o1hplcRyI(Lcom/emanuelef/remote_capture/fragments/FirewallStatus;Landroid/view/View;)V

    .line 126
    .line 127
    .line 128
    return-void

    .line 129
    :pswitch_7
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    .line 130
    .line 131
    check-cast v0, Lcom/emanuelef/remote_capture/fragments/ConnectionOverview;

    .line 132
    .line 133
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionOverview;->$r8$lambda$0cWAoz-AxFo4VYcWCIFy3tENVvI(Lcom/emanuelef/remote_capture/fragments/ConnectionOverview;Landroid/view/View;)V

    .line 134
    .line 135
    .line 136
    return-void

    .line 137
    :pswitch_8
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    .line 138
    .line 139
    check-cast v0, Lcom/emanuelef/remote_capture/activities/MainActivity;

    .line 140
    .line 141
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/activities/MainActivity;->$r8$lambda$UjODYE25BHMY7-1CMW_PrU5uS9A(Lcom/emanuelef/remote_capture/activities/MainActivity;Landroid/view/View;)V

    .line 142
    .line 143
    .line 144
    return-void

    .line 145
    :pswitch_9
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    .line 146
    .line 147
    check-cast v0, Lcom/emanuelef/remote_capture/activities/EditFilterActivity;

    .line 148
    .line 149
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/activities/EditFilterActivity;->$r8$lambda$ruXj0T2QtTCDv_tY9zHDnRBXXjE(Lcom/emanuelef/remote_capture/activities/EditFilterActivity;Landroid/view/View;)V

    .line 150
    .line 151
    .line 152
    return-void

    .line 153
    :pswitch_a
    iget-object v0, p0, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda2;->f$0:Ljava/lang/Object;

    .line 154
    .line 155
    check-cast v0, Lcom/emanuelef/remote_capture/fragments/AppsFragment;

    .line 156
    .line 157
    invoke-static {v0, p1}, Lcom/emanuelef/remote_capture/fragments/AppsFragment;->$r8$lambda$1qwaqnl44UkeyO7CZFZJ82vEe5U(Lcom/emanuelef/remote_capture/fragments/AppsFragment;Landroid/view/View;)V

    .line 158
    .line 159
    .line 160
    return-void

    .line 161
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
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
