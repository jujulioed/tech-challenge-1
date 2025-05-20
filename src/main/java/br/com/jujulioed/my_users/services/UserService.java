package br.com.jujulioed.my_users.services;

import br.com.jujulioed.my_users.entities.User;
import br.com.jujulioed.my_users.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers(int page, int size) {
        int offset = (page - 1) * size;
        return this.userRepository.findAll(size, offset);
    }

    public Optional<User> findUserById(Long id) {
        return  this.userRepository.findById(id);
    }

    public void saveUser(User user) {
        var save = this.userRepository.save(user);
        Assert.state(save == 1, "Error salving the user "+ user.getName());
    }

    public void updateUser(User user, Long id) {
        var update = this.userRepository.update(user, id);
        if(update == 0) {
            throw  new RuntimeException("User not found");
        }
    }

    public void delete(Long id) {
        var delete = userRepository.delete(id);
        if(delete == 0) {
            throw new RuntimeException("User not found");
        }
    }

    public boolean validatePassword(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return user.getPassword().equals(password);
        }
        return false;
    }
}
