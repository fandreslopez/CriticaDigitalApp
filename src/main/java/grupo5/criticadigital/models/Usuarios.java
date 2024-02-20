package grupo5.criticadigital.models;

import jakarta.persistence.*;
import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Data
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @Size(max = 10)
    @Column(unique = true)
    private String rut;

    private String nombre;

    private String apellido;

    private Date fechaNacimiento;

    @Email(message = "No se introdujo un correo válido")
    @Column(name = "correo",unique = true)
    private String correo;

    @Column(unique = true)
    private String nickname;

    @Size(min = 8)
    private String password;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Generos generoUsuario;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario")
    private TiposUsuario tipoUsuario;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region regionUsuario;

}
