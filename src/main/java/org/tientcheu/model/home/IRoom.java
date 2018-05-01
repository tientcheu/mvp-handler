package org.tientcheu.model.home;

public interface IRoom {

	String getName();

	void setName(String name);

	void setHouse(House house);

	void setBed(Bed bed);

	IBed getBed();

}