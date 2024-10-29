package br.com.backendpet.cachorro.controller;

import br.com.backendpet.cachorro.dtos.CachorroDto;
import br.com.backendpet.cachorro.model.Cachorro;
import br.com.backendpet.cachorro.repository.CachorroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CachorroController {


    @Autowired
    CachorroRepository cachorroRepository;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/salvarCachorro")
    public ResponseEntity<Cachorro> salvarCachorro(@RequestBody @Valid
                                                   CachorroDto cachorroDto){
        var cachorro = new Cachorro();
        BeanUtils.copyProperties(cachorroDto, cachorro);
        return ResponseEntity.status(HttpStatus.CREATED).body(cachorroRepository.save(cachorro));

    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/cachorro")
    public ResponseEntity<List<Cachorro>> getAllCachorro() {
        return ResponseEntity.status(HttpStatus.OK).body(cachorroRepository.findAll());
    }

    @GetMapping("/cachorro/{id}")
    public ResponseEntity<Object> getOneCachorro(@PathVariable(value = "id") UUID id) {
        Optional<Cachorro> cachorro = cachorroRepository.findById(id);
        if (cachorro.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cachorro not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cachorro.get());
    }

    @PutMapping("/cachorro/{id}")
    public ResponseEntity<Object> updateCachorro(@PathVariable(value = "id")UUID id,
                                                 @RequestBody @Valid CachorroDto cachorroDto ) {
        Optional<Cachorro> cachorro = cachorroRepository.findById(id);
        if (cachorro.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cachorro nâo encontrado");
        }
        var cachorroUpdate = cachorro.get();
        BeanUtils.copyProperties(cachorroDto, cachorroUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(cachorroRepository.save(cachorroUpdate));
    }

    @DeleteMapping("/cachorro/{id}")
    public ResponseEntity<Object> deleteCachorro(@PathVariable(value = "id")UUID id) {
        Optional<Cachorro> cachorro = cachorroRepository.findById(id);
        if (cachorro.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cachorro não foi encontrado");
        }
        cachorroRepository.delete(cachorro.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deleted com sucesso");
    }
}
