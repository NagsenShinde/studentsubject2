package studentSubject.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;

import studentSubject.dto.AuthRequest;
import studentSubject.dto.ExceptionHandlers;
import studentSubject.entity.NotificationTableEntity;
import studentSubject.entity.StudentInfoEntity;
import studentSubject.entity.StudentInfoModelClass;
import studentSubject.jwtservice.JwtService;
import studentSubject.repository.NotificationRepo;
import studentSubject.repository.StudentInfoRepo;

@RestController
//@RequestMapping("/studenttable")
public class StudentInfoController {
	
	private static final Logger log = Logger.getLogger(StudentInfoController.class); 
	
	@Autowired
	private StudentInfoRepo studentInfoRepo;
	
	@Autowired
    private NotificationRepo notificationRepo;
	
	@Autowired
	private PasswordEncoder PasswordEncoder;
	
	@Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
 
    AuthRequest authRequest = new AuthRequest();
    
	@GetMapping("/studentAll")
	public ResponseEntity <List<StudentInfoEntity>>  studentInfoEntity()
	{  
		 
	    log.info(studentInfoRepo.findAll());
	    List<StudentInfoEntity> list= studentInfoRepo.findAll();
	     return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	 
	@GetMapping("/student/{studentId}")
	public StudentInfoEntity getById(@PathVariable int studentId)
	{
		try
		{
			log.info(studentInfoRepo.findById(studentId).orElse(null));
			return studentInfoRepo.findById(studentId).orElse(null);	
		}
		catch(Exception e)
		{
			log.error( "Invalid student Id");
		  return null;
		}
		   
	}
	
	 
	@PostMapping("/student")
	public String addStudent(@RequestBody StudentInfoEntity studentInfoEntity)
	{
		studentInfoEntity.setStudentPassword(PasswordEncoder.encode(studentInfoEntity.getStudentPassword()));
		log.info(studentInfoRepo.save(studentInfoEntity));
		studentInfoRepo.save(studentInfoEntity);
		return "Student sucessfully added";
		 	
	}
	@DeleteMapping("/student/{studentId}")
	 public String deleteById(@PathVariable int studentId)
	 {
	log.info(studentInfoRepo.deleteByStudentId(studentId));
	  int a = studentInfoRepo.deleteByStudentId(studentId);
		
	     if(a!= 0)
	    	  return "Student Sucessfully deleted";  
	      else
	    	  log.error("Not Exist");
		return "Not Exist";
			 
	 }
	
	
   @PutMapping("/student/{studentId}")
  public String updateStudentInfo(@PathVariable int studentId,@RequestBody StudentInfoModelClass studentInfoModelClass)
   {
    	try {
	 StudentInfoEntity studentInfoEntity1 = studentInfoRepo.findById(studentId).orElse(null);
	 System.out.println(studentInfoModelClass.toString());
	 
	 if(studentInfoModelClass.getStudentAddress() != null)
	 studentInfoEntity1.setStudent_Address(studentInfoModelClass.getStudentAddress());
	 if(studentInfoModelClass.getStudentContractNo() != 0)
	 studentInfoEntity1.setStudent_ContractNo(studentInfoModelClass.getStudentContractNo());
	 if(studentInfoModelClass.getStudentEmailId() != null)
	 studentInfoEntity1.setStudent_EmailId(studentInfoModelClass.getStudentEmailId());
	 if(studentInfoModelClass.getStudentName() != null)
	 studentInfoEntity1.setStudent_Name(studentInfoModelClass.getStudentName());
	 List<NotificationTableEntity> notificationTableEntity =  studentInfoModelClass.getNotificationTableEntity();
	 for(NotificationTableEntity notificationTableEntity1:notificationTableEntity)
	 {
		 System.out.println(notificationTableEntity1.toString());
		 int a=notificationTableEntity.indexOf(notificationTableEntity1); 
		 int id=notificationTableEntity1.getNotificationId(); 
		 NotificationTableEntity notificationTableEntity2 = notificationRepo.findById(id).orElse(null);
		 notificationTableEntity.set(a, notificationTableEntity2);
		 System.out.println(notificationTableEntity.toString()); 
	 }
	 System.out.println(notificationTableEntity.size());
	 studentInfoEntity1.setNotificationTableEntity(notificationTableEntity);
	 System.out.println(studentInfoEntity1.toString());
	 log.info(studentInfoRepo.save(studentInfoEntity1));
	 studentInfoRepo.save(studentInfoEntity1);
	 return "data sucessfully updated";
    	}
    	catch(Exception e)
    	{
    		log.error("Invalid student id or data");
    		return e+ "";
    	}
 }  
  
   @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
   public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
	   Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getStudentName(), authRequest.getStudentPassword()));
	   if(authentication.isAuthenticated())
	   {
         log.info(jwtService.generateToken(authRequest.getStudentName())); 
         return jwtService.generateToken(authRequest.getStudentName()) ;
	   }
	 
	return "";
	    
   }    
 
 

}
