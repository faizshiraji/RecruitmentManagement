package com.recruitmentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitmentmanagement.entities.Message;
import com.recruitmentmanagement.repo.MessageRepo;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	public MessageRepo messageRepo;
	
	@Override
	public List<Message> getMessages() {
		return messageRepo.findAll();
	}

	@Override
	public Message getMessage(int idMessage) {
		return messageRepo.findById(idMessage).get();
	}

	@Override
	public Message addMessage(Message message) {
		return messageRepo.save(message);
	}

	@Override
	public Message updateMessage(Message message) {
		return messageRepo.save(message);
	}

	@Override
	public void deleteMessage(int idMessage) {
		messageRepo.deleteById(idMessage);
	}

	@Override
	public long countMessage() {
		return messageRepo.count();
	}

}
