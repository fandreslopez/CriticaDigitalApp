package grupo5.criticadigital.repositories;

import grupo5.criticadigital.models.Diputado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiputadoRepository extends JpaRepository<Diputado, Long> {
}
