.class public Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ViewHolder"
.end annotation


# instance fields
.field blockedFlag:Landroid/widget/ImageView;

.field icon:Landroid/widget/ImageView;

.field info:Landroid/widget/TextView;

.field sent_rcvd:Landroid/widget/TextView;

.field tempUnblocked:Landroid/widget/ImageView;

.field final synthetic this$0:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;

.field traffic:Landroid/widget/TextView;

.field whitelistedFlag:Landroid/widget/ImageView;


# direct methods
.method public constructor <init>(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;Landroid/view/View;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->this$0:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;

    .line 2
    .line 3
    invoke-direct {p0, p2}, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V

    .line 4
    .line 5
    .line 6
    const p1, 0x7f0a0199

    .line 7
    .line 8
    .line 9
    invoke-virtual {p2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    check-cast p1, Landroid/widget/ImageView;

    .line 14
    .line 15
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->icon:Landroid/widget/ImageView;

    .line 16
    .line 17
    const p1, 0x7f0a009d

    .line 18
    .line 19
    .line 20
    invoke-virtual {p2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 21
    .line 22
    .line 23
    move-result-object p1

    .line 24
    check-cast p1, Landroid/widget/ImageView;

    .line 25
    .line 26
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->blockedFlag:Landroid/widget/ImageView;

    .line 27
    .line 28
    const p1, 0x7f0a0398

    .line 29
    .line 30
    .line 31
    invoke-virtual {p2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 32
    .line 33
    .line 34
    move-result-object p1

    .line 35
    check-cast p1, Landroid/widget/ImageView;

    .line 36
    .line 37
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->whitelistedFlag:Landroid/widget/ImageView;

    .line 38
    .line 39
    const p1, 0x7f0a0344

    .line 40
    .line 41
    .line 42
    invoke-virtual {p2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 43
    .line 44
    .line 45
    move-result-object p1

    .line 46
    check-cast p1, Landroid/widget/ImageView;

    .line 47
    .line 48
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->tempUnblocked:Landroid/widget/ImageView;

    .line 49
    .line 50
    const p1, 0x7f0a0074

    .line 51
    .line 52
    .line 53
    invoke-virtual {p2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 54
    .line 55
    .line 56
    move-result-object p1

    .line 57
    check-cast p1, Landroid/widget/TextView;

    .line 58
    .line 59
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->info:Landroid/widget/TextView;

    .line 60
    .line 61
    const p1, 0x7f0a02e0

    .line 62
    .line 63
    .line 64
    invoke-virtual {p2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 65
    .line 66
    .line 67
    move-result-object p1

    .line 68
    check-cast p1, Landroid/widget/TextView;

    .line 69
    .line 70
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->sent_rcvd:Landroid/widget/TextView;

    .line 71
    .line 72
    const p1, 0x7f0a0364

    .line 73
    .line 74
    .line 75
    invoke-virtual {p2, p1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    .line 76
    .line 77
    .line 78
    move-result-object p1

    .line 79
    check-cast p1, Landroid/widget/TextView;

    .line 80
    .line 81
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->traffic:Landroid/widget/TextView;

    .line 82
    .line 83
    return-void
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


# virtual methods
.method public bindAppStats(Lcom/emanuelef/remote_capture/model/AppStats;)V
    .locals 11

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->this$0:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;

    .line 2
    .line 3
    invoke-static {v0}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->-$$Nest$fgetmApps(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;)Lcom/emanuelef/remote_capture/AppsResolver;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    const/4 v1, 0x0

    .line 8
    if-eqz v0, :cond_0

    .line 9
    .line 10
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->this$0:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;

    .line 11
    .line 12
    invoke-static {v0}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->-$$Nest$fgetmApps(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;)Lcom/emanuelef/remote_capture/AppsResolver;

    .line 13
    .line 14
    .line 15
    move-result-object v0

    .line 16
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/AppStats;->getUid()I

    .line 17
    .line 18
    .line 19
    move-result v2

    .line 20
    invoke-virtual {v0, v2, v1}, Lcom/emanuelef/remote_capture/AppsResolver;->getAppByUid(II)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 21
    .line 22
    .line 23
    move-result-object v0

    .line 24
    goto :goto_0

    .line 25
    :cond_0
    const/4 v0, 0x0

    .line 26
    :goto_0
    if-eqz v0, :cond_1

    .line 27
    .line 28
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getIcon()Landroid/graphics/drawable/Drawable;

    .line 29
    .line 30
    .line 31
    move-result-object v2

    .line 32
    if-eqz v2, :cond_1

    .line 33
    .line 34
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getIcon()Landroid/graphics/drawable/Drawable;

    .line 35
    .line 36
    .line 37
    move-result-object v2

    .line 38
    goto :goto_1

    .line 39
    :cond_1
    iget-object v2, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->this$0:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;

    .line 40
    .line 41
    invoke-static {v2}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->-$$Nest$fgetmUnknownIcon(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;)Landroid/graphics/drawable/Drawable;

    .line 42
    .line 43
    .line 44
    move-result-object v2

    .line 45
    :goto_1
    iget-object v3, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->icon:Landroid/widget/ImageView;

    .line 46
    .line 47
    invoke-virtual {v3, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 48
    .line 49
    .line 50
    if-eqz v0, :cond_2

    .line 51
    .line 52
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getName()Ljava/lang/String;

    .line 53
    .line 54
    .line 55
    move-result-object v0

    .line 56
    goto :goto_2

    .line 57
    :cond_2
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/AppStats;->getUid()I

    .line 58
    .line 59
    .line 60
    move-result v0

    .line 61
    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    .line 62
    .line 63
    .line 64
    move-result-object v0

    .line 65
    :goto_2
    iget v2, p1, Lcom/emanuelef/remote_capture/model/AppStats;->numConnections:I

    .line 66
    .line 67
    const/4 v3, 0x1

    .line 68
    if-le v2, v3, :cond_3

    .line 69
    .line 70
    new-instance v2, Ljava/lang/StringBuilder;

    .line 71
    .line 72
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 73
    .line 74
    .line 75
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 76
    .line 77
    .line 78
    const-string v0, " ("

    .line 79
    .line 80
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 81
    .line 82
    .line 83
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->this$0:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;

    .line 84
    .line 85
    invoke-static {v0}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->-$$Nest$fgetmContext(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;)Landroid/content/Context;

    .line 86
    .line 87
    .line 88
    move-result-object v0

    .line 89
    iget v4, p1, Lcom/emanuelef/remote_capture/model/AppStats;->numConnections:I

    .line 90
    .line 91
    int-to-long v4, v4

    .line 92
    invoke-static {v0, v4, v5}, Lcom/emanuelef/remote_capture/Utils;->formatNumber(Landroid/content/Context;J)Ljava/lang/String;

    .line 93
    .line 94
    .line 95
    move-result-object v0

    .line 96
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 97
    .line 98
    .line 99
    const-string v0, ")"

    .line 100
    .line 101
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 102
    .line 103
    .line 104
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 105
    .line 106
    .line 107
    move-result-object v0

    .line 108
    :cond_3
    iget-object v2, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->info:Landroid/widget/TextView;

    .line 109
    .line 110
    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 111
    .line 112
    .line 113
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->this$0:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;

    .line 114
    .line 115
    invoke-static {v0}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->-$$Nest$fgetmBlocklist(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;)Lcom/emanuelef/remote_capture/model/Blocklist;

    .line 116
    .line 117
    .line 118
    move-result-object v0

    .line 119
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/AppStats;->getUid()I

    .line 120
    .line 121
    .line 122
    move-result v2

    .line 123
    invoke-virtual {v0, v2}, Lcom/emanuelef/remote_capture/model/Blocklist;->isExemptedApp(I)Z

    .line 124
    .line 125
    .line 126
    move-result v0

    .line 127
    iget-object v2, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->this$0:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;

    .line 128
    .line 129
    invoke-static {v2}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->-$$Nest$fgetmBlocklist(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;)Lcom/emanuelef/remote_capture/model/Blocklist;

    .line 130
    .line 131
    .line 132
    move-result-object v2

    .line 133
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/AppStats;->getUid()I

    .line 134
    .line 135
    .line 136
    move-result v4

    .line 137
    invoke-virtual {v2, v4}, Lcom/emanuelef/remote_capture/model/Blocklist;->matchesApp(I)Z

    .line 138
    .line 139
    .line 140
    move-result v2

    .line 141
    iget-object v4, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->this$0:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;

    .line 142
    .line 143
    invoke-static {v4}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->-$$Nest$fgetmWhitelist(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;)Lcom/emanuelef/remote_capture/model/MatchList;

    .line 144
    .line 145
    .line 146
    move-result-object v4

    .line 147
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/AppStats;->getUid()I

    .line 148
    .line 149
    .line 150
    move-result v5

    .line 151
    invoke-virtual {v4, v5}, Lcom/emanuelef/remote_capture/model/MatchList;->matchesApp(I)Z

    .line 152
    .line 153
    .line 154
    move-result v4

    .line 155
    iget-object v5, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->this$0:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;

    .line 156
    .line 157
    invoke-static {v5}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->-$$Nest$fgetmContext(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;)Landroid/content/Context;

    .line 158
    .line 159
    .line 160
    move-result-object v5

    .line 161
    iget-object v6, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->this$0:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;

    .line 162
    .line 163
    invoke-static {v6}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->-$$Nest$fgetmPrefs(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;)Landroid/content/SharedPreferences;

    .line 164
    .line 165
    .line 166
    move-result-object v6

    .line 167
    invoke-static {v5, v6}, Lcom/emanuelef/remote_capture/model/Prefs;->isFirewallEnabled(Landroid/content/Context;Landroid/content/SharedPreferences;)Z

    .line 168
    .line 169
    .line 170
    move-result v5

    .line 171
    if-eqz v5, :cond_4

    .line 172
    .line 173
    iget-object v5, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->this$0:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;

    .line 174
    .line 175
    invoke-static {v5}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->-$$Nest$fgetmPrefs(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;)Landroid/content/SharedPreferences;

    .line 176
    .line 177
    .line 178
    move-result-object v5

    .line 179
    invoke-static {v5}, Lcom/emanuelef/remote_capture/model/Prefs;->isFirewallWhitelistMode(Landroid/content/SharedPreferences;)Z

    .line 180
    .line 181
    .line 182
    move-result v5

    .line 183
    if-eqz v5, :cond_4

    .line 184
    .line 185
    const/4 v5, 0x1

    .line 186
    goto :goto_3

    .line 187
    :cond_4
    const/4 v5, 0x0

    .line 188
    :goto_3
    iget-object v6, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->sent_rcvd:Landroid/widget/TextView;

    .line 189
    .line 190
    iget-object v7, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->this$0:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;

    .line 191
    .line 192
    invoke-static {v7}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->-$$Nest$fgetmContext(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;)Landroid/content/Context;

    .line 193
    .line 194
    .line 195
    move-result-object v7

    .line 196
    iget-wide v8, p1, Lcom/emanuelef/remote_capture/model/AppStats;->rcvdBytes:J

    .line 197
    .line 198
    invoke-static {v8, v9}, Lcom/emanuelef/remote_capture/Utils;->formatBytes(J)Ljava/lang/String;

    .line 199
    .line 200
    .line 201
    move-result-object v8

    .line 202
    iget-wide v9, p1, Lcom/emanuelef/remote_capture/model/AppStats;->sentBytes:J

    .line 203
    .line 204
    invoke-static {v9, v10}, Lcom/emanuelef/remote_capture/Utils;->formatBytes(J)Ljava/lang/String;

    .line 205
    .line 206
    .line 207
    move-result-object v9

    .line 208
    const/4 v10, 0x2

    .line 209
    new-array v10, v10, [Ljava/lang/Object;

    .line 210
    .line 211
    aput-object v8, v10, v1

    .line 212
    .line 213
    aput-object v9, v10, v3

    .line 214
    .line 215
    const v3, 0x7f14025f

    .line 216
    .line 217
    .line 218
    invoke-virtual {v7, v3, v10}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    .line 219
    .line 220
    .line 221
    move-result-object v3

    .line 222
    invoke-virtual {v6, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 223
    .line 224
    .line 225
    iget-object v3, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->traffic:Landroid/widget/TextView;

    .line 226
    .line 227
    iget-wide v6, p1, Lcom/emanuelef/remote_capture/model/AppStats;->sentBytes:J

    .line 228
    .line 229
    iget-wide v8, p1, Lcom/emanuelef/remote_capture/model/AppStats;->rcvdBytes:J

    .line 230
    .line 231
    add-long/2addr v6, v8

    .line 232
    invoke-static {v6, v7}, Lcom/emanuelef/remote_capture/Utils;->formatBytes(J)Ljava/lang/String;

    .line 233
    .line 234
    .line 235
    move-result-object p1

    .line 236
    invoke-virtual {v3, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 237
    .line 238
    .line 239
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->blockedFlag:Landroid/widget/ImageView;

    .line 240
    .line 241
    const/16 v3, 0x8

    .line 242
    .line 243
    if-eqz v2, :cond_5

    .line 244
    .line 245
    const/4 v2, 0x0

    .line 246
    goto :goto_4

    .line 247
    :cond_5
    const/16 v2, 0x8

    .line 248
    .line 249
    :goto_4
    invoke-virtual {p1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 250
    .line 251
    .line 252
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->whitelistedFlag:Landroid/widget/ImageView;

    .line 253
    .line 254
    if-eqz v5, :cond_6

    .line 255
    .line 256
    if-eqz v4, :cond_6

    .line 257
    .line 258
    const/4 v2, 0x0

    .line 259
    goto :goto_5

    .line 260
    :cond_6
    const/16 v2, 0x8

    .line 261
    .line 262
    :goto_5
    invoke-virtual {p1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 263
    .line 264
    .line 265
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->tempUnblocked:Landroid/widget/ImageView;

    .line 266
    .line 267
    if-eqz v0, :cond_7

    .line 268
    .line 269
    goto :goto_6

    .line 270
    :cond_7
    const/16 v1, 0x8

    .line 271
    .line 272
    :goto_6
    invoke-virtual {p1, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 273
    .line 274
    .line 275
    return-void
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
.end method
