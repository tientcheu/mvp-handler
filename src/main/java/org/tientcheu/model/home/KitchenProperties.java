package org.tientcheu.model.home;

import org.tientcheu.framework.mvp.api.Identifiable;

public enum KitchenProperties implements Identifiable {
	
	NAME,
	ROOM, FREEZER, HOUSE;

	@Override
	public String getIdentifier() {
		return this.getClass().getName() + "." + this.name();
	}
	
	public KitchenProperties findByName(String name){
		for (KitchenProperties bp : KitchenProperties.values()){
			if (bp.name().equals(name)) return bp;
		}
		return null;
	}
}