.class public Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ViewHolder"
.end annotation


# instance fields
.field appName:Landroid/widget/TextView;

.field blacklistedInd:Landroid/widget/ImageView;

.field blockedInd:Landroid/widget/ImageView;

.field decryptionInd:Landroid/widget/ImageView;

.field icon:Landroid/widget/ImageView;

.field jsInjectorInd:Landroid/widget/ImageView;

.field l7proto:Landroid/widget/TextView;

.field lastSeen:Landroid/widget/TextView;

.field final mProtoAndPort:Ljava/lang/String;

.field redirectedInd:Landroid/widget/ImageView;

.field remote:Landroid/widget/TextView;

.field statusInd:Landroid/widget/TextView;

.field traffic:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/view/View;)V
    .locals 1

    .line 1
    invoke-direct {p0, p1}, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 2
    .line 3
    .line 4
    const v0, 0x7f0a0199

    .line 5
    .line 6
    .line 7
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    check-cast v0, Landroid/widget/ImageView;

    .line 12
    .line 13
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->icon:Landroid/widget/ImageView;

    .line 14
    .line 15
    const v0, 0x7f0a02aa

    .line 16
    .line 17
    .line 18
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 19
    .line 20
    .line 21
    move-result-object v0

    .line 22
    check-cast v0, Landroid/widget/TextView;

    .line 23
    .line 24
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->remote:Landroid/widget/TextView;

    .line 25
    .line 26
    const v0, 0x7f0a01c1

    .line 27
    .line 28
    .line 29
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 30
    .line 31
    .line 32
    move-result-object v0

    .line 33
    check-cast v0, Landroid/widget/TextView;

    .line 34
    .line 35
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->l7proto:Landroid/widget/TextView;

    .line 36
    .line 37
    const v0, 0x7f0a0364

    .line 38
    .line 39
    .line 40
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 41
    .line 42
    .line 43
    move-result-object v0

    .line 44
    check-cast v0, Landroid/widget/TextView;

    .line 45
    .line 46
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->traffic:Landroid/widget/TextView;

    .line 47
    .line 48
    const v0, 0x7f0a0320

    .line 49
    .line 50
    .line 51
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 52
    .line 53
    .line 54
    move-result-object v0

    .line 55
    check-cast v0, Landroid/widget/TextView;

    .line 56
    .line 57
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->statusInd:Landroid/widget/TextView;

    .line 58
    .line 59
    const v0, 0x7f0a0109

    .line 60
    .line 61
    .line 62
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 63
    .line 64
    .line 65
    move-result-object v0

    .line 66
    check-cast v0, Landroid/widget/ImageView;

    .line 67
    .line 68
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->decryptionInd:Landroid/widget/ImageView;

    .line 69
    .line 70
    const v0, 0x7f0a0076

    .line 71
    .line 72
    .line 73
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 74
    .line 75
    .line 76
    move-result-object v0

    .line 77
    check-cast v0, Landroid/widget/TextView;

    .line 78
    .line 79
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->appName:Landroid/widget/TextView;

    .line 80
    .line 81
    const v0, 0x7f0a01c5

    .line 82
    .line 83
    .line 84
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 85
    .line 86
    .line 87
    move-result-object v0

    .line 88
    check-cast v0, Landroid/widget/TextView;

    .line 89
    .line 90
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->lastSeen:Landroid/widget/TextView;

    .line 91
    .line 92
    const v0, 0x7f0a01be

    .line 93
    .line 94
    .line 95
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 96
    .line 97
    .line 98
    move-result-object v0

    .line 99
    check-cast v0, Landroid/widget/ImageView;

    .line 100
    .line 101
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->jsInjectorInd:Landroid/widget/ImageView;

    .line 102
    .line 103
    const v0, 0x7f0a0093

    .line 104
    .line 105
    .line 106
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 107
    .line 108
    .line 109
    move-result-object v0

    .line 110
    check-cast v0, Landroid/widget/ImageView;

    .line 111
    .line 112
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->blacklistedInd:Landroid/widget/ImageView;

    .line 113
    .line 114
    const v0, 0x7f0a009d

    .line 115
    .line 116
    .line 117
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 118
    .line 119
    .line 120
    move-result-object v0

    .line 121
    check-cast v0, Landroid/widget/ImageView;

    .line 122
    .line 123
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->blockedInd:Landroid/widget/ImageView;

    .line 124
    .line 125
    const v0, 0x7f0a02a8

    .line 126
    .line 127
    .line 128
    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 129
    .line 130
    .line 131
    move-result-object v0

    .line 132
    check-cast v0, Landroid/widget/ImageView;

    .line 133
    .line 134
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->redirectedInd:Landroid/widget/ImageView;

    .line 135
    .line 136
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    .line 137
    .line 138
    .line 139
    move-result-object p1

    .line 140
    const v0, 0x7f140253

    .line 141
    .line 142
    .line 143
    invoke-virtual {p1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    .line 144
    .line 145
    .line 146
    move-result-object p1

    .line 147
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->mProtoAndPort:Ljava/lang/String;

    .line 148
    .line 149
    return-void
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


# virtual methods
.method public bindConn(Landroid/content/Context;Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;Lcom/emanuelef/remote_capture/AppsResolver;Landroid/graphics/drawable/Drawable;)V
    .locals 6

    .line 1
    iget v0, p2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-virtual {p3, v0, v1}, Lcom/emanuelef/remote_capture/AppsResolver;->getAppByUid(II)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 5
    .line 6
    .line 7
    move-result-object p3

    .line 8
    if-eqz p3, :cond_0

    .line 9
    .line 10
    invoke-virtual {p3}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getIcon()Landroid/graphics/drawable/Drawable;

    .line 11
    .line 12
    .line 13
    move-result-object v0

    .line 14
    if-eqz v0, :cond_0

    .line 15
    .line 16
    invoke-virtual {p3}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getIcon()Landroid/graphics/drawable/Drawable;

    .line 17
    .line 18
    .line 19
    move-result-object p4

    .line 20
    :cond_0
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->icon:Landroid/widget/ImageView;

    .line 21
    .line 22
    invoke-virtual {v0, p4}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 23
    .line 24
    .line 25
    iget-object p4, p2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 26
    .line 27
    if-eqz p4, :cond_1

    .line 28
    .line 29
    invoke-virtual {p4}, Ljava/lang/String;->length()I

    .line 30
    .line 31
    .line 32
    move-result p4

    .line 33
    if-lez p4, :cond_1

    .line 34
    .line 35
    iget-object p4, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->remote:Landroid/widget/TextView;

    .line 36
    .line 37
    iget-object v0, p2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->info:Ljava/lang/String;

    .line 38
    .line 39
    invoke-virtual {p4, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 40
    .line 41
    .line 42
    goto :goto_0

    .line 43
    :cond_1
    iget-object p4, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->remote:Landroid/widget/TextView;

    .line 44
    .line 45
    iget-object v0, p2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->dst_ip:Ljava/lang/String;

    .line 46
    .line 47
    invoke-virtual {p4, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 48
    .line 49
    .line 50
    :goto_0
    iget p4, p2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->dst_port:I

    .line 51
    .line 52
    if-eqz p4, :cond_2

    .line 53
    .line 54
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->mProtoAndPort:Ljava/lang/String;

    .line 55
    .line 56
    iget-object v2, p2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->l7proto:Ljava/lang/String;

    .line 57
    .line 58
    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 59
    .line 60
    .line 61
    move-result-object p4

    .line 62
    const/4 v3, 0x2

    .line 63
    new-array v3, v3, [Ljava/lang/Object;

    .line 64
    .line 65
    aput-object v2, v3, v1

    .line 66
    .line 67
    const/4 v2, 0x1

    .line 68
    aput-object p4, v3, v2

    .line 69
    .line 70
    invoke-static {v0, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 71
    .line 72
    .line 73
    move-result-object p4

    .line 74
    goto :goto_1

    .line 75
    :cond_2
    iget-object p4, p2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->l7proto:Ljava/lang/String;

    .line 76
    .line 77
    :goto_1
    iget v0, p2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->ipver:I

    .line 78
    .line 79
    const/4 v2, 0x6

    .line 80
    if-ne v0, v2, :cond_3

    .line 81
    .line 82
    const-string v0, ", IPv6"

    .line 83
    .line 84
    invoke-static {p4, v0}, Landroidx/lifecycle/ViewModelProvider$Factory$-CC;->m(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 85
    .line 86
    .line 87
    move-result-object p4

    .line 88
    :cond_3
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->l7proto:Landroid/widget/TextView;

    .line 89
    .line 90
    invoke-virtual {v0, p4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 91
    .line 92
    .line 93
    if-eqz p3, :cond_4

    .line 94
    .line 95
    invoke-virtual {p3}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getName()Ljava/lang/String;

    .line 96
    .line 97
    .line 98
    move-result-object p3

    .line 99
    goto :goto_2

    .line 100
    :cond_4
    iget p3, p2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->uid:I

    .line 101
    .line 102
    invoke-static {p3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    .line 103
    .line 104
    .line 105
    move-result-object p3

    .line 106
    :goto_2
    iget-object p4, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->appName:Landroid/widget/TextView;

    .line 107
    .line 108
    invoke-virtual {p4, p3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 109
    .line 110
    .line 111
    iget-object p3, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->traffic:Landroid/widget/TextView;

    .line 112
    .line 113
    iget-wide v2, p2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->sent_bytes:J

    .line 114
    .line 115
    iget-wide v4, p2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->rcvd_bytes:J

    .line 116
    .line 117
    add-long/2addr v2, v4

    .line 118
    invoke-static {v2, v3}, Lcom/emanuelef/remote_capture/Utils;->formatBytes(J)Ljava/lang/String;

    .line 119
    .line 120
    .line 121
    move-result-object p4

    .line 122
    invoke-virtual {p3, p4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 123
    .line 124
    .line 125
    iget-object p3, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->lastSeen:Landroid/widget/TextView;

    .line 126
    .line 127
    iget-wide v2, p2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->last_seen:J

    .line 128
    .line 129
    const-wide/16 v4, 0x3e8

    .line 130
    .line 131
    div-long/2addr v2, v4

    .line 132
    invoke-static {p1, v2, v3}, Lcom/emanuelef/remote_capture/Utils;->formatEpochShort(Landroid/content/Context;J)Ljava/lang/String;

    .line 133
    .line 134
    .line 135
    move-result-object p4

    .line 136
    invoke-virtual {p3, p4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 137
    .line 138
    .line 139
    iget-object p3, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->statusInd:Landroid/widget/TextView;

    .line 140
    .line 141
    invoke-virtual {p2, p1}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->getStatusLabel(Landroid/content/Context;)Ljava/lang/String;

    .line 142
    .line 143
    .line 144
    move-result-object p4

    .line 145
    invoke-virtual {p3, p4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 146
    .line 147
    .line 148
    iget p3, p2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->status:I

    .line 149
    .line 150
    const/4 p4, 0x3

    .line 151
    const/16 v0, 0x8

    .line 152
    .line 153
    if-ge p3, p4, :cond_5

    .line 154
    .line 155
    const p3, 0x7f0603d7

    .line 156
    .line 157
    .line 158
    goto :goto_5

    .line 159
    :cond_5
    if-eq p3, p4, :cond_9

    .line 160
    .line 161
    const/4 p4, 0x7

    .line 162
    if-ne p3, p4, :cond_6

    .line 163
    .line 164
    goto :goto_4

    .line 165
    :cond_6
    const/4 p4, 0x4

    .line 166
    if-eq p3, p4, :cond_8

    .line 167
    .line 168
    const/4 p4, 0x5

    .line 169
    if-eq p3, p4, :cond_8

    .line 170
    .line 171
    if-ne p3, v0, :cond_7

    .line 172
    .line 173
    goto :goto_3

    .line 174
    :cond_7
    const p3, 0x7f0603d6

    .line 175
    .line 176
    .line 177
    goto :goto_5

    .line 178
    :cond_8
    :goto_3
    const p3, 0x7f0603e0

    .line 179
    .line 180
    .line 181
    goto :goto_5

    .line 182
    :cond_9
    :goto_4
    const p3, 0x7f0603d5

    .line 183
    .line 184
    .line 185
    :goto_5
    iget-object p4, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->statusInd:Landroid/widget/TextView;

    .line 186
    .line 187
    invoke-static {p1, p3}, Landroidx/core/os/BundleKt;->getColor(Landroid/content/Context;I)I

    .line 188
    .line 189
    .line 190
    move-result p1

    .line 191
    invoke-virtual {p4, p1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 192
    .line 193
    .line 194
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->jsInjectorInd:Landroid/widget/ImageView;

    .line 195
    .line 196
    iget-object p3, p2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->js_injected_scripts:Ljava/lang/String;

    .line 197
    .line 198
    if-eqz p3, :cond_a

    .line 199
    .line 200
    invoke-virtual {p3}, Ljava/lang/String;->isEmpty()Z

    .line 201
    .line 202
    .line 203
    move-result p3

    .line 204
    if-nez p3, :cond_a

    .line 205
    .line 206
    const/4 p3, 0x0

    .line 207
    goto :goto_6

    .line 208
    :cond_a
    const/16 p3, 0x8

    .line 209
    .line 210
    :goto_6
    invoke-virtual {p1, p3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 211
    .line 212
    .line 213
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->blacklistedInd:Landroid/widget/ImageView;

    .line 214
    .line 215
    invoke-virtual {p2}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->isBlacklisted()Z

    .line 216
    .line 217
    .line 218
    move-result p3

    .line 219
    if-eqz p3, :cond_b

    .line 220
    .line 221
    const/4 p3, 0x0

    .line 222
    goto :goto_7

    .line 223
    :cond_b
    const/16 p3, 0x8

    .line 224
    .line 225
    :goto_7
    invoke-virtual {p1, p3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 226
    .line 227
    .line 228
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->blockedInd:Landroid/widget/ImageView;

    .line 229
    .line 230
    iget-boolean p3, p2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->is_blocked:Z

    .line 231
    .line 232
    if-eqz p3, :cond_c

    .line 233
    .line 234
    const/4 p3, 0x0

    .line 235
    goto :goto_8

    .line 236
    :cond_c
    const/16 p3, 0x8

    .line 237
    .line 238
    :goto_8
    invoke-virtual {p1, p3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 239
    .line 240
    .line 241
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->redirectedInd:Landroid/widget/ImageView;

    .line 242
    .line 243
    invoke-virtual {p2}, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->isPortMappingApplied()Z

    .line 244
    .line 245
    .line 246
    move-result p3

    .line 247
    if-eqz p3, :cond_d

    .line 248
    .line 249
    iget-boolean p3, p2, Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;->is_blocked:Z

    .line 250
    .line 251
    if-nez p3, :cond_d

    .line 252
    .line 253
    const/4 p3, 0x0

    .line 254
    goto :goto_9

    .line 255
    :cond_d
    const/16 p3, 0x8

    .line 256
    .line 257
    :goto_9
    invoke-virtual {p1, p3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 258
    .line 259
    .line 260
    invoke-static {}, Lcom/emanuelef/remote_capture/CaptureService;->isDecryptingTLS()Z

    .line 261
    .line 262
    .line 263
    move-result p1

    .line 264
    if-nez p1, :cond_f

    .line 265
    .line 266
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 267
    .line 268
    .line 269
    move-result-object p1

    .line 270
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/PCAPdroid;->isDecryptingPcap()Z

    .line 271
    .line 272
    .line 273
    move-result p1

    .line 274
    if-eqz p1, :cond_e

    .line 275
    .line 276
    goto :goto_a

    .line 277
    :cond_e
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->decryptionInd:Landroid/widget/ImageView;

    .line 278
    .line 279
    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 280
    .line 281
    .line 282
    return-void

    .line 283
    :cond_f
    :goto_a
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->decryptionInd:Landroid/widget/ImageView;

    .line 284
    .line 285
    invoke-virtual {p1, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 286
    .line 287
    .line 288
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/ConnectionsAdapter$ViewHolder;->decryptionInd:Landroid/widget/ImageView;

    .line 289
    .line 290
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/Utils;->setDecryptionIcon(Landroid/widget/ImageView;Lcom/emanuelef/remote_capture/model/ConnectionDescriptor;)V

    .line 291
    .line 292
    .line 293
    return-void
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
    .line 358
    .line 359
    .line 360
    .line 361
    .line 362
    .line 363
    .line 364
    .line 365
    .line 366
    .line 367
    .line 368
    .line 369
    .line 370
    .line 371
    .line 372
    .line 373
    .line 374
    .line 375
    .line 376
    .line 377
    .line 378
    .line 379
    .line 380
    .line 381
    .line 382
    .line 383
    .line 384
    .line 385
    .line 386
    .line 387
    .line 388
    .line 389
    .line 390
    .line 391
    .line 392
    .line 393
    .line 394
    .line 395
    .line 396
    .line 397
    .line 398
    .line 399
    .line 400
    .line 401
    .line 402
    .line 403
    .line 404
    .line 405
    .line 406
    .line 407
    .line 408
    .line 409
    .line 410
    .line 411
    .line 412
    .line 413
    .line 414
    .line 415
    .line 416
    .line 417
    .line 418
    .line 419
    .line 420
    .line 421
    .line 422
    .line 423
    .line 424
    .line 425
    .line 426
    .line 427
    .line 428
    .line 429
    .line 430
    .line 431
    .line 432
    .line 433
    .line 434
    .line 435
    .line 436
    .line 437
    .line 438
    .line 439
    .line 440
    .line 441
    .line 442
    .line 443
    .line 444
    .line 445
    .line 446
    .line 447
    .line 448
    .line 449
    .line 450
    .line 451
    .line 452
    .line 453
    .line 454
    .line 455
    .line 456
    .line 457
    .line 458
    .line 459
    .line 460
    .line 461
    .line 462
    .line 463
    .line 464
    .line 465
    .line 466
    .line 467
    .line 468
    .line 469
    .line 470
    .line 471
    .line 472
    .line 473
    .line 474
    .line 475
    .line 476
    .line 477
    .line 478
    .line 479
    .line 480
    .line 481
    .line 482
    .line 483
    .line 484
    .line 485
    .line 486
    .line 487
    .line 488
    .line 489
    .line 490
    .line 491
    .line 492
    .line 493
    .line 494
    .line 495
    .line 496
    .line 497
    .line 498
    .line 499
    .line 500
    .line 501
    .line 502
    .line 503
    .line 504
    .line 505
    .line 506
    .line 507
    .line 508
    .line 509
    .line 510
    .line 511
    .line 512
    .line 513
    .line 514
    .line 515
    .line 516
    .line 517
    .line 518
    .line 519
    .line 520
    .line 521
    .line 522
    .line 523
    .line 524
    .line 525
    .line 526
    .line 527
    .line 528
    .line 529
    .line 530
    .line 531
    .line 532
    .line 533
    .line 534
    .line 535
    .line 536
    .line 537
    .line 538
    .line 539
    .line 540
    .line 541
    .line 542
    .line 543
    .line 544
    .line 545
    .line 546
    .line 547
    .line 548
    .line 549
    .line 550
    .line 551
    .line 552
    .line 553
    .line 554
    .line 555
    .line 556
    .line 557
    .line 558
    .line 559
    .line 560
    .line 561
    .line 562
    .line 563
    .line 564
    .line 565
    .line 566
    .line 567
    .line 568
    .line 569
    .line 570
    .line 571
    .line 572
    .line 573
    .line 574
    .line 575
    .line 576
    .line 577
    .line 578
    .line 579
    .line 580
    .line 581
    .line 582
    .line 583
    .line 584
    .line 585
    .line 586
    .line 587
    .line 588
    .line 589
    .line 590
    .line 591
    .line 592
    .line 593
    .line 594
    .line 595
    .line 596
    .line 597
    .line 598
    .line 599
    .line 600
    .line 601
    .line 602
    .line 603
    .line 604
    .line 605
    .line 606
    .line 607
    .line 608
    .line 609
    .line 610
    .line 611
    .line 612
    .line 613
    .line 614
    .line 615
    .line 616
    .line 617
    .line 618
    .line 619
    .line 620
    .line 621
    .line 622
    .line 623
    .line 624
    .line 625
    .line 626
    .line 627
    .line 628
    .line 629
    .line 630
    .line 631
.end method
