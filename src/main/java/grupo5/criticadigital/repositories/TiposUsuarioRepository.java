package grupo5.criticadigital.repositories;

import grupo5.criticadigital.models.TiposUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposUsuarioRepository extends JpaRepository<TiposUsuario, Long> {
}
