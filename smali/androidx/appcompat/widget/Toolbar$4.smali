.class public final Landroidx/appcompat/widget/Toolbar$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field public final synthetic $r8$classId:I

.field public final synthetic this$0:Ljava/lang/Object;


# direct methods
.method public synthetic constructor <init>(ILjava/lang/Object;)V
    .locals 0

    .line 1
    iput p1, p0, Landroidx/appcompat/widget/Toolbar$4;->$r8$classId:I

    iput-object p2, p0, Landroidx/appcompat/widget/Toolbar$4;->this$0:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 5

    .line 1
    iget v0, p0, Landroidx/appcompat/widget/Toolbar$4;->$r8$classId:I

    .line 2
    .line 3
    packed-switch v0, :pswitch_data_0

    .line 4
    .line 5
    .line 6
    check-cast p1, Lcom/google/android/material/internal/NavigationMenuItemView;

    .line 7
    .line 8
    iget-object v0, p0, Landroidx/appcompat/widget/Toolbar$4;->this$0:Ljava/lang/Object;

    .line 9
    .line 10
    check-cast v0, Lcom/google/android/material/internal/NavigationMenuPresenter;

    .line 11
    .line 12
    iget-object v1, v0, Lcom/google/android/material/internal/NavigationMenuPresenter;->adapter:Lcom/google/android/material/internal/NavigationMenuPresenter$NavigationMenuAdapter;

    .line 13
    .line 14
    const/4 v2, 0x1

    .line 15
    if-eqz v1, :cond_0

    .line 16
    .line 17
    iput-boolean v2, v1, Lcom/google/android/material/internal/NavigationMenuPresenter$NavigationMenuAdapter;->updateSuspended:Z

    .line 18
    .line 19
    :cond_0
    invoke-virtual {p1}, Lcom/google/android/material/internal/NavigationMenuItemView;->getItemData()Landroidx/appcompat/view/menu/MenuItemImpl;

    .line 20
    .line 21
    .line 22
    move-result-object p1

    .line 23
    iget-object v1, v0, Lcom/google/android/material/internal/NavigationMenuPresenter;->menu:Landroidx/appcompat/view/menu/MenuBuilder;

    .line 24
    .line 25
    const/4 v3, 0x0

    .line 26
    invoke-virtual {v1, p1, v0, v3}, Landroidx/appcompat/view/menu/MenuBuilder;->performItemAction(Landroid/view/MenuItem;Landroidx/appcompat/view/menu/MenuPresenter;I)Z

    .line 27
    .line 28
    .line 29
    move-result v1

    .line 30
    if-eqz p1, :cond_1

    .line 31
    .line 32
    invoke-virtual {p1}, Landroidx/appcompat/view/menu/MenuItemImpl;->isCheckable()Z

    .line 33
    .line 34
    .line 35
    move-result v4

    .line 36
    if-eqz v4, :cond_1

    .line 37
    .line 38
    if-eqz v1, :cond_1

    .line 39
    .line 40
    iget-object v1, v0, Lcom/google/android/material/internal/NavigationMenuPresenter;->adapter:Lcom/google/android/material/internal/NavigationMenuPresenter$NavigationMenuAdapter;

    .line 41
    .line 42
    invoke-virtual {v1, p1}, Lcom/google/android/material/internal/NavigationMenuPresenter$NavigationMenuAdapter;->setCheckedItem(Landroidx/appcompat/view/menu/MenuItemImpl;)V

    .line 43
    .line 44
    .line 45
    goto :goto_0

    .line 46
    :cond_1
    const/4 v2, 0x0

    .line 47
    :goto_0
    iget-object p1, v0, Lcom/google/android/material/internal/NavigationMenuPresenter;->adapter:Lcom/google/android/material/internal/NavigationMenuPresenter$NavigationMenuAdapter;

    .line 48
    .line 49
    if-eqz p1, :cond_2

    .line 50
    .line 51
    iput-boolean v3, p1, Lcom/google/android/material/internal/NavigationMenuPresenter$NavigationMenuAdapter;->updateSuspended:Z

    .line 52
    .line 53
    :cond_2
    if-eqz v2, :cond_3

    .line 54
    .line 55
    invoke-virtual {v0}, Lcom/google/android/material/internal/NavigationMenuPresenter;->updateMenuView()V

    .line 56
    .line 57
    .line 58
    :cond_3
    return-void

    .line 59
    :pswitch_0
    iget-object p1, p0, Landroidx/appcompat/widget/Toolbar$4;->this$0:Ljava/lang/Object;

    .line 60
    .line 61
    check-cast p1, Lcom/google/android/material/datepicker/MaterialCalendar;

    .line 62
    .line 63
    iget v0, p1, Lcom/google/android/material/datepicker/MaterialCalendar;->calendarSelector:I

    .line 64
    .line 65
    const/4 v1, 0x1

    .line 66
    const/4 v2, 0x2

    .line 67
    if-ne v0, v2, :cond_4

    .line 68
    .line 69
    invoke-virtual {p1, v1}, Lcom/google/android/material/datepicker/MaterialCalendar;->setSelector$1(I)V

    .line 70
    .line 71
    .line 72
    iget-object v0, p1, Lcom/google/android/material/datepicker/MaterialCalendar;->recyclerView:Landroidx/recyclerview/widget/RecyclerView;

    .line 73
    .line 74
    const v1, 0x7f1401ee

    .line 75
    .line 76
    .line 77
    invoke-virtual {p1, v1}, Landroidx/fragment/app/Fragment;->getString(I)Ljava/lang/String;

    .line 78
    .line 79
    .line 80
    move-result-object p1

    .line 81
    invoke-virtual {v0, p1}, Landroid/view/View;->announceForAccessibility(Ljava/lang/CharSequence;)V

    .line 82
    .line 83
    .line 84
    goto :goto_1

    .line 85
    :cond_4
    if-ne v0, v1, :cond_5

    .line 86
    .line 87
    invoke-virtual {p1, v2}, Lcom/google/android/material/datepicker/MaterialCalendar;->setSelector$1(I)V

    .line 88
    .line 89
    .line 90
    iget-object v0, p1, Lcom/google/android/material/datepicker/MaterialCalendar;->yearSelector:Landroidx/recyclerview/widget/RecyclerView;

    .line 91
    .line 92
    const v1, 0x7f1401ef

    .line 93
    .line 94
    .line 95
    invoke-virtual {p1, v1}, Landroidx/fragment/app/Fragment;->getString(I)Ljava/lang/String;

    .line 96
    .line 97
    .line 98
    move-result-object p1

    .line 99
    invoke-virtual {v0, p1}, Landroid/view/View;->announceForAccessibility(Ljava/lang/CharSequence;)V

    .line 100
    .line 101
    .line 102
    :cond_5
    :goto_1
    return-void

    .line 103
    :pswitch_1
    iget-object p1, p0, Landroidx/appcompat/widget/Toolbar$4;->this$0:Ljava/lang/Object;

    .line 104
    .line 105
    check-cast p1, Landroidx/appcompat/view/ActionMode;

    .line 106
    .line 107
    invoke-virtual {p1}, Landroidx/appcompat/view/ActionMode;->finish()V

    .line 108
    .line 109
    .line 110
    return-void

    .line 111
    :pswitch_2
    iget-object v0, p0, Landroidx/appcompat/widget/Toolbar$4;->this$0:Ljava/lang/Object;

    .line 112
    .line 113
    check-cast v0, Landroidx/appcompat/app/AlertController;

    .line 114
    .line 115
    iget-object v1, v0, Landroidx/appcompat/app/AlertController;->mButtonPositive:Landroid/widget/Button;

    .line 116
    .line 117
    if-ne p1, v1, :cond_6

    .line 118
    .line 119
    iget-object v1, v0, Landroidx/appcompat/app/AlertController;->mButtonPositiveMessage:Landroid/os/Message;

    .line 120
    .line 121
    if-eqz v1, :cond_6

    .line 122
    .line 123
    invoke-static {v1}, Landroid/os/Message;->obtain(Landroid/os/Message;)Landroid/os/Message;

    .line 124
    .line 125
    .line 126
    move-result-object p1

    .line 127
    goto :goto_2

    .line 128
    :cond_6
    iget-object v1, v0, Landroidx/appcompat/app/AlertController;->mButtonNegative:Landroid/widget/Button;

    .line 129
    .line 130
    if-ne p1, v1, :cond_7

    .line 131
    .line 132
    iget-object v1, v0, Landroidx/appcompat/app/AlertController;->mButtonNegativeMessage:Landroid/os/Message;

    .line 133
    .line 134
    if-eqz v1, :cond_7

    .line 135
    .line 136
    invoke-static {v1}, Landroid/os/Message;->obtain(Landroid/os/Message;)Landroid/os/Message;

    .line 137
    .line 138
    .line 139
    move-result-object p1

    .line 140
    goto :goto_2

    .line 141
    :cond_7
    iget-object v1, v0, Landroidx/appcompat/app/AlertController;->mButtonNeutral:Landroid/widget/Button;

    .line 142
    .line 143
    if-ne p1, v1, :cond_8

    .line 144
    .line 145
    iget-object p1, v0, Landroidx/appcompat/app/AlertController;->mButtonNeutralMessage:Landroid/os/Message;

    .line 146
    .line 147
    if-eqz p1, :cond_8

    .line 148
    .line 149
    invoke-static {p1}, Landroid/os/Message;->obtain(Landroid/os/Message;)Landroid/os/Message;

    .line 150
    .line 151
    .line 152
    move-result-object p1

    .line 153
    goto :goto_2

    .line 154
    :cond_8
    const/4 p1, 0x0

    .line 155
    :goto_2
    if-eqz p1, :cond_9

    .line 156
    .line 157
    invoke-virtual {p1}, Landroid/os/Message;->sendToTarget()V

    .line 158
    .line 159
    .line 160
    :cond_9
    iget-object p1, v0, Landroidx/appcompat/app/AlertController;->mHandler:Landroidx/preference/PreferenceFragmentCompat$1;

    .line 161
    .line 162
    const/4 v1, 0x1

    .line 163
    iget-object v0, v0, Landroidx/appcompat/app/AlertController;->mDialog:Landroidx/appcompat/app/AlertDialog;

    .line 164
    .line 165
    invoke-virtual {p1, v1, v0}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    .line 166
    .line 167
    .line 168
    move-result-object p1

    .line 169
    invoke-virtual {p1}, Landroid/os/Message;->sendToTarget()V

    .line 170
    .line 171
    .line 172
    return-void

    .line 173
    :pswitch_3
    iget-object p1, p0, Landroidx/appcompat/widget/Toolbar$4;->this$0:Ljava/lang/Object;

    .line 174
    .line 175
    check-cast p1, Landroidx/appcompat/app/ActionBarDrawerToggle;

    .line 176
    .line 177
    iget-object p1, p1, Landroidx/appcompat/app/ActionBarDrawerToggle;->mDrawerLayout:Landroidx/drawerlayout/widget/DrawerLayout;

    .line 178
    .line 179
    const v0, 0x800003

    .line 180
    .line 181
    .line 182
    invoke-virtual {p1, v0}, Landroidx/drawerlayout/widget/DrawerLayout;->getDrawerLockMode(I)I

    .line 183
    .line 184
    .line 185
    move-result v1

    .line 186
    invoke-virtual {p1, v0}, Landroidx/drawerlayout/widget/DrawerLayout;->findDrawerWithGravity(I)Landroid/view/View;

    .line 187
    .line 188
    .line 189
    move-result-object v2

    .line 190
    if-eqz v2, :cond_a

    .line 191
    .line 192
    invoke-static {v2}, Landroidx/drawerlayout/widget/DrawerLayout;->isDrawerVisible(Landroid/view/View;)Z

    .line 193
    .line 194
    .line 195
    move-result v2

    .line 196
    goto :goto_3

    .line 197
    :cond_a
    const/4 v2, 0x0

    .line 198
    :goto_3
    if-eqz v2, :cond_b

    .line 199
    .line 200
    const/4 v2, 0x2

    .line 201
    if-eq v1, v2, :cond_b

    .line 202
    .line 203
    invoke-virtual {p1}, Landroidx/drawerlayout/widget/DrawerLayout;->closeDrawer$2()V

    .line 204
    .line 205
    .line 206
    goto :goto_4

    .line 207
    :cond_b
    const/4 v2, 0x1

    .line 208
    if-eq v1, v2, :cond_d

    .line 209
    .line 210
    invoke-virtual {p1, v0}, Landroidx/drawerlayout/widget/DrawerLayout;->findDrawerWithGravity(I)Landroid/view/View;

    .line 211
    .line 212
    .line 213
    move-result-object v1

    .line 214
    if-eqz v1, :cond_c

    .line 215
    .line 216
    invoke-virtual {p1, v1}, Landroidx/drawerlayout/widget/DrawerLayout;->openDrawer(Landroid/view/View;)V

    .line 217
    .line 218
    .line 219
    goto :goto_4

    .line 220
    :cond_c
    new-instance p1, Ljava/lang/IllegalArgumentException;

    .line 221
    .line 222
    new-instance v1, Ljava/lang/StringBuilder;

    .line 223
    .line 224
    const-string v2, "No drawer view found with gravity "

    .line 225
    .line 226
    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 227
    .line 228
    .line 229
    invoke-static {v0}, Landroidx/drawerlayout/widget/DrawerLayout;->gravityToString(I)Ljava/lang/String;

    .line 230
    .line 231
    .line 232
    move-result-object v0

    .line 233
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 234
    .line 235
    .line 236
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 237
    .line 238
    .line 239
    move-result-object v0

    .line 240
    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 241
    .line 242
    .line 243
    throw p1

    .line 244
    :cond_d
    :goto_4
    return-void

    .line 245
    :pswitch_4
    iget-object p1, p0, Landroidx/appcompat/widget/Toolbar$4;->this$0:Ljava/lang/Object;

    .line 246
    .line 247
    check-cast p1, Landroidx/appcompat/widget/Toolbar;

    .line 248
    .line 249
    iget-object p1, p1, Landroidx/appcompat/widget/Toolbar;->mExpandedMenuPresenter:Landroidx/appcompat/widget/Toolbar$ExpandedActionViewMenuPresenter;

    .line 250
    .line 251
    if-nez p1, :cond_e

    .line 252
    .line 253
    const/4 p1, 0x0

    .line 254
    goto :goto_5

    .line 255
    :cond_e
    iget-object p1, p1, Landroidx/appcompat/widget/Toolbar$ExpandedActionViewMenuPresenter;->mCurrentExpandedItem:Landroidx/appcompat/view/menu/MenuItemImpl;

    .line 256
    .line 257
    :goto_5
    if-eqz p1, :cond_f

    .line 258
    .line 259
    invoke-virtual {p1}, Landroidx/appcompat/view/menu/MenuItemImpl;->collapseActionView()Z

    .line 260
    .line 261
    .line 262
    :cond_f
    return-void

    .line 263
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
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
