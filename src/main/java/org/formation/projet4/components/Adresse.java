package org.formation.projet4.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
//@Scope("prototype")
@Data
public class Adresse {

    private Integer numero;
    private String libelleRue;
    private String codePostal;
    private String ville;

    public Adresse(
            @Value("1") Integer numero,
            @Value("avenue des églantines") String libelleRue,
            @Value("06300") String codePostal,
            @Value("Nice") String ville) {
        this.numero = numero;
        this.libelleRue = libelleRue;
        this.codePostal = codePostal;
        this.ville = ville;
    }
}
