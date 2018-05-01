package org.tientcheu.framework.mvp.api;

/**
 * IPresenterAttribute is used to act as an attribute manager
 * A presenter attribute acts as a facade (binder) to a model element.
 * a Presenter's attribute hold additional information regarding behaviour/layout management of the model/view attribute.
 * 
 * Each view component has to be linked or associated to a Presenter attribute in order to be populated with data.
 * in order words a presenter's attribute is used to setup binding
 *
 * @author Ben Tientcheu
 */
public interface IPresenterAttribute{

    /**
     * Set a value to the model attribute
     * 
     * @param model  the model
     * @param value  the value to set to the attribute of the model
     * @throws Exception 
     * 
     */
	void set(Object model, Object value) throws Exception;
	
    /**
     * Get the value of the attribute
     * 
     * @param model  the model on which to retrieve the value
     * @return the value of the attribute
     * @throws Exception 
     */	
	Object get(Object model) throws Exception;
	
    /**
     * Get the attribute identifier of the attribute
     * 
     * @return the attribute identifier
     * 
     * @see		IAttributeIdentifier
     */	
	IAttributeIdentifier getAttributeIdentifier();
	
    /**
     * Get the Xpath expression that's reference the attribute
     * 
     * @return the xpath of the attribute
     */		
	String getXpath();
	
    /**
     * Get the triggers that should be executed when changes occurs
     * 
     * @return the triggers
     * 
     * @see		IModelTrigger
     */		
	IModelTrigger[] getTriggers();
	
    /**
     * Get the validators that should be invoked before applying change on the attribute
     * 
     * @return the validator attach to the attribute
     * 
     * @see		IModelValidator
     */		
	IModelValidator getValidator();
	
    /**
     * Get the visitor that should be used to manage the style/layout of the view component linked to the attribute
     * 
     * @return the validators attach to the attribute
     * 
     * @see		IComponentVisitor
     */		
	IComponentVisitor getComponentVisitor();
	
    /**
     * Get the visitor that should be used to manage the style/layout of the label component that hold static description of the attribute
     * 
     * @return the visitor attach to the attribute
     * 
     * @see		IComponentVisitor
     */		
	IComponentVisitor getLabelVisitor();	
	
    /**
     * Get the presenter which act like the owner of the attribute
     * 
     * @return the presenter
     * 
     * @see		IPresenter
     */	
	IPresenter getPresenter();
	
    /**
     * Get the List of attribute that have dependency with the current attribute.
     * When a change occur to the attribute, the mask of its dependencies should be refreshed
     * 
     * @return the dependencies of the current attribute
     * 
     * @see		Identifiable
     */	
	String[] getDependencies();
	
}
