package com.example.pablo384.leccion1tarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ThirtyActivity extends AppCompatActivity {

    private ImageButton imgbt;
    private Button shared;

    // Otros valores
    private String name;
    private int age;
    private int typeOfMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirty);

        // Activar la flecha para volver al activity principal
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgbt=(ImageButton)findViewById(R.id.imageButton);
        shared=(Button)findViewById(R.id.buttonToShare);

        // Recogemos el nombre del activity anterior
        Bundle bundle= getIntent().getExtras();
        if(bundle !=null){
            name=bundle.getString("name");
            age=bundle.getInt("age");
            typeOfMessage=bundle.getInt("opcion");

        }

        imgbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirtyActivity.this,getmensaje(name,age,typeOfMessage),Toast.LENGTH_LONG).show();
                imgbt.setVisibility(View.INVISIBLE);
                shared.setVisibility(View.VISIBLE);
            }
        });

        shared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,getmensaje(name,age,typeOfMessage));
                startActivity(i);
            }
        });
    }

    private String getmensaje(String name, int age, int typeOfMessage){
        if(typeOfMessage==SecondActivity.FAREWELL_OPTION){
            return "Hola "+name+", como llevas esos "+age+" anos? #pablo384";
        }else {
            return "Espero verte pronto "+name+", antes que cumplas "+(age+1)+"... #pablo384";
        }
    }
}
