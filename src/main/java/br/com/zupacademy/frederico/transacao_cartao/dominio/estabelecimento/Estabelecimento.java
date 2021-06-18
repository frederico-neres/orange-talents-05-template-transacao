package br.com.zupacademy.frederico.transacao_cartao.dominio.estabelecimento;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
public class Estabelecimento {

    @Id
    private UUID id;
    @NotBlank
    private String nome;
    @NotBlank
    private String cidade;
    @NotBlank
    private String endereco;

    @Deprecated
    public Estabelecimento() {
    }

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
