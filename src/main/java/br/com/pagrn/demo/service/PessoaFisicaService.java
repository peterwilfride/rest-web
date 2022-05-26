package br.com.pagrn.demo.service;

import br.com.pagrn.demo.dto.PessoaFisicaDTO;
import br.com.pagrn.demo.model.Endereco;
import br.com.pagrn.demo.model.PessoaFisica;
import br.com.pagrn.demo.model.Servidor;
import br.com.pagrn.demo.model.Vinculo;
import br.com.pagrn.demo.repository.EnderecoRepository;
import br.com.pagrn.demo.repository.PessoaFisicaRepository;
import br.com.pagrn.demo.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ServidorRepository servidorRepository;

    public List<PessoaFisica> findAll() {
        return pessoaFisicaRepository.findAll();
    }

    public Optional<PessoaFisica> findById(Long id) {
        return pessoaFisicaRepository.findById(id);
    }

    /*@Transactional
    public PessoaFisicaDTO create(PessoaFisicaDTO dto) {

        PessoaFisica pessoaFisica = new PessoaFisica();

        Endereco endereco = enderecoRepository.findById(dto.getEndereco().getId()).orElse(null);

        // fazer verificação pelos outros campos
        if (endereco == null) {
            endereco = new Endereco();
        }

        pessoaFisica.setNome(dto.getNome());
        pessoaFisica.setEmail(dto.getEmail());
        pessoaFisica.setTelefones(dto.getTelefones());
        //pessoaFisica.setEh_pessoa_fisica(dto.getEh_pessoa_fisica());

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

        pessoaFisica.setServidores(dto.getServidores());

        pessoaFisica.setDeficiencias(dto.getDeficiencias());

        pessoaFisica = pessoaFisicaRepository.save(pessoaFisica);

        return new PessoaFisicaDTO(pessoaFisica);
    }*/

    @Transactional
    public PessoaFisica create(PessoaFisica pessoaFisica) {

        Endereco pe = pessoaFisica.getEndereco();

        Endereco endereco = enderecoRepository.findById(pe.getId()).orElse(null);

        if (endereco == null) {
            endereco = new Endereco();
            endereco.setLatitude(pe.getLatitude());
            endereco.setLongitude(pe.getLongitude());
            endereco.setNumero(pe.getNumero());
            endereco.setComplemento(pe.getComplemento());
            endereco.setLogradouro(pe.getLogradouro());
            endereco.setCep(pe.getCep());
            pessoaFisica.setEndereco(endereco);
        }

        List<Servidor> ss = pessoaFisica.getServidores();
        for(Servidor s : ss) {
            s.setPessoa_fisica_id(pessoaFisica);
            List<Vinculo> vv = s.getVinculos();
            for(Vinculo v : vv) {
                v.setServidor_id(s);
            }
        }

        return pessoaFisicaRepository.save(pessoaFisica);
    }
}
