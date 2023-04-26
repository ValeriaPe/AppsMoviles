package com.example.apptaller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Bienvenido extends AppCompatActivity {
    TextView Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);

        Text = findViewById(R.id.Text);

        Bundle RecibeName = getIntent().getExtras();
        String InfoName = RecibeName.getString("keyDatosName");
        Text.setText("Oh! Hola " + InfoName);
    }

    public void volver(View n){
        Intent ir = new Intent(this, MainActivity.class);

        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TASK | ir.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(ir);
    }
}