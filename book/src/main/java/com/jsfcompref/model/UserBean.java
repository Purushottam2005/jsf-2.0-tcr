package com.jsfcompref.model;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
@SessionScoped
public class UserBean {

	protected Date dob;
	protected String email;
	protected String firstName;
	protected String lastName;
	protected String serviceLevel = "medium";
	protected String sex;

	public Date getDob() {
		return dob;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getServiceLevel() {
		return serviceLevel;
	}

	public String getSex() {
		return sex;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void validateEmail(FacesContext context, UIComponent toValidate,
			Object value) throws ValidatorException {
		String emailStr = (String) value;
		if (-1 == emailStr.indexOf("@")) {
			FacesMessage message = new FacesMessage("Invalid email address");
			throw new ValidatorException(message);
		}
	}

	public String addConfirmedUser() {
		boolean added = true; // actual application may fail to add user
		FacesMessage doneMessage = null;
		String outcome = null;
		if (added) {
			doneMessage = new FacesMessage("Sucessfully added new user");
			outcome = "done";
		} else {
			doneMessage = new FacesMessage("Failed to add new user");
			outcome = "register";
		}
		FacesContext.getCurrentInstance().addMessage(null, doneMessage);
		return outcome;
	}

}
