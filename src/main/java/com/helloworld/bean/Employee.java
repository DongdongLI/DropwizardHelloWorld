package com.helloworld.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="employees")
@NamedQueries({
	@NamedQuery(name="com.helloworld.bean.Employee.findAll", 
			query = "select e from Employee e"),
	@NamedQuery(name="com.helloworld.bean.Employee.findByName", 
		query = "select e from Employee e "
				+ "where e.firstName like :name "
				+ "or e.lastName like :name")

})


public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="e_position")
	private String position;
	@Column(name="phone")// can be skipped since the name is the same?
	private String phone;
	@Column(name="e_mail")
	private String e_mail;
	
	public Employee(){}

	public Employee(String firstName, String lastName, String position, String phone, String e_mail) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.phone = phone;
		this.e_mail = e_mail;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	
	
	
}
