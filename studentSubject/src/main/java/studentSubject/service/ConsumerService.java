package studentSubject.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import studentSubject.entity.NotificationTableEntity;
import studentSubject.util.TopicName;

@Service
public class ConsumerService {
	
	NotificationTableEntity notificationTableEntity = new NotificationTableEntity();
	
	public static final Logger LOGGER=LoggerFactory.getLogger(ConsumerService.class);
	
	@KafkaListener(topics = TopicName.topicName,groupId = TopicName.groupId)
	public void consumeMessage(String message)
	{
		LOGGER.info(String.format("Message Recieve---> %s",message));
		
	}
	
	public LocalDateTime createdOn()
	{ 
		LOGGER.info(String.format("message receive date %s",LocalDateTime.now()));  
		return java.time.LocalDateTime.now();
		
	}
	
	public LocalTime createdTime()
	{ 
		LOGGER.info(String.format("message receive time %s",java.time.LocalTime.now()));  
		return java.time.LocalTime.now();
		
	}
	
	
	
	
}
