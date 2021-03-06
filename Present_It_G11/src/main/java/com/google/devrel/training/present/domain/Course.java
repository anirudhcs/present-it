package com.google.devrel.training.present.domain;

import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.ApiResourceProperty;
import com.google.devrel.training.present.form.CourseForm;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;


@Entity
public class Course{
	@Id
    private long id;
	private String courseId;
	private String courseName;
	private String description;
	
	@Index
	private int maxAttendees;
	
	@Parent
    @ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
    private Key<Person> personKey;
	
	@ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
    private String organizerEmail;
	
	private int seatsAvailable;
	
	@SuppressWarnings("unused")
	private Course() {}
	
	public Course(final long id, final String organizerEmail,
	                final CourseForm form){
		this.id = id;
		this.organizerEmail = organizerEmail;
		this.courseId = form.getCourseId();
		this.courseName = form.getCourseName();
		this.maxAttendees = form.getMaxAttendees();
		this.seatsAvailable = form.getMaxAttendees();
		this.description = form.getDescription();
		this.personKey = Key.create(Person.class, organizerEmail);
	}
	
	public long getId(){
		return id;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getCourseId(){
		return courseId;
	}
	
	public String getCourseName(){
		return courseName;
	}
	
	public int getMaxAttendees(){
		return maxAttendees;
	}
	
	public int getSeatsAvailable(){
		return seatsAvailable;
	}
	
	@ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
	public String getOrganizerEmail(){
		return organizerEmail;
	}
	
	@ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
    public Key<Person> getPersonKey() {
        return personKey;
    }
	
	// Get a String version of the key
    public String getWebsafeKey() {
        return Key.create(personKey, Course.class, id).getString();
    }
    
    public void registerForCourse(final int number) {
        if (seatsAvailable < number) {
            throw new IllegalArgumentException("There are no seats available.");
        }
        seatsAvailable = seatsAvailable - number;
    }
    
    public void deregisterFromCourse(final int number) {
        if (seatsAvailable + number > maxAttendees) {
            throw new IllegalArgumentException("The number of seats will exceeds the capacity.");
        }
        seatsAvailable = seatsAvailable + number;
    }
    
    /**
     * May need to modify this function to take into account
     * only the changed and no null parameters and not modify
     * everything always.
     * @param form
     */
    public void updateWithConferenceForm(CourseForm form){
    	this.courseId = form.getCourseId();
		this.courseName = form.getCourseName();
		this.maxAttendees = form.getMaxAttendees();
		this.seatsAvailable = form.getMaxAttendees();
    }
}


