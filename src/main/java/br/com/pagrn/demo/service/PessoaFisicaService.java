package br.com.pagrn.demo.service;

import br.com.pagrn.demo.dto.PessoaFisicaDTO;
import br.com.pagrn.demo.model.Deficiencia;
import br.com.pagrn.demo.model.Endereco;
import br.com.pagrn.demo.model.PessoaFisica;
import br.com.pagrn.demo.model.Servidor;
import br.com.pagrn.demo.repository.DeficienciaRepository;
import br.com.pagrn.demo.repository.EnderecoRepository;
import br.com.pagrn.demo.repository.PessoaFisicaRepository;
import br.com.pagrn.demo.repository.ServidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ServidorRepository servidorRepository;

    @Autowired
    private DeficienciaRepository deficienciaRepository;

    public List<PessoaFisica> findAll() {
        return pessoaFisicaRepository.findAll();
    }

    public Optional<PessoaFisica> findById(Long id) {
        return pessoaFisicaRepository.findById(id);
    }

    @Transactional
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

        List<Servidor> servidores = dto.getServidores();
        for (Servidor s : servidores) {
            Servidor servidor = new Servidor();
            servidor.setMatricula(s.getMatricula());
            servidor.setNome_social(s.getNome_social());
            servidor.setPessoa_fisica_id(pessoaFisica);
            servidor = servidorRepository.save(servidor);
        }
        //pessoaFisica.setServidores(servidores);

        Set<Deficiencia> deficiencias = dto.getDeficiencias();
        System.out.println(deficiencias);
        for (Deficiencia d : deficiencias) {
            Deficiencia deficiencia = new Deficiencia();
            deficiencia.setTipo(d.getTipo());
            deficiencia.setDenominacao(d.getDenominacao());
            deficiencia.getPessoaFisicas().add(pessoaFisica);
            deficiencia = deficienciaRepository.save(deficiencia);
        }
        pessoaFisica.setDeficiencias(deficiencias);

        pessoaFisica = pessoaFisicaRepository.save(pessoaFisica);

        return new PessoaFisicaDTO(pessoaFisica);
    }


}
