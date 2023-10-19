package org.java.app.entity.service;

import org.java.app.entity.pojo.Message;
import org.java.app.entity.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepo messageRepo;
	
	public void addMessage(String text)  {
		Message mess = new Message(text);
		messageRepo.save(mess);
	}
}
