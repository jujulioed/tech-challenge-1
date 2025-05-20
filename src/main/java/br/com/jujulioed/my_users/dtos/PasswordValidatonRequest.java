package br.com.jujulioed.my_users.dtos;

public record PasswordValidatonRequest(
        String username,
        String password) {
}
