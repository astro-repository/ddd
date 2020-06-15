package com.tutoriel.ddd.core.reunion.domaine.entite;

public class MeetingLocation {

    private String localisation;

    public MeetingLocation() {
    }

    public MeetingLocation(String localisation) {
        this.localisation = localisation;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

}
