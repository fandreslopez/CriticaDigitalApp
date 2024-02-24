package grupo5.criticadigital.services;

import grupo5.criticadigital.dto.UsuariosDTO;
import grupo5.criticadigital.models.Usuarios;


import java.util.List;

public interface UsuariosServices {
    List<Usuarios> obtenerUsuarios();

    Usuarios usuarioPorId(Long id);

    Usuarios editarUsuarioPorId(Usuarios usuarioParaEditar, Long id);

    Usuarios guardarUsuario(Usuarios usuario);

    void eliminarUsuario(Long id);

    UsuariosDTO buscarUsuario(String correo);

}
