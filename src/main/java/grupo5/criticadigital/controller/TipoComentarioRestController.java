package grupo5.criticadigital.controller;


import grupo5.criticadigital.models.TipoComentario;
import grupo5.criticadigital.services.TipoComentarioServiceImpl;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("api/ TipoComentario")
public class TipoComentarioRestController {

    private final TipoComentarioServiceImpl tipoComentarioService;

    @GetMapping("{id}")
    public ResponseEntity<TipoComentario> buscarTipoComentarioPorId(@PathVariable Long id){
        TipoComentario tipoComentarioSeleccionado = tipoComentarioService.tipoComentarioPorId(id);
        return new ResponseEntity<>(tipoComentarioSeleccionado, HttpStatus.OK);
    }

    @GetMapping("lista")
    public ResponseEntity<List<TipoComentario>> listarTipoComentarios(){
        List<TipoComentario> lista = tipoComentarioService.buscarTipoComentario();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("nuevo")
    public ResponseEntity<TipoComentario> crearTipoComentario(@RequestBody TipoComentario tipoComentario){
        TipoComentario tipoComentarioNuevo = tipoComentarioService.guardarTipoComentario(tipoComentario);
        return new ResponseEntity<>(tipoComentarioNuevo, HttpStatus.CREATED);

    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity<String> borrarTipoComentario(@PathVariable Long id){
        tipoComentarioService.eliminarTipoComentario(id);
        return new ResponseEntity<>("El tipo de comentario fue eliminado.", HttpStatus.OK);
    }




}
