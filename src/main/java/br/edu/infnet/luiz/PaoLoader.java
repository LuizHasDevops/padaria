package br.edu.infnet.luiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.luiz.model.domain.Pao;

@Component
public class PaoLoader implements ApplicationRunner{
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Map<Integer, Pao> mapa = new HashMap<Integer, Pao>();
		Integer id = 0;
		
		FileReader file = new FileReader("Pao.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		String[] campos = null;
		
		while (linha != null) {
			
			campos = linha.split(";");
			
			Pao pao = new Pao();
			pao.setId(++id);
			pao.setIntegral(Boolean.parseBoolean(campos[0]));
			pao.setQuantidade(Integer.parseInt(campos[1]));
			pao.setNome(campos[2]);
			pao.setPeso(Integer.parseInt(campos[3]));
			pao.setPreco(Float.parseFloat(campos[4]));
			
			mapa.put(pao.getId(), pao);
			
		
			linha = leitura.readLine();
		}
		
		System.out.println("iniciando o processamento!");
		
		for(Pao pao : mapa.values()) {
			System.out.println(pao);
		}
		
		System.out.println("Processamento realizado com sucesso!");
		leitura.close();
				
	}

}
