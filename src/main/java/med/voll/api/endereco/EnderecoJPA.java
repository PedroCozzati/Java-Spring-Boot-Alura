package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class EnderecoJPA {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public EnderecoJPA(Endereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.uf = endereco.uf();
        this.cidade = endereco.cidade();
        this.complemento = endereco.complemento();
        this.numero = endereco.numero();
    }

    public void atualizaEndereco(Endereco dados) {
        if(dados.logradouro()!=null){
            this.logradouro = dados.logradouro();
        }
        if(dados.bairro()!=null){
            this.bairro = dados.bairro();
        }
        if(dados.cep()!=null){
            this.cep = dados.cep();
        }
        if(dados.numero()!=null){
            this.numero = dados.numero();
        }
        if(dados.complemento()!=null){
            this.complemento= dados.complemento();
        }
        if(dados.cidade()!=null){
            this.cidade= dados.cidade();
        }
        if(dados.uf()!=null){
            this.uf = dados.uf();
        }
    }
}
