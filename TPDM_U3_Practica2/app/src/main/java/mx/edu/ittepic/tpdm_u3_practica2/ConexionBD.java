package mx.edu.ittepic.tpdm_u3_practica2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by GiannyEduardo on 07/04/17.
 */

public class ConexionBD extends SQLiteOpenHelper {
    public ConexionBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE TAREA (IDT INTEGER PRIMARY KEY AUTOINCREMENT, DESCRIPCION VARCHAR(200), FECHA TEXT, NOTAS TEXT, STATUS BOOLEAN)");
        db.execSQL("CREATE TABLE IMAGEN (IDI INTEGER PRIMARY KEY AUTOINCREMENT, IDT INTEGER, IMAGEN BLOP, FOREIGN KEY(IDT) REFERENCES TAREA(IDT))");
    }//onCreate

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }//onUpgrade
}//ConexionBD
