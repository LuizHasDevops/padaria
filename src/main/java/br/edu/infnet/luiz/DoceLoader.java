package br.edu.infnet.luiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.luiz.model.domain.Doce;
import br.edu.infnet.luiz.model.domain.Pao;


@Component
public class DoceLoader implements ApplicationRunner{
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Map<Integer, Doce> mapa = new HashMap<Integer, Doce>();
		Integer id = 0;
		
		FileReader file = new FileReader("Doce.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		String[] campos = null;
		
		while (linha != null) {
			
			campos = linha.split(";");
			
			Doce doce = new Doce();
			doce.setId(++id);
			doce.setLight(Boolean.parseBoolean(campos[0]));
			doce.setSorvete(Boolean.parseBoolean(campos[1]));
			doce.setNome(campos[2]);
			doce.setPeso(Integer.parseInt(campos[3]));
			doce.setPreco(Float.parseFloat(campos[4]));
			
			mapa.put(doce.getId(), doce);
			
			linha = leitura.readLine();
		}
		
		
		System.out.println("iniciando o processamento!");
		for(Doce doce : listaDoce) {
			System.out.println(doce);
		}
		
		System.out.println("Processamento realizado com sucesso!");
		leitura.close();
		
	}

}

