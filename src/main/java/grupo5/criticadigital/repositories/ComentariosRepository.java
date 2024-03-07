package grupo5.criticadigital.repositories;

import grupo5.criticadigital.models.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios, Long> {

    @Query(value = "select comentarios from comentarios c where id_diputado = :id", nativeQuery = true)
    List<String> publicacionComentario(@Param("id") Integer id);
}