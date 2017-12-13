package mx.edu.ittepic.tpdm_u4_estudiantes;

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
    EditText nombre,domicilio,carrera,promedio;
    Button insertar,consultar,consultaMultiple;
    ConexionWeb conexionWeb;
    TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=(EditText) findViewById(R.id.editText);
        domicilio=(EditText)findViewById(R.id.editText2);
        carrera=(EditText)findViewById(R.id.editText3);
        promedio=(EditText)findViewById(R.id.editText4);
        insertar=(Button)findViewById(R.id.button);
        consultar=(Button)findViewById(R.id.button2);
        resultado=(TextView)findViewById(R.id.textView);
        consultaMultiple=(Button)findViewById(R.id.button3);


        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConexionWeb conexionWeb = new ConexionWeb(MainActivity.this);
                conexionWeb.agregarVariables("nombre",nombre.getText().toString());
                conexionWeb.agregarVariables("domicilio",domicilio.getText().toString());
                conexionWeb.agregarVariables("carrera",carrera.getText().toString());
                conexionWeb.agregarVariables("promedio",promedio.getText().toString());


                nombre.setText("");
                domicilio.setText("");
                carrera.setText("");
                promedio.setText("");

                try{

                    URL direccionWeb= new URL("http://giannyeduardo.esy.es/estudianteinsertar.php");
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
        consultaMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preguntaConsultaMultiple();
            }
        });
    }

    private void preguntaConsultaMultiple() {
        AlertDialog.Builder pregunta= new AlertDialog.Builder(this);
        final EditText claveABuscar= new EditText(this);

        claveABuscar.setHint("Escriba la clave a buscar");
        claveABuscar.setText("");



        pregunta.setTitle("Atención:")
                .setView(claveABuscar).setPositiveButton("Consultar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
                consultaMultipleEstudiante(claveABuscar.getText().toString());
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).show();

    }

    private void consultaMultipleEstudiante(String clave) {
        ConexionWeb2 conexion2 = new ConexionWeb2(this);
        conexion2.agregarVariables("clave",clave);

        try{
            URL direccionWeb= new URL("http://giannyeduardo.esy.es/consultaestudiantemultiple.php");
            conexion2.execute(direccionWeb);

        }catch (MalformedURLException e){
           //Toast
        }

    }


    private void preguntarIDConsulta() {

        AlertDialog.Builder pregunta= new AlertDialog.Builder(this);
        final EditText id= new EditText(this);

        id.setHint("Escriba ID del Estudiante");
        id.setText("");



        pregunta.setView(id).setPositiveButton("Consultar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
                consultarEstudiante(id.getText().toString());
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).show();
    }

    private void consultarEstudiante(String id){
        conexionWeb = new ConexionWeb(MainActivity.this);
        conexionWeb.agregarVariables("idestudiante",id);


        try{

            URL direccion= new URL("http://giannyeduardo.esy.es/estudianteconsulta.php");
            conexionWeb.execute(direccion);
        }catch (MalformedURLException e){

            Toast.makeText(MainActivity.this,"Error en la direccion URL",Toast.LENGTH_LONG).show();
            //toast
        }
    }
}
