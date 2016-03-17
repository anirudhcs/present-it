package com.google.devrel.training.present.form;

import com.google.devrel.training.present.domain.Course;

public class CourseForm{
	private String courseId;
	private String courseName;
	private int maxAttendees;
	
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
	
	public String getCourseName(){
		return courseName;
	}
	
	public int getMaxAttendees(){
		return maxAttendees;
	} 
}