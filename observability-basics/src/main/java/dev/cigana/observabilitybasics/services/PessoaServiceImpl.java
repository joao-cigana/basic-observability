package dev.cigana.observabilitybasics.services;

import dev.cigana.observabilitybasics.domain.Pessoa;
import dev.cigana.observabilitybasics.domain.PessoaFormDTO;
import dev.cigana.observabilitybasics.domain.PessoaResponseDTO;
import dev.cigana.observabilitybasics.exceptions.InvalidDataException;
import dev.cigana.observabilitybasics.exceptions.ResourceNotFoundException;
import dev.cigana.observabilitybasics.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa createPessoa(PessoaFormDTO formDTO) {
        if(pessoaRepository.existsByCpf(formDTO.getCpf())){
            throw new InvalidDataException("Cpf " + formDTO.getCpf() + " já cadastrado na base de dados.");
        }
        return pessoaRepository.save(formDTO.toPessoa());
    }

    @Override
    public Pessoa findById(String idPessoa) {
        return pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada - id: " + idPessoa));
    }

    @Override
    public Pessoa updatePessoa(Pessoa pessoa) {
        if(!pessoaRepository.existsById(pessoa.getId())){
            throw new ResourceNotFoundException("Pessoa não encontrada - id: " + pessoa.getId());
        }

        Pessoa pessoaExistente = findById(pessoa.getId());
        pessoa.setEmail(pessoa.getEmail());
        pessoa.setTelefone(pessoa.getTelefone());

        return pessoaRepository.save(pessoaExistente);
    }

    @Override
    public Page<PessoaResponseDTO> findAll(Pageable pageable) {
        return pessoaRepository.findAll(pageable).map(PessoaResponseDTO::new);
    }

    @Override
    public void deletePessoa(String idPessoa) {
        if(!pessoaRepository.existsById(idPessoa)){
            throw new ResourceNotFoundException("Pessoa não encontrada - id: " + idPessoa);
        }
        pessoaRepository.deleteById(idPessoa);
    }
}
