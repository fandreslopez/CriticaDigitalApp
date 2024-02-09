package grupo5.criticadigital.services;

import grupo5.criticadigital.models.Usuarios;
import grupo5.criticadigital.repositories.UsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuariosServicesImpl implements UsuariosServices{

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public List<Usuarios> obtenerUsuarios() {
        return null;
    }

    @Override
    public Optional<Usuarios> obtenerUsuarioPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public Usuarios guardarUsuario(Usuarios usuario) {
        return null;
    }

    @Override
    public void eliminarUsuario(Long id) {

    }
}
