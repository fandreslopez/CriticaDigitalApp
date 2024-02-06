package grupo5.criticadigital.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TiposUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoUsuarioId;

    private String tipoUsuarioValor;

}
