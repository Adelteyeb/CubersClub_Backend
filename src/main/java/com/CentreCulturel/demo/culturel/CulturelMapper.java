package com.CentreCulturel.demo.culturel;

import org.springframework.stereotype.Service;
@Service
public class CulturelMapper {
	

		public Culturel toCulturel(CulturelRequest evntReq) {
			return Culturel.builder()
					.id(evntReq.getId())
					.name(evntReq.getName())
					.description(evntReq.getDescription())
					.theme(evntReq.getTheme())
					.dateCreation(evntReq.getDateCreation())
					.typeEvent(evntReq.getTypeEvent())
					.build();
		}
		public CulturelResponse toculturelDTO(Culturel evnt) {
			return CulturelResponse.builder()
					.id(evnt.getId())
					.name(evnt.getName())
					.description(evnt.getDescription())
					.dateCreation(evnt.getDateCreation())
					.theme(evnt.getTheme())
					.typeEvent(evnt.getTypeEvent())
					.build();
		}
}

