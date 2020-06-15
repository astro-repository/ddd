package com.tutoriel.ddd.infrastructure.objetvaleur.reunion;

import com.tutoriel.ddd.core.reunion.domaine.entite.MeetingLocation;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MeetingLocationTable {

    @Column
    private String localisation;

    public MeetingLocationTable() {
    }

    public MeetingLocationTable(MeetingLocation meeting) {
        this.localisation = meeting.getLocalisation();
    }

    public MeetingLocationTable(String localisation) {
        this.localisation = localisation;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

}
