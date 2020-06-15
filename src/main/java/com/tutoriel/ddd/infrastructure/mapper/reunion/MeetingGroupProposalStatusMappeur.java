package com.tutoriel.ddd.infrastructure.mapper.reunion;

import com.tutoriel.ddd.core.administration.domaine.objetvaleur.MeetingGroupProposalStatus;
import com.tutoriel.ddd.infrastructure.objetvaleur.administrateur.MeetingGroupProposalStatusTable;
import org.springframework.stereotype.Service;

@Service
public class MeetingGroupProposalStatusMappeur {

    public MeetingGroupProposalStatusTable statusVersTable(MeetingGroupProposalStatus status) {
        return MeetingGroupProposalStatusTable.valueOf(status.getStatus());
    }

    public MeetingGroupProposalStatus tableVersStatus(MeetingGroupProposalStatusTable statusTable) {
        return MeetingGroupProposalStatus.valueOf(statusTable.getStatus());
    }

}
