package grupo5.criticadigital.services;

import grupo5.criticadigital.models.Comentarios;

import java.util.List;

public interface ComentariosService {

    List<Comentarios> obtenerComentarios();

    Comentarios comentariosPorId(Long id);

    Comentarios editarComentariosPorId(Comentarios comentariosParaEditar, Long id);

    Comentarios guardarComentarios(Comentarios comentarios);

    void eliminarComentarios(Long id);

    List<String> getComentarioById(Integer id);
}