/**
 * 
 */
package org.tientcheu.framework.mvp;

import org.apache.commons.beanutils.BeanUtils;
import org.tientcheu.framework.mvp.api.IAttributeIdentifier;
import org.tientcheu.framework.mvp.api.IComponentVisitor;
import org.tientcheu.framework.mvp.api.IModelTrigger;
import org.tientcheu.framework.mvp.api.IModelValidator;
import org.tientcheu.framework.mvp.api.IPresenter;
import org.tientcheu.framework.mvp.api.IPresenterAttribute;

/**
 * PresenterAttribute is a concrete implementation of the IPresenterAttribute interface
 * They are used inside a Presenter to map a GUI component to a model's attribute.
 * They have some stuff regarding validation, side effects, set/retrieve data etc...
 * 
 * @see	IPresenterAttribute
 *  
 * @author Ben Tientcheu
 */
public class PresenterAttribute implements IPresenterAttribute {

	private String xpath;
	private IAttributeIdentifier attributeIdentifier;
	private IModelTrigger[] triggers;
	private IModelValidator modelValidator;
	private IComponentVisitor componentVisitor;
	private IComponentVisitor labelVisitor;
	private final IPresenter presenter;
	private String[] dependencies;

	@SuppressWarnings("rawtypes")
	public PresenterAttribute(IPresenter presenter){
		this.presenter = presenter;	
		presenter.registerAttribute(this);
	}
	
	/** 
	 * Set a value to the model's property
	 * 
	 * @param 	model	the model
	 * @param	value	the value to set
	 * @throws	Exception
	 */
	public void set(Object model, Object value) throws Exception {
		BeanUtils.setProperty(model, xpath, value);
	}

	/** 
	 * Get the value of the map property
	 * 
	 * @param 	model	the model
	 * @throws	Exception
	 */
	public Object get(Object model) throws Exception{
		return BeanUtils.getProperty(model, xpath);
	}

	/** 
	 * Get the unique ID of the model's attribute
	 */
	public IAttributeIdentifier getAttributeIdentifier() {
		return attributeIdentifier;
	}

	/** 
	 * Set the attribute identifier
	 *  
	 * @param 	attributeIdentifier	the identifier of the attribute
	 * 
	 * @see	IAttributeIdentifier
	 */
	public IPresenterAttribute setAttributeIdentifier(IAttributeIdentifier attributeIdentifier) {
		this.attributeIdentifier = attributeIdentifier;
		return this;
	}
	
	/** 
	 * Get the navigation path to the attribute through the model
	 */
	public String getXpath() {
		return xpath;
	}

	public IPresenterAttribute setXpath(String xpath) {
		this.xpath = xpath;
		return this;
	}
	
	/** 
	 * Get the triggers that are attached to the attribute
	 */
	public IModelTrigger[] getTriggers() {
		return triggers;
	}

	public IPresenterAttribute setTriggers(IModelTrigger[] triggers) {
		this.triggers = triggers;
		return this;
	}
	
	/** 
	 * Get the validation handler attached to the attribute
	 */
	public IModelValidator getValidator() {
		return this.modelValidator;
	}

	public IPresenterAttribute setValidator(IModelValidator modelValidator) {
		this.modelValidator = modelValidator;
		return this;
	}
	
	/** 
	 * Get the component in charge of the side effects on GUI's element attached to the model's attribute
	 */
	public IComponentVisitor getComponentVisitor() {
		return this.componentVisitor;
	}

	public IPresenterAttribute setComponentVisitor(IComponentVisitor componentVisitor) {
		this.componentVisitor = componentVisitor;
		return this;
	}
	
	/** 
	 * Get the component in charge of the side effects on label elements preceding the display of the model's attribute value
	 */
	public IComponentVisitor getLabelVisitor() {
		return this.labelVisitor;
	}

	public IPresenterAttribute setLabelVisitor(IComponentVisitor labelVisitor) {
		this.labelVisitor = labelVisitor;
		return this;
	}
	
	/** 
	 * Get the presenter holding the attribute
	 */
	public IPresenter getPresenter() {
		return this.presenter;
	}

	/** 
	 * Get the dependencies of the attribute.
	 * It importance would be questioned later
	 */
	public String[] getDependencies() {
		return this.dependencies;
	}

	public IPresenterAttribute setDependencies(String[] dependencies) {
		this.dependencies = dependencies;
		return this;
	}

}
