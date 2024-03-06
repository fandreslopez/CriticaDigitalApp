package grupo5.criticadigital.controller;

import grupo5.criticadigital.models.Diputado;
import grupo5.criticadigital.models.Region;
import grupo5.criticadigital.services.DiputadoServiceImpl;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/api/diputados")
@CrossOrigin("*")
public class DiputadosRestController {

    private final DiputadoServiceImpl diputadoService;

    @GetMapping("{id}")
    public ResponseEntity<Diputado> buscarDiputadoPorId(@PathVariable Long id) {
        Diputado diputadoSeleccionado = diputadoService.diputadoPorId(id);
        return new ResponseEntity<>(diputadoSeleccionado, HttpStatus.OK);

    }

    @GetMapping("region/{id}")
    public ResponseEntity<List<Diputado>> buscarDiputadosPorRegion(@PathVariable Region id) {
        List<Diputado> diputadosRegion = diputadoService.diputadosPorRegion(id);
        return new ResponseEntity<>(diputadosRegion, HttpStatus.OK);
    }

    @GetMapping("lista")
    public ResponseEntity<List<Diputado>> listarDiputados() {
        List<Diputado> listaDiputados = diputadoService.obtenerDiputados();
        return new ResponseEntity<>(listaDiputados, HttpStatus.OK);
    }

    @PostMapping("nuevo")
    public ResponseEntity<Diputado> crearDiputado(@RequestBody Diputado diputado) {
        Diputado nuevoDiputado = diputadoService.guardarDiputado(diputado);
        return new ResponseEntity<>(nuevoDiputado, HttpStatus.CREATED);
    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity<String> eliminardiputado(@PathVariable Long id) {
        diputadoService.borrarDiputado(id);
        return new ResponseEntity<>("El diputado fue eliminado con éxito", HttpStatus.OK);
    }

    // TODO: asignar asistencia diputados;
}
