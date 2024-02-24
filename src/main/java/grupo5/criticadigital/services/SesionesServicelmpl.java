package grupo5.criticadigital.services;

import grupo5.criticadigital.models.Sesiones;
import grupo5.criticadigital.repositories.SesionesRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Anotación que indica que esta clase es un servicio de Spring
@Transactional // Anotación que indica que los métodos de esta clase son transaccionales
@AllArgsConstructor // Anotación de Lombok que genera un constructor con todos los argumentos
public class SesionesServicelmpl implements SesionesService {

    private final SesionesRepository sesionesRepository;

    @Override
    public List<Sesiones> getAllSesiones() { // Método para obtener todas las sesiones
        return sesionesRepository.findAll(); // Utiliza el método findAll() del repositorio para obtener todas las sesiones
    }

    @Override
    public Sesiones getSesionesById(Integer id) { // Método para obtener una sesión por su ID
        return sesionesRepository.findById(Long.valueOf(id)).orElse(null); // Utiliza el método findById() del repositorio para obtener una sesión por su ID
    }

    @Override
    public Sesiones createSesiones(Sesiones sesiones) { // Método para crear una nueva sesión
        return sesionesRepository.save(sesiones); // Guarda la nueva sesión utilizando el método save() del repositorio
    }

    @Override
    public void deleteSesiones(Integer id) { // Método para eliminar una sesión por su ID
        sesionesRepository.deleteById(Long.valueOf(id)); // Elimina la sesión por su ID utilizando el método deleteById() del repositorio
    }
}
