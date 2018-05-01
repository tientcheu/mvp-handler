package org.tientcheu.framework.mvp.api;

/**
 * An identifiable is a tag to identify a component (model item, property or command)
 * 
 * @author Ben Tientcheu
 */
@Deprecated
public interface Identifiable {

    /**
     * Get the unique ID of the component/instance 
     *
     * @return 		  		the ID of the component
     */		
	String getIdentifier();
	
}
