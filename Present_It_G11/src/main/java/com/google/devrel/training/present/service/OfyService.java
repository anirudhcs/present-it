package com.google.devrel.training.present.service;

import java.util.concurrent.ConcurrentSkipListSet;

import com.google.devrel.training.present.domain.Conference;
import com.google.devrel.training.present.domain.Person;
import com.google.devrel.training.present.domain.Course;
import com.google.devrel.training.present.domain.Profile;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

/**
 * Custom Objectify Service that this application should use.
 */
@SuppressWarnings("unused")
public class OfyService {
    /**
     * This static block ensure the entity registration.
     */
    static {
        factory().register(Conference.class);
        factory().register(Profile.class);
        factory().register(Person.class);
        factory().register(Course.class);
    }

    /**
     * Use this static method for getting the Objectify service object in order to make sure the
     * above static block is executed before using Objectify.
     * @return Objectify service object.
     */
    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    /**
     * Use this static method for getting the Objectify service factory.
     * @return ObjectifyFactory.
     */
    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
