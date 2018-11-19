package com.alex.demo.modell.user;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@ToString
@Table(name = "USERS")
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public final class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @NonNull
    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @NonNull
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @NonNull
    @Column(name = "EMAIL_ADDRESS", nullable = false, unique = true)
    private String emailAddess;


    public User(Builder builder) {
        this.userName = builder.userName;
        this.password = builder.password;
        this.emailAddess = builder.emailAddess;
    }

    public static final class Builder {

        private String userName;
        private String password;
        private String emailAddess;

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder emailAddess(String emailAddess) {
            this.emailAddess = emailAddess;
            return this;
        }

    }

}
