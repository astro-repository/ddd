package com.tutoriel.ddd.infrastructure.mapper.reunion;

import com.tutoriel.ddd.core.reunion.domaine.entite.MeetingLocation;
import com.tutoriel.ddd.infrastructure.objetvaleur.reunion.MeetingLocationTable;
import org.springframework.stereotype.Service;

@Service
public class MeetingLocationMappeur {

    public MeetingLocationTable meetingLocationVersTable(MeetingLocation meetingLocation) {
        return new MeetingLocationTable(meetingLocation);
    }

    public MeetingLocation tableVersMeetingLocation(MeetingLocationTable meetingLocationTable) {
        return new MeetingLocation(meetingLocationTable.getLocalisation());
    }

}
