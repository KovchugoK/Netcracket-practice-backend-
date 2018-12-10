package com.netcrackerpractice.startup_social_network.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConversationDTO {
    private UUID conversationId;
    private UUID yourId;
    private UUID otherId;
    private String name;
}
