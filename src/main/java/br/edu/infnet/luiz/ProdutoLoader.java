package br.edu.infnet.luiz;

import br.edu.infnet.luiz.model.domain.Doce;
import br.edu.infnet.luiz.model.domain.Padeiro;
import br.edu.infnet.luiz.model.domain.Pao;
import br.edu.infnet.luiz.model.domain.Produto;
import br.edu.infnet.luiz.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
@Order(4)
@Component
public class ProdutoLoader implements ApplicationRunner {

    @Autowired
    private ProdutoService produtoService;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("arquivos/Produto.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        System.err.println("#produtos");
        while(linha != null) {

            campos = linha.split(";");

            switch (campos[0].toUpperCase()) {
                case "P":
                    Pao pao = new Pao();
                    pao.setNome(campos[1]);
                    pao.setPeso(Integer.valueOf(campos[2]));
                    pao.setPreco(Float.valueOf(campos[3]));
                    pao.setIntegral(Boolean.valueOf(campos[4]));
                    pao.setQuantidade(Integer.valueOf(campos[5]));

                    pao.setPadeiro(new Padeiro(Integer.valueOf(campos[6])));

                    produtoService.incluir(pao);
                    break;

                case "D":
                    Doce doce = new Doce();
                    doce.setNome(campos[1]);
                    doce.setPeso(Integer.valueOf(campos[2]));
                    doce.setPreco(Float.valueOf(campos[3]));
                    doce.setLight(Boolean.valueOf(campos[4]));
                    doce.setSorvete(Boolean.valueOf(campos[5]));

                    doce.setPadeiro(new Padeiro(Integer.valueOf(campos[6])));

                    produtoService.incluir(doce);
                    break;

                default:
                    System.err.println("Tipo inválido!!!");
            }

            linha = leitura.readLine();

        }

        System.out.println("Iniciando o processamento!");
        for(Produto produto : produtoService.obterLista()){
               System.out.println(produto);
    }
    System.out.println("Processamento realizado com sucesso!");
    leitura.close();
    }
}
