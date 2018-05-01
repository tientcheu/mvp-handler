package org.tientcheu.framework.mvp.api;

import org.tientcheu.framework.mvp.view.UIEvent;

public interface UIEventListener {

    /**
     * Execute a command/action given its name or identifier 
     * 
     * @see					ICommand
     */	
	void onEvent(String propertyCode, UIEvent uiEvent);
	
}
