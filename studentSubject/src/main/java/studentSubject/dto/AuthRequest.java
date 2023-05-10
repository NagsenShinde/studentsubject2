package studentSubject.dto;


public class AuthRequest {
	
	private String studentName ;
    private String studentPassword;
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	@Override
	public String toString() {
		return "AuthRequest [studentName=" + studentName + ", studentPassword=" + studentPassword + "]";
	}
	 
    
    
	
    

}
