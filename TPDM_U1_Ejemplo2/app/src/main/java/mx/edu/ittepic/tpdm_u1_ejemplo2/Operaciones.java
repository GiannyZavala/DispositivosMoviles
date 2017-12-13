package mx.edu.ittepic.tpdm_u1_ejemplo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Operaciones extends AppCompatActivity {
     EditText edt1;
     EditText edt2;
     Spinner  spinner1;
     Button boton1;
     TextView resul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones);

        edt1 = (EditText) findViewById(R.id.editText3);
        edt2 = (EditText) findViewById(R.id.editText4);
        boton1 = (Button) findViewById(R.id.button);
        resul = (TextView) findViewById(R.id.textView8);

        spinner1 = (Spinner) findViewById(R.id.spinner);
        String[] opciones = {"sumar", "restar", "multiplicar", "dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);
    }





    public void resultado(View view) {
        String valor1=edt1.getText().toString();
        String valor2=edt2.getText().toString();
        int nro1=Integer.parseInt(valor1);
        int nro2=Integer.parseInt(valor2);
        String selec=spinner1.getSelectedItem().toString();
        if (selec.equals("sumar")) {
            int suma=nro1+nro2;
            String resu=String.valueOf(suma);
            resul.setText(resu);

        } else
        if (selec.equals("restar")) {
            int resta=nro1-nro2;
            String resu=String.valueOf(resta);

        }
        else
        if (selec.equals("multiplicar")) {
            int multi=nro1*nro2;
            String resu=String.valueOf(multi);


        }
        else
        if (selec.equals("dividir")) {
            int divi=nro1/nro2;
            String resu=String.valueOf(divi);

        }
    }


}
