package grupo5.criticadigital.repositories;

import grupo5.criticadigital.models.Sesiones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesionesRepository extends JpaRepository<Sesiones, Long> {
}
