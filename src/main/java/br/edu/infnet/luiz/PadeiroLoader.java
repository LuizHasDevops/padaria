package br.edu.infnet.luiz;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.luiz.model.domain.Padeiro;
import br.edu.infnet.luiz.model.service.PadeiroService;

@Component
public class PadeiroLoader implements ApplicationRunner{
	
	@Autowired
	private PadeiroService padeiroService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		
		FileReader file = new FileReader("Padeiro.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		String[] campos = null;
		
		while (linha != null) {
			
			campos = linha.split(";");
			
			Padeiro padeiro = new Padeiro();
			padeiro.setNome(campos[0]);
			padeiro.setCpf(campos[1]);
			
	 	    padeiroService.incluir(padeiro);
			
			linha = leitura.readLine();
		}
		
		System.out.println("iniciando o processamento!");
		
		for(Padeiro padeiro : padeiroService.obterLista()) {
			System.out.println(padeiro);
		}

		System.out.println("Processamento realizado com sucesso!");
		leitura.close();
		
	}

}
