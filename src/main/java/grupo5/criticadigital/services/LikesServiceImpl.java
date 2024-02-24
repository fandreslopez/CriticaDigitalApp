package grupo5.criticadigital.services;


import grupo5.criticadigital.models.Likes;
import grupo5.criticadigital.repositories.LikesRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class LikesServiceImpl implements LikesService {
    private LikesRepository likesRepository;

    @Override
    public List<Likes> obtenerLikes() {
        return likesRepository.findAll();
    }

    @Override
    public Likes likesPorId(Long id) {
        return likesRepository.findById(id).get();
    }

    @Override
    public Likes editarLikesPorId(Likes likesParaEditar, Long id) {
        Likes likesSeleccionado = likesRepository.findById(id).get();
        return likesRepository.save(likesParaEditar);
    }

    @Override
    public Likes guardarLikes(Likes likes){
        if (likes != null) {
            return likesRepository.save(likes);
        } else return null;
    }
    @Override
    public void eliminarLikes(Long id) {
        likesRepository.deleteById(id);
    }
}
