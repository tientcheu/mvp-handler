package org.tientcheu.model.home;

public interface IFreezer {

	String getName();

	void setName(String name);

	void setKitchen(Kitchen kitchen);

	IKitchen getKitchen();

	String getID();

}