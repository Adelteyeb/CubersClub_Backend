package com.CentreCulturel.demo.message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.CentreCulturel.demo.departement.Departement;
import com.CentreCulturel.demo.departement.DepartementRepository;
import com.CentreCulturel.demo.membre.MembreRepository;
import com.CentreCulturel.demo.membre.Membre;
import com.CentreCulturel.demo.membre.MembreRequest;
import com.CentreCulturel.demo.membre.MembreResponse;
import com.CentreCulturel.demo.membre.MembreMapper;
import com.CentreCulturel.demo.user.User;
import com.CentreCulturel.demo.user.UserRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {
	private final MessageRepository repo;
	private final UserRepository userrepo ;
	private final MessageMapper mapper;
	
	@Override
	public Integer saveMessage(MessageRequest msgReq,Integer user_id) {
		
	
		User user = userrepo.findById(user_id).orElse(new User());
		Message message=mapper.tomessage(msgReq);
		user.getMessages().add(message);
		message.setUser(user);
		userrepo.save(user);
		//repo.save(message);
		return message.getId();
	}

	@Override
	public MessageResponse findByID(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).map(mapper::tomessageDto).orElse(new MessageResponse());
	}

	@Override
	public List<MessageResponse> findAll() {
		// TODO Auto-generated method stub
		 List<Message> messages = repo.findAllByOrderByIdAsc().orElse(Collections.EMPTY_LIST);
		 List<MessageResponse> messagesResponses = new ArrayList<>();
		 messages.forEach(message->{ messagesResponses.add(mapper.tomessageDto(message));});
	  return messagesResponses;
	}

	@Override
	public void deleteMessage(Integer id) {
		this.repo.deleteById(id);
		
	}

	@Override
	public List<MessageResponse> MessageByIdUser(Integer id) {
		// TODO Auto-generated method stub
		 List<Message> listmessages = repo.findListMessageByUserId(id).orElse(Collections.EMPTY_LIST);
		 List<MessageResponse> messages = new ArrayList<>();
		 listmessages.forEach(message->{ messages.add(mapper.tomessageDto(message));});
		return null;
	}
}
