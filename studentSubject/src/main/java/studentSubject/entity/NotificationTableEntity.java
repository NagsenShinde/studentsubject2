package studentSubject.entity;

 
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tablenotification")
public class NotificationTableEntity {
	
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  
	 @Column(name = "Notification_Id")
	  private int notificationId;
	   
	   @Column(name = "Operation") 
	   private String operation;
		
	   @Column(name="Message")
	   private String message;
	   
	    
	   
	    @Column(name = "Sent_Date")
	   private LocalDateTime sentDate;
	   
	   @Column(name = "Created_Date")
	   private LocalDateTime createdDate;
	 
	   @Column(name="Sent_Time")
	   private LocalTime SentTime;
	   
	   @Column(name="Created_Time")
	   private LocalTime createdTime;

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getSentDate() {
		return sentDate;
	}

	public void setSentDate(LocalDateTime sentDate) {
		this.sentDate = sentDate;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalTime getSentTime() {
		return SentTime;
	}

	public void setSentTime(LocalTime time) {
		SentTime = time;
	}

	public LocalTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalTime createdTime) {
		this.createdTime = createdTime;
	}

	 
	@Override
	public String toString() {
		return "NotificationTableEntity [notificationId=" + notificationId + ", operation=" + operation + ", message="
				+ message + ", sentDate=" + sentDate + ", createdDate="
				+ createdDate + ", SentTime=" + SentTime + ", createdTime=" + createdTime + "]";
	}

	 
	
 	
}
