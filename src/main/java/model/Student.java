package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Map;

@Entity
@Table(name="T_STUDENT")
public class Student implements Serializable {

	private static final long serialVersionUID = -7476381137287496245L;
	@Id
	private int id; //学生记录id
	@Column(name="STU_NAME")
	private String stuName;//学生姓名
	@Column(name="AGE")
	private int age; //学生年龄
	@Column(name="GENDER")
	private int gender; //学生性别
	@Column(name="ADDRESS")
	private String address;//学生住址
	
	public Student() {
		super();
	}

	public Student(int id, String stuName, int age, int gender, String address) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	
	public Student(Map<String, Object> map){
		this.id = (Integer) map.get("id");
		this.stuName = (String)map.get("stu_name");
		this.age = (Integer) map.get("age");
		this.gender = (Integer) map.get("gender");
		this.address = (String)map.get("address");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", stuName=" + stuName + ", age=" + age
				+ ", gender=" + gender + ", address=" + address + "]";
	}
	
}
