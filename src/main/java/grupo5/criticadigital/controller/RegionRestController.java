package grupo5.criticadigital.controller;

import grupo5.criticadigital.models.Region;
import grupo5.criticadigital.services.RegionServiceImpl;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("api/region")
public class RegionRestController {

    private final RegionServiceImpl regionService;

    @GetMapping("{id}")
    public ResponseEntity<Region> buscarRegion(@PathVariable Long id) {
        Region regionSeleccionada = regionService.obtenerRegionPorId(id);
        return new ResponseEntity<>(regionSeleccionada, HttpStatus.OK);
    }

    @GetMapping("lista")
    public ResponseEntity<List<Region>> obtenerRegiones() {
        List<Region> regiones = regionService.obtenerRegiones();
        return new ResponseEntity<>(regiones, HttpStatus.OK);
    }

    @PostMapping("nueva")
    public ResponseEntity<Region> agregarRegion(@RequestBody Region region) {
        Region regionNueva = regionService.agregarRegion(region);
        return new ResponseEntity<>(regionNueva, HttpStatus.CREATED);
    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity<String> eliminarRegion(@PathVariable Long id) {
        regionService.borrarRegion(id);
        return new ResponseEntity<>("La región fue eliminada con éxito", HttpStatus.OK);
    }
}
