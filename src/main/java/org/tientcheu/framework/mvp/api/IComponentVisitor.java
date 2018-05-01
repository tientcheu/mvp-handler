package org.tientcheu.framework.mvp.api;

import org.tientcheu.framework.mvp.view.IBindableComponent;

/**
 * An IComponentVisitor main goal is to visit UI component and apply some specific styling (color, layout, visibility...)
 *  
 * @author Ben Tientcheu
 * 
 * @see		IBindableComponent
 */
public interface IComponentVisitor {

    /**
     * visit the UI element (component) bound to a specific model item instance 
     * @param		cmp the component to visit
     */	
	void visit(IBindableComponent cmp);
	
}
