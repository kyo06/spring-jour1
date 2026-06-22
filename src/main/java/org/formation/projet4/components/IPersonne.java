package org.formation.projet4.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope("singleton")
@Scope("prototype")
public interface IPersonne {
    void parler();

    void marcher();

    String getName();
}
