package br.com.zupacademy.frederico.transacao_cartao.dominio.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
public class Cartao {

    @Id
    private UUID id;
    @NotBlank
    @Email
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(UUID id, String email) {
        this.id = id;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
