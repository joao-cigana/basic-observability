package dev.cigana.observabilitybasics.repositories;

import dev.cigana.observabilitybasics.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, String> {

    boolean existsByCpf(String cpf);

}
