package com.recruitmentmanagement.service;

import java.util.List;

import com.recruitmentmanagement.entities.Message;

public interface MessageService {

	public List<Message> getMessages();
	
	public Message getMessage(int idMessage);
	
	public Message addMessage(Message message);
	
	public Message updateMessage(Message message);
	
	public void deleteMessage(int idMessage);
	
	public long countMessage();
	
}
