package br.com.zupacademy.frederico.transacao_cartao.dominio.cartao.dto;

import br.com.zupacademy.frederico.transacao_cartao.dominio.cartao.Cartao;

import java.util.UUID;

public class CartaoResponse {
    private UUID id;
    private String email;

    public CartaoResponse(Cartao cartao) {
        this.id = cartao.getId();
        this.email = cartao.getEmail();
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
