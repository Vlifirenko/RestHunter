package resthunter.content.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gorodechnyj on 20.01.14.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String LOG_TAG = "com.fupmstma.content.provider.DatabaseHelper";
    private static final String DATABASE_NAME = "fupmstma.db";
    private static final int DATABASE_VERSION = 19;
    private static DatabaseHelper instance;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getInstance(Context context) {
        if (instance == null)
            instance = new DatabaseHelper(context.getApplicationContext());
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Contract.Act.DDL);
        sqLiteDatabase.execSQL(Contract.Damage.DDL);
        sqLiteDatabase.execSQL(Contract.Task.DDL);
        sqLiteDatabase.execSQL(Contract.User.DDL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + Contract.Act.TABLENAME);
            db.execSQL("DROP TABLE IF EXISTS " + Contract.Damage.TABLENAME);
            db.execSQL("DROP TABLE IF EXISTS " + Contract.Task.TABLENAME);
            db.execSQL("DROP TABLE IF EXISTS " + Contract.User.TABLENAME);
            onCreate(db);
        }
    }
}