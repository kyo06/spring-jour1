package org.formation.projet4.exceptions;

import lombok.AllArgsConstructor;

public class ClientNotFoundException extends Exception {
    public ClientNotFoundException(String s) {
        super(s);
    }
}
