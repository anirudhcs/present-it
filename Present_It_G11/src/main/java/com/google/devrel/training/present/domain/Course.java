package com.google.devrel.training.present.domain;

import static com.google.devrel.training.present.service.OfyService.ofy;

import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.ApiResourceProperty;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;


@Entity
public class Course{
	@Id 
	private String courseId;
	private String courseName;
	
	@Index
	private int maxAttendees;
	
	@Parent
    @ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
    private Key<Person> personKey;
	
	@ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
    private String organizerUfid;
	
	private int seatsAvailable;
	
	private Course() {}
	
}


