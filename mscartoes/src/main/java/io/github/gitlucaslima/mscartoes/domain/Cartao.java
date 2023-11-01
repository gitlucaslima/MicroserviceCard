package io.github.gitlucaslima.mscartoes.domain;

import io.github.gitlucaslima.mscartoes.domain.enums.BandeiraCartao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cartao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeiraCartao;

    private BigDecimal renda;

    private BigDecimal limiteBasico;

    public Cartao(String nome,
                  BandeiraCartao bandeiraCartao,
                  BigDecimal renda,
                  BigDecimal limiteBasico) {
        this.nome = nome;
        this.bandeiraCartao = bandeiraCartao;
        this.renda = renda;
        this.limiteBasico = limiteBasico;
    }
}
