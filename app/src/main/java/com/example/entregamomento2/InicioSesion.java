package com.example.entregamomento2;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import androidx.activity.EdgeToEdge;
        import androidx.appcompat.app.AppCompatActivity;

        public class InicioSesion extends AppCompatActivity {

            Button btnIniciarSesion;
            Button btnVolverHome2;
            EditText inputCorreoSesion;
            EditText inputPasswordSesion;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                EdgeToEdge.enable(this);
                setContentView(R.layout.activity_inicio_sesion);

                btnIniciarSesion = findViewById(R.id.btn_iniciar_sesion);
                btnVolverHome2 = findViewById(R.id.btn_volver_iniciosesion);
                inputCorreoSesion = findViewById(R.id.input_email);
                inputPasswordSesion = findViewById(R.id.input_password);

                btnVolverHome2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        irAlHome2();
                    }
                });

                btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        irDashboardDesdeInicioSesion();
                    }
                });
            }
            public void irAlHome2(){
                Intent intent = new Intent(this, Home.class);
                startActivity(intent);
            }
            public void irDashboardDesdeInicioSesion(){
                Intent intent = new Intent(this, DashBoard.class);
                startActivity(intent);
            }
        }