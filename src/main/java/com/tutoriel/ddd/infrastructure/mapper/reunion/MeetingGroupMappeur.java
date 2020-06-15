package com.tutoriel.ddd.infrastructure.mapper.reunion;

import com.tutoriel.ddd.core.reunion.domaine.entite.MeetingGroup;
import com.tutoriel.ddd.infrastructure.entite.reunion.MeetingGroupTable;
import com.tutoriel.ddd.infrastructure.entite.reunion.MeetingTable;
import com.tutoriel.ddd.infrastructure.mapper.administration.MeetingGroupProposalMappeur;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MeetingGroupMappeur {

    private final MeetingGroupProposalMappeur meetingGroupProposalMappeur;
//    private final MeetingMappeur meetingMappeur;

    public MeetingGroupMappeur(MeetingGroupProposalMappeur meetingGroupProposalMappeur/*, MeetingMappeur meetingMappeur*/) {
        this.meetingGroupProposalMappeur = meetingGroupProposalMappeur;
//        this.meetingMappeur = meetingMappeur;
    }

    public MeetingGroupTable meetingGroupVersTable(MeetingGroup meetingGroup) {
        MeetingGroupTable meetingGroupTable = new MeetingGroupTable();

        meetingGroupTable.setMeetingGroupProposal(
                meetingGroupProposalMappeur.meetingGroupProposalVersTable(
                        meetingGroup.getMeetingGroupProposal()
                )
        );

//        Set<MeetingTable> meetingTables = new HashSet<>();
//        meetingGroup.getMeetings().forEach(meeting -> {
//            meetingTables.add(
//                    meetingMappeur.meetingVersTable(meeting)
//            );
//        });
//        meetingGroupTable.setMeetings(meetingTables);

        return meetingGroupTable;
    }
}
