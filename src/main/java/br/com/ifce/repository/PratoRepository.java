package br.com.ifce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifce.model.Prato;

public interface PratoRepository extends JpaRepository<Prato, Long> {

}
