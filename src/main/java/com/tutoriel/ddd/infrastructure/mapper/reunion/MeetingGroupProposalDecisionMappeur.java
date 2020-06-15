package com.tutoriel.ddd.infrastructure.mapper.reunion;

import com.tutoriel.ddd.core.administration.domaine.objetvaleur.MeetingGroupProposalDecision;
import com.tutoriel.ddd.infrastructure.objetvaleur.administrateur.MeetingGroupProposalDecisionTable;
import org.springframework.stereotype.Service;

@Service
public class MeetingGroupProposalDecisionMappeur {

    public MeetingGroupProposalDecisionTable decisionVersTable(
            MeetingGroupProposalDecision decision) {

        return MeetingGroupProposalDecisionTable.valueOf(decision.getDecision());

    }

    public MeetingGroupProposalDecision tableVersDecision(
            MeetingGroupProposalDecisionTable decisionTable) {

        return MeetingGroupProposalDecision.valueOf(decisionTable.getDecisionTable());

    }
}
