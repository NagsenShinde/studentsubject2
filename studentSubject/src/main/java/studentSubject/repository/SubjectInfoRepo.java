package studentSubject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.transaction.Transactional; 
import studentSubject.entity.SubjectInfoEntity;
public interface SubjectInfoRepo extends JpaRepository<SubjectInfoEntity,Integer>{
	
	@Transactional
	int deleteBySubjectId(int id);

	 

	 
	//SubjectInfoEntity findBysubjectId(int id);
	  
}
