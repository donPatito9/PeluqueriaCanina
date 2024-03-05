package com.mycompany.peluqueriacanina.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author RobinsonConcha
 */
@Entity
public class Mascota implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idMascota;
    private String nombreMascota;
    private String razaMascota;
    private String colorMascota;
    private String alergico;
    private String especial;
    private String observaciones;
    
    @OneToOne
    private DuenioMascota unDuenio;
    
    public Mascota(){
        
    }

    public Mascota(int idMascota, String nombreMascota, String razaMascota, String colorMascota, String alergico, String especial, String observaciones, DuenioMascota unDuenio) {
        this.idMascota = idMascota;
        this.nombreMascota = nombreMascota;
        this.razaMascota = razaMascota;
        this.colorMascota = colorMascota;
        this.alergico = alergico;
        this.especial = especial;
        this.observaciones = observaciones;
        this.unDuenio = unDuenio;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getRazaMascota() {
        return razaMascota;
    }

    public void setRazaMascota(String razaMascota) {
        this.razaMascota = razaMascota;
    }

    public String getColorMascota() {
        return colorMascota;
    }

    public void setColorMascota(String colorMascota) {
        this.colorMascota = colorMascota;
    }

    public String getAlergico() {
        return alergico;
    }

    public void setAlergico(String alergico) {
        this.alergico = alergico;
    }

    public String getEspecial() {
        return especial;
    }

    public void setEspecial(String especial) {
        this.especial = especial;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public DuenioMascota getUnDuenio() {
        return unDuenio;
    }

    public void setUnDuenio(DuenioMascota unDuenio) {
        this.unDuenio = unDuenio;
    }
}
