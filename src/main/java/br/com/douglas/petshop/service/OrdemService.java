package br.com.douglas.petshop.service;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    OrdemRepository ordemRepository;

    @Autowired
    OrdemServicoRepository ordemServicoRepository;

    @Transactional
    public Ordem save(Ordem ordem) {
        // Obtem os servicos da ordem
        List<Servico> servicoList = new ArrayList<Servico>();
        servicoList = ordem.getServicos();

        // Inserir os servicos sem as ordens
        ordem.setServicos(new ArrayList<Servico>());
        ordem = ordemRepository.save(ordem);

        // Inserir os servicos individualmente para a ordem em questao.
        for (Servico servico : servicoList) {
            OrdemServico ordemServico = new OrdemServico();
            ordemServico.setOrdem(ordem);
            ordemServico.setServico(servico);
            ordemServico.setValor(servico.getValor());
            ordemServicoRepository.save(ordemServico);
        }

        return ordem;
    }
}
