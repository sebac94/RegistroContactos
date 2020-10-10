package com.example.registrocontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.datepicker.MaterialTextInputPicker;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView mostrarFecha;
    private DatePickerDialog.OnDateSetListener mostrarFechaEscuha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mostrarFecha = (TextView) findViewById(R.id.tvSelecDate);
        mostrarFecha.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mostrarFechaEscuha,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mostrarFechaEscuha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = month + "/" + dayOfMonth + "/" + year;
                mostrarFecha.setText(date);
            }
        };

        Button botonSiguiente = (Button) findViewById(R.id.btnSiguiente);

        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText campoNom = (TextInputEditText) findViewById(R.id.tiNombre);
                TextView camapoFechaNac = (TextView) findViewById(R.id.tvSelecDate);
                TextInputEditText campoTel = (TextInputEditText) findViewById(R.id.tiTelefono);
                TextInputEditText campoEmail = (TextInputEditText) findViewById(R.id.tiEmail);
                TextInputEditText campoDesc = (TextInputEditText) findViewById(R.id.tiDescripcion);

                Intent intent = new Intent(MainActivity.this, DatosContacto.class);
                intent.putExtra("NomCont",campoNom.getText().toString());
                intent.putExtra("FechaNac",camapoFechaNac.getText().toString());
                intent.putExtra("TelCont",campoTel.getText().toString());
                intent.putExtra("EmailCont",campoEmail.getText().toString());
                intent.putExtra("DescCont",campoDesc.getText().toString());
                startActivity(intent);
            }
        });


        Bundle parametros = getIntent().getExtras();
        if(parametros!=null){
            String nombre = parametros.getString("NomCont");
            String fechaNac = parametros.getString("FechaNac");
            String telefono = parametros.getString("TelCont");
            String email = parametros.getString("EmailCont");
            String descrip = parametros.getString("DescCont");

            TextInputEditText tvNombre = (TextInputEditText) findViewById(R.id.tiNombre);
            TextView tvSelecDate = (TextView) findViewById(R.id.tvSelecDate);
            TextInputEditText tvTelefono = (TextInputEditText) findViewById(R.id.tiTelefono);
            TextInputEditText tvEmail = (TextInputEditText) findViewById(R.id.tiEmail);
            TextInputEditText tvDesc = (TextInputEditText) findViewById(R.id.tiDescripcion);

            tvNombre.setText(nombre);
            tvSelecDate.setText(fechaNac);
            tvTelefono.setText(telefono);
            tvEmail.setText(email);
            tvDesc.setText(descrip);
        }



    }
}