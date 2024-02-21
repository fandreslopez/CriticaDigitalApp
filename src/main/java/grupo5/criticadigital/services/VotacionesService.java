package grupo5.criticadigital.services;

import grupo5.criticadigital.models.Votaciones;

import java.util.List;

public interface VotacionesService {

    // Método para obtener todas las votaciones
    List<Votaciones> getAllVotaciones();

    // Método para obtener una votación por su ID
    Votaciones getVotacionesById(Integer id);


    // Método para eliminar una votación por su ID
    void deleteVotaciones(Integer id);

}
