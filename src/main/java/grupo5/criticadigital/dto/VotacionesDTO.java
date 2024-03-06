package grupo5.criticadigital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class VotacionesDTO {
    private String NombreDiputado;

    private Integer votacionAfirmativa;

    private Integer votacionEnContra;

    private Integer votacionAbstecion;

    private Integer votacionDispensado;

    private BoletinDescripcionDTO boletinDescripcion;
}