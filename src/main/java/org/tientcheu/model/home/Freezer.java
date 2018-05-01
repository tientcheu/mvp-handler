package org.tientcheu.model.home;

import org.tientcheu.framework.mvp.AbstractModel;
import org.tientcheu.framework.mvp.ModelAttribute;

public class Freezer extends AbstractModel implements IFreezer{
	
	private ModelAttribute<String> name = new ModelAttribute<String>(FreezerProperties.NAME.name());
	private ModelAttribute<Kitchen> kitchen =  new ModelAttribute<Kitchen>(FreezerProperties.KITCHEN.name());
	
	public Freezer(String name){
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
	public void setKitchen(Kitchen kitchen) {
		this.kitchen.set(kitchen);
	}
	@Override
	public IKitchen getKitchen() {
		return this.kitchen.get();
	}	

	@Override
	public String getID() {
		return getName();
	}
}