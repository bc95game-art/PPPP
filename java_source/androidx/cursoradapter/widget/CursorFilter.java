package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.util.Log;
import android.widget.Filter;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SuggestionsAdapter;
/* loaded from: classes.dex */
public final class CursorFilter extends Filter {
    public CursorAdapter mClient;

    @Override // android.widget.Filter
    public final CharSequence convertResultToString(Object obj) {
        return ((SuggestionsAdapter) this.mClient).convertToString((Cursor) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    @Override // android.widget.Filter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        String str;
        Cursor cursor;
        SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter) this.mClient;
        SearchView searchView = suggestionsAdapter.mSearchView;
        if (charSequence == null) {
            str = "";
        } else {
            str = charSequence.toString();
        }
        if (searchView.getVisibility() == 0 && searchView.getWindowVisibility() == 0) {
            try {
                cursor = suggestionsAdapter.getSearchManagerSuggestions(suggestionsAdapter.mSearchable, str);
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
            if (cursor != null) {
                cursor.getCount();
                Filter.FilterResults filterResults = new Filter.FilterResults();
                if (cursor == null) {
                    filterResults.count = cursor.getCount();
                    filterResults.values = cursor;
                } else {
                    filterResults.count = 0;
                    filterResults.values = null;
                }
                return filterResults;
            }
        }
        cursor = null;
        Filter.FilterResults filterResults2 = new Filter.FilterResults();
        if (cursor == null) {
        }
        return filterResults2;
    }

    @Override // android.widget.Filter
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        CursorAdapter cursorAdapter = this.mClient;
        Cursor cursor = cursorAdapter.mCursor;
        Object obj = filterResults.values;
        if (obj != null && obj != cursor) {
            ((SuggestionsAdapter) cursorAdapter).changeCursor((Cursor) obj);
        }
    }
}
