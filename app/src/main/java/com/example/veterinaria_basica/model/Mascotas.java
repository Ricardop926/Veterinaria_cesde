package com.example.veterinaria_basica.model;

public class Mascotas {
    String nombrepet,edadpet,razapet,personacargo_,Vacunas;


    public Mascotas(){}

    public Mascotas(String nombrepet, String edadpet, String razapet, String personacargo_, String vacunas) {
        this.nombrepet = nombrepet;
        this.edadpet = edadpet;
        this.razapet = razapet;
        this.personacargo_ = personacargo_;
        Vacunas = vacunas;
    }

    public String getNombrepet() {
        return nombrepet;
    }

    public void setNombrepet(String nombrepet) {
        this.nombrepet = nombrepet;
    }

    public String getEdadpet() {
        return edadpet;
    }

    public void setEdadpet(String edadpet) {
        this.edadpet = edadpet;
    }

    public String getRazapet() {
        return razapet;
    }

    public void setRazapet(String razapet) {
        this.razapet = razapet;
    }

    public String getPersonacargo_() {
        return personacargo_;
    }

    public void setPersonacargo_(String personacargo_) {
        this.personacargo_ = personacargo_;
    }

    public String getVacunas() {
        return Vacunas;
    }

    public void setVacunas(String vacunas) {
        Vacunas = vacunas;
    }
}
