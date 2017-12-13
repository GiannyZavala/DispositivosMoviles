package mx.edu.ittepic.multimedia1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by GiannyEduardo on 06/03/17.
 */

public class Lienzo extends View {
     Bitmap img;
    int xIcono, yIcono;
    int xTexto;
    CountDownTimer timer;

    public Lienzo (Context context){
        super(context);



       //CARGANDO EL CONETENIDO DEL PNG AL OBJETO BITMAP
        img= BitmapFactory.decodeResource(getResources(),R.drawable.carne1);
        yIcono=xIcono=500;
        xTexto=50;


        timer= new CountDownTimer(2000,30) {
            @Override
            public void onTick(long millisUntilFinished) {
                //se ejecuta cuando sucede el lapso
                //199,198,197,...,0 se dispara el ONTICK
                //restando valor al TOTAL 2000-200=1800-200=1600... 0
                xTexto+=5;
                invalidate();
                if(xTexto>1200){
                    xTexto=-100;
                }

            }

            @Override
            public void onFinish() {

                start();
            }
        };
        timer.start();
    }

    protected void onDraw(Canvas c){
        Paint p=new Paint();

        p.setColor(Color.RED);
        p.setTextSize(40.5f);
        c.drawText("Gianny Eduardo",xTexto,50,p);

        p.setStrokeWidth(10.2f);
        p.setColor(Color.RED);
        c.drawCircle(200,300,150,p);
        p.setStyle(Paint.Style.STROKE);
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.BLUE);
        c.drawCircle(200,300,150,p);


        p.setColor(Color.LTGRAY);
        c.drawRect(200,550,500,600,p);


        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.DKGRAY);


        c.drawRect(200,550,500,600,p);

        c.drawBitmap(img,xIcono,yIcono,p);


    }


    public boolean onTouchEvent(MotionEvent e){



        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                //CUANDO SE PRESIONA
                xIcono=(int) e.getX()-img.getWidth()/2;
                yIcono=(int) e.getY()-img.getHeight()/2;
                break;
            case MotionEvent.ACTION_MOVE:
                //CUANDO SE ARRASTRA
                xIcono=(int) e.getX()-img.getWidth()/2;;
                yIcono=(int) e.getY()-img.getHeight()/2;
                break;
            case MotionEvent.ACTION_UP:
                //CUANDO DESPUES DE PRESIONAR, SE LIBERA
                break;
        }

          invalidate();
        return true;

    }
}
