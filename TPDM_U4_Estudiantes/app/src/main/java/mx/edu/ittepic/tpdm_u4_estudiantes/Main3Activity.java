package mx.edu.ittepic.tpdm_u4_estudiantes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class Main3Activity extends AppCompatActivity {
    EditText claveBuscar,fechafalta;
    RadioButton noaplicar,aplicar;
    TextView resultadobusqueda,resultadofalta;
    Button buscar,aplicarfalta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        claveBuscar=(EditText)findViewById(R.id.editText11);
        fechafalta=(EditText)findViewById(R.id.editText12);
        noaplicar=(RadioButton)findViewById(R.id.radioButton);
        aplicar=(RadioButton)findViewById(R.id.radioButton2);
        resultadobusqueda=(TextView)findViewById(R.id.textView3);
        resultadofalta=(TextView)findViewById(R.id.textView4);
        buscar=(Button)findViewById(R.id.button5);
        aplicarfalta=(Button)findViewById(R.id.button6);


        noaplicar.setEnabled(false);
        aplicar.setEnabled(false);
        aplicarfalta.setEnabled(false);


        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConexionWeb4 conexionWeb4 = new ConexionWeb4(Main3Activity.this);
                conexionWeb4.agregarVariables("idestudiante",claveBuscar.getText().toString());

                try{
                    URL direccion= new URL("http://giannyeduardo.esy.es/estudianteconsulta.php");
                    conexionWeb4.execute(direccion);
                }catch(MalformedURLException e){

                }
            }
        });
          aplicarfalta.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if(!aplicar.isChecked()){
                      Toast.makeText(Main3Activity.this,"DEBE SELECCIONAR EL RADIO BOTON APLICAR FALTA",Toast.LENGTH_LONG).show();

                      return;
                  }
                  ConexionWeb5 conexionWeb5 = new ConexionWeb5(Main3Activity.this);
                  conexionWeb5.agregarVariables("idestudiante",claveBuscar.getText().toString());
                  conexionWeb5.agregarVariables("fechafalta",fechafalta.getText().toString());

                  try{
                      URL direccion = new URL("http://giannyeduardo.esy.es/faltainsertar.php");
                      conexionWeb5.execute(direccion);
                      fechafalta.setText("");
                  }catch (MalformedURLException e){

                  }
              }
          });
    }
}
