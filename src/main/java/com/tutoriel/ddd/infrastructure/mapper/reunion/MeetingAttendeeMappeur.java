package com.tutoriel.ddd.infrastructure.mapper.reunion;

import com.tutoriel.ddd.core.reunion.domaine.entite.MeetingAttendee;
import com.tutoriel.ddd.infrastructure.entite.reunion.MeetingAttendeeTable;
import org.springframework.stereotype.Service;

@Service
public class MeetingAttendeeMappeur {

    private final MeetingMappeur meetingMappeur;

    public MeetingAttendeeMappeur(MeetingMappeur meetingMappeur) {
        this.meetingMappeur = meetingMappeur;
    }

    public MeetingAttendeeTable meetingAttendeeVersTable(MeetingAttendee meetingAttendee) {
        MeetingAttendeeTable meetingAttendeeTable = new MeetingAttendeeTable();
        meetingAttendeeTable.setMeeting(
                meetingMappeur.meetingVersTable(meetingAttendee.getMeeting())
        );
        return meetingAttendeeTable;
    }

    public void tableVersMeetingAttendee() {

    }
}
