package com.example.onlinewebscrapperspring.Model;

import com.example.onlinewebscrapperspring.Model.Roles.Roles;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "email", "username" }) })
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(unique=true, nullable=false, name = "username")
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(nullable=false, name = "firstname")
    private String firstName;
    @Column(nullable=false, name = "lastName")
    private String lastName;
    @Column(nullable=false, name = "email")
    private String email;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Roles> roles;
}
