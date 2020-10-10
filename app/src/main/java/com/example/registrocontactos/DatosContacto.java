package com.example.registrocontactos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;


public class DatosContacto extends AppCompatActivity{

    private TextView tvNombre;
    private TextView tvFechaNac;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_contacto);
        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString("NomCont");
        String fechaNac = parametros.getString("FechaNac");
        String telefono = parametros.getString("TelCont");
        String email = parametros.getString("EmailCont");
        String descrip = parametros.getString("DescCont");

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFechaNac = (TextView) findViewById(R.id.tvFechaNac);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDesc = (TextView) findViewById(R.id.tvDesc);

        tvNombre.setText(nombre);
        tvFechaNac.setText(fechaNac);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDesc.setText(descrip);


        Button botonEditar = (Button) findViewById(R.id.btnEditarDatos);

        botonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView campoNom = (TextView) findViewById(R.id.tvNombre);
                TextView campoFechaNac = (TextView) findViewById(R.id.tvFechaNac);
                TextView campoTel = (TextView) findViewById(R.id.tvTelefono);
                TextView campoEmail = (TextView) findViewById(R.id.tvEmail);
                TextView campoDesc = (TextView) findViewById(R.id.tvDesc);

                Intent intent = new Intent(DatosContacto.this, MainActivity.class);
                intent.putExtra("NomCont",campoNom.getText().toString());
                intent.putExtra("FechaNac",campoFechaNac.getText().toString());
                intent.putExtra("TelCont",campoTel.getText().toString());
                intent.putExtra("EmailCont",campoEmail.getText().toString());
                intent.putExtra("DescCont",campoDesc.getText().toString());
                startActivity(intent);
            }
        });
    }

}
