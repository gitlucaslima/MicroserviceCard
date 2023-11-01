package io.github.gitlcaslima.msavaliacaocredito.application;

import io.github.gitlcaslima.msavaliacaocredito.domain.model.DadosCliente;
import io.github.gitlcaslima.msavaliacaocredito.infra.clients.ClienteResourceClient;
import io.github.gitlcaslima.msavaliacaocredito.domain.model.SituacaoCliente;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    @Autowired
    private ClienteResourceClient clienteResourceClient;

    public SituacaoCliente obterSituacaoCliente(String cpf){

//        pobter dados cliente -mscliente
//        obter cartoes do cliente -mscartoes

         ResponseEntity<DadosCliente> dadosClienteResponse = clienteResourceClient.dadosCliente(cpf);

        return SituacaoCliente.builder()
                .clinte(dadosClienteResponse.getBody())
                .build();
    }
}
