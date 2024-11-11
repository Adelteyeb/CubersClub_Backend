package com.CentreCulturel.demo.evenementscientifique;

import org.springframework.stereotype.Service;

import com.CentreCulturel.demo.evenement.Evenement;
import com.CentreCulturel.demo.evenement.EventRequest;
import com.CentreCulturel.demo.evenement.EventResponse;
@Service
public class ScientifiqueMapper {
	public Scientifique toscientifique(ScientifiqueRequest evntReq) {
		return Scientifique.builder()
				.id(evntReq.getId())
				.name(evntReq.getName())
				.description(evntReq.getDescription())
				.dateCreation(evntReq.getDateCreation())
				.theme(evntReq.getTheme())
				 .typeEvent(evntReq.getTypeEvent())
				.build();
	}
	public ScientifiqueResponse toscientifiqueDTO(Scientifique evnt) {
		return ScientifiqueResponse.builder()
				.id(evnt.getId())
				.name(evnt.getName())
				.description(evnt.getDescription())
				.dateCreation(evnt.getDateCreation())
				.theme(evnt.getTheme())
				.typeEvent(evnt.getTheme())
				.build();
	}
}
