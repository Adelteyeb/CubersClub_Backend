package com.CentreCulturel.demo.evenement;

import org.springframework.stereotype.Service;

@Service
public class EventMapper {
public Evenement toevenement(EventRequest evntReq) {
	return Evenement.builder()
			.name(evntReq.getName())
			.description(evntReq.getDescription())
			.dateCreation(evntReq.getDateCreation())
			.theme(evntReq.getTheme())
			.build();
}
public EventResponse toevenementDTO(Evenement evnt) {
	return EventResponse.builder()
			.name(evnt.getName())
			.description(evnt.getDescription())
			.dateCreation(evnt.getDateCreation())
			.theme(evnt.getTheme())
			.build();
}

}
