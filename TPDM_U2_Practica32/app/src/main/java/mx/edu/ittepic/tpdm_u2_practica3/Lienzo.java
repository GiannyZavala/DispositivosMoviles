package mx.edu.ittepic.tpdm_u2_practica3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by GiannyEduardo on 15/03/17.
 */

public class Lienzo extends View {
    int xIcono, yIcono;
    int img;
    CountDownTimer timer;


    public Lienzo (Context context) {
        super(context);

        yIcono=xIcono=500;
        img=100;

    }


    protected void onDraw(Canvas c) {
        Paint p = new Paint();


    //FONDO
        c.drawColor(Color.BLACK);



        //NAVES

        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.rgb(0,128,255));
        c.drawOval(30,30,50,50,p);




        //PISTOLA

        p.setStrokeWidth(10.2f);
        p.setStyle(Paint.Style.STROKE);
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.rgb(138, 149, 151));
        c.drawRect(img,xIcono,yIcono,p);
    }


}
