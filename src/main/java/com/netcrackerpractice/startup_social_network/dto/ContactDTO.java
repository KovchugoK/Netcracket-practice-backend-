package com.netcrackerpractice.startup_social_network.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactDTO {
    private UUID yourId;
    private UUID otherId;
}
