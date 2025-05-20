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
        return this.jdbcClient
                .sql("SELECT * FROM users LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(User.class)
                .list();
    }

    @Override
    public Integer save(User user) {
        return this.jdbcClient
                .sql("INSERT INTO users (name, email, username, password, birthday) VALUES (:name, :email, :username, :password, :birthday)")
                .param("name", user.getName())
                .param("email", user.getEmail())
                .param("username", user.getUsername())
                .param("password", user.getPassword())
                .param("birthday", user.getBirthday())
                .update();
    }

    @Override
    public Integer update(User user, Long id) {
        return this.jdbcClient
                .sql("UPDATE users SET name = :name, email = :email, username = :user, password = :password, birthday = :birthday WHERE id = :id")
                .param("id", user.getId())
                .param("name", user.getName())
                .param("email", user.getEmail())
                .param("user", user.getUsername())
                .param("password", user.getPassword())
                .param("birthday", user.getBirthday())
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM users WHERE id = :id")
                .param("id", id)
                .update();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return this.jdbcClient
                .sql("SELECT * FROM users WHERE username = :username")
                .param("username", username)
                .query(User.class)
                .optional();
    }
}
