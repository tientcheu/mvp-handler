package org.tientcheu.model.home;

import org.tientcheu.framework.mvp.ModelAttribute;

public class House implements IHouse {

	private ModelAttribute<String> name = new ModelAttribute<String>(HouseProperties.NAME.name());
	private ModelAttribute<Kitchen> kitchen =  new ModelAttribute<Kitchen>(HouseProperties.KITCHEN.name());
	private ModelAttribute<Room> room = new ModelAttribute<Room>(HouseProperties.ROOM.name());
	private ModelAttribute<Door> door =  new ModelAttribute<Door>(HouseProperties.DOOR.name());
	private ModelAttribute<String> address = new ModelAttribute<String>(HouseProperties.ADDRESS.name());
	private ModelAttribute<Long> postalCode =  new ModelAttribute<Long>(HouseProperties.POSTAL_CODE.name());
	
	public House(String name){
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
	public IKitchen getKitchen() {
		return kitchen.get();
	}
	@Override
	public void setKitchen(Kitchen kitchen) {
		this.kitchen.set(kitchen);
	}
	@Override
	public IRoom getRoom() {
		return room.get();
	}
	@Override
	public void setRoom(Room room) {
		this.room.set(room);
	}
	@Override
	public IDoor getDoor() {
		return door.get();
	}
	@Override
	public void setDoor(Door door) {
		this.door.set(door);
	}
	@Override
	public IHouse setAddress(String address) {
		this.address.set(address);	
		return this;
	}
	@Override
	public String getAddress() {
		return this.address.get();
	}
	@Override
	public IHouse setPostalCode(Long postalCode) {
		this.postalCode.set(postalCode);
		return this;
	}	
	@Override
	public long getPostalCode() {
		return postalCode.get();
	}		
}