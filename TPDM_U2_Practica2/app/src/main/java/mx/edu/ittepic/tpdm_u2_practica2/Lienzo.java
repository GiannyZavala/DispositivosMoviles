package mx.edu.ittepic.tpdm_u2_practica2;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;


public class Lienzo extends View{


    Principal[] creacirculos=new Principal[20];
    CountDownTimer timer,timer2;
    int alto;
    int ancho;
    boolean cond;
    int xImagen;
    Bitmap img;


    public Lienzo(Context context, int altura,int anchura){

        super(context);
        alto= altura;
        ancho=anchura;
        cond=false;
        Circulos();
        img= BitmapFactory.decodeResource(getResources(),R.drawable.ganaste);
        xImagen=10;


        timer=new CountDownTimer(2000,3) {
            @Override
            public void onTick(long millisUntilFinished) {
                xImagen+=5;
                invalidate();
                if(xImagen>1200){
                    xImagen=-100;
                }
            }

            @Override
            public void onFinish() {
                start();

            }
        };
                timer.start();

        timer2=new CountDownTimer(200,50) {
            @Override
            public void onTick(long millisUntilFinished) {
                for (int i=0;i<creacirculos.length;i++){
                    creacirculos[i].mover();
                }
                invalidate();
            }

            @Override
            public void onFinish() {
                timer2.start();
            }
        };
        timer2.start();
    }


    protected void onDraw(Canvas c){
        Paint p=new Paint();
        c.drawColor(Color.WHITE);
        if(cond){
            c.drawBitmap(img,xImagen,350,p);
        }
        for (int i=0;i<creacirculos.length;i++){
            p.setColor(creacirculos[i].getColor());
            c.drawCircle(creacirculos[i].getPosicion_x(),creacirculos[i].getPosicion_y(),creacirculos[i].getRadio(),p);
        }
    }
    public void Circulos(){
        for (int i=0;i<creacirculos.length;i++){
            creacirculos[i]=new Principal();
            creacirculos[i].Circulo(ancho,alto);
        }
    }


    public  boolean onTouchEvent(MotionEvent e){
        if(e.getAction() == MotionEvent.ACTION_DOWN) {
            for (int i = 0; i < creacirculos.length; i++) {
                if (creacirculos[i].dibuja((int) e.getX(), (int) e.getY())) {
                    creacirculos[i].posx = 0;
                    creacirculos[i].posy = 0;
                    creacirculos[i].radio = 0;
                }
            }

        }
        if(e.getAction() == MotionEvent.ACTION_UP){
                float sum=0;
                for (int i=0;i<creacirculos.length;i++){
                    sum=sum+creacirculos[i].radio;
                }
                if(sum==0){
                    cond=true;
                }
            return true;
        }
        invalidate();
        return true;
    }
}
