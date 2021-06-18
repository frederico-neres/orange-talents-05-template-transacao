package br.com.zupacademy.frederico.transacao_cartao.dominio.estabelecimento.dto;

import br.com.zupacademy.frederico.transacao_cartao.dominio.estabelecimento.Estabelecimento;

import java.util.UUID;

public class EstabelecimentoResponse {

    private UUID id;
    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoResponse(Estabelecimento estabelecimento) {
        this.id = estabelecimento.getId();
        this.nome = estabelecimento.getNome();
        this.cidade = estabelecimento.getCidade();
        this.endereco = estabelecimento.getEndereco();
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
