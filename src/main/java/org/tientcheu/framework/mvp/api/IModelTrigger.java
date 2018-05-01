package org.tientcheu.framework.mvp.api;

public interface IModelTrigger {

	void onChanged(Object model, String attributeIdentifier, Object oldValue, Object newValue);
	
}
