package io.github.gitlucaslima.mscartoes.application.representation;

import io.github.gitlucaslima.mscartoes.domain.Cartao;
import io.github.gitlucaslima.mscartoes.domain.enums.BandeiraCartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoSaveRequest {
    private String nome;
    private BandeiraCartao bandeira;

    private BigDecimal renda;

    private BigDecimal limite;

    public Cartao toModel(){
        return  new Cartao(nome, bandeira, renda, limite);
    }
}
