package com.CentreCulturel.demo.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.CentreCulturel.demo.membre.Membre;
import com.CentreCulturel.demo.membre.MembreResponse;
import com.CentreCulturel.demo.message.Message;
import com.CentreCulturel.demo.message.MessageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserMapper usermapper;
	private final UserRepository repo;
	private final MessageRepository messagerepo;
	@Override
	public UserResponse loadUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return repo.findByEmailAndPassword(email, password)
				.map(usermapper::touserDTO).orElse(new UserResponse());
	}
	@Override
	public UserResponse findById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).map(usermapper::touserDTO).orElse(new UserResponse());
	}
	@Override
	public UserResponse findUserByMessagesId(Integer id) {
		// TODO Auto-generated method stub
		/* List<User> users = repo.findByMessagesId(id).orElse(Collections.EMPTY_LIST);
		 List<UserResponse> usersResponses = new ArrayList<>();
		 users.forEach(user->{ usersResponses.add(usermapper.touserDTO(user));});*/
		return repo.findByMessagesId(id).map(usermapper::touserDTO).orElse(new UserResponse());
	}
	@Override
	public void deleteUser(Integer id) {
		User user=repo.findById(id).orElse(new User());
		List<Message> messages =user.getMessages();
		if (messages != null && !messages.isEmpty()) {
	        for (Message message : messages) {
	            // Suppression de chaque message de la base de données.
	        	messagerepo.deleteById(message.getId());;
	        }
	        messages.clear(); // Supprime les messages de la collection en mémoire.
	    }
		this.repo.deleteById(id);
		//repo.save(utilisateur);
		// TODO Auto-generated method stub
		
	}
}
