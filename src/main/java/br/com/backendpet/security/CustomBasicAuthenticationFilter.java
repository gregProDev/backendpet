/*
package br.com.backendpet.security;

import br.com.backendpet.user.UserPrincipal;
import br.com.backendpet.user.model.Usuario;
import br.com.backendpet.user.repository.UsuarioRepository;
import jakarta.persistence.Basic;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.Authorization;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@RequiredArgsConstructor
public class CustomBasicAuthenticationFilter extends OncePerRequestFilter {

     private static final String Authorization = "Authorization";

     private static final String Basic = "Basic";

     private final UsuarioRepository usuarioRepository;

     public PasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder();
     }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (isBasicAuthentication(request)) {
            String[] credentials = decodeBase64(getHeader(request).replace(Basic,""))
                    .split(":");

            String nomeUsuario = credentials[0];
            String password = credentials[1];

            Usuario usuario = usuarioRepository.findByNomeUsuario(nomeUsuario);

            if (usuario == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Usuario não existe");
                return;
            }

            boolean valid = checkPassword(usuario.getPassword(), password);

            if(!valid){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Password não bateu ou password nao e igual");
            }

            setAuthentication(usuario);
        }
    }

    private void setAuthentication(Usuario usuario) {
        Authentication authentication = createAutenticationToken(usuario);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private Authentication createAutenticationToken(Usuario usuario) {
         UserPrincipal userPrincipal = UserPrincipal.create(usuario);
         return new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
    }

    private boolean checkPassword(String usuarioPassword, String loggingPassword) {
        return passwordEncoder().matches(loggingPassword, usuarioPassword);
    }

    private String decodeBase64(String base64) {
        byte[] decodeBytes = Base64.getDecoder().decode(base64);
        return new String(decodeBytes);
    }

    private boolean isBasicAuthentication(HttpServletRequest request) {
        String header = getHeader(request);
        return header != null && header.startsWith(Basic);
    }

    private String getHeader(HttpServletRequest request) {
        return request.getHeader(Authorization);
    }
}
*/
