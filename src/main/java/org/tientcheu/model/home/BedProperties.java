package org.tientcheu.model.home;

import org.tientcheu.framework.mvp.api.Identifiable;

public enum BedProperties implements Identifiable {
	
	NAME,
	ROOM;

	@Override
	public String getIdentifier() {
		return this.getClass().getName() + "." + this.name();
	}
	
	public BedProperties findByName(String name){
		for (BedProperties bp : BedProperties.values()){
			if (bp.name().equals(name)) return bp;
		}
		return null;
	}
}