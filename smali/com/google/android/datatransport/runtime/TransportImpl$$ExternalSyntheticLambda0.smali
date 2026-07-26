.class public final synthetic Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroidx/preference/Preference$OnPreferenceChangeListener;
.implements Landroidx/core/view/OnApplyWindowInsetsListener;
.implements Lcom/google/android/material/slider/LabelFormatter;
.implements Lcom/google/android/datatransport/runtime/scheduling/persistence/SQLiteEventStore$Function;
.implements Lcom/google/android/material/textfield/TextInputLayout$LengthCounter;
.implements Lcom/google/gson/internal/ObjectConstructor;


# instance fields
.field public final synthetic $r8$classId:I


# direct methods
.method public synthetic constructor <init>(I)V
    .locals 0

    .line 1
    iput p1, p0, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;->$r8$classId:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static bridge synthetic m(Landroid/content/res/Configuration;)I
    .locals 0

    .line 1
    iget p0, p0, Landroid/content/res/Configuration;->fontWeightAdjustment:I

    return p0
.end method


# virtual methods
.method public apply(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4

    .line 1
    check-cast p1, Landroid/database/sqlite/SQLiteDatabase;

    .line 2
    .line 3
    const/4 v0, 0x0

    .line 4
    new-array v1, v0, [Ljava/lang/String;

    .line 5
    .line 6
    const-string v2, "SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id"

    .line 7
    .line 8
    invoke-virtual {p1, v2, v1}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    .line 9
    .line 10
    .line 11
    move-result-object p1

    .line 12
    :try_start_0
    new-instance v1, Ljava/util/ArrayList;

    .line 13
    .line 14
    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 15
    .line 16
    .line 17
    :goto_0
    invoke-interface {p1}, Landroid/database/Cursor;->moveToNext()Z

    .line 18
    .line 19
    .line 20
    move-result v2

    .line 21
    if-eqz v2, :cond_1

    .line 22
    .line 23
    invoke-static {}, Lcom/google/android/datatransport/runtime/AutoValue_TransportContext;->builder()Lkotlin/text/MatcherMatchResult;

    .line 24
    .line 25
    .line 26
    move-result-object v2

    .line 27
    const/4 v3, 0x1

    .line 28
    invoke-interface {p1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    .line 29
    .line 30
    .line 31
    move-result-object v3

    .line 32
    invoke-virtual {v2, v3}, Lkotlin/text/MatcherMatchResult;->setBackendName(Ljava/lang/String;)V

    .line 33
    .line 34
    .line 35
    const/4 v3, 0x2

    .line 36
    invoke-interface {p1, v3}, Landroid/database/Cursor;->getInt(I)I

    .line 37
    .line 38
    .line 39
    move-result v3

    .line 40
    invoke-static {v3}, Lcom/google/android/datatransport/runtime/util/PriorityMapping;->valueOf(I)Lcom/google/android/datatransport/Priority;

    .line 41
    .line 42
    .line 43
    move-result-object v3

    .line 44
    iput-object v3, v2, Lkotlin/text/MatcherMatchResult;->groups:Ljava/lang/Object;

    .line 45
    .line 46
    const/4 v3, 0x3

    .line 47
    invoke-interface {p1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    .line 48
    .line 49
    .line 50
    move-result-object v3

    .line 51
    if-nez v3, :cond_0

    .line 52
    .line 53
    const/4 v3, 0x0

    .line 54
    goto :goto_1

    .line 55
    :cond_0
    invoke-static {v3, v0}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    .line 56
    .line 57
    .line 58
    move-result-object v3

    .line 59
    :goto_1
    iput-object v3, v2, Lkotlin/text/MatcherMatchResult;->input:Ljava/lang/Object;

    .line 60
    .line 61
    invoke-virtual {v2}, Lkotlin/text/MatcherMatchResult;->build()Lcom/google/android/datatransport/runtime/AutoValue_TransportContext;

    .line 62
    .line 63
    .line 64
    move-result-object v2

    .line 65
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 66
    .line 67
    .line 68
    goto :goto_0

    .line 69
    :cond_1
    invoke-interface {p1}, Landroid/database/Cursor;->close()V

    .line 70
    .line 71
    .line 72
    return-object v1

    .line 73
    :catchall_0
    move-exception v0

    .line 74
    invoke-interface {p1}, Landroid/database/Cursor;->close()V

    .line 75
    .line 76
    .line 77
    throw v0
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

.method public construct()Ljava/lang/Object;
    .locals 2

    .line 1
    iget v0, p0, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    new-instance v0, Ljava/util/LinkedHashMap;

    .line 7
    .line 8
    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    .line 9
    .line 10
    .line 11
    return-object v0

    .line 12
    :pswitch_0
    new-instance v0, Lcom/google/gson/internal/LinkedTreeMap;

    .line 13
    .line 14
    const/4 v1, 0x1

    .line 15
    invoke-direct {v0, v1}, Lcom/google/gson/internal/LinkedTreeMap;-><init>(Z)V

    .line 16
    .line 17
    .line 18
    return-object v0

    .line 19
    :pswitch_data_0
    .packed-switch 0x1c
        :pswitch_0
    .end packed-switch
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

.method public getFormattedValue(F)Ljava/lang/String;
    .locals 1

    .line 1
    iget v0, p0, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;->$r8$classId:I

    packed-switch v0, :pswitch_data_0

    invoke-static {p1}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$CDk2PIljtaBpyPQm-8gz2JUzkdA(F)Ljava/lang/String;

    move-result-object p1

    return-object p1

    :pswitch_0
    invoke-static {p1}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->$r8$lambda$fKYnJ451oMZJyWojKShO-4j93LM(F)Ljava/lang/String;

    move-result-object p1

    return-object p1

    nop

    :pswitch_data_0
    .packed-switch 0x6
        :pswitch_0
    .end packed-switch
.end method

.method public onApplyWindowInsets(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;
    .locals 1

    .line 1
    iget v0, p0, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;->$r8$classId:I

    sparse-switch v0, :sswitch_data_0

    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;->$r8$lambda$OwLbCGxZ8_Bbp_n3KM82qLzqFSY(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    move-result-object p1

    return-object p1

    :sswitch_0
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/views/EmptyRecyclerView;->$r8$lambda$MruLK7rALgKJYgSmsSFDz1-d6dY(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    move-result-object p1

    return-object p1

    :sswitch_1
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/fragments/LogviewFragment;->$r8$lambda$G3Ife5gsm7t32EW1pwirttfTG4A(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    move-result-object p1

    return-object p1

    :sswitch_2
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/fragments/HttpPayloadFragment;->$r8$lambda$xTpBBe-8VLofzBvAOHFBeyPbLvo(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    move-result-object p1

    return-object p1

    :sswitch_3
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/fragments/HttpLogFragment;->$r8$lambda$bScUgZQuxxcWQxZukoQB6ykL5x4(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    move-result-object p1

    return-object p1

    :sswitch_4
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/fragments/ConnectionsFragment;->$r8$lambda$-jPZzyYkl4_haGqIqyD4qt0rzqA(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    move-result-object p1

    return-object p1

    :sswitch_5
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/fragments/ConnectionPayload;->$r8$lambda$wY-rKVQuBcJzKYqDeHLMD1K9uz8(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    move-result-object p1

    return-object p1

    :sswitch_6
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/fragments/AppOverview;->$r8$lambda$wcMMKnz0dLIl4aH5DuWWLgtA-L8(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;

    move-result-object p1

    return-object p1

    nop

    :sswitch_data_0
    .sparse-switch
        0x4 -> :sswitch_6
        0x5 -> :sswitch_5
        0x7 -> :sswitch_4
        0x9 -> :sswitch_3
        0xa -> :sswitch_2
        0xb -> :sswitch_1
        0x12 -> :sswitch_0
    .end sparse-switch
.end method

.method public onPreferenceChange(Landroidx/preference/Preference;Ljava/lang/Object;)Z
    .locals 1

    .line 1
    iget v0, p0, Lcom/google/android/datatransport/runtime/TransportImpl$$ExternalSyntheticLambda0;->$r8$classId:I

    sparse-switch v0, :sswitch_data_0

    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/fragments/prefs/Socks5Settings;->$r8$lambda$m3C7kkMujGH7YXTu-2cYpTAtZXo(Landroidx/preference/Preference;Ljava/lang/Object;)Z

    move-result p1

    return p1

    :sswitch_0
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/fragments/prefs/Socks5Settings;->$r8$lambda$TKhh3V9pYhHxFZyMOcdvR2EilLs(Landroidx/preference/Preference;Ljava/lang/Object;)Z

    move-result p1

    return p1

    :sswitch_1
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/fragments/prefs/DnsSettings;->$r8$lambda$MHpgqMC8TyMJmqjdm4rnmzwhQsY(Landroidx/preference/Preference;Ljava/lang/Object;)Z

    move-result p1

    return p1

    :sswitch_2
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/fragments/prefs/DnsSettings;->$r8$lambda$ItTbOMEq3mUJk6wq9AHGxHKAYm8(Landroidx/preference/Preference;Ljava/lang/Object;)Z

    move-result p1

    return p1

    :sswitch_3
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->$r8$lambda$Ckj973tKI8pdA6JORvOYSCm3Oa4(Landroidx/preference/Preference;Ljava/lang/Object;)Z

    move-result p1

    return p1

    :sswitch_4
    invoke-static {p1, p2}, Lcom/emanuelef/remote_capture/activities/prefs/SettingsActivity$SettingsFragment;->$r8$lambda$PbMCzki4re8azfkphSYphxIcBtU(Landroidx/preference/Preference;Ljava/lang/Object;)Z

    move-result p1

    return p1

    nop

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_4
        0x2 -> :sswitch_3
        0xc -> :sswitch_2
        0xd -> :sswitch_1
        0xe -> :sswitch_0
    .end sparse-switch
.end method
