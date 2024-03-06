package grupo5.criticadigital.repositories;

import grupo5.criticadigital.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    Usuarios findByCorreo(String correo);

    Optional<Usuarios> findByNickname(String nickname);

    Boolean existsByNickname(String nickname);

    Boolean existsByCorreo(String correo);
}
