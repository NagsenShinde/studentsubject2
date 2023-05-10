package studentSubject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import studentSubject.entity.StudentInfoEntity;
import studentSubject.entity.SubjectInfoEntity;
import studentSubject.entity.SubjectInfoModelClass;
import studentSubject.repository.StudentInfoRepo;
import studentSubject.repository.SubjectInfoRepo;

@RestController
public class SubjectInfoController {
	
	@Autowired
	 private SubjectInfoRepo subjectInfoRepo;
	
	@Autowired
	private  StudentInfoRepo studentInfoRepo;
	 
	
	@GetMapping("/subject")
	public List<SubjectInfoEntity> getsubjectInfoEntity()
	{
		return subjectInfoRepo.findAll();
		
	}
	
	
	
	public SubjectInfoController(SubjectInfoRepo subjectInfoRepo) {
		super();
		this.subjectInfoRepo = subjectInfoRepo;
	}



	@GetMapping("/subject/{subjectId}")
	public SubjectInfoEntity getById(@PathVariable int subjectId)
	{
		
		List<SubjectInfoEntity> subjectInfoEntity = subjectInfoRepo.findAll();
		SubjectInfoEntity subjectInfoEntity1 = null;
		for(SubjectInfoEntity sub:subjectInfoEntity)
		{
			if(sub.getSubjectId() == subjectId)
			{
				subjectInfoEntity1=sub;
			}
		}
		return subjectInfoEntity1;
//		try
//		{
//		return subjectInfoRepo.findById(subjectId).orElse(null);
//		}
//		catch(Exception e)
//		{
//			return null;
//		}
	}
	
	@PostMapping("/subject")
	public String addSubject(@RequestBody SubjectInfoEntity subjectInfoEntity)
	{
	 subjectInfoRepo.save(subjectInfoEntity);
	 return "Subject sucessfully added";
		
	}
	
	@DeleteMapping("/subject/{subjectId}")
	public String deleteById(@PathVariable int subjectId)
	{
		SubjectInfoEntity subject = subjectInfoRepo.findById(subjectId).orElse(null);
		if(subject != null) {
			subjectInfoRepo.deleteById(subjectId);
			return "Successfully Deleted";
		}
		return"Not Exist";
		 	
	}
	
	@PutMapping("/subject/{subjectId}")
	public String updateById(@PathVariable int subjectId,@RequestBody SubjectInfoModelClass subjectInfoModelClass)
	{
		try {
		SubjectInfoEntity subjectInfoEntity = subjectInfoRepo.findById(subjectId).orElse(null);
		System.out.println(subjectInfoModelClass.toString());
	 
		if(subjectInfoModelClass.getSubjectName()!= null)
		subjectInfoEntity.setSubjectName(subjectInfoModelClass.getSubjectName());
		List<StudentInfoEntity> studentInfoEntity = subjectInfoModelClass.getStudentinfoEntity();
		for(StudentInfoEntity studentInfoEntity1:studentInfoEntity)
	      {
			System.out.println(studentInfoEntity.toString());
		    int a=studentInfoEntity.indexOf(studentInfoEntity1);
			int studentId = studentInfoEntity1.getStudentId();
			StudentInfoEntity studentInfoEntity2=studentInfoRepo.findById(studentId).orElse(null);
			studentInfoEntity.set(a,studentInfoEntity2);
		  }
		System.out.println(subjectInfoEntity.toString());
		subjectInfoEntity.setStudentInfoEntity(studentInfoEntity);
		subjectInfoRepo.save(subjectInfoEntity);
		return "Sucessfully updated";
		}
		catch(Exception e)
		{
		return e+ "";
	 
		}
	}

}
