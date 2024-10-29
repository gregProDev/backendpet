/*
package br.com.backendpet.user.service;


import br.com.backendpet.user.model.Usuario;
import br.com.backendpet.user.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public Usuario create(Usuario usuario) {
        Usuario existeUsuario = usuarioRepository.findByNomeUsuario(usuario.getNomeUsuario());

        if (existeUsuario != null) {
            throw new Error("Usuario ja existe");
        }

        usuario.setPassword(passwordEncoder().encode(usuario.getPassword()));
        Usuario createUsuario = usuarioRepository.save(usuario);

        return createUsuario;
    }
}
*/
