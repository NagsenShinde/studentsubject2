package studentSubject.entity;
 
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
@Table(name="studentinfo")
public class StudentInfoEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Student_id")
	private int studentId;
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
//	 @Column(name = "Student_Role")
//	 private String studentRole;
//
//	public String getStudentRole() {
//		return studentRole;
//	}
//
//	public void setStudentRole(String studentRole) {
//		this.studentRole = studentRole;
//	}
//	
	@Column(name = "Student_Password")
	   private String studentPassword;

	@Column(name = "Student_Name")
	private String studentName;
	
	@Column(name="Student_Address")
	private String studentAddress;
	
	@Column(name = "Student_Contractno")
	private long studentContractNo;
	
	@Column(name = "Student_Emailid")
	private String studentEmailId;
	 

	public String getStudentName() {
		return studentName;
	}

	public void setStudent_Name(String studentName) {
		this.studentName = studentName;
	}

	public String getStudent_Address() {
		return studentAddress;
	}

	public void setStudent_Address(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public long getStudent_ContractNo() {
		return studentContractNo;
	}

	public void setStudent_ContractNo(long studentContractNo) {
		this.studentContractNo = studentContractNo;
	}

	public String getStudent_EmailId() {
		return studentEmailId;
	}

	public void setStudent_EmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}
	
 
	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},targetEntity = NotificationTableEntity.class)
	@JoinColumn(name = "Student_Id") 
	private List<NotificationTableEntity> notificationTableEntity;

	public List<NotificationTableEntity> getNotificationTableEntity() {
		return notificationTableEntity;
	}

	public void setNotificationTableEntity(List<NotificationTableEntity> notificationTableEntity) {
		if(this.notificationTableEntity == null)
		{
			this.notificationTableEntity = new ArrayList<>();
		}
		this.notificationTableEntity.addAll(notificationTableEntity);
		 
 
	}

	@Override
	public String toString() {
		return "StudentInfoEntity [studentId=" + studentId + ", studentRole=" +  ", studentPassword="
				+ studentPassword + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ ", studentContractNo=" + studentContractNo + ", studentEmailId=" + studentEmailId
				+ ", notificationTableEntity=" + notificationTableEntity + "]";
	}
	

	 
 
}
