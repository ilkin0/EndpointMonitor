package com.ilkinmehdiyev.msmonitor.model.user;

import lombok.*;

import javax.persistence.*;

import java.util.UUID;

import static com.ilkinmehdiyev.msmonitor.model.user.User.TABLE_NAME;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = TABLE_NAME)
public class User {

    public static final String TABLE_NAME = "user";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;

    private String email;

    private UUID accessToken;
}