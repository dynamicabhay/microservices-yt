package com.email.service.messageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.email.service.GemailService.GemailService;
import com.email.service.util.Message;
import com.google.gson.Gson;
import com.jwt3.Authorization.auth.Util.Kmessage;

@Service
public class KafkaListenerService {
	Logger LOG = LoggerFactory.getLogger(KafkaListenerService.class);
	
	@Autowired
	private GemailService gs;
	  
	  @KafkaListener(topics = "${spring.kafka.topic.name}",groupId="${spring.kafka.consumer.group-id}")
	  public void listener(Kmessage data) {
		  Gson gson = new Gson();
		  String jsonString = gson.toJson(data);
	    LOG.info(jsonString);
	    gs.sendMail(data.getEmail(), "abhaysinghjprk6@gmail.com", "user with name: "+data.getName()+" is created successfully");
	    
	  } 
}	
