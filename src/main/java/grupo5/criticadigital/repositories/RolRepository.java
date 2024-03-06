package grupo5.criticadigital.repositories;

import grupo5.criticadigital.models.ERol;
import grupo5.criticadigital.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(ERol nombre);
}
