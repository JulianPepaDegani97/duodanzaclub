package com.mindhub.duodanzaclub.repositories;

import com.mindhub.duodanzaclub.models.UsuarioClase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UsuarioClaseRepository extends JpaRepository<UsuarioClase, Long> {
}
