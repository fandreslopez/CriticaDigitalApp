package grupo5.criticadigital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
@AllArgsConstructor
@Builder
public class AsistenciaDTO {
    private String NombreDiputado;

    private Integer Asistencias;

    private Integer Inasistencia;
}
