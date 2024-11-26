package com.example.entregamomento2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registro extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference().child("Usuarios");

    Button btnVolverDesdeRegistroAHome;
    EditText inputIdUsuario;
    EditText inputNombreUsuario;
    EditText inputApellidoUsuario;
    EditText inputCorreoUsuario;
    EditText inputTelefonoUsuario;
    EditText inputContrasena;
    Button btnGuardarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);

        btnVolverDesdeRegistroAHome = findViewById(R.id.btn_volver_reg);
        inputIdUsuario = findViewById(R.id.input_user_id);
        inputNombreUsuario = findViewById(R.id.input_user_name);
        inputApellidoUsuario = findViewById(R.id.input_user_lastname);
        inputCorreoUsuario = findViewById(R.id.input_user_email);
        inputTelefonoUsuario = findViewById(R.id.input_user_phone);
        inputContrasena = findViewById(R.id.input_user_password);
        btnGuardarUsuario = findViewById(R.id.btn_registrar);

        btnVolverDesdeRegistroAHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irAlHome();
            }
        });

        btnGuardarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearUsuario();
            }
        });
    }
    public void irAlHome(){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
    public void crearUsuario(){
        String idUsuario = inputIdUsuario.getText().toString();
        DatabaseReference nuevoUsuario = reference.child(idUsuario);

        String nombre = inputNombreUsuario.getText().toString();
        nuevoUsuario.child("Nombre").setValue(nombre);

        String apellido = inputApellidoUsuario.getText().toString();
        nuevoUsuario.child("Apellildo").setValue(apellido);

        String correo = inputCorreoUsuario.getText().toString();
        nuevoUsuario.child("Correo").setValue(correo);

        String telefono = inputTelefonoUsuario.getText().toString();
        nuevoUsuario.child("Telefono").setValue(telefono);

        String contrasena = inputContrasena.getText().toString();
        nuevoUsuario.child("Contrasena").setValue(contrasena);

        Toast.makeText(getApplicationContext(), "Usuario Creado Exitosamente", Toast.LENGTH_LONG).show();
    }
}