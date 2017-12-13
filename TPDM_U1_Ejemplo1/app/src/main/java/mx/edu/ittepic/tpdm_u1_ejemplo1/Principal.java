package mx.edu.ittepic.tpdm_u1_ejemplo1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    EditText nombrePersona;
    Button saludar,limpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //findViewById encontrarObjetoXsuIdentificador
        nombrePersona = (EditText) findViewById(R.id.editText);
        saludar = (Button) findViewById(R.id.button4);
        limpiar = (Button) findViewById(R.id.button3);


        //Eventos

        saludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Principal.this, "Hola " + nombrePersona.getText(), Toast.LENGTH_LONG).show();

                AlertDialog.Builder mensaje= new AlertDialog.Builder(Principal.this);
                mensaje.setTitle("Atención").setMessage("Hola"+nombrePersona.getText().toString()).setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                }).show();
               int valor= Integer.parseInt(nombrePersona.getText().toString());
            }

        });


        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nombrePersona.setText("");


            }
        });
    }
    public void salirAplicacion(View v) {
        finish();
    }
}
