package grupo5.criticadigital.controller;

import grupo5.criticadigital.models.Likes;
import grupo5.criticadigital.models.Usuarios;
import grupo5.criticadigital.services.LikesService;
import grupo5.criticadigital.services.LikesServiceImpl;
import grupo5.criticadigital.services.UsuariosServicesImpl;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("api/likes")
public class LikesRestController {

    private final LikesServiceImpl likesService;

    @GetMapping("{id}")
    public ResponseEntity<Likes> buscarLikesPorId (@PathVariable Long id) {
        Likes likesSeleccionado = likesService.likesPorId(id);
        return new ResponseEntity<>(likesSeleccionado, HttpStatus.OK);
    }

    @GetMapping("lista")
    public ResponseEntity<List<Likes>> listarLikes (){
        List<Likes> lista = likesService.obtenerLikes();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    //Guardar nuevo usuario

    @PostMapping("nuevo")
    public ResponseEntity<Likes> crearLikes(@RequestBody Likes likes){
        Likes likesNuevo = likesService.guardarLikes(likes);
        return new ResponseEntity<>(likesNuevo, HttpStatus.CREATED);
    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        likesService.eliminarLikes(id);
        return new ResponseEntity<>("El like fue eliminado", HttpStatus.OK);
    }
}
