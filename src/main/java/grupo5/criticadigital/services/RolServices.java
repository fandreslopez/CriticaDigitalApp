package grupo5.criticadigital.services;

import grupo5.criticadigital.models.ERol;
import grupo5.criticadigital.models.Rol;
import grupo5.criticadigital.repositories.RolRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class RolServices {

    private final RolRepository rolRepository;

    public Optional<Rol> buscarRolPorNombre(ERol nombre){
        return rolRepository.findByNombre(nombre);
    }
}
