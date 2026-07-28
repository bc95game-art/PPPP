.class public final Landroidx/recyclerview/widget/LinearLayoutManager$LayoutState;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public mAvailable:I

.field public mCurrentPosition:I

.field public mExtraFillSpace:I

.field public mInfinite:Z

.field public mItemDirection:I

.field public mLastScrollDelta:I

.field public mLayoutDirection:I

.field public mNoRecycleSpace:I

.field public mOffset:I

.field public mRecycle:Z

.field public mScrapList:Ljava/util/List;

.field public mScrollingOffset:I


# virtual methods
.method public final assignPositionFromScrapList(Landroid/view/View;)V
    .locals 7

    .line 1
    iget-object v0, p0, Landroidx/recyclerview/widget/LinearLayoutManager$LayoutState;->mScrapList:Ljava/util/List;

    .line 2
    .line 3
    invoke-interface {v0}, Ljava/util/List;->size()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    const/4 v1, 0x0

    .line 8
    const v2, 0x7fffffff

    .line 9
    .line 10
    .line 11
    const/4 v3, 0x0

    .line 12
    :goto_0
    if-ge v3, v0, :cond_4

    .line 13
    .line 14
    iget-object v4, p0, Landroidx/recyclerview/widget/LinearLayoutManager$LayoutState;->mScrapList:Ljava/util/List;

    .line 15
    .line 16
    invoke-interface {v4, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    .line 17
    .line 18
    .line 19
    move-result-object v4

    .line 20
    check-cast v4, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;

    .line 21
    .line 22
    iget-object v4, v4, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;->itemView:Landroid/view/View;

    .line 23
    .line 24
    invoke-virtual {v4}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    .line 25
    .line 26
    .line 27
    move-result-object v5

    .line 28
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;

    .line 29
    .line 30
    if-eq v4, p1, :cond_3

    .line 31
    .line 32
    iget-object v6, v5, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;->mViewHolder:Landroidx/recyclerview/widget/RecyclerView$ViewHolder;

    .line 33
    .line 34
    invoke-virtual {v6}, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;->isRemoved()Z

    .line 35
    .line 36
    .line 37
    move-result v6

    .line 38
    if-eqz v6, :cond_0

    .line 39
    .line 40
    goto :goto_1

    .line 41
    :cond_0
    iget-object v5, v5, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;->mViewHolder:Landroidx/recyclerview/widget/RecyclerView$ViewHolder;

    .line 42
    .line 43
    invoke-virtual {v5}, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;->getLayoutPosition()I

    .line 44
    .line 45
    .line 46
    move-result v5

    .line 47
    iget v6, p0, Landroidx/recyclerview/widget/LinearLayoutManager$LayoutState;->mCurrentPosition:I

    .line 48
    .line 49
    sub-int/2addr v5, v6

    .line 50
    iget v6, p0, Landroidx/recyclerview/widget/LinearLayoutManager$LayoutState;->mItemDirection:I

    .line 51
    .line 52
    mul-int v5, v5, v6

    .line 53
    .line 54
    if-gez v5, :cond_1

    .line 55
    .line 56
    goto :goto_1

    .line 57
    :cond_1
    if-ge v5, v2, :cond_3

    .line 58
    .line 59
    move-object v1, v4

    .line 60
    if-nez v5, :cond_2

    .line 61
    .line 62
    goto :goto_2

    .line 63
    :cond_2
    move v2, v5

    .line 64
    :cond_3
    :goto_1
    add-int/lit8 v3, v3, 0x1

    .line 65
    .line 66
    goto :goto_0

    .line 67
    :cond_4
    :goto_2
    if-nez v1, :cond_5

    .line 68
    .line 69
    const/4 p1, -0x1

    .line 70
    iput p1, p0, Landroidx/recyclerview/widget/LinearLayoutManager$LayoutState;->mCurrentPosition:I

    .line 71
    .line 72
    return-void

    .line 73
    :cond_5
    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    .line 74
    .line 75
    .line 76
    move-result-object p1

    .line 77
    check-cast p1, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;

    .line 78
    .line 79
    iget-object p1, p1, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;->mViewHolder:Landroidx/recyclerview/widget/RecyclerView$ViewHolder;

    .line 80
    .line 81
    invoke-virtual {p1}, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;->getLayoutPosition()I

    .line 82
    .line 83
    .line 84
    move-result p1

    .line 85
    iput p1, p0, Landroidx/recyclerview/widget/LinearLayoutManager$LayoutState;->mCurrentPosition:I

    .line 86
    .line 87
    return-void
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

.method public final next(Landroidx/recyclerview/widget/RecyclerView$Recycler;)Landroid/view/View;
    .locals 4

    .line 1
    iget-object v0, p0, Landroidx/recyclerview/widget/LinearLayoutManager$LayoutState;->mScrapList:Ljava/util/List;

    .line 2
    .line 3
    if-eqz v0, :cond_3

    .line 4
    .line 5
    invoke-interface {v0}, Ljava/util/List;->size()I

    .line 6
    .line 7
    .line 8
    move-result p1

    .line 9
    const/4 v0, 0x0

    .line 10
    :goto_0
    if-ge v0, p1, :cond_2

    .line 11
    .line 12
    iget-object v1, p0, Landroidx/recyclerview/widget/LinearLayoutManager$LayoutState;->mScrapList:Ljava/util/List;

    .line 13
    .line 14
    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    .line 15
    .line 16
    .line 17
    move-result-object v1

    .line 18
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;

    .line 19
    .line 20
    iget-object v1, v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;->itemView:Landroid/view/View;

    .line 21
    .line 22
    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    .line 23
    .line 24
    .line 25
    move-result-object v2

    .line 26
    check-cast v2, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;

    .line 27
    .line 28
    iget-object v3, v2, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;->mViewHolder:Landroidx/recyclerview/widget/RecyclerView$ViewHolder;

    .line 29
    .line 30
    invoke-virtual {v3}, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;->isRemoved()Z

    .line 31
    .line 32
    .line 33
    move-result v3

    .line 34
    if-eqz v3, :cond_0

    .line 35
    .line 36
    goto :goto_1

    .line 37
    :cond_0
    iget v3, p0, Landroidx/recyclerview/widget/LinearLayoutManager$LayoutState;->mCurrentPosition:I

    .line 38
    .line 39
    iget-object v2, v2, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;->mViewHolder:Landroidx/recyclerview/widget/RecyclerView$ViewHolder;

    .line 40
    .line 41
    invoke-virtual {v2}, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;->getLayoutPosition()I

    .line 42
    .line 43
    .line 44
    move-result v2

    .line 45
    if-ne v3, v2, :cond_1

    .line 46
    .line 47
    invoke-virtual {p0, v1}, Landroidx/recyclerview/widget/LinearLayoutManager$LayoutState;->assignPositionFromScrapList(Landroid/view/View;)V

    .line 48
    .line 49
    .line 50
    return-object v1

    .line 51
    :cond_1
    :goto_1
    add-int/lit8 v0, v0, 0x1

    .line 52
    .line 53
    goto :goto_0

    .line 54
    :cond_2
    const/4 p1, 0x0

    .line 55
    return-object p1

    .line 56
    :cond_3
    iget v0, p0, Landroidx/recyclerview/widget/LinearLayoutManager$LayoutState;->mCurrentPosition:I

    .line 57
    .line 58
    invoke-virtual {p1, v0}, Landroidx/recyclerview/widget/RecyclerView$Recycler;->getViewForPosition(I)Landroid/view/View;

    .line 59
    .line 60
    .line 61
    move-result-object p1

    .line 62
    iget v0, p0, Landroidx/recyclerview/widget/LinearLayoutManager$LayoutState;->mCurrentPosition:I

    .line 63
    .line 64
    iget v1, p0, Landroidx/recyclerview/widget/LinearLayoutManager$LayoutState;->mItemDirection:I

    .line 65
    .line 66
    add-int/2addr v0, v1

    .line 67
    iput v0, p0, Landroidx/recyclerview/widget/LinearLayoutManager$LayoutState;->mCurrentPosition:I

    .line 68
    .line 69
    return-object p1
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
