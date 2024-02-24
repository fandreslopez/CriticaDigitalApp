package grupo5.criticadigital.services;

import grupo5.criticadigital.models.Diputado;
import grupo5.criticadigital.models.Region;
import grupo5.criticadigital.repositories.DiputadoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DiputadoServiceImpl implements DiputadoService{

    private DiputadoRepository diputadoRepository;

    @Override
    public Diputado diputadoPorId(Long id) {
        return diputadoRepository.findById(id).get();
    }

    @Override
    public List<Diputado> obtenerDiputados(){
        return diputadoRepository.findAll();
    }

    @Override
    public Diputado guardarDiputado(Diputado diputado) {
        if (diputado != null) {
            return diputadoRepository.save(diputado);
        } else {
            return null;
        }
    }

    @Override
    public void borrarDiputado(Long id) {
        Boolean diputadoExiste = diputadoRepository.existsById(id);

        if (diputadoExiste) {
            diputadoRepository.deleteById(id);
        }
    }

    @Override
    public List<Diputado> diputadosPorRegion(Region regionId) {
        List<Diputado> diputadosRegion = diputadoRepository.buscarDiputadosPorRegion(regionId);
        return diputadosRegion;

    }

}
