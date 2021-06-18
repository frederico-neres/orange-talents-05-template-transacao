package br.com.zupacademy.frederico.transacao_cartao.kafkaListener;

import br.com.zupacademy.frederico.transacao_cartao.dominio.transacao.dto.TransacaoKafkaRequest;
import br.com.zupacademy.frederico.transacao_cartao.dominio.transacao.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class TransacaoCartaoListener {

    TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoCartaoListener(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @Bean
    JsonMessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }

    @KafkaListener(topics = "${spring.kafka.topic.transacoes}")
    public void listenTransacoes(TransacaoKafkaRequest transacaoKafkaRequest) {
        transacaoRepository.save(transacaoKafkaRequest.toModel());
    }
}
