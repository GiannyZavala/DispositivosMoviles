package mx.edu.ittepic.tpdm_u2_practica2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

public class Juego extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        setContentView(new Lienzo(this,displaymetrics.heightPixels-160,displaymetrics.widthPixels));

    }
}

