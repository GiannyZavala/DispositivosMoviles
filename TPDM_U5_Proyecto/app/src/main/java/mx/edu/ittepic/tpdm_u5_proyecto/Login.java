package mx.edu.ittepic.tpdm_u5_proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
     Button inicio,registrar;
     EditText usuario,contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicio=(Button)findViewById(R.id.button5);
        registrar=(Button)findViewById(R.id.button6);
        usuario=(EditText)findViewById(R.id.editText5);
        contraseña=(EditText)findViewById(R.id.editText6);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro =new Intent(Login.this,Registro.class);
                startActivity(registro);
            }
        });
    }
}
