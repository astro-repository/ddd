package com.tutoriel.ddd.infrastructure.mapper.administration;

import com.tutoriel.ddd.core.administration.domaine.entite.MeetingGroupProposal;
import com.tutoriel.ddd.infrastructure.entite.administrators.MeetingGroupProposalTable;
import com.tutoriel.ddd.infrastructure.mapper.reunion.MeetingGroupMappeur;
import com.tutoriel.ddd.infrastructure.mapper.reunion.MeetingGroupProposalDecisionMappeur;
import com.tutoriel.ddd.infrastructure.mapper.reunion.MeetingGroupProposalStatusMappeur;
import com.tutoriel.ddd.infrastructure.mapper.reunion.MembreMappeur;
import org.springframework.stereotype.Service;

@Service
public class MeetingGroupProposalMappeur {

//    private final AdministrateurMappeur administrateurMappeur;
    private final MeetingGroupProposalDecisionMappeur decisionMappeur;
//    private final MeetingGroupMappeur meetingGroupMappeur;
//    private final MembreMappeur membreMappeur;
    private final MeetingGroupProposalStatusMappeur statusMappeur;

    public MeetingGroupProposalMappeur(/*AdministrateurMappeur administrateurMappeur,*/ MeetingGroupProposalDecisionMappeur decisionMappeur,/* MeetingGroupMappeur meetingGroupMappeur, MembreMappeur membreMappeur,*/ MeetingGroupProposalStatusMappeur statusMappeur) {
//        this.administrateurMappeur = administrateurMappeur;
        this.decisionMappeur = decisionMappeur;
//        this.meetingGroupMappeur = meetingGroupMappeur;
//        this.membreMappeur = membreMappeur;
        this.statusMappeur = statusMappeur;
    }

    public MeetingGroupProposalTable meetingGroupProposalVersTable(MeetingGroupProposal meetingGroupProposal) {

        MeetingGroupProposalTable meetingGroupProposalTable = new MeetingGroupProposalTable();

//        meetingGroupProposalTable.setAdministrateurTable(
//                administrateurMappeur.AdministrateurVersTable(
//                        meetingGroupProposal.getAdministrator()
//                )
//        );

        meetingGroupProposalTable.setDecision(
                decisionMappeur.decisionVersTable(meetingGroupProposal.getDecision())
        );

//        meetingGroupProposalTable.setMeetingGroup(
//                meetingGroupMappeur.meetingGroupVersTable(meetingGroupProposal.getMeetingGroup())
//        );

//        meetingGroupProposalTable.setMembre(
//                membreMappeur.membreVersTable(meetingGroupProposal.getMember())
//        );

        meetingGroupProposalTable.setStatus(
                statusMappeur.statusVersTable(meetingGroupProposal.getStatus())
        );

        return meetingGroupProposalTable;

    }
}
