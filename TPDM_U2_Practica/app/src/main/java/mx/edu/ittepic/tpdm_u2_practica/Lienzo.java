package mx.edu.ittepic.tpdm_u2_practica;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by GiannyEduardo on 06/03/17.
 */

public class Lienzo extends View {

    public Lienzo(Context context) {
        super(context);


    }

    protected void onDraw(Canvas c) {
        Paint p = new Paint();


             //CIELO

            c.drawColor(Color.rgb(0,204,255));

            //NUBE
            p.setColor(Color.WHITE);
            p.setStyle(Paint.Style.FILL);
            c.drawOval(150, 140, 270, 250, p);
            c.drawOval(100, 180, 220, 280, p);
            c.drawOval(180, 180, 330, 290, p);


            //SOL
            p.setStrokeWidth(10.2f);
            p.setStyle(Paint.Style.STROKE);
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.YELLOW);
            c.drawCircle(600,90,80,p);


             //CESPED

            p.setStrokeWidth(10.2f);
            p.setStyle(Paint.Style.STROKE);
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.GREEN);
            c.drawRect(500,100,200,300,p);


            // ARBOL
            p.setStrokeWidth(10.2f);
            p.setStyle(Paint.Style.STROKE);
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.rgb(0,102,0));
            c.drawCircle(300, 800, 100, p);

            p.setStrokeWidth(10.2f);
            p.setStyle(Paint.Style.STROKE);
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.rgb(0,102,0));
            c.drawCircle(380, 800, 100, p);

            p.setStrokeWidth(10.2f);
            p.setStyle(Paint.Style.STROKE);
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.rgb(0,102,0));
            c.drawCircle(340, 730, 100, p);

           //TRONCO
            p.setStrokeWidth(10.2f);
            p.setStyle(Paint.Style.STROKE);
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.rgb(153,102,0));
            c.drawRect(300,890,380,1090,p);



           //FLOR

           p.setStrokeWidth(10.2f);
           p.setStyle(Paint.Style.STROKE);
           p.setStyle(Paint.Style.FILL);
           p.setColor(Color.RED);
           c.drawCircle(600, 940, 30, p);

           p.setStrokeWidth(10.2f);
           p.setStyle(Paint.Style.STROKE);
           p.setStyle(Paint.Style.FILL);
           p.setColor(Color.RED);
           c.drawCircle(620, 920, 30, p);

           p.setStrokeWidth(10.2f);
           p.setStyle(Paint.Style.STROKE);
           p.setStyle(Paint.Style.FILL);
           p.setColor(Color.RED);
           c.drawCircle(640, 940, 30, p);

           p.setStrokeWidth(10.2f);
           p.setStyle(Paint.Style.STROKE);
           p.setStyle(Paint.Style.FILL);
           p.setColor(Color.RED);
           c.drawCircle(620, 963, 30, p);

           p.setStrokeWidth(10.2f);
           p.setStyle(Paint.Style.STROKE);
           p.setStyle(Paint.Style.FILL);
           p.setColor(Color.YELLOW);
           c.drawCircle(620, 940, 20, p);


           p.setStrokeWidth(10.2f);
           p.setStyle(Paint.Style.STROKE);
           p.setStyle(Paint.Style.FILL);
           p.setColor(Color.GREEN);
           c.drawRect(610,990,630,1100,p);











        }


    }

