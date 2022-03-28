package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor                                     //Crea el constructor vacio
@AllArgsConstructor                                    //Crea un constructor con todas las variables
@Setter                                                //Crea los setter
@Getter                                                //Crea los getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)      //Crea el Equals y el hascode con las variables que se incluyan
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)    // Una tabla por clase
@MappedSuperclass                                           //No se crea tabla Persona

public class Persona implements Serializable {

    //---------- Variables
    @Id                                                 //Llave primaria
    @EqualsAndHashCode.Include                          //Inluimos "cedula" en el hashcode y el equal
    @Column(length = 10)                                //Tamaño de la columna de 10 (varchar(10))
    private String cedula;

    @Column(length = 200, nullable = false)             //Tamaño de la columna de 200 (varchar(200)), no puede ser null
    private String nombre;

}
