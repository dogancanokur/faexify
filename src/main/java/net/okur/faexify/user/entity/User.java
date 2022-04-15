package net.okur.faexify.user.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private String password;
    private String displayName;

    @Override
    public String toString() {
        return "User => username=" + username + " password=" + password + " displayName=" + displayName;
    }
}
