package co.edu.uniquindio.unitravel.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor                                      //Crea un constructor vacio
@AllArgsConstructor                                     //Crea un constructor con todas los atributos
@Getter                                                 //Crea los getters
@Setter                                                 //Crea los setter

public class Autor extends Persona implements Serializable {

    //------------- atributos ---------
    @Positive                                            //Debe ser posotivo}
    @Column(nullable = false)                            //No puede ser null
    private int anio;

    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;



}
