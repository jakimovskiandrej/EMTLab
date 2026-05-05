package mk.ukim.finki.wp.lab1b.model.dto;

import mk.ukim.finki.wp.lab1b.model.domain.User;
import mk.ukim.finki.wp.lab1b.model.enums.Role;

public record RegisterUserRequestDto(
        String name,
        String surname,
        String email,
        String username,
        String password,
        Role role
) {
    public User toUser() {
        return new User(name, surname, email, username, password,role);
    }
}