package br.com.backendpet.user.service;

import br.com.backendpet.user.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioServiceInterface {

    Usuario create(Usuario usuario);

    ResponseEntity<Usuario> findAllUsuario();

    ResponseEntity<List<Usuario>> findAll();


}
