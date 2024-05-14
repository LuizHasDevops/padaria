package br.edu.infnet.luiz;

import java.io.BufferedReader;
import java.io.FileReader;


import br.edu.infnet.luiz.model.service.DoceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.luiz.model.domain.Doce;


@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class DoceLoader implements ApplicationRunner{

    @Autowired
    private DoceService doceService;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("arquivos/Doce.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		System.err.println("#doce");
		while(linha != null) {
			
			campos = linha.split(";");
			
			Doce doce = new Doce();
            doce.setNome(campos[0]);
            doce.setPeso(Integer.valueOf(campos[1]));
            doce.setPreco(Float.valueOf(campos[2]));
			doce.setLight(Boolean.valueOf(campos[3]));
			doce.setSorvete(Boolean.valueOf(campos[4]));
			
			doceService.incluir(doce);
			
			linha = leitura.readLine();
		}
		
		
		System.out.println("iniciando o processamento!");
		for(Doce doce : doceService.obterLista()) {
			System.out.println(doce);
		}
		
		System.out.println("Processamento realizado com sucesso!");
		leitura.close();
		
	}
}

