package com.tutoriel.ddd.infrastructure.mapper.reunion;

import com.tutoriel.ddd.core.reunion.domaine.entite.MeetingWaitlistMember;
import com.tutoriel.ddd.infrastructure.entite.reunion.MeetingWaitlistMemberTable;
import com.tutoriel.ddd.infrastructure.entite.reunion.MembreTable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MeetingWaitlistMemberMappeur {

    private final MeetingMappeur meetingMappeur;
//    private final MembreMappeur membreMappeur;

    public MeetingWaitlistMemberMappeur(MeetingMappeur meetingMappeur/*, MembreMappeur membreMappeur*/) {
        this.meetingMappeur = meetingMappeur;
//        this.membreMappeur = membreMappeur;
    }

    public MeetingWaitlistMemberTable waitlistMappeurVersTable(MeetingWaitlistMember meetingWaitlistMember) {

        MeetingWaitlistMemberTable meetingWaitlistMemberTable = new MeetingWaitlistMemberTable();

        meetingWaitlistMemberTable.setMeeting(meetingMappeur.meetingVersTable(meetingWaitlistMember.getMeeting()));

//        Set<MembreTable> membreTables = new HashSet<>();
//        meetingWaitlistMember.getMembres().forEach(membre -> {
//            membreTables.add(membreMappeur.membreVersTable(membre));
//        });
//        meetingWaitlistMemberTable.setMembers(membreTables);

        return meetingWaitlistMemberTable;

    }
}
