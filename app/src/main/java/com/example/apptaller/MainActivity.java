package com.example.apptaller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText CampName;

    CheckBox Robot;
    CheckBox Persona;

    RadioButton R_Aceptar;

    boolean confirmar = false;

    boolean AceptarT = false;

    String SRobot ="No";
    String SPersona = "No";

    String Aceptar = "No";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CampName = findViewById(R.id.Name);
        Robot = findViewById(R.id.RobotSi);
        Persona = findViewById(R.id.PersonaSi);
        R_Aceptar = findViewById(R.id.RadioAceptar);

        Robot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Persona.setChecked(false);
                    confirmar = true;
                    SRobot = "Si";
                }else{
                    SRobot = "No";
                }
            }
        });

        Persona.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Robot.setChecked(false);
                    confirmar = true;
                    SPersona = "Si";
                }else{
                    SPersona = "No";
                }
            }
        });
        R_Aceptar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AceptarT = true;
                    Aceptar = "Si";
                }
            }
        });

    }

    public boolean validar(){
        boolean verificar = true;
        String CName = CampName.getText().toString();
        if (CName.isEmpty()){
            CampName.setError("No me dejes con la duda... ¿Cómo te llamas?");
            verificar = false;
        }
        if (!confirmar) {
            Toast.makeText(getApplicationContext(), "Responde! Marca una opción", Toast.LENGTH_SHORT).show();
            verificar = false;
        }
        if (!AceptarT) {
            Toast.makeText(getApplicationContext(), "Debe Aceptar los Terminos y Condiciones", Toast.LENGTH_SHORT).show();
            verificar = false;
        }
        return verificar;
    }

    public void Entrar(View v){
        if(validar()) {
            Bundle DatosName = new Bundle();
            Bundle DatosRobot = new Bundle();
            Bundle DatosPersona = new Bundle();
            Bundle Terminos = new Bundle();

            DatosName.putString("keyDatosName", CampName.getText().toString());
            DatosRobot.putString("keyDatosRobot", SRobot);
            DatosPersona.putString("keyDatosPersona", SPersona);
            Terminos.putString("keyDatosTerminos", Aceptar);


            Intent ir = new Intent(this, Bienvenido.class);

            ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TASK | ir.FLAG_ACTIVITY_CLEAR_TOP);
            ir.putExtras(DatosName);
            ir.putExtras(DatosRobot);
            ir.putExtras(DatosPersona);
            ir.putExtras(Terminos);
            startActivity(ir);
        }
    }
}