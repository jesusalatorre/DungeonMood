package dm.dungeonmood;

/**
 * Created by Jesus on 4/5/2019.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBM extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "DungeonMood.db";
    private static final int DATABASE_VERSION = 1;

    public DBM(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SOUNDS_TABLE = "CREATE TABLE " +
                DataBaseSchema.SoundsTable.TABLE_NAME +
                "(" +
                DataBaseSchema.SoundsTable._ID + " INTEGER PRIMARY KEY," +
                DataBaseSchema.SoundsTable.COLUMN_NAME_TITLE + " TEXT," +
                DataBaseSchema.SoundsTable.COLUMN_NAME_DETAILS + " TEXT," +
                DataBaseSchema.SoundsTable.COLUMN_NAME_CATEGORY + " TEXT," +
                DataBaseSchema.SoundsTable.COLUMN_NAME_URL + " TEXT" +
                ")";

        Log.i("Producthelper onCreate1", CREATE_SOUNDS_TABLE);
        db.execSQL(CREATE_SOUNDS_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DELETE_SOUNDS_TABLE = "DROP TABLE IF EXISTS " + DataBaseSchema.SoundsTable.TABLE_NAME;
        db.execSQL(DELETE_SOUNDS_TABLE);

        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
