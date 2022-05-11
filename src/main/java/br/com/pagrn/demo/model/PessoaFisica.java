package br.com.pagrn.demo.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;

@Entity(name = "pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id")
public class PessoaFisica extends Pessoa {

    char sexo;

    String cpf;

    Date data_nascumento;

    String tipo_sangue;

    String nome_pai;

    String nome_mae;

    String foto;

}
