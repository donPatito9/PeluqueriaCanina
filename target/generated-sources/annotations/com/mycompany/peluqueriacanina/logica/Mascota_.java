package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.logica.DuenioMascota;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-02-17T00:46:15")
@StaticMetamodel(Mascota.class)
public class Mascota_ { 

    public static volatile SingularAttribute<Mascota, String> razaMascota;
    public static volatile SingularAttribute<Mascota, String> nombreMascota;
    public static volatile SingularAttribute<Mascota, String> alergico;
    public static volatile SingularAttribute<Mascota, String> colorMascota;
    public static volatile SingularAttribute<Mascota, String> observaciones;
    public static volatile SingularAttribute<Mascota, DuenioMascota> unDuenio;
    public static volatile SingularAttribute<Mascota, String> especial;
    public static volatile SingularAttribute<Mascota, Integer> idMascota;

}