package io.github.gitlucaslima.msclientes.application;

import io.github.gitlucaslima.msclientes.domain.Cliente;
import io.github.gitlucaslima.msclientes.infra.Repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente save(Cliente cliente){
       return this.clienteRepository.save(cliente);
    }

    public Optional<Cliente> getByCpf(String cpf){
        return this.clienteRepository.findByCpf(cpf);
    }

}
