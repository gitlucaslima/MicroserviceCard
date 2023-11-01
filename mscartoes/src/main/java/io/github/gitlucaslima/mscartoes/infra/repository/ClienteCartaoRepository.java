package io.github.gitlucaslima.mscartoes.infra.repository;

import io.github.gitlucaslima.mscartoes.domain.ClienteCartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, UUID> {

    List<ClienteCartao> findByCpf(String cpf);
}
