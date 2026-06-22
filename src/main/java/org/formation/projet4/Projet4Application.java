package org.formation.projet4;

import org.formation.projet4.components.Adresse;
import org.formation.projet4.components.Personne;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Projet4Application {

    public static void main(String[] args) {
        var context = SpringApplication.run(Projet4Application.class, args);
        Personne p1 = context.getBean(Personne.class);
        Personne p2 = context.getBean(Personne.class);
        Adresse a2 = context.getBean(Adresse.class);
        p2.setAdresse(a2);
        System.out.println("Personne p1 - " + p1.hashCode());
        System.out.println("Personne p2 - " + p2.hashCode());
        System.out.println("Adresse de p1 - " + p1.getAdresse().hashCode());
        System.out.println("Adresse de p2 - " + p2.getAdresse().hashCode());
        p2.setAge(45);
        a2.setVille("Antibes");
        System.out.println("Personne p - " + p1);
        System.out.println("Personne p2 - " + p2);

    }

}
