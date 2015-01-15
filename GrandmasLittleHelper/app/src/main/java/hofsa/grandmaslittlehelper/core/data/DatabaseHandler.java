package hofsa.grandmaslittlehelper.core.data;

import android.content.Context;
import android.util.Log;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sam on 12.01.15.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "glh.db";
    /**
     * Goal of the DATABASE_VERSION is an alternative implementation of
     * the structure and the information showed for the user.
     * So DATABASE_VERSION 1 is for the enduser, that means old people which
     * wants to consume the drugs.
     */
    private static final int DATABASE_VERSION = 1;

    /*
    private static final String TABLE_CREATE_DRUG = ""
            +"CREATE TABLE tblDRUG("
            +"ID integer PRIMARY KEY AUTOINCREMENT, "
            +"NAME TEXT,"
            +"AFFLICTION TEXT,"
            +"SIDEACTION TEXT,"
            +"QUANTITY INT,"
            +"VISUALMARK TEXT);";
    */

    private final static String DRUG_TABEL = "tblDrug";
    private final static String DRUG_ID = "_id";
    private final static String DRUG_NAME = "name";
    private final static String DRUG_AFFLICTION = "affliction";
    private final static String DRUG_SIDEACTION = "sideaction";
    private final static String DRUG_MAX_QUANTITY = "maxquantity";
    private final static String DRUG_UNIT = "unit";
    private final static String DRUG_VISUALMARK = "visualmark";


    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use to open or create the database
     */
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL(TABLE_CREATE_DRUG);
        String createDB = "CREATE TABLE " + DRUG_TABEL + " ( " +
                DRUG_ID + " INTEGER PRIMARY KEY, " +
                DRUG_NAME + " TEXT, " +
                DRUG_AFFLICTION + " TEXT, " +
                DRUG_SIDEACTION + " TEXT, " +
                DRUG_MAX_QUANTITY + " INTEGER, " +
                DRUG_UNIT + " TEXT, " +
                DRUG_VISUALMARK + " TEXT)";
        db.execSQL(createDB);
    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p/>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHandler.class.getName(),
                " Upgrade database from Version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF  EXISTS "+ DRUG_TABEL );
        onCreate(db);
    }
}
