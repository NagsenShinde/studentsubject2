package studentSubject.controller;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import studentSubject.entity.NotificationTableEntity;
import studentSubject.entity.StudentInfoEntity;
import studentSubject.repository.NotificationRepo;
import studentSubject.service.ConsumerService;
import studentSubject.service.NotificationService;

@RestController
public class NotificationController {
	
	@Autowired
	private NotificationRepo notificationRepo;
	
    @Autowired
	private NotificationService notificationService ;
	
	 @Autowired
	private ConsumerService ConsumerService;
	 
	 private NotificationTableEntity notificationTableEntity = new NotificationTableEntity();
   
	@GetMapping(value ="/send")
     public String MessageToSendKafkaTopic(@RequestParam("message") String message) {
		//NotificationService notificationService2 = new NotificationService();
		notificationService.sendMessage(message);
		notificationTableEntity.setMessage(message);
		notificationTableEntity.setOperation("Post");
		notificationTableEntity.setSentDate(notificationService.SentDate());
		notificationTableEntity.setSentTime(notificationService.SentTime());
		notificationTableEntity.setCreatedDate(ConsumerService.createdOn());
		notificationTableEntity.setCreatedTime(ConsumerService.createdTime());
		notificationRepo.save(notificationTableEntity);
		System.out.println(notificationTableEntity);
		return "Sucess";
 }
	
 
	@GetMapping(value ="/sends")
	public List<NotificationTableEntity> getAllNotisficationDetails( )
	{
		notificationTableEntity.setOperation("Get");
		return notificationRepo.findAll();
		
	}

	@GetMapping(value ="/sends/{notificationId}")
	public  NotificationTableEntity getById(@PathVariable int notificationId)
	{
		notificationTableEntity.setOperation("Get");
		return notificationRepo.findById(notificationId).orElse(null);
	}
	
	
	@PutMapping(value = "/put/{notificationId}")
	public String UpdateData(@PathVariable int notificationId,@RequestBody NotificationTableEntity notificationTableEntity)
	{
		NotificationTableEntity	notificationTableEntity1 = notificationRepo.findById(notificationId).orElse(null);
		System.out.println(notificationTableEntity1.toString());
		if(notificationTableEntity.getCreatedDate() != null)
		notificationTableEntity1.setCreatedDate(notificationTableEntity.getCreatedDate());
		if(notificationTableEntity.getCreatedTime() != null)
		notificationTableEntity1.setCreatedTime(notificationTableEntity.getCreatedTime());
		if(notificationTableEntity.getOperation() != null)
		notificationTableEntity1.setOperation(notificationTableEntity.getOperation());
		if(notificationTableEntity.getMessage() != null)
		notificationTableEntity1.setMessage(notificationTableEntity.getMessage());
		if(notificationTableEntity.getSentDate() != null)
		notificationTableEntity1.setSentDate(notificationTableEntity.getSentDate());
		if(notificationTableEntity.getSentTime() != null)
		notificationTableEntity1.setSentTime(notificationTableEntity.getSentTime());
		 notificationRepo.save(notificationTableEntity1);
		 return "Data sucessfully updated";
		
	} 
	
	
	
	@DeleteMapping(value = "/delete/{notificationId}")
	public String deleteById(@PathVariable int notificationId)
	{
		int a = notificationRepo.deleteByNotificationId(notificationId);
		return "Id Sucessfully Deleted";
		
	}
	
}
