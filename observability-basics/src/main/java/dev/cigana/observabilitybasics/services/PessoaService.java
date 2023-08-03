package dev.cigana.observabilitybasics.services;

import dev.cigana.observabilitybasics.domain.Pessoa;
import dev.cigana.observabilitybasics.domain.PessoaFormDTO;
import dev.cigana.observabilitybasics.domain.PessoaResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PessoaService {

    Pessoa createPessoa(PessoaFormDTO formDTO);

    Pessoa findById(String idPessoa);

    Pessoa updatePessoa(Pessoa pessoa);

    Page<PessoaResponseDTO> findAll(Pageable pageable);

    void deletePessoa(String idPessoa);

}
