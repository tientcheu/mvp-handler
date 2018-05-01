package org.tientcheu.framework.mvp.api;

import java.beans.PropertyChangeListener;

public interface IModel {
	
	/**
	 * Set the unique listener that will be notified when changes occur on the model.
	 * The appropriate listener for a model is of type <code> IPresenter </code>
	 * 
	 * @param PropertyChangeListener
	 */
	void setPropertyChangeListener(PropertyChangeListener modelListener);
	
	/**
	 * Get the unique listener attached to the model
	 * 
	 * @return the PropertyChangeListener
	 */
	PropertyChangeListener getPropertyChangeListener();
	
	/**
	 * Get the business or functionnal ID of the given model/instance.
	 * 
	 * @return the ID of the model
	 */
	String getID();

}
