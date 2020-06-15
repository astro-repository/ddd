package com.tutoriel.ddd.infrastructure.mapper.reunion;

import com.tutoriel.ddd.core.reunion.domaine.entite.Membre;
import com.tutoriel.ddd.infrastructure.entite.RoleTable;
import com.tutoriel.ddd.infrastructure.entite.administrators.MeetingGroupProposalTable;
import com.tutoriel.ddd.infrastructure.entite.reunion.MeetingAttendeeTable;
import com.tutoriel.ddd.infrastructure.entite.reunion.MeetingNotAttendeeTable;
import com.tutoriel.ddd.infrastructure.entite.reunion.MeetingWaitlistMemberTable;
import com.tutoriel.ddd.infrastructure.entite.reunion.MembreTable;
import com.tutoriel.ddd.infrastructure.mapper.CompteMappeur;
import com.tutoriel.ddd.infrastructure.mapper.RoleMappeur;
import com.tutoriel.ddd.infrastructure.mapper.administration.MeetingGroupProposalMappeur;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MembreMappeur {

//    private final RoleMappeur roleMappeur;
//    private final CompteMappeur compteMappeur;
    private final MeetingGroupProposalMappeur meetingGroupProposalMappeur;
    private final MeetingWaitlistMemberMappeur meetingWaitlistMemberMappeur;
    private final MeetingAttendeeMappeur meetingAttendeeMappeur;
    private final MeetingNotAttendeeMappeur meetingNotAttendeeMappeur;

    public MembreMappeur(/*RoleMappeur roleMappeur, CompteMappeur compteMappeur, */MeetingGroupProposalMappeur meetingGroupProposalMappeur, MeetingWaitlistMemberMappeur meetingWaitlistMemberMappeur, MeetingAttendeeMappeur meetingAttendeeMappeur, MeetingNotAttendeeMappeur meetingNotAttendeeMappeur) {
//        this.roleMappeur = roleMappeur;
//        this.compteMappeur = compteMappeur;
        this.meetingGroupProposalMappeur = meetingGroupProposalMappeur;
        this.meetingWaitlistMemberMappeur = meetingWaitlistMemberMappeur;
        this.meetingAttendeeMappeur = meetingAttendeeMappeur;
        this.meetingNotAttendeeMappeur = meetingNotAttendeeMappeur;
    }

    public MembreTable membreVersTable(Membre membre) {

        MembreTable membreTable = new MembreTable();

        Set<MeetingAttendeeTable> meetingAttendeeTables = new HashSet<>();
        membre.getListAttendee().forEach(meetingWaitlistMember -> {
            meetingAttendeeTables.add(
                    meetingAttendeeMappeur.meetingAttendeeVersTable(meetingWaitlistMember)
            );
        });
        membreTable.setListAttendee(meetingAttendeeTables);

        Set<MeetingNotAttendeeTable> meetingNotAttendeeTables = new HashSet<>();
        membre.getListNotAttendee().forEach(meetingNotAttendee -> {
            meetingNotAttendeeTables.add(
                    meetingNotAttendeeMappeur.meetingNotAttendeeVersTable(meetingNotAttendee)
            );
        });
        membreTable.setListNotAttendee(meetingNotAttendeeTables);

        Set<MeetingWaitlistMemberTable> meetingWaitlistMemberTables = new HashSet<>();
        membre.getListWaiting().forEach(meetingWaitlistMember -> {
            meetingWaitlistMemberTables.add(
                    meetingWaitlistMemberMappeur.waitlistMappeurVersTable(meetingWaitlistMember)
            );
        });
        membreTable.setListWaiting(meetingWaitlistMemberTables);

        Set<MeetingGroupProposalTable> meetingGroupProposals = new HashSet<>();
        membre.getProposals().forEach(meetingGroupProposal -> {
            meetingGroupProposals.add(
                    meetingGroupProposalMappeur.meetingGroupProposalVersTable(meetingGroupProposal));
        });
        membreTable.setProposals(meetingGroupProposals);

//        membreTable.setCompteTable(compteMappeur.compteVersTable(membre.getCompte()));

//        Set<RoleTable> rolesTable = new HashSet<>();
//        membre.getRoles().forEach(role -> {
//            rolesTable.add(roleMappeur.roleVersTable(role));
//        });
//        membreTable.setRolesTable(rolesTable);

        membreTable.setAge(membre.getAge());
        membreTable.setNom(membre.getNom());
        membreTable.setPrenom(membre.getPrenom());

        return membreTable;

    }

}
