package com.example.pablo384.leccion1tarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Button btn2;
    private RadioButton rb1, rb2;
    private TextView textEdad;
    private SeekBar seek;

    //otros valores
    private String name="";
    private int age=18;
    private static final int MAX_AGE=60;
    private static final int MIN_AGE=16;

    // Para compartir
    public static final int GREETER_OPTION = 1;
    public static final int FAREWELL_OPTION = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Activar la flecha para volver al activity principal
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn2=(Button)findViewById(R.id.button_siguiente2);
        rb1=(RadioButton)findViewById(R.id.radioButton_Greeter);
        rb2=(RadioButton)findViewById(R.id.radioButton_Farewall);
        textEdad=(TextView)findViewById(R.id.textView_edad);
        seek=(SeekBar)findViewById(R.id.seekBar);

        // Recogemos el nombre del activity anterior
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            name = bundle.getString("name");
        }


        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                age=progress;
                textEdad.setText(age+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                age=seekBar.getProgress();
                textEdad.setText(age+"");
                if(age>MAX_AGE){
                    btn2.setVisibility(View.INVISIBLE);
                    Toast.makeText(SecondActivity.this,"Su edad es muy Alta",Toast.LENGTH_LONG).show();
                }else if(age < MIN_AGE){
                    btn2.setVisibility(View.INVISIBLE);
                    Toast.makeText(SecondActivity.this,"Su edad es muy baja",Toast.LENGTH_LONG).show();
                }else {
                    btn2.setVisibility(View.VISIBLE);
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SecondActivity.this, ThirtyActivity.class);
                i.putExtra("name",name);
                i.putExtra("age",age);

                // Si el botón de greeter esta activo, option valdrá 1, si no, 2
                int opcion=(rb1.isChecked())? GREETER_OPTION:FAREWELL_OPTION;

                i.putExtra("opcion",opcion);


                startActivity(i);
                Toast.makeText(SecondActivity.this, seek.getProgress()+"",Toast.LENGTH_LONG).show();
            }
        });
    }
}
