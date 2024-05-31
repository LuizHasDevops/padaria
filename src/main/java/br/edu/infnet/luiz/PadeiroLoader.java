package br.edu.infnet.luiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

import br.edu.infnet.luiz.model.domain.Doce;
import br.edu.infnet.luiz.model.domain.Pao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.luiz.model.domain.Padeiro;
import br.edu.infnet.luiz.model.service.PadeiroService;
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class PadeiroLoader implements ApplicationRunner{
	
	@Autowired
	private PadeiroService padeiroService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("arquivos/Padeiro.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

        Padeiro padeiro = null;

		System.err.println("#padeiro");
		while (linha != null) {
			
			campos = linha.split(";");

            switch (campos[0].toUpperCase()){
                case "PA":
                    padeiro = new Padeiro();
                    padeiro.setNome(campos[1]);
                    padeiro.setCpf(campos[2]);

                    padeiroService.incluir(padeiro);
                    break;

                case "P":
                    Pao pao = new Pao();
                    pao.setNome(campos[1]);
                    pao.setPeso(Integer.valueOf(campos[2]));
                    pao.setPreco(Float.valueOf(campos[3]));
                    pao.setIntegral(Boolean.valueOf(campos[4]));
                    pao.setQuantidade(Integer.valueOf(campos[5]));

                    padeiro.getProdutos().add(pao);
                    break;

                case "D":
                    Doce doce = new Doce();
                    doce.setNome(campos[1]);
                    doce.setPeso(Integer.valueOf(campos[2]));
                    doce.setPreco(Float.valueOf(campos[3]));
                    doce.setLight(Boolean.valueOf(campos[4]));
                    doce.setSorvete(Boolean.valueOf(campos[5]));

                    padeiro.getProdutos().add(doce);
                    break;

                default:
                    System.err.println("Linha: " + Arrays.asList(campos));
                    break;
            }
			
			linha = leitura.readLine();
		}
		
		System.out.println("iniciando o processamento!");
		
		for(Padeiro oPadeiro : padeiroService.obterLista()) {
			System.out.println(oPadeiro);
		}

		System.out.println("Processamento realizado com sucesso!");
		leitura.close();
		
	}

}
