package org.tientcheu.model.home;

import org.tientcheu.framework.mvp.ModelAttribute;

public class Room implements IRoom {
	
	private ModelAttribute<String> name = new ModelAttribute<String>(RoomProperties.NAME.name());
	private ModelAttribute<Bed> bed =  new ModelAttribute<Bed>(RoomProperties.BED.name());
	private ModelAttribute<House> house = new ModelAttribute<House>(RoomProperties.HOUSE.name());
	
	public Room(String name){
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
	public void setHouse(House house) {
		this.house.set(house);		
	}
	@Override
	public void setBed(Bed bed) {
		this.bed.set(bed);
	}
	@Override
	public IBed getBed() {
		return this.bed.get();		
	}		
}