package mx.edu.ittepic.tpdm_u3_practica1;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.SQLException;
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
    EditText id_cliente,nombre,direccion,telefono,email,id_factura,fecha;
    Button insertar,mostrar,actualizar,eliminar;
    ConexionDB conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        id_cliente=(EditText)findViewById(R.id.editText);
        nombre=(EditText)findViewById(R.id.editText2);
        direccion=(EditText)findViewById(R.id.editText3);
        telefono=(EditText)findViewById(R.id.editText4);
        email=(EditText)findViewById(R.id.editText5);
        id_factura=(EditText)findViewById(R.id.editText6);
        fecha=(EditText)findViewById(R.id.editText7);
        insertar=(Button)findViewById(R.id.button);
        mostrar=(Button)findViewById(R.id.button2);
        actualizar=(Button)findViewById(R.id.button3);
        eliminar=(Button)findViewById(R.id.button4);
        conexion = new ConexionDB(this,"baseDatosEjemplo2",null,1);


        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarCliente();
            }
        });

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarClientes();
            }
        });
    }

    private void mostrarClientes() {

        try{
            SQLiteDatabase db = conexion.getReadableDatabase();
            String SQL = "SELECT * FROM CLIENTE WHERE ID_CLIENTE = "+id_cliente.getText().toString();
            Cursor resultado = db.rawQuery(SQL,null);


            AlertDialog.Builder mensaje = new AlertDialog.Builder(MainActivity.this);

            if(resultado.moveToFirst()==true){
                //Si hay datos

                mensaje.setTitle("Atencion!")
                        .setMessage("ID_CLIENTE: "+resultado.getString(0)+'\n'+"NOMBRE: "+resultado.getString(1)+'\n'+"DIRECCION: "+resultado.getString(2)+'\n'+"TELEFONO: "+resultado.getString(3)+'\n'+"EMAIL: "+resultado.getString(4))
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

    private void insertarCliente() {

        try{
            SQLiteDatabase base= conexion.getWritableDatabase();
            String SQL1="INSERT INTO CLIENTE VALUES('<ID_CLIENTE>','<NOMBRE>','<DIRECCION>','<TELEFONO>','<EMAIL>')";
            String SQL2="INSERT INTO FACTURA VALUES(NULL,'<ID_FACTURA>','<FECHA>')";

            SQL1= SQL1.replace("<ID_CLIENTE>",id_cliente.getText().toString());
            SQL1= SQL1.replace("<NOMBRE>",nombre.getText().toString());
            SQL1= SQL1.replace("<DIRECCION>",direccion.getText().toString());
            SQL1= SQL1.replace("<TELEFONO>",telefono.getText().toString());
            SQL1= SQL1.replace("<EMAIL>",email.getText().toString());



            SQL2= SQL2.replace("<ID_FACTURA>",id_factura.getText().toString());
            SQL2= SQL2.replace("<FECHA>",fecha.getText().toString());
            SQL2=SQL2.replace("<ID_CLIENTE>",id_cliente.getText().toString());

            base.execSQL(SQL1);
            base.execSQL(SQL2);

            base.close();

            Toast.makeText(this,"EXITO",Toast.LENGTH_LONG).show();
            id_cliente.setText("");nombre.setText("");direccion.setText("");telefono.setText("");email.setText("");id_factura.setText("");fecha.setText("");

        }catch(SQLException e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
