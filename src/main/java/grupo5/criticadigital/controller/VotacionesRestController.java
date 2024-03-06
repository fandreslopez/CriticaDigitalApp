package grupo5.criticadigital.controller;
import grupo5.criticadigital.dto.BoletinDescripcionDTO;
import grupo5.criticadigital.dto.VotacionesDTO;
import grupo5.criticadigital.models.Votaciones;
import grupo5.criticadigital.services.DiputadoService;
import grupo5.criticadigital.services.DiputadoServiceImpl;
import grupo5.criticadigital.services.VotacionesService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Data
@RestController
@RequestMapping("/api/votaciones")
@CrossOrigin("*")
public class VotacionesRestController {

    private final VotacionesService votacionesService;
    private final DiputadoServiceImpl diputadoService;

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

    @GetMapping("/votacion/{id}")
    public ResponseEntity<VotacionesDTO> votacionDiputado(@PathVariable("id") Integer id) {
        VotacionesDTO votacionDiputado = VotacionesDTO.builder()
                .NombreDiputado(diputadoService.diputadoPorId(Long.valueOf(id)).getNombres())
                .votacionAfirmativa(votacionesService.getvotacionAfirmativaById(id))
                .votacionEnContra(votacionesService.getvotacionEnContraById(id))
                .votacionAbstecion(votacionesService.getvotacionAbstecionById(id))
                .votacionDispensado(votacionesService.getvotacionDispensadoById(id))
                .build();
        return new ResponseEntity<>(votacionDiputado, HttpStatus.OK);
    }

    @GetMapping("/detalles/{id}")
    public ResponseEntity<List<BoletinDescripcionDTO>> votacionesService(@PathVariable("id") Integer id) {
        List<String> ListaBoletin = votacionesService.getvotacionBoletinById(id);
        List<String> ListaDescipcion = votacionesService.getvotacionDescripcionById(id);
        List<String> ListaSituacion = votacionesService.getvotacionSituacionById(id);
        List<BoletinDescripcionDTO> ArrayVotaciones =  new ArrayList<>();
        for (int i = 0 ; i < ListaBoletin.size() ; i++){

            BoletinDescripcionDTO votacionDiputado = BoletinDescripcionDTO.builder()
                    .boletin(ListaBoletin.get(i))
                    .descripcion(ListaDescipcion.get(i))
                    .situacion(ListaSituacion.get(i))
                    .build();
            ArrayVotaciones.add(votacionDiputado);
        }
        return new ResponseEntity<>(ArrayVotaciones, HttpStatus.OK);
    }
}