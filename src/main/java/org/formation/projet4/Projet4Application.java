package org.formation.projet4;

import org.formation.projet4.components.Adresse;
import org.formation.projet4.components.IPersonne;
import org.formation.projet4.components.Personne;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Projet4Application {

    public static void main(String[] args) {
        var context = SpringApplication.run(Projet4Application.class, args);
        IPersonne p1 = context.getBean("P", IPersonne.class);
        p1.parler();
        p1.marcher();

    }

}
