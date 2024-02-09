package grupo5.criticadigital.services;

import grupo5.criticadigital.models.Usuarios;
import grupo5.criticadigital.repositories.UsuariosRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UsuariosServicesImpl implements UsuariosServices {

    private UsuariosRepository usuariosRepository;

    @Override
    public List<Usuarios> obtenerUsuarios() {
        return usuariosRepository.findAll();
    }

    @Override
    public Usuarios usuarioPorId(Long id) {
        return usuariosRepository.findById(id).get();
    }

    @Override
    public Usuarios editarUsuarioPorId(Usuarios usuarioParaEditar, Long id) {
        Usuarios usuarioSeleccionado = usuariosRepository.findById(id).get();
        return usuariosRepository.save(usuarioParaEditar);
    }

    @Override
    public Usuarios guardarUsuario(Usuarios usuario){
        if (usuario != null) {
            return usuariosRepository.save(usuario);
        } else return null;
    }

    /* public Empleado guardarEmpleado(Empleado empleadoParaGuardar) {
        Boolean empleadoExiste = empleadoRepository.existsById(empleadoParaGuardar.getEmpleadoId());
        //Agrego validaciones antes de guardar al empleado
        if (!(empleadoExiste) && empleadoParaGuardar.getAniosAntiguedad() > 1) {
            return empleadoRepository.save(empleadoParaGuardar);
        } else {
            return null;
        }
    } */
    @Override
    public void eliminarUsuario(Long id) {
        usuariosRepository.deleteById(id);
    }
}
