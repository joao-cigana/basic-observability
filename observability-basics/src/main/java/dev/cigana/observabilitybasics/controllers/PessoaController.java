package dev.cigana.observabilitybasics.controllers;

import dev.cigana.observabilitybasics.domain.Pessoa;
import dev.cigana.observabilitybasics.domain.PessoaFormDTO;
import dev.cigana.observabilitybasics.domain.PessoaResponseDTO;
import dev.cigana.observabilitybasics.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> createPessoa(@RequestBody @Valid PessoaFormDTO formDTO){
        Pessoa pessoa = pessoaService.createPessoa(formDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable("id") String id){
        return ResponseEntity.ok(pessoaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<PessoaResponseDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok(pessoaService.findAll(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable("id") String id){
        pessoaService.deletePessoa(id);
        return ResponseEntity.noContent().build();
    }

}
