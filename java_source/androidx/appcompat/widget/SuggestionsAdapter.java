package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat$Api21Impl;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.lifecycle.ViewModelProvider;
import com.emanuelef.remote_capture.C0130R;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class SuggestionsAdapter extends CursorAdapter implements View.OnClickListener {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final int mCommitIconResId;
    public final int mDropDownLayout;
    public final LayoutInflater mInflater;
    public final int mLayout;
    public final WeakHashMap mOutsideDrawablesCache;
    public final Context mProviderContext;
    public final SearchView mSearchView;
    public final SearchableInfo mSearchable;
    public ColorStateList mUrlColor;
    public int mQueryRefinement = 1;
    public int mText1Col = -1;
    public int mText2Col = -1;
    public int mText2UrlCol = -1;
    public int mIconName1Col = -1;
    public int mIconName2Col = -1;
    public int mFlagsCol = -1;

    /* loaded from: classes.dex */
    public final class ChildViewCache {
        public final ImageView mIcon1;
        public final ImageView mIcon2;
        public final ImageView mIconRefine;
        public final TextView mText1;
        public final TextView mText2;

        public ChildViewCache(View view) {
            this.mText1 = (TextView) view.findViewById(16908308);
            this.mText2 = (TextView) view.findViewById(16908309);
            this.mIcon1 = (ImageView) view.findViewById(16908295);
            this.mIcon2 = (ImageView) view.findViewById(16908296);
            this.mIconRefine = (ImageView) view.findViewById(C0130R.C0132id.edit_query);
        }
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        int suggestionRowLayout = searchView.getSuggestionRowLayout();
        this.mAutoRequery = true;
        this.mCursor = null;
        this.mDataValid = false;
        this.mRowIDColumn = -1;
        this.mChangeObserver = new CursorAdapter.ChangeObserver(this);
        this.mDataSetObserver = new CursorAdapter.MyDataSetObserver(0, this);
        this.mDropDownLayout = suggestionRowLayout;
        this.mLayout = suggestionRowLayout;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mSearchView = searchView;
        this.mSearchable = searchableInfo;
        this.mCommitIconResId = searchView.getSuggestionCommitIconResId();
        this.mProviderContext = context;
        this.mOutsideDrawablesCache = weakHashMap;
    }

    public static String getStringOrNull(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0134  */
    @Override // androidx.cursoradapter.widget.CursorAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bindView(View view, Cursor cursor) {
        int i;
        int i2;
        int i3;
        Drawable drawable;
        Drawable drawable2;
        Drawable.ConstantState constantState;
        ActivityInfo activityInfo;
        int iconResource;
        String str;
        ChildViewCache childViewCache = (ChildViewCache) view.getTag();
        int i4 = this.mFlagsCol;
        if (i4 != -1) {
            i = cursor.getInt(i4);
        } else {
            i = 0;
        }
        TextView textView = childViewCache.mText1;
        TextView textView2 = childViewCache.mText2;
        ImageView imageView = childViewCache.mIconRefine;
        if (textView != null) {
            String stringOrNull = getStringOrNull(cursor, this.mText1Col);
            textView.setText(stringOrNull);
            if (TextUtils.isEmpty(stringOrNull)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
        }
        Context context = this.mProviderContext;
        if (textView2 != null) {
            String stringOrNull2 = getStringOrNull(cursor, this.mText2UrlCol);
            if (stringOrNull2 != null) {
                if (this.mUrlColor == null) {
                    TypedValue typedValue = new TypedValue();
                    context.getTheme().resolveAttribute(C0130R.attr.textColorSearchUrl, typedValue, true);
                    this.mUrlColor = context.getResources().getColorStateList(typedValue.resourceId);
                }
                SpannableString spannableString = new SpannableString(stringOrNull2);
                spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, stringOrNull2.length(), 33);
                str = spannableString;
            } else {
                str = getStringOrNull(cursor, this.mText2Col);
            }
            if (TextUtils.isEmpty(str)) {
                if (textView != null) {
                    textView.setSingleLine(false);
                    textView.setMaxLines(2);
                }
            } else if (textView != null) {
                textView.setSingleLine(true);
                textView.setMaxLines(1);
            }
            textView2.setText(str);
            if (TextUtils.isEmpty(str)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
            }
        }
        ImageView imageView2 = childViewCache.mIcon1;
        if (imageView2 != null) {
            int i5 = this.mIconName1Col;
            if (i5 == -1) {
                drawable2 = null;
            } else {
                drawable2 = getDrawableFromResourceValue(cursor.getString(i5));
                if (drawable2 == null) {
                    ComponentName searchActivity = this.mSearchable.getSearchActivity();
                    String flattenToShortString = searchActivity.flattenToShortString();
                    WeakHashMap weakHashMap = this.mOutsideDrawablesCache;
                    if (weakHashMap.containsKey(flattenToShortString)) {
                        Drawable.ConstantState constantState2 = (Drawable.ConstantState) weakHashMap.get(flattenToShortString);
                        if (constantState2 == null) {
                            drawable2 = null;
                        } else {
                            drawable2 = constantState2.newDrawable(context.getResources());
                        }
                    } else {
                        PackageManager packageManager = context.getPackageManager();
                        try {
                            activityInfo = packageManager.getActivityInfo(searchActivity, 128);
                            iconResource = activityInfo.getIconResource();
                        } catch (PackageManager.NameNotFoundException e) {
                            Log.w("SuggestionsAdapter", e.toString());
                        }
                        if (iconResource != 0) {
                            Drawable drawable3 = packageManager.getDrawable(searchActivity.getPackageName(), iconResource, activityInfo.applicationInfo);
                            if (drawable3 == null) {
                                StringBuilder m = ViewModelProvider.Factory.CC.m598m("Invalid icon resource ", iconResource, " for ");
                                m.append(searchActivity.flattenToShortString());
                                Log.w("SuggestionsAdapter", m.toString());
                            } else {
                                drawable2 = drawable3;
                                if (drawable2 != null) {
                                    constantState = null;
                                } else {
                                    constantState = drawable2.getConstantState();
                                }
                                weakHashMap.put(flattenToShortString, constantState);
                            }
                        }
                        drawable2 = null;
                        if (drawable2 != null) {
                        }
                        weakHashMap.put(flattenToShortString, constantState);
                    }
                    if (drawable2 == null) {
                        drawable2 = context.getPackageManager().getDefaultActivityIcon();
                    }
                }
            }
            imageView2.setImageDrawable(drawable2);
            if (drawable2 == null) {
                imageView2.setVisibility(4);
            } else {
                imageView2.setVisibility(0);
                drawable2.setVisible(false, false);
                drawable2.setVisible(true, false);
            }
        }
        ImageView imageView3 = childViewCache.mIcon2;
        if (imageView3 != null) {
            int i6 = this.mIconName2Col;
            if (i6 == -1) {
                drawable = null;
            } else {
                drawable = getDrawableFromResourceValue(cursor.getString(i6));
            }
            imageView3.setImageDrawable(drawable);
            if (drawable == null) {
                imageView3.setVisibility(8);
            } else {
                imageView3.setVisibility(0);
                drawable.setVisible(false, false);
                i2 = 1;
                drawable.setVisible(true, false);
                i3 = this.mQueryRefinement;
                if (i3 != 2 || (i3 == i2 && (i & 1) != 0)) {
                    imageView.setVisibility(0);
                    imageView.setTag(textView.getText());
                    imageView.setOnClickListener(this);
                }
                imageView.setVisibility(8);
                return;
            }
        }
        i2 = 1;
        i3 = this.mQueryRefinement;
        if (i3 != 2) {
        }
        imageView.setVisibility(0);
        imageView.setTag(textView.getText());
        imageView.setOnClickListener(this);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public final void changeCursor(Cursor cursor) {
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.mText1Col = cursor.getColumnIndex("suggest_text_1");
                this.mText2Col = cursor.getColumnIndex("suggest_text_2");
                this.mText2UrlCol = cursor.getColumnIndex("suggest_text_2_url");
                this.mIconName1Col = cursor.getColumnIndex("suggest_icon_1");
                this.mIconName2Col = cursor.getColumnIndex("suggest_icon_2");
                this.mFlagsCol = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public final String convertToString(Cursor cursor) {
        String stringOrNull;
        String stringOrNull2;
        if (cursor == null) {
            return null;
        }
        String stringOrNull3 = getStringOrNull(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (stringOrNull3 != null) {
            return stringOrNull3;
        }
        SearchableInfo searchableInfo = this.mSearchable;
        if (searchableInfo.shouldRewriteQueryFromData() && (stringOrNull2 = getStringOrNull(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
            return stringOrNull2;
        }
        if (!searchableInfo.shouldRewriteQueryFromText() || (stringOrNull = getStringOrNull(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
            return null;
        }
        return stringOrNull;
    }

    public final Drawable getDrawableFromResourceUri(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.mProviderContext.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Drawable getDrawableFromResourceValue(String str) {
        Drawable drawable;
        Drawable drawable2;
        WeakHashMap weakHashMap = this.mOutsideDrawablesCache;
        Context context = this.mProviderContext;
        Drawable drawable3 = null;
        if (str != null && !str.isEmpty() && !"0".equals(str)) {
            try {
                int parseInt = Integer.parseInt(str);
                String str2 = "android.resource://" + context.getPackageName() + "/" + parseInt;
                Drawable.ConstantState constantState = (Drawable.ConstantState) weakHashMap.get(str2);
                if (constantState == null) {
                    drawable2 = null;
                } else {
                    drawable2 = constantState.newDrawable();
                }
                if (drawable2 != null) {
                    return drawable2;
                }
                Drawable drawable4 = ContextCompat$Api21Impl.getDrawable(context, parseInt);
                if (drawable4 != null) {
                    weakHashMap.put(str2, drawable4.getConstantState());
                }
                return drawable4;
            } catch (Resources.NotFoundException unused) {
                Log.w("SuggestionsAdapter", "Icon resource not found: ".concat(str));
                return null;
            } catch (NumberFormatException unused2) {
                Drawable.ConstantState constantState2 = (Drawable.ConstantState) weakHashMap.get(str);
                if (constantState2 == null) {
                    drawable = null;
                } else {
                    drawable = constantState2.newDrawable();
                }
                if (drawable != null) {
                    return drawable;
                }
                Uri parse = Uri.parse(str);
                try {
                } catch (FileNotFoundException e) {
                    Log.w("SuggestionsAdapter", "Icon not found: " + parse + ", " + e.getMessage());
                    if (drawable3 != null) {
                    }
                    return drawable3;
                }
                if ("android.resource".equals(parse.getScheme())) {
                    try {
                        drawable3 = getDrawableFromResourceUri(parse);
                        if (drawable3 != null) {
                            weakHashMap.put(str, drawable3.getConstantState());
                        }
                    } catch (Resources.NotFoundException unused3) {
                        throw new FileNotFoundException("Resource does not exist: " + parse);
                    }
                } else {
                    InputStream openInputStream = context.getContentResolver().openInputStream(parse);
                    if (openInputStream != null) {
                        Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                        try {
                            openInputStream.close();
                        } catch (IOException e2) {
                            Log.e("SuggestionsAdapter", "Error closing icon stream for " + parse, e2);
                        }
                        drawable3 = createFromStream;
                        if (drawable3 != null) {
                        }
                    } else {
                        throw new FileNotFoundException("Failed to open " + parse);
                    }
                }
                Log.w("SuggestionsAdapter", "Icon not found: " + parse + ", " + e.getMessage());
                if (drawable3 != null) {
                }
            }
        }
        return drawable3;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View inflate = this.mInflater.inflate(this.mDropDownLayout, viewGroup, false);
            if (inflate != null) {
                ((ChildViewCache) inflate.getTag()).mText1.setText(e.toString());
            }
            return inflate;
        }
    }

    public final Cursor getSearchManagerSuggestions(SearchableInfo searchableInfo, String str) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        fragment.appendQueryParameter("limit", String.valueOf(50));
        return this.mProviderContext.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View newView = newView(viewGroup);
            ((ChildViewCache) newView.getTag()).mText1.setText(e.toString());
            return newView;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public final View newView(ViewGroup viewGroup) {
        View inflate = this.mInflater.inflate(this.mLayout, viewGroup, false);
        inflate.setTag(new ChildViewCache(inflate));
        ((ImageView) inflate.findViewById(C0130R.C0132id.edit_query)).setImageResource(this.mCommitIconResId);
        return inflate;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        Bundle bundle;
        super.notifyDataSetChanged();
        Cursor cursor = this.mCursor;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetInvalidated() {
        Bundle bundle;
        super.notifyDataSetInvalidated();
        Cursor cursor = this.mCursor;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.mSearchView.onQueryRefine((CharSequence) tag);
        }
    }
}
