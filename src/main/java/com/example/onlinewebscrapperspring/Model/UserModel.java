package com.example.onlinewebscrapperspring.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="users_scrapper")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;


}
