package mx.edu.ittepic.tpdm_u3_practica2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout layo;
    TextView campos;
    ListView listView;
    ArrayList<String> listado;
    ConexionBD conexion;

    @Override
    protected void onPostResume(){
        super.onPostResume();
        cargarListado();
    }//onPostResume

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        layo = (LinearLayout) findViewById(R.id.layo);
        campos = (TextView) findViewById(R.id.textView);
        listView = (ListView) findViewById(R.id.listview);
        conexion = new ConexionBD(this,"DBTareas",null,1);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Principal.this,Descriptores.class);
                startActivity(intent);
                /*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                        */

            }
        });

        cargarListado();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int clave = Integer.parseInt(listado.get(position).split(" ")[0]);
                String descripcion = listado.get(position).split(" ")[1];
                String fecha = listado.get(position).split(" ")[2];
                String nota = listado.get(position).split(" ")[3];
                String titulo = "Tarea: "+ clave;

                Intent intent = new Intent(Principal.this,Descriptores.class);
                intent.putExtra("Id",clave);
                intent.putExtra("Descripcion",descripcion);
                intent.putExtra("Fecha",fecha);
                intent.putExtra("Notas",nota);
                intent.putExtra("Titulo",titulo);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void cargarListado(){
        listado = ListaProductos();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Principal.this,android.R.layout.simple_list_item_1,listado);
        listView.setAdapter(adapter);
    }

    private ArrayList<String> ListaProductos(){
        ArrayList<String> datos = new ArrayList<String>();
        SQLiteDatabase db = conexion.getReadableDatabase();
        String SQL1 = "SELECT IDT,DESCRIPCION,FECHA,NOTAS FROM TAREA";

        Cursor c = db.rawQuery(SQL1,null);
        if(c.moveToFirst()){
            do{
                String linea = c.getInt(0)+ " "+c.getString(1) + " " + c.getString(2) + " " + c.getString(3);
                datos.add(linea);
                datos.add("Tarea: ");
            }while(c.moveToNext());
        }//if
        db.close();
        return datos;
    }//ListarProductos

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
