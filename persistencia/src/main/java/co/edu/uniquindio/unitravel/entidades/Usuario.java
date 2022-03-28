package co.edu.uniquindio.unitravel.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor                                      //Crea el constructor vacio
@Getter                                                 //Crea todos los getter
@Setter                                                 //Crea todos los setter
public class Usuario extends Persona implements Serializable {

    //--------- variables -----------
    @Email                                                      //Verifica que cumpla con el formato de correo
    @Column(length = 200, nullable = false, unique = true)      //tamaño de la columna de 200 (varchar(200)), no puede ser nul, debe ser una valor unico
    private String email;

    @ElementCollection
    private Map<String, String> telefonorfono;

    @ManyToOne                                            //Relacion de muchos a uno
    private Ciudad ciudad;

    @OneToMany(mappedBy = "persona")
    private List<Prestamo> prestamos;


    //------------- Constructor ------------------
    public Usuario(String cedula, String nombre, String email) {
        super(cedula, nombre);
        this.email = email;
    }

}
