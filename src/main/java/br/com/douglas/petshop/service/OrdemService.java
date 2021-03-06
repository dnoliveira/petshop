package br.com.douglas.petshop.service;

import br.com.douglas.petshop.repository.ServicoRepository;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.douglas.petshop.model.Ordem;
import br.com.douglas.petshop.model.OrdemServico;
import br.com.douglas.petshop.model.Servico;
import br.com.douglas.petshop.repository.OrdemRepository;
import br.com.douglas.petshop.repository.OrdemServicoRepository;

@Service
public class OrdemService {
    private final Logger log = LoggerFactory.getLogger(OrdemService.class);

    @Autowired
    OrdemRepository ordemRepository;

    @Autowired
    OrdemServicoRepository ordemServicoRepository;

    @Autowired
    ServicoRepository servicoRepository;

    @Transactional
    public Ordem save(Ordem ordem) {
        // Obtem os servicos da ordem
        List<Servico> servicoList = ordem.getServicos();

        // Inserir os servicos sem as ordens
        ordem.setServicos(new ArrayList<>());
        ordem = ordemRepository.save(ordem);

        // Inserir os servicos individualmente para a ordem em questao.
        for (Servico servico : servicoList) {
            Optional<Servico> servicoOpt = servicoRepository.findById(servico.getId());

            if (servicoOpt.isPresent()) {
                servico = servicoOpt.get();

                OrdemServico ordemServico = new OrdemServico();
                ordemServico.setOrdem(ordem);
                ordemServico.setServico(servico);
                ordemServico.setValor(servico.getValor());
                ordemServicoRepository.save(ordemServico);
            }
        }

        return ordem;
    }

    public Optional<Ordem> findOne(Long id) {
        log.debug("Request to get Ordem : {}", id);
        return ordemRepository.findById(id);
    }

    public List<Ordem> findAllList(){
        log.debug("Request to get All Ordem");
        return ordemRepository.findAll();
    }

    public void delete(Long id) {
        log.debug("Request to delete Ordem : {}", id);
        ordemRepository.deleteById(id);
    }

    public List<Ordem> saveAll(List<Ordem> ordem) {
        log.debug("Request to save Ordem : {}", ordem);
        ordem = ordemRepository.saveAll(ordem);
        return ordem;
    }
}
