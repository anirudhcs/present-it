package com.google.devrel.training.present.domain;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.devrel.training.present.form.PersonalProfileForm;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class Person {
    private PersonalProfile profile;
    @Id 
    private String mainEmail;
    

    /**
     * Keys of the courses that this user registers to attend.
     */
    private List<String> courseKeysToAttend = new ArrayList<>(0);

    /**
     * Public constructor for Profile.
     * @param userId The user id, obtained from the email
     * @param displayName Any string user wants us to display him/her on this system.
     * @param mainEmail User's main e-mail address.
     * @param teeShirtSize The User's tee shirt size
     *
     */
    public Person (String mainEmail, PersonalProfileForm form) {
        this.mainEmail = mainEmail;
        this.profile.updatePersonalProfile(form);
    }
    
    public Person(String mainEmail){
    	this.mainEmail = mainEmail;
    }
    
    /**
     * Just making the default constructor private.
     */
    @SuppressWarnings("unused")
	private Person() {}

    public PersonalProfile getPersonalProfile(){
    	return profile;
    }

    public String getEmail() {
        return mainEmail;
    }
    
    /**
     * Update the Profile with the given displayName and teeShirtSize
     *
     * @param displayName
     * @param teeShirtSize
     */
    public void update(PersonalProfileForm form) {
        this.profile.updatePersonalProfile(form);
    }

    
    /**
     * From here the functions need to be modified based on the course class
     */
    /**
     * Getter for courseIdsToAttend.
     * @return an immutable copy of courseIdsToAttend.
     */
    public List<String> getCourseKeysToAttend() {
        return ImmutableList.copyOf(courseKeysToAttend);
    }


    /**
     * Adds a CoursId to courseIdsToAttend.
     *
     * The method initCourseIdsToAttend is not thread-safe, but we need a transaction for
     * calling this method after all, so it is not a practical issue.
     *
     * @param courseKey a websafe String representation of the Course Key.
     */
    public void addToCourseKeysToAttend(String courseKey) {
    	courseKeysToAttend.add(courseKey);
    }

    /**
     * Remove the courseId from courseIdsToAttend.
     *
     * @param courseKey a websafe String representation of the Course Key.
     */
    public void unregisterFromCourse(String courseKey) {
        if (courseKeysToAttend.contains(courseKey)) {
        	courseKeysToAttend.remove(courseKey);
        } else {
            throw new IllegalArgumentException("Invalid courseKey: " + courseKey);
        }
    }

}
