package mx.edu.ittepic.tpdm_u3_practica1;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
     //SQLite  -> Investigar SQLite

    EditText id,nombre,domicilio;
    Button insertar,mostrar,eliminar,actualizar,limpia;
    ConexionDB conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        id=(EditText)findViewById(R.id.editText);
        nombre=(EditText)findViewById(R.id.editText2);
        domicilio=(EditText)findViewById(R.id.editText3);

        insertar=(Button)findViewById(R.id.button);
        mostrar=(Button)findViewById(R.id.button2);
        eliminar=(Button)findViewById(R.id.button3);
        actualizar=(Button)findViewById(R.id.button4);
        limpia=(Button)findViewById(R.id.button5);

        conexion = new ConexionDB(this,"BD_Ejemplo1",null,1);


        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertar();
            }
        });

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                seleccion();

            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elimina();
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualiza();
            }
        });

        limpia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });
    }

    private void limpiar() {

        nombre.setText("");id.setText("");domicilio.setText("");

    }


    private void actualiza() {
            try {
                SQLiteDatabase db_ejemplo1 = conexion.getWritableDatabase();
                String instruccionSQL = "UPDATE PERSONA SET NOMBRE='"+nombre.getText().toString()+"', DOMICILIO ='"+domicilio.getText().toString()+"' WHERE ID = "+id.getText().toString()+"";

                db_ejemplo1.execSQL(instruccionSQL);
                db_ejemplo1.close();
                Toast.makeText(this,"Dato actualizado con exito!",Toast.LENGTH_SHORT).show();
            }catch (SQLiteException e){
                Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

    private void elimina() {
        try{
            SQLiteDatabase db_ejemplo1 = conexion.getWritableDatabase();


            String instruccionSQL="DELETE FROM PERSONA WHERE ID="+id.getText().toString();

            instruccionSQL= instruccionSQL.replace("<ID>",id.getText().toString());
            instruccionSQL= instruccionSQL.replace("<NOMBRE>",nombre.getText().toString());
            instruccionSQL= instruccionSQL.replace("<DOMICILIO>", domicilio.getText().toString());

            db_ejemplo1.execSQL(instruccionSQL);
            db_ejemplo1.close();

            Toast.makeText(this,"Persona eliminada correctamente", Toast.LENGTH_SHORT).show();
            nombre.setText("");id.setText("");domicilio.setText("");

        }catch(SQLException e){
            Toast.makeText(this, e.getMessage(),Toast.LENGTH_LONG).show();

        }

    }

    private void seleccion() {
        try {
            SQLiteDatabase db = conexion.getReadableDatabase();
            String SQL = "SELECT * FROM PERSONA WHERE ID ="+id.getText().toString();

            Cursor resultado = db.rawQuery(SQL, null);

            if(resultado.moveToFirst()==true){
                //si hay datos
                nombre.setText(resultado.getString(1));
                domicilio.setText(resultado.getString(2));
            }else{
                // no se encontro el registro
                Toast.makeText(this,"Nose encontro el resultado",Toast.LENGTH_SHORT).show();
            }


        }catch (SQLiteException e){
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void insertar() {
        try{
            SQLiteDatabase db_ejemplo1 = conexion.getWritableDatabase();
            //String instruccionSQL = "INSERT INTO PERSONA VALUES("+id.getText().toString()+",'"+nombre.getText().toString()+"',"+domicilio.getText().toString()+")";


            String instruccionSQL="INSERT INTO PERSONA VALUES('<ID>','<NOMBRE>','<DOMICILIO>')";

            instruccionSQL= instruccionSQL.replace("<ID>",id.getText().toString());
            instruccionSQL= instruccionSQL.replace("<NOMBRE>",nombre.getText().toString());
            instruccionSQL= instruccionSQL.replace("<DOMICILIO>", domicilio.getText().toString());

            db_ejemplo1.execSQL(instruccionSQL);
            db_ejemplo1.close();

            Toast.makeText(this,"Persona registrada correctamente", Toast.LENGTH_SHORT).show();
            nombre.setText("");id.setText("");domicilio.setText("");

        }catch(SQLException e){
            Toast.makeText(this, e.getMessage(),Toast.LENGTH_LONG).show();

        }
    }
}
