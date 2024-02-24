package grupo5.criticadigital.dto;

import grupo5.criticadigital.models.Generos;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UsuariosDTO {

    private String nombre;

    private String apellido;

    private String correo;

    private String nickname;

    private String genero;
}
