package mx.edu.ittepic.tpdm_u5_proyecto;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class Registro extends AppCompatActivity {
    EditText nombre, domicilio, telefono, usuario, contrasena;
    Button registrar;
    TextView resultado;
    ConexionWeb2 conexionWeb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nombre = (EditText) findViewById(R.id.editText);
        domicilio = (EditText) findViewById(R.id.editText1);
        telefono = (EditText) findViewById(R.id.editText7);
        usuario = (EditText) findViewById(R.id.editText8);
        contrasena = (EditText) findViewById(R.id.editText9);
        registrar = (Button) findViewById(R.id.button);
        resultado = (TextView) findViewById(R.id.textView11);


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conexionWeb2 = new ConexionWeb2 (Registro.this);
                conexionWeb2.agregarVariables("nombre", nombre.getText().toString());
                conexionWeb2.agregarVariables("domicilio", domicilio.getText().toString());
                conexionWeb2.agregarVariables("telefono", telefono.getText().toString());
                conexionWeb2.agregarVariables("usuario", usuario.getText().toString());
                conexionWeb2.agregarVariables("contrasena", contrasena.getText().toString());


                nombre.setText("");
                domicilio.setText("");
                telefono.setText("");
                usuario.setText("");
                contrasena.setText("");


                try {

                    URL direccionWeb = new URL("http://giannyeduardo.esy.es/registro.php");
                    conexionWeb2.execute(direccionWeb);

                } catch (MalformedURLException e) {
                    Toast.makeText(Registro.this, "Error en la direccion URL", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void mostrarMensajeEnAlert(String contenido) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);

        resultado.setText("");
        alerta.setTitle("Respuesta del servidor").setMessage(contenido).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        }).show();


    }
}
