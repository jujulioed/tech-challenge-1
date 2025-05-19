package br.com.jujulioed.my_users.repositories;

import br.com.jujulioed.my_users.entities.User;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImp implements UserRepository {
    private final JdbcClient jdbcClient;
    public UserRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    @Override
    public Optional<User> findById(Long id) {
        return this.jdbcClient
                .sql("SELECT * FROM users WHERE id = :id")
                .param("id", id)
                .query(User.class)
                .optional();
    }

    @Override
    public List<User> findAll(int size, int offset) {
        return null;
    }

    @Override
    public Integer save(User user) {
        return null;
    }

    @Override
    public Integer update(User user, Long id) {
        return null;
    }

    @Override
    public Integer delete(Long id) {
        return null;
    }
}
