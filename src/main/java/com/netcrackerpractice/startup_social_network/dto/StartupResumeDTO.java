package com.netcrackerpractice.startup_social_network.dto;

import lombok.*;

import java.util.UUID;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StartupResumeDTO {
    private UUID id;
    private String status;
    private ResumeDTO resume;
}
