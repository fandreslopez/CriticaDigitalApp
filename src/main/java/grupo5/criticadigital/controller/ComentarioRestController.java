package grupo5.criticadigital.controller;

import grupo5.criticadigital.dto.ComentarioDTO;
import grupo5.criticadigital.models.Comentarios;
import grupo5.criticadigital.services.ComentariosServiceImpl;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Data
@RestController
@RequestMapping("api/comentarios")
@CrossOrigin("*")
public class ComentarioRestController {
    private final ComentariosServiceImpl comentariosService;

    @GetMapping("{id}")
    public ResponseEntity<Comentarios> buscarComentariosPorId (@PathVariable Long id) {
        Comentarios comentariosSeleccionado = comentariosService.comentariosPorId(id);
        return new ResponseEntity<>(comentariosSeleccionado, HttpStatus.OK);
    }

    @GetMapping("lista")
    public ResponseEntity<List<Comentarios>> listarComentarios (){
        List<Comentarios> lista = comentariosService.obtenerComentarios();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    //Guardar nuevo usuario

    @PostMapping("nuevo")
    public ResponseEntity<Comentarios> crearComentarios(@RequestBody Comentarios comentarios){
        Comentarios comentariosNuevo = comentariosService.guardarComentarios(comentarios);
        return new ResponseEntity<>(comentariosNuevo, HttpStatus.CREATED);
    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        comentariosService.eliminarComentarios(id);
        return new ResponseEntity<>("El like fue eliminado", HttpStatus.OK);
    }

    @GetMapping("/comentarios/{id}")
    public ResponseEntity<List<ComentarioDTO>> comentariosService(@PathVariable("id") Integer id) {
        List<String> ListaComentario = comentariosService.getComentarioById(id);
        List<ComentarioDTO> ArrayComentarios =  new ArrayList<>();
        for (int i = 0 ; i < ListaComentario.size() ; i++){

            ComentarioDTO comentarioDiputado = ComentarioDTO.builder()
                    .comentarios(ListaComentario.get(i))
                    .build();
            ArrayComentarios.add(comentarioDiputado);
        }
        return new ResponseEntity<>(ArrayComentarios, HttpStatus.OK);
    }
}
