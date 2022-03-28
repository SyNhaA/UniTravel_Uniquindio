package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor                                         //Constructor vacio
@Getter                                                    //Los getter de todas las variables
@Setter                                                    //Los setter de todas las variables
@EqualsAndHashCode(onlyExplicitlyIncluded = true)          //El hash code y el equal con las varibales que se incluyan
public class Prestamo {

//  --------- Variables --------
    @Id                                                     //Llave principal
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //int autoincrmente
    @EqualsAndHashCode.Include                              //Añadir "codigo" a el equal and hashcode
    private int codigo;

    @Column(nullable = false)                               //No puede ser null
    private LocalDateTime fechaPrestamo;

    @Future                                                 //La fecha debe estar ubicada en el futuro
    @Column(nullable = false)                               //No puede ser null
    private LocalDate fechaDevolucion;

    @ManyToMany                                             //Asociacion de mucho a muchos
    private List<Libro> libros;

    @ManyToOne                                              //Asociacion de mucho a uno
    private Usuario persona;

// ----------- Constructor -----------------

    public Prestamo(int codigo, LocalDateTime fechaPrestamo, LocalDate fechaDevolucion) {
        this.codigo = codigo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

}
