package studentSubject.entity;

import java.util.List;

public class StudentInfoModelClass {
	
	 
	private String studentName;
	
	 
	private String studentAddress;
	
	 
	private long studentContractNo;
	
	
	private int studentId; 
	
	
	private String studentRole;
	
	
	private String studentEmailId;
	
	
	private String studentPassword;
	
	
	private List<NotificationTableEntity> notificationTableEntity;
	

	public String getStudentRole() {
		return studentRole;
	}

	public void setStudentRole(String studentRole) {
		this.studentRole = studentRole;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public long getStudentContractNo() {
		return studentContractNo;
	}

	public void setStudentContractNo(long studentContractNo) {
		this.studentContractNo = studentContractNo;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentEmailId() {
		return studentEmailId;
	}

	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}

	public List<NotificationTableEntity> getNotificationTableEntity() {
		return notificationTableEntity;
	}

	public void setNotificationTableEntity(List<NotificationTableEntity> notificationTableEntity) {
		this.notificationTableEntity = notificationTableEntity;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	@Override
	public String toString() {
		return "StudentInfoModelClass [studentName=" + studentName + ", studentAddress=" + studentAddress
				+ ", studentContractNo=" + studentContractNo + ", studentId=" + studentId + ", studentRole="
				+ studentRole + ", studentEmailId=" + studentEmailId + ", studentPassword=" + studentPassword
				+ ", notificationTableEntity=" + notificationTableEntity + "]";
	}

	 
	
	
	

}
