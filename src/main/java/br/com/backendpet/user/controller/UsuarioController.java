package br.com.backendpet.user.controller;

import br.com.backendpet.user.model.Usuario;
import br.com.backendpet.user.repository.UsuarioRepository;
import br.com.backendpet.user.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
//@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {


    private final UsuarioRepository usuarioRepository;

    private final UsuarioService usuarioService;

   /* @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.create(usuario);
    }*/
    @CrossOrigin
    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuario));
    }
    @CrossOrigin
    @RequestMapping(value = "/allusuario", method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> getAllUsuario() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUsuario(@PathVariable(value = "id") Long id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        if(usuario.isEmpty()) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
    }
}
