package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.paciente.ListaPacientes;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteJPA;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public void cadastraPaciente(@RequestBody @Valid Paciente dados){
      repository.save(new PacienteJPA(dados));
    }

    @GetMapping
    public Page<ListaPacientes> listaPacientes(Pageable paginacao){
        return repository.findAll(paginacao).map(ListaPacientes::new);
    }
}
