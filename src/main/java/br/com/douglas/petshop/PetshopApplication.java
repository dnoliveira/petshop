package br.com.douglas.petshop;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.douglas.petshop.model.Ordem;
import br.com.douglas.petshop.model.Pet;
import br.com.douglas.petshop.model.Servico;
import br.com.douglas.petshop.repository.OrdemRepository;
import br.com.douglas.petshop.repository.OrdemServicoRepository;
import br.com.douglas.petshop.repository.PetRepository;
import br.com.douglas.petshop.repository.ServicoRepository;
import br.com.douglas.petshop.service.OrdemService;

@SpringBootApplication
public class PetshopApplication implements ApplicationRunner {

	@Autowired
	PetRepository petRepository;

	@Autowired
	ServicoRepository servicoRepository;

	@Autowired
	OrdemRepository ordemRepository;

	@Autowired
	OrdemServicoRepository ordemServicoRepository;

	@Autowired
	OrdemService ordemService;

	public static void main(String[] args) {
		SpringApplication.run(PetshopApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Pet pet1 = new Pet("Bidu", "Monica");
		Pet pet2 = new Pet("Spike", "Gabriella");
		pet1 = petRepository.save(pet1);
		pet2 = petRepository.save(pet2);
		System.out.println(pet1);
		System.out.println(pet2);

		Servico serv1 = new Servico("Tosa", new BigDecimal(50.0));
		Servico serv2 = new Servico("Banho", new BigDecimal(30.0));
		serv1 = servicoRepository.save(serv1);
		serv2 = servicoRepository.save(serv2);
		System.out.println(serv1);
		System.out.println(serv2);

		List<Servico> servicoList = new ArrayList<Servico>();
		servicoList.add(serv1);
		servicoList.add(serv2);
		Ordem ordem = new Ordem(Instant.parse("2022-05-13T00:00:00.00Z"), "", pet1, servicoList);
		ordemService.save(ordem);

		/*
		 * ordem = ordemRepository.save(ordem);
		 * 
		 * List<Servico> servicoList = new ArrayList<Servico>();
		 * servicoList.add(serv1);
		 * servicoList.add(serv2);
		 * for (Servico servico : servicoList) {
		 * OrdemServico ordemServico = new OrdemServico();
		 * ordemServico.setOrdem(ordem);
		 * ordemServico.setServico(servico);
		 * ordemServico.setValor(servico.getValor());
		 * ordemServicoRepository.save(ordemServico);
		 * }
		 */

	}

}
