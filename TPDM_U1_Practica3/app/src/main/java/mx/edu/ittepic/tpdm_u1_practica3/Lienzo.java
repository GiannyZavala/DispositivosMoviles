package mx.edu.ittepic.tpdm_u1_practica3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.View;

/**
 * Created by GiannyEduardo on 13/03/17.
 */

public class Lienzo extends View {
    CountDownTimer timer;
    int xTexto;

    public Lienzo(Context context) {
        super(context);
        xTexto=100;



        timer = new CountDownTimer(1000,50) {
            @Override
            public void onTick(long millisUntilFinished) {

                xTexto += 40;
                invalidate();
                if (xTexto > 1200) {
                    xTexto = -100;
                }
                else if (xTexto==1200){
                    xTexto-=1200;
                }

            }

            @Override
            public void onFinish() {
                //se ejecuta al finzalizar el conteo
                start();
            }
        };
        timer.start();


}



    protected void onDraw(Canvas c) {
        Paint p = new Paint();

          c.drawColor(Color.BLACK);




        //NAVES


        p.setStyle(Paint.Style.FILL_AND_STROKE);
       // p.setStyle(Paint.Style.FILL);
        p.setColor(Color.BLUE);
        c.drawCircle(xTexto,100,100,p);






    }

    }
