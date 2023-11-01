package io.github.gitlucaslima.mscartoes.application;

import io.github.gitlucaslima.mscartoes.domain.ClienteCartao;
import io.github.gitlucaslima.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    @Autowired
    private ClienteCartaoRepository clienteCartaoRepository;

    public List<ClienteCartao> listCartosbyCpf(String cpf){
        return this.clienteCartaoRepository.findByCpf(cpf);
    }
}
