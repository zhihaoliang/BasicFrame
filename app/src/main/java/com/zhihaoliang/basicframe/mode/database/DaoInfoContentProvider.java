package com.zhihaoliang.basicframe.mode.database;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.database.Database;

import com.zhihaoliang.basicframe.dao.DaoSession;
import com.zhihaoliang.basicframe.dao.DaoInfoDao;

/* Copy this code snippet into your AndroidManifest.xml inside the <application> element:

    <provider
        android:name="com.zhihaoliang.basicframe.mode.database.DaoInfoContentProvider"
        android:authorities="com.zhihaoliang.basicframe.mode.database.provider" />
*/

public class DaoInfoContentProvider extends ContentProvider {

    public static final String AUTHORITY = "com.zhihaoliang.basicframe.mode.database.provider";
    public static final String BASE_PATH = "";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);
    public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
            + "/" + BASE_PATH;
    public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
            + "/" + BASE_PATH;

    private static final String TABLENAME = DaoInfoDao.TABLENAME;
    private static final String PK = DaoInfoDao.Properties.Id.columnName;

    private static final int DAOINFO_DIR = 0;
    private static final int DAOINFO_ID = 1;

    private static final UriMatcher sURIMatcher;

    static {
        sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sURIMatcher.addURI(AUTHORITY, BASE_PATH, DAOINFO_DIR);
        sURIMatcher.addURI(AUTHORITY, BASE_PATH + "/#", DAOINFO_ID);
    }

    /**
    * This must be set from outside, it's recommended to do this inside your Application object.
    * Subject to change (static isn't nice).
    */
    public static DaoSession daoSession;

    @Override
    public boolean onCreate() {
        // if(daoSession == null) {
        //     throw new IllegalStateException("DaoSession must be set before content provider is created");
        // }
        DaoLog.d("Content Provider started: " + CONTENT_URI);
        return true;
    }

    protected Database getDatabase() {
        if(daoSession == null) {
            throw new IllegalStateException("DaoSession must be set during content provider is active");
        }
        return daoSession.getDatabase();
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        throw new UnsupportedOperationException("This content provider is readonly");
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("This content provider is readonly");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
            String[] selectionArgs) {
        throw new UnsupportedOperationException("This content provider is readonly");
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        int uriType = sURIMatcher.match(uri);
        switch (uriType) {
        case DAOINFO_DIR:
            queryBuilder.setTables(TABLENAME);
            break;
        case DAOINFO_ID:
            queryBuilder.setTables(TABLENAME);
            queryBuilder.appendWhere(PK + "="
                    + uri.getLastPathSegment());
            break;
        default:
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }

        Database db = getDatabase();
        Cursor cursor = queryBuilder.query(((StandardDatabase) db).getSQLiteDatabase(), projection, selection,
                selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Override
    public final String getType(Uri uri) {
        switch (sURIMatcher.match(uri)) {
        case DAOINFO_DIR:
            return CONTENT_TYPE;
        case DAOINFO_ID:
            return CONTENT_ITEM_TYPE;
        default :
            throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }
}
