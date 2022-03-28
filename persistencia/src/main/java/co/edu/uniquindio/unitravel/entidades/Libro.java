package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor                                       //Constructor vacio
@Getter                                                  //Los getter de todas las variables
@Setter                                                  //Los setter de todas las variables
@EqualsAndHashCode(onlyExplicitlyIncluded = true)        //El hash code y el equal con las varibales que se incluyan
public class Libro implements Serializable {

    //------------ Variables------------
    @Id                                             //Llave principal
    @EqualsAndHashCode.Include                      //Añadir "isbn" a el equal and hashcode
    @Column(length = 13)                            //El tamaño de la columna es de 13 (varchar(13)
    private String isbn;

    @Column(length = 200, nullable = false)         //El tamaño de la columna es de 200 (varchar(200),No puede ser null
    private String nombre;

    @PositiveOrZero                                 //Debe ser mayor o igual a cero
    @Column(nullable = false)                       //No puede ser null
    private int unidades;

    @Max(9999)                                      //No puede superar el numero 9999
    @Column(nullable = false)                       //No puede ser null
    private short anio;

    private Genero genero;

    @ManyToMany(mappedBy = "libros")                //Asociacion de mucho a muchos
    private List<Prestamo> prestamos;

    @ManyToMany
    private List<Autor> autores;


    // -------------- Constructor -----------
    public Libro(String isbn, String nombre, int unidades, short anio) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.unidades = unidades;
        this.anio = anio;
    }

}
