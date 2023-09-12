package med.voll.api.medico;

public record ListaMedicos(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {

    public ListaMedicos(MedicoJPA medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
