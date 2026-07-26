package androidx.emoji2.text;

import android.content.Context;
import android.graphics.Typeface;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.collection.internal.Lock;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.util.Pools$SimplePool;
import androidx.core.util.TimeUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.emoji2.text.flatbuffer.MetadataList;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider$1;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Executor;
import javax.inject.Provider;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class MetadataRepo implements ActionMode.Callback, Factory {
    public Object mEmojiCharArray;
    public Object mMetadataList;
    public Object mRootNode;
    public Object mTypeface;

    /* loaded from: classes.dex */
    public final class Node {
        public final SparseArray mChildren;
        public TypefaceEmojiRasterizer mData;

        public Node(int i) {
            this.mChildren = new SparseArray(i);
        }

        public final void put(TypefaceEmojiRasterizer typefaceEmojiRasterizer, int i, int i2) {
            Node node;
            int codepointAt = typefaceEmojiRasterizer.getCodepointAt(i);
            SparseArray sparseArray = this.mChildren;
            if (sparseArray == null) {
                node = null;
            } else {
                node = (Node) sparseArray.get(codepointAt);
            }
            if (node == null) {
                node = new Node(1);
                sparseArray.put(typefaceEmojiRasterizer.getCodepointAt(i), node);
            }
            if (i2 > i) {
                node.put(typefaceEmojiRasterizer, i + 1, i2);
            } else {
                node.mData = typefaceEmojiRasterizer;
            }
        }
    }

    public /* synthetic */ MetadataRepo(Object obj, Object obj2, Object obj3, Object obj4) {
        this.mMetadataList = obj;
        this.mEmojiCharArray = obj2;
        this.mRootNode = obj3;
        this.mTypeface = obj4;
    }

    public void dfs(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (!arrayList.contains(obj)) {
            if (!hashSet.contains(obj)) {
                hashSet.add(obj);
                ArrayList arrayList2 = (ArrayList) ((SimpleArrayMap) this.mEmojiCharArray).get(obj);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        dfs(arrayList2.get(i), arrayList, hashSet);
                    }
                }
                hashSet.remove(obj);
                arrayList.add(obj);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new MetadataRepo((Executor) ((Provider) this.mMetadataList).get(), (EventStore) ((Provider) this.mEmojiCharArray).get(), (MatcherMatchResult) ((MatcherMatchResult) this.mRootNode).get(), (SynchronizationGuard) ((Provider) this.mTypeface).get());
    }

    public SupportActionModeWrapper getActionModeWrapper(ActionMode actionMode) {
        ArrayList arrayList = (ArrayList) this.mRootNode;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            SupportActionModeWrapper supportActionModeWrapper = (SupportActionModeWrapper) arrayList.get(i);
            if (supportActionModeWrapper != null && supportActionModeWrapper.mWrappedObject == actionMode) {
                return supportActionModeWrapper;
            }
        }
        SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper((Context) this.mEmojiCharArray, actionMode);
        arrayList.add(supportActionModeWrapper2);
        return supportActionModeWrapper2;
    }

    public ViewModel getViewModel$lifecycle_viewmodel_release(ClassReference classReference, String key) {
        ViewModel viewModel;
        ViewModel create;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (((Lock) this.mTypeface)) {
            try {
                ViewModelStore viewModelStore = (ViewModelStore) this.mMetadataList;
                viewModelStore.getClass();
                viewModel = (ViewModel) viewModelStore.map.get(key);
                if (classReference.isInstance(viewModel)) {
                    ViewModelProvider.Factory factory = (ViewModelProvider.Factory) this.mEmojiCharArray;
                    if (factory instanceof SavedStateViewModelFactory) {
                        SavedStateViewModelFactory savedStateViewModelFactory = (SavedStateViewModelFactory) factory;
                        Intrinsics.checkNotNull(viewModel);
                        Lifecycle lifecycle = savedStateViewModelFactory.lifecycle;
                        if (lifecycle != null) {
                            SavedStateRegistry savedStateRegistry = savedStateViewModelFactory.savedStateRegistry;
                            Intrinsics.checkNotNull(savedStateRegistry);
                            SavedStateHandleSupport.attachHandleIfNeeded(viewModel, savedStateRegistry, lifecycle);
                        }
                    }
                    Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.ViewModelProviderImpl.getViewModel");
                } else {
                    MutableCreationExtras mutableCreationExtras = new MutableCreationExtras((CreationExtras) this.mRootNode);
                    mutableCreationExtras.extras.put(ViewModelProvider.VIEW_MODEL_KEY, key);
                    ViewModelProvider.Factory factory2 = (ViewModelProvider.Factory) this.mEmojiCharArray;
                    Intrinsics.checkNotNullParameter(factory2, "factory");
                    try {
                        try {
                            create = factory2.create(classReference, mutableCreationExtras);
                        } catch (AbstractMethodError unused) {
                            create = factory2.create(RangesKt.getJavaClass(classReference));
                        }
                    } catch (AbstractMethodError unused2) {
                        create = factory2.create(RangesKt.getJavaClass(classReference), mutableCreationExtras);
                    }
                    viewModel = create;
                    ViewModelStore viewModelStore2 = (ViewModelStore) this.mMetadataList;
                    viewModelStore2.getClass();
                    Intrinsics.checkNotNullParameter(viewModel, "viewModel");
                    ViewModel viewModel2 = (ViewModel) viewModelStore2.map.put(key, viewModel);
                    if (viewModel2 != null) {
                        viewModel2.clear$lifecycle_viewmodel_release();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return viewModel;
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return ((ActionMode.Callback) this.mMetadataList).onActionItemClicked(getActionModeWrapper(actionMode), new MenuItemWrapperICS((Context) this.mEmojiCharArray, (SupportMenuItem) menuItem));
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onCreateActionMode(androidx.appcompat.view.ActionMode actionMode, Menu menu) {
        ActionMode.Callback callback = (ActionMode.Callback) this.mMetadataList;
        SupportActionModeWrapper actionModeWrapper = getActionModeWrapper(actionMode);
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.mTypeface;
        Menu menu2 = (Menu) simpleArrayMap.get(menu);
        if (menu2 == null) {
            menu2 = new MenuWrapperICS((Context) this.mEmojiCharArray, (MenuBuilder) menu);
            simpleArrayMap.put(menu, menu2);
        }
        return callback.onCreateActionMode(actionModeWrapper, menu2);
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public void onDestroyActionMode(androidx.appcompat.view.ActionMode actionMode) {
        ((ActionMode.Callback) this.mMetadataList).onDestroyActionMode(getActionModeWrapper(actionMode));
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onPrepareActionMode(androidx.appcompat.view.ActionMode actionMode, Menu menu) {
        ActionMode.Callback callback = (ActionMode.Callback) this.mMetadataList;
        SupportActionModeWrapper actionModeWrapper = getActionModeWrapper(actionMode);
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.mTypeface;
        Menu menu2 = (Menu) simpleArrayMap.get(menu);
        if (menu2 == null) {
            menu2 = new MenuWrapperICS((Context) this.mEmojiCharArray, (MenuBuilder) menu);
            simpleArrayMap.put(menu, menu2);
        }
        return callback.onPrepareActionMode(actionModeWrapper, menu2);
    }

    public void updatePageAccessibilityActions() {
        int itemCount;
        int i;
        ViewPager2$PageAwareAccessibilityProvider$1 viewPager2$PageAwareAccessibilityProvider$1 = (ViewPager2$PageAwareAccessibilityProvider$1) this.mEmojiCharArray;
        ViewPager2$PageAwareAccessibilityProvider$1 viewPager2$PageAwareAccessibilityProvider$12 = (ViewPager2$PageAwareAccessibilityProvider$1) this.mMetadataList;
        ViewPager2 viewPager2 = (ViewPager2) this.mTypeface;
        int i2 = 16908360;
        ViewCompat.removeActionWithId(16908360, viewPager2);
        boolean z = false;
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(0, viewPager2);
        ViewCompat.removeActionWithId(16908361, viewPager2);
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(0, viewPager2);
        ViewCompat.removeActionWithId(16908358, viewPager2);
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(0, viewPager2);
        ViewCompat.removeActionWithId(16908359, viewPager2);
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(0, viewPager2);
        if (viewPager2.getAdapter() != null && (itemCount = viewPager2.getAdapter().getItemCount()) != 0 && viewPager2.mUserInputEnabled) {
            if (viewPager2.getOrientation() == 0) {
                if (viewPager2.mLayoutManager.getLayoutDirection() == 1) {
                    z = true;
                }
                if (z) {
                    i = 16908360;
                } else {
                    i = 16908361;
                }
                if (z) {
                    i2 = 16908361;
                }
                if (viewPager2.mCurrentItem < itemCount - 1) {
                    ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i, (String) null), viewPager2$PageAwareAccessibilityProvider$12);
                }
                if (viewPager2.mCurrentItem > 0) {
                    ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i2, (String) null), viewPager2$PageAwareAccessibilityProvider$1);
                    return;
                }
                return;
            }
            if (viewPager2.mCurrentItem < itemCount - 1) {
                ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908359, (String) null), viewPager2$PageAwareAccessibilityProvider$12);
            }
            if (viewPager2.mCurrentItem > 0) {
                ViewCompat.replaceAccessibilityAction(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908358, (String) null), viewPager2$PageAwareAccessibilityProvider$1);
            }
        }
    }

    public MetadataRepo(ViewModelStore store, ViewModelProvider.Factory factory, CreationExtras defaultExtras) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(defaultExtras, "defaultExtras");
        this.mMetadataList = store;
        this.mEmojiCharArray = factory;
        this.mRootNode = defaultExtras;
        this.mTypeface = new Object();
    }

    public MetadataRepo(int i) {
        switch (i) {
            case 4:
                this.mMetadataList = new SimpleArrayMap(0);
                this.mEmojiCharArray = new SparseArray();
                this.mRootNode = new LongSparseArray();
                this.mTypeface = new SimpleArrayMap(0);
                return;
            default:
                this.mMetadataList = new Pools$SimplePool(10);
                this.mEmojiCharArray = new SimpleArrayMap(0);
                this.mRootNode = new ArrayList();
                this.mTypeface = new HashSet();
                return;
        }
    }

    public MetadataRepo(Typeface typeface, MetadataList metadataList) {
        int i;
        int i2;
        int i3;
        int i4;
        this.mTypeface = typeface;
        this.mMetadataList = metadataList;
        this.mRootNode = new Node(1024);
        int __offset = metadataList.__offset(6);
        if (__offset != 0) {
            int i5 = __offset + metadataList.bb_pos;
            i = ((ByteBuffer) metadataList.f9bb).getInt(((ByteBuffer) metadataList.f9bb).getInt(i5) + i5);
        } else {
            i = 0;
        }
        this.mEmojiCharArray = new char[i * 2];
        int __offset2 = metadataList.__offset(6);
        if (__offset2 != 0) {
            int i6 = __offset2 + metadataList.bb_pos;
            i2 = ((ByteBuffer) metadataList.f9bb).getInt(((ByteBuffer) metadataList.f9bb).getInt(i6) + i6);
        } else {
            i2 = 0;
        }
        for (int i7 = 0; i7 < i2; i7++) {
            TypefaceEmojiRasterizer typefaceEmojiRasterizer = new TypefaceEmojiRasterizer(this, i7);
            MetadataItem metadataItem = typefaceEmojiRasterizer.getMetadataItem();
            int __offset3 = metadataItem.__offset(4);
            Character.toChars(__offset3 != 0 ? ((ByteBuffer) metadataItem.f9bb).getInt(__offset3 + metadataItem.bb_pos) : 0, (char[]) this.mEmojiCharArray, i7 * 2);
            MetadataItem metadataItem2 = typefaceEmojiRasterizer.getMetadataItem();
            int __offset4 = metadataItem2.__offset(16);
            if (__offset4 != 0) {
                int i8 = __offset4 + metadataItem2.bb_pos;
                i3 = ((ByteBuffer) metadataItem2.f9bb).getInt(((ByteBuffer) metadataItem2.f9bb).getInt(i8) + i8);
            } else {
                i3 = 0;
            }
            TimeUtils.checkArgument("invalid metadata codepoint length", i3 > 0);
            Node node = (Node) this.mRootNode;
            MetadataItem metadataItem3 = typefaceEmojiRasterizer.getMetadataItem();
            int __offset5 = metadataItem3.__offset(16);
            if (__offset5 != 0) {
                int i9 = __offset5 + metadataItem3.bb_pos;
                i4 = ((ByteBuffer) metadataItem3.f9bb).getInt(((ByteBuffer) metadataItem3.f9bb).getInt(i9) + i9);
            } else {
                i4 = 0;
            }
            node.put(typefaceEmojiRasterizer, 0, i4 - 1);
        }
    }

    public MetadataRepo(Context context, ActionMode.Callback callback) {
        this.mEmojiCharArray = context;
        this.mMetadataList = callback;
        this.mRootNode = new ArrayList();
        this.mTypeface = new SimpleArrayMap(0);
    }
}
