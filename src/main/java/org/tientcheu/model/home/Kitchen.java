package org.tientcheu.model.home;

import org.tientcheu.framework.mvp.ModelAttribute;

public class Kitchen implements IKitchen {

	private ModelAttribute<String> name = new ModelAttribute<String>(KitchenProperties.NAME.name());
	private ModelAttribute<Freezer> freezer =  new ModelAttribute<Freezer>(KitchenProperties.FREEZER.name());
	private ModelAttribute<House> house = new ModelAttribute<House>(KitchenProperties.HOUSE.name());

	public Kitchen(String name){
		this.setName(name);			
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
	public void setFreezer(Freezer freezer) {
		this.freezer.set(freezer);		
	}
}