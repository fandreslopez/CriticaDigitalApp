package grupo5.criticadigital.controller;

import grupo5.criticadigital.dto.UsuariosDTO;
import grupo5.criticadigital.models.Usuarios;
import grupo5.criticadigital.services.UsuariosServices;
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
    public ResponseEntity<Usuarios> usuarioPorId (@PathVariable Long id) {
        Usuarios usuarioSeleccionado = usuariosServices.usuarioPorId(id);
        return new ResponseEntity<>(usuarioSeleccionado, HttpStatus.OK);
    }

    @GetMapping("login")
    public ResponseEntity<UsuariosDTO> usuarioDTO (@RequestBody Usuarios usuario) {
        return new ResponseEntity<>(usuariosServices.buscarUsuario(usuario.getCorreo()), HttpStatus.OK);
    }


    @GetMapping("lista")
    public ResponseEntity<List<Usuarios>> listarUsuarios (){
        return new ResponseEntity<>(usuariosServices.obtenerUsuarios(), HttpStatus.OK);
    }

    //Guardar nuevo usuario

    @PostMapping("nuevo")
    public ResponseEntity<Usuarios> crearUsuario(@RequestBody Usuarios usuario){
        return new ResponseEntity<>(usuariosServices.guardarUsuario(usuario), HttpStatus.CREATED);
    }
    //Borrar

    @DeleteMapping("borrar/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        usuariosServices.eliminarUsuario(id);
        return new ResponseEntity<>("El usuario fue eliminado", HttpStatus.OK);
    }

    //Editar
    @PutMapping("editar/{id}")
    public ResponseEntity<Usuarios> editar(@RequestBody Usuarios usuario, @PathVariable Long id){
        return new ResponseEntity<>(usuariosServices.editarUsuarioPorId(usuario, id), HttpStatus.OK);
    }
}
