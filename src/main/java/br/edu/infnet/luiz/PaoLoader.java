package br.edu.infnet.luiz;

import java.io.BufferedReader;
import java.io.FileReader;


import br.edu.infnet.luiz.model.domain.Padeiro;
import br.edu.infnet.luiz.model.service.PaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.luiz.model.domain.Pao;


@Order(3)
@Component
public class PaoLoader implements ApplicationRunner{

    @Autowired
    private PaoService paoService;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		

		FileReader file = new FileReader("arquivos/Pao.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		System.err.println("#pao");
		while (linha != null) {
			
			campos = linha.split(";");
			
			Pao pao = new Pao();
            pao.setNome(campos[0]);
            pao.setPeso(Integer.valueOf(campos[1]));
            pao.setPreco(Float.valueOf(campos[2]));
			pao.setIntegral(Boolean.valueOf(campos[3]));
			pao.setQuantidade(Integer.valueOf(campos[4]));

            pao.setPadeiro(new Padeiro(Integer.valueOf(campos[5])));
			
			paoService.incluir(pao);

			linha = leitura.readLine();
		}
		
		System.out.println("iniciando o processamento!");
		for(Pao pao : paoService.obterLista()) {
			System.out.println(pao);
		}
		
		System.out.println("Processamento realizado com sucesso!");

		leitura.close();
				
	}

}
