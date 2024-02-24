package grupo5.criticadigital.controller;

import grupo5.criticadigital.models.Asistencia;
import grupo5.criticadigital.services.AsistenciaService;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController // Anotación para indicar que esta clase es un controlador REST
@RequestMapping("/api/asistencias") // Anotación para asignar una ruta base para todos los endpoints del controlador
public class AsistenciaRestController {

    private final AsistenciaService asistenciaService;

    @Autowired // Anotación para realizar la inyección de dependencia del servicio AsistenciaService
    public AsistenciaRestController(AsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService; // Asignación del servicio AsistenciaService
    }

    @GetMapping // Anotación para indicar que este método maneja las solicitudes GET
    public ResponseEntity<List<Asistencia>> getAllAsistencias() {
        List<Asistencia> asistencias = asistenciaService.getAllAsistencias(); // Obtención de todas las asistencias utilizando el servicio
        return new ResponseEntity<>(asistencias, HttpStatus.OK); // Devolución de la lista de asistencias en una respuesta HTTP OK
    }

    @GetMapping("/{id}") // Anotación para indicar que este método maneja las solicitudes GET con una variable en la ruta
    public ResponseEntity<Asistencia> getAsistenciaById(@PathVariable("id") Integer id) {
        Asistencia asistencia = asistenciaService.getAsistenciaById(id); // Obtención de una asistencia por su ID utilizando el servicio
        if (asistencia != null) { // Verifica si se encontró la asistencia
            return new ResponseEntity<>(asistencia, HttpStatus.OK); // Devolución de la asistencia en una respuesta HTTP OK
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Devolución de una respuesta HTTP NOT FOUND si la asistencia no se encontró
        }
    }

    @DeleteMapping("/{id}") // Anotación para indicar que este método maneja las solicitudes DELETE con una variable en la ruta
    public ResponseEntity<Void> deleteAsistencia(@PathVariable("id") Integer id) {
        asistenciaService.deleteAsistencia(id); // Eliminación de una asistencia por su ID utilizando el servicio
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Devolución de una respuesta HTTP NO CONTENT
    }
}
