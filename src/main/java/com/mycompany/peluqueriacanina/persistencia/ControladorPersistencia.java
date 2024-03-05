package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.DuenioMascota;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author RobinsonConcha
 */

public class ControladorPersistencia {
    
    DuenioMascotaJpaController duenioJpa = new DuenioMascotaJpaController();
    MascotaJpaController petJpa = new MascotaJpaController();

    public void guardar(DuenioMascota duenio, Mascota pet) {
        
        duenioJpa.create(duenio);
        
        petJpa.create(pet);
        
    }

    public List<Mascota> traerMascotas() {
        return petJpa.findMascotaEntities();
        
    }

    public void borrarMascota(int idMascota) {
        try {
            petJpa.destroy(idMascota);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public Mascota traerMascota(int idMascota) {
        return petJpa.findMascota(idMascota);
       
    }

    public void modificarMascota(Mascota pet) {
        try {
            petJpa.edit(pet);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public DuenioMascota traerDuenio(int idDuenio) {
        return duenioJpa.findDuenioMascota(idDuenio); 
    }

    public void modificarDuenioMascota(DuenioMascota duenio) {
       try{
           duenioJpa.edit(duenio);
       } catch (Exception ex) {
           Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
    

