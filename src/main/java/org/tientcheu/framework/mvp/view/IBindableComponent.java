package org.tientcheu.framework.mvp.view;

import org.tientcheu.framework.mvp.api.IComponentVisitor;
import org.tientcheu.framework.mvp.api.IViewControler;

/**
 * IBindableComponent aims to indicate that a component is bound to a model
 * A BindableComponent is an element of the UI that display business data.
 * this means a bindableComponent is attached to a particular attribute of the model
 *
 * @author Ben Tientcheu
 * 
 */
public interface IBindableComponent {
	
    /**
     * Set the presenter which is used as the man in the middle to access model layer 
     * The bindableComponent interact with the presenter for any purpose
     *
     * @param presenter  the presenter to set
     */
	void setPresenter(IViewControler presenter);
	
    /**
     * Set the keyPath/identifier used to link to UI element to a model element 
     * The identifier is used by the presenter/controller to retrieve the data on which the bindable component is bound
     *
     * @param identifier  the Identifiable to set
     */
	void setBoundIdentifier(String identifier);
	
    /**
     * Populate the model (through the presenter) with the componentValue 
     */
	void setValueToPresenter();
	
    /**
     * Refresh or Populate the UI element (BindableComponent) value with the model value 
     */	
	void refreshValue();
	
    /**
     * Apply visibility, color, fonts, layout rules to the component 
     */		
	void refreshMask();
	
    /**
     * Get the presenter
     * @return  IPresenter
     */	
	IViewControler getPresenter();
	
    /**
     * Get the value (display/input value) of the UI element
     * @return  Object
     */		
	Object getComponentValue();
	
    /**
     * Get the model value on which the UI element is bound
     * @return  Object
     */		
	Object getPresenterValue();
	
    /**
     * Get the identifier/keyPath that identify the model element on which the UI element is bound
     * @return  Identifiable
     */			
	String getBoundIdentifier();
	
    /**
     * Use to pass componentVisitor to the UI element in order to apply/update display items
     * @param  cmpVisitor the IComponentVisitor to accept
     */		
	void accept(IComponentVisitor cmpVisitor);
	
}
