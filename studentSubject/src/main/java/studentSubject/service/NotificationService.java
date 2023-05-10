package studentSubject.service;

 
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import studentSubject.util.TopicName;

@Service
public class NotificationService {
	
	public static final Logger LOGGER=LoggerFactory.getLogger(NotificationService.class);
	
	 @Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	 
	public void KafkaTemplate(KafkaTemplate<String,String> kafkaTemplate) {
		this.kafkaTemplate=kafkaTemplate;
	}
       public void sendMessage(String message)
		{
    	   BasicConfigurator.configure();  
    	   LOGGER.info(String.format("Message Send---> %s",message));
			kafkaTemplate.send(TopicName.topicName, message);
			 
		}
	
	public LocalDateTime SentDate()
	{ 
		LOGGER.info(String.format("sent message date----> %s",java.time.LocalDateTime.now()));  
		return java.time.LocalDateTime.now();
	}
	
	public LocalTime SentTime()
	{ 
		LOGGER.info(String.format("sent message time----> %s",java.time.LocalTime.now()));  
		return java.time.LocalTime.now();
	}
	
    
	

}
