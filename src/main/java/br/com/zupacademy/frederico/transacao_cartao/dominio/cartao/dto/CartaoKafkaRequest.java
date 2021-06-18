package br.com.zupacademy.frederico.transacao_cartao.dominio.cartao.dto;

import br.com.zupacademy.frederico.transacao_cartao.dominio.cartao.Cartao;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class CartaoKafkaRequest {

    @JsonProperty
    private UUID id;
    @JsonProperty
    private String email;

    @Deprecated
    public CartaoKafkaRequest() {
    }

    public CartaoKafkaRequest(UUID id, String email) {
        this.id = id;
        this.email = email;
    }

    public Cartao toModel() {
        return new Cartao(id, email);
    }

}
