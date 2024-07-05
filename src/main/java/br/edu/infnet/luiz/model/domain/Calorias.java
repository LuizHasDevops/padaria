package br.edu.infnet.luiz.model.domain;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class Calorias {

    private Id id;
    private String descricao;
    private String quantidade;
    private String calorias;
    @Data
    @NoArgsConstructor
    public static class Id {
        private long timestamp;
        private String date;
    }
}
