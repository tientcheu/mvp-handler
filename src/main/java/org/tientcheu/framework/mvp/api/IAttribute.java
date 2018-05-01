package org.tientcheu.framework.mvp.api;

/**
 * IAttribute is an interface dedicate to mark/hold component item/property
 *  
 * @author Ben Tientcheu
 */
public interface IAttribute<T> {

    /**
     * Get the value of the attribute/property
     *
     * @return 		  		the value of the item/property
     */	
	T get();
	
    /**
     * Set the value of the attribute/property
     *
     */		
	void set(T value);
	
}
