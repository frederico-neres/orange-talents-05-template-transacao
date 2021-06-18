package br.com.zupacademy.frederico.transacao_cartao.dominio.transacao.repository;

import br.com.zupacademy.frederico.transacao_cartao.dominio.transacao.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {
}
