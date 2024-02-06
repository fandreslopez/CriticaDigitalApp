package grupo5.criticadigital.services;

import grupo5.criticadigital.models.Usuarios;


import java.util.List;
import java.util.Optional;

public interface UsuariosServices {
    List<Usuarios> obtenerUsuarios();

    Optional<Usuarios> obtenerUsuarioPorId(Long id);

    Usuarios guardarUsuario(Usuarios usuario);

    void eliminarUsuario(Long id);
}
