package mx.edu.ittepic.tpdm_u1_ejemplo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Dinamico extends AppCompatActivity {
     Button b1,b2,b3;
     TextView t1,t2,t3;
     LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamico);


        linear=(LinearLayout)findViewById(R.id.activity_dinamico);

        //Creando los botones
        b1= new Button(this);
        b2= new Button(this);
        b3= new Button(this);

        t1=new TextView(this);
        t2=new TextView(this);
        t3=new TextView(this);

        t1.setText("Hola");
        t2.setText("Como estas?");
        t2.setText("Saludos");

        b1.setText("Mostrar");
        b2.setText("Quitar el 1ero");
        b3.setText("Quitar el RESTO");


        linear.addView(b1);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    linear.addView(t1, 0);
                    linear.addView(t2);
                    linear.addView(b2);
                    linear.addView(t3);
                    linear.addView(b3);
                } catch (Exception e) {
                    Toast.makeText(Dinamico.this, "Al parecer ya estan mostrados", Toast.LENGTH_LONG).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    linear.removeViewAt(0);
                }catch(Exception e){
                    Toast.makeText(Dinamico.this,"Wow parace que no hay",Toast.LENGTH_LONG).show();
                }


            }

        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                }catch(Exception e){
                    Toast.makeText(Dinamico.this,"Parece que no se puede borrar",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
