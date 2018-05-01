package org.tientcheu.framework.mvp.api;

import java.util.List;

import org.tientcheu.framework.mvp.view.IBindableComponent;
import org.tientcheu.framework.mvp.view.ILabel;

/**
 * IPresenter the interface that define a Presenter
 * A Presenter is the controler in MVC/MVP paradigm.
 * The presenter acts like a SAS between the View and the Model (T).
 *
 * @author Ben Tientcheu
 */
public interface IPresenter<T, V> extends IViewControler, IModelListener {	
	
	
    /**
     * Get the presenterAttribute associated to a given propertyCode 
     *
     * @param propertyCode  the propertyCode
     * @return 		  		the presenterAttribute attached to the given propertyCode
     */		
	IPresenterAttribute getPresenterAttributeFor(String propertyCode);
	
    /**
     * Get the command associated to a given commandIdentifier 
     *
     * @param commandName	the command identifier
     * @return 		  		the command associated to the given commandIdentifier
     */		
	ICommand getPresenterCommandFor(String commandName);
	
    /**
     * Get the component visitor associated to a given propertyCode 
     *
     * @param propertyCode	the property identifier
     * @return 		  		the component visitor associated to the given property identifier
     * 
     * @see					IComponentVisitor
     */		
	IComponentVisitor getComponentVisitor(String propertyCode);
	
    /**
     * Get the label visitor associated to a given propertyCode 
     *
     * @param propertyCode	the property identifier
     * @return 		  		the component visitor associated to the given property identifier
     * 
     * @see					IComponentVisitor
     */		
	IComponentVisitor getLabelVisitor(String propertyCode);
	
    /**
     * Get the list of registered UI components (bindableComponents) bound to model elements 
     *
     * @return 		  		the list of registered components
     * 
     * @see					IBindableComponent
     */			
	List<IBindableComponent> getRegisteredComponents();
	
    /**
     * Get the list of registered labels bound to model elements 
     *
     * @return 		  		the list of registered labels
     * 
     * @see					ILabel
     */		
	List<ILabel> getRegisteredLabels();
	
    /**
     * Get the list of presenterAttributes used to manage access to models 
     *
     * @return 		  		the list of presenter attributes
     * 
     * @see					IPresenterAttribute
     */		
	List<IPresenterAttribute> getPresenterAttributes();
	
    /**
     * Get the list of presenterCommands used to manage execution of commands/actions 
     *
     * @return 		  		the list of presenter commands
     * 
     * @see					ICommand
     */		
	List<ICommand> getPresenterCommands();
	
    /**
     * determine if a model identifier (propertycode) is managed/exposed by the presenter.
     * This is a convenient way to check if the getValue call will return a value 
     * 
     * @return 		<code>true</code> if the model element is managed/exposed
     */		
	boolean isAttributeManaged(String propertyCode);
	
    /**
     * determine if a command/action is managed/exposed by the presenter.
     * 
     * @return 		<code>true</code> if the command exist and is exposed
     */		
	boolean isCommandManaged(String commandName);
	
    /**
     * Get the root model attached to the presenter
     * 
     * @return 		the root model attached to the presenter
     * 
     */		
	T getModel();
	
    /**
     * Set the root model
     * 
     * @param		the root model to set
     * 
     */		
	void setModel(T model);
	
    /**
     * Get the view attached to the presenter
     * 
     * @return 		the view attached to the presenter
     * 
     */		
	V getView();
	
    /**
     * Set the view
     * 
     * @param		the view to set
     * 
     */		
	void setView(V view);

	void registerAttribute(IPresenterAttribute presenterAttribute);

	void registerCommand(IPresenterCommand command);	
	
}
