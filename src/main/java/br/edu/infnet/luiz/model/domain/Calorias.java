package br.edu.infnet.luiz.model.domain;

import lombok.Data;

import java.time.LocalDateTime;
@Data

public class Calorias {

    private Integer id;
    private long timestamp;
    private LocalDateTime date;
    private String descricao;
    private String quantidade;
    private String calorias;

}
