package com.google.devrel.training.present.form;

public class CourseForm{
	private String courseId;
	private String courseName;
	private int maxAttendees;
	private String description;
	
	CourseForm(){
		courseId = "";
		courseName = "";
		maxAttendees = 0;
	}
	
	CourseForm(String courseId, String courseName, int maxAttendees){
		this.courseId = courseId;
		this.courseName = courseName;
		this.maxAttendees = maxAttendees;
	}
	
	public String getCourseId(){
		return courseId;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getCourseName(){
		return courseName;
	}
	
	public int getMaxAttendees(){
		return maxAttendees;
	} 
}