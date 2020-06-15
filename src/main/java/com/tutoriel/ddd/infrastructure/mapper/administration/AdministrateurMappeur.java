package com.tutoriel.ddd.infrastructure.mapper.administration;

import com.tutoriel.ddd.core.administration.domaine.entite.Administrateur;
import com.tutoriel.ddd.infrastructure.entite.administrators.AdministrateurTable;
import com.tutoriel.ddd.infrastructure.entite.administrators.MeetingGroupProposalTable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdministrateurMappeur {

    private final MeetingGroupProposalMappeur meetingGroupProposalMappeur;

    public AdministrateurMappeur(MeetingGroupProposalMappeur meetingGroupProposalMappeur) {
        this.meetingGroupProposalMappeur = meetingGroupProposalMappeur;
    }

    public AdministrateurTable AdministrateurVersTable(Administrateur administrator) {

        AdministrateurTable administrateurTable = new AdministrateurTable();
        Set<MeetingGroupProposalTable> meetingGroupProposalTables = new HashSet<>();
        administrator.getMeetingGroupProposals().forEach(meetingGroupProposal -> {
                    meetingGroupProposalTables.add(
                            meetingGroupProposalMappeur.meetingGroupProposalVersTable(meetingGroupProposal));
        });
        administrateurTable.setMeetingGroupProposalTables(meetingGroupProposalTables);

        return administrateurTable;

    }

}
