.class public Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;
.super Landroidx/preference/PreferenceDialogFragmentCompat;
.source "SourceFile"


# instance fields
.field public mEntries:[Ljava/lang/CharSequence;

.field public mEntryValues:[Ljava/lang/CharSequence;

.field public final mNewValues:Ljava/util/HashSet;

.field public mPreferenceChanged:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Landroidx/preference/PreferenceDialogFragmentCompat;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Ljava/util/HashSet;

    .line 5
    .line 6
    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mNewValues:Ljava/util/HashSet;

    .line 10
    .line 11
    return-void
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


# virtual methods
.method public final onCreate(Landroid/os/Bundle;)V
    .locals 4

    .line 1
    invoke-super {p0, p1}, Landroidx/preference/PreferenceDialogFragmentCompat;->onCreate(Landroid/os/Bundle;)V

    .line 2
    .line 3
    .line 4
    const/4 v0, 0x0

    .line 5
    iget-object v1, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mNewValues:Ljava/util/HashSet;

    .line 6
    .line 7
    if-nez p1, :cond_1

    .line 8
    .line 9
    invoke-virtual {p0}, Landroidx/preference/PreferenceDialogFragmentCompat;->getPreference()Landroidx/preference/DialogPreference;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    check-cast p1, Landroidx/preference/MultiSelectListPreference;

    .line 14
    .line 15
    iget-object v2, p1, Landroidx/preference/MultiSelectListPreference;->mEntries:[Ljava/lang/CharSequence;

    .line 16
    .line 17
    iget-object v3, p1, Landroidx/preference/MultiSelectListPreference;->mEntryValues:[Ljava/lang/CharSequence;

    .line 18
    .line 19
    if-eqz v2, :cond_0

    .line 20
    .line 21
    if-eqz v3, :cond_0

    .line 22
    .line 23
    invoke-virtual {v1}, Ljava/util/HashSet;->clear()V

    .line 24
    .line 25
    .line 26
    iget-object v2, p1, Landroidx/preference/MultiSelectListPreference;->mValues:Ljava/util/HashSet;

    .line 27
    .line 28
    invoke-interface {v1, v2}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 29
    .line 30
    .line 31
    iput-boolean v0, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mPreferenceChanged:Z

    .line 32
    .line 33
    iget-object p1, p1, Landroidx/preference/MultiSelectListPreference;->mEntries:[Ljava/lang/CharSequence;

    .line 34
    .line 35
    iput-object p1, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mEntries:[Ljava/lang/CharSequence;

    .line 36
    .line 37
    iput-object v3, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mEntryValues:[Ljava/lang/CharSequence;

    .line 38
    .line 39
    return-void

    .line 40
    :cond_0
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 41
    .line 42
    const-string v0, "MultiSelectListPreference requires an entries array and an entryValues array."

    .line 43
    .line 44
    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 45
    .line 46
    .line 47
    throw p1

    .line 48
    :cond_1
    invoke-virtual {v1}, Ljava/util/HashSet;->clear()V

    .line 49
    .line 50
    .line 51
    const-string v2, "MultiSelectListPreferenceDialogFragmentCompat.values"

    .line 52
    .line 53
    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    .line 54
    .line 55
    .line 56
    move-result-object v2

    .line 57
    invoke-interface {v1, v2}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 58
    .line 59
    .line 60
    const-string v1, "MultiSelectListPreferenceDialogFragmentCompat.changed"

    .line 61
    .line 62
    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    .line 63
    .line 64
    .line 65
    move-result v0

    .line 66
    iput-boolean v0, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mPreferenceChanged:Z

    .line 67
    .line 68
    const-string v0, "MultiSelectListPreferenceDialogFragmentCompat.entries"

    .line 69
    .line 70
    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getCharSequenceArray(Ljava/lang/String;)[Ljava/lang/CharSequence;

    .line 71
    .line 72
    .line 73
    move-result-object v0

    .line 74
    iput-object v0, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mEntries:[Ljava/lang/CharSequence;

    .line 75
    .line 76
    const-string v0, "MultiSelectListPreferenceDialogFragmentCompat.entryValues"

    .line 77
    .line 78
    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getCharSequenceArray(Ljava/lang/String;)[Ljava/lang/CharSequence;

    .line 79
    .line 80
    .line 81
    move-result-object p1

    .line 82
    iput-object p1, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mEntryValues:[Ljava/lang/CharSequence;

    .line 83
    .line 84
    return-void
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

.method public final onDialogClosed(Z)V
    .locals 2

    .line 1
    if-eqz p1, :cond_0

    .line 2
    .line 3
    iget-boolean p1, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mPreferenceChanged:Z

    .line 4
    .line 5
    if-eqz p1, :cond_0

    .line 6
    .line 7
    invoke-virtual {p0}, Landroidx/preference/PreferenceDialogFragmentCompat;->getPreference()Landroidx/preference/DialogPreference;

    .line 8
    .line 9
    .line 10
    move-result-object p1

    .line 11
    check-cast p1, Landroidx/preference/MultiSelectListPreference;

    .line 12
    .line 13
    iget-object v0, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mNewValues:Ljava/util/HashSet;

    .line 14
    .line 15
    invoke-virtual {p1, v0}, Landroidx/preference/Preference;->callChangeListener(Ljava/io/Serializable;)Z

    .line 16
    .line 17
    .line 18
    move-result v1

    .line 19
    if-eqz v1, :cond_0

    .line 20
    .line 21
    invoke-virtual {p1, v0}, Landroidx/preference/MultiSelectListPreference;->setValues(Ljava/util/Set;)V

    .line 22
    .line 23
    .line 24
    :cond_0
    const/4 p1, 0x0

    .line 25
    iput-boolean p1, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mPreferenceChanged:Z

    .line 26
    .line 27
    return-void
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

.method public final onPrepareDialogBuilder(Lcom/android/billingclient/api/zzbv;)V
    .locals 5

    .line 1
    iget-object v0, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mEntryValues:[Ljava/lang/CharSequence;

    .line 2
    .line 3
    array-length v0, v0

    .line 4
    new-array v1, v0, [Z

    .line 5
    .line 6
    const/4 v2, 0x0

    .line 7
    :goto_0
    if-ge v2, v0, :cond_0

    .line 8
    .line 9
    iget-object v3, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mEntryValues:[Ljava/lang/CharSequence;

    .line 10
    .line 11
    aget-object v3, v3, v2

    .line 12
    .line 13
    invoke-interface {v3}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    .line 14
    .line 15
    .line 16
    move-result-object v3

    .line 17
    iget-object v4, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mNewValues:Ljava/util/HashSet;

    .line 18
    .line 19
    invoke-virtual {v4, v3}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    .line 20
    .line 21
    .line 22
    move-result v3

    .line 23
    aput-boolean v3, v1, v2

    .line 24
    .line 25
    add-int/lit8 v2, v2, 0x1

    .line 26
    .line 27
    goto :goto_0

    .line 28
    :cond_0
    iget-object v0, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mEntries:[Ljava/lang/CharSequence;

    .line 29
    .line 30
    new-instance v2, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat$1;

    .line 31
    .line 32
    invoke-direct {v2, p0}, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat$1;-><init>(Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;)V

    .line 33
    .line 34
    .line 35
    iget-object p1, p1, Lcom/android/billingclient/api/zzbv;->zza:Ljava/lang/Object;

    .line 36
    .line 37
    check-cast p1, Landroidx/appcompat/app/AlertController$AlertParams;

    .line 38
    .line 39
    iput-object v0, p1, Landroidx/appcompat/app/AlertController$AlertParams;->mItems:[Ljava/lang/CharSequence;

    .line 40
    .line 41
    iput-object v2, p1, Landroidx/appcompat/app/AlertController$AlertParams;->mOnCheckboxClickListener:Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat$1;

    .line 42
    .line 43
    iput-object v1, p1, Landroidx/appcompat/app/AlertController$AlertParams;->mCheckedItems:[Z

    .line 44
    .line 45
    const/4 v0, 0x1

    .line 46
    iput-boolean v0, p1, Landroidx/appcompat/app/AlertController$AlertParams;->mIsMultiChoice:Z

    .line 47
    .line 48
    return-void
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

.method public final onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .line 1
    invoke-super {p0, p1}, Landroidx/preference/PreferenceDialogFragmentCompat;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 2
    .line 3
    .line 4
    new-instance v0, Ljava/util/ArrayList;

    .line 5
    .line 6
    iget-object v1, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mNewValues:Ljava/util/HashSet;

    .line 7
    .line 8
    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 9
    .line 10
    .line 11
    const-string v1, "MultiSelectListPreferenceDialogFragmentCompat.values"

    .line 12
    .line 13
    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 14
    .line 15
    .line 16
    const-string v0, "MultiSelectListPreferenceDialogFragmentCompat.changed"

    .line 17
    .line 18
    iget-boolean v1, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mPreferenceChanged:Z

    .line 19
    .line 20
    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 21
    .line 22
    .line 23
    const-string v0, "MultiSelectListPreferenceDialogFragmentCompat.entries"

    .line 24
    .line 25
    iget-object v1, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mEntries:[Ljava/lang/CharSequence;

    .line 26
    .line 27
    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putCharSequenceArray(Ljava/lang/String;[Ljava/lang/CharSequence;)V

    .line 28
    .line 29
    .line 30
    const-string v0, "MultiSelectListPreferenceDialogFragmentCompat.entryValues"

    .line 31
    .line 32
    iget-object v1, p0, Landroidx/preference/MultiSelectListPreferenceDialogFragmentCompat;->mEntryValues:[Ljava/lang/CharSequence;

    .line 33
    .line 34
    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putCharSequenceArray(Ljava/lang/String;[Ljava/lang/CharSequence;)V

    .line 35
    .line 36
    .line 37
    return-void
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
