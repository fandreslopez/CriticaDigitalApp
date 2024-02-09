package grupo5.criticadigital.repositories;

import grupo5.criticadigital.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {

    Region findByNombreRegion(String nombreRegion);
}
