package org.tientcheu.framework.mvp.api;

import java.beans.PropertyChangeListener;

public interface IModelListener extends PropertyChangeListener {
	void onDataChanged(Object model, String identifier, Object oldValue, Object newValue);
}
