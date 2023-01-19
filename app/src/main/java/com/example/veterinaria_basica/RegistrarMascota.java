package com.example.veterinaria_basica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegistrarMascota extends AppCompatActivity {

    EditText nombreM,edadM,raza,personaacargo;
    RadioButton Vacuna_Si, Vacuna_No;
    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_mascota);
        mFirestore = FirebaseFirestore.getInstance();

        this.setTitle("Ingresar Mascota");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombreM = findViewById(R.id.NombreM);
        edadM = findViewById(R.id.EdadM);
        raza = findViewById(R.id.RazaM);
        personaacargo = findViewById(R.id.PersonaAcargo);
        Vacuna_Si = (RadioButton) findViewById(R.id.checkSi);
        Vacuna_No = (RadioButton) findViewById(R.id.checkNo);


    }

    public void RegistrarMascota (View view){
        String nombrepet = nombreM.getText().toString();
        String edadpet = edadM.getText().toString();
        String razapet = raza.getText().toString();
        String personacargo_ = personaacargo.getText().toString();

        if (nombrepet.isEmpty()||edadpet.isEmpty()||razapet.isEmpty()||personacargo_.isEmpty()){
            validacion();
        }else{
            postMascotas(nombrepet,edadpet,razapet,personacargo_,Vacunas);
        }

    }

    String Vacunas = "";
    public void VacunaNo(View view){
        if (view.getId() == R.id.checkNo){
            Vacunas = "No";
        }
    }

    public void VacunaSi(View view){
        if (view.getId() == R.id.checkSi){
            Vacunas = "Si";
        }
    }

    private void postMascotas(String nombrepet, String edadpet, String razapet, String personacargo_,String Vacunas) {
        Map<String, Object> map = new HashMap<>();
        map.put("NombreMascota",nombrepet);
        map.put("EdadMascota",edadpet);
        map.put("RazaMascota",razapet);
        map.put("PersonaAcargo",personacargo_);
        map.put("Vacunas", Vacunas);

        mFirestore.collection("Mascotas").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(),"Regristro exitoso", Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error al registrar",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void limpiarElementos() {

    }

    private void validacion() {

        String nombrepet = nombreM.getText().toString();
        String edadpet = edadM.getText().toString();
        String razapet = raza.getText().toString();
        String personacargo_ = personaacargo.getText().toString();

        if (nombrepet.isEmpty()) {
            nombreM.setError("Campo Requerido");
            Toast.makeText(getApplicationContext(), "Por favor ingrese el Nombre de su mascota",Toast.LENGTH_SHORT).show();
        }else if (edadpet.isEmpty()){
            edadM.setError("Campo Requerido");
            Toast.makeText(getApplicationContext(), "Por favor ingrese la edad de su mascota",Toast.LENGTH_SHORT).show();
        }else if (razapet.isEmpty()) {
            raza.setError("Campo Requerido");
            Toast.makeText(getApplicationContext(), "Por favor ingrese la raza de su mascota", Toast.LENGTH_SHORT).show();
        }else if (personacargo_.isEmpty()) {
            personaacargo.setError("Campo Requerido");
            Toast.makeText(getApplicationContext(), "Por favor ingrese el nombre de la persona a cargo", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}