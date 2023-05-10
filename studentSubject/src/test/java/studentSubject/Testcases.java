package studentSubject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;

import studentSubject.controller.SubjectInfoController;
import studentSubject.entity.SubjectInfoEntity;
import studentSubject.repository.SubjectInfoRepo;

@SpringBootTest(classes = {Testcases.class})
public class Testcases {

	@Mock
	SubjectInfoRepo subjectInfoRepo;
	
	@InjectMocks
	SubjectInfoController subjectInfoController;
	
	
	SubjectInfoEntity subjectInfoEntity = new SubjectInfoEntity();
	
	public List<SubjectInfoEntity> subjectInfoEntity1;
	@Test
	public void getAllSubject()
	{
		subjectInfoEntity.setSubjectId(1012);
		subjectInfoEntity.setSubjectName("hindi");
		List<SubjectInfoEntity> subjectInfoEntity1 = new ArrayList<>();
		subjectInfoEntity1.add(subjectInfoEntity);
		 when(subjectInfoRepo.findAll()).thenReturn(subjectInfoEntity1);
		assertThat(subjectInfoEntity1).isEqualTo(subjectInfoController.getsubjectInfoEntity());
	}
	 
	@Test
	//@Disabled
	public void findById()
	{
		subjectInfoEntity.setSubjectId(1012);
		subjectInfoEntity.setSubjectName("hindi");
		 List<SubjectInfoEntity> subjectInfoEntity2 = new ArrayList<>();
		 subjectInfoEntity2.add(subjectInfoEntity);
		 int id=subjectInfoEntity.getSubjectId();
		 when(subjectInfoRepo.findAll()).thenReturn(subjectInfoEntity2);
		 assertThat(id).isEqualTo(subjectInfoController.getById(id).getSubjectId());
	}
    
	 @Test
	 @AfterEach
	 public void deleteSubject()
	 {
		    subjectInfoEntity.setSubjectId(1012);
			subjectInfoEntity.setSubjectName("hindi");
		
			 int id=subjectInfoEntity.getSubjectId();
			 
	        when(subjectInfoRepo.findById(id)).thenReturn(Optional.ofNullable(subjectInfoEntity));
			  
			 String s=subjectInfoController.deleteById(id);
			// System.out.println(s);
			 assertThat("Successfully Deleted").isEqualTo(s);
			
		
	 }
 
	@Test
	@BeforeEach
	 public void addSubject()
	 {
		 subjectInfoEntity.setSubjectName("Hindi");
		 List<SubjectInfoEntity> subjectInfoEntity2 = new ArrayList<>();
		 subjectInfoEntity2.add(subjectInfoEntity);
		 //when(subjectInfoRepo.save(subjectInfoEntity2)).thenReturn("Subject sucessfully added"); 
		 assertThat("Subject sucessfully added").isEqualTo(subjectInfoController.addSubject(subjectInfoEntity));
		    
	 }
}

