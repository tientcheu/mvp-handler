package org.tientcheu.model.home;

import org.tientcheu.framework.mvp.api.Identifiable;

public enum FreezerProperties implements Identifiable {
	
	NAME,
	KITCHEN;

	@Override
	public String getIdentifier() {
		return this.getClass().getName() + "." + this.name();
	}
	
	public FreezerProperties findByName(String name){
		for (FreezerProperties bp : FreezerProperties.values()){
			if (bp.name().equals(name)) return bp;
		}
		return null;
	}
}