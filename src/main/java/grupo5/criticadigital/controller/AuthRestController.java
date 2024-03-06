package grupo5.criticadigital.controller;

import grupo5.criticadigital.dto.LoginDTO;
import grupo5.criticadigital.dto.SignupDTO;
import grupo5.criticadigital.models.ERol;
import grupo5.criticadigital.models.Rol;
import grupo5.criticadigital.models.Usuarios;
import grupo5.criticadigital.security.JwtUtils;
import grupo5.criticadigital.security.UsuariosDetailsImpl;
import grupo5.criticadigital.services.RolServices;
import grupo5.criticadigital.services.UsuariosServicesImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthRestController {

    private final AuthenticationManager authenticationManager;

    private final UsuariosServicesImpl usuariosService;

    private final RolServices rolService;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginRequest) {

        // Autentica al usuario utilizando el gestor de autenticación de Spring Security
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));


        // Establece la autenticación en el contexto de seguridad de Spring Security
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Obtiene los detalles del usuario autenticado
        UsuariosDetailsImpl userDetails = (UsuariosDetailsImpl) authentication.getPrincipal();

        // Genera un token JWT para el usuario autenticado
        String jwtToken = jwtUtils.generateJwtToken(userDetails);

        System.out.println("funciona");

        // Retorna una respuesta exitosa con el token JWT y detalles del usuario
        return new ResponseEntity<>(new JwtResponse(jwtToken, userDetails.getUsername(), userDetails.getEmail()), HttpStatus.OK);
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupDTO solicitudRegistro) {
        // Verifica si el nombre de usuario ya está en uso
        if (usuariosService.existeUsuarioPorUsername(solicitudRegistro.getUsername())) {
            return ResponseEntity.badRequest().body(new String("Error: El username ya está en uso!"));
        }

        // Verifica si el correo electrónico ya está en uso
        if (usuariosService.existeUsuarioPorEmail(solicitudRegistro.getEmail())) {
            return ResponseEntity.badRequest().body(new String("Error: El email ya está en uso"));
        }

        // Crea una nueva cuenta de usuario
        Usuarios usuario = Usuarios.builder()
                .nickname(solicitudRegistro.getUsername())
                .correo(solicitudRegistro.getEmail())
                .password(passwordEncoder.encode(solicitudRegistro.getPassword())) // Codifica la contraseña antes de almacenarla
                .build();

        // Obtiene los roles seleccionados por el usuario y los asigna al nuevo usuario
        Set<String> strRoles = solicitudRegistro.getRoles();
        Set<Rol> roles = new HashSet<>();
        if (strRoles == null) {
            Rol rolUsuario = rolService.buscarRolPorNombre(ERol.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
            roles.add(rolUsuario);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Rol rolAdmin = rolService.buscarRolPorNombre(ERol.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
                        roles.add(rolAdmin);
                        break;
                    default:
                        Rol rolUsuario= rolService.buscarRolPorNombre(ERol.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
                        roles.add(rolUsuario);
                }
            });
        }

        // Asigna los roles al usuario y guarda el usuario en la base de datos
        usuario.setRoles(roles);
        usuariosService.guardarUsuario(usuario);

        // Retorna una respuesta exitosa indicando que el usuario se registró correctamente
        return new ResponseEntity(new String("Usuario registrado exitosamente!"), HttpStatus.CREATED);
    }


    // Clase interna que representa la respuesta del token JWT
    @AllArgsConstructor
    @Getter
    @Setter
    public class JwtResponse {
        private String token;
        private String username;
        private String email;
    }
}