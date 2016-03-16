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
    private String ufid;
    

    /**
     * Keys of the conferences that this user registers to attend.
     */
    private List<String> conferenceKeysToAttend = new ArrayList<>(0);

    /**
     * Public constructor for Profile.
     * @param userId The user id, obtained from the email
     * @param displayName Any string user wants us to display him/her on this system.
     * @param mainEmail User's main e-mail address.
     * @param teeShirtSize The User's tee shirt size
     *
     */
    public Person (String ufid, PersonalProfileForm form) {
        this.ufid = ufid;
        this.profile.updatePersonalProfile(form);
    }
    
    /**
     * Just making the default constructor private.
     */
    @SuppressWarnings("unused")
	private Person() {}

    public PersonalProfile getPersonalProfile(){
    	return profile;
    }

    public String getUfid() {
        return ufid;
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
     * From here the functios need to be modified based on the course class
     */
    /**
     * Getter for conferenceIdsToAttend.
     * @return an immutable copy of conferenceIdsToAttend.
     */
    public List<String> getConferenceKeysToAttend() {
        return ImmutableList.copyOf(conferenceKeysToAttend);
    }


    /**
     * Adds a ConferenceId to conferenceIdsToAttend.
     *
     * The method initConferenceIdsToAttend is not thread-safe, but we need a transaction for
     * calling this method after all, so it is not a practical issue.
     *
     * @param conferenceKey a websafe String representation of the Conference Key.
     */
    public void addToConferenceKeysToAttend(String conferenceKey) {
        conferenceKeysToAttend.add(conferenceKey);
    }

    /**
     * Remove the conferenceId from conferenceIdsToAttend.
     *
     * @param conferenceKey a websafe String representation of the Conference Key.
     */
    public void unregisterFromConference(String conferenceKey) {
        if (conferenceKeysToAttend.contains(conferenceKey)) {
            conferenceKeysToAttend.remove(conferenceKey);
        } else {
            throw new IllegalArgumentException("Invalid conferenceKey: " + conferenceKey);
        }
    }

}
