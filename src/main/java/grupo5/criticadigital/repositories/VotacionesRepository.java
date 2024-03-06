package grupo5.criticadigital.repositories;

import grupo5.criticadigital.models.Votaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotacionesRepository extends JpaRepository<Votaciones, Long> {
    @Query(value = "select count(votacion) from votaciones Join diputado on votaciones.id_diputado = diputado.id_diputado where diputado.id_diputado = :id AND votacion = 'afirmativo'", nativeQuery = true)
    Integer votacionAfirmativa(@Param("id") Integer id);

    @Query(value = "select count(votacion) from votaciones Join diputado on votaciones.id_diputado = diputado.id_diputado where diputado.id_diputado = :id AND votacion = 'en contra'", nativeQuery = true)
    Integer votacionEnContra(@Param("id") Integer id);

    @Query(value = "select count(votacion) from votaciones Join diputado on votaciones.id_diputado = diputado.id_diputado where diputado.id_diputado = :id AND votacion = 'abstencion'", nativeQuery = true)
    Integer votacionAbstecion(@Param("id") Integer id);

    @Query(value = "select count(votacion) from votaciones Join diputado on votaciones.id_diputado = diputado.id_diputado where diputado.id_diputado = :id AND votacion = 'dispensado'", nativeQuery = true)
    Integer votacionDispensado(@Param("id") Integer id);

    @Query(value = "select boletin from votaciones Join diputado on votaciones.id_diputado = diputado.id_diputado where diputado.id_diputado = :id ", nativeQuery = true)
    List<String> votacionBoletin(@Param("id") Integer boletin);

    @Query(value = "select descripcion from votaciones Join diputado on votaciones.id_diputado = diputado.id_diputado where diputado.id_diputado = :id ", nativeQuery = true)
    List<String> votacionDescripcion(@Param("id") Integer id);

    @Query(value = "select votacion from votaciones Join diputado on votaciones.id_diputado = diputado.id_diputado where diputado.id_diputado = :id ", nativeQuery = true)
    List<String> votacionSituacion(@Param("id") Integer id);

}
