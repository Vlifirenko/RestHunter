package resthunter.content.provider;


import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

/**
 * Created by gorodechnyj on 20.01.14.
 */
public class FupmsTmaContentProvider extends ContentProvider {
    private static final String TAG = "com.fupmstma.content.provider.FupmsTmaContentProvider";
    private Context context;
    private DatabaseHelper dbHelper;

    public static final UriMatcher URI_MATCHER = buildUriMatcher();

    public static final int ACT_TOKEN = 0;
    public static final int ACT_ID_TOKEN = 1;
    public static final int DAMAGE_TOKEN = 2;
    public static final int DAMAGE_ID_TOKEN = 3;
    public static final int TASK_TOKEN = 6;
    public static final int TASK_ID_TOKEN = 7;
    public static final int USER_TOKEN = 8;
    public static final int USER_ID_TOKEN = 9;

    private static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(Contract.AUTHORITY, Contract.Act.PATH, ACT_TOKEN);
        matcher.addURI(Contract.AUTHORITY, Contract.Act.PATH_SINGLE, ACT_ID_TOKEN);
        matcher.addURI(Contract.AUTHORITY, Contract.Damage.PATH, DAMAGE_TOKEN);
        matcher.addURI(Contract.AUTHORITY, Contract.Damage.PATH_SINGLE, DAMAGE_ID_TOKEN);
        matcher.addURI(Contract.AUTHORITY, Contract.Task.PATH, TASK_TOKEN);
        matcher.addURI(Contract.AUTHORITY, Contract.Task.PATH_SINGLE, TASK_ID_TOKEN);
        matcher.addURI(Contract.AUTHORITY, Contract.User.PATH, USER_TOKEN);
        matcher.addURI(Contract.AUTHORITY, Contract.User.PATH_SINGLE, USER_ID_TOKEN);
        return matcher;
    }

    @Override
    public boolean onCreate() {
        context = getContext();
        dbHelper = new DatabaseHelper(context);
        return true;
    }

    private String getContentDirType(Class clazz) {
        return "vnd.android.cursor.dir/vnd." + Contract.AUTHORITY + "." + Contract.getTableName(clazz);
    }

    private String getContentItemType(Class clazz) {
        return "vnd.android.cursor.item/vnd." + Contract.AUTHORITY + "." + Contract.getTableName(clazz);
    }

    @Override
    public String getType(Uri uri) {
        final int token = URI_MATCHER.match(uri);
        switch (token) {
            case ACT_TOKEN:
                return getContentDirType(Contract.Act.class);
            case ACT_ID_TOKEN:
                return getContentItemType(Contract.Act.class);
            case DAMAGE_TOKEN:
                return getContentDirType(Contract.Damage.class);
            case DAMAGE_ID_TOKEN:
                return getContentItemType(Contract.Damage.class);
            case TASK_TOKEN:
                return getContentDirType(Contract.Task.class);
            case TASK_ID_TOKEN:
                return getContentItemType(Contract.Task.class);
            case USER_TOKEN:
                return getContentDirType(Contract.User.class);
            case USER_ID_TOKEN:
                return getContentItemType(Contract.User.class);
            default:
                throw new UnsupportedOperationException("URI " + uri + " is not supported.");
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int token = URI_MATCHER.match(uri);
        long id = 0;
        switch (token) {
            case ACT_TOKEN:
                id = db.insertWithOnConflict(Contract.Act.TABLENAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);
                getContext().getContentResolver().notifyChange(uri, null, false);
                return Contract.Act.CONTENT_URI.buildUpon().appendPath(Long.toString(id)).build();
            case DAMAGE_TOKEN:
                id = db.insertWithOnConflict(Contract.Damage.TABLENAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);
                getContext().getContentResolver().notifyChange(uri, null, false);
                return Contract.Damage.CONTENT_URI.buildUpon().appendPath(Long.toString(id)).build();
            case TASK_TOKEN:
                id = db.insertWithOnConflict(Contract.Task.TABLENAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);
                getContext().getContentResolver().notifyChange(uri, null, false);
                return Contract.Task.CONTENT_URI.buildUpon().appendPath(Long.toString(id)).build();
            case USER_TOKEN:
                id = db.insertWithOnConflict(Contract.User.TABLENAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);
                getContext().getContentResolver().notifyChange(uri, null, false);
                return Contract.User.CONTENT_URI.buildUpon().appendPath(Long.toString(id)).build();
            default:
                throw new UnsupportedOperationException("URI " + uri + " is not supported.");
        }
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        final int token = URI_MATCHER.match(uri);
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        switch (token) {
            case ACT_TOKEN:
                builder.setTables(Contract.Act.TABLENAME);
                break;
            case DAMAGE_TOKEN:
                builder.setTables(Contract.Damage.TABLENAME);
                break;
            case TASK_TOKEN:
                builder.setTables(Contract.Task.TABLENAME);
                break;
            case USER_TOKEN:
                builder.setTables(Contract.User.TABLENAME);
                break;
            default:
                throw new UnsupportedOperationException("URI " + uri + " is not supported.");
        }
        Cursor cursor = builder.query(db, projection, selection, selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int token = URI_MATCHER.match(uri);
        int count = 0;
        switch (token) {
            case ACT_TOKEN:
                count = db.updateWithOnConflict(Contract.Act.TABLENAME,
                        values, selection, selectionArgs, SQLiteDatabase.CONFLICT_REPLACE);
                break;
            case DAMAGE_TOKEN:
                count = db.updateWithOnConflict(Contract.Damage.TABLENAME,
                        values, selection, selectionArgs, SQLiteDatabase.CONFLICT_REPLACE);
                break;
            case TASK_TOKEN:
                count = db.updateWithOnConflict(Contract.Task.TABLENAME,
                        values, selection, selectionArgs, SQLiteDatabase.CONFLICT_REPLACE);
                break;
            case USER_TOKEN:
                count = db.updateWithOnConflict(Contract.User.TABLENAME,
                        values, selection, selectionArgs, SQLiteDatabase.CONFLICT_REPLACE);
                break;
            default:
                throw new UnsupportedOperationException("URI " + uri + " is not supported.");
        }
        if (count > 0)
            getContext().getContentResolver().notifyChange(uri, null, false);
        return count;
    }

    @Override
    public int delete(Uri uri, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        final int token = URI_MATCHER.match(uri);
        int count = 0;
        switch (token) {
            case ACT_TOKEN:
                count = db.delete(Contract.Act.TABLENAME, whereClause, whereArgs);
                break;
            case DAMAGE_TOKEN:
                count = db.delete(Contract.Damage.TABLENAME, whereClause, whereArgs);
                break;
            case TASK_TOKEN:
                count = db.delete(Contract.Task.TABLENAME, whereClause, whereArgs);
                break;
            case USER_TOKEN:
                count = db.delete(Contract.User.TABLENAME, whereClause, whereArgs);
                break;
            default:
                throw new UnsupportedOperationException("URI " + uri + " is not supported.");
        }
        if (count > 0) getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}