package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladorPersistencia;
import java.util.List;

/**
 * @author RobinsonConcha
 */

public class ControladorLogica {
    
    ControladorPersistencia controlPersist = new ControladorPersistencia();

    public void guardar(String nomMascota, String raza,
            String color, String nomDuenio, String telDuenio,
            String observaciones, String alergico, String especial) {
        
        DuenioMascota duenio = new DuenioMascota();
        duenio.setNombreDuenio(nomDuenio);
        duenio.setTelefonoDuenio(telDuenio);
        
        Mascota pet = new Mascota();
        pet.setNombreMascota(nomMascota);
        pet.setRazaMascota(raza);
        pet.setColorMascota(color);
        pet.setAlergico(alergico);
        pet.setEspecial(especial);
        pet.setObservaciones(observaciones);
        pet.setUnDuenio(duenio);
        
        controlPersist.guardar(duenio, pet);
        
        
        
        
        
    }

    public List<Mascota> traerMascotas() {
        
        return controlPersist.traerMascotas();
    }

    public void borrarMascota(int idMascota) {
        
        controlPersist.borrarMascota(idMascota);
    }

    public Mascota traerMascota(int idMascota) {
        
       return controlPersist.traerMascota(idMascota);
        
    }

    public void modificarMascota(Mascota pet, String nomMascota, String raza,
       String color, String alergico, String especial, String observaciones, String nomDuenio, String telDuenio) {
        
       pet.setNombreMascota(nomMascota);
       pet.setRazaMascota(raza);
       pet.setColorMascota(color);
       pet.setAlergico(alergico);
       pet.setEspecial(especial);
       pet.setObservaciones(observaciones);
       
       controlPersist.modificarMascota(pet);
       
       DuenioMascota duenio = this.buscarDuenio(pet.getUnDuenio().getIdDuenio());
       duenio.setNombreDuenio(nomDuenio);
       duenio.setTelefonoDuenio(telDuenio);
     
       //llamar al metodo modificar dueño
       this.modificarDuenio(duenio);
       
    }

    private DuenioMascota buscarDuenio(int idDuenio) {
       return controlPersist.traerDuenio(idDuenio);
    }

    private void modificarDuenio(DuenioMascota duenio) {
        controlPersist.modificarDuenioMascota(duenio);
    }

  

    
    
}
