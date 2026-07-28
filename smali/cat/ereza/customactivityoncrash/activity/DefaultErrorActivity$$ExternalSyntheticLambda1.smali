.class public final synthetic Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic f$0:Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity;


# direct methods
.method public synthetic constructor <init>(Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity;)V
    .locals 1

    .line 1
    const/4 v0, 0x1

    iput v0, p0, Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity$$ExternalSyntheticLambda1;->$r8$classId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity$$ExternalSyntheticLambda1;->f$0:Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity;

    return-void
.end method

.method public synthetic constructor <init>(Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity;Lcat/ereza/customactivityoncrash/config/CaocConfig;)V
    .locals 0

    .line 2
    const/4 p2, 0x0

    iput p2, p0, Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity$$ExternalSyntheticLambda1;->$r8$classId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity$$ExternalSyntheticLambda1;->f$0:Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity;

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 3

    .line 1
    iget p1, p0, Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity$$ExternalSyntheticLambda1;->$r8$classId:I

    .line 2
    .line 3
    iget-object v0, p0, Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity$$ExternalSyntheticLambda1;->f$0:Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity;

    .line 4
    .line 5
    packed-switch p1, :pswitch_data_0

    .line 6
    .line 7
    .line 8
    sget p1, Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity;->$r8$clinit:I

    .line 9
    .line 10
    new-instance p1, Lcom/android/billingclient/api/zzbv;

    .line 11
    .line 12
    invoke-direct {p1, v0}, Lcom/android/billingclient/api/zzbv;-><init>(Landroid/content/Context;)V

    .line 13
    .line 14
    .line 15
    const v1, 0x7f1400bb

    .line 16
    .line 17
    .line 18
    invoke-virtual {p1, v1}, Lcom/android/billingclient/api/zzbv;->setTitle(I)V

    .line 19
    .line 20
    .line 21
    invoke-virtual {v0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    .line 22
    .line 23
    .line 24
    move-result-object v1

    .line 25
    invoke-static {v0, v1}, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->getAllErrorDetailsFromIntent(Landroid/content/Context;Landroid/content/Intent;)Ljava/lang/String;

    .line 26
    .line 27
    .line 28
    move-result-object v1

    .line 29
    iget-object v2, p1, Lcom/android/billingclient/api/zzbv;->zza:Ljava/lang/Object;

    .line 30
    .line 31
    check-cast v2, Landroidx/appcompat/app/AlertController$AlertParams;

    .line 32
    .line 33
    iput-object v1, v2, Landroidx/appcompat/app/AlertController$AlertParams;->mMessage:Ljava/lang/CharSequence;

    .line 34
    .line 35
    const v1, 0x7f1400b8

    .line 36
    .line 37
    .line 38
    const/4 v2, 0x0

    .line 39
    invoke-virtual {p1, v1, v2}, Lcom/android/billingclient/api/zzbv;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)V

    .line 40
    .line 41
    .line 42
    new-instance v1, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda0;

    .line 43
    .line 44
    const/4 v2, 0x1

    .line 45
    invoke-direct {v1, v2, v0}, Lcom/emanuelef/remote_capture/fragments/AppsFragment$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 46
    .line 47
    .line 48
    const v2, 0x7f1400ba

    .line 49
    .line 50
    .line 51
    invoke-virtual {p1, v2, v1}, Lcom/android/billingclient/api/zzbv;->setNeutralButton(ILandroid/content/DialogInterface$OnClickListener;)V

    .line 52
    .line 53
    .line 54
    invoke-virtual {p1}, Lcom/android/billingclient/api/zzbv;->show()Landroidx/appcompat/app/AlertDialog;

    .line 55
    .line 56
    .line 57
    move-result-object p1

    .line 58
    const v1, 0x102000b

    .line 59
    .line 60
    .line 61
    invoke-virtual {p1, v1}, Landroidx/appcompat/app/AlertDialog;->findViewById(I)Landroid/view/View;

    .line 62
    .line 63
    .line 64
    move-result-object p1

    .line 65
    check-cast p1, Landroid/widget/TextView;

    .line 66
    .line 67
    if-eqz p1, :cond_0

    .line 68
    .line 69
    invoke-virtual {v0}, Landroidx/appcompat/app/AppCompatActivity;->getResources()Landroid/content/res/Resources;

    .line 70
    .line 71
    .line 72
    move-result-object v0

    .line 73
    const v1, 0x7f070074

    .line 74
    .line 75
    .line 76
    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimension(I)F

    .line 77
    .line 78
    .line 79
    move-result v0

    .line 80
    const/4 v1, 0x0

    .line 81
    invoke-virtual {p1, v1, v0}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 82
    .line 83
    .line 84
    :cond_0
    return-void

    .line 85
    :pswitch_0
    sget p1, Lcat/ereza/customactivityoncrash/activity/DefaultErrorActivity;->$r8$clinit:I

    .line 86
    .line 87
    sget-object p1, Lcat/ereza/customactivityoncrash/CustomActivityOnCrash;->application:Landroid/app/Application;

    .line 88
    .line 89
    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 90
    .line 91
    .line 92
    invoke-static {}, Landroid/os/Process;->myPid()I

    .line 93
    .line 94
    .line 95
    move-result p1

    .line 96
    invoke-static {p1}, Landroid/os/Process;->killProcess(I)V

    .line 97
    .line 98
    .line 99
    const/16 p1, 0xa

    .line 100
    .line 101
    invoke-static {p1}, Ljava/lang/System;->exit(I)V

    .line 102
    .line 103
    .line 104
    return-void

    .line 105
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
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
