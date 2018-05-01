package org.tientcheu.framework.mvp.api;

/**
 * IModelValidator is an interface dedicate to mark/hold component item/property
 *  
 * @author Ben Tientcheu
 */
public interface IModelValidator {

	/**
	 * check if the attribute is editable
	 * 
	 * @param	model	The model holding the data
	 * @param	attributeIdentifier	the identifier of the attribute
	 * 
	 * @return	true if the attribute if editable
	 */
	boolean isAttributeEditable(IModel model, IAttributeIdentifier attributeIdentifier);
	
	/**
	 * check if the value is valid
	 * 
	 * @param	model	The model holding the data
	 * @param	attributeIdentifier	the identifier of the attribute
	 * @param	value	the value to set
	 * 
	 * @return	true if the value is valid/can be setted
	 */
	boolean isValueValid(IModel model, IAttributeIdentifier attributeIdentifier, Object value);
	
	/**
	 * validate the value
	 * 
	 * @param	model	The model holding the data
	 * @param	attributeIdentifier	the identifier of the attribute
	 * @param	value	the value to set
	 * 
	 * @return	a validation message. if null this means no error, the input is fine.
	 */
	IValidationMessage validate(IModel model, IAttributeIdentifier attributeIdentifier, Object value);

}
