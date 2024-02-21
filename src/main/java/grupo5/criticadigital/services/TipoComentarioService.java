package grupo5.criticadigital.services;

import grupo5.criticadigital.models.TipoComentario;

import java.util.List;

public interface TipoComentarioService {

    List<TipoComentario> buscarTipoComentario();//listar

    TipoComentario tipoComentarioPorId(Long id); //buscar por id

    List<TipoComentario> obtenerTipoComentario();

    TipoComentario TipoComentarioPorId(Long id);

    TipoComentario editarTipoComentarioPorId(TipoComentario tipoComentarioParaEditar, Long id);

    TipoComentario guardarTipoComentario(TipoComentario tipoComentario);

    void eliminarTipoComentario(Long id);
}
