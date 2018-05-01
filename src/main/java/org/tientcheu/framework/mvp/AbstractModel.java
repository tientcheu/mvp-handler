package org.tientcheu.framework.mvp;

import java.beans.PropertyChangeListener;

import org.tientcheu.framework.mvp.api.IModel;

public abstract class AbstractModel implements IModel {
	
	private PropertyChangeListener modelListener;

	@Override
	public void setPropertyChangeListener(PropertyChangeListener modelListener) {
		this.modelListener = modelListener;
	}

	@Override
	public PropertyChangeListener getPropertyChangeListener() {
		return modelListener;
	}

}
