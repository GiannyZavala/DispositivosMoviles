package mx.edu.ittepic.tpdm_u1_ejemplo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Ventana1 extends AppCompatActivity {
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana1);

        lista = (ListView) findViewById(R.id.listaPrincipal);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                switch (i) {
                    case 0: abrirVentanaOperaciones();
                        break;
                    case 1: abrirVentanaDinamico();
                        break;
                    case 2:abrirAcercaDe(); //alert dialog
                        break;
                    default:
                        finish();
                }
            }
        });
    }

                //i es el ITEM SELECCIONADO, EL 1ER ITEM TOMA EL VALOR DE

                private void abrirVentanaOperaciones(){
                 Intent ventanaOperaciones=new Intent(this,Operaciones.class);

                    startActivity(ventanaOperaciones);
    }

              private void abrirAcercaDe(){
                  Intent ventanaAcercaDe=new Intent(this,Ventana2.class);

                  startActivity(ventanaAcercaDe);
              }

              private void abrirVentanaDinamico(){
                 Intent ventanaDinamica=new Intent(this,Dinamico.class);

                  startActivity(ventanaDinamica);
    }
    }

