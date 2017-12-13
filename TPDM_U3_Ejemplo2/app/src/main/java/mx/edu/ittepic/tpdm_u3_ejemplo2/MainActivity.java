package mx.edu.ittepic.tpdm_u3_ejemplo2;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText id,nombre,puesto,conyugue,hijo;
    Button insertar,mostrar,mostrarhijo,insertarhijo;
    ConexionDB conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        id=(EditText)findViewById(R.id.editText);
        nombre=(EditText)findViewById(R.id.editText2);
        puesto=(EditText)findViewById(R.id.editText3);
        conyugue=(EditText)findViewById(R.id.editText4);
        conexion = new ConexionDB(this,"baseDatosEjemplo2_1",null,1);
        insertar=(Button)findViewById(R.id.button);
        mostrar=(Button)findViewById(R.id.button2);
        insertarhijo=(Button)findViewById(R.id.button3);
        mostrarhijo=(Button)findViewById(R.id.button4);
        hijo=(EditText)findViewById(R.id.editText5);

        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarTrabajador();
            }
        });

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDatos();
                
            }
        });
        
        insertarhijo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarHijo();
                
            }
        });
        
        mostrarhijo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarHijo();
                
            }
        });
    }

    private void mostrarHijo() {
        try{
            String cad="";
            SQLiteDatabase db=conexion.getReadableDatabase();
            String sql="SELECT * FROM  HIJO WHERE IDT="+id.getText().toString();
            Cursor resultado=db.rawQuery(sql,null);
            int i=0;
            while(resultado.moveToNext()){
                cad+=resultado.getString(1)+"\n";
                i++;
            }
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle("Hijos");
            alertDialog.setMessage(cad);
            alertDialog.show();
            i=0;

            if(resultado==null){
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("No se encontraron Hijos");
                alertDialog.setMessage(cad);
                alertDialog.show();
                i=1;


            }
        }catch (SQLiteException e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void insertarHijo() {
        try{
            SQLiteDatabase db = conexion.getWritableDatabase();
            String SQL="INSERT INTO HIJO VALUES(NULL,'<NOMBRE>','<IDT>',1)";

            SQL= SQL.replace("<NOMBRE>",hijo.getText().toString());
            SQL=SQL.replace("<IDT>",id.getText().toString());

            db.execSQL(SQL);

            db.close();

            id.setText("");
            hijo.setText("");
            Toast.makeText(this,"EXITO!",Toast.LENGTH_LONG).show();

        }catch(SQLiteException e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void mostrarDatos() {
        try{
            SQLiteDatabase db = conexion.getReadableDatabase();
            String SQL = "SELECT * FROM TRABAJADOR WHERE IDT = "+id.getText().toString();
            Cursor resultado = db.rawQuery(SQL,null);

            String SQL2 = "SELECT * FROM CONYUGUE WHERE IDT = "+id.getText().toString();
            Cursor resultado2 = db.rawQuery(SQL2,null);

            AlertDialog.Builder mensaje = new AlertDialog.Builder(MainActivity.this);

            if(resultado.moveToFirst()==true && resultado2.moveToFirst()==true){
                //Si hay datos

                mensaje.setTitle("Atencion!")
                        .setMessage("ID: "+resultado.getString(0)+'\n'+"Nombre: "+resultado.getString(1)+'\n'+"Puesto: "+resultado.getString(2)+'\n'+"Conyugue: "+resultado2.getString(1))
                        .setPositiveButton("Cerrar", new DialogInterface.OnClickListener(){
                            @Override public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();

            }
            else{
                //No se encontro ni un regitro
                Toast.makeText(this, "No se encontró resultado", Toast.LENGTH_SHORT).show();
            }

        }catch(SQLiteException e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void insertarTrabajador() {
        try{
            SQLiteDatabase base= conexion.getWritableDatabase();
            String SQL1="INSERT INTO TRABAJADOR VALUES('<IDT>','<NOMBRE>','<PUESTO>')";
            String SQL2="INSERT INTO CONYUGUE VALUES(NULL,'<NOMBRE>','<IDT>')";

            SQL1= SQL1.replace("<IDT>",id.getText().toString());
            SQL1= SQL1.replace("<NOMBRE>",nombre.getText().toString());
            SQL1= SQL1.replace("<PUESTO>",puesto.getText().toString());

            SQL2= SQL2.replace("<NOMBRE>",conyugue.getText().toString());
            SQL2= SQL2.replace("<IDT>",id.getText().toString());

            base.execSQL(SQL1);
            base.execSQL(SQL2);

            base.close();

            Toast.makeText(this,"EXITO",Toast.LENGTH_LONG).show();
            id.setText("");nombre.setText("");puesto.setText("");conyugue.setText("");


        }catch(SQLiteException e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
