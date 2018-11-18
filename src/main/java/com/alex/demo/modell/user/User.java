package com.alex.demo.modell.user;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Table(name = "USERS")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    Long id;

    @Column(name = "USER_NAME", nullable = false)
    String userName;

    @Column(name = "PASSWORD", nullable = false)
    String password;
}
