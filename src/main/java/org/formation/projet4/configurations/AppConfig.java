package org.formation.projet4.configurations;


import org.formation.projet4.components.Adresse;
import org.formation.projet4.components.Personne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean("addresse1FromConfig")
    // @Primary
    public Adresse adresse() {
        return new Adresse(
                1,
                "avenue des églantines",
                "06300",
                "Nice");
    }

    @Bean("personne1FromConfig")
    public Personne personne() {
        return new Personne(
                1,
                "John",
                25,
                adresse());
    }
}
