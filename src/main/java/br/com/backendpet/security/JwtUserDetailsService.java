package br.com.backendpet.security;

import br.com.backendpet.user.model.Usuario;
import br.com.backendpet.user.repository.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    private List<Usuario> usuarios = new ArrayList<>();
    private String nomeusuario;
    private String password;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        setUsuarios(usuarioRepository.findAll());
        for (Usuario usuario: this.getUsuarios()) {
            if (usuario.getNomeUsuario().equals(username)) {
                this.nomeusuario = usuario.getNomeUsuario();
                this.password = usuario.getPassword();
            }
        }
        return new User(this.nomeusuario, this.password, new ArrayList<>());
    }
}
