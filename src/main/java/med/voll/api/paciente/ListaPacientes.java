package med.voll.api.paciente;

import med.voll.api.medico.Especialidade;
import med.voll.api.medico.MedicoJPA;

public record ListaPacientes(
        String nome,
        String email,
        String cpf
) {

    public ListaPacientes(PacienteJPA paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
