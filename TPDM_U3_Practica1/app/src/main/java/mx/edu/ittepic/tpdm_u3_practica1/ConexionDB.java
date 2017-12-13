package mx.edu.ittepic.tpdm_u3_practica1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by GiannyEduardo on 29/03/17.
 */

public class ConexionDB extends SQLiteOpenHelper {
    public ConexionDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CLIENTE(ID_CLIENTE SMALLINT PRIMARY KEY,NOMBRE VARCHAR(60),DIRECCION VARCHAR(60),TELEFONO VARCHAR(20),EMAIL VARCHAR(30))");
        db.execSQL("CREATE TABLE FACTURA(ID_FACTURA SMALLINT PRIMARY KEY,FECHA DATE,ID_CLIENTE SMALLINT,FOREIGN KEY(ID_CLIENTE) REFERENCES CLIENTE(ID_CLIENTE))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
