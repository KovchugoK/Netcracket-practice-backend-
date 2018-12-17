package com.netcrackerpractice.startup_social_network.mapper;

import com.netcrackerpractice.startup_social_network.dto.ConversationDTO;
import com.netcrackerpractice.startup_social_network.entity.Conversation;
import com.netcrackerpractice.startup_social_network.exception.AccountNotFoundException;
import com.netcrackerpractice.startup_social_network.service.AccountService;
import com.netcrackerpractice.startup_social_network.service.MessageService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ConversationMapper {
    @Autowired
    private AccountService accountService;
    @Autowired
    private MessageService messageService;

    public ConversationDTO conversationToConversationDTO(Conversation conversation) {
        return ConversationDTO.builder()
                .conversationId(conversation.getId())
                .yourId(conversation.getFirstAccount().getId())
                .otherId(conversation.getSecondAccount().getId())
                .name(conversation.getName())
                .build();
    }

    public Conversation conversationDTOtoConversation(ConversationDTO conversationDTO) {
        return Conversation.builder()
                .id(conversationDTO.getConversationId())
                .firstAccount(accountService.findAccountById(conversationDTO.getYourId()).orElseThrow(
                        () -> new AccountNotFoundException("Account with UUID" + conversationDTO.getYourId() + "not found")))
                .secondAccount(accountService.findAccountById(conversationDTO.getOtherId()).orElseThrow(
                        () -> new AccountNotFoundException("Account with UUID" + conversationDTO.getOtherId() + "not found")))
                .name(conversationDTO.getName())
                .messages(messageService.getConversationMessagesById(conversationDTO.getConversationId()))
                .build();
    }

    public abstract List<ConversationDTO> conversationDTOtoConversation(Collection<Conversation> conversations);
}
