package com.CentreCulturel.demo.message;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
Optional<Message> findByUserId(Integer id);
Optional<List<Message>> findAllByOrderByIdAsc(); 
Optional<List<Message>> findListMessageByUserId(Integer id);
Optional<List<Message>> findAllByOrderByIdDesc();
}
