package mx.edu.ittepic.calendarioreserva;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    public boolean onCreateOptionsMenu(android.view.Menu m){

        getMenuInflater().inflate(R.menu.menu,m);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem m) {
        switch (m.getItemId()) {

            case R.id.salir:
                finish();
                break;

        }
        return true;

    }
}
