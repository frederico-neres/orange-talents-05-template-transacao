package br.com.zupacademy.frederico.transacao_cartao.dominio.transacao.repository;

import br.com.zupacademy.frederico.transacao_cartao.dominio.transacao.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {
    Page<Transacao> findByCartaoId(UUID id, Pageable pageable);
}
