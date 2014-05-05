package resthunter.content.provider;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

import java.lang.reflect.Field;

/**
 * Created by gorodechnyj on 30.01.14.
 */
public class Contract {
    public static final String AUTHORITY = "com.fupmstma";

    public static final Uri BASE_CONTENT_URI = new Uri.Builder()
            .scheme(ContentResolver.SCHEME_CONTENT)
            .authority(AUTHORITY)
            .build();

    public static String getTableName(Class clazz) {
        try {
            Field tableNameField = clazz.getField("TABLENAME");
            String result = (String) tableNameField.get(null);
            return result;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Model contract given should have TABLENAME specified");
        } catch (IllegalAccessException e) {
            e.printStackTrace(System.err);
            throw new RuntimeException("Have no idea what happend: look at System.err stream");
        }
    }

    public static class Task {
        public static final String TABLENAME = "task";
        public static final String PATH = TABLENAME;
        public static final String PATH_SINGLE = TABLENAME + "/#";

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH).build();

        public static final String ID = BaseColumns._ID;
        public static final String TYPE = "type";
        public static final String STATUS = "status";
        public static final String VEHICLE = "vehicle";
        public static final String CURRENT_PARKING = "current_parking";
        public static final String NEW_PARKING = "new_parking";
        public static final String PARKING_TYPE = "parking_type";
        public static final String OWNER = "owner";
        public static final String ASSIGNEE = "assignee";
        public static final String RECIPIENT = "recipient";
        public static final String COMMENT = "comment";
        public static final String KEYS_BOUND = "keys_bound";
        public static final String CREATE_DATETIME = "create_datetime";
        public static final String START_DATETIME = "start_datetime";

        public static final String DDL = "CREATE TABLE " + TABLENAME + " ( " +
                ID + " INTEGER, " +
                TYPE + " INTEGER, " +
                STATUS + " INTEGER, " +
                VEHICLE + " TEXT, " +
                CURRENT_PARKING + " TEXT, " +
                NEW_PARKING + " TEXT, " +
                PARKING_TYPE + " INTEGER, " +
                OWNER + " TEXT, " +
                ASSIGNEE + " TEXT, " +
                RECIPIENT + " TEXT, " +
                COMMENT + " TEXT, " +
                KEYS_BOUND + " INTEGER, " +
                CREATE_DATETIME + " LONG, " +
                START_DATETIME + " LONG, " +
                "UNIQUE (" + ID + ") ON CONFLICT REPLACE)";
    }

    public static class Act {
        public static final String TABLENAME = "act";
        public static final String PATH = TABLENAME;
        public static final String PATH_SINGLE = TABLENAME + "/#";

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH).build();

        public static final String ID = BaseColumns._ID;
        public static final String TRUCK = "truck";
        public static final String CARRIER = "carrier";
        public static final String FORWARDING_AGENT = "forwarding_agent";
        public static final String PROTECTIVE_COVER = "protective_cover";
        public static final String FUEL = "fuel";
        public static final String MILEAGE_MAINTENANCE = "mileage_maintenance";
        public static final String MILEAGE = "mileage";
        public static final String EQUIPMENTS = "equipments";
        public static final String DOCUMENTS = "documents";
        public static final String TASK_ID = "task_id";

        public static final String DDL = "CREATE TABLE " + TABLENAME + " ( " +
                ID + "  INTEGER PRIMARY KEY, " +
                TRUCK + " TEXT, " +
                CARRIER + " TEXT, " +
                FORWARDING_AGENT + " TEXT, " +
                PROTECTIVE_COVER + " TEXT, " +
                FUEL + " INTEGER, " +
                MILEAGE_MAINTENANCE + " INTEGER, " +
                MILEAGE + " INTEGER, " +
                EQUIPMENTS + " TEXT, " +
                DOCUMENTS + " TEXT, " +
                TASK_ID + " INTEGER, " +
                "UNIQUE (" + ID + ") ON CONFLICT REPLACE)";
    }

    public static class Damage {
        public static final String TABLENAME = "damage";
        public static final String PATH = TABLENAME;
        public static final String PATH_SINGLE = TABLENAME + "/#";

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH).build();

        public static final String ID = BaseColumns._ID;
        public static final String TASK_ID = "task_id";
        public static final String VEHICLE_ID = "vehicle_id";
        public static final String TYPE = "type";
        public static final String LOCATION_TYPE = "location_type";
        public static final String SIZE_TYPE = "size_type";
        public static final String VEHICLE_PART = "vehicle_part";
        public static final String REPAIRS = "repairs";
        public static final String OTHER_REPAIRS = "other_repairs";
        public static final String REPAIR_COST = "repair_cost";
        public static final String PHOTO_ID = "photo_id";
        public static final String PHOTO_FILE_PATH = "photo_uri";
        public static final String REMOTE_ID = "remote_id";

        public static final String DDL = "CREATE TABLE " + TABLENAME + " ( " +
                ID + "  INTEGER PRIMARY KEY, " +
                TASK_ID + " INTEGER, " +
                VEHICLE_ID + " INTEGER, " +
                TYPE + " INTEGER, " +
                LOCATION_TYPE + " INTEGER, " +
                SIZE_TYPE + " INTEGER, " +
                VEHICLE_PART + " TEXT, " +
                REPAIRS + " INTEGER, " +
                OTHER_REPAIRS + " TEXT, " +
                REPAIR_COST + " NUMBER, " +
                PHOTO_ID + " INTEGER, " +
                PHOTO_FILE_PATH + " TEXT, " +
                REMOTE_ID + " INTEGER, " +
                "UNIQUE (" + ID + ") ON CONFLICT REPLACE)";
    }

    public static class User {
        public static final String TABLENAME = "user";
        public static final String PATH = TABLENAME;
        public static final String PATH_SINGLE = TABLENAME + "/#";

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH).build();

        public static final String ID = BaseColumns._ID;
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String ROLE = "role";
        public static final String KEY_1_CARD_ID = "key_1_card_id";
        public static final String KEY_2_CARD_ID = "key_2_card_id";

        public static final String DDL = "CREATE TABLE " + TABLENAME + " ( " +
                ID + "  INTEGER, " +
                FIRST_NAME + " TEXT, " +
                LAST_NAME + " TEXT, " +
                ROLE + " TEXT, " +
                KEY_1_CARD_ID + " TEXT, " +
                KEY_2_CARD_ID + " TEXT, " +
                "UNIQUE (" + ID + ") ON CONFLICT REPLACE)";
    }
}
