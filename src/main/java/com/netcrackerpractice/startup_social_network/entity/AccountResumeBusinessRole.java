package com.netcrackerpractice.startup_social_network.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Accounts_Resume_Business_role")
public class AccountResumeBusinessRole {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator( name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_resume")
    @JsonIgnoreProperties(value = "accountResumeBusinessRoles", allowSetters = true)
    private Resume resume;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_business_role")
    @JsonIgnoreProperties(value = "accountResumeBusinessRoles", allowSetters = true)
    private BusinessRole businessRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_account")
    @JsonIgnoreProperties(value = "accountResumeBusinessRoles", allowSetters = true)
    private Account account;
}