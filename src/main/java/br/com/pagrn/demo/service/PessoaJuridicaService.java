package br.com.pagrn.demo.service;

import br.com.pagrn.demo.dto.PessoaJuridicaDTO;
import br.com.pagrn.demo.model.Endereco;
import br.com.pagrn.demo.model.PessoaFisica;
import br.com.pagrn.demo.model.PessoaJuridica;
import br.com.pagrn.demo.repository.EnderecoRepository;
import br.com.pagrn.demo.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    /*
    public Page<PessoaJuridica> find() {
        Para cada pessoa jurifica no banco de dados, verificar
        * se o atributo removed é null, se sim, adiciona a pessoa
        * na lista, se não ignora. Ao final converte a lista para
        * um Page.
        *
        List<PessoaJuridica> pjs = pessoaJuridicaRepository.findAll();
        List<PessoaJuridica> new_pjs = new ArrayList<>();
        for(int i = 0; i < pessoaJuridicaRepository.count(); i++) {
            PessoaJuridica pj = pjs.get(i);
            if (pj.getRemoved() == null) {
                new_pjs.add(pj);
            }
        }
        return new PageImpl<>(new_pjs);
    }*/

    public Optional<PessoaJuridica> findById(Long id) {
        return pessoaJuridicaRepository.findByIdAndRemoved(id,null);
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
