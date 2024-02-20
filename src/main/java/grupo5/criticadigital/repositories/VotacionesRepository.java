package grupo5.criticadigital.repositories;

import grupo5.criticadigital.models.Votaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotacionesRepository extends JpaRepository<Votaciones, Long> {
}
