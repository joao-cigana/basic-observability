package dev.cigana.observabilitybasics.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaFormDTO {

    @NotBlank(message = "Campo 'nome' não pode ser vazio.")
    private String nome;

    @NotBlank(message = "Campo 'email' não pode ser vazio.")
    private String email;

    @NotBlank(message = "Campo 'cpf' não pode ser vazio.")
    @CPF(message = "CPF informado não é válido.")
    private String cpf;

    private String telefone;

    public Pessoa toPessoa(){
        return Pessoa.builder()
                .nome(this.nome)
                .email(this.email)
                .cpf(this.cpf)
                .telefone(this.telefone)
                .build();
    }

}
