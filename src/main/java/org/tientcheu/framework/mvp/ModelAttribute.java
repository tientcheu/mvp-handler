package org.tientcheu.framework.mvp;

import java.beans.PropertyChangeEvent;

import org.apache.commons.lang3.ObjectUtils;
import org.tientcheu.framework.mvp.api.IModel;
import org.tientcheu.framework.mvp.api.IModelAttribute;

public class ModelAttribute<T> implements IModelAttribute<T> {

	private T value = null;
	private IModel model;
	private final String propertyName;
	
	public ModelAttribute(String identifier){
		this.propertyName = identifier;
	}
	
	public ModelAttribute(String identifier, T value){
		this.propertyName = identifier;
		this.value = value;
	}
	
	@Override
	public T get() {
		return value;
	}

	@Override
	public void set(T value) {
		T oldValue = this.value;
		this.value = value;
		notifyChanged(value, oldValue);
	}

	private void notifyChanged(T value, T oldValue) {
		
		if (model == null || model.getPropertyChangeListener() == null) return;
				
		if (valueChanged(oldValue, value)){
			model.getPropertyChangeListener().propertyChange(new PropertyChangeEvent(model, propertyName, oldValue, value));
		}
		
	}

	private boolean valueChanged(Object oldValue, Object newValue) {
				
		if (oldValue ==  newValue) return false;
		
		if (oldValue == null || newValue == null) return true;
		
		return ObjectUtils.notEqual(oldValue, newValue);
		
	}

	@Override
	public IModel getModel() {
		return model;
	}

	@Override
	public void setModel(IModel model) {
		this.model = model;
	}
	
	@Override
	public String getPropertyName() {
		return propertyName;
	}
	
}
