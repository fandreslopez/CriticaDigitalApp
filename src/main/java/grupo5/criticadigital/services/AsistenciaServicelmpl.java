package grupo5.criticadigital.services;

import grupo5.criticadigital.models.Asistencia;
import grupo5.criticadigital.repositories.AsistenciaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Anotación para marcar esta clase como un servicio de Spring
@Transactional // Anotación para indicar que los métodos de esta clase son transaccionales
@AllArgsConstructor // Anotación de Lombok para generar un constructor con todos los argumentos
public class AsistenciaServicelmpl implements AsistenciaService {
    @Override
    public Integer getAsistenciadiputadoById(Integer id) {
        return asistenciaRepository.asistenciaDiputado(id);
    }

    @Override
    public Integer getInasistenciaDiputadoById(Integer id) {
        return asistenciaRepository.inasistenciaDiputado(id);
    }

    @Autowired
    private AsistenciaRepository asistenciaRepository; // Inyección de dependencia del repositorio de Asistencia

    // Método para obtener todas las asistencias
    @Override
    public List<Asistencia> getAllAsistencias() {
        return asistenciaRepository.findAll(); // Utiliza el método findAll() del repositorio para obtener todas las asistencias
    }

    // Método para obtener una asistencia por su ID
    @Override
    public Asistencia getAsistenciaById(Integer id) {
        Optional<Asistencia> optionalAsistencia = asistenciaRepository.findById((long) id); // Busca la asistencia por su ID utilizando el método findById() del repositorio
        return optionalAsistencia.orElse(null); // Devuelve la asistencia si se encuentra, o null si no se encuentra
    }

    // Método para eliminar una asistencia por su ID
    @Override
    public void deleteAsistencia(Integer id) {
        asistenciaRepository.deleteById((long) id); // Elimina la asistencia por su ID utilizando el método deleteById() del repositorio
    }
}
