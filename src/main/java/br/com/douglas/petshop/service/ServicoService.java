package br.com.douglas.petshop.service;

import br.com.douglas.petshop.model.Servico;
import br.com.douglas.petshop.repository.ServicoRepository;
import br.com.douglas.petshop.repository.ServicoRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

  private final Logger log = LoggerFactory.getLogger(ServicoService.class);

  private final ServicoRepository servicoRepository;

  public ServicoService(ServicoRepository servicoRepository){
    this.servicoRepository = servicoRepository;
  }

  public Optional<Servico> findOne(Long id) {
    log.debug("Request to get Servico : {}", id);
    return servicoRepository.findById(id);
  }

  public List<Servico> findAllList(){
    log.debug("Request to get All Servico");
    return servicoRepository.findAll();
  }

  public void delete(Long id) {
    log.debug("Request to delete Servico : {}", id);
    servicoRepository.deleteById(id);
  }

  public Servico save(Servico servico) {
    log.debug("Request to save Servico : {}", servico);
    servico = servicoRepository.save(servico);
    return servico;
  }

  public List<Servico> saveAll(List<Servico> servico) {
    log.debug("Request to save Servico : {}", servico);
    servico = servicoRepository.saveAll(servico);
    return servico;
  }
}
