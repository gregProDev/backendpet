package br.com.backendpet.jwtautenticatecontroller;

import br.com.backendpet.security.JwtTokenUtil;
import br.com.backendpet.user.model.Usuario;
import br.com.backendpet.user.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class JwtAutenticateControllers {

    private List<Usuario> usuarios = new ArrayList<>();

    private String token;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String createAuthenticeToken(@RequestBody Usuario authenticateRequest) {
        usuarios = usuarioRepository.findAll();
        for (Usuario usuario: usuarios) {
            if(usuario.getNomeUsuario().equals(authenticateRequest.getNomeUsuario())
                    && passwordEncoder.matches(authenticateRequest.getPassword(), usuario.getPassword())) {
                final UserDetails userDetails = userDetailsService
                        .loadUserByUsername(authenticateRequest.getNomeUsuario());

                     this.token = jwtTokenUtil.generateToken(userDetails);

                return this.token;

            }

            System.out.println(usuario.getNomeUsuario());

        }
        System.out.println(authenticateRequest.getNomeUsuario());

        return "Error";
    }
}
