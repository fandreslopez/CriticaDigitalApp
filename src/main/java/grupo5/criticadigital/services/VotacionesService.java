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

    Integer getvotacionAfirmativaById(Integer id);

    Integer getvotacionEnContraById(Integer id);

    Integer getvotacionAbstecionById(Integer id);

    Integer getvotacionDispensadoById(Integer id);

    List<String> getvotacionBoletinById(Integer id);

    List<String> getvotacionDescripcionById(Integer id);

    List<String> getvotacionSituacionById(Integer id);

}
