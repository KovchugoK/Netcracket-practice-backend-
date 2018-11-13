package com.netcrackerpractice.startup_social_network.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.netcrackerpractice.startup_social_network.payload.JwtAuthenticationResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.UUID;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator( name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String login;
    @Column(name = "hashed_password")
    private String hashedPassword;
    private String salt;
    @Email
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "id_user", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "id_role", referencedColumnName = "id"))
    @JsonIgnoreProperties(value = "users", allowSetters = true)
    private Collection<Role> roles;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = "user", allowSetters = true)
    private Account account;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private JwtAuthenticationResponse token;
}




