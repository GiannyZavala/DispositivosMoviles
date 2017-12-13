package mx.edu.ittepic.tpdm_u1_menu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button b = (Button) findViewById(R.id.button_menu);

        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                startActionMode(mActionModeCallback);
            }
        });

    }

    @SuppressLint("NewApi")
    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {


        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {

            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
            return true;
        }


        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }


        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu:
                    Toast.makeText(getApplicationContext(), "Opción 1",
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu2:
                    Toast.makeText(getApplicationContext(), "Opción 2",
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu3:
                    Toast.makeText(getApplicationContext(), "Opción 3",
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu4:
                    Toast.makeText(getApplicationContext(),"Opción 4",
                            Toast.LENGTH_SHORT).show();
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode arg0) {
            // TODO Auto-generated method stub

        }

        

    };

}