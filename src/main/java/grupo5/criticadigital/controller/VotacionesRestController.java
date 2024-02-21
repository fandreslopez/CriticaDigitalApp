package grupo5.criticadigital.controller;
import grupo5.criticadigital.models.Votaciones;
import grupo5.criticadigital.services.VotacionesService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/api/votaciones")
public class VotacionesRestController {

    private final VotacionesService votacionesService;


    @Autowired
    public VotacionesRestController(VotacionesService votacionesService) {
        this.votacionesService = votacionesService;
    }


    @GetMapping
    public ResponseEntity<List<Votaciones>> getAllVotaciones() {
        List<Votaciones> votaciones = votacionesService.getAllVotaciones();
        return new ResponseEntity<>(votaciones, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Votaciones> getVotacionesById(@PathVariable("id") Integer id) {
        Votaciones votaciones = votacionesService.getVotacionesById(id);
        if (votaciones != null) {
            return new ResponseEntity<>(votaciones, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVotaciones(@PathVariable("id") Integer id) {
        votacionesService.deleteVotaciones(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}