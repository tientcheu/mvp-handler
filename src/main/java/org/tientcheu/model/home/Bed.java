package org.tientcheu.model.home;

import org.tientcheu.framework.mvp.AbstractModel;
import org.tientcheu.framework.mvp.ModelAttribute;

public class Bed extends AbstractModel implements IBed {
	
	private ModelAttribute<String> name = new ModelAttribute<String>(BedProperties.NAME.name());
	private ModelAttribute<Room> room = new ModelAttribute<Room>(BedProperties.ROOM.name());
	
	public Bed(String name){
		this.name.set(name);	
	}
	@Override
	public String getName() {
		return name.get();
	}

	@Override
	public void setName(String name) {
		this.name.set(name);	
	}
	@Override
	public void setRoom(Room room) {
		this.room.set(room);		
	}
	
	@Override
	public String getID() {
		return getName();
	}		
}