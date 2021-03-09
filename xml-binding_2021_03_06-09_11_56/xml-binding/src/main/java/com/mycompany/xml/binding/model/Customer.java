package com.mycompany.xml.binding.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.lang.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

	@XmlElement
	private String name;

	@XmlElement
	private String email;

	@XmlElement
	private Integer age;

	@XmlAttribute
	private Integer customerId;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer{" + "name=" + name + ", email=" + email + ", age=" + age + ", customerId=" + customerId + '}';
	}
}
