package org.tientcheu.framework.mvp.api;

/**
 * IAttributeIdentifier extends the purpose of identifying components.
 * it adds the ability to indicate a label, a hint, a type.
 * Theses could be usefull when dealing with such of component.
 * It will be easy to automatically display the label/hint associated
 *  
 * @author Ben Tientcheu
 */
public interface IAttributeIdentifier {

    /**
     * Get the unique ID of the component/instance 
     *
     * @return 		  		the ID of the component
     */		
	String getIdentifier();
	
    /**
     * Get the label of the attribute (model item)
     *
     * @return 		  		the label of the model item/property
     */		
	String getLabel();
	
    /**
     * Get the hint of the attribute (model item)
     *
     * @return 		  		the hint of the model item/property
     */		
	String getHint();
	
}
