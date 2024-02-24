package grupo5.criticadigital.repositories;

import grupo5.criticadigital.models.Diputado;
import grupo5.criticadigital.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiputadoRepository extends JpaRepository<Diputado, Long> {

    @Query("SELECT e FROM Diputado e WHERE e.idRegion = :region ")
    public List<Diputado> buscarDiputadosPorRegion(@Param("region") Region regionId);

}
