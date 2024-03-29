package grupo5.criticadigital.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Entity
@Data
public class TipoComentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdComentario;

    @NotNull
    private String TipoComentario;

}
