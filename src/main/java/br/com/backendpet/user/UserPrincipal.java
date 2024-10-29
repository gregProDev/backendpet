/*
package br.com.backendpet.user;


import br.com.backendpet.role.Role;
import br.com.backendpet.user.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserPrincipal {

    private String nomeusuario;

    private String password;


    private Collection<? extends GrantedAuthority> authorities;


    private UserPrincipal(Usuario usuario) {
        this.nomeusuario = usuario.getNomeUsuario();
        this.password = usuario.getPassword();

        this.authorities = usuario.getRoles().stream().map(role -> {
            return new SimpleGrantedAuthority("ROLE".concat(role.getNomeRole()));
        }).collect(Collectors.toList());
    }

    public static UserPrincipal create(Usuario usuario) {
        return new UserPrincipal(usuario);
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

}
*/
