package br.com.pagrn.demo.dto;

import br.com.pagrn.demo.model.Endereco;
import br.com.pagrn.demo.model.PessoaFisica;
import br.com.pagrn.demo.model.Servidor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaFisicaDTO implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private String telefones;
    private Boolean eh_pessoa_fisica;
    private Endereco endereco;

    private Character sexo;
    private String cpf;
    private Date data_nascimento;
    private String tipo_sangue;
    private String nome_pai;
    private String nome_mae;
    private String foto;

    private List<Servidor> servidores;

    public PessoaFisicaDTO(PessoaFisica pessoaFisica) {
        id = pessoaFisica.getId();
        nome = pessoaFisica.getNome();
        email = pessoaFisica.getEmail();
        telefones = pessoaFisica.getTelefones();
        eh_pessoa_fisica = pessoaFisica.getEh_pessoa_fisica();

        endereco = pessoaFisica.getEndereco();

        sexo = pessoaFisica.getSexo();
        cpf = pessoaFisica.getCpf();
        data_nascimento = pessoaFisica.getData_nascimento();
        tipo_sangue = pessoaFisica.getTipo_sangue();
        nome_pai = pessoaFisica.getNome_pai();
        nome_mae = pessoaFisica.getNome_mae();
        foto = pessoaFisica.getFoto();

        servidores = pessoaFisica.getServidores();
    }
}
