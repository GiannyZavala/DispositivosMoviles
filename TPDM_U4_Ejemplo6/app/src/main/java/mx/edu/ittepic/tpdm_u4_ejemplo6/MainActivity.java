package mx.edu.ittepic.tpdm_u4_ejemplo6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
     Button b;
     TextView resultado;
     EditText numtarjetacredito;
     ConexionWeb conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b=(Button)findViewById(R.id.button);
        resultado=(TextView)findViewById(R.id.textView);
        numtarjetacredito=(EditText)findViewById(R.id.editText);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               conexion=new ConexionWeb(MainActivity.this);
                conexion.agregarVariables("numtarjeta",numtarjetacredito.getText().toString());

                try {
                    URL direccionDeMiServidor = new URL("http://www.tepicsoftware.com/consultabanco.php");

                 conexion.execute(direccionDeMiServidor);
                }catch(MalformedURLException e){

                }
            }
        });
    }
}
