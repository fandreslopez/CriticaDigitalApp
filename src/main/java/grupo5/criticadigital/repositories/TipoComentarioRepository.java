package grupo5.criticadigital.repositorys;

import grupo5.criticadigital.models.TipoComentario;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoComentarioRepository extends JpaRepository<TipoComentario, Long> {
}
