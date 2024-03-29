package grupo5.criticadigital.services;

import grupo5.criticadigital.models.Votaciones;
import grupo5.criticadigital.repositories.VotacionesRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//Anotacion service permite a Spring tomar este componente para inyectarlo luego donde lo necesitemos
@Transactional//Transactional indica que los métodos contenidos en esta clase son transaccionales
@AllArgsConstructor
public class VotacionesServicelmpl implements VotacionesService {

    @Override
    public Integer getvotacionAfirmativaById(Integer id) {
        return votacionesRepository.votacionAfirmativa(id);
    }

    @Override
    public Integer getvotacionEnContraById(Integer id) {
        return votacionesRepository.votacionEnContra(id);
    }

    @Override
    public Integer getvotacionAbstecionById(Integer id) {
        return votacionesRepository.votacionAbstecion(id);
    }

    @Override
    public Integer getvotacionDispensadoById(Integer id) {
        return votacionesRepository.votacionDispensado(id);
    }

    @Override
    public List<String> getvotacionBoletinById(Integer id) {return votacionesRepository.votacionBoletin(id);
    }

    @Override
    public List<String> getvotacionDescripcionById(Integer id) {return votacionesRepository.votacionDescripcion(id);
    }

    @Override
    public List<String> getvotacionSituacionById(Integer id) {return votacionesRepository.votacionSituacion(id);
    }

    private final VotacionesRepository votacionesRepository;

    // Método para obtener todas las votaciones
    @Override
    public List<Votaciones> getAllVotaciones() {
        return votacionesRepository.findAll();
    }

    // Método para obtener una votación por su ID
    @Override
    public Votaciones getVotacionesById(Integer id) {
        return votacionesRepository.findById((long) id).orElse(null);
    }

    // Método para eliminar una votación por su ID
    @Override
    public void deleteVotaciones(Integer id) {
        votacionesRepository.deleteById((long) id);
    }
}
