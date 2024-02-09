package grupo5.criticadigital.ViewsController;

import grupo5.criticadigital.models.Usuarios;
import grupo5.criticadigital.services.UsuariosServicesImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("usuarios")  //ruta base para los metodos relacionados a usuarios
public class UsuariosController {

    private UsuariosServicesImpl usuariosServices;

    @GetMapping("lista")
    public String mostrarLista(Model model){
        List<Usuarios> lista = usuariosServices.obtenerUsuarios();
        model.addAttribute("usuarios", lista);
        return "usuarios";
    }

    @GetMapping("formulario")
    public String formulario(Model model){
        model.addAttribute("usuarioNuevo", new Usuarios());
        return "formulario";
    }

    @PostMapping("registrar")
    public String registroUsuario(@ModelAttribute Usuarios nuevoUsuario){
        usuariosServices.guardarUsuario(nuevoUsuario);
        return "redirect:lista";

    }

    @GetMapping("editar/{id}")
    public String edicion(@PathVariable Long id, Model model){
        Usuarios usuario = usuariosServices.usuarioPorId(id);
        model.addAttribute("usuario", usuario);
        return "formularioeditar";
    }

    @PostMapping("actualizar/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute Usuarios usuarioEditado){
        usuariosServices.editarUsuarioPorId(usuarioEditado, id);
        return "redirect:/usuarios/lista";

    }


    @PostMapping("borrar/{id}")
    public String borrar (@PathVariable Long id){
        usuariosServices.eliminarUsuario(id);
        return "redirect:/usuarios/lista";
    }



}
