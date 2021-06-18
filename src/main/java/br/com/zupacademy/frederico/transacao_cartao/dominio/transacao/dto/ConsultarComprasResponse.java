package br.com.zupacademy.frederico.transacao_cartao.dominio.transacao.dto;

import br.com.zupacademy.frederico.transacao_cartao.dominio.cartao.dto.CartaoResponse;
import br.com.zupacademy.frederico.transacao_cartao.dominio.estabelecimento.dto.EstabelecimentoResponse;
import br.com.zupacademy.frederico.transacao_cartao.dominio.transacao.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ConsultarComprasResponse {

    private UUID id;
    private BigDecimal valor;
    private EstabelecimentoResponse estabelecimento;
    private CartaoResponse cartao;
    private LocalDateTime efetivadaEm;

    public ConsultarComprasResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento());
        this.cartao = new CartaoResponse(transacao.getCartao());
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }
}
