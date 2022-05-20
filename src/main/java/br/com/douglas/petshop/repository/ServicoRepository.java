package br.com.douglas.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.douglas.petshop.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
