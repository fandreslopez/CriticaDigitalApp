package grupo5.criticadigital.services;

import grupo5.criticadigital.models.Asistencia;

import java.util.List;


public interface AsistenciaService {

    // Método para obtener todas las asistencias
    List<Asistencia> getAllAsistencias();

    // Método para obtener una asistencia por su ID
    Asistencia getAsistenciaById(Integer id);

    // Método para eliminar una asistencia por su ID
    void deleteAsistencia(Integer id);

    Integer getAsistenciadiputadoById(Integer id);

    Integer getInasistenciaDiputadoById(Integer id);
}
