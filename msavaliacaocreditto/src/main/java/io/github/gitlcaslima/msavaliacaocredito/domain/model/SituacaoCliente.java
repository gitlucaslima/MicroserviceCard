package io.github.gitlcaslima.msavaliacaocredito.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SituacaoCliente {
    private DadosCliente clinte;

    private List<CartaoCliente> cartoes;

}
