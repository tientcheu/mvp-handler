package org.tientcheu.framework.mvp.api;

import java.util.List;

/**
 * A MaskTrigger is advised when changed on model element occured.
 * It main task is to indicated which properties layout/display are affected by the changes.
 * For example, given a passenger form. If the user indicate he did not need any insurance, the subform for capturing details
 * regarding insurance should be unavailable. It's the role of MaskTrigger to indicate which properties (identifiable) should be revisited
 *
 * In order words, maskTrigger hold/manage dependencies between properties
 * 
 * @author Ben Tientcheu
 */
@Deprecated
public interface IMaskTrigger {

    /**
     * Get the list of items (properties) to revisit when changed occurs on one of the model item 
     *
     * @param model  		the root model
     * @param identifier  	the model item (property) on which change occurs
     * @param oldValue  	the previous value of the model item
     * @param newValue  	the new value of the model item
     * @return 		  		the list of model item (properties) to revisit
     * 
     * @see					Identifiable
     */	
	List<Identifiable> onDataChanged(Object model, Identifiable identifier, Object oldValue, Object newValue);

}
