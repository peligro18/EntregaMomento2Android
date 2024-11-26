package com.example.entregamomento2;

    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;

    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.app.AppCompatActivity;

    public class Home extends AppCompatActivity {

        Button btnIrRegistro;
        Button btnInicioSesion;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_home);

            btnInicioSesion = findViewById(R.id.btn_inicio_sesion);
            btnIrRegistro = findViewById(R.id.btn_registro);

            btnInicioSesion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    irAlInicioSesion();
                }
            });
            btnIrRegistro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    irAlRegistro();
                }
            });
        }
        public void irAlInicioSesion(){
            Intent intent = new Intent(this, InicioSesion.class);
            startActivity(intent);
        }
        public void irAlRegistro(){
            Intent intent = new Intent(this, Registro.class);
            startActivity(intent);
        }
    }