package org.tientcheu.model.home;

import org.tientcheu.framework.mvp.api.Identifiable;

public enum DoorProperties implements Identifiable {
	
	NAME,
	ROOM;

	@Override
	public String getIdentifier() {
		return this.getClass().getName() + "." + this.name();
	}
	
	public DoorProperties findByName(String name){
		for (DoorProperties bp : DoorProperties.values()){
			if (bp.name().equals(name)) return bp;
		}
		return null;
	}
}