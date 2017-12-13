package mx.edu.ittepic.tpdm_u3_practica1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by GiannyEduardo on 22/03/17.
 */

public class ConexionDB extends SQLiteOpenHelper {
    int error;

    public ConexionDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        error=0;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL("CREATE TABLE PERSONA(ID INTEGER PRIMARY KEY NOT NULL,"+"NOMBRE VARCHAR(200),DOMICILIO VARCHAR(400))");
        }catch(SQLiteException e){
            error=1;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int nuevaVersion) {

    }
}
