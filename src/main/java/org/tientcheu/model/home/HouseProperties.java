package org.tientcheu.model.home;

import org.tientcheu.framework.mvp.api.Identifiable;

public enum HouseProperties implements Identifiable {
	
	NAME,
	ROOM, KITCHEN, POSTAL_CODE, ADDRESS, DOOR;

	@Override
	public String getIdentifier() {
		return this.getClass().getName() + "." + this.name();
	}
	
	public HouseProperties findByName(String name){
		for (HouseProperties bp : HouseProperties.values()){
			if (bp.name().equals(name)) return bp;
		}
		return null;
	}
}