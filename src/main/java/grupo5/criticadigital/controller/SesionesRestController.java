package grupo5.criticadigital.controller;

import grupo5.criticadigital.models.Sesiones;
import grupo5.criticadigital.services.SesionesService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/api/sesiones")
public class SesionesRestController {

    private final SesionesService sesionesService;

    @Autowired
    public SesionesRestController(SesionesService sesionesService) {
        this.sesionesService = sesionesService;
    }

    @GetMapping
    public ResponseEntity<List<Sesiones>> getAllSesiones() {
        List<Sesiones> sesiones = sesionesService.getAllSesiones();
        return new ResponseEntity<>(sesiones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sesiones> getSesionesById(@PathVariable("id") Integer id) {
        Sesiones sesiones = sesionesService.getSesionesById(id);
        if (sesiones != null) {
            return new ResponseEntity<>(sesiones, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSesiones(@PathVariable("id") Integer id) {
        sesionesService.deleteSesiones(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
