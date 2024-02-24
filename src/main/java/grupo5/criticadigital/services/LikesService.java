package grupo5.criticadigital.services;


import grupo5.criticadigital.models.Likes;
import grupo5.criticadigital.models.Usuarios;

import java.util.List;

public interface LikesService {

    List<Likes> obtenerLikes();

    Likes likesPorId(Long id);

    Likes editarLikesPorId(Likes likesParaEditar, Long id);

    Likes guardarLikes(Likes likes);

    void eliminarLikes(Long id);
}
