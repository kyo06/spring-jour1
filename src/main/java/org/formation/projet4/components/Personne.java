package org.formation.projet4.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope("singleton")
@Scope("prototype")
@Data
public class Personne {

    private Integer id;
    private String name;
    private Integer age;

    private Adresse adresse;

    public Personne(
            @Value("1") Integer id,
            @Value("John") String name,
            @Value("25") Integer age,
            Adresse adresse) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.adresse = adresse;
    }
}
