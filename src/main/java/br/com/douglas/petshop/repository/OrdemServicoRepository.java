package br.com.douglas.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.douglas.petshop.model.OrdemServico;
import br.com.douglas.petshop.model.OrdemServicoId;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, OrdemServicoId> {

}
