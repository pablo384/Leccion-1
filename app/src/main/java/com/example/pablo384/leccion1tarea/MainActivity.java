package com.example.pablo384.leccion1tarea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edit;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Forzar el logo, en todas las versiones android
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        edit =(EditText) findViewById(R.id.editText_Nombre);
        btn=(Button)findViewById(R.id.button_siguiente);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edit.getText().toString();
                if(edit !=null && !name.isEmpty()){
                    Intent intent=new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"El nombre no puede estar Vacio",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
