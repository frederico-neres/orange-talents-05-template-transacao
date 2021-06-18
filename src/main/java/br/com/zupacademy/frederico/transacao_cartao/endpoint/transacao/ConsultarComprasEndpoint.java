package br.com.zupacademy.frederico.transacao_cartao.endpoint.transacao;


import br.com.zupacademy.frederico.transacao_cartao.dominio.transacao.Transacao;
import br.com.zupacademy.frederico.transacao_cartao.dominio.transacao.dto.ConsultarComprasResponse;
import br.com.zupacademy.frederico.transacao_cartao.dominio.transacao.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transacao")
public class ConsultarComprasEndpoint {

    TransacaoRepository transacaoRepository;

    @Autowired
    public ConsultarComprasEndpoint(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping("/{id}/consultar/compras")
    public ResponseEntity<?> consultarCompras(@PathVariable("id") UUID id,
                                              @PageableDefault(direction = Sort.Direction.DESC, sort = {"efetivadaEm"},
                                                      page = 0, size = 10) Pageable pageable) {

        Page<Transacao> compras = transacaoRepository.findByCartaoId(id, pageable);

        return compras.isEmpty() ? ResponseEntity.notFound().build() :
                ResponseEntity.ok().body((compras.map(ConsultarComprasResponse::new)));
    }
}
