package com.netcrackerpractice.startup_social_network.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Business_roles")
public class BusinessRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "role_name")
    private String roleName;


    @OneToMany(mappedBy = "businessRole", cascade = CascadeType.ALL)
    private List<AccountResumeBusinessRole> accountResumeBusinessRoles;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<AccountResumeBusinessRole> getAccountResumeBusinessRoles() {
        return accountResumeBusinessRoles;
    }

    public void setAccountResumeBusinessRoles(List<AccountResumeBusinessRole> accountResumeBusinessRoles) {
        this.accountResumeBusinessRoles = accountResumeBusinessRoles;
    }
}
