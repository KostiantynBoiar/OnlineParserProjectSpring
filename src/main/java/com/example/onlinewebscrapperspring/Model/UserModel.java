package com.example.onlinewebscrapperspring.Model;

import jakarta.persistence.*;
import lombok.*;

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


}
