package androidx.cursoradapter.widget;

import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.SuggestionsAdapter;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.tabs.TabLayout;
/* loaded from: classes.dex */
public abstract class CursorAdapter extends BaseAdapter implements Filterable {
    public boolean mAutoRequery;
    public ChangeObserver mChangeObserver;
    public Cursor mCursor;
    public CursorFilter mCursorFilter;
    public MyDataSetObserver mDataSetObserver;
    public boolean mDataValid;
    public int mRowIDColumn;

    /* loaded from: classes.dex */
    public final class ChangeObserver extends ContentObserver {
        public final /* synthetic */ SuggestionsAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChangeObserver(SuggestionsAdapter suggestionsAdapter) {
            super(new Handler());
            this.this$0 = suggestionsAdapter;
        }

        @Override // android.database.ContentObserver
        public final boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z) {
            Cursor cursor;
            SuggestionsAdapter suggestionsAdapter = this.this$0;
            if (suggestionsAdapter.mAutoRequery && (cursor = suggestionsAdapter.mCursor) != null && !cursor.isClosed()) {
                suggestionsAdapter.mDataValid = suggestionsAdapter.mCursor.requery();
            }
        }
    }

    /* loaded from: classes.dex */
    public final class MyDataSetObserver extends DataSetObserver {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ MyDataSetObserver(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            switch (this.$r8$classId) {
                case 0:
                    SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter) this.this$0;
                    suggestionsAdapter.mDataValid = true;
                    suggestionsAdapter.notifyDataSetChanged();
                    return;
                case 1:
                    ListPopupWindow listPopupWindow = (ListPopupWindow) this.this$0;
                    if (listPopupWindow.mPopup.isShowing()) {
                        listPopupWindow.show();
                        return;
                    }
                    return;
                default:
                    ((TabLayout) this.this$0).populateFromPagerAdapter();
                    return;
            }
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            switch (this.$r8$classId) {
                case 0:
                    SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter) this.this$0;
                    suggestionsAdapter.mDataValid = false;
                    suggestionsAdapter.notifyDataSetInvalidated();
                    return;
                case 1:
                    ((ListPopupWindow) this.this$0).dismiss();
                    return;
                default:
                    ((TabLayout) this.this$0).populateFromPagerAdapter();
                    return;
            }
        }
    }

    public abstract void bindView(View view, Cursor cursor);

    public void changeCursor(Cursor cursor) {
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                ChangeObserver changeObserver = this.mChangeObserver;
                if (changeObserver != null) {
                    cursor2.unregisterContentObserver(changeObserver);
                }
                MyDataSetObserver myDataSetObserver = this.mDataSetObserver;
                if (myDataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(myDataSetObserver);
                }
            }
            this.mCursor = cursor;
            if (cursor != null) {
                ChangeObserver changeObserver2 = this.mChangeObserver;
                if (changeObserver2 != null) {
                    cursor.registerContentObserver(changeObserver2);
                }
                MyDataSetObserver myDataSetObserver2 = this.mDataSetObserver;
                if (myDataSetObserver2 != null) {
                    cursor.registerDataSetObserver(myDataSetObserver2);
                }
                this.mRowIDColumn = cursor.getColumnIndexOrThrow("_id");
                this.mDataValid = true;
                notifyDataSetChanged();
            } else {
                this.mRowIDColumn = -1;
                this.mDataValid = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract String convertToString(Cursor cursor);

    @Override // android.widget.Adapter
    public final int getCount() {
        Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.mDataValid) {
            return null;
        }
        this.mCursor.moveToPosition(i);
        if (view == null) {
            SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter) this;
            view = suggestionsAdapter.mInflater.inflate(suggestionsAdapter.mDropDownLayout, viewGroup, false);
        }
        bindView(view, this.mCursor);
        return view;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.Filter, androidx.cursoradapter.widget.CursorFilter] */
    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.mCursorFilter == null) {
            ?? filter = new Filter();
            filter.mClient = this;
            this.mCursorFilter = filter;
        }
        return this.mCursorFilter;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.mCursor;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null || !cursor.moveToPosition(i)) {
            return 0L;
        }
        return this.mCursor.getLong(this.mRowIDColumn);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.mDataValid) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.mCursor.moveToPosition(i)) {
            if (view == null) {
                view = newView(viewGroup);
            }
            bindView(view, this.mCursor);
            return view;
        } else {
            throw new IllegalStateException(ViewModelProvider.Factory.CC.m(i, "couldn't move cursor to position "));
        }
    }

    public abstract View newView(ViewGroup viewGroup);
}
