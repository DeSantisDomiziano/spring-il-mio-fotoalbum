package org.java.app.api;

import org.java.app.entity.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/message")
public class MessageRestController {
	
	@Autowired
	private MessageService messageService;
	
	@PostMapping("/send")
	public void addMessage(@RequestBody String text) {

		messageService.addMessage(text);
	}
}
