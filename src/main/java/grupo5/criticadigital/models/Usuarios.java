package grupo5.criticadigital.models;

import jakarta.persistence.*;
import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @Size(max = 10)
    private String rutUsuario;

    private String nombreUsuario;

    private String apellidoUsuario;

    private Date fechaNacimiento;

    @Email(message = "No se introdujo un correo válido")
    private String correoUsuario;

    private String nickUsuario;

    @Size(min = 8)
    private String password;

}
