package studentSubject.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.*;
public class ExceptionHandlers extends RuntimeException{

	 private String status;
     private String message;

//     public ExceptionHandlers(String status2, String message) {
//         this.status = status2;
//         this.message = message;
//     }


	public String getStatus() {
         return status;
     }

    public void setStatus(String status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
         return message;
    }
    
    
}
	 

