package org.tientcheu.model.home;

import org.tientcheu.framework.mvp.api.Identifiable;

public enum RoomProperties implements Identifiable {
	
	NAME,
	ROOM, BED, HOUSE;

	@Override
	public String getIdentifier() {
		return this.getClass().getName() + "." + this.name();
	}
	
	public RoomProperties findByName(String name){
		for (RoomProperties bp : RoomProperties.values()){
			if (bp.name().equals(name)) return bp;
		}
		return null;
	}
}