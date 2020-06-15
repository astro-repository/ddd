package com.tutoriel.ddd.infrastructure.mapper.reunion;

import com.tutoriel.ddd.core.reunion.domaine.entite.MeetingNotAttendee;
import com.tutoriel.ddd.infrastructure.entite.reunion.MeetingNotAttendeeTable;
import com.tutoriel.ddd.infrastructure.entite.reunion.MembreTable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MeetingNotAttendeeMappeur {

    private final MeetingMappeur meetingMappeur;
//    private final MembreMappeur membreMappeur;

    public MeetingNotAttendeeMappeur(MeetingMappeur meetingMappeur/*, MembreMappeur membreMappeur*/) {
        this.meetingMappeur = meetingMappeur;
//        this.membreMappeur = membreMappeur;
    }

    public MeetingNotAttendeeTable meetingNotAttendeeVersTable(MeetingNotAttendee meetingNotAttendee) {

        MeetingNotAttendeeTable meetingNotAttendeeTable = new MeetingNotAttendeeTable();
        meetingNotAttendeeTable.setMeeting(
                meetingMappeur.meetingVersTable(meetingNotAttendee.getMeeting())
        );

//        Set<MembreTable> membreTables = new HashSet<>();
//        meetingNotAttendee.getMembres().forEach(
//                membre -> {
//                    membreTables.add(
//                            membreMappeur.membreVersTable(membre)
//                    );
//                }
//        );
//        meetingNotAttendeeTable.setMembers(membreTables);

        return meetingNotAttendeeTable;

    }
}
