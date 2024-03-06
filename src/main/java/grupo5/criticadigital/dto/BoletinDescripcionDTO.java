package grupo5.criticadigital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BoletinDescripcionDTO {
    private String boletin;

    private String descripcion;

    private String situacion;
}