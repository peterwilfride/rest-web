package br.com.pagrn.demo.service;

import br.com.pagrn.demo.dto.PessoaFisicaDTO;
import br.com.pagrn.demo.model.Endereco;
import br.com.pagrn.demo.model.PessoaFisica;
import br.com.pagrn.demo.repository.EnderecoRepository;
import br.com.pagrn.demo.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaFisicaService {

    //@Autowired
    //private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<PessoaFisica> findAll() {
        return pessoaFisicaRepository.findAll();
    }

    /*
    public Optional<PessoaFisica> findById(Long id) {
        return repository.findById(id);
    }*/
    @Transactional
    public PessoaFisicaDTO create(PessoaFisicaDTO dto) {

        PessoaFisica pessoaFisica = new PessoaFisica();

        Endereco endereco = enderecoRepository.findById(dto.getEndereco().getId()).orElse(null);

        if (endereco == null) {
            endereco = new Endereco();
        }

        pessoaFisica.setNome(dto.getNome());
        pessoaFisica.setEmail(dto.getEmail());
        pessoaFisica.setTelefones(dto.getTelefones());
        pessoaFisica.setEh_pessoa_fisica(dto.getEh_pessoa_fisica());

        endereco.setLatitude(dto.getEndereco().getLatitude());
        endereco.setLongitude(dto.getEndereco().getLongitude());
        endereco.setNumero(dto.getEndereco().getNumero());
        endereco.setComplemento(dto.getEndereco().getComplemento());
        endereco.setLogradouro(dto.getEndereco().getLogradouro());
        endereco.setCep(dto.getEndereco().getCep());
        pessoaFisica.setEndereco(endereco);

        pessoaFisica.setSexo(dto.getSexo());
        pessoaFisica.setCpf(dto.getCpf());
        pessoaFisica.setTipo_sangue(dto.getTipo_sangue());
        pessoaFisica.setData_nascimento(dto.getData_nascimento());
        pessoaFisica.setNome_pai(dto.getNome_pai());
        pessoaFisica.setNome_mae(dto.getNome_mae());
        pessoaFisica.setFoto(dto.getFoto());

        pessoaFisica = pessoaFisicaRepository.save(pessoaFisica);

        return new PessoaFisicaDTO(pessoaFisica);
    }


}
