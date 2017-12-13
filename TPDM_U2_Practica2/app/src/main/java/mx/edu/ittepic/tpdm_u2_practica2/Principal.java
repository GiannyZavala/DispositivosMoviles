package mx.edu.ittepic.tpdm_u2_practica2;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by GiannyEduardo on 09/03/17.
 */

public class Principal {

    int posx,posy,senx,seny,radio,color,totalanc,totalalt;
    Random random = new Random();

    public void Circulo(int ancho, int alto){
        totalalt=alto;totalanc=ancho;
        radio=random.nextInt(130-20)+20;
        posx=random.nextInt(ancho);
        posy=random.nextInt(alto);
        posicion();
        color= Color.rgb(random.nextInt(254), random.nextInt(254), random.nextInt(254));
    }

    public void mover(){
        if(senx==0){
            if(posx+radio>=totalanc){
                senx=1;
            }else{
                posx+=10;
            }
        }else{
            if(posx-radio<=0){
                senx=0;
            }else{
                posx-=10;
            }
        }
        if(seny==0){
            if(posy+radio>=totalalt){
                seny=1;
            }else{
                posy+=10;
            }
        }else{
            if(posy-radio<=0){
                seny=0;
            }else{
                posy-=10;
            }
        }
    }

    public void posicion(){
        if(posx-(radio)<0){
            posx=posx+radio;
        }
        if(posx+(radio)>totalanc) {
            posx=posx-radio;
        }
        if(posy-(radio)<0){
            posy=posy+radio;
        }
        if(posy+(radio)>totalalt) {
            posy=posy-radio;
        }
    }
    public boolean sin(){
        return true;
    }
    public int getColor() {
        return color;
    }

    public int getPosicion_x() {
        return posx;
    }

    public int getPosicion_y() {
        return posy;
    }

    public int getRadio() {
        return radio;
    }

    public boolean dibuja(int tocax, int tocay){
        if(tocax>posx-radio&&tocax<(posx+radio)
                &&tocay>posy-radio&&tocay<(posy+radio)){
            return true;
        }else{
            return false;
        }
    }

}