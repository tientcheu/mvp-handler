package org.tientcheu.framework.mvp.api;

import org.tientcheu.framework.mvp.view.IBindableComponent;
import org.tientcheu.framework.mvp.view.ILabel;

/**
 * IViewControler the component that handle all invocation coming from view components
 * The presenter acts like a SAS between the View and the Model (T).
 *
 * @author Ben Tientcheu
 */
public interface IViewControler extends UIEventListener {	
	
    /**
     * Register a UI element (BindableComponent)to the presenter 
     * 
     * @see				IBindableComponent
     * @param component  the bindableComponent
     */
	void registerComponent(IBindableComponent component);
	
    /**
     * Register a label element to the presenter 
     *
     * @param label  the label to register
     */	
	void registerLabel(ILabel label);
	
    /**
     * Unregister a bindableComponent from the presenter 
     *
     * @param component  the component to unregister
     */	
	void unregisterComponent(IBindableComponent component);
	
    /**
     * Unregister a label from the presenter 
     *
     * @param label  the label to unregister
     */	
	void unregisterLabel(ILabel label);
	
    /**
     * Get a model value/element through its propertyCode (key identifier) 
     *
     * @param propertyCode  the unique identifier of the model element (attribut/property)
     */		
	Object getValue(String propertyCode);
	
    /**
     * Set the value of a model element 
     *
     * @param propertyCode  the unique identifier (reference) of the model element (attribut/property)
     * @param value  the new value to set
     */		
	void setValue(String propertyCode, Object value);		
	
	
    /**
     * Execute a command/action given its name or identifier 
     * 
     * @see					ICommand
     */	
	void execute(String commandName);
	
}
