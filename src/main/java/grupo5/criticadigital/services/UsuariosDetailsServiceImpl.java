package grupo5.criticadigital.services;

import grupo5.criticadigital.models.Usuarios;
import grupo5.criticadigital.repositories.UsuariosRepository;
import grupo5.criticadigital.security.UsuariosDetailsImpl;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class UsuariosDetailsServiceImpl implements UserDetailsService{

    private final UsuariosRepository usuariosRepository;

    @Transactional
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        Usuarios usuario = usuariosRepository.findByNickname(nickname)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + nickname));

        System.out.println();
        return UsuariosDetailsImpl.build(usuario);
    }
}
