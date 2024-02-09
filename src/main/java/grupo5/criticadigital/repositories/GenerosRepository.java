package grupo5.criticadigital.repositories;

import grupo5.criticadigital.models.Generos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerosRepository extends JpaRepository<Generos, Long> {
}
