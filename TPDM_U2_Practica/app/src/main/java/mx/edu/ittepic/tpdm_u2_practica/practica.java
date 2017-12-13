package mx.edu.ittepic.tpdm_u2_practica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class practica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Lienzo(this));
    }
}
