package org.tientcheu.framework.mvp;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.tientcheu.framework.mvp.api.ICommand;
import org.tientcheu.framework.mvp.api.IComponentVisitor;
import org.tientcheu.framework.mvp.api.IModelTrigger;
import org.tientcheu.framework.mvp.api.IPresenter;
import org.tientcheu.framework.mvp.api.IPresenterAttribute;
import org.tientcheu.framework.mvp.api.IPresenterCommand;
import org.tientcheu.framework.mvp.utils.ViewUtils;
import org.tientcheu.framework.mvp.view.IBindableComponent;
import org.tientcheu.framework.mvp.view.ILabel;
import org.tientcheu.framework.mvp.view.UIEvent;

public class Presenter<T, V> implements IPresenter<T, V> {
	
	private static final Logger LOGGER = Logger.getLogger(Presenter.class);
	
	private List<T> models = new ArrayList<T>();
	private T model;
	
	// TODO use a singleton instead or dependency injection
	private ViewUtils viewUtils = new ViewUtils();
	
	private final RegisteredComponentsHolder registeredComponentsHolder = new RegisteredComponentsHolder();
	private final RegisteredLabelsHolder registeredLabelsHolder = new RegisteredLabelsHolder();
	private final PresenterCommandHolder presenterCommandHolder = new PresenterCommandHolder();
	private final PresenterAttributeHolder presenterAttributeHolder = new PresenterAttributeHolder();

	private V view;		

	@Override
	public void onDataChanged(Object model, String identifier, Object oldValue,	Object newValue) {
		
		IPresenterAttribute presenterAttribute = getPresenterAttributeFor(identifier);
		if (presenterAttribute != null && presenterAttribute.getDependencies() != null){
			refreshMaskFor(presenterAttribute.getDependencies());
		} 
	}
	
	@Override
	public void registerAttribute(IPresenterAttribute presenterAttribute) {
		presenterAttributeHolder.add(presenterAttribute);				
	}
	
	@Override
	public void registerCommand(IPresenterCommand command) {
		presenterCommandHolder.add(command);				
	}
	
	private void refreshMaskFor(List<String> propertyToRefresh) {
		viewUtils.refreshMask(propertyToRefresh);		
	}

	private void refreshMaskFor(String[] dependencies) {
		refreshMaskFor(Arrays.asList(dependencies));	
	}

	@Override
	public void  registerComponent(IBindableComponent component) {
		
		if (component.getPresenter() != null && component.getPresenter() != this) {
			component.getPresenter().unregisterComponent(component);
		}
		
		component.setPresenter(this);
		registeredComponentsHolder.add(component);			

	}

	@Override
	public void registerLabel(ILabel label) {
		
		if (label.getPresenter() != null && label.getPresenter() != this) {
			label.getPresenter().unregisterLabel(label);
		}
		
		label.setPresenter(this);
		registeredLabelsHolder.add(label);	

	}

	@Override
	public void unregisterComponent(IBindableComponent component) {
		
		if (component.getPresenter() != this) return;
		
		component.setPresenter(null);
		registeredComponentsHolder.remove(component);
		
	}

	@Override
	public void unregisterLabel(ILabel label) {

		if (label.getPresenter() != this) return;
		
		label.setPresenter(null);
		registeredLabelsHolder.remove(label);
		
	}

	@Override
	public Object getValue(String propertyCode) {

		IPresenterAttribute presenterAttribute = getPresenterAttributeFor(propertyCode);
		try {
			return presenterAttribute != null ? presenterAttribute.get(model) : null;
		} catch (Exception e) {
			LOGGER.error("Error while retrieving value for " + propertyCode);
			return null;
		}
	}

	@Override
	public void setValue(String propertyCode, Object value) {

		IPresenterAttribute presenterAttribute = getPresenterAttributeFor(propertyCode);
		
		if (presenterAttribute != null) {
			
			Object oldValue = null;
			try {
				oldValue = presenterAttribute.get(model);
			} catch (Exception e) {
				LOGGER.error(String.format("Error while retrieving value for [%s]", propertyCode, e.getMessage()));
			}
			try {
				presenterAttribute.set(model, value);
			} catch (Exception e) {
				LOGGER.error(String.format("Error while setting value [property=%s, value=%s] ", propertyCode, value, e.getMessage()));
			}
			// launch defined trigger
			if (presenterAttribute.getTriggers() != null){
				for ( IModelTrigger  dataTrigger : presenterAttribute.getTriggers()){
					dataTrigger.onChanged(model, presenterAttribute.getAttributeIdentifier().getIdentifier(), oldValue, value);					
				}
			}
		} else {
			LOGGER.warn(String.format("unable to set value for an undefined property [property=%s, value=%s] ", propertyCode, value));
		}
		
	}

	@Override
	public void onEvent(String propertyCode, UIEvent uiEvent) {
		// TODO handle uiEvents
	}
		
	
	@Override
	public IPresenterAttribute getPresenterAttributeFor(String propertyCode) {
		return presenterAttributeHolder.get(propertyCode);
	}

	@Override
	public ICommand getPresenterCommandFor(String commandName) {
		return presenterCommandHolder.get(commandName);
	}

	@Override
	public IComponentVisitor getComponentVisitor(String propertyCode) {
		return getPresenterAttributeFor(propertyCode).getComponentVisitor();
	}

	@Override
	public IComponentVisitor getLabelVisitor(String propertyCode) {
		return getPresenterAttributeFor(propertyCode).getLabelVisitor();
	}

	@Override
	public List<IBindableComponent> getRegisteredComponents() {
		return registeredComponentsHolder.getAll();
	}

	@Override
	public List<ILabel> getRegisteredLabels() {
		return registeredLabelsHolder.getAllRegisteredLabels();		
	}

	@Override
	public List<IPresenterAttribute> getPresenterAttributes() {
		return presenterAttributeHolder.getAll();
	}

	@Override
	public List<ICommand> getPresenterCommands() {
		return presenterCommandHolder.getAll();
	}

	@Override
	public void execute(String commandName) {
		ICommand command = getPresenterCommandFor(commandName);
		try {
			command.execute();
		} catch (Exception e) {
			LOGGER.error("Error while executing the command : " + commandName, e);
		}

	}

	@Override
	public boolean isAttributeManaged(String propertyCode) {
		return getPresenterAttributeFor(propertyCode) != null;
	}
	
	@Override
	public boolean isCommandManaged(String commandName) {
		return getPresenterCommandFor(commandName) != null;
	}

	private class PresenterAttributeHolder  {

		private final Map<String, IPresenterAttribute> presenterAttributeMap = new HashMap<String, IPresenterAttribute>();
		private final List<IPresenterAttribute> presenterAttributes = new ArrayList<IPresenterAttribute>();
		
		public IPresenterAttribute get(String propertyCode) {
			return presenterAttributeMap.get(propertyCode);
		}

		public void add(IPresenterAttribute presenterAttribute) {
			if (presenterAttributeMap.get(presenterAttribute.getAttributeIdentifier().getIdentifier()) == null){
				presenterAttributeMap.put(presenterAttribute.getAttributeIdentifier().getIdentifier(), presenterAttribute);
				presenterAttributes.add(presenterAttribute);
			}			
		}

		public List<IPresenterAttribute> getAll() {
			return Collections.unmodifiableList(presenterAttributes);
		}	
		
	}
	
	private static class RegisteredComponentsHolder {
		
		private Map<String, List<IBindableComponent>> registeredComponentsMap = new HashMap<String, List<IBindableComponent>>();
		private List<IBindableComponent> registeredComponents = new ArrayList<IBindableComponent>();
		
		public void add(IBindableComponent component) {
			
			if (component == null || component.getBoundIdentifier() == null) return;
			
			synchronized (registeredComponentsMap) {
				if (registeredComponentsMap.get(component.getBoundIdentifier()) == null){
					registeredComponentsMap.put(component.getBoundIdentifier(), new ArrayList<IBindableComponent>());
				}
				
				registeredComponentsMap.get(component.getBoundIdentifier()).add(component);
				registeredComponents.add(component);				
			}

		}

		public void remove(IBindableComponent component) {

			if (component == null || component.getBoundIdentifier() == null) return;
			
			synchronized (registeredComponentsMap) {
				if (registeredComponentsMap.get(component.getBoundIdentifier()) != null) {
					registeredComponentsMap.get(component.getBoundIdentifier()).remove(component);
					registeredComponents.remove(component);	
				}			
			}
			
		}

		public List<IBindableComponent> getAll() {			
			return Collections.unmodifiableList(registeredComponents);
		}
				
	}
	
	private static class RegisteredLabelsHolder {
		
		private Map<String, List<ILabel>> registeredLabelsMap = new HashMap<String, List<ILabel>>();
		private List<ILabel> registeredLabels = new ArrayList<ILabel>();

		public void add(ILabel label) {
			
			synchronized (registeredLabelsMap) {
				if (registeredLabelsMap.get(label.getBoundIdentifier()) == null){
					registeredLabelsMap.put(label.getBoundIdentifier(), new ArrayList<ILabel>());
				}
				
				registeredLabelsMap.get(label.getBoundIdentifier()).add(label);
				registeredLabels.add(label);		
			}
			
		}

		public void remove(ILabel label) {
			
			if (label == null || label.getBoundIdentifier() == null) return;
			
			synchronized (registeredLabelsMap) {
				
				if (registeredLabelsMap.get(label.getBoundIdentifier()) != null) {
					registeredLabelsMap.get(label.getBoundIdentifier()).remove(label);
					registeredLabels.remove(label);	
				}			
			}
			
		}

		public List<ILabel> getAllRegisteredLabels() {
			return Collections.unmodifiableList(registeredLabels);			
		}
				
	}
	
	
	private static class PresenterCommandHolder {

		private final Map<String, ICommand> presenterCommandMap = new HashMap<String, ICommand>();
		private final List<ICommand> presenterCommands = new ArrayList<ICommand>();
		
		public ICommand get(String propertyCode) {
			return presenterCommandMap.get(propertyCode);
		}

		public void add(IPresenterCommand presenterCommand) {
			synchronized(presenterCommandMap){
				if (presenterCommandMap.get(presenterCommand.getIdentifier()) == null){
					presenterCommandMap.put(presenterCommand.getIdentifier(), presenterCommand);
					presenterCommands.add(presenterCommand);
				}				
			}			
		}

		public List<ICommand> getAll() {
			return Collections.unmodifiableList(presenterCommands);
		}	
		
	}

	@Override
	public T getModel() {
		return this.model;
	}

	@Override
	public void setModel(T model) {
		this.model = model;		
	}

	@Override
	public V getView() {
		return view;
	}

	@Override
	public void setView(V view) {
		this.view = view;		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		onDataChanged(evt.getSource(), evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
	}



}
