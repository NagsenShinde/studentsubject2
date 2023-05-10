package studentSubject.entity;

import java.util.List;

public class SubjectInfoModelClass {
	
	private String subjectName;
	
	private List<StudentInfoEntity> studentinfoEntity;

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public List<StudentInfoEntity> getStudentinfoEntity() {
		return studentinfoEntity;
	}

	public void setStudentinfoEntity(List<StudentInfoEntity> studentinfoEntity) {
		this.studentinfoEntity = studentinfoEntity;
	}

	@Override
	public String toString() {
		return "SubjectInfoModelClass [subjectName=" + subjectName + ", studentinfoEntity=" + studentinfoEntity + "]";
	}

	 
	

}
