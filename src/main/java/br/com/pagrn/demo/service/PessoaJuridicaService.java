package br.com.pagrn.demo.service;

import br.com.pagrn.demo.dto.PessoaJuridicaDTO;
import br.com.pagrn.demo.model.Endereco;
import br.com.pagrn.demo.model.PessoaFisica;
import br.com.pagrn.demo.model.PessoaJuridica;
import br.com.pagrn.demo.repository.EnderecoRepository;
import br.com.pagrn.demo.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<PessoaJuridica> findAll() {
        return pessoaJuridicaRepository.findAll();
    }

    public Optional<PessoaJuridica> findById(Long id) {
        return pessoaJuridicaRepository.findById(id);
    }

    /*@Transactional
    public PessoaJuridicaDTO create(PessoaJuridicaDTO dto) {

        PessoaJuridica pessoaJuridica = new PessoaJuridica();

        Endereco endereco = enderecoRepository.findById(dto.getEndereco().getId()).orElse(null);

        // fazer verificação pelos outros campos
        if (endereco == null) {
            endereco = new Endereco();
        }

        pessoaJuridica.setNome(dto.getNome());
        pessoaJuridica.setEmail(dto.getEmail());
        pessoaJuridica.setTelefones(dto.getTelefones());
        //pessoaJuridica.setEh_pessoa_fisica(dto.getEh_pessoa_fisica());
        pessoaJuridica.setEndereco(dto.getEndereco());

        endereco.setLatitude(dto.getEndereco().getLatitude());
        endereco.setLongitude(dto.getEndereco().getLongitude());
        endereco.setNumero(dto.getEndereco().getNumero());
        endereco.setComplemento(dto.getEndereco().getComplemento());
        endereco.setLogradouro(dto.getEndereco().getLogradouro());
        endereco.setCep(dto.getEndereco().getCep());
        pessoaJuridica.setEndereco(endereco);

        pessoaJuridica.setCnpj(dto.getCnpj());
        pessoaJuridica.setRazao_social(dto.getRazao_social());

        pessoaJuridica = pessoaJuridicaRepository.save(pessoaJuridica);

        return new PessoaJuridicaDTO(pessoaJuridica);
    }*/

    @Transactional
    public PessoaJuridica create(PessoaJuridica pessoaJuridica) {

        Endereco pe = pessoaJuridica.getEndereco();

        Endereco endereco = enderecoRepository.findById(pe.getId()).orElse(null);

        if (endereco == null) {
            endereco = new Endereco();
            endereco.setLatitude(pe.getLatitude());
            endereco.setLongitude(pe.getLongitude());
            endereco.setNumero(pe.getNumero());
            endereco.setComplemento(pe.getComplemento());
            endereco.setLogradouro(pe.getLogradouro());
            endereco.setCep(pe.getCep());
            pessoaJuridica.setEndereco(endereco);
        }

        return pessoaJuridicaRepository.save(pessoaJuridica);
    }
}
