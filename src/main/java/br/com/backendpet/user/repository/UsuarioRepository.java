package br.com.backendpet.user.repository;

import br.com.backendpet.user.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByNomeUsuario(String nomeUsuario);
}
