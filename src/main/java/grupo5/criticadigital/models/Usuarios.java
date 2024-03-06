package grupo5.criticadigital.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

}
