package br.com.zupacademy.frederico.transacao_cartao.dominio.transacao.dto;

import br.com.zupacademy.frederico.transacao_cartao.dominio.cartao.Cartao;
import br.com.zupacademy.frederico.transacao_cartao.dominio.cartao.dto.CartaoKafkaRequest;
import br.com.zupacademy.frederico.transacao_cartao.dominio.estabelecimento.Estabelecimento;
import br.com.zupacademy.frederico.transacao_cartao.dominio.estabelecimento.dto.EstabelecimentoKafkaRequest;
import br.com.zupacademy.frederico.transacao_cartao.dominio.transacao.Transacao;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

public class TransacaoKafkaRequest {
    @JsonProperty
    private UUID id;
    @JsonProperty
    private BigDecimal valor;
    @JsonProperty
    private EstabelecimentoKafkaRequest estabelecimento;
    @JsonProperty
    private CartaoKafkaRequest cartao;
    @JsonProperty
    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacaoKafkaRequest() {
    }

    public TransacaoKafkaRequest(UUID id, BigDecimal valor, EstabelecimentoKafkaRequest estabelecimento,
                                 CartaoKafkaRequest cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public Transacao toModel() {
        return new Transacao(id, valor, estabelecimento.toModel(),
                cartao.toModel(), efetivadaEm);
    }

}
