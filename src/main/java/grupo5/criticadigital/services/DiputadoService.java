package grupo5.criticadigital.services;

import grupo5.criticadigital.models.Diputado;
import grupo5.criticadigital.models.Region;

import java.util.List;

public interface DiputadoService {

    Diputado diputadoPorId(Long id);

    List<Diputado> obtenerDiputados();

    Diputado guardarDiputado(Diputado diputado);

    void borrarDiputado(Long id);

    List<Diputado> diputadosPorRegion(Region regionId);

}
