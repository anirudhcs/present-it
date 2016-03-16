package com.google.devrel.training.present.domain;

import com.google.devrel.training.present.form.PersonalProfileForm;

public class PersonalProfile{
	
	/**
	 * This class contains all the personal profile information
	 * Any data parameter that corresponds to the personal information of the person 
	 * should be put in this calss and the form should also be correspondingly updated
	 */
	private String firstName;
	private String lastName;
	private String mainEmail;
	
	/**
	 * the empty constructor
	 */
	PersonalProfile(){
		firstName = "";
		lastName = "";
		mainEmail = "";
	}
	
	/**
	 * 
	 * @param form
	 */
	PersonalProfile(PersonalProfileForm form){
		this.firstName = form.getFirstName();
		this.lastName = form.getLastName();
		this.mainEmail = form.getEmail();
	}
	
	
	/**
	 * 
	 * @return firstName
	 */
	public String getFirstName(){
		return firstName;
	}
	
	
	/**
	 * 
	 * @return lastName
	 */
	public String getLastName(){
		return lastName;
	}

	
	/**
	 * The getter function for the email
	 * @return email
	 */
	public String getEmail(){
		return mainEmail;
	}
	
	
	/**
	 * Updates the firstName and the lastName.
	 * Need to add checks if they are null so that one at a time can also be updated.
	 * @param form
	 */
	public void updatePersonalProfile(PersonalProfileForm form){
		this.firstName = form.getFirstName();
		this.lastName = form.getLastName();
		this.mainEmail = form.getEmail();
	}
	
}