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
@Table(name="subjectinfo")
public class SubjectInfoEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Subject_Id")
	private int subjectId;
	
	@Column(name="Subject_Name")
	private String subjectName;

	 

	 

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	

//	public SubjectInfoEntity(int subjectId, String subjectName) {
//		super();
//		this.subjectId = subjectId;
//		this.subjectName = subjectName;
//	}



	@OneToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},targetEntity=StudentInfoEntity.class)
	@JoinColumn(name = "Subject_Id") 
	private List<StudentInfoEntity> studentInfoEntity;

	public List<StudentInfoEntity> getStudentInfoEntity() {
		return studentInfoEntity;
	}

	public void setStudentInfoEntity(List<StudentInfoEntity> studentInfoEntity) {
		if(this.studentInfoEntity == null)
		{
			this.studentInfoEntity= new ArrayList<>();
		}
		this.studentInfoEntity.addAll(studentInfoEntity);
	}
	
	
	
	
	
	 
	
}
