package com.tutoriel.ddd.infrastructure.entite.administrators;

import com.tutoriel.ddd.infrastructure.entite.UtilisateurTable;
import com.tutoriel.ddd.infrastructure.objetvaleur.administrateur.MeetingGroupProposalDecisionTable;
import com.tutoriel.ddd.infrastructure.objetvaleur.administrateur.MeetingGroupProposalStatusTable;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class AdministrateurTable extends UtilisateurTable {

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<MeetingGroupProposalTable> meetingGroupProposalTables = new HashSet<MeetingGroupProposalTable>();

    public AdministrateurTable() {
    }

    public AdministrateurTable(String firstName, String lastName, int number) {
        super(firstName, lastName, number);
    }

    public Set<MeetingGroupProposalTable> getMeetingGroupProposalTables() {
        return meetingGroupProposalTables;
    }

    public void setMeetingGroupProposalTables(Set<MeetingGroupProposalTable> meetingGroupProposalTables) {
        this.meetingGroupProposalTables = meetingGroupProposalTables;
    }
}
