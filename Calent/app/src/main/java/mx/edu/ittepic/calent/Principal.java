package mx.edu.ittepic.calent;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class Principal extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2;

    private int dia,mes,año,hora,minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button3);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == btn1) {
            final Calendar c = Calendar.getInstance();

            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            año = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    btn1.setText(dayOfMonth + "/" + month + 1 + "/" + year);
                }
            }, dia, mes, año);

            datePickerDialog.show();

        }

        if(v==btn2){
            final Calendar c = Calendar.getInstance();
            hora=c.get(Calendar.HOUR_OF_DAY);
            minutos=c.get(Calendar.MINUTE);


            TimePickerDialog timePickerDialog= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    btn2.setText(hourOfDay+":"+minute);
                }
            },hora,minutos,false);

            timePickerDialog.show();

        }
    }
}
