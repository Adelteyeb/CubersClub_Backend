package com.CentreCulturel.demo.message;

import java.util.List;

import com.CentreCulturel.demo.membre.MembreResponse;

public interface MessageService {
	 Integer saveMessage(MessageRequest msgReq,Integer user_id);
	 MessageResponse findByID(Integer id);
	 List<MessageResponse> findAll();
	 void deleteMessage(Integer id);
	 List<MessageResponse> MessageByIdUser(Integer id);
}
