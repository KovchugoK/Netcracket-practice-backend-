package com.netcrackerpractice.startup_social_network.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Startups")
public class Startup {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator( name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "startup_name")
    private String startupName;

    private String idea;

    @Column(name = "about_project")
    private String aboutProject;

    @Column(name = "business_plan")
    private String businessPlan;

    @Column(name = "sum_of_investment")
    private int sumOfInvestment;

    @Column(name = "date_of_creation")
    private Date dateOfCreation;

    @Column(name = "id_image")
    private String imageId;

    @Column(name = "id_compressed_image")
    private String compressedImageId;

    @Column(name = "non_block")
    private boolean nonBlock = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_creator")
    @JsonIgnoreProperties(value = {"startupInvestments", "birthday", "aboutMe",
              "resumes", "yourContact", "otherContact", "yourConversations",
            "otherConversations", "startups", "favorites", "educations", "workExperiences", "balance"}, allowSetters = true)
    private Account account;

    @OneToMany(mappedBy = "startup", orphanRemoval= true, cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "startup", allowSetters = true)
    private Set<StartupResume> startupResumes;

    @OneToMany(mappedBy = "startup", orphanRemoval= true, cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"startup","account"} , allowSetters = true)
    private Set<StartupRole> startupRoles;

    @OneToMany(mappedBy = "startup", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "startup", allowSetters = true)
    private Set<Investment> startupInvestments;

}
