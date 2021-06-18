package br.com.zupacademy.frederico.transacao_cartao.dominio.estabelecimento.dto;

import br.com.zupacademy.frederico.transacao_cartao.dominio.estabelecimento.Estabelecimento;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EstabelecimentoKafkaRequest {

    @JsonProperty
    private String nome;
    @JsonProperty
    private String cidade;
    @JsonProperty
    private String endereco;

    @Deprecated
    public EstabelecimentoKafkaRequest() {
    }

    public EstabelecimentoKafkaRequest(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public Estabelecimento toModel() {
        return new Estabelecimento(nome, cidade, endereco);
    }
}
