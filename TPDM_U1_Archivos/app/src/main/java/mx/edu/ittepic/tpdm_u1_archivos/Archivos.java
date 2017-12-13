package mx.edu.ittepic.tpdm_u1_archivos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Archivos extends AppCompatActivity {
     EditText campo1,campo2;
     Button boton,boton2;
     String[] n=new String[3];
     FileOutputStream inc;
     String nombre_archivo="Datos.txt";
     List<String> lista1=new ArrayList<String>();
     List<String> lista2=new ArrayList<String>();
     List<String> lista3=new ArrayList<String>();
     public static String[][] listas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archivos);
        campo1 = (EditText) findViewById(R.id.editText);
        campo2 = (EditText) findViewById(R.id.editText2);
        boton = (Button) findViewById(R.id.button);
        boton2 = (Button) findViewById(R.id.button2);
    }


    public void captura_datos(){
        n[0]=campo1.getText().toString();
        n[1]=campo2.getText().toString();
    }

    public void escribir(String[] texto) throws IOException{
        inc=this.openFileOutput(nombre_archivo, Context.MODE_APPEND);


           for (int i=0;i<2;i++){
               if(TextUtils.isEmpty(texto[i])){
                   inc.write("0".getBytes());
               }
               else{
                   inc.write(texto[i].getBytes());
               }
               inc.write(";".getBytes());
           }
          inc.write("\n".getBytes());
        inc.close();
    }
    public void leer_columna(String nombre, List<String> arreglo, int columna)throws IOException{
        String linea;
        InputStreamReader archivo = new InputStreamReader(openFileInput(nombre));
        BufferedReader reader=new BufferedReader(archivo);
        if(archivo!=null){
            while((linea=reader.readLine())!=null){
                arreglo.add(linea.split(";")[columna]);
            }
        }
        archivo.close();
    }
    public void boton_escribir(View v) throws IOException{
        captura_datos();
        escribir(n);

    }
    public void boton_mostrar(View v) throws IOException{
        leer_columna(nombre_archivo,lista1,0);
        listas=new String[2][lista1.size()];

        listas[0]=lista1.toArray(new String[lista1.size()]);

        leer_columna(nombre_archivo,lista2,1);
        listas[1]=lista2.toArray(new String[lista2.size()]);


        Intent ver_lista=new Intent(this,Lista.class);
        startActivity(ver_lista);
    }
}
