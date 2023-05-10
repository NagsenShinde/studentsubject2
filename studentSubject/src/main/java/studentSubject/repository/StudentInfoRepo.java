package studentSubject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import studentSubject.entity.StudentInfoEntity;

@Repository
public interface StudentInfoRepo extends JpaRepository<StudentInfoEntity,Integer> {

	List<StudentInfoEntity> findAll();
	
	 
	
	@Transactional
    int deleteByStudentId(int id);



	Optional<StudentInfoEntity> findByStudentName(String username);



	String save(String done);

	 

	 

	 

	 


 
	 

}
