package grupo5.criticadigital.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import grupo5.criticadigital.dto.UsuariosDTO;
import grupo5.criticadigital.models.Generos;
import grupo5.criticadigital.models.Usuarios;
import grupo5.criticadigital.repositories.GenerosRepository;
import grupo5.criticadigital.repositories.UsuariosRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UsuariosServicesImpl implements UsuariosServices {

    private final UsuariosRepository usuariosRepository;

    @Override
    public List<Usuarios> obtenerUsuarios() {
        return usuariosRepository.findAll();
    }

    @Override
    public Usuarios usuarioPorId(Long id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    @Override
    public UsuariosDTO buscarUsuario(String correo) {
        Usuarios usuario = usuariosRepository.findByCorreo(correo);
        return new UsuariosDTO(usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getNickname(), usuario.getGeneroUsuario().getGeneroValor());
    }


    @Override
    public Usuarios editarUsuarioPorId(Usuarios usuarioParaEditar, Long id) {
        Usuarios usuarioSeleccionado = usuariosRepository.findById(id).get();
        usuarioSeleccionado.setNombre(usuarioParaEditar.getNombre());
        usuarioSeleccionado.setApellido(usuarioParaEditar.getApellido());
        usuarioSeleccionado.setNickname(usuarioParaEditar.getNickname());
        usuarioSeleccionado.setGeneroUsuario(usuarioParaEditar.getGeneroUsuario());
        usuarioSeleccionado.setTipoUsuario(usuarioParaEditar.getTipoUsuario());
        usuarioSeleccionado.setCorreo(usuarioParaEditar.getCorreo());
        usuarioSeleccionado.setFechaNacimiento(usuarioParaEditar.getFechaNacimiento());
        usuarioSeleccionado.setPassword(usuarioParaEditar.getPassword());
        usuarioSeleccionado.setRut(usuarioParaEditar.getRut());
        return usuariosRepository.save(usuarioSeleccionado);
    }

    @Override
    public Usuarios guardarUsuario(Usuarios usuario){
        return usuariosRepository.save(usuario);
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
