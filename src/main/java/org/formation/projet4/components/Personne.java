package org.formation.projet4.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("P")
@Data
@NoArgsConstructor
public class Personne implements IPersonne {

    private Integer id;
    private String name;
    private Integer age;

    private Adresse adresse;

    /*
    public void setAdresse(@Qualifier("") Adresse adresse) {
        this.adresse = adresse;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void Age(Integer age) {
        this.age = age;
    }
    */
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

    @Override
    public void parler() {
        System.out.println("blabla");
    }

    @Override
    public void marcher() {
        System.out.println("Je marche");
    }

}
