package org.tientcheu.model.home;

import org.tientcheu.framework.mvp.AbstractModel;
import org.tientcheu.framework.mvp.ModelAttribute;

public class Door extends AbstractModel implements IDoor {
	
	private ModelAttribute<String> name = new ModelAttribute<String>(DoorProperties.NAME.name());
	
	public Door(String name){
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
	public String getID() {
		return getName();
	}	
}