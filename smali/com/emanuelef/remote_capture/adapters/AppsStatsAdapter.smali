.class public Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$SortField;,
        Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/recyclerview/widget/RecyclerView$Adapter;"
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "AppsStatsAdapter"


# instance fields
.field private final mApps:Lcom/emanuelef/remote_capture/AppsResolver;

.field private final mBlocklist:Lcom/emanuelef/remote_capture/model/Blocklist;

.field private final mContext:Landroid/content/Context;

.field private final mFirewallAvailable:Z

.field private final mLayoutInflater:Landroid/view/LayoutInflater;

.field private mListener:Landroid/view/View$OnClickListener;

.field private final mPrefs:Landroid/content/SharedPreferences;

.field private mSelectedItem:Lcom/emanuelef/remote_capture/model/AppStats;

.field private mSortField:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$SortField;

.field private mStats:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/emanuelef/remote_capture/model/AppStats;",
            ">;"
        }
    .end annotation
.end field

.field private final mUnknownIcon:Landroid/graphics/drawable/Drawable;

.field private final mWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;


# direct methods
.method public static synthetic $r8$lambda$OM70x6gm8s6_s5Qt11M6fxBge_U(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;Lcom/emanuelef/remote_capture/model/AppStats;Lcom/emanuelef/remote_capture/model/AppStats;)I
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->lambda$setStats$1(Lcom/emanuelef/remote_capture/model/AppStats;Lcom/emanuelef/remote_capture/model/AppStats;)I

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$wL2yDVtlT3NpOhgUsopxYHaAeD4(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;Landroid/view/View;)Z
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->lambda$onCreateViewHolder$0(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;Landroid/view/View;)Z

    move-result p0

    return p0
.end method

.method public static bridge synthetic -$$Nest$fgetmApps(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;)Lcom/emanuelef/remote_capture/AppsResolver;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mApps:Lcom/emanuelef/remote_capture/AppsResolver;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$fgetmBlocklist(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;)Lcom/emanuelef/remote_capture/model/Blocklist;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mBlocklist:Lcom/emanuelef/remote_capture/model/Blocklist;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$fgetmContext(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;)Landroid/content/Context;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mContext:Landroid/content/Context;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$fgetmPrefs(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;)Landroid/content/SharedPreferences;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mPrefs:Landroid/content/SharedPreferences;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$fgetmUnknownIcon(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;)Landroid/graphics/drawable/Drawable;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mUnknownIcon:Landroid/graphics/drawable/Drawable;

    return-object p0
.end method

.method public static bridge synthetic -$$Nest$fgetmWhitelist(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;)Lcom/emanuelef/remote_capture/model/MatchList;
    .locals 0

    .line 1
    iget-object p0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    return-object p0
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mContext:Landroid/content/Context;

    .line 5
    .line 6
    new-instance v0, Lcom/emanuelef/remote_capture/AppsResolver;

    .line 7
    .line 8
    invoke-direct {v0, p1}, Lcom/emanuelef/remote_capture/AppsResolver;-><init>(Landroid/content/Context;)V

    .line 9
    .line 10
    .line 11
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mApps:Lcom/emanuelef/remote_capture/AppsResolver;

    .line 12
    .line 13
    const-string v0, "layout_inflater"

    .line 14
    .line 15
    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    check-cast v0, Landroid/view/LayoutInflater;

    .line 20
    .line 21
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    .line 22
    .line 23
    const v0, 0x7f0801a5

    .line 24
    .line 25
    .line 26
    invoke-static {p1, v0}, Landroidx/core/content/ContextCompat$Api21Impl;->getDrawable(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    .line 27
    .line 28
    .line 29
    move-result-object v0

    .line 30
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mUnknownIcon:Landroid/graphics/drawable/Drawable;

    .line 31
    .line 32
    invoke-static {p1}, Landroidx/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    .line 33
    .line 34
    .line 35
    move-result-object v0

    .line 36
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mPrefs:Landroid/content/SharedPreferences;

    .line 37
    .line 38
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 39
    .line 40
    .line 41
    move-result-object v0

    .line 42
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/PCAPdroid;->getBlocklist()Lcom/emanuelef/remote_capture/model/Blocklist;

    .line 43
    .line 44
    .line 45
    move-result-object v0

    .line 46
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mBlocklist:Lcom/emanuelef/remote_capture/model/Blocklist;

    .line 47
    .line 48
    invoke-static {}, Lcom/emanuelef/remote_capture/PCAPdroid;->getInstance()Lcom/emanuelef/remote_capture/PCAPdroid;

    .line 49
    .line 50
    .line 51
    move-result-object v0

    .line 52
    invoke-virtual {v0}, Lcom/emanuelef/remote_capture/PCAPdroid;->getFirewallWhitelist()Lcom/emanuelef/remote_capture/model/MatchList;

    .line 53
    .line 54
    .line 55
    move-result-object v0

    .line 56
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mWhitelist:Lcom/emanuelef/remote_capture/model/MatchList;

    .line 57
    .line 58
    const/4 v0, 0x0

    .line 59
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mListener:Landroid/view/View$OnClickListener;

    .line 60
    .line 61
    new-instance v0, Ljava/util/ArrayList;

    .line 62
    .line 63
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 64
    .line 65
    .line 66
    iput-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mStats:Ljava/util/List;

    .line 67
    .line 68
    invoke-static {p1}, Lcom/emanuelef/remote_capture/Billing;->newInstance(Landroid/content/Context;)Lcom/emanuelef/remote_capture/PlayBilling;

    .line 69
    .line 70
    .line 71
    move-result-object p1

    .line 72
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/Billing;->isFirewallVisible()Z

    .line 73
    .line 74
    .line 75
    move-result p1

    .line 76
    iput-boolean p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mFirewallAvailable:Z

    .line 77
    .line 78
    sget-object p1, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$SortField;->NAME:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$SortField;

    .line 79
    .line 80
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mSortField:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$SortField;

    .line 81
    .line 82
    const/4 p1, 0x1

    .line 83
    invoke-virtual {p0, p1}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->setHasStableIds(Z)V

    .line 84
    .line 85
    .line 86
    return-void
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

.method private synthetic lambda$onCreateViewHolder$0(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;Landroid/view/View;)Z
    .locals 0

    .line 1
    invoke-virtual {p1}, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;->getAbsoluteAdapterPosition()I

    .line 2
    .line 3
    .line 4
    move-result p1

    .line 5
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->getItem(I)Lcom/emanuelef/remote_capture/model/AppStats;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mSelectedItem:Lcom/emanuelef/remote_capture/model/AppStats;

    .line 10
    .line 11
    const/4 p1, 0x0

    .line 12
    return p1
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
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
    .line 58
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
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

.method private synthetic lambda$setStats$1(Lcom/emanuelef/remote_capture/model/AppStats;Lcom/emanuelef/remote_capture/model/AppStats;)I
    .locals 4

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mApps:Lcom/emanuelef/remote_capture/AppsResolver;

    .line 2
    .line 3
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/AppStats;->getUid()I

    .line 4
    .line 5
    .line 6
    move-result v1

    .line 7
    const/4 v2, 0x0

    .line 8
    invoke-virtual {v0, v1, v2}, Lcom/emanuelef/remote_capture/AppsResolver;->getAppByUid(II)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mApps:Lcom/emanuelef/remote_capture/AppsResolver;

    .line 13
    .line 14
    invoke-virtual {p2}, Lcom/emanuelef/remote_capture/model/AppStats;->getUid()I

    .line 15
    .line 16
    .line 17
    move-result v3

    .line 18
    invoke-virtual {v1, v3, v2}, Lcom/emanuelef/remote_capture/AppsResolver;->getAppByUid(II)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 19
    .line 20
    .line 21
    move-result-object v1

    .line 22
    if-nez v0, :cond_0

    .line 23
    .line 24
    if-nez v1, :cond_0

    .line 25
    .line 26
    return v2

    .line 27
    :cond_0
    if-nez v0, :cond_1

    .line 28
    .line 29
    const/4 p1, -0x1

    .line 30
    return p1

    .line 31
    :cond_1
    const/4 v2, 0x1

    .line 32
    if-nez v1, :cond_2

    .line 33
    .line 34
    return v2

    .line 35
    :cond_2
    iget-object v3, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mSortField:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$SortField;

    .line 36
    .line 37
    invoke-virtual {v3}, Ljava/lang/Enum;->ordinal()I

    .line 38
    .line 39
    .line 40
    move-result v3

    .line 41
    if-eq v3, v2, :cond_5

    .line 42
    .line 43
    const/4 v2, 0x2

    .line 44
    if-eq v3, v2, :cond_4

    .line 45
    .line 46
    const/4 v2, 0x3

    .line 47
    if-eq v3, v2, :cond_3

    .line 48
    .line 49
    invoke-virtual {v0, v1}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->compareTo(Lcom/emanuelef/remote_capture/model/AppDescriptor;)I

    .line 50
    .line 51
    .line 52
    move-result p1

    .line 53
    return p1

    .line 54
    :cond_3
    iget-wide v0, p1, Lcom/emanuelef/remote_capture/model/AppStats;->rcvdBytes:J

    .line 55
    .line 56
    iget-wide p1, p2, Lcom/emanuelef/remote_capture/model/AppStats;->rcvdBytes:J

    .line 57
    .line 58
    invoke-static {v0, v1, p1, p2}, Ljava/lang/Long;->compare(JJ)I

    .line 59
    .line 60
    .line 61
    move-result p1

    .line 62
    :goto_0
    neg-int p1, p1

    .line 63
    return p1

    .line 64
    :cond_4
    iget-wide v0, p1, Lcom/emanuelef/remote_capture/model/AppStats;->sentBytes:J

    .line 65
    .line 66
    iget-wide p1, p2, Lcom/emanuelef/remote_capture/model/AppStats;->sentBytes:J

    .line 67
    .line 68
    invoke-static {v0, v1, p1, p2}, Ljava/lang/Long;->compare(JJ)I

    .line 69
    .line 70
    .line 71
    move-result p1

    .line 72
    goto :goto_0

    .line 73
    :cond_5
    iget-wide v0, p1, Lcom/emanuelef/remote_capture/model/AppStats;->rcvdBytes:J

    .line 74
    .line 75
    iget-wide v2, p1, Lcom/emanuelef/remote_capture/model/AppStats;->sentBytes:J

    .line 76
    .line 77
    add-long/2addr v0, v2

    .line 78
    iget-wide v2, p2, Lcom/emanuelef/remote_capture/model/AppStats;->rcvdBytes:J

    .line 79
    .line 80
    iget-wide p1, p2, Lcom/emanuelef/remote_capture/model/AppStats;->sentBytes:J

    .line 81
    .line 82
    add-long/2addr v2, p1

    .line 83
    invoke-static {v0, v1, v2, v3}, Ljava/lang/Long;->compare(JJ)I

    .line 84
    .line 85
    .line 86
    move-result p1

    .line 87
    goto :goto_0
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
.method public getItem(I)Lcom/emanuelef/remote_capture/model/AppStats;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mStats:Ljava/util/List;

    .line 2
    .line 3
    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    check-cast p1, Lcom/emanuelef/remote_capture/model/AppStats;

    .line 8
    .line 9
    return-object p1
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
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

.method public getItemCount()I
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mStats:Ljava/util/List;

    .line 2
    .line 3
    invoke-interface {v0}, Ljava/util/List;->size()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    return v0
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
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
    .line 58
.end method

.method public getItemId(I)J
    .locals 2

    .line 1
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->getItem(I)Lcom/emanuelef/remote_capture/model/AppStats;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    if-eqz p1, :cond_0

    .line 6
    .line 7
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/AppStats;->getUid()I

    .line 8
    .line 9
    .line 10
    move-result p1

    .line 11
    goto :goto_0

    .line 12
    :cond_0
    const/4 p1, -0x1

    .line 13
    :goto_0
    int-to-long v0, p1

    .line 14
    return-wide v0
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
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

.method public getItemPackage(I)Ljava/lang/String;
    .locals 3

    .line 1
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->getItem(I)Lcom/emanuelef/remote_capture/model/AppStats;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    const/4 v0, 0x0

    .line 6
    if-nez p1, :cond_0

    .line 7
    .line 8
    return-object v0

    .line 9
    :cond_0
    iget-object v1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mApps:Lcom/emanuelef/remote_capture/AppsResolver;

    .line 10
    .line 11
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/AppStats;->getUid()I

    .line 12
    .line 13
    .line 14
    move-result p1

    .line 15
    const/4 v2, 0x0

    .line 16
    invoke-virtual {v1, p1, v2}, Lcom/emanuelef/remote_capture/AppsResolver;->getAppByUid(II)Lcom/emanuelef/remote_capture/model/AppDescriptor;

    .line 17
    .line 18
    .line 19
    move-result-object p1

    .line 20
    if-eqz p1, :cond_1

    .line 21
    .line 22
    invoke-virtual {p1}, Lcom/emanuelef/remote_capture/model/AppDescriptor;->getPackageName()Ljava/lang/String;

    .line 23
    .line 24
    .line 25
    move-result-object p1

    .line 26
    return-object p1

    .line 27
    :cond_1
    return-object v0
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

.method public getSelectedItem()Lcom/emanuelef/remote_capture/model/AppStats;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mSelectedItem:Lcom/emanuelef/remote_capture/model/AppStats;

    .line 2
    .line 3
    return-object v0
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
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
    .line 58
.end method

.method public getSortField()Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$SortField;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mSortField:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$SortField;

    .line 2
    .line 3
    return-object v0
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
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
    .line 58
.end method

.method public notifyItemChanged(Lcom/emanuelef/remote_capture/model/AppStats;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mStats:Ljava/util/List;

    .line 2
    .line 3
    invoke-interface {v0, p1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    .line 4
    .line 5
    .line 6
    move-result p1

    .line 7
    if-ltz p1, :cond_0

    .line 8
    .line 9
    invoke-virtual {p0, p1}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyItemChanged(I)V

    .line 10
    .line 11
    .line 12
    :cond_0
    return-void
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
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

.method public bridge synthetic onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V
    .locals 0

    .line 1
    check-cast p1, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;

    invoke-virtual {p0, p1, p2}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->onBindViewHolder(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;I)V

    return-void
.end method

.method public onBindViewHolder(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;I)V
    .locals 0

    .line 2
    invoke-virtual {p0, p2}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->getItem(I)Lcom/emanuelef/remote_capture/model/AppStats;

    move-result-object p2

    if-nez p2, :cond_0

    return-void

    .line 3
    :cond_0
    invoke-virtual {p1, p2}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;->bindAppStats(Lcom/emanuelef/remote_capture/model/AppStats;)V

    return-void
.end method

.method public bridge synthetic onCreateViewHolder(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    .locals 0

    .line 1
    invoke-virtual {p0, p1, p2}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->onCreateViewHolder(Landroid/view/ViewGroup;I)Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;

    move-result-object p1

    return-object p1
.end method

.method public onCreateViewHolder(Landroid/view/ViewGroup;I)Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;
    .locals 2

    .line 2
    iget-object p2, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    const v0, 0x7f0d0022

    const/4 v1, 0x0

    invoke-virtual {p2, v0, p1, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p1

    .line 3
    iget-object p2, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mListener:Landroid/view/View$OnClickListener;

    if-eqz p2, :cond_0

    .line 4
    invoke-virtual {p1, p2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 5
    :cond_0
    new-instance p2, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;

    invoke-direct {p2, p0, p1}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$ViewHolder;-><init>(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;Landroid/view/View;)V

    .line 6
    iget-boolean v0, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mFirewallAvailable:Z

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    .line 7
    invoke-virtual {p1, v0}, Landroid/view/View;->setLongClickable(Z)V

    .line 8
    new-instance v0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda1;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p2, v1}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda1;-><init>(Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V

    invoke-virtual {p1, v0}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    :cond_1
    return-object p2
.end method

.method public setClickListener(Landroid/view/View$OnClickListener;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mListener:Landroid/view/View$OnClickListener;

    .line 2
    .line 3
    return-void
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
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

.method public setSortField(Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$SortField;)V
    .locals 0
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NotifyDataSetChanged"
        }
    .end annotation

    .line 1
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mSortField:Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$SortField;

    .line 2
    .line 3
    iget-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mStats:Ljava/util/List;

    .line 4
    .line 5
    invoke-virtual {p0, p1}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->setStats(Ljava/util/List;)V

    .line 6
    .line 7
    .line 8
    return-void
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
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

.method public setStats(Ljava/util/List;)V
    .locals 2
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NotifyDataSetChanged"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lcom/emanuelef/remote_capture/model/AppStats;",
            ">;)V"
        }
    .end annotation

    .line 1
    new-instance v0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda0;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-direct {v0, v1, p0}, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter$$ExternalSyntheticLambda0;-><init>(ILjava/lang/Object;)V

    .line 5
    .line 6
    .line 7
    invoke-static {p1, v0}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 8
    .line 9
    .line 10
    iput-object p1, p0, Lcom/emanuelef/remote_capture/adapters/AppsStatsAdapter;->mStats:Ljava/util/List;

    .line 11
    .line 12
    invoke-virtual {p0}, Landroidx/recyclerview/widget/RecyclerView$Adapter;->notifyDataSetChanged()V

    .line 13
    .line 14
    .line 15
    return-void
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
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
