package com.tutoriel.ddd.infrastructure.mapper.reunion;

import com.tutoriel.ddd.core.reunion.domaine.entite.Meeting;
import com.tutoriel.ddd.infrastructure.entite.reunion.*;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MeetingMappeur {

    private final MeetingLocationMappeur meetingLocationMappeur;
//    private final MeetingAttendeeMappeur meetingAttendeeMappeur;
    private final MeetingGroupMappeur meetingGroupMappeur;
//    private final MeetingNotAttendeeMappeur meetingNotAttendeeMappeur;
//    private final MeetingWaitlistMemberMappeur meetingWaitlistMemberMappeur;

    public MeetingMappeur(MeetingLocationMappeur meetingLocationMappeur/*, MeetingAttendeeMappeur meetingAttendeeMappeur*/, MeetingGroupMappeur meetingGroupMappeur/*, MeetingNotAttendeeMappeur meetingNotAttendeeMappeur, MeetingWaitlistMemberMappeur meetingWaitlistMemberMappeur*/) {
        this.meetingLocationMappeur = meetingLocationMappeur;
//        this.meetingAttendeeMappeur = meetingAttendeeMappeur;
        this.meetingGroupMappeur = meetingGroupMappeur;
//        this.meetingNotAttendeeMappeur = meetingNotAttendeeMappeur;
//        this.meetingWaitlistMemberMappeur = meetingWaitlistMemberMappeur;
    }

    public MeetingTable meetingVersTable(Meeting meeting) {

        MeetingTable meetingTable = new MeetingTable();
        meetingTable.setLocation(
                meetingLocationMappeur.meetingLocationVersTable(
                        meeting.getLocation()
                )
        );

//        Set<MeetingAttendeeTable> meetingAttendeeTables = new HashSet<>();
//        meeting.getMeetingAttendeeList().forEach(meetingAttendee -> {
//            meetingAttendeeTables.add(
//                    meetingAttendeeMappeur.meetingAttendeeVersTable(meetingAttendee)
//            );
//        });
//        meetingTable.setMeetingAttendeeList(meetingAttendeeTables);

        meetingTable.setMeetingGroup(
                meetingGroupMappeur.meetingGroupVersTable(
                        meeting.getMeetingGroup()
                )
        );

//        Set<MeetingNotAttendeeTable> meetingNotAttendeeTables = new HashSet<>();
//        meeting.getMeetingNotAttendeeList().forEach(meetingNotAttendee -> {
//                    meetingNotAttendeeTables.add(
//                            meetingNotAttendeeMappeur.meetingNotAttendeeVersTable(
//                                    meetingNotAttendee
//                            )
//                    );
//                }
//        );
//        meetingTable.setMeetingNotAttendeeList(meetingNotAttendeeTables);

//        Set<MeetingWaitlistMemberTable> meetingWaitlistMemberTables = new HashSet<>();
//        meeting.getMeetingWaitlistList().forEach(meetingWaitlistMember -> {
//                    meetingWaitlistMemberTables.add(
//                            meetingWaitlistMemberMappeur.waitlistMappeurVersTable(
//                                    meetingWaitlistMember
//                            )
//                    );
//                }
//        );
//        meetingTable.setMeetingWaitlistList(meetingWaitlistMemberTables);

        return meetingTable;

    }
}
