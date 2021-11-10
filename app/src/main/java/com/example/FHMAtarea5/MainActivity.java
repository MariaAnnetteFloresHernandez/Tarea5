package com.example.FHMAtarea5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    EditText Nombre, Correo, Telefono, Edad, Curp, Estado;
    TextView Json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nombre = findViewById(R.id.txtNombre);
        Correo = findViewById(R.id.txtCorreo);
        try {
            Telefono = findViewById(R.id.txtTelefono);
        }catch (NumberFormatException e){
            Toast.makeText(this, "Ingrese 10 digitos", Toast.LENGTH_SHORT).show();
        }
        Edad = findViewById(R.id.txtEdad);
        Curp = findViewById(R.id.txtCurp);
        Estado = findViewById(R.id.txtEstado);
        Json = findViewById(R.id.txtJson);
    }

    public void conversion(View v){

        Datos datos = new Datos();
        Gson gson = new Gson();

        String cgson;

        datos.setNombre(Nombre.getText().toString());
        datos.setCorreo(Correo.getText().toString());
        datos.setTelefono(Integer.parseInt(Telefono.getText().toString()));
        datos.setEdad(Integer.parseInt(Edad.getText().toString()));
        datos.setCurp(Curp.getText().toString());
        datos.setEstado(Estado.getText().toString());

        cgson = gson.toJson(datos);
        Json.setText(cgson);

    }
}

