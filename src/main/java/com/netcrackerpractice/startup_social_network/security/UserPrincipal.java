package com.netcrackerpractice.startup_social_network.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netcrackerpractice.startup_social_network.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {
    private UUID id;
    private String username;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String password;
    private boolean nonBlock;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(UUID id, String username, String email, String password,
                         Collection<? extends GrantedAuthority> authorities, boolean nonBlock) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.nonBlock = nonBlock;

    }

    public static UserPrincipal create(User user) {

//        List<GrantedAuthority> authorities  = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName().name()))   ;
//        // new ArrayList<GrantedAuthority>().add(new SimpleGrantedAuthority(user.getRole().getRoleName().name()));

        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getRoleName().name())
        ).collect(Collectors.toList());

        return new UserPrincipal(
                user.getId(),
                user.getLogin(),
                user.getEmail(),
                user.getHashedPassword(),
                authorities,
                user.getNonBlock()
        );
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return nonBlock;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
