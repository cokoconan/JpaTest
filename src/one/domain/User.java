package one.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int idx;
	
	private String name;
	
	private int age;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [idx=" + idx + ", name=" + name + ", age=" + age + "]";
	}

	public User(int idx, String name, int age) {
		super();
		this.idx = idx;
		this.name = name;
		this.age = age;
	}

	public User() {
	}
	
	

}
