package mx.edu.ittepic.tpdm_u3_practica2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


public class Descriptores extends AppCompatActivity implements OnClickListener{
    Button tomar;
    ImageView foto;
    Intent i;
    final static int cons=0;
    Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descriptores);

        tomar=(Button)findViewById(R.id.button);
        tomar.setOnClickListener(this);
        foto=(ImageView)findViewById(R.id.imagen);
        init();
    }
     public void init(){

     }


    @Override
    public void onClick(View v) {
      int id;
        id=v.getId();
        switch(id){
            case R.id.button:
                i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(i,cons);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode== Activity.RESULT_OK){
            Bundle ext=data.getExtras();
            bmp=(Bitmap)ext.get("data");
            foto.setImageBitmap(bmp);
        }
    }
}
