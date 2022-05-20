package br.com.douglas.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.douglas.petshop.model.Ordem;

@Repository
public interface OrdemRepository extends JpaRepository<Ordem, Long> {

}
