package org.tientcheu.model.home;

public interface IHouse {

	String getName();

	void setName(String name);

	IKitchen getKitchen();

	void setKitchen(Kitchen kitchen);

	IRoom getRoom();

	void setRoom(Room room);

	IDoor getDoor();

	void setDoor(Door door);

	IHouse setAddress(String address);

	String getAddress();

	IHouse setPostalCode(Long postalCode);

	long getPostalCode();

}