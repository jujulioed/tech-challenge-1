package br.com.jujulioed.my_users.entities;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private Long id;
    private String name;
    private String email;
    private String user;
    private String password;
    private LocalDate birthday;
    private LocalDate lastUpdate;

    public User(Long id, String name, String email, String user, String password, LocalDate birthday, LocalDate lastUpdate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.user = user;
        this.password = password;
        this.birthday = birthday;
        this.lastUpdate = lastUpdate;
    }

    public User() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return Objects.equals(id, user1.id) && Objects.equals(name, user1.name) && Objects.equals(email, user1.email) && Objects.equals(user, user1.user) && Objects.equals(password, user1.password) && Objects.equals(birthday, user1.birthday) && Objects.equals(lastUpdate, user1.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, user, password, birthday, lastUpdate);
    }

}
