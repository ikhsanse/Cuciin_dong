package gir.cuciindong;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    //private construct
    private DatabaseAccess (Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.db = openHelper.getWritableDatabase();
    }

    public void close() {
        if (db!= null) {
            this.db.close();
        }
    }
    public List<String> getLaundry() {
        List<String> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM laundry", null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            list.add(c.getString(0));
            c.moveToNext();
        }
        c.close();
        return list;
    }
    public List<String> getPelanggan() {
        List<String> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM pelanggan", null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            list.add(c.getString(0));
            c.moveToNext();
        }
        c.close();
        return list;
    }
    public List<String> getAkun() {
        List<String> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM akun", null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            list.add(c.getString(0));
            c.moveToNext();
        }
        c.close();
        return list;
    }
    public List<String> getService() {
        List<String> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM services", null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            list.add(c.getString(0));
            c.moveToNext();
        }
        c.close();
        return list;
    }
    public List<String> getPemesanan() {
        List<String> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM pemesanan", null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            list.add(c.getString(0));
            c.moveToNext();
        }
        c.close();
        return list;
    }

}
