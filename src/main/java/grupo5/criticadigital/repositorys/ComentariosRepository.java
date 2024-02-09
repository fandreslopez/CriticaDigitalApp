package grupo5.criticadigital.repositorys;

import grupo5.criticadigital.models.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios, Long> {
}
