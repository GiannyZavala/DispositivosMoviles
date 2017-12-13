package mx.edu.ittepic.tpdm_u3_ejemplo2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by GiannyEduardo on 24/03/17.
 */

public class ConexionDB extends SQLiteOpenHelper {
    public ConexionDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE TRABAJADOR(IDT VARCHAR(20) PRIMARY KEY,NOMBRE VARCHAR(200),PUESTO VARCHAR(200))");
        db.execSQL("CREATE TABLE CONYUGUE(IDC INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE VARCHAR(200),IDT VARCHAR(20),FOREIGN KEY(IDT) REFERENCES TRABAJADOR(IDT))");
        db.execSQL("CREATE TABLE HIJO(IDH INTEGER PRIMARY KEY AUTOINCREMENT,NOMBRE VARCHAR(200),IDT VARCHAR(20),FOREIGN KEY(IDT) REFERENCES TRABAJADOR(IDT))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}