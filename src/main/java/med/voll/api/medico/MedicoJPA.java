package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.EnderecoJPA;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "medicos")
@Entity(name = "Medico")
public class MedicoJPA {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private EnderecoJPA endereco;

    private Boolean ativo;

    public MedicoJPA(Medico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.endereco = new EnderecoJPA(dados.endereco());
        this.especialidade = dados.especialidade();
    }

    public void atualizaInformacoes(DadosAtualizacaoMedico dados) {
        if(dados.nome()!=null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco()!= null){
            this.endereco.atualizaEndereco(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
