package grupo5.criticadigital.services;

import grupo5.criticadigital.models.Sesiones;

import java.util.List;

public interface SesionesService {

    // Método para obtener todas las sesiones
    List<Sesiones> getAllSesiones();

    // Método para obtener una sesión por su ID
    Sesiones getSesionesById(Integer id);

    // Método para crear una nueva sesión
    Sesiones createSesiones(Sesiones sesiones);

    // Método para eliminar una sesión por su ID
    void deleteSesiones(Integer id);
}
