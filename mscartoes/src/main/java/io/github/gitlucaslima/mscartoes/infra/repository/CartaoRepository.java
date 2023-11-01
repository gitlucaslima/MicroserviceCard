package io.github.gitlucaslima.mscartoes.infra.repository;

import io.github.gitlucaslima.mscartoes.domain.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CartaoRepository extends JpaRepository<Cartao, UUID> {
    List<Cartao> findByRendaLessThanEqual(BigDecimal renda);

    Optional<Cartao> findById(UUID uuid);
}
