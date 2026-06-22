package org.formation.projet4;

import org.formation.projet4.components.Adresse;
import org.formation.projet4.components.IPersonne;
import org.formation.projet4.components.Personne;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

@SpringBootApplication
public class Projet4Application {

    public static void main(String[] args) {
        var context = SpringApplication.run(Projet4Application.class, args);
        IPersonne p1 = context.getBean("P", IPersonne.class);
        p1.parler();
        p1.marcher();
        //context.close();

        Map<String, Adresse> beans =
                context.getBeansOfType(Adresse.class);

        beans.forEach((nom, adresse) ->
                System.out.println(nom + " -> " + adresse));

        ApplicationContext contextCLassPath =
                new ClassPathXmlApplicationContext("classpath:spring/mon-contexte.xml");

        Personne personne1 = contextCLassPath.getBean("personne", Personne.class);
        Personne personne2 = contextCLassPath.getBean("personne2", Personne.class);
        System.out.println(personne1);
        System.out.println(personne2);

    }

}
