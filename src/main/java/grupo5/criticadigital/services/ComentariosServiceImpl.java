package grupo5.criticadigital.services;


import grupo5.criticadigital.models.Comentarios;
import grupo5.criticadigital.repositories.ComentariosRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ComentariosServiceImpl implements ComentariosService {

    private ComentariosRepository comentariosRepository;

    @Override
    public List<String> getComentarioById(Integer id){

        return comentariosRepository.publicacionComentario(id);
    }

    @Override
    public List<Comentarios> obtenerComentarios() {
        return comentariosRepository.findAll();
    }

    @Override
    public Comentarios comentariosPorId(Long id) {
        return comentariosRepository.findById(id).get();
    }

    @Override
    public Comentarios editarComentariosPorId(Comentarios comentariosParaEditar, Long id) {
        Comentarios comentariosSeleccionado = comentariosRepository.findById(id).get();
        return comentariosRepository.save(comentariosParaEditar);
    }

    @Override
    public Comentarios guardarComentarios(Comentarios comentarios){
        if (comentarios != null) {
            return comentariosRepository.save(comentarios);
        } else return null;
    }
    @Override
    public void eliminarComentarios(Long id) {
        comentariosRepository.deleteById(id);
    }
}



