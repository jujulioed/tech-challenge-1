package br.com.jujulioed.my_users.repositories;

import br.com.jujulioed.my_users.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);
    List<User> findAll(int size, int offset);
    Integer save(User user);
    Integer update(User user, Long id);
    Integer delete(Long id);
}
