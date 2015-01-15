package hofsa.grandmaslittlehelper.core.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.DropBoxManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam on 12.01.15.
 */
public class DatabaseWizard {

    private SQLiteDatabase database;
    private DatabaseHandler dbHandler;
    private String[] allColumns = {"_id","name","affliction","sideaction","maxquantity","unit","visualmark"};
  // private String[] allColumns = {"ID","NAME"};


    public DatabaseWizard(Context context) {
        dbHandler = new DatabaseHandler(context);
    }
    public void open() throws SQLException{
        database = dbHandler.getWritableDatabase();
    }
    public void close(){
        dbHandler.close();
    }

    public Drug createDrug(String name,String affliction, String sideaction,
                           int maxquantity, String unit, String visualmark ){
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("affliction",affliction);
        values.put("sideaction", sideaction);
        values.put("maxquantity", maxquantity);
        values.put("unit", unit);
        values.put("visualmark",visualmark);

        long generateId = database.insert("tblDRUG", null, values);

        Cursor cursor = database.query("tblDRUG", allColumns, "_id + "+generateId,null,null,null,null,null);
        cursor.moveToFirst();

        return cursorToDrug(cursor);
    }

    public List<Drug> getAllDrugs(){
        List<Drug> DrugList = new ArrayList<>();


        Cursor cursor = database.query("tblDRUG", allColumns,null,null,null,null,null,null);
        cursor.moveToFirst();

        if(cursor.getCount() == 0){
            return DrugList;
        }

        while(!cursor.isAfterLast()){
            Drug drug = cursorToDrug(cursor);
            DrugList.add(drug);
            cursor.moveToNext();
        }
        cursor.close();
        return DrugList;
    }

    private Drug cursorToDrug(Cursor cursor){
        Drug drug = new Drug();
        drug.setDrugId(cursor.getLong(0));
        drug.setName(cursor.getString(1));
        drug.setAffliction(cursor.getString(2));
        drug.setSideAction(cursor.getString(3));
        drug.setQuantity(cursor.getInt(4));
        drug.setUnit(cursor.getString(5));
        drug.setVisualMark(cursor.getString(6));


        return drug;
    }
}
