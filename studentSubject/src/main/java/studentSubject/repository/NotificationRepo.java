package studentSubject.repository;
 
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import studentSubject.entity.NotificationTableEntity;
import studentSubject.service.NotificationService;
 
@Repository
public interface NotificationRepo extends JpaRepository<NotificationTableEntity,Integer> {

	List<NotificationTableEntity> save(NotificationService notificationTableEntity);

	@Transactional
	int deleteByNotificationId(int notificationId);
 

	 

}
