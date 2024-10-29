package br.com.backendpet.cachorro.repository;

import br.com.backendpet.cachorro.model.Cachorro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CachorroRepository extends JpaRepository<Cachorro, UUID> {
}
