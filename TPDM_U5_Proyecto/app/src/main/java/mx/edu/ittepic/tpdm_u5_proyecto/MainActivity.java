package mx.edu.ittepic.tpdm_u5_proyecto;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText nombre,origen,destino,precio;
    Button insertar,consultar;
    ConexionWeb conexionWeb;
    TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=(EditText) findViewById(R.id.editText);
        origen=(EditText)findViewById(R.id.editText2);
        destino=(EditText)findViewById(R.id.editText3);
        precio=(EditText)findViewById(R.id.editText4);
        insertar=(Button)findViewById(R.id.button);
        consultar=(Button)findViewById(R.id.button2);
        resultado=(TextView)findViewById(R.id.textView);


        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conexionWeb = new ConexionWeb(MainActivity.this);
                conexionWeb.agregarVariables("nombre",nombre.getText().toString());
                conexionWeb.agregarVariables("origen",origen.getText().toString());
                conexionWeb.agregarVariables("destino",destino.getText().toString());
                conexionWeb.agregarVariables("precio",precio.getText().toString());


                nombre.setText("");
                origen.setText("");
                destino.setText("");
                precio.setText("");

                try{

                    URL direccionWeb= new URL("http://giannyeduardo.esy.es/clienteinsertar.php");
                    conexionWeb.execute(direccionWeb);

                }catch (MalformedURLException e){
                    Toast.makeText(MainActivity.this,"Error en la direccion URL",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void mostrarMensajeEnAlert(String contenido){
        AlertDialog.Builder alerta= new AlertDialog.Builder(this);

        resultado.setText("");
        alerta.setTitle("Respuesta del servidor").setMessage(contenido).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        }).show();

        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preguntarIDConsulta();


            }
        });

    }





    private void preguntarIDConsulta() {

        AlertDialog.Builder pregunta= new AlertDialog.Builder(this);
        final EditText id= new EditText(this);
        pregunta.setTitle("Consulta Cliente");
        id.setHint("Escriba ID del Estudiante");
        id.setText("");



        pregunta.setView(id).setPositiveButton("Consultar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
                consultarCliente(id.getText().toString());
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).show();
    }

    private void consultarCliente(String id){
        conexionWeb = new ConexionWeb(MainActivity.this);
        conexionWeb.agregarVariables("idcliente",id);


        try{

            URL direccion= new URL("http://giannyeduardo.esy.es/consultaviaje.php");
            conexionWeb.execute(direccion);
        }catch (MalformedURLException e){

            Toast.makeText(MainActivity.this,"Error en la direccion URL",Toast.LENGTH_LONG).show();
            //toast
        }
    }
}
