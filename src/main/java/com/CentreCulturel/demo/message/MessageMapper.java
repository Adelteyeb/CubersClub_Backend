package com.CentreCulturel.demo.message;

import org.springframework.stereotype.Service;
@Service
public class MessageMapper {
	public Message tomessage(MessageRequest msgReq) {
		return Message.builder()
				.id(msgReq.getId())
				.titre(msgReq.getTitre())
				.description(msgReq.getDescription())
				.dateCreation(msgReq.getDateCreation())
				.build();
	}
	public MessageResponse tomessageDto(Message msg) {
		return MessageResponse.builder()
				.id(msg.getId())
				.titre(msg.getTitre())
				.description(msg.getDescription())
				.dateCreation(msg.getDateCreation())
				.build();
	}
	
}
