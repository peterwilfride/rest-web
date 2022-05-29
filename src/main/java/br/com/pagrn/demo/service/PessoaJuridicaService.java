package br.com.pagrn.demo.service;

import br.com.pagrn.demo.model.Endereco;
import br.com.pagrn.demo.model.PessoaJuridica;
import br.com.pagrn.demo.repository.EnderecoRepository;
import br.com.pagrn.demo.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Page<PessoaJuridica> findAll(Pageable pegeable) {
        return pessoaJuridicaRepository.findAllByRemoved(null, pegeable);
    }

    public Optional<PessoaJuridica> findById(Long id) {
        return pessoaJuridicaRepository.findByIdAndRemoved(id,null);
    }

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
        } else {
            pessoaJuridica.setEndereco(endereco);
        }

        return pessoaJuridicaRepository.save(pessoaJuridica);
    }

    public void delete(PessoaJuridica pessoaJuridica) {

        Date current_date = new Date();

        pessoaJuridica.setRemoved(current_date);
        pessoaJuridicaRepository.save(pessoaJuridica);

        Endereco e = pessoaJuridica.getEndereco();
        e.setRemoved(current_date);
        enderecoRepository.save(e);
    }
}
