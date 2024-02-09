package grupo5.criticadigital.controller;

import grupo5.criticadigital.models.Usuarios;
import grupo5.criticadigital.services.UsuariosServicesImpl;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("api/usuarios")
public class UsuariosRestController {

    private final UsuariosServicesImpl usuariosServices;

    @GetMapping("{id}")
    public ResponseEntity<Usuarios> buscarUsuarioPorId (@PathVariable Long id) {
        Usuarios usuarioSeleccionado = usuariosServices.usuarioPorId(id);
        return new ResponseEntity<>(usuarioSeleccionado, HttpStatus.OK);
    }

    @GetMapping("lista")
    public ResponseEntity<List<Usuarios>> listarEmpleados (){
        List<Usuarios> lista = usuariosServices.obtenerUsuarios();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    //Guardar nuevo usuario

    @PostMapping("nuevo")
    public ResponseEntity<Usuarios> crearUsuario(@RequestBody Usuarios usuario){
        Usuarios usuarioNuevo = usuariosServices.guardarUsuario(usuario);
        return new ResponseEntity<>(usuarioNuevo, HttpStatus.CREATED);
    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        usuariosServices.eliminarUsuario(id);
        return new ResponseEntity<>("El usuario fue eliminado", HttpStatus.OK);
    }
}
