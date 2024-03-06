package grupo5.criticadigital.repositories;

import grupo5.criticadigital.models.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {

    @Query(value = "select count(situacion) from asistencia Join diputado on asistencia.id_diputado = diputado.id_diputado where diputado.id_diputado = :id AND situacion = 'Asiste'", nativeQuery = true)
    Integer asistenciaDiputado(@Param("id") Integer id);

    @Query(value = "select count(situacion) from asistencia Join diputado on asistencia.id_diputado = diputado.id_diputado where diputado.id_diputado = :id AND situacion = 'No Asiste'", nativeQuery = true)
    Integer inasistenciaDiputado(@Param("id") Integer id);
}
