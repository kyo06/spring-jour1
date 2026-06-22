package org.formation.projet4.components;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("PE")
@Primary
@Data
public class PersonneEspace implements IPersonne {

    private Integer id;
    private String name;
    private Integer age;

    private Adresse adresse;

    public PersonneEspace(
            @Value("1") Integer id,
            @Value("John") String name,
            @Value("25") Integer age,
            Adresse adresse) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.adresse = adresse;
    }

    @Override
    public void parler() {
        System.out.println("blublu");
    }

    @Override
    public void marcher() {
        System.out.println("Je vole");
    }

}
