package com.netcrackerpractice.startup_social_network.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.netcrackerpractice.startup_social_network.view.View;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {
    @JsonView(View.BasicInfo.class)
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @JsonView(View.BasicInfo.class)
    @Column(name = "first_name")
    private String firstName;

    @JsonView(View.BasicInfo.class)
    @Column(name = "last_name")
    private String lastName;

    @JsonView(View.BasicInfo.class)
    private Date birthday;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    @JsonIgnoreProperties(value = "account", allowSetters = true)
    private User user;

    @Column(name = "about_me")
    private String aboutMe;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "account", allowSetters = true)
    private List<Resume> resumes;

    public List<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(List<Resume> resumes) {
        this.resumes = resumes;
    }

    @OneToMany(mappedBy = "yourAccount", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "yourAccount", allowSetters = true)
    private List<Contact> yourContact;

    @OneToMany(mappedBy = "otherAccount", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "otherAccount", allowSetters = true)
    private List<Contact> otherContact;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "account", allowSetters = true)
    private List<Startup> startups;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "account", allowSetters = true)
    private List<StartupRole> startupRoles;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "account", allowSetters = true)
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "account", allowSetters = true)
    private Set<Education> educations;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "account", allowSetters = true)
    private List<WorkExperience> workExperiences;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
