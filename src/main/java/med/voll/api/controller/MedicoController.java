package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @Transactional
    @PostMapping
    public void cadastraMedico(@RequestBody @Valid Medico dados) {
        repository.save(new MedicoJPA(dados));
    }

    @GetMapping
    public Page<ListaMedicos> listaMedicos(Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(ListaMedicos::new);
    }

    @Transactional
    @PutMapping
    public void atualizaMedico(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizaInformacoes(dados);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void deletaMedico(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }


}
