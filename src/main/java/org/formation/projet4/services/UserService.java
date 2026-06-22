package org.formation.projet4.services;

import org.formation.projet4.security.RequiresRole;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @RequiresRole("USER")
    public String getUserById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID invalide");
        }
        return "User-" + id;
    }

    @RequiresRole("ADMIN")
    public String deleteUser(int id) {
        return "User " + id + " supprimé";
    }
}
