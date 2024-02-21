package grupo5.criticadigital.services;


import grupo5.criticadigital.models.TipoComentario;
import grupo5.criticadigital.repositories.TipoComentarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TipoComentarioServiceImpl implements  TipoComentarioService{

    private TipoComentarioRepository tipoComentarioRepository;

    @Override
    public List<TipoComentario> buscarTipoComentario() {
        return null;
    }

    @Override
    public TipoComentario tipoComentarioPorId(Long id) {
        return null;
    }

    @Override
    public List<TipoComentario> obtenerTipoComentario() {
        return tipoComentarioRepository.findAll();
    }

    @Override
    public TipoComentario TipoComentarioPorId(Long id) {
        return tipoComentarioRepository.findById(id).get();
    }

    @Override
    public TipoComentario editarTipoComentarioPorId(TipoComentario tipoComentarioParaEditar, Long id) {
        TipoComentario tipoComentarioSeleccionado = tipoComentarioRepository.findById(id).get();
        return tipoComentarioRepository.save(tipoComentarioParaEditar);
    }

    @Override
    public TipoComentario guardarTipoComentario(TipoComentario tipoComentario){
        if (tipoComentario != null) {
            return tipoComentarioRepository.save(tipoComentario);
        } else return null;
    }

    @Override
    public void eliminarTipoComentario(Long id) {
        tipoComentarioRepository.deleteById(id);
    }
}
