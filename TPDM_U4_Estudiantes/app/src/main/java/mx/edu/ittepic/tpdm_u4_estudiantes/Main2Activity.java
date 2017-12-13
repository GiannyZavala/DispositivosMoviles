package mx.edu.ittepic.tpdm_u4_estudiantes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class Main2Activity extends AppCompatActivity {
    EditText nombre,domicilio,carrera,promedio,fechafalta;
    Button insetar;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombre=(EditText)findViewById(R.id.editText5);
        domicilio=(EditText)findViewById(R.id.editText6);
        carrera=(EditText)findViewById(R.id.editText7);
        promedio=(EditText)findViewById(R.id.editText8);
        fechafalta=(EditText)findViewById(R.id.editText9);
        insetar=(Button)findViewById(R.id.button4);
        resultado=(TextView)findViewById(R.id.textView2);


        insetar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              ConexionWeb3 conexionWeb3 = new ConexionWeb3(Main2Activity.this);
                conexionWeb3.agregarVariables("nombre",nombre.getText().toString());
                conexionWeb3.agregarVariables("domicilio",domicilio.getText().toString());
                conexionWeb3.agregarVariables("carrera",carrera.getText().toString());
                conexionWeb3.agregarVariables("promedio",promedio.getText().toString());
                conexionWeb3.agregarVariables("fechafalta",fechafalta.getText().toString());


                try{
                    URL direccion= new URL("http://giannyeduardo.esy.es/estudiantefaltainsertar.php");
                    conexionWeb3.execute(direccion);

                }catch (MalformedURLException e){
                    Toast.makeText(Main2Activity.this,"ERROR EN URL",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
