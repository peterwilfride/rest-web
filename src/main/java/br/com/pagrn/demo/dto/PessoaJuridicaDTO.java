package br.com.pagrn.demo.dto;

import br.com.pagrn.demo.model.Endereco;
import br.com.pagrn.demo.model.PessoaJuridica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaJuridicaDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefones;
    //private Boolean eh_pessoa_fisica;
    private Endereco endereco;

    private String cnpj;
    private String razao_social;

    public PessoaJuridicaDTO(PessoaJuridica pessoaJuridica) {
        id = pessoaJuridica.getId();
        nome = pessoaJuridica.getNome();
        email = pessoaJuridica.getEmail();
        telefones = pessoaJuridica.getTelefones();
        //eh_pessoa_fisica = pessoaJuridica.getEh_pessoa_fisica();
        endereco = pessoaJuridica.getEndereco();
        cnpj = pessoaJuridica.getCnpj();
        razao_social = pessoaJuridica.getRazao_social();
    }

    public PessoaJuridica extractPessoaJuridica() {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();

        pessoaJuridica.setNome(this.getNome());
        pessoaJuridica.setEmail(this.getEmail());
        pessoaJuridica.setTelefones(this.getTelefones());
        pessoaJuridica.setEndereco(this.getEndereco());

        pessoaJuridica.setEndereco(this.getEndereco());

        pessoaJuridica.setCnpj(this.getCnpj());
        pessoaJuridica.setRazao_social(this.getRazao_social());

        return pessoaJuridica;
    }

}
