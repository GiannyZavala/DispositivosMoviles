package mx.edu.ittepic.tpdm_u4_estudiantes;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GiannyEduardo on 17/05/17.
 */

public class ConexionWeb5 extends AsyncTask<URL,String,String> {

    List<String[]> variables;
    Main3Activity puntero;
    ProgressDialog dialogo;

    public ConexionWeb5(Main3Activity p){
        puntero=p;
        variables= new ArrayList<String[]>();
    }

    public void agregarVariables(String nombreVariable,String contenido){
        String[] temp={nombreVariable,contenido};

        variables.add(temp);
    }
    protected void onPreExecute(){
        dialogo=ProgressDialog.show(puntero,"Conectando","Conectando al servidor");
    }


    @Override
    protected String doInBackground(URL... urls) {
        String POST="";
        String respuestaDelServidor="";

        for(int i=0;i<variables.size();i++){
            String [] temp=variables.get(i);
         try {


             POST += temp[0] + "=" + URLEncoder.encode(temp[1], "UTF-8")+" ";
         }catch(Exception e){
             return "2311";
          }
        }
        POST=POST.trim();
        POST=POST.replaceAll(" ","&");


        HttpURLConnection conexion=null;

        try{
            conexion=(HttpURLConnection) urls[0].openConnection();

            conexion.setDoOutput(true); //se envia en post
            conexion.setFixedLengthStreamingMode(POST.length()); //se indica la cantidad de datos a enviar

           publishProgress("Enviando datos...");
            OutputStream flujoSalida= new BufferedOutputStream(conexion.getOutputStream());
            flujoSalida.write(POST.getBytes());
            flujoSalida.flush(); //garantizas no se quede en buffer
            flujoSalida.close();

            if(conexion.getResponseCode()==200){
                publishProgress("Recibiendo respuesta del servidor...");
                InputStreamReader flujoEntrada= new InputStreamReader(conexion.getInputStream(),"UTF-8");
                BufferedReader lineaFlujoEntrada = new BufferedReader(flujoEntrada);

                String linea = "";

                do{
                    linea= lineaFlujoEntrada.readLine();
                    if(linea!=null){
                        respuestaDelServidor+=linea;
                    }
                }while(linea!=null);
            }else{
                return "555";
            }

        }catch (UnknownHostException e){
            return "408";
        }catch (IOException e){
            return "333";
        }finally {
            if (conexion!=null){
                conexion.disconnect();
            }
        }
        return respuestaDelServidor;
    }
    protected void onProgressUpdate(String... informe){
        dialogo.setMessage(informe[0]);
    }

    protected void onPostExecute(String resp) {
        dialogo.dismiss();
        puntero.resultadofalta.setText(resp);
    }
}
