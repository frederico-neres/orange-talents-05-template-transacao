package br.com.zupacademy.frederico.transacao_cartao.dominio.transacao;

import br.com.zupacademy.frederico.transacao_cartao.dominio.cartao.Cartao;
import br.com.zupacademy.frederico.transacao_cartao.dominio.estabelecimento.Estabelecimento;
import com.sun.istack.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
public class Transacao {

    @Id
    private UUID id;
    @NotNull
    @Positive
    private BigDecimal valor;
    @ManyToOne(cascade = CascadeType.ALL)
    private Estabelecimento estabelecimento;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cartao cartao;
    @PastOrPresent
    private LocalDateTime  efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(UUID id, BigDecimal valor, Estabelecimento estabelecimento,
                     Cartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
